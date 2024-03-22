package org.neptrueworks.irishyperion.application.interaction;

import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.core.IIdentifierGeneratable;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfile;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileFactory;
import org.neptrueworks.irishyperion.domain.interaction.CommentProfileIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.events.CommentPostedEvent;

public class CommentProfileDefaultFactory extends CommentProfileFactory {
    private IIdentifierGeneratable<CommentProfileIdentifier> identifierGenerator;

    @Override
    public CommentProfile create(EventPublisher eventPublisher, UserIdentifier postedBy,
                                 InteractionIdentifier postedTo, String content) {
        CommentProfileIdentifier commentId = this.identifierGenerator.nextIdentifier();
        CommentProfile commentProfile = new CommentProfile(commentId, postedTo, postedBy,
                eventPublisher.getChronographService().currentDateTime(), content, false);
        eventPublisher.publish(new CommentPostedEvent(postedTo, content, postedBy,
                eventPublisher.getChronographService().currentDateTime()));
        return commentProfile;
    }
}
