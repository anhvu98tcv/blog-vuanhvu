package com.vuanhvu.blog.vo;

import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BlogSummary {

    private Post post;
    private User user;
    private List<Comment> listComment;

}
