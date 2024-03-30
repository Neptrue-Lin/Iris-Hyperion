package org.neptrueworks.irishyperion.domain.identification.services;

import org.neptrueworks.irishyperion.domain.identification.EmailAddress;

public interface IEmailAddressLookupService {
    MailServiceProvider getMailServiceProvider(EmailAddress emailAddress);
    boolean isDisposableMailServiceProvider(EmailAddress emailAddress);
    boolean checkMailExchangeRecord(EmailAddress emailAddress);
    boolean checkMailDeliverability(EmailAddress emailAddress);
}
