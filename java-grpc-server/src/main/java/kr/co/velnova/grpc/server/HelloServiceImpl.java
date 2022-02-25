package kr.co.velnova.grpc.server;

import io.grpc.stub.StreamObserver;
import kr.co.velnova.grpc.helloworld.HelloRequest;
import kr.co.velnova.grpc.helloworld.HelloResponse;
import kr.co.velnova.grpc.helloworld.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void helloWorld(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        System.out.println(request);

        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setMessage("hello! " + lastName + " " + firstName + "!")
                .build();

        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}
