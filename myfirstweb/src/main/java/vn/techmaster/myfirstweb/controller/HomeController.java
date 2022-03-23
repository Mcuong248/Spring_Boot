package vn.techmaster.myfirstweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping(value = "/hi")
    @ResponseBody
    public String hello(){
         return "Hello World";
    }
}
