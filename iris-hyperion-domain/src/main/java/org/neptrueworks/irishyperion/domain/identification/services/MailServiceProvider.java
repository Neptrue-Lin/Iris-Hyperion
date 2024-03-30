package org.neptrueworks.irishyperion.domain.identification.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URI;

@Getter
@AllArgsConstructor
public class MailServiceProvider {
    private final URI domainName;
}
