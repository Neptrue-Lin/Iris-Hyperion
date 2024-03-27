package org.neptrueworks.irishyperion.data.persistence.querying;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Table("user_profile")
public class UserProfileQueryModel {
    @Id
    private long id;
    private long userId;
    private String username;
    private String avatar;
    private Date birthday;
    private boolean gender;
}
