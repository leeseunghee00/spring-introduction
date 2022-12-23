package seunghee.studyspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http에서 body부에 이 데이터를 직접 넣어준다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring
    }
}