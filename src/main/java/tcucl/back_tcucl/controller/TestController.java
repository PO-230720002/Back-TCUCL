package tcucl.back_tcucl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcucl.back_tcucl.entity.facteurEmission.FacteurEmissionParametre;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public int testget() {

        System.out.println(FacteurEmissionParametre.ENERGIE);
        System.out.println(FacteurEmissionParametre.ENERGIE_.GAZ);
        System.out.println(FacteurEmissionParametre.ENERGIE_.GAZ_.MWh_PCS);

        return 0;
    }

    @PostMapping("/{value}]")
    public void testPost(@PathVariable int value) {
    }
}
