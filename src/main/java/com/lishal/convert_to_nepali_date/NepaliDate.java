package com.lishal.convert_to_nepali_date;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NepaliDate implements Comparable<NepaliDate>, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{4})[-/](\\d{1,2})[-/](\\d{1,2})$");

    private final int year;
    private final int month;
    private final int day;

    private NepaliDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new NepaliDateException("Invalid Nepali month: " + month);
        }

        if (day < 1 || day > 32) {
            throw new NepaliDateException("Invalid Nepali day: " + day);
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static NepaliDate of(int year, int month, int day) {
        return new NepaliDate(year, month, day);
    }

    public static NepaliDate parse(String value) {
        Objects.requireNonNull(value, "value must not be null");

        Matcher matcher = DATE_PATTERN.matcher(value.trim());

        if (!matcher.matches()) {
            throw new NepaliDateException(
                    "Invalid Nepali date format: " + value + ". Expected yyyy-MM-dd or yyyy/MM/dd."
            );
        }

        try {
            int year = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int day = Integer.parseInt(matcher.group(3));

            NepaliDate nepaliDate = of(year, month, day);
            NepaliDateConverter.validate(nepaliDate);

            return nepaliDate;
        } catch (NumberFormatException exception) {
            throw new NepaliDateException("Invalid Nepali date value: " + value, exception);
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public NepaliMonth getNepaliMonth() {
        return NepaliMonth.of(month);
    }

    public String getMonthName() {
        return NepaliMonth.getDisplayName(month);
    }

    public int getDay() {
        return day;
    }

    public String format() {
        return String.format(Locale.ROOT, "%04d-%02d-%02d", year, month, day);
    }

    public String formatWithMonthName() {
        return String.format(Locale.ROOT, "%04d %s %02d", year, getMonthName(), day);
    }

    @Override
    public int compareTo(NepaliDate other) {
        Objects.requireNonNull(other, "other must not be null");

        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }

        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }

        return Integer.compare(this.day, other.day);
    }

    @Override
    public String toString() {
        return format();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof NepaliDate)) {
            return false;
        }

        NepaliDate that = (NepaliDate) object;

        return year == that.year
                && month == that.month
                && day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
