package com.shanzhu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Record;
import com.shanzhu.mapper.RecordMapper;
import com.shanzhu.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private RecordMapper recordMapper;

    @Override
    public IPage page(QueryPageWrapper wrapper) {
        HashMap param = wrapper.getParam();
        String name = (String) param.get("name");
        String goodstype = (String) param.get("goodstype");
        String storage = (String) param.get("storage");
        String roleId = (String) param.get("roleId");
        String userId = (String) param.get("userId");

        Page page = new Page();
        page.setCurrent(wrapper.getPageNum());
        page.setSize(wrapper.getPageSize());

        QueryWrapper<Record> queryWrapper = new QueryWrapper();
        queryWrapper.apply("a.goods=b.id and b.storage=c.id and b.goodsType=d.id ");

        if ("2".equals(roleId)) {
            queryWrapper.apply(" a.userId= " + userId);
        }

        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            queryWrapper.like("b.name", name);
        }
        if (StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)) {
            queryWrapper.eq("d.id", goodstype);
        }
        if (StringUtils.isNotBlank(storage) && !"null".equals(storage)) {
            queryWrapper.eq("c.id", storage);
        }

        return recordMapper.pageCC(page, queryWrapper);
    }

}
