package pers.dandandog.admin.entity.enums;

import com.dandandog.framework.core.entity.enums.IBaseEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author JohnnyLiu
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResourceType implements IBaseEnum<Integer> {
    /**
     * 目录
     */
    CATALOG(0, "catalog"),
    /**
     * 菜单
     */
    MENU(1, "menu"),
    /**
     * 按钮
     */
    BUTTON(2, "button");

    private final int value;

    private final String title;

    ResourceType(int value, String title) {
        this.value = value;
        this.title = title;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    @JsonValue
    public String getTitle() {
        return this.title;
    }
}
