package bhuwanupadhyay.springbootjwttoken;

import bhuwanupadhyay.springbootjwttoken.security.JwtTokenProvider;
import bhuwanupadhyay.springbootjwttoken.security.User;
import bhuwanupadhyay.springbootjwttoken.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@SpringBootApplication
public class SpringBootJwtTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJwtTokenApplication.class, args);
    }


    @RestController
    @RequestMapping("/api/auth")
    static class AuthController {

        private final AuthenticationManager auth;
        private final JwtTokenProvider tokenProvider;

        @Autowired
        public AuthController(AuthenticationManager auth, JwtTokenProvider tokenProvider) {
            this.auth = auth;
            this.tokenProvider = tokenProvider;
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginDto login) {
            Authentication authentication = auth.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authResponse(tokenProvider.generateToken(authentication));
        }


        @GetMapping("/refresh")
        public ResponseEntity<?> refresh(HttpServletRequest request) {
            return tokenProvider.buildAuthentication(request)
                    .map(tokenProvider::generateToken)
                    .map(this::authResponse)
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }

        private ResponseEntity<?> authResponse(String jwtToken) {
            HashMap<String, String> response = new HashMap<>();
            response.put("accessToken", jwtToken);
            response.put("tokenType", "Bearer");
            return ResponseEntity.ok(response);
        }

    }

    @RestController
    @RequestMapping("/api/hello")
    static class HelloController {

        @GetMapping
        public String ok() {
            return "Welcome!";
        }

    }


    @Component
    static class Init {

        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;

        @Autowired
        public Init(UserRepository repository, PasswordEncoder passwordEncoder) {
            this.repository = repository;
            this.passwordEncoder = passwordEncoder;
        }


        @EventListener
        public void handleApplicationReady(ApplicationReadyEvent readyEvent) {
            User user = new User();
            user.setUsername("developerbhuwan");
            user.setPassword(passwordEncoder.encode("Password"));
            repository.save(user);
        }

    }
}
