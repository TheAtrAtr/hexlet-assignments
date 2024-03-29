package exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
class WelcomeController {
    @GetMapping()
    public String wellcomme(){
        return "Welcome to Spring";
    }

    @GetMapping("/hello")
    public String wellcomme(@RequestParam(value = "name", defaultValue = "World") String string){
        return String.format("Hello, %s!", string);
    }
        }
// END
