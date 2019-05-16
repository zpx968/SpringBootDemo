package com.dgy.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dgy.sys.entity.DiaryDiary;
import com.dgy.sys.service.IDiaryDiaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author penghu
 * @since 2019-04-28
 */
@RestController
@CrossOrigin
@RequestMapping("/sys/diary-diary")
public class DiaryDiaryController {

    @Resource
    private IDiaryDiaryService diaryService;

    @RequestMapping("insertDiary")
    public Map<String,Object> insertDiary(DiaryDiary d){

        System.out.println("title="+d.getTitle()+" weather="+d.getWeather());

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        diaryService.save(d);

        return map;
    }


    @RequestMapping("listDiary")
    public Map<String,Object> listDiary(){

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        List<DiaryDiary> list = diaryService.list(new QueryWrapper<DiaryDiary>());
        map.put("list",list);
        //sysMenuService.removeById(id);
        return map;
    }

    @RequestMapping("pageDiary")
    public Map<String,Object> pageDiary(Integer currentPage,Integer pageSize){

        //mybatisplus  分页
        Page page = new Page(currentPage,pageSize);
        QueryWrapper<DiaryDiary> wrapper = new QueryWrapper<DiaryDiary>();

        IPage p = diaryService.page(page,wrapper);

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        //List<DiaryDiary> list = diaryService.list(new QueryWrapper<DiaryDiary>());
        map.put("page",p);
        //sysMenuService.removeById(id);
        return map;
    }
    @RequestMapping("deleteDiary")
    public Map<String,Object> pageDiary(Integer id){

        System.out.println("id="+id);
        diaryService.removeById(id);

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        return map;
    }

    @RequestMapping("selectDiaryById")
    public Map<String,Object> selectDiaryById(Integer id){

        System.out.println("id="+id);
        DiaryDiary d = diaryService.getById(id);

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        map.put("diary",d);
        return map;
    }

    @RequestMapping("updateDiary")
    public Map<String,Object> pageDiary(DiaryDiary d){

        System.out.println("id="+d.getId());
        diaryService.updateById(d);

        Map<String,Object> map =new HashMap<String,Object>();
        map.put("code",0);
        return map;
    }




}
