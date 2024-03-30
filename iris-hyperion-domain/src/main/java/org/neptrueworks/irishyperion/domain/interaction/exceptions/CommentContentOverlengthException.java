package org.neptrueworks.irishyperion.domain.interaction.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.DomainException;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentContentOverlengthException extends DomainException {
    private final InteractionIdentifier postedTo;
    private final UserIdentifier postedBy;
    private final LocalDateTime postedAt;
}
