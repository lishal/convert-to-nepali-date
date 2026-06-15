package com.lishal.convert_to_nepali_date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

public final class NepaliDateConverter {

    private static final LocalDate BASE_AD_DATE = LocalDate.of(2026, 6, 8);
    private static final NepaliDate BASE_BS_DATE = NepaliDate.of(2083, 2, 25);
    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    private NepaliDateConverter() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static NepaliDate toNepaliDate(LocalDate englishDate) {
        Objects.requireNonNull(englishDate, "englishDate must not be null");

        long daysDifference = ChronoUnit.DAYS.between(BASE_AD_DATE, englishDate);

        NepaliDate result = moveNepaliDate(BASE_BS_DATE, daysDifference);

        validate(result);

        return result;
    }

    public static NepaliDate toNepaliDate(String englishDate) {
        return toNepaliDate(parseEnglishDate(englishDate));
    }

    public static NepaliDate toNepaliDate(LocalDateTime englishDateTime) {
        Objects.requireNonNull(englishDateTime, "englishDateTime must not be null");
        return toNepaliDate(englishDateTime.toLocalDate());
    }

    public static NepaliDate toNepaliDate(Instant instant) {
        Objects.requireNonNull(instant, "instant must not be null");
        return toNepaliDate(LocalDate.ofInstant(instant, DEFAULT_ZONE));
    }

    public static NepaliDate toNepaliDate(Date date) {
        Objects.requireNonNull(date, "date must not be null");
        return toNepaliDate(date.toInstant());
    }

    public static NepaliDate toNepaliDate(ZonedDateTime englishDateTime) {
        Objects.requireNonNull(englishDateTime, "englishDateTime must not be null");
        return toNepaliDate(englishDateTime.toLocalDate());
    }

    public static NepaliDate toNepaliDate(OffsetDateTime englishDateTime) {
        Objects.requireNonNull(englishDateTime, "englishDateTime must not be null");
        return toNepaliDate(englishDateTime.toLocalDate());
    }

    public static NepaliDate convert(Object englishDate) {
        Objects.requireNonNull(englishDate, "englishDate must not be null");

        if (englishDate instanceof LocalDate) {
            return toNepaliDate((LocalDate) englishDate);
        }

        if (englishDate instanceof CharSequence) {
            return toNepaliDate(englishDate.toString());
        }

        if (englishDate instanceof LocalDateTime) {
            return toNepaliDate((LocalDateTime) englishDate);
        }

        if (englishDate instanceof Instant) {
            return toNepaliDate((Instant) englishDate);
        }

        if (englishDate instanceof Date) {
            return toNepaliDate((Date) englishDate);
        }

        if (englishDate instanceof ZonedDateTime) {
            return toNepaliDate((ZonedDateTime) englishDate);
        }

        if (englishDate instanceof OffsetDateTime) {
            return toNepaliDate((OffsetDateTime) englishDate);
        }

        throw new NepaliDateException(
                "Unsupported English date input type: " + englishDate.getClass().getName() +
                        ". Supported types are LocalDate, CharSequence, LocalDateTime, Instant, Date, ZonedDateTime, and OffsetDateTime."
        );
    }

    public static LocalDate toEnglishDate(NepaliDate nepaliDate) {
        Objects.requireNonNull(nepaliDate, "nepaliDate must not be null");

        validate(nepaliDate);

        long daysDifference = daysBetweenNepaliDates(BASE_BS_DATE, nepaliDate);

        return BASE_AD_DATE.plusDays(daysDifference);
    }

    public static LocalDate toEnglishDate(String nepaliDate) {
        return toEnglishDate(NepaliDate.parse(nepaliDate));
    }

    public static void validate(NepaliDate nepaliDate) {
        Objects.requireNonNull(nepaliDate, "nepaliDate must not be null");

        int year = nepaliDate.getYear();
        int month = nepaliDate.getMonth();
        int day = nepaliDate.getDay();

        if (!NepaliCalendarData.isSupportedYear(year)) {
            throw new NepaliDateException(
                    "Unsupported Nepali year: " + year +
                            ". Supported range is " +
                            NepaliCalendarData.getMinimumSupportedYear() +
                            " to " +
                            NepaliCalendarData.getMaximumSupportedYear() + "."
            );
        }

        int maximumDay = NepaliCalendarData.getDaysInMonth(year, month);

        if (day < 1 || day > maximumDay) {
            throw new NepaliDateException(
                    "Invalid Nepali date: " + nepaliDate.format() +
                            ". Month " + month +
                            " of year " + year +
                            " has only " + maximumDay + " days."
            );
        }
    }

