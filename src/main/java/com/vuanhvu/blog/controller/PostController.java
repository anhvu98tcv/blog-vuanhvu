package com.vuanhvu.blog.controller;

import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.service.CommentServiceImpl;
import com.vuanhvu.blog.service.PostServiceImpl;
import com.vuanhvu.blog.vo.RightMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/post/{id}")
    public String getPostDetail(@PathVariable Integer id, Model model) {

        Post post = postService.getPostById(id);
        if (post == null || post.getStatus() != 1) {
            model.addAttribute("errorCode", HttpStatus.NOT_FOUND.value());
            return "error";
        }

        model.addAttribute("post", post);

        List<Comment> listCommentOfBlog = commentService.getFullCommentTree(post.getId());
        model.addAttribute("listCommentOfBlog", listCommentOfBlog);
        model.addAttribute("totalComment", listCommentOfBlog.size());

        RightMenu dataRightMenu = postService.getDataRightMenu();
        model.addAttribute("categoryCounts", dataRightMenu.getCategoryCount());
        model.addAttribute("listPopular", dataRightMenu.getListPopularPost());

        Comment comment = new Comment();
        comment.setPostId(post.getId());
        model.addAttribute("comment", comment);

        if (Constants.CATEGORY_ENGINEER.equalsIgnoreCase(post.getCategory())) {
            return "single_html";
        }

        return "single";

    }
}
