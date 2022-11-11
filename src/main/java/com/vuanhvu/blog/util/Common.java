package com.vuanhvu.blog.util;

import com.vuanhvu.blog.entity.Comment;

import java.util.List;

public class Common {

    public static boolean isNullOrEmpty(String input) {
        if (input == null  || input.trim().isEmpty()) {
            return  true;
        }

        return false;
    }

}
