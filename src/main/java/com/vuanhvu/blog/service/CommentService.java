package com.vuanhvu.blog.service;

import com.vuanhvu.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getListParentComment(Integer postId);

    List<Comment> findByParentId(Integer parentId);

    Comment saveComment(Comment comment);
}
