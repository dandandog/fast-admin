package pers.dandandog.admin.model.vo;

import lombok.Data;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.TreeNode;
import pers.dandandog.admin.entity.AuthResource;
import pers.dandandog.admin.entity.enums.ResourceTarget;
import pers.dandandog.admin.entity.enums.ResourceType;

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

    private TreeNode parentNode;

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

    public AuthResource getParent() {
        return (AuthResource) Optional.ofNullable(parentNode).orElse(new CheckboxTreeNode()).getData();
    }
}
