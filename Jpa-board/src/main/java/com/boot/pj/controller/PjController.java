package com.boot.pj.controller;

import com.boot.pj.dto.ArticleFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PjController {

    @GetMapping("/")
    public String index(){
        return "greetings";
    }


}
