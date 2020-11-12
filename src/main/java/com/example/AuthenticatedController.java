package com.example;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;

@Controller("/")
public class AuthenticatedController {

    @Get(produces="text/plain")
		@Secured("admin")
    public String index() {
        return "Example Response";
    }
}
