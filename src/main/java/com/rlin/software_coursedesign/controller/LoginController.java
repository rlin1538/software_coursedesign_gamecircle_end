package com.rlin.software_coursedesign.controller;

import com.rlin.software_coursedesign.pojo.User;
import com.rlin.software_coursedesign.result.Result;
import com.rlin.software_coursedesign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUserName();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getUserPassword());
        if (null == user) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public Result register(@RequestBody User requestUser) {
        String username = requestUser.getUserName();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getUserPassword());
        if (null == user) {
            User newUser = new User();
            newUser.setUserName(requestUser.getUserName());
            newUser.setUserPhoneNumber(requestUser.getUserPhoneNumber());
            newUser.setUserPassword(requestUser.getUserPassword());
            newUser.setUserState(false);
            userService.add(newUser);
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping(value = "/api/change")
    @ResponseBody
    public Result changeInfo(@RequestBody User requestUser) {
        String username = requestUser.getUserName();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.getByName(username);
        if (null != user) {
            User newUser = new User();
            newUser.setUserID(requestUser.getUserID());
            newUser.setUserName(requestUser.getUserName());
            newUser.setUserPhoneNumber(requestUser.getUserPhoneNumber());
            newUser.setUserPassword(requestUser.getUserPassword());
            newUser.setUserState(false);
            userService.change(newUser);
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}
