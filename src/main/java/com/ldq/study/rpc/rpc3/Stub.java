package com.ldq.study.rpc.rpc3;

import com.ldq.study.rpc.common.User;
import com.ldq.study.rpc.common.UserService;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 封装了底层调用server端服务的过程，通过动态代理实现
 * 但是invoke的方法中只实现了一个逻辑，也就是无论UserServiceImpl中其他的所有方法，
 * 都会执行相同逻辑
 */
public class Stub {

    public static UserService getStub(){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 8888);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(123);

                socket.getOutputStream().write(baos.toByteArray());
                socket.getOutputStream().flush();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);


                dos.close();
                dis.close();
                socket.close();
                return user;
            }
        };
        Object in = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, handler);

        return (UserService) in;
    }

}
