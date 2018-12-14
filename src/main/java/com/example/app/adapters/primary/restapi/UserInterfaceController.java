package com.example.app.adapters.primary.restapi;

import com.example.app.application.services.UseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInterfaceController {

    private UseCase usecase;

    public UserInterfaceController(UseCase usecase) {
        this.usecase = usecase;
    }

    @GetMapping("/")
    public String allRequests() {
        return usecase.myThing();
    }
}
