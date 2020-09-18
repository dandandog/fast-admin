package pers.dandandog.admin.config.model;

import cn.hutool.core.util.TypeUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dandandog.framework.core.entity.ITree;
import com.dandandog.framework.core.utils.MybatisUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author create by Johnny
 * @description com.johnny.framework.web.faces.model
 * @date 八月 01,2019
 */
public class TreeDataModel<T extends ITree> {

    private TreeDataModel() {
    }

    private static class InnerAccountDataModel {
        private static final TreeDataModel dataModel = new TreeDataModel<>();
    }

    public static TreeDataModel getInstance() {
        TreeDataModel treeDataModel = TreeDataModel.InnerAccountDataModel.dataModel;
        return treeDataModel;
    }

    private Class<?> getMClass() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return TypeUtil.getClass(type);
    }


    public BaseMapper<T> getBaseMapper() {
        Class<T> clazz = (Class<T>) getMClass();
        try {
            return MybatisUtil.getMapper(clazz);
        } catch (Exception ignored) {
        }
        return null;
    }


    private List<T> load(LambdaQueryWrapper<T> queryWrapper) {
        return getBaseMapper().selectList(queryWrapper);
    }


    public Multimap<T, T> getValue(LambdaQueryWrapper<T> queryWrapper) {
        List<T> sources = load(queryWrapper);
        Multimap<String, T> idMap = ArrayListMultimap.create();
        sources.forEach(t -> {
            idMap.put(t.getParentId(), t);
        });
        Multimap<T, T> objMap = ArrayListMultimap.create();

        idMap.keySet().forEach(id -> {
            sources.forEach(t -> {
                if (id.equals(t.getId())) {
                    objMap.putAll(t, idMap.get(id));
                }
            });
        });
        objMap.putAll(null, idMap.get(null));

        return objMap;
    }
}
