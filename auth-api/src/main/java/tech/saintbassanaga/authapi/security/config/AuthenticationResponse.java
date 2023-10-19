package tech.saintbassanaga.authapi.security.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private  String token;
}
