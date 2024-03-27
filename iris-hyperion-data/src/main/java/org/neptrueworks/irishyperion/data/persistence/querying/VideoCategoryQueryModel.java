package org.neptrueworks.irishyperion.data.persistence.querying;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("video_category")
public class VideoCategoryQueryModel {
    @Id
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
