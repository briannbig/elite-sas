package elite.sas.core.files;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.AttachmentWeek;
import elite.sas.core.entities.Log;
import elite.sas.core.util.TimeUtil;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LogBookGenerator extends PdfGenerator<Attachment> {

    Document pdDocument;
    Font defaultFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);

    String fileOutputPath = "";

    @Override
    String getFileOutputPath() {
        return fileOutputPath;
    }

    @Override
    public Document generate(Attachment attachment) {
        fileOutputPath = attachment.getStudent().getAdmissionNumber() + ".pdf";
        pdDocument = defaultDocument();
        addTitle(pdDocument, "Log book - " + attachment.getStudent().getAdmissionNumber());

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(pdDocument, pdfFileOutputStream());

            pdDocument.open();
            pdDocument.newPage();

            createCoverPage(attachment);

            pdDocument.newPage();

            if (attachment.getAttachmentWeeks() == null) {
                Paragraph paragraph = new Paragraph("No attachment weeks found");
                pdDocument.add(paragraph);
            }

            attachment.getAttachmentWeeks().forEach(aw -> {
                pdDocument.add(createWeekTable(aw));
                pdDocument.newPage();

                createWeeklyComments(aw);
            });

            pdDocument.close();

            return pdDocument;


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createWeeklyComments(AttachmentWeek attachmentWeek) {

        Paragraph paragraph = new Paragraph("Student comments");
        defaultFont.setSize(30);
        paragraph.setFont(defaultFont);
        pdDocument.add(paragraph);

        if (attachmentWeek.getStudentComment() == null) {
            paragraph = new Paragraph("No comments");
        } else {
            paragraph = new Paragraph(attachmentWeek.getStudentComment());
        }
        defaultFont.setSize(18);
        paragraph.setFont(defaultFont);
        pdDocument.add(paragraph);

        paragraph = new Paragraph("Industry Supervisor comments");
        defaultFont.setSize(30);
        paragraph.setFont(defaultFont);
        paragraph.add(paragraph);
        pdDocument.add(paragraph);

        if (attachmentWeek.getIndustrySupervisorComment() == null) {
            paragraph = new Paragraph("No comments");
        } else {
            paragraph = new Paragraph(attachmentWeek.getIndustrySupervisorComment());
        }
        defaultFont.setSize(18);
        paragraph.setFont(defaultFont);
        paragraph.add(paragraph);
        pdDocument.add(paragraph);

        paragraph = new Paragraph("School Supervisor comments");
        defaultFont.setSize(30);
        paragraph.setFont(defaultFont);
        paragraph.add(paragraph);
        pdDocument.add(paragraph);

        if (attachmentWeek.getSchoolSupervisorComment() == null) {
            paragraph = new Paragraph("No comments");
        } else {
            paragraph = new Paragraph(attachmentWeek.getSchoolSupervisorComment());
        }
        defaultFont.setSize(18);
        paragraph.setFont(defaultFont);
        paragraph.add(paragraph);

    }

    void createCoverPage(Attachment attachment) {
        Paragraph paragraph = new Paragraph(attachment.getStudent().getAdmissionNumber());
        pdDocument.add(paragraph);


    }

    PdfPTable createWeekTable(AttachmentWeek attachmentWeek) {

        PdfPTable table = new PdfPTable(3);
        table.setExtendLastRow(false);
        table.setHeaderRows(3);
        table.setKeepTogether(true);

        PdfPCell headerCell = new PdfPCell(new Paragraph("Day & Date"));
        headerCell.setBackgroundColor(new Color(0, 0, 0));
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("Description of work done"));
        headerCell.setBackgroundColor(new Color(0, 0, 0));
        table.addCell(headerCell);

        headerCell = new PdfPCell(new Paragraph("Industry Supervisor comment"));
        headerCell.setBackgroundColor(new Color(0, 0, 0));
        table.addCell(headerCell);

        if (attachmentWeek.getLogs() == null) {
            Paragraph paragraph = new Paragraph("No daily logs found");
            pdDocument.add(paragraph);
        }

        attachmentWeek.getLogs().forEach(
                log -> insertLogToTable(table, log));

        return table;

    }

    private void insertLogToTable(PdfPTable table, Log log) {

        table.addCell(TimeUtil.formartedDate(log.getCreatedAt()));
        table.addCell(log.getWorkDone());
        table.addCell(log.getIndustrySupervisorComment());


    }
}
