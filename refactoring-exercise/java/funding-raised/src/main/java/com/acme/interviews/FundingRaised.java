package com.acme.interviews;

import com.acme.interviews.csv.Csv;
import com.acme.interviews.csv.Field;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class FundingRaised {
    private final Csv csv;

    public FundingRaised(Csv csv) {
        this.csv = csv;
    }

    public List<Map<String, Field>> where(Field... fields) throws IOException {
        List<String[]> csvData = csv.retrieveCsvRows();

        for (Field field : fields) {
            csvData = field.applyFilter(csvData);
        }

        return csvData.stream().map(csv::outputRow).collect(toList());
    }

    public Map<String, Field> findBy(Filter filter) throws IOException, NoSuchEntryException {
        List<String[]> csvData = csv.retrieveCsvRows();
        for (String[] csvDatum : csvData) {
            if (!filter.hasCompany() || !filter.isSameCompany(csvDatum)) continue;
            if (!filter.hasCity() || !filter.isSameCity(csvDatum)) continue;
            if (!filter.hasState() || !filter.isSameState(csvDatum)) continue;
            if (!filter.hasRound() || !filter.isSameRound(csvDatum)) continue;

            return csv.outputRow(csvDatum);
        }
        throw new NoSuchEntryException();
    }
}
