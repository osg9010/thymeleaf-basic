package hello.thymeleaf.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("/text-basic")
    public String textBasic(Model model){
        model.addAttribute("data","Hello Spring");

        return "basic/text-basic";
    }
    @GetMapping("/text-unescaped")
    public String textEscaped(Model model){
        model.addAttribute("data","Hello <b>Spring</b>");

        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model){
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        ArrayList<User> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);
        HashMap<String, User> map = new HashMap<String, User>();
        map.put(userA.getUsername(),userA);
        map.put(userB.getUsername(),userB);

        model.addAttribute("user",userA);
        model.addAttribute("users",list);
        model.addAttribute("userMap",map);

        return "basic/variable";
    }

    @Data
    @AllArgsConstructor
    static class User{
        private String username;
        private int age;

    }
}
