package elite.sas.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.49.0)",
    comments = "Source: tenant-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class tenantServiceGrpc {

  private tenantServiceGrpc() {}

  public static final String SERVICE_NAME = "tenantService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getRegisterTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerTenant",
      requestType = elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest.class,
      responseType = elite.sas.api.grpc.TenantServiceProto.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getRegisterTenantMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest, elite.sas.api.grpc.TenantServiceProto.Tenant> getRegisterTenantMethod;
    if ((getRegisterTenantMethod = tenantServiceGrpc.getRegisterTenantMethod) == null) {
      synchronized (tenantServiceGrpc.class) {
        if ((getRegisterTenantMethod = tenantServiceGrpc.getRegisterTenantMethod) == null) {
          tenantServiceGrpc.getRegisterTenantMethod = getRegisterTenantMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest, elite.sas.api.grpc.TenantServiceProto.Tenant>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerTenant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.Tenant.getDefaultInstance()))
              .setSchemaDescriptor(new tenantServiceMethodDescriptorSupplier("registerTenant"))
              .build();
        }
      }
    }
    return getRegisterTenantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetAllTenantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllTenants",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.TenantServiceProto.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetAllTenantsMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.TenantServiceProto.Tenant> getGetAllTenantsMethod;
    if ((getGetAllTenantsMethod = tenantServiceGrpc.getGetAllTenantsMethod) == null) {
      synchronized (tenantServiceGrpc.class) {
        if ((getGetAllTenantsMethod = tenantServiceGrpc.getGetAllTenantsMethod) == null) {
          tenantServiceGrpc.getGetAllTenantsMethod = getGetAllTenantsMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.TenantServiceProto.Tenant>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllTenants"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.Tenant.getDefaultInstance()))
              .setSchemaDescriptor(new tenantServiceMethodDescriptorSupplier("getAllTenants"))
              .build();
        }
      }
    }
    return getGetAllTenantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTenantById",
      requestType = elite.sas.api.grpc.TenantServiceProto.SearchParams.class,
      responseType = elite.sas.api.grpc.TenantServiceProto.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByIdMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams, elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByIdMethod;
    if ((getGetTenantByIdMethod = tenantServiceGrpc.getGetTenantByIdMethod) == null) {
      synchronized (tenantServiceGrpc.class) {
        if ((getGetTenantByIdMethod = tenantServiceGrpc.getGetTenantByIdMethod) == null) {
          tenantServiceGrpc.getGetTenantByIdMethod = getGetTenantByIdMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.TenantServiceProto.SearchParams, elite.sas.api.grpc.TenantServiceProto.Tenant>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getTenantById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.SearchParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.Tenant.getDefaultInstance()))
              .setSchemaDescriptor(new tenantServiceMethodDescriptorSupplier("getTenantById"))
              .build();
        }
      }
    }
    return getGetTenantByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTenantByType",
      requestType = elite.sas.api.grpc.TenantServiceProto.SearchParams.class,
      responseType = elite.sas.api.grpc.TenantServiceProto.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByTypeMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.SearchParams, elite.sas.api.grpc.TenantServiceProto.Tenant> getGetTenantByTypeMethod;
    if ((getGetTenantByTypeMethod = tenantServiceGrpc.getGetTenantByTypeMethod) == null) {
      synchronized (tenantServiceGrpc.class) {
        if ((getGetTenantByTypeMethod = tenantServiceGrpc.getGetTenantByTypeMethod) == null) {
          tenantServiceGrpc.getGetTenantByTypeMethod = getGetTenantByTypeMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.TenantServiceProto.SearchParams, elite.sas.api.grpc.TenantServiceProto.Tenant>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getTenantByType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.SearchParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.Tenant.getDefaultInstance()))
              .setSchemaDescriptor(new tenantServiceMethodDescriptorSupplier("getTenantByType"))
              .build();
        }
      }
    }
    return getGetTenantByTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getUpdateTenantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateTenant",
      requestType = elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest.class,
      responseType = elite.sas.api.grpc.TenantServiceProto.Tenant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest,
      elite.sas.api.grpc.TenantServiceProto.Tenant> getUpdateTenantMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest, elite.sas.api.grpc.TenantServiceProto.Tenant> getUpdateTenantMethod;
    if ((getUpdateTenantMethod = tenantServiceGrpc.getUpdateTenantMethod) == null) {
      synchronized (tenantServiceGrpc.class) {
        if ((getUpdateTenantMethod = tenantServiceGrpc.getUpdateTenantMethod) == null) {
          tenantServiceGrpc.getUpdateTenantMethod = getUpdateTenantMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest, elite.sas.api.grpc.TenantServiceProto.Tenant>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateTenant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.TenantServiceProto.Tenant.getDefaultInstance()))
              .setSchemaDescriptor(new tenantServiceMethodDescriptorSupplier("updateTenant"))
              .build();
        }
      }
    }
    return getUpdateTenantMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static tenantServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tenantServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tenantServiceStub>() {
        @java.lang.Override
        public tenantServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tenantServiceStub(channel, callOptions);
        }
      };
    return tenantServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static tenantServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tenantServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tenantServiceBlockingStub>() {
        @java.lang.Override
        public tenantServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tenantServiceBlockingStub(channel, callOptions);
        }
      };
    return tenantServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static tenantServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<tenantServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<tenantServiceFutureStub>() {
        @java.lang.Override
        public tenantServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new tenantServiceFutureStub(channel, callOptions);
        }
      };
    return tenantServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class tenantServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerTenant(elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterTenantMethod(), responseObserver);
    }

    /**
     */
    public void getAllTenants(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllTenantsMethod(), responseObserver);
    }

    /**
     */
    public void getTenantById(elite.sas.api.grpc.TenantServiceProto.SearchParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantByIdMethod(), responseObserver);
    }

    /**
     */
    public void getTenantByType(elite.sas.api.grpc.TenantServiceProto.SearchParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTenantByTypeMethod(), responseObserver);
    }

    /**
     */
    public void updateTenant(elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTenantMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest,
                elite.sas.api.grpc.TenantServiceProto.Tenant>(
                  this, METHODID_REGISTER_TENANT)))
          .addMethod(
            getGetAllTenantsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                elite.sas.api.grpc.CommonsProto.Empty,
                elite.sas.api.grpc.TenantServiceProto.Tenant>(
                  this, METHODID_GET_ALL_TENANTS)))
          .addMethod(
            getGetTenantByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.TenantServiceProto.SearchParams,
                elite.sas.api.grpc.TenantServiceProto.Tenant>(
                  this, METHODID_GET_TENANT_BY_ID)))
          .addMethod(
            getGetTenantByTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.TenantServiceProto.SearchParams,
                elite.sas.api.grpc.TenantServiceProto.Tenant>(
                  this, METHODID_GET_TENANT_BY_TYPE)))
          .addMethod(
            getUpdateTenantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest,
                elite.sas.api.grpc.TenantServiceProto.Tenant>(
                  this, METHODID_UPDATE_TENANT)))
          .build();
    }
  }

  /**
   */
  public static final class tenantServiceStub extends io.grpc.stub.AbstractAsyncStub<tenantServiceStub> {
    private tenantServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tenantServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tenantServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerTenant(elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterTenantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllTenants(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllTenantsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTenantById(elite.sas.api.grpc.TenantServiceProto.SearchParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTenantByType(elite.sas.api.grpc.TenantServiceProto.SearchParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTenantByTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateTenant(elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class tenantServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<tenantServiceBlockingStub> {
    private tenantServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tenantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tenantServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public elite.sas.api.grpc.TenantServiceProto.Tenant registerTenant(elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterTenantMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.TenantServiceProto.Tenant> getAllTenants(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllTenantsMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.TenantServiceProto.Tenant getTenantById(elite.sas.api.grpc.TenantServiceProto.SearchParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.TenantServiceProto.Tenant getTenantByType(elite.sas.api.grpc.TenantServiceProto.SearchParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTenantByTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.TenantServiceProto.Tenant updateTenant(elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTenantMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class tenantServiceFutureStub extends io.grpc.stub.AbstractFutureStub<tenantServiceFutureStub> {
    private tenantServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected tenantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new tenantServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.TenantServiceProto.Tenant> registerTenant(
        elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterTenantMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.TenantServiceProto.Tenant> getTenantById(
        elite.sas.api.grpc.TenantServiceProto.SearchParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.TenantServiceProto.Tenant> getTenantByType(
        elite.sas.api.grpc.TenantServiceProto.SearchParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTenantByTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.TenantServiceProto.Tenant> updateTenant(
        elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTenantMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_TENANT = 0;
  private static final int METHODID_GET_ALL_TENANTS = 1;
  private static final int METHODID_GET_TENANT_BY_ID = 2;
  private static final int METHODID_GET_TENANT_BY_TYPE = 3;
  private static final int METHODID_UPDATE_TENANT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final tenantServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(tenantServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_TENANT:
          serviceImpl.registerTenant((elite.sas.api.grpc.TenantServiceProto.RegisterTenantRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant>) responseObserver);
          break;
        case METHODID_GET_ALL_TENANTS:
          serviceImpl.getAllTenants((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant>) responseObserver);
          break;
        case METHODID_GET_TENANT_BY_ID:
          serviceImpl.getTenantById((elite.sas.api.grpc.TenantServiceProto.SearchParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant>) responseObserver);
          break;
        case METHODID_GET_TENANT_BY_TYPE:
          serviceImpl.getTenantByType((elite.sas.api.grpc.TenantServiceProto.SearchParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant>) responseObserver);
          break;
        case METHODID_UPDATE_TENANT:
          serviceImpl.updateTenant((elite.sas.api.grpc.TenantServiceProto.UpdateTenantRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.TenantServiceProto.Tenant>) responseObserver);
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

  private static abstract class tenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    tenantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return elite.sas.api.grpc.TenantServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("tenantService");
    }
  }

  private static final class tenantServiceFileDescriptorSupplier
      extends tenantServiceBaseDescriptorSupplier {
    tenantServiceFileDescriptorSupplier() {}
  }

  private static final class tenantServiceMethodDescriptorSupplier
      extends tenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    tenantServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (tenantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new tenantServiceFileDescriptorSupplier())
              .addMethod(getRegisterTenantMethod())
              .addMethod(getGetAllTenantsMethod())
              .addMethod(getGetTenantByIdMethod())
              .addMethod(getGetTenantByTypeMethod())
              .addMethod(getUpdateTenantMethod())
              .build();
        }
      }
    }
    return result;
  }
}
