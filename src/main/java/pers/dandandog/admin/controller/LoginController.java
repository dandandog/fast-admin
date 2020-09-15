package pers.dandandog.admin.controller;

import com.dandandog.framework.common.utils.SecurityUtil;
import com.dandandog.framework.faces.controller.FacesController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * @author JohnnyLiu
 */
@Slf4j
@Controller("/login.faces")
public class LoginController extends FacesController {

    @Override
    public void onEntry() {
        if (SecurityUtil.isLogin()) {
            redirectInternal("/index.faces");
        }
    }
}
