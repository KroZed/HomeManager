package com.shanzhu.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.entity.Storage;
import com.shanzhu.mapper.StorageMapper;
import com.shanzhu.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author rabbiter
 * @since 2023-01-05
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public IPage page(QueryPageWrapper wrapper) {
        HashMap param = wrapper.getParam();
        String name = (String) param.get("name");

        Page<Storage> page = new Page();
        page.setCurrent(wrapper.getPageNum());
        page.setSize(wrapper.getPageSize());

        LambdaQueryWrapper<Storage> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            queryWrapper.like(Storage::getName, name);
        }
        return storageMapper.pageCC(page, queryWrapper);
    }
}
