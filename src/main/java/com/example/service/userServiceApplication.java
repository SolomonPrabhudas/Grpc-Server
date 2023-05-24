package com.example.service;

import com.example.javastubs.User;
import com.example.javastubs.userServiceGrpc;
import com.example.javastubs.User.APIResponse;
import com.example.javastubs.User.Empty;
import com.example.javastubs.User.LoginRequest;

import io.grpc.stub.StreamObserver;

public class userServiceApplication extends userServiceGrpc.userServiceImplBase 
{

	@Override
	public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver)
	{
		System.out.println("Inside login method");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		User.APIResponse.Builder response = User.APIResponse.newBuilder();
		
		if(username.equals(password))
		{
			response.setResponsecode(0).setResponsemessage("Login successfull");
		}
		else
		{
			response.setResponsecode(100).setResponsemessage("Login failed");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) 
	{
		
	}
	
}
