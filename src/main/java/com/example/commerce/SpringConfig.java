package com.example.commerce;


import com.example.commerce.controller.User;
import com.example.commerce.repository.*;
import com.example.commerce.service.AlertService;
import com.example.commerce.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    private DataSource dataSource;

    private EntityManager em;
    //@Autowired
    //public SpringConfig(DataSource dataSource){
    //    this.dataSource = dataSource;
    //}

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    @Bean
    public AlertService alertService(){ return new AlertService(new AlertRepository(em)); }

    @Bean
    public String String(){ return new String(new String()); }

    @Bean
    public JpaMemberRepository jpaMemberRepository(){return new JpaMemberRepository(em);}
    @Bean
    public User user(){return new User();}

}
