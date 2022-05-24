package com.acme.interviews;

import com.acme.interviews.csv.Csv;
import com.acme.interviews.csv.CsvField;
import com.acme.interviews.csv.Field;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class FundingRaisedTest extends TestCase {

    private final FundingRaised fundingRaised = new FundingRaised(new Csv("startup_funding.csv"));


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FundingRaisedTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(FundingRaisedTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testWhereGivenCompany() {
        try {
            CsvField companyName = new CsvField("Facebook", 1);
            assertEquals(fundingRaised.where(companyName).size(), 7);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenCity() {
        try {
            CsvField city = new CsvField("Tempe", 4);
            assertEquals(fundingRaised.where(city).size(), 3);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenState() {
        try {
            CsvField state = new CsvField("CA", 5);
            assertEquals(fundingRaised.where(state).size(), 873);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereGivenRound() {
        try {
            CsvField round = new CsvField("a", 9);
            assertEquals(fundingRaised.where(round).size(), 582);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testMultipleOptions() {
        try {
            CsvField round = new CsvField("a", 9);
            CsvField companyName = new CsvField("Facebook", 1);
            assertEquals(fundingRaised.where(round, companyName).size(), 1);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereNotExists() {
        try {
            CsvField companyName = new CsvField("NotFacebook", 1);
            assertEquals(fundingRaised.where(companyName).size(), 0);
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testWhereCorrectKeys() {
        try {
            CsvField companyName = new CsvField("Facebook", 1);
            Map<String, Field> row = fundingRaised.where(companyName).get(0);

            assertEquals(row.get("permalink"), new CsvField("facebook", -1));
            assertEquals(row.get("company_name"), new CsvField("Facebook", 1));
            assertEquals(row.get("number_employees"), new CsvField("450", -1));
            assertEquals(row.get("category"), new CsvField("web", -1));
            assertEquals(row.get("city"), new CsvField("Palo Alto", 4));
            assertEquals(row.get("state"), new CsvField("CA", 5));
            assertEquals(row.get("funded_date"), new CsvField("1-Sep-04", -1));
            assertEquals(row.get("raised_amount"), new CsvField("500000", -1));
            assertEquals(row.get("round"), new CsvField("angel", 9));
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByGivenCompanyName() {
        try {
            CsvField companyName = new CsvField("Facebook", 1);
            Filter filter = new Filter(companyName, null, null, null);
            Map<String, Field> row = fundingRaised.findBy(filter);

            assertEquals(row.get("permalink"), new CsvField("facebook", -1));
            assertEquals(row.get("company_name"), new CsvField("Facebook", 1));
            assertEquals(row.get("number_employees"), new CsvField("450", -1));
            assertEquals(row.get("category"), new CsvField("web", -1));
            assertEquals(row.get("city"), new CsvField("Palo Alto", 4));
            assertEquals(row.get("state"), new CsvField("CA", 5));
            assertEquals(row.get("funded_date"), new CsvField("1-Sep-04", -1));
            assertEquals(row.get("raised_amount"), new CsvField("500000", -1));
            assertEquals(row.get("round"), new CsvField("angel", 9));
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByGivenState() {
        try {
            CsvField state = new CsvField("CA", 5);
            Filter filter = new Filter(null, null, state, null);
            Map<String, Field> row = fundingRaised.findBy(filter);

            assertEquals(row.get("permalink"), new CsvField("digg", -1));
            assertEquals(row.get("company_name"), new CsvField("Digg", 1));
            assertEquals(row.get("number_employees"), new CsvField("60", -1));
            assertEquals(row.get("category"), new CsvField("web", -1));
            assertEquals(row.get("city"), new CsvField("San Francisco", 4));
            assertEquals(row.get("state"), new CsvField("CA", 5));
            assertEquals(row.get("funded_date"), new CsvField("1-Dec-06", -1));
            assertEquals(row.get("raised_amount"), new CsvField("8500000", -1));
            assertEquals(row.get("round"), new CsvField("b", 9));
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByMultipleOptions() {
        try {
            CsvField companyName = new CsvField("Facebook", 1);
            CsvField round = new CsvField("c", 9);
            Filter filter = new Filter(companyName, null, null, round);
            Map<String, Field> row = fundingRaised.findBy(filter);

            assertEquals(row.get("permalink"), new CsvField("facebook", -1));
            assertEquals(row.get("company_name"), new CsvField("Facebook", 1));
            assertEquals(row.get("number_employees"), new CsvField("450", -1));
            assertEquals(row.get("category"), new CsvField("web", -1));
            assertEquals(row.get("city"), new CsvField("Palo Alto", 4));
            assertEquals(row.get("state"), new CsvField("CA", 5));
            assertEquals(row.get("funded_date"), new CsvField("1-Oct-07", -1));
            assertEquals(row.get("raised_amount"), new CsvField("300000000", -1));
            assertEquals(row.get("round"), new CsvField("c", 9));
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

    public void testFindByNotExists() {
        try {
            CsvField companyName = new CsvField("Facebook", 1);
            CsvField round = new CsvField("c", 9);
            Filter filter = new Filter(companyName, null, null, round);
            Map<String, Field> row = fundingRaised.findBy(filter);
            fail("findBy should throw exception");
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        } catch (NoSuchEntryException e) {
        }
    }
}
