package org.neptrueworks.irishyperion.domain.identification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.identification.UserIdentifier;
import org.neptrueworks.irishyperion.domain.identification.UserIdentityIdentifier;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class LockIdentityCommand extends Command {
    private final UserIdentifier userId;
    private final UserIdentityIdentifier identityIdentifier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LockIdentityCommand that = (LockIdentityCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(identityIdentifier, that.identityIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, identityIdentifier);
    }
}
