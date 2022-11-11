package com.vuanhvu.blog.controller;

import com.vuanhvu.blog.auth.AuthenticationSystem;
import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/comment")
    public String submitForm(@ModelAttribute("comment") Comment comment, HttpServletRequest request) {

        if (!AuthenticationSystem.isLogged()) {
            String referrer = request.getHeader("Referer");
            request.getSession().setAttribute("url_prior_login", referrer);
            return "login";
        }

        HttpSession session = request.getSession();

        comment.setUserId(Integer.parseInt((String) session.getAttribute("userId")));
        comment.setCreateDatetime(new Date());
        comment.setStatus(Constants.ACTIVE_STATUS);
        commentService.saveComment(comment);

        return "redirect:" + request.getHeader("Referer");

    }

}
