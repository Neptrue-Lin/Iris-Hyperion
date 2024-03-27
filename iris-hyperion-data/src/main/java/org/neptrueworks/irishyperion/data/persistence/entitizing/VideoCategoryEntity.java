package org.neptrueworks.irishyperion.data.persistence.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("video_category")
public class VideoCategoryEntity {
    @Id
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
