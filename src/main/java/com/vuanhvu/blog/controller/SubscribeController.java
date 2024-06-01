package com.vuanhvu.blog.controller;

//import com.vuanhvu.blog.auth.AuthenticationSystem;
import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.Subscribe;
import com.vuanhvu.blog.service.CommentServiceImpl;
import com.vuanhvu.blog.service.SubscribeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class SubscribeController {

    @Autowired
    private SubscribeServiceImpl subscribeService;

    @PostMapping("/subscribe/{email}")
    public String submitForm(@PathVariable String email, HttpServletRequest request) {

        Subscribe subscribe = new Subscribe();
        subscribe.setEmail(email);
        subscribe.setCreateDatetime(new Date());
        subscribe.setStatus(Constants.ACTIVE_STATUS);
        subscribeService.saveSubscribe(subscribe);

        return "redirect:" + request.getHeader("Referer");

    }

}
