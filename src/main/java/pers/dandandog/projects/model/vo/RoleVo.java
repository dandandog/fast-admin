package pers.dandandog.projects.model.vo;

import com.dandandog.framework.mapstruct.model.MapperVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.primefaces.model.TreeNode;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.entity.AuthRole;
import pers.dandandog.projects.admin.entity.AuthUser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleVo extends MapperVo<AuthRole> {

    private String name;

    private String code;

    private Integer level;

    private Integer dataScope;

    private String remark;

    private TreeNode[] resourceNodes = new TreeNode[0];

    public List<AuthResource> getResources() {
        return Arrays.stream(resourceNodes)
                .map(treeNode -> (AuthResource) treeNode.getData()).collect(Collectors.toList());
    }
}
