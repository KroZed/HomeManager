package com.shanzhu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.common.R;
import com.shanzhu.entity.Storage;
import com.shanzhu.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 仓库管理 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 新增仓库
     *
     * @param storage 仓库信息
     * @return 结果
     */
    @PostMapping("/save")
    public R save(@RequestBody Storage storage) {
        return storageService.save(storage) ? R.success() : R.fail();
    }

    /**
     * 更新
     *
     * @param storage 仓库信息
     * @return 结果
     */
    @PostMapping("/update")
    public R update(@RequestBody Storage storage) {
        return storageService.updateById(storage) ? R.success() : R.fail();
    }

    /**
     * 删除仓库
     *
     * @param id 仓库id
     * @return 结果
     */
    @GetMapping("/del")
    public R del(@RequestParam String id) {
        return storageService.removeById(id) ? R.success() : R.fail();
    }

    /**
     * 查询仓库列表
     *
     * @return 仓库列表
     */
    @GetMapping("/list")
    public R list() {
        return R.success(storageService.list());
    }

    /**
     * 分页查询仓库
     *
     * @param query 查询条件
     * @return 仓库列表
     */
    @PostMapping("/listPage")
    public R listPage(@RequestBody QueryPageWrapper query) {
        IPage result = storageService.page(query);
        return R.success(result.getRecords(), result.getTotal());
    }

}
