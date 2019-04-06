package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    /*
    查询所有女生列表
     */

    @Autowired GirlService girlService;

    @GetMapping(value = "/girl")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }
    /*
    添加一个女生
     */
    @PostMapping(value = "/girl")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") int age){
        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") int id){
        return girlRepository.findById(id).orElse(null);
    }

    //更新
    @PutMapping(value = "/girl/{id}")
    public void girlUpdate(@PathVariable("id") int id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") int age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setAge(age);
        girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") int id){
        girlRepository.deleteById(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") int age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girl/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
