package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class DisableIdentificationCommand extends Command {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identifier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisableIdentificationCommand that = (DisableIdentificationCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, identifier);
    }


}
