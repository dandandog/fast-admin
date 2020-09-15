package pers.dandandog.admin.controller;

import com.dandandog.framework.faces.controller.FacesController;
import org.springframework.stereotype.Controller;

/**
 * @author JohnnyLiu
 */
@Controller("/test.faces")
public class TestController extends FacesController {

    @Override
    public void onEntry() {
        throw new RuntimeException("error");
    }
}
