package com.example.roaddamage1;

import com.example.roaddamage1.observerModel.Inform;
import com.example.roaddamage1.observerModel.ob1;
import com.example.roaddamage1.service.Action;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Proxy;
import java.util.Observer;

@SpringBootApplication
@MapperScan({"com.**.mapper"})
public class RoadDamage1Application {

    public static void main(String[] args) {
        SpringApplication.run(RoadDamage1Application.class, args);

    }
}
