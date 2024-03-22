package org.neptrueworks.irishyperion.domain.profiling.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neptrueworks.irishyperion.domain.core.Command;

import java.util.Objects;

@Data
@AllArgsConstructor
public class ChangeUsernameCommand extends Command {
    private Integer userId;
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeUsernameCommand that = (ChangeUsernameCommand) o;
        return Objects.equals(userId, that.userId) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }
}
