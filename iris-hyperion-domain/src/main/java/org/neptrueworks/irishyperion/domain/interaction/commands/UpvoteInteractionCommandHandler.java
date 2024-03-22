package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetric;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetricRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpvoteInteractionCommandHandler extends CommandHandler<UpvoteInteractionCommand> {
    private InteractionMetricRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, UpvoteInteractionCommand command) {
        InteractionMetric interactionMetric = this.repository.fetchByIdentifierOrError(command.getInteractionId(), command.getUserId());
        interactionMetric.upvoteInteraction(eventPublisher, command);
        this.repository.save(interactionMetric);
    }
}
