package com.vuanhvu.blog.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCount {

    private String category;
    private Long total;

    public CategoryCount(String category, Long total) {
        this.category = category;
        this.total = total;
    }
}
