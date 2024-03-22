package org.neptrueworks.irishyperion.domain.social;

import org.neptrueworks.irishyperion.domain.core.Repository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class SocialEngagementRepository extends Repository<SocialEngagement> {
    public abstract SocialEngagement fetchByIdentifierOrError(UserIdentifier source, UserIdentifier target);
}
