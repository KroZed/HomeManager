package com.shanzhu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Record;

/**
 * 记录管理 业务服务层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public interface RecordService extends IService<Record> {

    IPage page(QueryPageWrapper wrapper);

}
