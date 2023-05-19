package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.userServiceApplication;

public class GrpcServer {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.out.println("Starting Grpc Server");
		
		Server server = ServerBuilder.forPort(8085)
				.addService(new userServiceApplication()).build();
		
		server.start();
		System.out.println("Server started at port: "+ server.getPort());
		server.awaitTermination();
	}

}
