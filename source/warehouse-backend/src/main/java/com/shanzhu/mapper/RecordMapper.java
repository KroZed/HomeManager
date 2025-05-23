package com.shanzhu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.shanzhu.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 记录管理 持久层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    IPage pageCC(IPage<Record> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
