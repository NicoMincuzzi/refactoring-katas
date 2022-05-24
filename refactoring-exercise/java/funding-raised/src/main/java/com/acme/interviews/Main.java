package com.acme.interviews;

import com.acme.interviews.csv.Csv;
import com.acme.interviews.csv.CsvField;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            CsvField round = new CsvField("a", 9);
            CsvField companyName = new CsvField("Facebook", 1);
            System.out.print(new FundingRaised(new Csv("startup_funding.csv")).where(companyName, round).size());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}
