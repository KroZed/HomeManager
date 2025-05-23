package com.shanzhu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.shanzhu.entity.Goodstype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 物品分类管理 持久层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@Mapper
public interface GoodstypeMapper extends BaseMapper<Goodstype> {

    IPage pageCC(IPage<Goodstype> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
