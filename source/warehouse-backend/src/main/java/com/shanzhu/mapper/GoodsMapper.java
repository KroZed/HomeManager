package com.shanzhu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.shanzhu.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 物品管理 持久层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage pageCC(IPage<Goods> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
