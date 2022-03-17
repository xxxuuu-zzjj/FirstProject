package com.xzj.mongo;

import com.xzj.mongo.po.Comment;
import com.xzj.mongo.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MongoApplicationTests {

    @Autowired
    private CommentService commentService;


    @Test
    public void testFindCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void testFindCommentById() {
        Comment commentById = commentService.findCommentById("1");
        System.out.println(commentById);
    }

    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleId("100000");
        comment.setContent("测试添加的数据");
        comment.setCreateDateTime(new Date());
        comment.setUserId("1003");
        comment.setNickName("凯撒大帝");
        comment.setState("1");
        comment.setLikeNum(0);
        comment.setReplyNum(0);

        commentService.saveComment(comment);

    }

    @Test
    public void testFindCommentListByParentid() {
        Page<Comment> page = commentService.findCommentListPageByParentId("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

//    @Test
//    public void testUpdateCommentLikenum() {
//        commentService.updateCommentLikeNum("1");
//    }

}
