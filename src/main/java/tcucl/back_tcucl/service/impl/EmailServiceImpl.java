package tcucl.back_tcucl.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tcucl.back_tcucl.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.emailSender = javaMailSender;
    }

    @Override
    public void sendSimpleEmail(String name, String to, String mdp) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Création de votre compte sur TCUCL");
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText("Bonjour " + name + ",\n\n" +
                    "Bienvenue sur TCUCL, votre compte a été créé avec succès.\n" +
                    "Pour activer votre compte, connectez-vous avec votre e-mail et ce mot de passe : "+
                    mdp +"\n\n" +
                    "Cordialement,\n" +
                    "L'équipe TCUCL");
            emailSender.send(message);
            System.out.println(" Email envoyé à : " + to);
        } catch (Exception e) {
            System.out.println(" Erreur lors de l'envoi de l'email : " + e.getMessage());
        }
    }


}

