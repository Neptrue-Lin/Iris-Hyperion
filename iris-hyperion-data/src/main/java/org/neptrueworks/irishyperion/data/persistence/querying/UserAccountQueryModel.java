package org.neptrueworks.irishyperion.data.persistence.querying;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;


@Data
@Table("user_account")
public class UserAccountQueryModel {
    @Id
    private long id;
    private boolean isLocked;
    private boolean isCancelled;
    private boolean isDeleted;
}
