package org.neptrueworks.irishyperion.data.searching.querying;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

import java.sql.Timestamp;
import java.util.List;

@Data
@IndexName("video_profile")
public class VideoProfileQueryModel {
    private long id;
    private String title;
    private long author;
    private List<UserProfileQueryModel> creators;
    private List<VideoCategoryQueryModel> category;
    private List<VideoTagQueryModel> tags;
    private String description;
    private Timestamp publishedAt;
    private Timestamp postedAt;
    private boolean isDeleted;
}
