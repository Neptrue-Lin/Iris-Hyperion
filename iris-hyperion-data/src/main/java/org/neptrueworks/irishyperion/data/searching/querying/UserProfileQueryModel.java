package org.neptrueworks.irishyperion.data.searching.querying;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

import java.sql.Date;

@Data
@IndexName("user_profile")
public class UserProfileQueryModel {
    private long id;
    private long userId;
    private String username;
    private String avatar;
    private Date birthday;
    private boolean gender;
}
