package com.mssc.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Component
public class DateMapper {

    public  OffsetDateTime asOffsetDateTime(Timestamp ts) {
        return Optional.ofNullable(ts)
                .map(t -> OffsetDateTime.of(t.toLocalDateTime().getYear(),
                        t.toLocalDateTime().getMonthValue(),
                        t.toLocalDateTime().getDayOfMonth(),
                        t.toLocalDateTime().getHour(), t.toLocalDateTime().getMinute(),
                        t.toLocalDateTime().getSecond(), t.toLocalDateTime().getNano(), ZoneOffset.UTC))
                .orElse(null);
    }

    public Timestamp asTimesTamp(OffsetDateTime offsetDateTime) {
        return Optional.ofNullable(offsetDateTime)
                .map(of ->  Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()))
                .orElse(null);
    }
}
