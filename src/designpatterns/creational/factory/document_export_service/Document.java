package designpatterns.creational.factory.document_export_service;

// product interface
public interface Document {
    String getHeader();
    String formatRow(String[] data);
    String getFooter();
    String getFileExtension();
}

// concrete products
class PdfDocument implements Document{

    @Override
    public String getHeader() {
        return "----- PDF START FROM HERE -----";
    }

    @Override
    public String formatRow(String[] data) {
        return "| " + String.join("| ", data) + " |";
    }

    @Override
    public String getFooter() {
        return "----- PDF END HERE -----";
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}



class CsvDocument implements Document{

    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public String formatRow(String[] data) {
        return String.join(",",data);
    }

    @Override
    public String getFooter() {
        return "";
    }

    @Override
    public String getFileExtension() {
        return ".csv";
    }
}


class HtmlDocument implements Document{

    @Override
    public String getHeader() {
        return "<html><body><table>";
    }

    @Override
    public String formatRow(String[] data) {
        StringBuilder sb = new StringBuilder("<tr>");
        for (String cell : data) {
            sb.append("<td>").append(cell).append("</td>");
        }
        sb.append("</tr>");
        return sb.toString();
    }

    @Override
    public String getFooter() {
        return "</table></body></html>";
    }

    @Override
    public String getFileExtension() {
        return ".html";
    }
}
