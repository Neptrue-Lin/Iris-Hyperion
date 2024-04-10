package org.neptrueworks.irishyperion.domain.media;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.interaction.InteractionIdentifier;

@Getter
@AllArgsConstructor
public class VideoProfileIdentifier extends InteractionIdentifier {
    private final String identifier;
}
