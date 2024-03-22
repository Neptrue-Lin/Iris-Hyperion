package org.neptrueworks.irishyperion.domain.media;

import org.neptrueworks.irishyperion.domain.core.Repository;

public abstract class VideoProfileRepository extends Repository<VideoProfile> {
    public abstract VideoProfile fetchByIdentifierOrError(VideoProfileIdentifier video);
}
