package com.lishal.convert_to_nepali_date;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class NepaliCalendarData {

    private static final Map<Integer, int[]> MONTH_DAYS_BY_YEAR = createCalendarData();

    private NepaliCalendarData() {
        throw new AssertionError("Utility class should not be instantiated");
    }
    private static Map<Integer, int[]> createCalendarData() {
        Map<Integer, int[]> data = new HashMap<>();

        data.put(1970, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1971, new int[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});
        data.put(1972, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(1973, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(1974, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1975, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(1976, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(1977, new int[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31});
        data.put(1978, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1979, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});

        data.put(1980, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(1981, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(1982, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1983, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(1984, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(1985, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(1986, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1987, new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(1988, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(1989, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});

        data.put(1990, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1991, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(1992, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(1993, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1994, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1995, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(1996, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(1997, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1998, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(1999, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});

        data.put(2000, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2001, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2002, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2003, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2004, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2005, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2006, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2007, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2008, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        data.put(2009, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});

        data.put(2010, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2011, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2012, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(2013, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2014, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2015, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2016, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(2017, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2018, new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2019, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});

        data.put(2020, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2021, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2022, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(2023, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2024, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2025, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2026, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2027, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2028, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2029, new int[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});

        data.put(2030, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2031, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2032, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2033, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2034, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2035, new int[]{30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        data.put(2036, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2037, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2038, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2039, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});

        data.put(2040, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2041, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2042, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2043, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(2044, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2045, new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2046, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2047, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2048, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2049, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});

        data.put(2050, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2051, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2052, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2053, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(2054, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2055, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2056, new int[]{31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30});
        data.put(2057, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2058, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2059, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});

        data.put(2060, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2061, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2062, new int[]{30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31});
        data.put(2063, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2064, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2065, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2066, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31});
        data.put(2067, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2068, new int[]{31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2069, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});

        data.put(2070, new int[]{31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30});
        data.put(2071, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2072, new int[]{31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2073, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31});
        data.put(2074, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2075, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2076, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(2077, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2078, new int[]{31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2079, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});

        data.put(2080, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30});
        data.put(2081, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31});
        data.put(2082, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2083, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30});
        data.put(2084, new int[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2085, new int[]{31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30});
        data.put(2086, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2087, new int[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30});
        data.put(2088, new int[]{30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30});
        data.put(2089, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});

        data.put(2090, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2091, new int[]{31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30});
        data.put(2092, new int[]{30, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2093, new int[]{30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2094, new int[]{31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2095, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 30, 30, 30, 30});
        data.put(2096, new int[]{30, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30});
        data.put(2097, new int[]{31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30});
        data.put(2098, new int[]{31, 31, 32, 31, 31, 31, 29, 30, 29, 30, 29, 31});
        data.put(2099, new int[]{31, 31, 32, 31, 31, 31, 30, 29, 29, 30, 30, 30});

        data.put(2100, new int[]{31, 32, 31, 32, 30, 31, 30, 29, 30, 29, 30, 30});

        validateCalendarData(data);

        return Collections.unmodifiableMap(data);
    }


    static int getDaysInMonth(int year, int month) {
        validateMonth(month);

        int[] monthDays = MONTH_DAYS_BY_YEAR.get(year);

        if (monthDays == null) {
            throw new NepaliDateException(
                    "Unsupported Nepali year: " + year +
                            ". Supported range is " + getMinimumSupportedYear() +
                            " to " + getMaximumSupportedYear() + "."
            );
        }

        return monthDays[month - 1];
    }

    static boolean isSupportedYear(int year) {
        return MONTH_DAYS_BY_YEAR.containsKey(year);
    }

    static int getMinimumSupportedYear() {
        return MONTH_DAYS_BY_YEAR.keySet()
                .stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new NepaliDateException("No Nepali calendar data found"));
    }

    static int getMaximumSupportedYear() {
        return MONTH_DAYS_BY_YEAR.keySet()
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NepaliDateException("No Nepali calendar data found"));
    }

    private static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new NepaliDateException("Invalid Nepali month: " + month);
        }
    }

    private static void validateCalendarData(Map<Integer, int[]> data) {
        if (data.isEmpty()) {
            throw new NepaliDateException("Nepali calendar data cannot be empty");
        }

        for (Map.Entry<Integer, int[]> entry : data.entrySet()) {
            int year = entry.getKey();
            int[] monthDays = entry.getValue();

            if (monthDays == null || monthDays.length != 12) {
                throw new NepaliDateException(
                        "Invalid calendar data for year " + year +
                                ". Each year must have exactly 12 month values."
                );
            }

            for (int i = 0; i < monthDays.length; i++) {
                int days = monthDays[i];

                if (days < 29 || days > 32) {
                    throw new NepaliDateException(
                            "Invalid day count " + days +
                                    " for year " + year +
                                    ", month " + (i + 1)
                    );
                }
            }
        }
    }
}