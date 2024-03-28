package org.neptrueworks.irishyperion.data.searching.querying;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

@Data
@IndexName("video_tag")
public class VideoTagQueryModel {
    private long id;
    private String name;
    private String description;
    private boolean isDeleted;
}
