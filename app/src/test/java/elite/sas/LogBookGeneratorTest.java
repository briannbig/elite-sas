package elite.sas;

import com.lowagie.text.Document;
import elite.sas.core.entities.*;
import elite.sas.core.files.LogBookGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LogBookGeneratorTest {

    @Mock
    private Attachment attachment;
    @Mock
    private Student student;
    @Mock
    private Tenant school;
    @Mock
    private Tenant company;
    @Mock
    private AppUser industrialSupervisor;
    @Mock
    private AppUser schoolSupervisor;
    @Mock
    private List<AttachmentWeek> attachmentWeeks = mock(List.class);
    @Mock
    private List<Log> logList = mock(List.class);


    @BeforeEach
    void setUp() {

        AppUser studentAppUser = mock(AppUser.class);
        lenient().when(studentAppUser.getTenant()).thenReturn(school);

        lenient().when(student.getAppUser()).thenReturn(studentAppUser);
        lenient().when(student.getAdmissionNumber()).thenReturn("ADM-001-TEST");

        lenient().when(company.getName()).thenReturn("Test company ltd");
        lenient().when(school.getName()).thenReturn("Test school college");

        lenient().when(schoolSupervisor.getTenant()).thenReturn(school);
        lenient().when(industrialSupervisor.getTenant()).thenReturn(company);

        Log log1 = mock(Log.class);
        lenient().when(log1.getWorkDone()).thenReturn("did work bla nla bla nla ");
        lenient().when(log1.getCreatedAt()).thenReturn(LocalDateTime.now());

        lenient().when(logList.get(1)).thenReturn(log1);
        lenient().when(logList.get(2)).thenReturn(log1);
        lenient().when(logList.get(3)).thenReturn(log1);
        lenient().when(logList.get(4)).thenReturn(log1);
        lenient().when(logList.get(5)).thenReturn(log1);

        AttachmentWeek attachmentWeek1 = mock(AttachmentWeek.class);
        lenient().when(attachmentWeek1.getLogs()).thenReturn(logList);
        lenient().when(attachmentWeek1.getAttachment()).thenReturn(attachment);
        lenient().when(attachmentWeek1.getLogs()).thenReturn(logList);

        lenient().when(attachmentWeeks.get(1)).thenReturn(attachmentWeek1);
        lenient().when(attachmentWeeks.get(2)).thenReturn(attachmentWeek1);
        lenient().when(attachmentWeeks.get(3)).thenReturn(attachmentWeek1);
        lenient().when(attachmentWeeks.get(4)).thenReturn(attachmentWeek1);
        lenient().when(attachmentWeeks.get(5)).thenReturn(attachmentWeek1);

        lenient().when(attachment.getStudent()).thenReturn(student);
        lenient().when(attachment.getIndustrySupervisor()).thenReturn(industrialSupervisor);
        lenient().when(attachment.getSchoolSupervisor()).thenReturn(schoolSupervisor);

        lenient().when(attachment.getAttachmentWeeks()).thenReturn(attachmentWeeks);

    }


    @Test
    void createspdf() {
        LogBookGenerator logBookGenerator = new LogBookGenerator();

        System.out.println(attachment.toString());
        Document document = logBookGenerator.generate(attachment);


        assertNotNull(document);
    }


}