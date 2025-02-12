package tcucl.back_tcucl.service;

import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.RefreshToken;
import tcucl.back_tcucl.entity.User;
import tcucl.back_tcucl.repository.RefreshTokenRepository;
import tcucl.back_tcucl.repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private RefreshTokenRepository refreshTokenRepository;
    private UserRepository userRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public String createToken(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new RuntimeException("User not found with username : " + username);
        }

        String token = UUID.randomUUID().toString(); // Génère un token unique

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(token);
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(Instant.now().plus(7, ChronoUnit.DAYS)); // Expire dans 7 jours

        refreshTokenRepository.save(refreshToken);
        return token;
    }

    public String validateToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElse(null);

        if (refreshToken == null || refreshToken.getExpiryDate().isBefore(Instant.now())) {
            return null; // Token invalide ou expiré
        }

        return refreshToken.getUser().getUsername(); // Retourne l'utilisateur associé
    }

    public void deleteToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}

