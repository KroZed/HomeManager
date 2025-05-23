package com.shanzhu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.common.R;
import com.shanzhu.entity.Goodstype;
import com.shanzhu.service.GoodsTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 物品分类管理 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/goodstype")
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodstypeService;
    
    /**
     * 新增物品分类
     *
     * @param goodstype 物品分类信息
     * @return 结果
     */
    @PostMapping("/save")
    public R save(@RequestBody Goodstype goodstype){
        return goodstypeService.save(goodstype)? R.success(): R.fail();
    }

    /**
     * 更新物品分类
     *
     * @param goodstype 物品分类信息
     * @return 结果
     */
    @PostMapping("/update")
    public R update(@RequestBody Goodstype goodstype){
        return goodstypeService.updateById(goodstype)? R.success(): R.fail();
    }
    

    /**
     * 删除物品分类
     *
     * @param id 物品分类id
     * @return 结果
     */
    @GetMapping("/del")
    public R del(@RequestParam String id){
        return goodstypeService.removeById(id)? R.success(): R.fail();
    }
    
    /**
     * 查询物品分类
     *
     * @return 物品分类列表
     */
    @GetMapping("/list")
    public R list(){
        List list = goodstypeService.list();
        return R.success(goodstypeService.list());
    }

    /**
     * 分页查询物品分类
     *
     * @param query 查询条件
     * @return 物品分类
     */
    @PostMapping("/listPage")
    public R listPage(@RequestBody QueryPageWrapper query){
        IPage result = goodstypeService.page(query);
        return R.success(result.getRecords(),result.getTotal());
    }
    
}
