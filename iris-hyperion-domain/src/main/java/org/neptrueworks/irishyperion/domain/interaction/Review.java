package org.neptrueworks.irishyperion.domain.interaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.AggregateRoot;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

@Getter
@AllArgsConstructor
@Builder
public class Review extends AggregateRoot {
    private ReviewIdentifier reviewId;
    private String content;
    private double rating;
    private UserIdentifier reviewer;
}
