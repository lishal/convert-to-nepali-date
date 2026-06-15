package com.lishal.convert_to_nepali_date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public final class ConvertToNepaliDate {

    private ConvertToNepaliDate() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static NepaliDate convert(LocalDate englishDate) {
        return NepaliDateConverter.toNepaliDate(englishDate);
    }

    public static NepaliDate convert(String englishDate) {
        return NepaliDateConverter.toNepaliDate(englishDate);
    }

    public static NepaliDate convert(LocalDateTime englishDateTime) {
        return NepaliDateConverter.toNepaliDate(englishDateTime);
    }

    public static NepaliDate convert(Instant instant) {
        return NepaliDateConverter.toNepaliDate(instant);
    }

    public static NepaliDate convert(Date date) {
        return NepaliDateConverter.toNepaliDate(date);
    }

    public static NepaliDate convert(ZonedDateTime englishDateTime) {
        return NepaliDateConverter.toNepaliDate(englishDateTime);
    }

    public static NepaliDate convert(OffsetDateTime englishDateTime) {
        return NepaliDateConverter.toNepaliDate(englishDateTime);
    }

    public static NepaliDate convert(Object englishDate) {
        return NepaliDateConverter.convert(englishDate);
    }
}
