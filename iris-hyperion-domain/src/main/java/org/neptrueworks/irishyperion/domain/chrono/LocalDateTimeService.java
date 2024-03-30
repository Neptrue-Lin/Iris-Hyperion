package org.neptrueworks.irishyperion.domain.chrono;

import java.time.LocalDateTime;

public class LocalDateTimeService implements ChronographService {
    @Override
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
