package tcucl.back_tcucl.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    // Me Permet d'accepter null dans des ENUM 
    // Pas assez sécurisé à mon goût mais voilà ça existe 

    // Actuellement désactivé car pas assez sécurisé
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer customizer() {
//        return builder -> builder
//                .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//    }
}