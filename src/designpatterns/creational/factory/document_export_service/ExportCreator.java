package designpatterns.creational.factory.document_export_service;

// Abstract Creator
abstract class ExportCreator {

    // Factory Method
    public abstract Document createDocument();

    // Shared export logic
    public boolean export(String[][] data) {
        Document doc = createDocument();
        System.out.println("Exporting to " + doc.getFileExtension() + " format...");

        String header = doc.getHeader();
        if (!header.isEmpty()) {
            System.out.println(header);
        }

        for (String[] row : data) {
            System.out.println(doc.formatRow(row));
        }

        String footer = doc.getFooter();
        if (!footer.isEmpty()) {
            System.out.println(footer);
        }

        System.out.println("Export complete.\n");
        return false;
    }
}

// Concrete Creators
class PdfExporter extends ExportCreator {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class CsvExporter extends ExportCreator{
    @Override
    public Document createDocument() {
        return new CsvDocument();
    }
}

class HtmlExporter extends ExportCreator{
    @Override
    public Document createDocument() {
        return new HtmlDocument();
    }
}
