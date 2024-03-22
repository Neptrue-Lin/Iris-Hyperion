package org.neptrueworks.irishyperion.domain.interaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.commands.DownvoteInteractionCommand;
import org.neptrueworks.irishyperion.domain.interaction.commands.UnvoteInteractionCommand;
import org.neptrueworks.irishyperion.domain.interaction.commands.UpvoteInteractionCommand;
import org.neptrueworks.irishyperion.domain.interaction.events.InteractionDownvotedEvent;
import org.neptrueworks.irishyperion.domain.interaction.events.InteractionUnvotedEvent;

@Getter
@AllArgsConstructor
public class InteractionMetric extends AggregateRoot {
    private InteractionIdentifier interactionId;
    private UserIdentifier userId;
    private VoteStatus voteStatus;
//    private Reaction reaction;

    public void upvoteInteraction(EventPublisher eventPublisher, UpvoteInteractionCommand command) {
        if(this.voteStatus == VoteStatus.UPVOTED)
            return;
        this.voteStatus = VoteStatus.UPVOTED;
        eventPublisher.publish(new InteractionUnvotedEvent(this.getInteractionId(), this.getUserId(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void downvoteInteraction(EventPublisher eventPublisher, DownvoteInteractionCommand command) {
        if(this.voteStatus == VoteStatus.DOWNVOTED)
            return;
        this.voteStatus = VoteStatus.DOWNVOTED;
        eventPublisher.publish(new InteractionDownvotedEvent(this.getInteractionId(), this.getUserId(),
                eventPublisher.getChronographService().currentDateTime()));
    }

    public void unvoteInteraction(EventPublisher eventPublisher, UnvoteInteractionCommand command) {
        if(this.voteStatus == VoteStatus.UNVOTED)
            return;
        this.voteStatus = VoteStatus.UNVOTED;
        eventPublisher.publish(new InteractionUnvotedEvent(this.getInteractionId(), this.getUserId(),
                eventPublisher.getChronographService().currentDateTime()));
    }
}
