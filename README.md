# Convert To Nepali Date

Java library for converting English AD dates to Nepali Bikram Sambat dates.

```java
NepaliDate nepaliDate = ConvertToNepaliDate.convert("2026-06-15");

System.out.println(nepaliDate.format()); // 2083-03-01
```

## Supported input

Use `ConvertToNepaliDate.convert(...)` when you want the library to detect common Java date inputs automatically:

```java
ConvertToNepaliDate.convert(LocalDate.of(2026, 6, 15));
ConvertToNepaliDate.convert("2026-06-15");
ConvertToNepaliDate.convert("2026/06/15");
ConvertToNepaliDate.convert("2026-06-15T18:30:00");
ConvertToNepaliDate.convert(Instant.now());
ConvertToNepaliDate.convert(new Date());
```

For explicit conversion, use `NepaliDateConverter`:

```java
NepaliDate bsDate = NepaliDateConverter.toNepaliDate(LocalDate.of(2026, 6, 15));
LocalDate adDate = NepaliDateConverter.toEnglishDate(NepaliDate.of(2083, 3, 1));
```

## Validation

```java
NepaliDate date = NepaliDate.parse("2083-03-01");

NepaliDateConverter.validate(date);
boolean valid = NepaliDateConverter.isValid(date);
```

Calendar data is available for Nepali years `1970` through `2100`.

## Build

```bash
./mvnw test
```
