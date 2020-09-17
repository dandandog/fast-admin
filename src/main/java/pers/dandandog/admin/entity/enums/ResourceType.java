package pers.dandandog.admin.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author JohnnyLiu
 */

@Getter
public enum ResourceType implements IEnum<Integer> {
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

    private final String name;

    ResourceType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }


}
