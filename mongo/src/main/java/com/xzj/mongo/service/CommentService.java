package com.xzj.mongo.service;

import com.xzj.mongo.dao.CommentDao;
import com.xzj.mongo.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

    @Resource
    private CommentDao commentDao;

    public void saveComment(Comment comment){
        commentDao.save(comment);
    }

    public void updateComment(Comment comment){
        commentDao.save(comment);
    }

    public void deleteComment(Comment comment){
        commentDao.deleteById(comment.getId());
    }

    public List<Comment> findCommentList(){
        return commentDao.findAll();
    }

    public Comment findCommentById(String id){
        return commentDao.findById(id).get();
    }

    public Page<Comment> findCommentListPageByParentId(String parentId, int page, int size){
        return commentDao.findByParentId(parentId, PageRequest.of(page-1,size));
    }
}
