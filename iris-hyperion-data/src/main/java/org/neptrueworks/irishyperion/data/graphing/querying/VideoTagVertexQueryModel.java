package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "video_tag")
public class VideoTagVertexQueryModel {
    @Id
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
