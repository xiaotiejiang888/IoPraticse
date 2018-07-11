package com.test.serializable;

import java.io.*;

/**
 * 1、静态变量不会被序列化。
 *
 * 2、子类序列化时：
 *
 *      如果父类没有实现Serializable接口，没有提供默认构造函数，那么子类的序列化会出错；
 *
 *      如果父类没有实现Serializable接口，提供了默认的构造函数，那么子类可以序列化，父类的成员变量不会被序列化。
 *
 *      如果父类实现了Serializable接口，则父类和子类都可以序列化。
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/data.txt"));
        /**
         * 对象序列化之后，写入的是一个二进制文件，所有打开乱码是正常现象，
         * 不过透过乱码我们还是可以看到文件中存储的就是我们创建的那个对象那个。
         */
        oos.writeObject(new Person(25,"China",180));
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "d:/data.txt"));
        Person p1 = (Person) ois.readObject();
        System.out.println("age=" + p1.age + ";address=" + p1.address
                + ";height=" + p1.height);
        ois.close();
    }
}
