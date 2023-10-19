package tech.saintbassanaga.authapi.controller;





import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.saintbassanaga.authapi.models.AuthenticationRequest;
import tech.saintbassanaga.authapi.security.config.AuthenticationResponse;
import tech.saintbassanaga.authapi.security.config.AuthenticationService;
import tech.saintbassanaga.authapi.security.config.RegisterRequest;

@RestController
@RequestMapping(path = "api/v1/auth")

public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    )
    {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    )
    {
        return  ResponseEntity.ok(service.authenticate(request));
    }
}
