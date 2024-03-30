package org.neptrueworks.irishyperion.domain.interaction;

import org.neptrueworks.irishyperion.domain.common.Repository;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;

public abstract class InteractionMetricRepository extends Repository<InteractionMetric> {
    public abstract InteractionMetric fetchByIdentifierOrError(InteractionIdentifier interactionId, UserIdentifier userId);
}
