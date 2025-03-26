package tcucl.back_tcucl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcucl.back_tcucl.service.EmailService;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/fakeApi")
public class FakeApi {

    private final EmailService emailService;

    public FakeApi(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/")
    public String getFakeResource() {
        return "tu as accédé à une ressource protégée";
    }

    @PostMapping("/sendEmail/{email}/")
    public String sendEmail(String email) {
        emailService.sendSimpleEmail("connard", email, "mdp");
        return "email sent";
    }
}
