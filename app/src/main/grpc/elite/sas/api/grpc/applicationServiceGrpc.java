package elite.sas.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: application-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class applicationServiceGrpc {

  private applicationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "applicationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Listing,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getAddListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addListing",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Listing,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getAddListingMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Listing, elite.sas.api.grpc.ApplicationServiceProto.Listing> getAddListingMethod;
    if ((getAddListingMethod = applicationServiceGrpc.getAddListingMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getAddListingMethod = applicationServiceGrpc.getAddListingMethod) == null) {
          applicationServiceGrpc.getAddListingMethod = getAddListingMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.Listing, elite.sas.api.grpc.ApplicationServiceProto.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("addListing"))
              .build();
        }
      }
    }
    return getAddListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetAllListingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllListings",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetAllListingsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetAllListingsMethod;
    if ((getGetAllListingsMethod = applicationServiceGrpc.getGetAllListingsMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetAllListingsMethod = applicationServiceGrpc.getGetAllListingsMethod) == null) {
          applicationServiceGrpc.getGetAllListingsMethod = getGetAllListingsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.ApplicationServiceProto.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllListings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getAllListings"))
              .build();
        }
      }
    }
    return getGetAllListingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListings",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams, elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingsMethod;
    if ((getGetListingsMethod = applicationServiceGrpc.getGetListingsMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetListingsMethod = applicationServiceGrpc.getGetListingsMethod) == null) {
          applicationServiceGrpc.getGetListingsMethod = getGetListingsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams, elite.sas.api.grpc.ApplicationServiceProto.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getListings"))
              .build();
        }
      }
    }
    return getGetListingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getListing",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams, elite.sas.api.grpc.ApplicationServiceProto.Listing> getGetListingMethod;
    if ((getGetListingMethod = applicationServiceGrpc.getGetListingMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetListingMethod = applicationServiceGrpc.getGetListingMethod) == null) {
          applicationServiceGrpc.getGetListingMethod = getGetListingMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams, elite.sas.api.grpc.ApplicationServiceProto.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getListing"))
              .build();
        }
      }
    }
    return getGetListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getUpdateListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateListing",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest,
      elite.sas.api.grpc.ApplicationServiceProto.Listing> getUpdateListingMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest, elite.sas.api.grpc.ApplicationServiceProto.Listing> getUpdateListingMethod;
    if ((getUpdateListingMethod = applicationServiceGrpc.getUpdateListingMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getUpdateListingMethod = applicationServiceGrpc.getUpdateListingMethod) == null) {
          applicationServiceGrpc.getUpdateListingMethod = getUpdateListingMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest, elite.sas.api.grpc.ApplicationServiceProto.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("updateListing"))
              .build();
        }
      }
    }
    return getUpdateListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Application,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getAddApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addApplication",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Application,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getAddApplicationMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.Application, elite.sas.api.grpc.ApplicationServiceProto.Application> getAddApplicationMethod;
    if ((getAddApplicationMethod = applicationServiceGrpc.getAddApplicationMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getAddApplicationMethod = applicationServiceGrpc.getAddApplicationMethod) == null) {
          applicationServiceGrpc.getAddApplicationMethod = getAddApplicationMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.Application, elite.sas.api.grpc.ApplicationServiceProto.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("addApplication"))
              .build();
        }
      }
    }
    return getAddApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetAllApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllApplications",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetAllApplicationsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.ApplicationServiceProto.Application> getGetAllApplicationsMethod;
    if ((getGetAllApplicationsMethod = applicationServiceGrpc.getGetAllApplicationsMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetAllApplicationsMethod = applicationServiceGrpc.getGetAllApplicationsMethod) == null) {
          applicationServiceGrpc.getGetAllApplicationsMethod = getGetAllApplicationsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.ApplicationServiceProto.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllApplications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getAllApplications"))
              .build();
        }
      }
    }
    return getGetAllApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getApplications",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams, elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationsMethod;
    if ((getGetApplicationsMethod = applicationServiceGrpc.getGetApplicationsMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetApplicationsMethod = applicationServiceGrpc.getGetApplicationsMethod) == null) {
          applicationServiceGrpc.getGetApplicationsMethod = getGetApplicationsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams, elite.sas.api.grpc.ApplicationServiceProto.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getApplications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getApplications"))
              .build();
        }
      }
    }
    return getGetApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getApplication",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams, elite.sas.api.grpc.ApplicationServiceProto.Application> getGetApplicationMethod;
    if ((getGetApplicationMethod = applicationServiceGrpc.getGetApplicationMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getGetApplicationMethod = applicationServiceGrpc.getGetApplicationMethod) == null) {
          applicationServiceGrpc.getGetApplicationMethod = getGetApplicationMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams, elite.sas.api.grpc.ApplicationServiceProto.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("getApplication"))
              .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getUpdateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateApplication",
      requestType = elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest.class,
      responseType = elite.sas.api.grpc.ApplicationServiceProto.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest,
      elite.sas.api.grpc.ApplicationServiceProto.Application> getUpdateApplicationMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest, elite.sas.api.grpc.ApplicationServiceProto.Application> getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = applicationServiceGrpc.getUpdateApplicationMethod) == null) {
      synchronized (applicationServiceGrpc.class) {
        if ((getUpdateApplicationMethod = applicationServiceGrpc.getUpdateApplicationMethod) == null) {
          applicationServiceGrpc.getUpdateApplicationMethod = getUpdateApplicationMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest, elite.sas.api.grpc.ApplicationServiceProto.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.ApplicationServiceProto.Application.getDefaultInstance()))
              .setSchemaDescriptor(new applicationServiceMethodDescriptorSupplier("updateApplication"))
              .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static applicationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<applicationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<applicationServiceStub>() {
        @java.lang.Override
        public applicationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new applicationServiceStub(channel, callOptions);
        }
      };
    return applicationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static applicationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<applicationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<applicationServiceBlockingStub>() {
        @java.lang.Override
        public applicationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new applicationServiceBlockingStub(channel, callOptions);
        }
      };
    return applicationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static applicationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<applicationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<applicationServiceFutureStub>() {
        @java.lang.Override
        public applicationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new applicationServiceFutureStub(channel, callOptions);
        }
      };
    return applicationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     *add a listing
     * </pre>
     */
    default void addListing(elite.sas.api.grpc.ApplicationServiceProto.Listing request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddListingMethod(), responseObserver);
    }

    /**
     * <pre>
     *get all listings
     * </pre>
     */
    default void getAllListings(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllListingsMethod(), responseObserver);
    }

    /**
     * <pre>
     *search listings
     * </pre>
     */
    default void getListings(elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListingsMethod(), responseObserver);
    }

    /**
     */
    default void getListing(elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListingMethod(), responseObserver);
    }

    /**
     */
    default void updateListing(elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateListingMethod(), responseObserver);
    }

    /**
     */
    default void addApplication(elite.sas.api.grpc.ApplicationServiceProto.Application request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddApplicationMethod(), responseObserver);
    }

    /**
     */
    default void getAllApplications(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllApplicationsMethod(), responseObserver);
    }

    /**
     */
    default void getApplications(elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApplicationsMethod(), responseObserver);
    }

    /**
     */
    default void getApplication(elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApplicationMethod(), responseObserver);
    }

    /**
     */
    default void updateApplication(elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApplicationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service applicationService.
   */
  public static abstract class applicationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return applicationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service applicationService.
   */
  public static final class applicationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<applicationServiceStub> {
    private applicationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected applicationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new applicationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *add a listing
     * </pre>
     */
    public void addListing(elite.sas.api.grpc.ApplicationServiceProto.Listing request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *get all listings
     * </pre>
     */
    public void getAllListings(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllListingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *search listings
     * </pre>
     */
    public void getListings(elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetListingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getListing(elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateListing(elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addApplication(elite.sas.api.grpc.ApplicationServiceProto.Application request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllApplications(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllApplicationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getApplications(elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetApplicationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getApplication(elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateApplication(elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service applicationService.
   */
  public static final class applicationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<applicationServiceBlockingStub> {
    private applicationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected applicationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new applicationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *add a listing
     * </pre>
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Listing addListing(elite.sas.api.grpc.ApplicationServiceProto.Listing request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *get all listings
     * </pre>
     */
    public java.util.Iterator<elite.sas.api.grpc.ApplicationServiceProto.Listing> getAllListings(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllListingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *search listings
     * </pre>
     */
    public java.util.Iterator<elite.sas.api.grpc.ApplicationServiceProto.Listing> getListings(
        elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetListingsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Listing getListing(elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListingMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Listing updateListing(elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListingMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Application addApplication(elite.sas.api.grpc.ApplicationServiceProto.Application request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddApplicationMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.ApplicationServiceProto.Application> getAllApplications(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllApplicationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.ApplicationServiceProto.Application> getApplications(
        elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetApplicationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Application getApplication(elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.ApplicationServiceProto.Application updateApplication(elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service applicationService.
   */
  public static final class applicationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<applicationServiceFutureStub> {
    private applicationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected applicationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new applicationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *add a listing
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Listing> addListing(
        elite.sas.api.grpc.ApplicationServiceProto.Listing request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddListingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Listing> getListing(
        elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Listing> updateListing(
        elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Application> addApplication(
        elite.sas.api.grpc.ApplicationServiceProto.Application request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddApplicationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Application> getApplication(
        elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.ApplicationServiceProto.Application> updateApplication(
        elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_LISTING = 0;
  private static final int METHODID_GET_ALL_LISTINGS = 1;
  private static final int METHODID_GET_LISTINGS = 2;
  private static final int METHODID_GET_LISTING = 3;
  private static final int METHODID_UPDATE_LISTING = 4;
  private static final int METHODID_ADD_APPLICATION = 5;
  private static final int METHODID_GET_ALL_APPLICATIONS = 6;
  private static final int METHODID_GET_APPLICATIONS = 7;
  private static final int METHODID_GET_APPLICATION = 8;
  private static final int METHODID_UPDATE_APPLICATION = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_LISTING:
          serviceImpl.addListing((elite.sas.api.grpc.ApplicationServiceProto.Listing) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing>) responseObserver);
          break;
        case METHODID_GET_ALL_LISTINGS:
          serviceImpl.getAllListings((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing>) responseObserver);
          break;
        case METHODID_GET_LISTINGS:
          serviceImpl.getListings((elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing>) responseObserver);
          break;
        case METHODID_GET_LISTING:
          serviceImpl.getListing((elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing>) responseObserver);
          break;
        case METHODID_UPDATE_LISTING:
          serviceImpl.updateListing((elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Listing>) responseObserver);
          break;
        case METHODID_ADD_APPLICATION:
          serviceImpl.addApplication((elite.sas.api.grpc.ApplicationServiceProto.Application) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application>) responseObserver);
          break;
        case METHODID_GET_ALL_APPLICATIONS:
          serviceImpl.getAllApplications((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application>) responseObserver);
          break;
        case METHODID_GET_APPLICATIONS:
          serviceImpl.getApplications((elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application>) responseObserver);
          break;
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication((elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication((elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.ApplicationServiceProto.Application>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddListingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.Listing,
              elite.sas.api.grpc.ApplicationServiceProto.Listing>(
                service, METHODID_ADD_LISTING)))
        .addMethod(
          getGetAllListingsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.CommonsProto.Empty,
              elite.sas.api.grpc.ApplicationServiceProto.Listing>(
                service, METHODID_GET_ALL_LISTINGS)))
        .addMethod(
          getGetListingsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
              elite.sas.api.grpc.ApplicationServiceProto.Listing>(
                service, METHODID_GET_LISTINGS)))
        .addMethod(
          getGetListingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.SearchListingParams,
              elite.sas.api.grpc.ApplicationServiceProto.Listing>(
                service, METHODID_GET_LISTING)))
        .addMethod(
          getUpdateListingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.UpdateListingRequest,
              elite.sas.api.grpc.ApplicationServiceProto.Listing>(
                service, METHODID_UPDATE_LISTING)))
        .addMethod(
          getAddApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.Application,
              elite.sas.api.grpc.ApplicationServiceProto.Application>(
                service, METHODID_ADD_APPLICATION)))
        .addMethod(
          getGetAllApplicationsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.CommonsProto.Empty,
              elite.sas.api.grpc.ApplicationServiceProto.Application>(
                service, METHODID_GET_ALL_APPLICATIONS)))
        .addMethod(
          getGetApplicationsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
              elite.sas.api.grpc.ApplicationServiceProto.Application>(
                service, METHODID_GET_APPLICATIONS)))
        .addMethod(
          getGetApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.SearchApplicationParams,
              elite.sas.api.grpc.ApplicationServiceProto.Application>(
                service, METHODID_GET_APPLICATION)))
        .addMethod(
          getUpdateApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.ApplicationServiceProto.UpdateApplicationRequest,
              elite.sas.api.grpc.ApplicationServiceProto.Application>(
                service, METHODID_UPDATE_APPLICATION)))
        .build();
  }

  private static abstract class applicationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    applicationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return elite.sas.api.grpc.ApplicationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("applicationService");
    }
  }

  private static final class applicationServiceFileDescriptorSupplier
      extends applicationServiceBaseDescriptorSupplier {
    applicationServiceFileDescriptorSupplier() {}
  }

  private static final class applicationServiceMethodDescriptorSupplier
      extends applicationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    applicationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (applicationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new applicationServiceFileDescriptorSupplier())
              .addMethod(getAddListingMethod())
              .addMethod(getGetAllListingsMethod())
              .addMethod(getGetListingsMethod())
              .addMethod(getGetListingMethod())
              .addMethod(getUpdateListingMethod())
              .addMethod(getAddApplicationMethod())
              .addMethod(getGetAllApplicationsMethod())
              .addMethod(getGetApplicationsMethod())
              .addMethod(getGetApplicationMethod())
              .addMethod(getUpdateApplicationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
