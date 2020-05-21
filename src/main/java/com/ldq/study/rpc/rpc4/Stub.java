package com.ldq.study.rpc.rpc4;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 封装了底层调用server端服务的过程，通过动态代理实现
 * invoke方法中根据传递的方法名字，可以调用UserService类的所有返回User方法的支持
 *
 * 但是只能支持User中id,name的序列化结果
 * 如果User中新增字段需要序列化，则报错
 *
 */
public class Stub {

    public static Object getStub(Class className){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 8888);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(out);


//                获取对应的方法名
                String name = method.getName();
//                由于有重载的情况存在，所以需要判断方法名和方法参数类型
                Class<?>[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(name);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                DataInputStream dis = new DataInputStream(in);

                int id = dis.readInt();
                String name1 = dis.readUTF();
                User user = new User(id, name1);
                oos.close();
                dis.close();
                socket.close();
                return user;
            }
        };
        Object in = Proxy.newProxyInstance(className.getClassLoader(), new Class[]{className}, handler);

        return (UserService) in;
    }

}
