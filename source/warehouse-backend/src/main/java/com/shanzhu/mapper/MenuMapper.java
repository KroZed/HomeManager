package com.shanzhu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanzhu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单 持久层
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
