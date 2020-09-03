package pers.dandandog.admin.controller;

import com.dandandog.framework.common.utils.SpringContextUtil;
import com.dandandog.framework.mapstruct.MapperRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dandandog.admin.model.Test;
import pers.dandandog.admin.model.TestVo;

@RestController
@RequestMapping("/test")
@Api(value = "FooBarAPI", tags = {"FooBar"})
public class TestController {


    @GetMapping("/hello")
    @ApiOperation("Lists journals")
    public Object hello() {
        Test test = new Test();
        test.setName("liuqiang");
        test.setAge(11);
        return MapperRepo.mapTo(test, TestVo.class);
    }


    @GetMapping("/No")
    @ApiOperation("no no no ")
    public Object no() {
        Object o = SpringContextUtil.getBean("admin");
        return o;
    }

}
