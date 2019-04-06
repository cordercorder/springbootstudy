package com.example.demo;



//和数据库对应的一个类,属性值会映射成数据库的字段

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Girl {

    @Id
    @GeneratedValue//自增
    private int id;

    private String cupSize;

    private int age;

    public Girl(){//一个无参的构造函数

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
