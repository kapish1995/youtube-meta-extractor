package com.YouTubeTools.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }


    @GetMapping("/video-details")
    public String videoDetails(){
        return "video-details";
    }


}
