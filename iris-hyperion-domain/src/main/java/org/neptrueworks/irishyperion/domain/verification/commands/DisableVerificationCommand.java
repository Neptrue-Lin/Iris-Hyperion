package org.neptrueworks.irishyperion.domain.verification.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.common.Command;
import org.neptrueworks.irishyperion.domain.verification.UserVerityIdentifier;

@Getter
@AllArgsConstructor
public class DisableVerificationCommand extends Command {
    private final UserVerityIdentifier identifier;
}
