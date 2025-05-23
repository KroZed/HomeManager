package com.shanzhu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanzhu.common.QueryPageWrapper;
import com.shanzhu.common.R;
import com.shanzhu.entity.Menu;
import com.shanzhu.entity.User;
import com.shanzhu.service.MenuService;
import com.shanzhu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 用户 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private MenuService menuService;

    /**
     * 查询所有用户
     *
     * @return 结果
     */
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }


    /**
     * 根据账号查询用户
     *
     * @param no 账号
     * @return 用户
     */
    @GetMapping("/findByNo")
    public R findByNo(@RequestParam String no) {
        List list = userService.lambdaQuery().eq(User::getNo, no).list();
        return list.size() > 0 ? R.success(list) : R.fail();
    }


    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/save")
    public R save(@RequestBody User user) {
        return userService.save(user) ? R.success() : R.fail();
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 结果
     */
    @PostMapping("/update")
    public R update(@RequestBody User user) {
        return userService.updateById(user) ? R.success() : R.fail();
    }

    /**
     * 查询用户信息 及 菜单权限
     *
     * @param user 用户信息
     * @return 用户信息 和 菜单
     */
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        //匹配账号和密码
        List list = userService.lambdaQuery().eq(User::getNo, user.getNo()).eq(User::getPassword, user.getPassword()).list();

        if (list.size() > 0) {
            User user1 = (User) list.get(0);
            List<Menu> menuList = menuService.lambdaQuery().like(Menu::getMenuright, user1.getRoleId()).list();
            HashMap res = new HashMap();
            res.put("user", user1);
            res.put("menu", menuList);
            return R.success(res);
        }
        return R.fail();
    }

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return 修改结果
     */
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user) {
        return userService.updateById(user);
    }


    @PostMapping("/saveOrUpdate")
    public R saveOrUpdate(@RequestBody User user) {
        return userService.saveOrUpdate(user) ? R.success() : R.fail();
    }

    @GetMapping("/del")
    public R delete(Integer id) {
        return userService.removeById(id) ? R.success() : R.fail();
    }

    @PostMapping("/listP")
    public R query(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getName())) {
            wrapper.like(User::getName, user.getName());
        }
        return R.success(userService.list(wrapper));
    }


    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageWrapper query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        System.out.println("name=>" + (String) param.get("name"));

        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName, name);


        IPage result = userService.page(page, lambdaQueryWrapper);

        System.out.println("total=>" + result.getTotal());

        return result.getRecords();
    }

    @PostMapping("/listPageC1")
    public R listPageC1(@RequestBody QueryPageWrapper query) {
        HashMap param = query.getParam();
        String name = (String) param.get("name");
        String sex = (String) param.get("sex");
        String roleId = (String) param.get("roleId");

        Page<User> page = new Page();
        page.setCurrent(query.getPageNum());
        page.setSize(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(User::getName, name);
        }
        if (StringUtils.isNotBlank(sex)) {
            lambdaQueryWrapper.eq(User::getSex, sex);
        }
        if (StringUtils.isNotBlank(roleId)) {
            lambdaQueryWrapper.eq(User::getRoleId, roleId);
        }

        IPage result = userService.pageCC(page, lambdaQueryWrapper);

        System.out.println("total=>" + result.getTotal());

        return R.success(result.getRecords(), result.getTotal());
    }

}
