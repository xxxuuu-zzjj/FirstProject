package com.xzj.mongo.dao;

import com.xzj.mongo.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDao extends MongoRepository<Comment, String> {

    Page<Comment> findByParentId(String parentId, Pageable pageable);
}
