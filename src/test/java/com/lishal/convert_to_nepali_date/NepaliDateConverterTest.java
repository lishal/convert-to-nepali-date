package com.lishal.convert_to_nepali_date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NepaliDateConverterTest {

    @Test
    void convertsEnglishDateToNepaliDate() {
        NepaliDate nepaliDate = NepaliDateConverter.toNepaliDate(LocalDate.of(2026, 6, 15));

        assertEquals(NepaliDate.of(2083, 3, 1), nepaliDate);
        assertEquals("2083-03-01", nepaliDate.format());
    }

    @Test
    void convertsIsoDateStringToNepaliDate() {
        NepaliDate nepaliDate = ConvertToNepaliDate.convert("2026-06-15");

        assertEquals("2083-03-01", nepaliDate.format());
    }

    @Test
    void convertsCommonStringDateFormatsToNepaliDate() {
        assertEquals("2083-03-01", ConvertToNepaliDate.convert("2026/06/15").format());
        assertEquals("2083-03-01", ConvertToNepaliDate.convert("2026-06-15T18:30:00").format());
        assertEquals("2083-03-01", ConvertToNepaliDate.convert("2026-06-15T18:30:00Z").format());
    }

    @Test
    void convertsLocalDateTimeUsingDatePartOnly() {
        NepaliDate nepaliDate = ConvertToNepaliDate.convert(LocalDateTime.of(2026, 6, 15, 23, 59));

        assertEquals("2083-03-01", nepaliDate.format());
    }

    @Test
    void convertsNepaliDateBackToEnglishDate() {
        LocalDate englishDate = NepaliDateConverter.toEnglishDate(NepaliDate.of(2083, 3, 1));

        assertEquals(LocalDate.of(2026, 6, 15), englishDate);
    }

    @Test
    void parsesNepaliDateStringForReverseConversion() {
        LocalDate englishDate = NepaliDateConverter.toEnglishDate("2083-03-01");

        assertEquals(LocalDate.of(2026, 6, 15), englishDate);
    }

    @Test
    void validatesNepaliDateAgainstCalendarData() {
        assertTrue(NepaliDateConverter.isValid(NepaliDate.of(2083, 3, 32)));
        assertFalse(NepaliDateConverter.isValid(NepaliDate.of(2083, 4, 32)));
    }

    @Test
    void rejectsUnsupportedAutomaticInputType() {
        NepaliDateException exception = assertThrows(
                NepaliDateException.class,
                () -> NepaliDateConverter.convert(20260615)
        );

        assertTrue(exception.getMessage().contains("Unsupported English date input type"));
    }

    @Test
    void rejectsInvalidEnglishDateString() {
        NepaliDateException exception = assertThrows(
                NepaliDateException.class,
                () -> ConvertToNepaliDate.convert("15-06-2026")
        );

        assertTrue(exception.getMessage().contains("Expected yyyy-MM-dd"));
    }
}