    public static boolean isValid(NepaliDate nepaliDate) {
        try {
            validate(nepaliDate);
            return true;
        } catch (NepaliDateException exception) {
            return false;
        }
    }

    public static int getDaysInMonth(int year, int month) {
        return NepaliCalendarData.getDaysInMonth(year, month);
    }

    public static int getMinimumSupportedYear() {
        return NepaliCalendarData.getMinimumSupportedYear();
    }

    public static int getMaximumSupportedYear() {
        return NepaliCalendarData.getMaximumSupportedYear();
    }

    public static LocalDate getMinimumSupportedEnglishDate() {
        return toEnglishDate(NepaliDate.of(getMinimumSupportedYear(), 1, 1));
    }

    public static LocalDate getMaximumSupportedEnglishDate() {
        int year = getMaximumSupportedYear();
        return toEnglishDate(NepaliDate.of(year, 12, getDaysInMonth(year, 12)));
    }

    private static LocalDate parseEnglishDate(String englishDate) {
        Objects.requireNonNull(englishDate, "englishDate must not be null");

        String normalizedDate = englishDate.trim().replace('/', '-');

        try {
            return LocalDate.parse(normalizedDate);
        } catch (DateTimeParseException ignored) {
            return parseEnglishDateTime(normalizedDate, englishDate);
        }
    }

    private static LocalDate parseEnglishDateTime(String normalizedDate, String originalDate) {
        try {
            return OffsetDateTime.parse(normalizedDate).toLocalDate();
        } catch (DateTimeParseException ignored) {
            // Try the next supported date-time representation.
        }

        try {
            return ZonedDateTime.parse(normalizedDate).toLocalDate();
        } catch (DateTimeParseException ignored) {
            // Try the next supported date-time representation.
        }

        try {
            return LocalDateTime.parse(normalizedDate).toLocalDate();
        } catch (DateTimeParseException exception) {
            throw new NepaliDateException(
                    "Invalid English date format: " + originalDate +
                            ". Expected yyyy-MM-dd, yyyy/MM/dd, or an ISO date-time value.",
                    exception
            );
        }
    }

    private static NepaliDate moveNepaliDate(NepaliDate startDate, long daysToMove) {
        int year = startDate.getYear();
        int month = startDate.getMonth();
        int day = startDate.getDay();

        if (daysToMove > 0) {
            while (daysToMove > 0) {
                day++;

                int daysInCurrentMonth = NepaliCalendarData.getDaysInMonth(year, month);

                if (day > daysInCurrentMonth) {
                    day = 1;
                    month++;

                    if (month > 12) {
                        month = 1;
                        year++;
                    }
                }

                daysToMove--;
            }
        } else {
            while (daysToMove < 0) {
                day--;

                if (day < 1) {
                    month--;

                    if (month < 1) {
                        month = 12;
                        year--;
                    }

                    day = NepaliCalendarData.getDaysInMonth(year, month);
                }

                daysToMove++;
            }
        }

        return NepaliDate.of(year, month, day);
    }

    private static long daysBetweenNepaliDates(NepaliDate startDate, NepaliDate targetDate) {
        if (startDate.equals(targetDate)) {
            return 0;
        }

        if (startDate.compareTo(targetDate) < 0) {
            return countDaysForward(startDate, targetDate);
        }

        return -countDaysForward(targetDate, startDate);
    }

    private static long countDaysForward(NepaliDate startDate, NepaliDate targetDate) {
        int year = startDate.getYear();
        int month = startDate.getMonth();
        int day = startDate.getDay();

        long days = 0;

        while (!isSameDate(year, month, day, targetDate)) {
            day++;

            int daysInCurrentMonth = NepaliCalendarData.getDaysInMonth(year, month);

            if (day > daysInCurrentMonth) {
                day = 1;
                month++;

                if (month > 12) {
                    month = 1;
                    year++;
                }
            }

            days++;
        }

        return days;
    }

    private static boolean isSameDate(int year, int month, int day, NepaliDate targetDate) {
        return year == targetDate.getYear()
                && month == targetDate.getMonth()
                && day == targetDate.getDay();
    }
}
