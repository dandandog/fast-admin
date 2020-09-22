package pers.dandandog.admin.model.vo;

import lombok.Data;
import org.primefaces.model.TreeNode;
import pers.dandandog.admin.entity.AuthResource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RoleVo {

    private String id;

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
