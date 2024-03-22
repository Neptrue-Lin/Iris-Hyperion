package org.neptrueworks.irishyperion.domain.media;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
public class Channel extends AggregateRoot {
    private ChannelIdentifier channelId;
    private UserIdentifier userId;
    private String channelName;
}
