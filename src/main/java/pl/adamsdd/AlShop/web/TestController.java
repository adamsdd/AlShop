package pl.adamsdd.AlShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.adamsdd.AlShop.domain.alcohol.Alcohol;

@Controller
public class TestController {

    @GetMapping("/")
    public String testGet(Model model) {
        return "welcome";
    }

    @GetMapping(value = "/item", produces="application/json")
    @ResponseBody
    public Alcohol getItem() {
        return new Alcohol(1L, "Browar", "opis", new byte[0]);
    }
}
