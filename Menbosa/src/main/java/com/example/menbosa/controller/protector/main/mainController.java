package com.example.menbosa.controller.protector.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/alheum")
public class mainController {

//    @GetMapping
//    public String main() {
//        return "/basic/division";
//    }

    @GetMapping
    public String main(@SessionAttribute(value="proMemNum", required = false) Long proMemNum) {
        return proMemNum == null ? "/basic/division" : "/protector/protectorMain-mainNonMember";
    }

    @GetMapping("/introduce")
    public String introduce() {
        return "/protector/protectorIntroduce";
    }

    @GetMapping("/recommend")
    public String recommend() {
        return "/protector/protectorRecommend-hospital";
    }

    @GetMapping("/recommend/sanatorium")
    public String recommendSanatorium() {
        return "/protector/protectorRecommend-sanatorium";
    }

    @GetMapping("/recommend/welfare")
    public String recommendWelfare() {
        return "/protector/protectorRecommend-welfare";
    }


}
