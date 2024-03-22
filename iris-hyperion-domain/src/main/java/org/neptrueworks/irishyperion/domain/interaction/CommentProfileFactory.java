package org.neptrueworks.irishyperion.domain.interaction;

import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class CommentProfileFactory {

    public abstract CommentProfile create(EventPublisher eventPublisher, UserIdentifier postedBy,
                                          InteractionIdentifier postedTo, String content);
}
