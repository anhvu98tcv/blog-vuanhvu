package com.vuanhvu.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer postId;
    private Integer parentCommentId;
    private String content;
    private Integer userId;
    private Date createDatetime;
    private Integer status;

    @Transient
    private List<Comment> listChildComment;

    @Transient
    private User user;

}
