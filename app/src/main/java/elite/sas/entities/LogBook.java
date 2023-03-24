package elite.sas.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Getter @Setter
public class LogBook extends BaseModel {
    @ManyToOne
    private Attachment attachment;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<AttachmentWeek> attachmentWeeks;

    public LogBook() {
    }

    public LogBook(UUID Id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Attachment attachment, List<AttachmentWeek> attachmentWeeks) {
        super(Id, createdAt, updatedAt, deletedAt);
        this.attachment = attachment;
        this.attachmentWeeks = attachmentWeeks;
    }
}
