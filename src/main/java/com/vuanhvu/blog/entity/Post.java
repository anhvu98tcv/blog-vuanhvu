package com.vuanhvu.blog.entity;

import com.vuanhvu.blog.constant.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String title;
    private String category;
    private String briefContent;
    private String content;
    private String image;
    private Date createDate;
    private Integer status;
    private Integer popular;

    @Transient
    private User user;
    @Transient
    private List<Comment> listComment;
    @Transient
    private Comment commentOfAuthor;

}
