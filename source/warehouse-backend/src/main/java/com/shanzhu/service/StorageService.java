package com.shanzhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Storage;

/**
 * 仓库管理 业务服务层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public interface StorageService extends IService<Storage> {

    /**
     * 分页查询仓库
     *
     * @param wrapper 查询条件
     * @return 结果
     */
    IPage page(QueryPageWrapper wrapper);

}
