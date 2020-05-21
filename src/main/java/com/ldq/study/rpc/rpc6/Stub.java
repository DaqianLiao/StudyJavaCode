package com.ldq.study.rpc.rpc6;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 封装了底层调用server端服务的过程，通过动态代理实现
 * 通过传递具体实现类的类名和接口类名，就可以在服务端通过反射加载该类
 *
 */
public class Stub {

    public static Object getStub(Class aClass, Class interfaceClazz){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 8888);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);

                String className = aClass.getName();
//                获取对应的方法名
                String name = method.getName();
//                由于有重载的情况存在，所以需要判断方法名和方法参数类型
                Class<?>[] parameterTypes = method.getParameterTypes();

                oos.writeUTF(className);
                oos.writeUTF(name);
                oos.writeObject(parameterTypes);
                oos.writeObject(args);
                oos.flush();

                Object object = ois.readObject();

                oos.close();
                ois.close();
                socket.close();
                return object;
            }
        };
        /**
         * 第一个参数是接口类的加载器
         * 第二个参数是接口类
         * 第三个参数是Handler
         */
        Object in = Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{interfaceClazz}, handler);
        return in;
    }

}
