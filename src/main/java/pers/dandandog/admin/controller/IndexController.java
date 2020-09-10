package pers.dandandog.admin.controller;


import com.dandandog.framework.faces.controller.FacesController;
import org.springframework.stereotype.Controller;

/**
 * 系统资源(SysResource)表控制层
 *
 * @author JohnnyLiu
 * @since 2020-09-06 22:06:06
 */
@Controller("/views/index.faces")
public class IndexController extends FacesController {

    @Override
    public void onEntry() {
        putViewScope("name", "hello world");
    }

}