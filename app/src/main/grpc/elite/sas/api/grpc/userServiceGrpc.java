package elite.sas.api.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: user-service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class userServiceGrpc {

  private userServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "userService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.RegisterUserRequest,
      elite.sas.api.grpc.UserServiceProto.AppUser> getRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerUser",
      requestType = elite.sas.api.grpc.UserServiceProto.RegisterUserRequest.class,
      responseType = elite.sas.api.grpc.UserServiceProto.AppUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.RegisterUserRequest,
      elite.sas.api.grpc.UserServiceProto.AppUser> getRegisterUserMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.RegisterUserRequest, elite.sas.api.grpc.UserServiceProto.AppUser> getRegisterUserMethod;
    if ((getRegisterUserMethod = userServiceGrpc.getRegisterUserMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getRegisterUserMethod = userServiceGrpc.getRegisterUserMethod) == null) {
          userServiceGrpc.getRegisterUserMethod = getRegisterUserMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.RegisterUserRequest, elite.sas.api.grpc.UserServiceProto.AppUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registerUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.RegisterUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.AppUser.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("registerUser"))
              .build();
        }
      }
    }
    return getRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetAllUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllUsers",
      requestType = elite.sas.api.grpc.CommonsProto.Empty.class,
      responseType = elite.sas.api.grpc.UserServiceProto.AppUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetAllUsersMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.UserServiceProto.AppUser> getGetAllUsersMethod;
    if ((getGetAllUsersMethod = userServiceGrpc.getGetAllUsersMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getGetAllUsersMethod = userServiceGrpc.getGetAllUsersMethod) == null) {
          userServiceGrpc.getGetAllUsersMethod = getGetAllUsersMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.CommonsProto.Empty, elite.sas.api.grpc.UserServiceProto.AppUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.CommonsProto.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.AppUser.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("getAllUsers"))
              .build();
        }
      }
    }
    return getGetAllUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsers",
      requestType = elite.sas.api.grpc.UserServiceProto.SearchUserParams.class,
      responseType = elite.sas.api.grpc.UserServiceProto.AppUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetUsersMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams, elite.sas.api.grpc.UserServiceProto.AppUser> getGetUsersMethod;
    if ((getGetUsersMethod = userServiceGrpc.getGetUsersMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getGetUsersMethod = userServiceGrpc.getGetUsersMethod) == null) {
          userServiceGrpc.getGetUsersMethod = getGetUsersMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.SearchUserParams, elite.sas.api.grpc.UserServiceProto.AppUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.SearchUserParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.AppUser.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("getUsers"))
              .build();
        }
      }
    }
    return getGetUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = elite.sas.api.grpc.UserServiceProto.SearchUserParams.class,
      responseType = elite.sas.api.grpc.UserServiceProto.AppUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams,
      elite.sas.api.grpc.UserServiceProto.AppUser> getGetUserMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.SearchUserParams, elite.sas.api.grpc.UserServiceProto.AppUser> getGetUserMethod;
    if ((getGetUserMethod = userServiceGrpc.getGetUserMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getGetUserMethod = userServiceGrpc.getGetUserMethod) == null) {
          userServiceGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.SearchUserParams, elite.sas.api.grpc.UserServiceProto.AppUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.SearchUserParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.AppUser.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("getUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateUserRequest,
      elite.sas.api.grpc.UserServiceProto.AppUser> getUpdateUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateUser",
      requestType = elite.sas.api.grpc.UserServiceProto.UpdateUserRequest.class,
      responseType = elite.sas.api.grpc.UserServiceProto.AppUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateUserRequest,
      elite.sas.api.grpc.UserServiceProto.AppUser> getUpdateUserMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateUserRequest, elite.sas.api.grpc.UserServiceProto.AppUser> getUpdateUserMethod;
    if ((getUpdateUserMethod = userServiceGrpc.getUpdateUserMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getUpdateUserMethod = userServiceGrpc.getUpdateUserMethod) == null) {
          userServiceGrpc.getUpdateUserMethod = getUpdateUserMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.UpdateUserRequest, elite.sas.api.grpc.UserServiceProto.AppUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.UpdateUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.AppUser.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("updateUser"))
              .build();
        }
      }
    }
    return getUpdateUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateAccountParams,
      elite.sas.api.grpc.UserServiceProto.Account> getUpdatePasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updatePassword",
      requestType = elite.sas.api.grpc.UserServiceProto.UpdateAccountParams.class,
      responseType = elite.sas.api.grpc.UserServiceProto.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateAccountParams,
      elite.sas.api.grpc.UserServiceProto.Account> getUpdatePasswordMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.UpdateAccountParams, elite.sas.api.grpc.UserServiceProto.Account> getUpdatePasswordMethod;
    if ((getUpdatePasswordMethod = userServiceGrpc.getUpdatePasswordMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getUpdatePasswordMethod = userServiceGrpc.getUpdatePasswordMethod) == null) {
          userServiceGrpc.getUpdatePasswordMethod = getUpdatePasswordMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.UpdateAccountParams, elite.sas.api.grpc.UserServiceProto.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updatePassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.UpdateAccountParams.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.Account.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("updatePassword"))
              .build();
        }
      }
    }
    return getUpdatePasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.GetAccountRequest,
      elite.sas.api.grpc.UserServiceProto.Account> getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAccount",
      requestType = elite.sas.api.grpc.UserServiceProto.GetAccountRequest.class,
      responseType = elite.sas.api.grpc.UserServiceProto.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.GetAccountRequest,
      elite.sas.api.grpc.UserServiceProto.Account> getGetAccountMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.GetAccountRequest, elite.sas.api.grpc.UserServiceProto.Account> getGetAccountMethod;
    if ((getGetAccountMethod = userServiceGrpc.getGetAccountMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getGetAccountMethod = userServiceGrpc.getGetAccountMethod) == null) {
          userServiceGrpc.getGetAccountMethod = getGetAccountMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.GetAccountRequest, elite.sas.api.grpc.UserServiceProto.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.GetAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.Account.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("getAccount"))
              .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.LogInRequest,
      elite.sas.api.grpc.UserServiceProto.Account> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = elite.sas.api.grpc.UserServiceProto.LogInRequest.class,
      responseType = elite.sas.api.grpc.UserServiceProto.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.LogInRequest,
      elite.sas.api.grpc.UserServiceProto.Account> getLoginMethod() {
    io.grpc.MethodDescriptor<elite.sas.api.grpc.UserServiceProto.LogInRequest, elite.sas.api.grpc.UserServiceProto.Account> getLoginMethod;
    if ((getLoginMethod = userServiceGrpc.getLoginMethod) == null) {
      synchronized (userServiceGrpc.class) {
        if ((getLoginMethod = userServiceGrpc.getLoginMethod) == null) {
          userServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<elite.sas.api.grpc.UserServiceProto.LogInRequest, elite.sas.api.grpc.UserServiceProto.Account>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.LogInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  elite.sas.api.grpc.UserServiceProto.Account.getDefaultInstance()))
              .setSchemaDescriptor(new userServiceMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static userServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceStub>() {
        @java.lang.Override
        public userServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceStub(channel, callOptions);
        }
      };
    return userServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static userServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceBlockingStub>() {
        @java.lang.Override
        public userServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceBlockingStub(channel, callOptions);
        }
      };
    return userServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static userServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<userServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<userServiceFutureStub>() {
        @java.lang.Override
        public userServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new userServiceFutureStub(channel, callOptions);
        }
      };
    return userServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void registerUser(elite.sas.api.grpc.UserServiceProto.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterUserMethod(), responseObserver);
    }

    /**
     */
    default void getAllUsers(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllUsersMethod(), responseObserver);
    }

    /**
     */
    default void getUsers(elite.sas.api.grpc.UserServiceProto.SearchUserParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsersMethod(), responseObserver);
    }

    /**
     */
    default void getUser(elite.sas.api.grpc.UserServiceProto.SearchUserParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    default void updateUser(elite.sas.api.grpc.UserServiceProto.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateUserMethod(), responseObserver);
    }

    /**
     */
    default void updatePassword(elite.sas.api.grpc.UserServiceProto.UpdateAccountParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePasswordMethod(), responseObserver);
    }

    /**
     */
    default void getAccount(elite.sas.api.grpc.UserServiceProto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     */
    default void login(elite.sas.api.grpc.UserServiceProto.LogInRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service userService.
   */
  public static abstract class userServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return userServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service userService.
   */
  public static final class userServiceStub
      extends io.grpc.stub.AbstractAsyncStub<userServiceStub> {
    private userServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerUser(elite.sas.api.grpc.UserServiceProto.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllUsers(elite.sas.api.grpc.CommonsProto.Empty request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsers(elite.sas.api.grpc.UserServiceProto.SearchUserParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(elite.sas.api.grpc.UserServiceProto.SearchUserParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateUser(elite.sas.api.grpc.UserServiceProto.UpdateUserRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePassword(elite.sas.api.grpc.UserServiceProto.UpdateAccountParams request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAccount(elite.sas.api.grpc.UserServiceProto.GetAccountRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(elite.sas.api.grpc.UserServiceProto.LogInRequest request,
        io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service userService.
   */
  public static final class userServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<userServiceBlockingStub> {
    private userServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.AppUser registerUser(elite.sas.api.grpc.UserServiceProto.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.UserServiceProto.AppUser> getAllUsers(
        elite.sas.api.grpc.CommonsProto.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<elite.sas.api.grpc.UserServiceProto.AppUser> getUsers(
        elite.sas.api.grpc.UserServiceProto.SearchUserParams request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.AppUser getUser(elite.sas.api.grpc.UserServiceProto.SearchUserParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.AppUser updateUser(elite.sas.api.grpc.UserServiceProto.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.Account updatePassword(elite.sas.api.grpc.UserServiceProto.UpdateAccountParams request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.Account getAccount(elite.sas.api.grpc.UserServiceProto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public elite.sas.api.grpc.UserServiceProto.Account login(elite.sas.api.grpc.UserServiceProto.LogInRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service userService.
   */
  public static final class userServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<userServiceFutureStub> {
    private userServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected userServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new userServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.AppUser> registerUser(
        elite.sas.api.grpc.UserServiceProto.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.AppUser> getUser(
        elite.sas.api.grpc.UserServiceProto.SearchUserParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.AppUser> updateUser(
        elite.sas.api.grpc.UserServiceProto.UpdateUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.Account> updatePassword(
        elite.sas.api.grpc.UserServiceProto.UpdateAccountParams request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.Account> getAccount(
        elite.sas.api.grpc.UserServiceProto.GetAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<elite.sas.api.grpc.UserServiceProto.Account> login(
        elite.sas.api.grpc.UserServiceProto.LogInRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_USER = 0;
  private static final int METHODID_GET_ALL_USERS = 1;
  private static final int METHODID_GET_USERS = 2;
  private static final int METHODID_GET_USER = 3;
  private static final int METHODID_UPDATE_USER = 4;
  private static final int METHODID_UPDATE_PASSWORD = 5;
  private static final int METHODID_GET_ACCOUNT = 6;
  private static final int METHODID_LOGIN = 7;

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
        case METHODID_REGISTER_USER:
          serviceImpl.registerUser((elite.sas.api.grpc.UserServiceProto.RegisterUserRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser>) responseObserver);
          break;
        case METHODID_GET_ALL_USERS:
          serviceImpl.getAllUsers((elite.sas.api.grpc.CommonsProto.Empty) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser>) responseObserver);
          break;
        case METHODID_GET_USERS:
          serviceImpl.getUsers((elite.sas.api.grpc.UserServiceProto.SearchUserParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((elite.sas.api.grpc.UserServiceProto.SearchUserParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser>) responseObserver);
          break;
        case METHODID_UPDATE_USER:
          serviceImpl.updateUser((elite.sas.api.grpc.UserServiceProto.UpdateUserRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.AppUser>) responseObserver);
          break;
        case METHODID_UPDATE_PASSWORD:
          serviceImpl.updatePassword((elite.sas.api.grpc.UserServiceProto.UpdateAccountParams) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account>) responseObserver);
          break;
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount((elite.sas.api.grpc.UserServiceProto.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((elite.sas.api.grpc.UserServiceProto.LogInRequest) request,
              (io.grpc.stub.StreamObserver<elite.sas.api.grpc.UserServiceProto.Account>) responseObserver);
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
          getRegisterUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.RegisterUserRequest,
              elite.sas.api.grpc.UserServiceProto.AppUser>(
                service, METHODID_REGISTER_USER)))
        .addMethod(
          getGetAllUsersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.CommonsProto.Empty,
              elite.sas.api.grpc.UserServiceProto.AppUser>(
                service, METHODID_GET_ALL_USERS)))
        .addMethod(
          getGetUsersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.SearchUserParams,
              elite.sas.api.grpc.UserServiceProto.AppUser>(
                service, METHODID_GET_USERS)))
        .addMethod(
          getGetUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.SearchUserParams,
              elite.sas.api.grpc.UserServiceProto.AppUser>(
                service, METHODID_GET_USER)))
        .addMethod(
          getUpdateUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.UpdateUserRequest,
              elite.sas.api.grpc.UserServiceProto.AppUser>(
                service, METHODID_UPDATE_USER)))
        .addMethod(
          getUpdatePasswordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.UpdateAccountParams,
              elite.sas.api.grpc.UserServiceProto.Account>(
                service, METHODID_UPDATE_PASSWORD)))
        .addMethod(
          getGetAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.GetAccountRequest,
              elite.sas.api.grpc.UserServiceProto.Account>(
                service, METHODID_GET_ACCOUNT)))
        .addMethod(
          getLoginMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              elite.sas.api.grpc.UserServiceProto.LogInRequest,
              elite.sas.api.grpc.UserServiceProto.Account>(
                service, METHODID_LOGIN)))
        .build();
  }

  private static abstract class userServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    userServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return elite.sas.api.grpc.UserServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("userService");
    }
  }

  private static final class userServiceFileDescriptorSupplier
      extends userServiceBaseDescriptorSupplier {
    userServiceFileDescriptorSupplier() {}
  }

  private static final class userServiceMethodDescriptorSupplier
      extends userServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    userServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (userServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new userServiceFileDescriptorSupplier())
              .addMethod(getRegisterUserMethod())
              .addMethod(getGetAllUsersMethod())
              .addMethod(getGetUsersMethod())
              .addMethod(getGetUserMethod())
              .addMethod(getUpdateUserMethod())
              .addMethod(getUpdatePasswordMethod())
              .addMethod(getGetAccountMethod())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
