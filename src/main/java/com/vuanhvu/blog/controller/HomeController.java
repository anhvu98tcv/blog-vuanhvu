package com.vuanhvu.blog.controller;

import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.service.PostServiceImpl;
import com.vuanhvu.blog.service.UserServiceImpl;
import com.vuanhvu.blog.vo.RightMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String index(Model model) throws Exception {

        List<Post> postList = postService.getAllPost();
        model.addAttribute("postList", postList);

        RightMenu dataRightMenu = postService.getDataRightMenu();
        model.addAttribute("categoryCounts", dataRightMenu.getCategoryCount());
        model.addAttribute("listPopular", dataRightMenu.getListPopularPost());

        return "index";

    }

    @GetMapping("/engineer")
    public String engineer(Model model) {

        List<Post> postHtmlList = postService.getPostByCategory(Constants.CATEGORY_ENGINEER);
        model.addAttribute("postHtmlList", postHtmlList);

        return "engineer";
    }

    @GetMapping("/java")
    public String java(Model model) {

        List<Post> postList = postService.getPostByCategory(Constants.CATEGORY_JAVA);
        model.addAttribute("postList", postList);

        return "java";
    }

    @GetMapping("/travel")
    public String travel(Model model) {

        List<Post> postList = postService.getPostByCategory(Constants.CATEGORY_TRAVEL);

        if (postList != null && !postList.isEmpty()) {
            for (Post post: postList) {
                post.setUser(userService.getById(post.getUserId()));
            }
        }

        model.addAttribute("postList", postList);

        RightMenu dataRightMenu = postService.getDataRightMenu();
        model.addAttribute("categoryCounts", dataRightMenu.getCategoryCount());
        model.addAttribute("listPopular", dataRightMenu.getListPopularPost());

        return "travel";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}
