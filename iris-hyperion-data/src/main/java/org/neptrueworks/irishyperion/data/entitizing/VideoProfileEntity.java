package org.neptrueworks.irishyperion.data.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import org.neptrueworks.irishyperion.data.persistence.querying.UserProfileQueryModel;
import org.neptrueworks.irishyperion.data.persistence.querying.VideoCategoryQueryModel;
import org.neptrueworks.irishyperion.data.persistence.querying.VideoTagQueryModel;

import java.sql.Timestamp;
import java.util.Collection;

@Data
@Table("video_profile")
public class VideoProfileEntity {
    @Id
    private long id;
    private String title;
    private long author;
    private Collection<UserProfileQueryModel> creators;
    private Collection<VideoCategoryQueryModel> category;
    private Collection<VideoTagQueryModel> tags;
    private String description;
    private Timestamp publishedAt;
    private boolean isDeleted;
}
