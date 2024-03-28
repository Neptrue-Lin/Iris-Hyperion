package org.neptrueworks.irishyperion.data.searching.querying;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

import java.sql.Timestamp;

@Data
@IndexName("comment_profile")
public class CommentProfileQueryModel {
    private long id;
    private long target;
    private long author;
    private String content;
    private Timestamp postedAt;
    private boolean isDeleted;
}
