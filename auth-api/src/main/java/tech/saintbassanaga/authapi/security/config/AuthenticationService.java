package tech.saintbassanaga.authapi.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.saintbassanaga.authapi.models.AuthenticationRequest;
import tech.saintbassanaga.authapi.models.User;
import tech.saintbassanaga.authapi.models.UserRole;
import tech.saintbassanaga.authapi.repositories.UserRepository;
import tech.saintbassanaga.authapi.services.JWTService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public AuthenticationResponse register(RegisterRequest request)
    {
        var user = User.builder()
                .name(request.getFirstname())
                .surname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getEmail())
                .userRole(UserRole.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }
    public AuthenticationResponse authenticate(AuthenticationRequest request)
    {
        authenticationManager.authenticate((
                new UsernamePasswordAuthenticationToken(request.getEmail(),
                        request.getPassword())
                ));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
