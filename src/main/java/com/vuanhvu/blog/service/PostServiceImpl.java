package com.vuanhvu.blog.service;

import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.Post;
import com.vuanhvu.blog.entity.User;
import com.vuanhvu.blog.repository.CommentRepository;
import com.vuanhvu.blog.repository.PostRepository;
import com.vuanhvu.blog.repository.UserRepository;
import com.vuanhvu.blog.vo.CategoryCount;
import com.vuanhvu.blog.vo.RightMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPost() {
        List<Post> posts = postRepository.getPostByStatusOrderByCreateDateDesc(Constants.ACTIVE_STATUS);

        return getMoreData(posts);
    }

    private List<Post> getMoreData(List<Post> posts) {
        if (posts != null && !posts.isEmpty()) {
            Map<Integer, User> userMap = new HashMap<>();
            for (Post post: posts) {

                if (userMap.get(post.getUserId()) == null) {
                    User user = userRepository.findById(post.getUserId()).orElse(null);
                    userMap.put(post.getUserId(), user);
                    post.setUser(user);
                } else {
                    post.setUser(userMap.get(post.getUserId()));
                }

                post.setListComment(commentRepository.getListParentComment(post.getId(), Constants.ACTIVE_STATUS));
            }
        }

        return posts;
    }

    @Override
    public Post getPostById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        Post post = postOptional.orElse(null);
        if (post == null || post.getStatus() != 1) {
            return post;
        }

        List<Comment> commentList = commentRepository.getFirstCommentOfOwner(post.getId(), post.getUserId(), Constants.ACTIVE_STATUS);
        post.setCommentOfAuthor((commentList != null && !commentList.isEmpty()) ? commentList.get(0) : null);


        User user = userRepository.findById(post.getUserId()).orElse(new User());
        post.setUser(user);
        return post;
    }

    @Override
    public List<Post> getPostByCategory(String category) {
        List<Post> posts = postRepository.getPostByCategoryAndStatusOrderByCreateDate(category, Constants.ACTIVE_STATUS);

        return getMoreData(posts);
    }

    @Override
    public List<CategoryCount> countTotalCategory() {
        return postRepository.countTotalCategory();
    }

    @Override
    public List<Post> getListPopular() {
        List<Post> posts = postRepository.getPostsByPopularAndStatusOrderByCreateDateDesc(Constants.POPULAR_STATUS, Constants.ACTIVE_STATUS);
        return getMoreData(posts);
    }

    @Override
    public RightMenu getDataRightMenu() {
        RightMenu rightMenu = new RightMenu();

        List<CategoryCount> categoryCounts = countTotalCategory();
        List<Post> listPopular = getListPopular();

        rightMenu.setCategoryCount(categoryCounts);
        rightMenu.setListPopularPost(listPopular);

        return rightMenu;
    }
}
