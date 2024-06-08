package com.example.menbosa.controller.protector.main;

import com.example.menbosa.dto.protector.communicate.MainListDto;
import com.example.menbosa.service.protector.communicate.CommunicateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/alheum")
public class mainController {

    private final CommunicateService communicateService;

    public mainController(CommunicateService communicateService) {
        this.communicateService = communicateService;
    }
//    @GetMapping
//    public String main() {
//        return "/basic/division";
//    }

    @GetMapping
    public String main(@SessionAttribute(value="proMemNum", required = false) Long proMemNum, Model model) {
        List<MainListDto> mainList = communicateService.findAll();
        model.addAttribute("mainList", mainList);

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
