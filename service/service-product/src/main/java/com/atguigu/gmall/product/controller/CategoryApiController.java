package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 10:39
 * @Description:
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class CategoryApiController {
    @Autowired
    BaseCategoryService baseCategoryService;

    @RequestMapping("getCategory1")
    public Result getCategory1(){
        List<BaseCategory1> baseCategoryList = baseCategoryService.getCategory1();
        return Result.ok(baseCategoryList);
    }

    @RequestMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") String category1Id){
        List<BaseCategory2> baseCategoryList = baseCategoryService.getCategory2(category1Id);
        return Result.ok(baseCategoryList);
    }
    @RequestMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") String category2Id){
        List<BaseCategory3> baseCategoryList = baseCategoryService.getCategory3(category2Id);
        return Result.ok(baseCategoryList);
    }
}
