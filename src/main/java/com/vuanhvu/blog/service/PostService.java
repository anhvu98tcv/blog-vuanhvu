package com.vuanhvu.blog.service;

import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.vo.CategoryCount;
import com.vuanhvu.blog.vo.RightMenu;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();
    Post getPostById(Integer Id);
    List<Post> getPostByCategory(String category);
    List<CategoryCount> countTotalCategory();
    List<Post> getListPopular();

    RightMenu getDataRightMenu();

}
