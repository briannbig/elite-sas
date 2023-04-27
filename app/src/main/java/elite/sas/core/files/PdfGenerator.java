package elite.sas.core.files;

import com.lowagie.text.Document;

import com.lowagie.text.PageSize;
import elite.sas.core.entities.BaseModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public abstract class PdfGenerator<T extends BaseModel> {


    abstract String getFileOutputPath();

    abstract Document generate(T model);


    FileOutputStream pdfFileOutputStream() throws IOException {
        var file = new File(getFileOutputPath());
        if (file == null) {
            file.createNewFile();
        }
        return new FileOutputStream(file);
    }

    Document defaultDocument() {
        return new Document(PageSize.A4, 50, 50, 50, 50);
    }

    void addTitle(Document document, String title) {
        document.addTitle(title);
    }


}
