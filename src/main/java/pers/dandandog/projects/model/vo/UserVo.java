package pers.dandandog.projects.model.vo;

import cn.hutool.core.util.StrUtil;
import com.dandandog.framework.mapstruct.model.MapperUrl;
import com.dandandog.framework.mapstruct.model.MapperVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.primefaces.model.DualListModel;
import pers.dandandog.projects.admin.entity.AuthRole;
import pers.dandandog.projects.admin.entity.AuthUser;
import pers.dandandog.projects.admin.entity.enums.UserGender;
import pers.dandandog.projects.admin.entity.enums.UserState;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserVo extends MapperVo<AuthUser> {

    @NotEmpty
    private String nickname;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String email;

    private String phone;

    private UserState status = UserState.INACTIVATED;

    private UserGender gender = UserGender.UNKNOWN;

    private MapperUrl avatarUrl;

    private String remark;

    private LocalDateTime pwdRestTime;

    private DualListModel<AuthRole> roleModel = new DualListModel<>();

}
