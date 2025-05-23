package com.shanzhu.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanzhu.entity.Menu;
import com.shanzhu.mapper.MenuMapper;
import com.shanzhu.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
