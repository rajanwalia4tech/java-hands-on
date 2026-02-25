package designpatterns.creational.factory.document_export_service;

/*
Let's build a complete example in a different domain to show the pattern's versatility.
We will create a document export system that generates reports in
multiple formats: PDF, HTML, and CSV.

Problem
A reporting service needs to export data in different formats. Each format has its own
rendering logic, headers, and file structure. New formats (Markdown, XML, Excel) might be
added in the future.
 */


public class DocumentExportDemo {
    public static void main(String[] args) {
        String [][]data = new String[][]{
                {"Rajan","12"},
                {"Mukul","11"}
        };

        ExportCreator pdfExporter = new PdfExporter();
        pdfExporter.export(data);

        ExportCreator htmlExporter = new HtmlExporter();
        htmlExporter.export(data);

        ExportCreator csvExporter = new CsvExporter();
        csvExporter.export(data);

    }
}
