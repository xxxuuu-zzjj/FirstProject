package com.xzj.mongo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;

    private String content;

    private String userId;

    private String nickName;

    private Date createDateTime;

    private Integer likeNum;

    private Integer replyNum;

    private String state;

    private String parentId;

    private String articleId;
}
