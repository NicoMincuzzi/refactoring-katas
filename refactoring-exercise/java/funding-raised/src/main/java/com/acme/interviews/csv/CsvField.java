package com.acme.interviews.csv;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class CsvField implements Field{
    private final String name;
    private final int csvColumn;

    public CsvField(String name, int csvColumn) {
        this.name = name;
        this.csvColumn = csvColumn;
    }

    @Override
    public List<String[]> applyFilter(List<String[]> csvData) {
        return csvData.stream().filter(csvDatum -> csvDatum[csvColumn].equals(name)).collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CsvField csvField = (CsvField) o;
        return Objects.equals(name, csvField.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
