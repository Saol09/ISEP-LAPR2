package app.domain.model;

import app.domain.utils.SaveDate;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;


public class DiagnosisReport {

    private String report;
    private String diagnosedDate;


    public DiagnosisReport(String report) {
        checkReport(report);
        this.report = report;
        this.diagnosedDate = SaveDate.dataCreation();
    }

    public void setDiagnosedDate(String diagnosedDate) {
        this.diagnosedDate = diagnosedDate;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        checkReport(report);
        this.report = report;
    }

    public String getDiagnosedDate() {
        return diagnosedDate;
    }

    private void checkReport(String report) {
        if (StringUtils.isBlank(report))
            throw new IllegalArgumentException("The report cannot be blank.");
        if (report.equals("^\\W*(?:\\w+\\b\\W*){1,400}$"))
            throw new IllegalArgumentException("The report cannot have more than 400 words");
    }

    @Override
    public String toString() {
        return "DiagnosisReport:" + '\'' + (report) + '\'' +
                "DiagnosedDate='" + diagnosedDate;
    }
}
