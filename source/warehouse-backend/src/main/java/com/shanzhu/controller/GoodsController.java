package com.shanzhu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.common.R;
import com.shanzhu.entity.Goods;
import com.shanzhu.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 物品管理 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 新增物品
     *
     * @param goods 物品信息
     * @return 结果
     */
    @PostMapping("/save")
    public R save(@RequestBody Goods goods) {
        return goodsService.save(goods) ? R.success() : R.fail();
    }

    /**
     * 更新物品
     *
     * @param goods 物品信息
     * @return 结果
     */
    @PostMapping("/update")
    public R update(@RequestBody Goods goods) {
        return goodsService.updateById(goods) ? R.success() : R.fail();
    }

    /**
     * 删除物品
     *
     * @param id 物品id
     * @return 结果
     */
    @GetMapping("/del")
    public R del(@RequestParam String id) {
        return goodsService.removeById(id) ? R.success() : R.fail();
    }

    /**
     * 分页查询商品
     *
     * @param query 分页参数
     * @return 结果
     */
    @PostMapping("/listPage")
    public R listPage(@RequestBody QueryPageWrapper query) {
        IPage result = goodsService.page(query);
        return R.success(result.getRecords(), result.getTotal());
    }

}
