package com.dgy.sys.mapper;

import com.dgy.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author penghu
 * @since 2019-04-27
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> getMenuByUserId(@Param("user_id") Integer user_id);

}
