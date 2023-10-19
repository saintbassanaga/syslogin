package tech.saintbassanaga.authapi.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.saintbassanaga.authapi.models.RegistrationRequest;
import tech.saintbassanaga.authapi.services.RegistrationService;

@RestController
@RequestMapping(path = "api/v1/registration")

public class RegistrationController {

    private RegistrationService registrationService;
    public  String register(@RequestBody RegistrationRequest request){
        return "Works";
    }
}
