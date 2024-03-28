package org.neptrueworks.irishyperion.data.persistence.querying;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Table("video_profile")
public class VideoProfileQueryModel {
    @Id
    private long id;
    private String title;
    private long author;
    private String cover;
    private List<UserProfileQueryModel> creators;
    private List<VideoCategoryQueryModel> category;
    private List<VideoTagQueryModel> tags;
    private String description;
    private Timestamp publishedAt;
    private Timestamp postedAt;
    private boolean isDeleted;
}
