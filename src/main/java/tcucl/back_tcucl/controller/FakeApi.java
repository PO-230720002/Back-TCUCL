package tcucl.back_tcucl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fakeApi")
public class FakeApi {

    @GetMapping("/")
    public String getFakeResource() {
        return "tu as accédé à une ressource protégée";
    }
}
