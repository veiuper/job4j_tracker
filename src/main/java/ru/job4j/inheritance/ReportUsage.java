package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        String text;
        TextReport textReport = new TextReport();
        text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);
        HTMLReport htmlReport = new HTMLReport();
        text = htmlReport.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonReport = new JSONReport();
        text = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
