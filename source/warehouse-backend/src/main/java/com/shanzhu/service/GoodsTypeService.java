package com.shanzhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Goodstype;

/**
 * 物品分类管理 业务服务层
 *
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public interface GoodsTypeService extends IService<Goodstype> {

    /**
     * 分页查询物品分类
     *
     * @param wrapper 查询条件
     * @return 物品分类
     */
    IPage page(QueryPageWrapper wrapper);

}
