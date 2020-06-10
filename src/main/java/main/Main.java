package main;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            wordDocProcessor("D:/test/kek.docx","D:/test/");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
    public static void wordDocProcessor(String source, String destination) throws IOException, InvalidFormatException {
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(source));
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null
                                    && text.contains("Секция 2.6 от 01.05.2020г.")) {
                                text = text.replace("Секция 2.6 от 01.05.2020г.",
                                        "Секция 2.6 от 02.07.2020г.");
                                r.setText(text, 0);
                            }
                        }
                    }
                }
            }
        }
        doc.write(new FileOutputStream(destination
                + "_TestReport_URL_Document.doc"));
    }
}
