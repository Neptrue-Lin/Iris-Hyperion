package org.neptrueworks.irishyperion.domain.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InteractionDownvotedEvent extends DomainEvent {
    private final InteractionIdentifier interactionId;
    private final UserIdentifier downvotedBy;
    private final LocalDateTime downvotedAt;
}
