package org.neptrueworks.irishyperion.domain.media;

import org.neptrueworks.irishyperion.domain.common.Repository;

public abstract class ChannelRepository extends Repository<Channel> {
    public abstract Channel fetchByIdentifierOrError(ChannelIdentifier channelId);
}
