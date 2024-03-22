package org.neptrueworks.irishyperion.domain.interaction.commands;

import lombok.AllArgsConstructor;
import org.neptrueworks.irishyperion.domain.core.CommandHandler;
import org.neptrueworks.irishyperion.domain.core.EventPublisher;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetric;
import org.neptrueworks.irishyperion.domain.interaction.InteractionMetricRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UnvoteInteractionCommandHandler extends CommandHandler<UnvoteInteractionCommand> {
    private InteractionMetricRepository repository;

    @Override
    public void handle(EventPublisher eventPublisher, UnvoteInteractionCommand command) {
        InteractionMetric interactionMetric = this.repository.fetchByIdentifierOrError(command.getInteractionId(), command.getUserId());
        interactionMetric.unvoteInteraction(eventPublisher, command);
        this.repository.save(interactionMetric);
    }
}
