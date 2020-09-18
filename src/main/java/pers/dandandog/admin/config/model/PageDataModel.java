package pers.dandandog.admin.config.model;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.TypeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.core.utils.MybatisUtil;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author JohnnyLiu
 */
public class PageDataModel<T extends BaseEntity> extends LazyDataModel<T> {
    private static final long serialVersionUID = 2957926997919683676L;


    public Map<String, Object> filters;

    public PageDataModel setFilters(Map filters) {
        this.filters = filters;
        return this;
    }


    public BaseMapper<T> getBaseMapper() {
        Class clazz = getMClass();
        try {
            return MybatisUtil.getMapper(clazz);
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public T getRowData(String rowKey) {
        return getBaseMapper().selectById(Long.valueOf(rowKey));
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filters) {
        IPage<T> page = getBaseMapper().selectPage(new Page<>(getPage(first, pageSize), pageSize),
                new QueryWrapper<T>().orderBy(StrUtil.isNotBlank(sortField),
                        SortOrder.ASCENDING.equals(sortOrder), sortField));
        this.setRowCount((int) page.getTotal());
        return page.getRecords();
    }

    @Override
    public void setRowIndex(int rowIndex) {
        super.setRowIndex((getPageSize() == 0) ? -1 : rowIndex);
    }

    private int getPage(int first, int pageSize) {
        int pageNum = (pageSize > 0) ? (first / pageSize) : 0;
        return pageNum + 1;
    }

    private Class<?> getMClass() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        return TypeUtil.getClass(type);
    }

}
