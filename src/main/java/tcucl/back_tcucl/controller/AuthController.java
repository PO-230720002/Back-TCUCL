package tcucl.back_tcucl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcucl.back_tcucl.config.JwtUtils;
import tcucl.back_tcucl.entity.User;
import tcucl.back_tcucl.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtils jwtUtils,
                          AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
       try{
           Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
           );
           if (authentication.isAuthenticated()) {
               Map<String, Object> authData = new HashMap<>();
               authData.put("token", jwtUtils.generateToken(user.getUsername()));
               authData.put("type", "Bearer");
               return ResponseEntity.ok(authData);
           }
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }catch (AuthenticationException e){
       logger.error(e.getMessage());
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

       }
    }
}
