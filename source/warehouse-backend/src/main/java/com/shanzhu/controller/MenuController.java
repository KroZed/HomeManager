package com.shanzhu.controller;


import com.shanzhu.common.R;
import com.shanzhu.entity.Menu;
import com.shanzhu.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 通过角色获取菜单
     *
     * @param roleId 角色id
     * @return 菜单
     */
    @GetMapping("/list")
    public R list(@RequestParam String roleId) {
        return R.success(
                menuService.lambdaQuery()
                        .like(Menu::getMenuright, roleId)
                        .list()
        );
    }

}
