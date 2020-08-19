package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 18:59
 * @Description:
 */
public interface SpuInfoService {
    IPage<SpuInfo>spuList(Page<SpuInfo> spuInfoPage, String category3Id);

    void saveSpuInfo(SpuInfo spuInfo);
}
