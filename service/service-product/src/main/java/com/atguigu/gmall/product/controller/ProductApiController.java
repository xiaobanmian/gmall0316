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
 * @create:2020-08-18 20:59
 * @Description:
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class ProductApiController {
    @Autowired
    BaseCategoryService baseCategoryService;

    @RequestMapping("testProductApi")
    public String testProductApi(){
        return "testProductApi";
    }




}

