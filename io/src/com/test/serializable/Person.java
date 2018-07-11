package com.test.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * http://www.cnblogs.com/dongguacai/p/5721056.html
 */
public class Person implements Serializable
{
    int age;
    /**
     * 使用tranisent修饰的变量，在经过序列化和反序列化之后，JAVA对象会丢失该实例变量值。
     */
//    transient String address;
    String address;
    double height;
    public Person(int age, String address, double height)
    {
        this.age = age;
        this.address = address;
        this.height = height;
    }

    //JAVA BEAN自定义的writeObject方法
    private void writeObject(ObjectOutputStream out) throws IOException
    {
        System.out.println("writeObejct ------");
        out.writeInt(age);
        out.writeObject(new StringBuffer(address).reverse());
        out.writeDouble(height);
    }

    /**
     * JAVA提供了一种自定义序列化机制。这样程序就可以自己来控制如何序列化各实例变量，甚至不序列化实例变量。
     *
     * 在序列化和反序列化过程中需要特殊处理的类应该提供如下的方法，这些方法用于实现自定义的序列化。
     *
     * writeObject（）
     *
     * readObject（）
     *
     * 这两个方法并不属于任何的类和接口，只要在要序列化的类中提供这两个方法，就会在序列化机制中自动被调用。
     *
     * 其中writeObject方法用于写入特定类的实例状态，以便相应的readObject方法可以恢复它。
     * 通过重写该方法，程序员可以获取对序列化的控制，可以自主决定可以哪些实例变量需要序列化，怎样序列化。
     * 该方法调用out.defaultWriteObject来保存JAVA对象的实例变量，从而可以实现序列化java对象状态的目的。
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        System.out.println("readObject ------");
        this.age = in.readInt();
        this.address = ((StringBuffer)in.readObject()).reverse().toString();
        this.height = in.readDouble();
    }
}