package tcucl.back_tcucl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcucl.back_tcucl.config.AnneeConfig;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public int testget() {
        return 0;
    }

    @PostMapping("/{value}]")
    public void testPost(@PathVariable int value) {
    }
}
