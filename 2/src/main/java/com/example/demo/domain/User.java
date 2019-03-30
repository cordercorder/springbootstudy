package com.example.demo.domain;

public class User {
    private int id;
    private String username;
    private String password;
    private String content;
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getContent(){
        return content;
    }
    public void setId(int _id){
        id=_id;
    }
    public void setUsername(String _username){
        username=_username;
    }
    public void setPassword(String _password){
        password=_password;
    }
    public void setContent(String _content){
        content=_content;
    }
}
