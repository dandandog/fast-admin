package pers.dandandog.projects.model.vo;

import lombok.Data;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import pers.dandandog.projects.admin.entity.AuthResource;
import pers.dandandog.projects.admin.entity.enums.ResourceTarget;
import pers.dandandog.projects.admin.entity.enums.ResourceType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
public class ResourceVo {

    private String id;

    @NotBlank
    private String title;

    private String parentId;

    private String path;

    private String perms;

    @NotNull
    private ResourceType type = ResourceType.CATALOG;

    private String icon;

    @Min(0)
    @Max(999)
    private Integer seq;

    private Boolean display;

    private ResourceTarget target = ResourceTarget.CURR_PAGE;

    @Min(0)
    @Max(999)
    private Integer level = 0;

    private TreeNode parentNode;

    public AuthResource getParent() {
        return (AuthResource) Optional.ofNullable(parentNode).orElse(new CheckboxTreeNode(new AuthResource())).getData();
    }
}
