import java.util.*;

interface DataExporter {
    void export();
    default void exportToJSON() {
        System.out.println("Exporting data in JSON format (default)");
    }
}

class CSVExporter implements DataExporter {
    public void export() {
        System.out.println("Exporting data as CSV");
    }
}

class PDFExporter implements DataExporter {
    public void export() {
        System.out.println("Exporting data as PDF");
    }
}

class dataExport {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String type = s.nextLine();
        DataExporter exporter;
        if (type.equalsIgnoreCase("csv")) exporter = new CSVExporter();
        else exporter = new PDFExporter();
        exporter.export();
        exporter.exportToJSON();
    }
}
