package com.dgy.sys.service.impl;

import com.dgy.sys.entity.SysMenu;
import com.dgy.sys.mapper.SysMenuMapper;
import com.dgy.sys.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author penghu
 * @since 2019-04-27
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getMenuByUserId(Integer user_id) {

        return this.baseMapper.getMenuByUserId(user_id);
    }
}
