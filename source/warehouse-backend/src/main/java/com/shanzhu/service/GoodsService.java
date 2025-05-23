package com.shanzhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Goods;

/**
 * 物品管理 业务服务层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 分页查询商品
     *
     * @param wrapper 查询条件
     * @return 结果
     */
    IPage page(QueryPageWrapper wrapper);

}
