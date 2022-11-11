package com.vuanhvu.blog.repository;

import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.vo.CategoryCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> getPostByStatusOrderByCreateDateDesc(Integer status);

    List<Post> getPostByCategoryAndStatusOrderByCreateDate(String category, Integer status);

    @Query("SELECT new com.vuanhvu.blog.vo.CategoryCount(c.category, COUNT(c.category)) FROM Post " +
            "AS c GROUP BY c.category ORDER BY c.category DESC")
    List<CategoryCount> countTotalCategory();

    List<Post> getPostsByPopularAndStatusOrderByCreateDateDesc(Integer popular, Integer status);

}
