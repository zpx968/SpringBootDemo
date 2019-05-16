package com.dgy.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgy.sys.entity.SysMenu;
import com.dgy.sys.service.ISysMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author penghu
 * @since 2019-04-27
 */
@RestController
@CrossOrigin   //解决跨域问题
@RequestMapping("/sys/sys-menu")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @RequestMapping("getPage")
    public Map<String,Object> getPage(){

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        List<SysMenu> list = sysMenuService.list(new QueryWrapper());
        IPage page = sysMenuService.page(new Page(1,3),new QueryWrapper<SysMenu>());
        map.put("list",page);
        return map;

    }

    @RequestMapping("deleteById")
    public Map<String,Object> deleteById(Integer id){
        System.out.println("id="+id);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","hellossssss");

        //sysMenuService.removeById(id);

        return map;

    }

    @RequestMapping("getMenus")
    public Map<String,Object> getMenus(){

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","hellossssss");
        List<SysMenu> list = sysMenuService.list(new QueryWrapper());
        map.put("list",list);
        return map;

    }

    @RequestMapping("getMenusByUserId")
    public Map<String,Object> getMenusByUserId(Integer user_id){

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","hellossssss");
        //List<SysMenu> list = sysMenuService.list(new QueryWrapper());
        List<SysMenu> list = sysMenuService.getMenuByUserId(user_id);
        map.put("list",list);
        return map;

    }

    public List<SysMenu> buildTree(List<SysMenu>  root){
        //获取对应对根结点的所有子节点

        for(SysMenu menu : root){
            List<SysMenu> sons = sysMenuService.list(new QueryWrapper<SysMenu>().eq("parent_id",menu.getMenuId()).ne("type",2));
            buildTree(sons);
            menu.setChildren(sons);
        }
        return root;
    }

    //包含了权限的所有的结点
    public List<SysMenu> buildTrees(List<SysMenu>  root){
        //获取对应对根结点的所有子节点

        for(SysMenu menu : root){
            //System.out.println("id="+menu.getMenuId());
            List<SysMenu> sons = sysMenuService.list(new QueryWrapper<SysMenu>().eq("parent_id",menu.getMenuId()));
            buildTrees(sons);
            menu.setChildren(sons);
        }
        return root;
    }

    @RequestMapping("getTrees")
    public Map<String,Object> getTrees(){
        Map<String,Object> map =new HashMap<String,Object>();

        List<SysMenu>  root = sysMenuService.list(new QueryWrapper<SysMenu>().eq("parent_id",0));

        List<SysMenu>  list = buildTrees(root);
        map.put("list",list);
        return map;

    }


    @RequestMapping("getTree")
    public Map<String,Object> getTree(){
        Map<String,Object> map =new HashMap<String,Object>();

        List<SysMenu>  root = sysMenuService.list(new QueryWrapper<SysMenu>().eq("parent_id",0));

        List<SysMenu>  list = buildTree(root);
        map.put("list",list);
        return map;

    }
}
