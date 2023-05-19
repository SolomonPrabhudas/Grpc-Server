package user;

import com.sample.javastubs.User.APIResponse;
import com.sample.javastubs.User.Empty;
import com.sample.javastubs.User.LoginRequest;
import com.sample.javastubs.userServiceGrpc.userServiceImplBase;

import io.grpc.stub.StreamObserver;

public class userServiceApplication extends userServiceImplBase 
{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver)
	{
		System.out.println("Inside login method");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
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
