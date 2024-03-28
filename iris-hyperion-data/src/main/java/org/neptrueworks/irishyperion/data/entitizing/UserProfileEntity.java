package org.neptrueworks.irishyperion.data.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("user_profile")
public class UserProfileEntity {
    @Id
    private long id;
    private long userId;
    private String username;
    private String avatar;
}
