package org.neptrueworks.irishyperion.domain.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InteractionUpvotedEvent extends DomainEvent {
    private final InteractionIdentifier interactionId;
    private final UserIdentifier upvotedBy;
    private final LocalDateTime upvotedAt;
}
