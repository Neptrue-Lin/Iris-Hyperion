package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.util.Objects;

@Data
@AllArgsConstructor
public class EnableIdentificationCommand extends Command {
    private UserIdentifier userId;
    private UserIdentityIdentifier identifier;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnableIdentificationCommand that = (EnableIdentificationCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, identifier);
    }
}
