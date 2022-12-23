package seunghee.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")    //실행되는 첫번째 화면을 의미함 "/"
    public String Home(){
        return "home";
    }

}
