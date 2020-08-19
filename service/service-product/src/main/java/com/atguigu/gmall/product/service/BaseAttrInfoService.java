package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 10:49
 * @Description:
 */

public interface BaseAttrInfoService {

    List<BaseAttrInfo> attrInfoList(String category3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseAttrValue> getAttrValueList(String attrId);

}
