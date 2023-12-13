package app.domain.model;

import app.domain.utils.SaveDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiagnosisReportTest {


    @Test
    public void getReportTest() {
        DiagnosisReport report = new DiagnosisReport("The Specialist Doctor was already done the report");
        assertEquals("The Specialist Doctor was already done the report", report.getReport());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setReportBlank(){
        DiagnosisReport report = new DiagnosisReport("");
        report.setReport("");
    }
    /*
    @Test(expected = IllegalArgumentException.class)
    public void setReportBigger(){
        DiagnosisReport report = new DiagnosisReport("fasfa");
        report.setReport("a b c d e f g h i j k l m n o p r s t u v x z w a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "a b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z wa b c d e f g h i j k l m n o p r s t u v x z w" +
                "");
    }

     */

    @Test
    public void setReportTest() {
        DiagnosisReport report = new DiagnosisReport("The Specialist Doctor was already done the report");
        report.setReport("The report is done");
        assertEquals(report.getReport(),"The report is done");
    }


    @Test
    public void getDiagnosedDateTest() {
        DiagnosisReport report = new DiagnosisReport("The Specialist Doctor was already done the report");
        assertNotNull(report.getDiagnosedDate());
    }




}