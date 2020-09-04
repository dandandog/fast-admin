package pers.dandandog.admin.model;

import com.dandandog.framework.mapstruct.model.Url;
import lombok.Data;

@Data
public class TestVo {

    private String name;

    private Integer age;

    private Url url;
}
