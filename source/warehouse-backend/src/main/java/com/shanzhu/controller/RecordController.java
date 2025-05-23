package com.shanzhu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.common.R;
import com.shanzhu.entity.Goods;
import com.shanzhu.entity.Record;
import com.shanzhu.service.GoodsService;
import com.shanzhu.service.RecordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 记录管理 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    @Resource
    private GoodsService goodsService;

    /**
     * 新增记录
     *
     * @param record
     * @return 结果
     */
    @PostMapping("/save")
    public R save(@RequestBody Record record){
        Goods goods = goodsService.getById(record.getGoods());
        int n = record.getCount();
        // 出库
        if("2".equals(record.getAction())){
            n = -n;
            record.setCount(n);
        }

        int num = goods.getCount()+n;
        if(num < 0) {
            return R.fail();
        }
        goods.setCount(num);
        goodsService.updateById(goods);
        record.setCreatetime(LocalDateTime.now());
        return recordService.save(record)? R.success(): R.fail();
    }

    /**
     * 分页查询记录
     *
     * @param query 查询条件
     * @return 记录列表
     */
    @PostMapping("/listPage")
    public R listPage(@RequestBody QueryPageWrapper query){
        IPage result = recordService.page(query);
        return R.success(result.getRecords(),result.getTotal());
    }

}
