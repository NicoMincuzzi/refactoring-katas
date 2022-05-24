package com.acme.interviews.csv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Csv {
    private final String filename;

    public Csv(String filename) {
        this.filename = filename;
    }

    public List<String[]> retrieveCsvRows() throws IOException {
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] row;

        List<String[]> csvData = new ArrayList<>();
        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);
        return csvData;
    }

    public Map<String, Field> outputRow(String[] csvDatum) {
        Map<String, Field> mapped = new HashMap<>();
        mapped.put("permalink", new CsvField(csvDatum[0], 0));
        mapped.put("company_name", new CsvField(csvDatum[1], 1));
        mapped.put("number_employees", new CsvField(csvDatum[2], 2));
        mapped.put("category", new CsvField(csvDatum[3], 3));
        mapped.put("city", new CsvField(csvDatum[4], 4));
        mapped.put("state", new CsvField(csvDatum[5], 5));
        mapped.put("funded_date", new CsvField(csvDatum[6], 6));
        mapped.put("raised_amount", new CsvField(csvDatum[7], 7));
        mapped.put("raised_currency", new CsvField(csvDatum[8], 8));
        mapped.put("round", new CsvField(csvDatum[9], 9));
        return mapped;
    }
}
