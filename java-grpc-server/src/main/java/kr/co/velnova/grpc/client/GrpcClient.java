package kr.co.velnova.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import kr.co.velnova.grpc.helloworld.HelloRequest;
import kr.co.velnova.grpc.helloworld.HelloResponse;
import kr.co.velnova.grpc.helloworld.HelloServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.helloWorld(HelloRequest.newBuilder()
                .setFirstName("Velnova")
                .setLastName("Jung")
                .build());

        System.out.println("response : " + helloResponse);

        channel.shutdown();

    }
}
