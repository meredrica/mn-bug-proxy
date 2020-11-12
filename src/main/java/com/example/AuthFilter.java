package com.example;

import java.util.Collections;

import javax.inject.Singleton;

import org.reactivestreams.Publisher;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;

@Singleton
public class AuthFilter implements AuthenticationProvider {

	@Override
	public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest,
			AuthenticationRequest<?, ?> authenticationRequest) {

		if(authenticationRequest.getIdentity().toString().equals("admin")) {
			return Flowable.just(new UserDetails("username",Collections.singleton("admin") ));
		} else {
			return Flowable.empty();
		}
	}
}
