package org.neptrueworks.irishyperion.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.neptrueworks.irishyperion.domain.core.Command;

@Getter
@AllArgsConstructor
public class AuthorizableCommandDecorator extends Command {
    private Command decoratedCommand;
    private AuthorizationIdentifier identifier;
    private AuthorizationCredential credential;
}
