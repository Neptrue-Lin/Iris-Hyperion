package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.common.CommandHandler;
import org.neptrueworks.irishyperion.domain.common.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetric;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetricRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpvoteInteractionCommandHandler extends CommandHandler<UpvoteInteractionCommand> {
    private final InteractionMetricRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, UpvoteInteractionCommand command) {
        InteractionMetric interactionMetric = this.repository.fetchByIdentifierOrError(command.interactionId(), command.userId());
        interactionMetric.upvoteInteraction(eventPublisher, command);
        this.repository.save(interactionMetric);
    }
}
