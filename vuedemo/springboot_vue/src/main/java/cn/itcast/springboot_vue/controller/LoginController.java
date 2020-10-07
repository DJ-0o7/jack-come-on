package cn.itcast.springboot_vue.controller;

import cn.itcast.springboot_vue.domain.Result;
import cn.itcast.springboot_vue.domain.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if(!Objects.equals("admin",username) || !Objects.equals("123456",requestUser.getPassword())){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else
            return new Result(200);
    }
}
