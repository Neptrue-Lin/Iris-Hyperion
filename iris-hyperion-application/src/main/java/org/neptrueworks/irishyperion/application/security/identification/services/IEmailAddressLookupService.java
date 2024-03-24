package org.neptrueworks.irishyperion.application.security.identification.services;

import org.neptrueworks.irishyperion.application.security.identification.EmailAddress;

public interface IEmailAddressLookupService {
    MailServiceProvider getMailServiceProvider(EmailAddress emailAddress);
    boolean isDisposableMailServiceProvider(EmailAddress emailAddress);
    boolean checkMailExchangeRecord(EmailAddress emailAddress);
    boolean checkMailDeliverability(EmailAddress emailAddress);
}
