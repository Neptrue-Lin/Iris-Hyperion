package org.neptrueworks.irishyperion.data.graphing.querying;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Data
@Table(name = "user")
public class UserVertexQueryModel {
    @Id
    private long id;
    private long userId;
    private String username;
    private String avatar;
    private short level;
    private Date birthday;
    private boolean gender;
    private boolean isDeleted;
}
