package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "video")
public class VideoVertexQueryModel {
    @Id
    private long id;
    private String title;
    private String cover;
    private String description;
    private boolean isDeleted;
}
