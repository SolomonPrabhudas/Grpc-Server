package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.service.userServiceApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class GrpcServer {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		SpringApplication.run(GrpcServer.class, args);
		System.out.println("Starting Grpc Server");
		
		Server server = ServerBuilder.forPort(8085)
				.addService(new userServiceApplication()).build();
		
		server.start();
		System.out.println("Server started at port: "+ server.getPort());
		server.awaitTermination();
	}

}
