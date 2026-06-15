package com.lishal.convert_to_nepali_date;
import java.util.Arrays;

public enum NepaliMonth {

    BAISAKH(1, "Baisakh"),
    JESTHA(2, "Jestha"),
    ASHAR(3, "Ashar"),
    SHRAWAN(4, "Shrawan"),
    BHADRA(5, "Bhadra"),
    ASHOJ(6, "Ashoj"),
    KARTIK(7, "Kartik"),
    MANGSIR(8, "Mangsir"),
    POUSH(9, "Poush"),
    MAGH(10, "Magh"),
    FALGUN(11, "Falgun"),
    CHAITRA(12, "Chaitra");

    private final int value;
    private final String displayName;

    NepaliMonth(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static NepaliMonth of(int month) {
        return Arrays.stream(values())
                .filter(nepaliMonth -> nepaliMonth.value == month)
                .findFirst()
                .orElseThrow(() -> new NepaliDateException("Invalid Nepali month: " + month));
    }

    public static String getDisplayName(int month) {
        return of(month).getDisplayName();
    }
}