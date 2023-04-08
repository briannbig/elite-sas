package elite.sas.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.0)",
    comments = "Source: internship-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class internshipServiceGrpc {

  private internshipServiceGrpc() {}

  public static final String SERVICE_NAME = "internshipService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Attachment,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getAddAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addAttachment",
      requestType = elite.sas.api.grpc.InternshipServiceProto.Attachment.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.Attachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Attachment,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getAddAttachmentMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Attachment, elite.sas.api.grpc.InternshipServiceProto.Attachment> getAddAttachmentMethod;
    if ((getAddAttachmentMethod = internshipServiceGrpc.getAddAttachmentMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getAddAttachmentMethod = internshipServiceGrpc.getAddAttachmentMethod) == null) {
          internshipServiceGrpc.getAddAttachmentMethod = getAddAttachmentMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.InternshipServiceProto.Attachment, elite.sas.api.grpc.InternshipServiceProto.Attachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Attachment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Attachment.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("addAttachment"))
              .build();
        }
      }
    }
    return getAddAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAllAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllAttachments",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.Attachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAllAttachmentsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAllAttachmentsMethod;
    if ((getGetAllAttachmentsMethod = internshipServiceGrpc.getGetAllAttachmentsMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getGetAllAttachmentsMethod = internshipServiceGrpc.getGetAllAttachmentsMethod) == null) {
          internshipServiceGrpc.getGetAllAttachmentsMethod = getGetAllAttachmentsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.InternshipServiceProto.Attachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllAttachments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Attachment.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("getAllAttachments"))
              .build();
        }
      }
    }
    return getGetAllAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAttachment",
      requestType = elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.Attachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams, elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentMethod;
    if ((getGetAttachmentMethod = internshipServiceGrpc.getGetAttachmentMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getGetAttachmentMethod = internshipServiceGrpc.getGetAttachmentMethod) == null) {
          internshipServiceGrpc.getGetAttachmentMethod = getGetAttachmentMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams, elite.sas.api.grpc.InternshipServiceProto.Attachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Attachment.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("getAttachment"))
              .build();
        }
      }
    }
    return getGetAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAttachments",
      requestType = elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.Attachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
      elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams, elite.sas.api.grpc.InternshipServiceProto.Attachment> getGetAttachmentsMethod;
    if ((getGetAttachmentsMethod = internshipServiceGrpc.getGetAttachmentsMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getGetAttachmentsMethod = internshipServiceGrpc.getGetAttachmentsMethod) == null) {
          internshipServiceGrpc.getGetAttachmentsMethod = getGetAttachmentsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams, elite.sas.api.grpc.InternshipServiceProto.Attachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAttachments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Attachment.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("getAttachments"))
              .build();
        }
      }
    }
    return getGetAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Log,
      elite.sas.api.grpc.InternshipServiceProto.Log> getAddLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addLog",
      requestType = elite.sas.api.grpc.InternshipServiceProto.Log.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.Log.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Log,
      elite.sas.api.grpc.InternshipServiceProto.Log> getAddLogMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.Log, elite.sas.api.grpc.InternshipServiceProto.Log> getAddLogMethod;
    if ((getAddLogMethod = internshipServiceGrpc.getAddLogMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getAddLogMethod = internshipServiceGrpc.getAddLogMethod) == null) {
          internshipServiceGrpc.getAddLogMethod = getAddLogMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.InternshipServiceProto.Log, elite.sas.api.grpc.InternshipServiceProto.Log>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Log.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.Log.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("addLog"))
              .build();
        }
      }
    }
    return getAddLogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek,
      elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> getAddAttachmentWeekMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addAttachmentWeek",
      requestType = elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek.class,
      responseType = elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek,
      elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> getAddAttachmentWeekMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek, elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> getAddAttachmentWeekMethod;
    if ((getAddAttachmentWeekMethod = internshipServiceGrpc.getAddAttachmentWeekMethod) == null) {
      synchronized (internshipServiceGrpc.class) {
        if ((getAddAttachmentWeekMethod = internshipServiceGrpc.getAddAttachmentWeekMethod) == null) {
          internshipServiceGrpc.getAddAttachmentWeekMethod = getAddAttachmentWeekMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek, elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addAttachmentWeek"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek.getDefaultInstance()))
              .setSchemaDescriptor(new internshipServiceMethodDescriptorSupplier("addAttachmentWeek"))
              .build();
        }
      }
    }
    return getAddAttachmentWeekMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static internshipServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<internshipServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<internshipServiceStub>() {
        @java.lang.Override
        public internshipServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new internshipServiceStub(channel, callOptions);
        }
      };
    return internshipServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static internshipServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<internshipServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<internshipServiceBlockingStub>() {
        @java.lang.Override
        public internshipServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new internshipServiceBlockingStub(channel, callOptions);
        }
      };
    return internshipServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static internshipServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<internshipServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<internshipServiceFutureStub>() {
        @java.lang.Override
        public internshipServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new internshipServiceFutureStub(channel, callOptions);
        }
      };
    return internshipServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class internshipServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addAttachment(elite.sas.api.grpc.InternshipServiceProto.Attachment request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddAttachmentMethod(), responseObserver);
    }

    /**
     */
    public void getAllAttachments(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAttachmentsMethod(), responseObserver);
    }

    /**
     */
    public void getAttachment(elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAttachmentMethod(), responseObserver);
    }

    /**
     */
    public void getAttachments(elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAttachmentsMethod(), responseObserver);
    }

    /**
     */
    public void addLog(elite.sas.api.grpc.InternshipServiceProto.Log request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Log> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddLogMethod(), responseObserver);
    }

    /**
     */
    public void addAttachmentWeek(elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddAttachmentWeekMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.InternshipServiceProto.Attachment,
                elite.sas.api.grpc.InternshipServiceProto.Attachment>(
                  this, METHODID_ADD_ATTACHMENT)))
          .addMethod(
            getGetAllAttachmentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CommonsProto.Empty,
                elite.sas.api.grpc.InternshipServiceProto.Attachment>(
                  this, METHODID_GET_ALL_ATTACHMENTS)))
          .addMethod(
            getGetAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
                elite.sas.api.grpc.InternshipServiceProto.Attachment>(
                  this, METHODID_GET_ATTACHMENT)))
          .addMethod(
            getGetAttachmentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams,
                elite.sas.api.grpc.InternshipServiceProto.Attachment>(
                  this, METHODID_GET_ATTACHMENTS)))
          .addMethod(
            getAddLogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.InternshipServiceProto.Log,
                elite.sas.api.grpc.InternshipServiceProto.Log>(
                  this, METHODID_ADD_LOG)))
          .addMethod(
            getAddAttachmentWeekMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek,
                elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek>(
                  this, METHODID_ADD_ATTACHMENT_WEEK)))
          .build();
    }
  }

  /**
   */
  public static final class internshipServiceStub extends io.grpc.stub.AbstractAsyncStub<internshipServiceStub> {
    private internshipServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected internshipServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new internshipServiceStub(channel, callOptions);
    }

    /**
     */
    public void addAttachment(elite.sas.api.grpc.InternshipServiceProto.Attachment request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllAttachments(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllAttachmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAttachment(elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAttachments(elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAttachmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addLog(elite.sas.api.grpc.InternshipServiceProto.Log request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Log> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddLogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addAttachmentWeek(elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAttachmentWeekMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class internshipServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<internshipServiceBlockingStub> {
    private internshipServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected internshipServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new internshipServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public elite.sas.api.grpc.InternshipServiceProto.Attachment addAttachment(elite.sas.api.grpc.InternshipServiceProto.Attachment request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAttachmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.InternshipServiceProto.Attachment> getAllAttachments(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.InternshipServiceProto.Attachment getAttachment(elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttachmentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.InternshipServiceProto.Attachment> getAttachments(
        elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.InternshipServiceProto.Log addLog(elite.sas.api.grpc.InternshipServiceProto.Log request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddLogMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek addAttachmentWeek(elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAttachmentWeekMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class internshipServiceFutureStub extends io.grpc.stub.AbstractFutureStub<internshipServiceFutureStub> {
    private internshipServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected internshipServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new internshipServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.InternshipServiceProto.Attachment> addAttachment(
        elite.sas.api.grpc.InternshipServiceProto.Attachment request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAttachmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.InternshipServiceProto.Attachment> getAttachment(
        elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttachmentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.InternshipServiceProto.Log> addLog(
        elite.sas.api.grpc.InternshipServiceProto.Log request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddLogMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek> addAttachmentWeek(
        elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAttachmentWeekMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_ATTACHMENT = 0;
  private static final int METHODID_GET_ALL_ATTACHMENTS = 1;
  private static final int METHODID_GET_ATTACHMENT = 2;
  private static final int METHODID_GET_ATTACHMENTS = 3;
  private static final int METHODID_ADD_LOG = 4;
  private static final int METHODID_ADD_ATTACHMENT_WEEK = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final internshipServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(internshipServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_ATTACHMENT:
          serviceImpl.addAttachment((elite.sas.api.grpc.InternshipServiceProto.Attachment) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment>) responseObserver);
          break;
        case METHODID_GET_ALL_ATTACHMENTS:
          serviceImpl.getAllAttachments((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment>) responseObserver);
          break;
        case METHODID_GET_ATTACHMENT:
          serviceImpl.getAttachment((elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment>) responseObserver);
          break;
        case METHODID_GET_ATTACHMENTS:
          serviceImpl.getAttachments((elite.sas.api.grpc.InternshipServiceProto.SearchAttachmentParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Attachment>) responseObserver);
          break;
        case METHODID_ADD_LOG:
          serviceImpl.addLog((elite.sas.api.grpc.InternshipServiceProto.Log) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.Log>) responseObserver);
          break;
        case METHODID_ADD_ATTACHMENT_WEEK:
          serviceImpl.addAttachmentWeek((elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.InternshipServiceProto.AttachmentWeek>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class internshipServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    internshipServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return elite.sas.api.grpc.InternshipServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("internshipService");
    }
  }

  private static final class internshipServiceFileDescriptorSupplier
      extends internshipServiceBaseDescriptorSupplier {
    internshipServiceFileDescriptorSupplier() {}
  }

  private static final class internshipServiceMethodDescriptorSupplier
      extends internshipServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    internshipServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (internshipServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new internshipServiceFileDescriptorSupplier())
              .addMethod(getAddAttachmentMethod())
              .addMethod(getGetAllAttachmentsMethod())
              .addMethod(getGetAttachmentMethod())
              .addMethod(getGetAttachmentsMethod())
              .addMethod(getAddLogMethod())
              .addMethod(getAddAttachmentWeekMethod())
              .build();
        }
      }
    }
    return result;
  }
}
