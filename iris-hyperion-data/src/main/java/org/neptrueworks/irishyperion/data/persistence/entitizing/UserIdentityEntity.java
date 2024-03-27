package org.neptrueworks.irishyperion.data.persistence.entitizing;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("user_identity")
public class UserIdentityEntity {
    @Id
    private long id;
    private long userId;
    private String identificationClaim;
    private String verificationCredential;
    private boolean isIdentificationEnabled;
    private boolean isVerificationEnabled;
    private boolean isLocked;
    private boolean isDeleted;
}
