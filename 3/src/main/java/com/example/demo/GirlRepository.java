package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //扩展接口，通过年龄来查询

    public List<Girl> findByAge(int age);//方法名不能乱写，一定要按照要求写

}
