package com.vuanhvu.blog.service;

import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.Comment;
import com.vuanhvu.blog.entity.User;
import com.vuanhvu.blog.repository.CommentRepository;
import com.vuanhvu.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment saveComment(Comment comment) {
        Comment save = commentRepository.save(comment);
        return save;
    }

    public List<Comment> getListParentComment(Integer postId) {
        return commentRepository.getListParentComment(postId, Constants.ACTIVE_STATUS);
    }

    public List<Comment> findByParentId(Integer parentId) {
        return commentRepository.findByParentCommentIdAndStatusOrderByCreateDatetime(parentId, Constants.ACTIVE_STATUS);
    }

//    public List<Comment> getFullCommentTree(Integer postId) {
//        List<Comment> listCommentOfBlog = getListParentComment(postId);
//        if (listCommentOfBlog != null && !listCommentOfBlog.isEmpty()) {
//            for (Comment comment: listCommentOfBlog) {
//                List<Comment> listChildComment = findByParentId(comment.getId());
//                if (listChildComment != null && !listChildComment.isEmpty()) {
//                    for (Comment commentChild: listChildComment) {
//                        commentChild.setUser(userRepository.findById(commentChild.getUserId()).orElse(null));
//                    }
//                }
//                comment.setListChildComment(listChildComment);
//                comment.setUser(userRepository.findById(comment.getUserId()).orElse(null));
//            }
//
//        }
//
//        return listCommentOfBlog;
//    }

    public List<Comment> getFullCommentTree(Integer postId) {
        List<Comment> listCommentOfBlog = commentRepository.getCommentByPostIdAndStatusOrderByCreateDatetimeDesc(postId, Constants.ACTIVE_STATUS);
        List<Comment> listCommentReturn = new ArrayList<>();

        if (listCommentOfBlog == null || listCommentOfBlog.isEmpty()) {
            return listCommentReturn;
        }

        Map<Integer, User> userMap = new HashMap<>();
        for (Comment comment : listCommentOfBlog) {
            if (comment.getParentCommentId() == null) {
                listCommentReturn.add(comment);
                List<Comment> listChildComment = new ArrayList<>();
                for (Comment commentChild : listCommentOfBlog) {
                    if (commentChild.getParentCommentId() != null && commentChild.getParentCommentId().equals(comment.getId())) {
                        listChildComment.add(commentChild);
                    }
                }
                comment.setListChildComment(listChildComment);
            }
            if (userMap.get(comment.getUserId()) == null) {
                User user = userRepository.findById(comment.getUserId()).orElse(null);
                userMap.put(comment.getUserId(), user);
                comment.setUser(user);
            } else {
                comment.setUser(userMap.get(comment.getUserId()));
            }
        }
        return listCommentReturn;

    }

}
