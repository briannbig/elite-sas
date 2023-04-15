package elite.sas.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.0)",
    comments = "Source: student-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class studentServiceGrpc {

  private studentServiceGrpc() {}

  public static final String SERVICE_NAME = "studentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest,
      elite.sas.api.grpc.CourseServiceProto.Student> getRegisterStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerStudent",
      requestType = elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest,
      elite.sas.api.grpc.CourseServiceProto.Student> getRegisterStudentMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest, elite.sas.api.grpc.CourseServiceProto.Student> getRegisterStudentMethod;
    if ((getRegisterStudentMethod = studentServiceGrpc.getRegisterStudentMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getRegisterStudentMethod = studentServiceGrpc.getRegisterStudentMethod) == null) {
          studentServiceGrpc.getRegisterStudentMethod = getRegisterStudentMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest, elite.sas.api.grpc.CourseServiceProto.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Student.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("registerStudent"))
              .build();
        }
      }
    }
    return getRegisterStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetAllStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllStudents",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetAllStudentsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.CourseServiceProto.Student> getGetAllStudentsMethod;
    if ((getGetAllStudentsMethod = studentServiceGrpc.getGetAllStudentsMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetAllStudentsMethod = studentServiceGrpc.getGetAllStudentsMethod) == null) {
          studentServiceGrpc.getGetAllStudentsMethod = getGetAllStudentsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.CourseServiceProto.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Student.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getAllStudents"))
              .build();
        }
      }
    }
    return getGetAllStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudent",
      requestType = elite.sas.api.grpc.CourseServiceProto.SearchStudentParams.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams, elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentMethod;
    if ((getGetStudentMethod = studentServiceGrpc.getGetStudentMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetStudentMethod = studentServiceGrpc.getGetStudentMethod) == null) {
          studentServiceGrpc.getGetStudentMethod = getGetStudentMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams, elite.sas.api.grpc.CourseServiceProto.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.SearchStudentParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Student.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getStudent"))
              .build();
        }
      }
    }
    return getGetStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudents",
      requestType = elite.sas.api.grpc.CourseServiceProto.SearchStudentParams.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
      elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams, elite.sas.api.grpc.CourseServiceProto.Student> getGetStudentsMethod;
    if ((getGetStudentsMethod = studentServiceGrpc.getGetStudentsMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetStudentsMethod = studentServiceGrpc.getGetStudentsMethod) == null) {
          studentServiceGrpc.getGetStudentsMethod = getGetStudentsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.SearchStudentParams, elite.sas.api.grpc.CourseServiceProto.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getStudents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.SearchStudentParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Student.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getStudents"))
              .build();
        }
      }
    }
    return getGetStudentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest,
      elite.sas.api.grpc.CourseServiceProto.Student> getUpdateStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStudent",
      requestType = elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Student.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest,
      elite.sas.api.grpc.CourseServiceProto.Student> getUpdateStudentMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest, elite.sas.api.grpc.CourseServiceProto.Student> getUpdateStudentMethod;
    if ((getUpdateStudentMethod = studentServiceGrpc.getUpdateStudentMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getUpdateStudentMethod = studentServiceGrpc.getUpdateStudentMethod) == null) {
          studentServiceGrpc.getUpdateStudentMethod = getUpdateStudentMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest, elite.sas.api.grpc.CourseServiceProto.Student>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Student.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("updateStudent"))
              .build();
        }
      }
    }
    return getUpdateStudentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.Course,
      elite.sas.api.grpc.CourseServiceProto.Course> getAddCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCourse",
      requestType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.Course,
      elite.sas.api.grpc.CourseServiceProto.Course> getAddCourseMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.Course, elite.sas.api.grpc.CourseServiceProto.Course> getAddCourseMethod;
    if ((getAddCourseMethod = studentServiceGrpc.getAddCourseMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getAddCourseMethod = studentServiceGrpc.getAddCourseMethod) == null) {
          studentServiceGrpc.getAddCourseMethod = getAddCourseMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.Course, elite.sas.api.grpc.CourseServiceProto.Course>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("addCourse"))
              .build();
        }
      }
    }
    return getAddCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetAllCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCourses",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetAllCoursesMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.CourseServiceProto.Course> getGetAllCoursesMethod;
    if ((getGetAllCoursesMethod = studentServiceGrpc.getGetAllCoursesMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetAllCoursesMethod = studentServiceGrpc.getGetAllCoursesMethod) == null) {
          studentServiceGrpc.getGetAllCoursesMethod = getGetAllCoursesMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.CourseServiceProto.Course>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getAllCourses"))
              .build();
        }
      }
    }
    return getGetAllCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCourse",
      requestType = elite.sas.api.grpc.CourseServiceProto.SearchCourseParams.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetCourseMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams, elite.sas.api.grpc.CourseServiceProto.Course> getGetCourseMethod;
    if ((getGetCourseMethod = studentServiceGrpc.getGetCourseMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetCourseMethod = studentServiceGrpc.getGetCourseMethod) == null) {
          studentServiceGrpc.getGetCourseMethod = getGetCourseMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams, elite.sas.api.grpc.CourseServiceProto.Course>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.SearchCourseParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getCourse"))
              .build();
        }
      }
    }
    return getGetCourseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetCoursesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCourses",
      requestType = elite.sas.api.grpc.CourseServiceProto.SearchCourseParams.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
      elite.sas.api.grpc.CourseServiceProto.Course> getGetCoursesMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams, elite.sas.api.grpc.CourseServiceProto.Course> getGetCoursesMethod;
    if ((getGetCoursesMethod = studentServiceGrpc.getGetCoursesMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getGetCoursesMethod = studentServiceGrpc.getGetCoursesMethod) == null) {
          studentServiceGrpc.getGetCoursesMethod = getGetCoursesMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.SearchCourseParams, elite.sas.api.grpc.CourseServiceProto.Course>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCourses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.SearchCourseParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("getCourses"))
              .build();
        }
      }
    }
    return getGetCoursesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest,
      elite.sas.api.grpc.CourseServiceProto.Course> getUpdateCourseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateCourse",
      requestType = elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest.class,
      responseType = elite.sas.api.grpc.CourseServiceProto.Course.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest,
      elite.sas.api.grpc.CourseServiceProto.Course> getUpdateCourseMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest, elite.sas.api.grpc.CourseServiceProto.Course> getUpdateCourseMethod;
    if ((getUpdateCourseMethod = studentServiceGrpc.getUpdateCourseMethod) == null) {
      synchronized (studentServiceGrpc.class) {
        if ((getUpdateCourseMethod = studentServiceGrpc.getUpdateCourseMethod) == null) {
          studentServiceGrpc.getUpdateCourseMethod = getUpdateCourseMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest, elite.sas.api.grpc.CourseServiceProto.Course>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateCourse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CourseServiceProto.Course.getDefaultInstance()))
              .setSchemaDescriptor(new studentServiceMethodDescriptorSupplier("updateCourse"))
              .build();
        }
      }
    }
    return getUpdateCourseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static studentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<studentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<studentServiceStub>() {
        @java.lang.Override
        public studentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new studentServiceStub(channel, callOptions);
        }
      };
    return studentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static studentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<studentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<studentServiceBlockingStub>() {
        @java.lang.Override
        public studentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new studentServiceBlockingStub(channel, callOptions);
        }
      };
    return studentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static studentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<studentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<studentServiceFutureStub>() {
        @java.lang.Override
        public studentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new studentServiceFutureStub(channel, callOptions);
        }
      };
    return studentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class studentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerStudent(elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterStudentMethod(), responseObserver);
    }

    /**
     */
    public void getAllStudents(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllStudentsMethod(), responseObserver);
    }

    /**
     */
    public void getStudent(elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentMethod(), responseObserver);
    }

    /**
     */
    public void getStudents(elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentsMethod(), responseObserver);
    }

    /**
     */
    public void updateStudent(elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStudentMethod(), responseObserver);
    }

    /**
     */
    public void addCourse(elite.sas.api.grpc.CourseServiceProto.Course request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCourseMethod(), responseObserver);
    }

    /**
     */
    public void getAllCourses(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCoursesMethod(), responseObserver);
    }

    /**
     */
    public void getCourse(elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCourseMethod(), responseObserver);
    }

    /**
     */
    public void getCourses(elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCoursesMethod(), responseObserver);
    }

    /**
     */
    public void updateCourse(elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCourseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest,
                elite.sas.api.grpc.CourseServiceProto.Student>(
                  this, METHODID_REGISTER_STUDENT)))
          .addMethod(
            getGetAllStudentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CommonsProto.Empty,
                elite.sas.api.grpc.CourseServiceProto.Student>(
                  this, METHODID_GET_ALL_STUDENTS)))
          .addMethod(
            getGetStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
                elite.sas.api.grpc.CourseServiceProto.Student>(
                  this, METHODID_GET_STUDENT)))
          .addMethod(
            getGetStudentsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.SearchStudentParams,
                elite.sas.api.grpc.CourseServiceProto.Student>(
                  this, METHODID_GET_STUDENTS)))
          .addMethod(
            getUpdateStudentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest,
                elite.sas.api.grpc.CourseServiceProto.Student>(
                  this, METHODID_UPDATE_STUDENT)))
          .addMethod(
            getAddCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.Course,
                elite.sas.api.grpc.CourseServiceProto.Course>(
                  this, METHODID_ADD_COURSE)))
          .addMethod(
            getGetAllCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CommonsProto.Empty,
                elite.sas.api.grpc.CourseServiceProto.Course>(
                  this, METHODID_GET_ALL_COURSES)))
          .addMethod(
            getGetCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
                elite.sas.api.grpc.CourseServiceProto.Course>(
                  this, METHODID_GET_COURSE)))
          .addMethod(
            getGetCoursesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.SearchCourseParams,
                elite.sas.api.grpc.CourseServiceProto.Course>(
                  this, METHODID_GET_COURSES)))
          .addMethod(
            getUpdateCourseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest,
                elite.sas.api.grpc.CourseServiceProto.Course>(
                  this, METHODID_UPDATE_COURSE)))
          .build();
    }
  }

  /**
   */
  public static final class studentServiceStub extends io.grpc.stub.AbstractAsyncStub<studentServiceStub> {
    private studentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new studentServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerStudent(elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllStudents(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudent(elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudents(elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStudent(elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStudentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addCourse(elite.sas.api.grpc.CourseServiceProto.Course request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCourses(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourse(elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCourses(elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetCoursesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCourse(elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class studentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<studentServiceBlockingStub> {
    private studentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new studentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Student registerStudent(elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.CourseServiceProto.Student> getAllStudents(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Student getStudent(elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.CourseServiceProto.Student> getStudents(
        elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetStudentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Student updateStudent(elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStudentMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Course addCourse(elite.sas.api.grpc.CourseServiceProto.Course request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.CourseServiceProto.Course> getAllCourses(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Course getCourse(elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCourseMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.CourseServiceProto.Course> getCourses(
        elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetCoursesMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.CourseServiceProto.Course updateCourse(elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCourseMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class studentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<studentServiceFutureStub> {
    private studentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected studentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new studentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Student> registerStudent(
        elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Student> getStudent(
        elite.sas.api.grpc.CourseServiceProto.SearchStudentParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Student> updateStudent(
        elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStudentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Course> addCourse(
        elite.sas.api.grpc.CourseServiceProto.Course request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Course> getCourse(
        elite.sas.api.grpc.CourseServiceProto.SearchCourseParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCourseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.CourseServiceProto.Course> updateCourse(
        elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCourseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_STUDENT = 0;
  private static final int METHODID_GET_ALL_STUDENTS = 1;
  private static final int METHODID_GET_STUDENT = 2;
  private static final int METHODID_GET_STUDENTS = 3;
  private static final int METHODID_UPDATE_STUDENT = 4;
  private static final int METHODID_ADD_COURSE = 5;
  private static final int METHODID_GET_ALL_COURSES = 6;
  private static final int METHODID_GET_COURSE = 7;
  private static final int METHODID_GET_COURSES = 8;
  private static final int METHODID_UPDATE_COURSE = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final studentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(studentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_STUDENT:
          serviceImpl.registerStudent((elite.sas.api.grpc.CourseServiceProto.RegisterStudentRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student>) responseObserver);
          break;
        case METHODID_GET_ALL_STUDENTS:
          serviceImpl.getAllStudents((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student>) responseObserver);
          break;
        case METHODID_GET_STUDENT:
          serviceImpl.getStudent((elite.sas.api.grpc.CourseServiceProto.SearchStudentParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student>) responseObserver);
          break;
        case METHODID_GET_STUDENTS:
          serviceImpl.getStudents((elite.sas.api.grpc.CourseServiceProto.SearchStudentParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student>) responseObserver);
          break;
        case METHODID_UPDATE_STUDENT:
          serviceImpl.updateStudent((elite.sas.api.grpc.CourseServiceProto.UpdateStudentRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Student>) responseObserver);
          break;
        case METHODID_ADD_COURSE:
          serviceImpl.addCourse((elite.sas.api.grpc.CourseServiceProto.Course) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course>) responseObserver);
          break;
        case METHODID_GET_ALL_COURSES:
          serviceImpl.getAllCourses((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course>) responseObserver);
          break;
        case METHODID_GET_COURSE:
          serviceImpl.getCourse((elite.sas.api.grpc.CourseServiceProto.SearchCourseParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course>) responseObserver);
          break;
        case METHODID_GET_COURSES:
          serviceImpl.getCourses((elite.sas.api.grpc.CourseServiceProto.SearchCourseParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course>) responseObserver);
          break;
        case METHODID_UPDATE_COURSE:
          serviceImpl.updateCourse((elite.sas.api.grpc.CourseServiceProto.UpdateCourseRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.CourseServiceProto.Course>) responseObserver);
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

  private static abstract class studentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    studentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return elite.sas.api.grpc.CourseServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("studentService");
    }
  }

  private static final class studentServiceFileDescriptorSupplier
      extends studentServiceBaseDescriptorSupplier {
    studentServiceFileDescriptorSupplier() {}
  }

  private static final class studentServiceMethodDescriptorSupplier
      extends studentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    studentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (studentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new studentServiceFileDescriptorSupplier())
              .addMethod(getRegisterStudentMethod())
              .addMethod(getGetAllStudentsMethod())
              .addMethod(getGetStudentMethod())
              .addMethod(getGetStudentsMethod())
              .addMethod(getUpdateStudentMethod())
              .addMethod(getAddCourseMethod())
              .addMethod(getGetAllCoursesMethod())
              .addMethod(getGetCourseMethod())
              .addMethod(getGetCoursesMethod())
              .addMethod(getUpdateCourseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
