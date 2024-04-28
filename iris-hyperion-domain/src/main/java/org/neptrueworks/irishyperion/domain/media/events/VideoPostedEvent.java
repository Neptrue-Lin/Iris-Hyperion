package org.neptrueworks.irishyperion.domain.media.events;

import org.neptrueworks.irishyperion.domain.common.DomainEvent;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

import java.time.LocalDateTime;

public record VideoPostedEvent(UserIdentifier postedBy, LocalDateTime postedAt) implements DomainEvent {
}
