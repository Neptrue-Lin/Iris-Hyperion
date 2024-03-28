package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "comment")
public class CommentVertexQueryModel {
    @Id
    private long id;
    private String content;
    private Timestamp postedAt;
    private boolean isDeleted;
}
