package org.neptrueworks.irishyperion.application.chrono;

import org.neptrueworks.irishyperion.domain.chrono.ChronographService;

import java.time.LocalDateTime;

public class LocalDateTimeService implements ChronographService {
    @Override
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
