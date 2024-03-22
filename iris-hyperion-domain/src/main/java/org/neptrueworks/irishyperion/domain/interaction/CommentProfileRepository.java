package org.neptrueworks.irishyperion.domain.interaction;

import org.neptrueworks.irishyperion.domain.core.Repository;

public abstract class CommentProfileRepository extends Repository<CommentProfile> {
    public abstract CommentProfile fetchByIdentifierOrError(CommentProfileIdentifier commentId);
}
