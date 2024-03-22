package org.neptrueworks.irishyperion.domain.interaction;

import org.neptrueworks.irishyperion.domain.core.AggregateRoot;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public class Review extends AggregateRoot {
    private ReviewIdentifier reviewId;
    private String content;
    private Float rating;
    private UserIdentifier reviewer;
}
