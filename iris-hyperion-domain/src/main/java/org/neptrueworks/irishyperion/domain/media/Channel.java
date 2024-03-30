package org.neptrueworks.irishyperion.domain.media;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class Channel extends AggregateRoot {
    private final ChannelIdentifier channelId;
    private final UserIdentifier userId;
    private final String channelName;
}
