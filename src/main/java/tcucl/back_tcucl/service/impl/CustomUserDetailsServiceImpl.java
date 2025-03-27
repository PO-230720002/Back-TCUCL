package tcucl.back_tcucl.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.entity.Utilisateur;
import tcucl.back_tcucl.repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Ne pas changer le nom de la méthode loadByUsername en loadUserByEmail, sinon l'authentification ne fonctionnera pas
    //loadByUsername Override la méthode loadUserByUsername de l'interface UserDetailsService qui fait partie de Spring Security (le framework)
    // Pas toucher !
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Utilisateur> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le mail : " + email);
        }

        Utilisateur utilisateur = userOptional.get();
        return new org.springframework.security.core.userdetails.User(
                utilisateur.getEmail(),
                utilisateur.getMdp(),
                Collections.singletonList(new SimpleGrantedAuthority(utilisateur.getRole()))
        );
    }
}