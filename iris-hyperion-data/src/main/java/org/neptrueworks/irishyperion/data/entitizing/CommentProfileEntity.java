package org.neptrueworks.irishyperion.data.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table("comment_profile")
public class CommentProfileEntity {
    @Id
    private long id;
    private long target;
    private long author;
    private String content;
    private Timestamp postedAt;
    private boolean isDeleted;
}
