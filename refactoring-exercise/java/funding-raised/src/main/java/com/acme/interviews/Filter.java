package com.acme.interviews;

import com.acme.interviews.csv.CsvField;

public class Filter {
    private final CsvField companyName;
    private final CsvField city;
    private final CsvField state;
    private final CsvField round;

    public Filter(CsvField companyName, CsvField city, CsvField state, CsvField round) {
        this.companyName = companyName;
        this.city = city;
        this.state = state;
        this.round = round;
    }

    public boolean isSameCompany(String[] csvDatum) {
        return new CsvField(csvDatum[1], 1).equals(companyName);
    }

    public boolean isSameCity(String[] csvDatum) {
        return new CsvField(csvDatum[4], 4).equals(city);
    }

    public boolean isSameState(String[] csvDatum) {
        return new CsvField(csvDatum[5], 5).equals(state);
    }

    public boolean isSameRound(String[] csvDatum) {
        return new CsvField(csvDatum[9], 9).equals(round);
    }

    public boolean hasCompany() {
        return companyName == null;
    }

    public boolean hasCity() {
        return city == null;
    }

    public boolean hasState() {
        return state == null;
    }

    public boolean hasRound() {
        return round == null;
    }
}
