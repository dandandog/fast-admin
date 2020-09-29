package pers.dandandog.admin.model.vo;

import lombok.Data;
import org.primefaces.model.DualListModel;
import pers.dandandog.admin.entity.AuthRole;
import pers.dandandog.admin.entity.enums.UserGender;
import pers.dandandog.admin.entity.enums.UserState;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class UserVo {

    private String id;

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

    private String avatarUrl;

    private String remark;

    private LocalDateTime pwdRestTime;

    private DualListModel<AuthRole> roleModel = new DualListModel<>();

}
