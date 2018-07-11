package com.test.serializable;

import java.io.Serializable;

public class Person implements Serializable
{
    int age;
    String address;
    double height;
    public Person(int age, String address, double height)
    {
        this.age = age;
        this.address = address;
        this.height = height;
    }
}