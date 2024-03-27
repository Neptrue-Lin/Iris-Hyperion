package org.neptrueworks.irishyperion.data.persistence.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("user_account")
public class UserAccountEntity {
    @Id
    private long id;
    private String isLocked;
    private String isCancelled;
    private String isDeleted;
}
