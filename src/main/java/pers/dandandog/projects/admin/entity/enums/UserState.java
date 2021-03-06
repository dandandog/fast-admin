package pers.dandandog.projects.admin.entity.enums;

import com.dandandog.framework.core.entity.enums.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserState implements BaseEnum<Integer> {

    /**
     * 正常
     */
    NORMAL(0, "normal"),
    /**
     * 冻结
     */
    FREEZE(1, "freeze"),
    /**
     * 未激活
     */
    INACTIVATED(2, "inactivated");

    private final int value;

    private final String title;

    UserState(int value, String title) {
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
