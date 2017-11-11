package com.enble.model;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class Person {
    private String name;
    private String institude;
    private String classNumber;

    public Person(String name, String institude, String classNumber) {
        this.name = name;
        this.institude = institude;
        this.classNumber = classNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstitude(String institude) {
        this.institude = institude;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public String getInstitude() {
        return institude;
    }

    public String getClassNumber() {
        return classNumber;
    }
}
