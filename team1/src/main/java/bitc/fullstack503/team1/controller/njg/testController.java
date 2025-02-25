package bitc.fullstack503.team1.controller.njg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
@RequestMapping("/njg")
  public String test() {
    return "main/NJG/spot1";
  }
}
