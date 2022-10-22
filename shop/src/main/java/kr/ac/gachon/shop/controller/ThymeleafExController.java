package kr.ac.gachon.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafExController {
    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        //http://localhost:8080/thymeleaf/ex01
        model.addAttribute("data", "타임리프 예제 입니다.");
        return "thymeleafEx/thymeleafEx01";
    }
}