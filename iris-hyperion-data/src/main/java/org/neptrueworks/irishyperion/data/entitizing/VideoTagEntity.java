package org.neptrueworks.irishyperion.data.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("video_tag")
public class VideoTagEntity {
    @Id
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
