package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 10:40
 * @Description:
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class AttrApiController {
    @Autowired
    BaseAttrInfoService baseAttrInfoService;


    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category1Id") String category1Id,
                               @PathVariable("category2Id") String category2Id,
                               @PathVariable("category3Id") String category3Id) {
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.attrInfoList(category3Id);
        return Result.ok(baseAttrInfoList);
    }

    @RequestMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
        baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    @RequestMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable String attrId) {
        List<BaseAttrValue> baseAttrValueList = baseAttrInfoService.getAttrValueList(attrId);
        return Result.ok(baseAttrValueList);
    }


}
