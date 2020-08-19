package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 18:46
 * @Description:
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class SpuApiController {
    @Autowired
    SpuInfoService spuInfoService;
    @Autowired
    BaseSaleAttrService baseSaleAttrService;

    /**
     * 获取spu分页列表  商品实体的信息
     *
     * @param page
     * @param limit
     * @param category3Id 对应的三级目录的信息
     * @return
     */
    @RequestMapping("{page}/{limit}")
    public Result spuList(@PathVariable Long page, @PathVariable Long limit, String category3Id) {
        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);
        IPage<SpuInfo> spuInfos = spuInfoService.spuList(spuInfoPage, category3Id);
        return Result.ok(spuInfos);
    }

    /**
     * 获取对应销售商品的属性值
     *
     * @return
     */
    @RequestMapping("baseSaleAttrList")
    public Result baseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrs = baseSaleAttrService.baseSaleAttrList();
        return Result.ok(baseSaleAttrs);
    }

    /**
     * 保存  商品属性SPU管理  对应的信息  需要四张表的联合才可以添加
     * @param spuInfo
     * @return
     */
    @RequestMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        spuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }

}
