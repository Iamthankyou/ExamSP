package com.codegym.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
;
    @RequestMapping("/")
    public String direct() {

        return "redirect:/promotions";
    }

}
