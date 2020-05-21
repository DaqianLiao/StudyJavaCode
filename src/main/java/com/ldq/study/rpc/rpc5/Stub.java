package com.ldq.study.rpc.rpc5;

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
 */
public class Stub {

    public static Object getStub(){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 8888);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);

//                获取对应的方法名
                String name = method.getName();
//                由于有重载的情况存在，所以需要判断方法名和方法参数类型
                Class<?>[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(name);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                Object user = ois.readObject();


                oos.close();
                ois.close();
                socket.close();
                return user;
            }
        };
        Object in = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, handler);

        return in;
    }

}
