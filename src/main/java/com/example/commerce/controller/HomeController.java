package com.example.commerce.controller;


import com.example.commerce.domain.Alert;
import com.example.commerce.domain.Member;
import com.example.commerce.domain.UserAppId;
import com.example.commerce.service.AlertService;
import com.example.commerce.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// S.O.L.I.D design principles
// SRP, OCP, LSP, ISP, DIP
// JPA,
@Controller
public class HomeController {

    private final MemberService memberService;
    private final AlertService alertService;
    private User users;
    private String Employee;

    @Autowired
    public HomeController(AlertService alertService, User users, MemberService memberService, String Employee){
        this.alertService = alertService;
        this.users = users;
        this.memberService = memberService;
        this.Employee = Employee;
    }


    @GetMapping("/")
    public String home(){
        return "Login";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/popups")
    public String popups(){
        return "pop_ups_page";
    }
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";}


    @PostMapping("/alert")
    public String login(User user, Model model){

        System.out.println("--------------------");
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println("--------------------");


        try{
            memberService.findByUser(user.getName(),user.getPassword());
            Employee = user.getName();
        }catch (EmployeeNotFoundException e){
            System.out.println("Not found");
        }catch(IndexOutOfBoundsException e){
            System.out.println(e);
            return "LoginError";
        }
        Member member = memberService.findByName(user.getName());
        user.setId(member.getId());

        List<Alert> alerts = null;

        String userPrivilege = memberService.findUserPrivilege(user.getId());
        System.out.println(userPrivilege);
        users = user;


        if (userPrivilege.equals("admin")) {
            alerts =  alertService.findAlerts();

            model.addAttribute("alerts", alerts);
            model.addAttribute("username", Employee);

            return "admin";
        } else {
            List<UserAppId> appids = memberService.findAppId(member.getId());

            for (int i = 0; i < appids.size(); i++) {
                System.out.println(appids.get(i).getAppId());
            }

            List<Alert> testalerts = null;

//            for (int i = 0; i < appids.size(); i++) {
//                testalerts = alertService.findAlertByAppId(appids.get(i).getAppId());
//                for (int j = 0; j < testalerts.size(); j++) {
//                    alerts.add(testalerts.get(j));
//                }
//            }

            alerts = alertService.findAlertByAppId(appids.get(0).getAppId());

            model.addAttribute("alerts", alerts);
            model.addAttribute("username", Employee);

            return "alert";
        }

    }

    @GetMapping("/getalert")
    public String getAlert( Model model){
        List<Alert> alerts;
        String userPrivilege = memberService.findUserPrivilege(users.getId());
        if (userPrivilege.equals("admin")) {
            alerts =  alertService.findAlerts();

            model.addAttribute("alerts", alerts);
            model.addAttribute("username", Employee);

            return "admin";
        } else {
            List<UserAppId> appids = memberService.findAppId(users.getId());

            for (int i = 0; i < appids.size(); i++) {
                System.out.println(appids.get(i).getAppId());
            }

            alerts = alertService.findAlertByAppId(appids.get(0).getAppId());

            model.addAttribute("alerts", alerts);
            model.addAttribute("username", Employee);

            return "alert";
        }


    }



    @PostMapping("/alertMsg")
    public String alert(@RequestBody AlertForm form){

        Alert alert = new Alert();
        alert.setTimestamp(form.getTimestamp());
        alert.setHostname(form.getHostname());
        alert.setAppid(form.getAppid());
        alert.setFile(form.getFile());
        alert.setChangeagenet(form.getChangeagent());
        alert.setChangeprocess(form.getChangeprocess());

        alertService.join(alert);

        return "alert";
    }



    @PostMapping("/changeStatus")
    public String changeStatus(@RequestParam String id) {

        System.out.println("--------------------");
        System.out.println(id);

        alertService.updateStatus( Long.parseLong(id));

        return  "redirect:/getalert";
    }
}
