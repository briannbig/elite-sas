package elite.sas.api.server;

import elite.sas.api.ApiUtil;
import elite.sas.api.exceptions.ModelConversionException;
import elite.sas.api.exceptions.UnRetriableException;
import elite.sas.api.grpc.CommonsProto;
import elite.sas.api.grpc.InternshipServiceProto;
import elite.sas.api.grpc.internshipServiceGrpc;
import elite.sas.core.entities.Attachment;
import elite.sas.core.entities.Log;
import elite.sas.core.service.AttachmentService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static elite.sas.api.ApiUtil.*;


@Slf4j
@RequiredArgsConstructor
public class InternshipService extends internshipServiceGrpc.internshipServiceImplBase {

    private final AttachmentService attachmentService;

    @Override
    public void addAttachment(InternshipServiceProto.Attachment request, StreamObserver<InternshipServiceProto.Attachment> responseObserver) {

        super.addAttachment(request, responseObserver);
    }

    @Override
    public void getAllAttachments(CommonsProto.Empty request, StreamObserver<InternshipServiceProto.Attachment> responseObserver) {
        attachmentService.getAllAttachments().forEach(attachment -> {
            try {
                responseObserver.onNext(attachmentToApi(attachment));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            }
        });

        responseObserver.onCompleted();

    }

    @Override
    public void getAttachment(InternshipServiceProto.SearchAttachmentParams request, StreamObserver<InternshipServiceProto.Attachment> responseObserver) {
        if (Objects.nonNull(request.getId()) && !request.getId().isEmpty()) {
            Optional<Attachment> optionalAttachment = attachmentService.getAttachmentById(request.getId());
            if (optionalAttachment.isEmpty()) {
                log.debug("Could not find internship with id: {}", request.getId());
                var e = new UnRetriableException("Could not find internship with given id");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
                return;
            }
            try {
                responseObserver.onNext(attachmentToApi(optionalAttachment.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                return;
            }

            responseObserver.onCompleted();
            return;
        }

        if (Objects.nonNull(request.getStudentId()) && !request.getStudentId().isEmpty()) {
            Optional<Attachment> optionalAttachment = attachmentService.getAttachmentByStudentId(request.getStudentId());
            if (optionalAttachment.isEmpty()) {
                log.debug("Could not find internship for student with id: {}", request.getStudentId());
                var e = new UnRetriableException("Could not find internship with given id");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
                return;
            }
            try {
                responseObserver.onNext(attachmentToApi(optionalAttachment.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.NOT_FOUND.INTERNAL.withCause(e).asRuntimeException());
                return;
            }

            responseObserver.onCompleted();
            return;
        }


        if (Objects.nonNull(request.getStudentAdmissionNumber()) && !request.getStudentAdmissionNumber().isEmpty()) {
            Optional<Attachment> optionalAttachment = attachmentService.getAttachmentByStudentAdmissionNumber(request.getStudentAdmissionNumber());
            if (optionalAttachment.isEmpty()) {
                log.debug("Could not find internship for student with admission: {}", request.getStudentAdmissionNumber());
                var e = new UnRetriableException("Could not find internship for student with given admission number");
                responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
                return;
            }
            try {
                responseObserver.onNext(attachmentToApi(optionalAttachment.get()));
            } catch (ModelConversionException e) {
                log.debug("Conversion error: {}", e);
                responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                return;
            }

            responseObserver.onCompleted();
            return;
        }
    }

    @Override
    public void getAttachments(InternshipServiceProto.SearchAttachmentParams request, StreamObserver<InternshipServiceProto.Attachment> responseObserver) {
        if (Objects.nonNull(request.getCompanyId()) && !request.getCompanyId().isEmpty()) {
            attachmentService.getAllAttachmentsAtCompany(request.getCompanyId()).forEach(attachment -> {
                try {
                    responseObserver.onNext(attachmentToApi(attachment));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            });
        }

        if (Objects.nonNull(request.getSchoolId()) && !request.getSchoolId().isEmpty()) {
            attachmentService.getAllAttachmentsFromSchool(request.getSchoolId()).forEach(attachment -> {
                try {
                    responseObserver.onNext(attachmentToApi(attachment));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            });
        }

        if (Objects.nonNull(request.getAttachmentPeriod())) {
            attachmentService.getAllAttachmentsForPeriod(attachmentPeriodFromApi(request.getAttachmentPeriod())).forEach(attachment -> {
                try {
                    responseObserver.onNext(attachmentToApi(attachment));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            });
        }

        if (Objects.nonNull(request.getIndustrySupervisorId()) && !request.getIndustrySupervisorId().isEmpty()) {
            attachmentService.getAllAttachmentsForIndustrySupervisor(request.getIndustrySupervisorId()).forEach(attachment -> {
                try {
                    responseObserver.onNext(attachmentToApi(attachment));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            });
        }

        if (Objects.nonNull(request.getSchoolSupervisorId()) && !request.getIndustrySupervisorId().isEmpty()) {
            attachmentService.getAllAttachmentsForSchoolSupervisor(request.getSchoolSupervisorId()).forEach(attachment -> {
                try {
                    responseObserver.onNext(attachmentToApi(attachment));
                } catch (ModelConversionException e) {
                    log.debug("Conversion error: {}", e);
                    responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
                }
            });
        }


        responseObserver.onCompleted();
    }

    @Override
    public void addLog(InternshipServiceProto.Log request, StreamObserver<InternshipServiceProto.Log> responseObserver) {
        if (Objects.isNull(request.getWorkDone()) || request.getWorkDone().isEmpty() || request.getAttachmentWeekId().isEmpty()) {
            log.debug("attempted to add an empty daily log or missing attachmentWeekId, request: {}", request);
            var e = new UnRetriableException("Work done and attachment week cannot be empty");
            responseObserver.onError(Status.INVALID_ARGUMENT.withCause(e).asRuntimeException());
            return;
        }


        var optionalAttachment = attachmentService.getAttachmentWeekById(request.getAttachmentWeekId());

        if (optionalAttachment.isEmpty()) {
            log.debug("attachment week with id: {} not found");
            var e = new UnRetriableException("Attachment week with given id not found");
            responseObserver.onError(Status.NOT_FOUND.withCause(e).asRuntimeException());
            return;
        }

        Log.LogBuilder logBuilder = Log.builder()
                .attachmentWeek(optionalAttachment.get())
                .workDone(request.getWorkDone());

        if (Objects.nonNull(request.getSchoolSupervisorComment())) {
            logBuilder.schoolSupervisorComment(request.getSchoolSupervisorComment());
        }

        if (Objects.nonNull(request.getIndustrySupervisorComment())) {
            logBuilder.industrySupervisorComment(request.getIndustrySupervisorComment());
        }

        Optional<Log> optionalLog = attachmentService.addLog(logBuilder.build());

        if (optionalLog.isEmpty()) {
            log.debug("daily log could not be added to database");
            var e = new UnRetriableException("Daily log could not be saved");
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            return;
        }

        try {
            responseObserver.onNext(logToApi(optionalLog.get()));
        } catch (ModelConversionException e) {
            log.debug("conversion error: {}", e);
            responseObserver.onError(Status.INTERNAL.withCause(e).asRuntimeException());
            return;
        }

        responseObserver.onCompleted();

    }

    @Override
    public void addAttachmentWeek(InternshipServiceProto.AttachmentWeek request, StreamObserver<InternshipServiceProto.AttachmentWeek> responseObserver) {
        // TODO: 4/16/23 note that attachment weeks generation should be automatically instantiated by quartz hence this method not required, updating is required instead
        super.addAttachmentWeek(request, responseObserver);
    }
}
