package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping
    public String testController(@RequestParam(defaultValue =
            "test.@RequestParam Jest to napis przekazany jako parametr do controllera") String test,
                                 Model model){
    model.addAttribute("test", test);
    return "test";
}
}
