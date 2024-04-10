package org.neptrueworks.irishyperion.domain.interaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentProfileIdentifier extends InteractionIdentifier {
    private final String identifier;
}
