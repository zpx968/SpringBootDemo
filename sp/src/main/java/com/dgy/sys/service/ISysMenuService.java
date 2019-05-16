package com.dgy.sys.service;

import com.dgy.sys.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author penghu
 * @since 2019-04-27
 */
public interface ISysMenuService extends IService<SysMenu> {
    List<SysMenu> getMenuByUserId(Integer user_id);

}
