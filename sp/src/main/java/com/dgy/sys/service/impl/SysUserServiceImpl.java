package com.dgy.sys.service.impl;

import com.dgy.sys.entity.SysUser;
import com.dgy.sys.mapper.SysUserMapper;
import com.dgy.sys.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author penghu
 * @since 2019-04-27
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
