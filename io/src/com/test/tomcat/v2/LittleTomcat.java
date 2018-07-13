package com.test.tomcat.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * https://blog.csdn.net/u014795347/article/details/52328221
 */
public class LittleTomcat {
    /**
     * 容器主方法
     * @param args
     * @throws InstantiationException
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws InstantiationException, IOException {
        System.out.println("little_tomcat_is_running!");
        try {
            ServerSocket serverSocket = new ServerSocket(8082);
            while (true) {
                //服务器每接受一次请求，创建一个socket对象
                Socket socket = serverSocket.accept();
                BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = bReader.readLine();
                if (!(null==line)) {
                    ClintRequestBean requestBean = new ClintRequestBean(line);
                    System.out.println("客户端请求："+requestBean.toReadString());
                    System.out.println("请求参数[路径]："+requestBean.getRequestParm().get("path"));
                    System.out.println("请求参数[参数表]："+requestBean.getRequestParm().get("attrs"));
                    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                    try {
                        classLoader.loadClass("com.test.tomcat.v2.ExClass");
                        System.out.println("动态加载ExClass类--成功");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("动态加载ExClass类--失败");
                    }
                    Class<?> exClass = null;
                    try {
                        exClass = Class.forName("com.test.tomcat.v2.ExClass");
                        System.out.println("动态初始化ExClass类--成功");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("动态初始化ExClass类--失败");
                    }
                    Method method;
                    try {
                        method = exClass.getMethod("test", null);
                        System.out.println("得到ExClass对象的"+method.getName()+"方法");
                        try {
                            System.out.println("执行ExClass对象的"+method.getName()+"方法");
                            method.invoke(exClass.newInstance(), null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
                bReader.close();
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
