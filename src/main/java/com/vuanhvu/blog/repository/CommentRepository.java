package com.vuanhvu.blog.repository;

import com.vuanhvu.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value  = "select a from Comment a where a.postId = ?1 and a.userId = ?2 and a.parentCommentId is null and a.status = ?3 " +
            " order by a.createDatetime asc ")
    List<Comment> getFirstCommentOfOwner(Integer postId, Integer userId, Integer status);

    @Query(value  = "select a from Comment a where a.postId = ?1 and a.parentCommentId is null and a.status = ?2 " +
            " order by a.createDatetime desc")
    List<Comment> getListParentComment(Integer postId, Integer status);

    List<Comment> findByParentCommentIdAndStatusOrderByCreateDatetime(Integer parentId, Integer status);

    List<Comment> getCommentByPostIdAndStatusOrderByCreateDatetimeDesc(Integer postId, Integer status);

}
