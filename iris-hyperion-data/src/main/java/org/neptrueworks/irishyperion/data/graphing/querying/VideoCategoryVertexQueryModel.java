package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "video_category")
public class VideoCategoryVertexQueryModel {
    @Id
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
