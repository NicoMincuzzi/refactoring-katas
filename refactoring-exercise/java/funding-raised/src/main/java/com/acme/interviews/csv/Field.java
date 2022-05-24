package com.acme.interviews.csv;

import java.util.List;
import java.util.Map;

public interface Field {
    List<String[]> applyFilter(List<String[]> csvData);
}
