package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "boy")
public class BoyProperties {

    @Value("${Test}")
    public String ch;


    private int score;

    private int age;

    public int getScore(){
        return score;
    }

    public void setScore(int _score){
        score=_score;
    }
}
