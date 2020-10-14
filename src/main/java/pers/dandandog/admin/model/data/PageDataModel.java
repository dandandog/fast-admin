package pers.dandandog.admin.model.data;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dandandog.framework.core.entity.BaseEntity;
import com.dandandog.framework.core.utils.MybatisUtil;
import lombok.Getter;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JohnnyLiu
 */
public class PageDataModel<T extends BaseEntity> extends LazyDataModel<T> {

    @Getter
    private ServiceImpl<? extends T, T> baseService;

    private PageDataModel(Class<T> clazz) {
        try {
            this.baseService = MybatisUtil.getOneServiceByModelClass(clazz);
        } catch (Exception ignored) {
        }
    }

    private static class InnerDataModel {
        private final static Map<Class<?>, PageDataModel<?>> dataModelMap = new ConcurrentHashMap<>();

        private static PageDataModel<?> get(Class<?> instanceClass) {
            return dataModelMap.get(instanceClass);
        }

        private static void put(Class<?> instanceClass, PageDataModel<?> dataModel) {
            dataModelMap.put(instanceClass, dataModel);
        }

        private static boolean containsKey(Class<?> instanceClass) {
            return dataModelMap.containsKey(instanceClass);
        }

    }

    public synchronized static <T extends BaseEntity> PageDataModel<T> getInstance(Class<T> instanceClass) {
        if (!InnerDataModel.containsKey(instanceClass)) {
            InnerDataModel.put(instanceClass, new PageDataModel<>(instanceClass));
        }
        return (PageDataModel<T>) InnerDataModel.get(instanceClass);
    }

    @Override
    public T getRowData(String rowKey) {
        return getBaseService().getById(rowKey);
    }

    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, FilterMeta> filters) {
        IPage<T> page = getBaseService().page(new Page<>(getPage(first, pageSize), pageSize),
                createQuery(filters.values()).orderBy(StrUtil.isNotBlank(sortField),
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

    private QueryWrapper<T> createQuery(Collection<FilterMeta> filters) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (CollUtil.isEmpty(filters)) {
            return queryWrapper;
        }
        filters.forEach(filterMeta -> {
            switch (filterMeta.getFilterMatchMode()) {
                //("startsWith"),
                case STARTS_WITH:
                    queryWrapper.likeLeft(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("endsWith"),
                case ENDS_WITH:
                    queryWrapper.likeRight(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("contains"),
                case CONTAINS:
                    queryWrapper.like(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("exact"),
                case EXACT:
                    queryWrapper.eq(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("lt"),
                case LESS_THAN:
                    queryWrapper.lt(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("lte"),
                case LESS_THAN_EQUALS:
                    queryWrapper.le(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("gt"),
                case GREATER_THAN:
                    queryWrapper.gt(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("gte"),
                case GREATER_THAN_EQUALS:
                    queryWrapper.ge(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("equals"),
                case EQUALS:

                    queryWrapper.eq(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("in"),
                case IN:
                    queryWrapper.in(ObjectUtil.isNotNull(filterMeta.getFilterValue()),
                            filterMeta.getFilterField(), filterMeta.getFilterValue());
                    break;
                //("global");
                case GLOBAL:
                    //TODO
                    break;
                default:
                    break;
            }
        });

        return queryWrapper;
    }


}
