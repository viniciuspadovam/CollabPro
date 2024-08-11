package com.viniciuspadovam.collabpro.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {

    public static Timestamp addTimestampAndInteger(Timestamp timestamp, Integer hoursToAdd) {
        LocalDateTime dateTime = timestamp.toLocalDateTime();
        LocalDateTime novoDateTime = dateTime.plusHours(hoursToAdd);
        return Timestamp.valueOf(novoDateTime);
    }

}
