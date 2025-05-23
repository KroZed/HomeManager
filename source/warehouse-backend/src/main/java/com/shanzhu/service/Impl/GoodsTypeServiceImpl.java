package com.shanzhu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Goodstype;
import com.shanzhu.mapper.GoodstypeMapper;
import com.shanzhu.service.GoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodsTypeService {

    @Resource
    private GoodstypeMapper goodstypeMapper;

    @Override
    public IPage page(QueryPageWrapper wrapper) {
        HashMap param = wrapper.getParam();
        String name = (String)param.get("name");

        Page<Goodstype> page = new Page();
        page.setCurrent(wrapper.getPageNum());
        page.setSize(wrapper.getPageSize());

        LambdaQueryWrapper<Goodstype> queryWrapper = new LambdaQueryWrapper();
        if(StringUtils.isNotBlank(name) && !"null".equals(name)){
            queryWrapper.like(Goodstype::getName,name);
        }
        return goodstypeMapper.pageCC(page,queryWrapper);
    }
}
