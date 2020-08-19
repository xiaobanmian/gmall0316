package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 18:51
 * @Description: 交易类型的品牌
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class TradeMarkApiController {
    @Autowired
    BaseTrademarkService baseTrademarkService;

    /**
     * 获取对应的商品品牌名称
     * @return
     */
    @RequestMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList() {
        List<BaseTrademark> getTrademarkList = baseTrademarkService.getTrademarkList();
        return Result.ok(getTrademarkList);
    }
}
