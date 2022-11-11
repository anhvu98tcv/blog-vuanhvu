package com.vuanhvu.blog.vo;

import com.vuanhvu.blog.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RightMenu {

    private List<CategoryCount> categoryCount;
    private List<Post> listPopularPost;

}
