package tcucl.back_tcucl.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tcucl.back_tcucl.config.JwtUtils;
import tcucl.back_tcucl.entity.User;
import tcucl.back_tcucl.repository.UserRepository;
import tcucl.back_tcucl.service.RefreshTokenService;

import java.time.Duration;
import java.util.Collections;
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
    private final RefreshTokenService refreshTokenService;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtils jwtUtils,
                          AuthenticationManager authenticationManager,
                          RefreshTokenService refreshTokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        logger.info("API EndPoint -->  /register");
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) {
        logger.info("API EndPoint -->  /login");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if (authentication.isAuthenticated()) {
                String accessToken = jwtUtils.generateToken(user.getUsername());
                String refreshToken = refreshTokenService.createToken(user.getUsername());


                // Création du cookie sécurisé avec HttpOnly
                ResponseCookie cookie = ResponseCookie.from("refresh_token", refreshToken)
                        .httpOnly(true)  // Empêche l'accès via JavaScript
//                    .secure(true)    // Envoie uniquement en HTTPS
                        .sameSite("Strict") // Empêche l’envoi du cookie via des requêtes intersites
                        .path("/auth/refresh") // Définit le chemin où le cookie est envoyé
                        .maxAge(Duration.ofDays(7)) // Expire après 7 jours
                        .build();



                Map<String, Object> authData = new HashMap<>();
                authData.put("token", accessToken);
                authData.put("type", "Bearer");

                return ResponseEntity.ok()
                        .header("Set-Cookie", cookie.toString())
                        .body(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }



    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@CookieValue(value = "refresh_token", required = false) String refreshToken) {
        logger.info("API EndPoint -->  /refresh");

        if (refreshToken == null || refreshToken.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Refresh token is required");
        }

        String username = refreshTokenService.validateToken(refreshToken);
        if (username == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired refresh token");
        }

        String newAccessToken = jwtUtils.generateToken(username);
        return ResponseEntity.ok(Collections.singletonMap("token", newAccessToken));
    }

}
