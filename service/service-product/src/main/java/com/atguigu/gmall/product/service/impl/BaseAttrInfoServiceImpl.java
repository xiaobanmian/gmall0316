package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jdk.internal.org.objectweb.asm.tree.analysis.BasicValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:shkstart
 * @create:2020-08-19 10:49
 * @Description:
 */
@Service
public class BaseAttrInfoServiceImpl implements BaseAttrInfoService {
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseAttrInfo> attrInfoList(String category3Id) {
        QueryWrapper<BaseAttrInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_level",3);
        queryWrapper.eq("category_id",category3Id);
        List<BaseAttrInfo> baseAttrInfos = baseAttrInfoMapper.selectList(queryWrapper);
        for (BaseAttrInfo baseAttrInfo : baseAttrInfos) {
            Long id = baseAttrInfo.getId();
            QueryWrapper<BaseAttrValue> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("attr_id",id);
            List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.selectList(queryWrapper1);
            baseAttrInfo.setAttrValueList(baseAttrValues);
        }
        return baseAttrInfos;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //获取id,id空插入，否则是更新
        Long id = baseAttrInfo.getId();
        if (id == null) {
            //获取属性
            baseAttrInfoMapper.insert(baseAttrInfo);
        }else{
            //修改属性值,删除属性值
            baseAttrInfoMapper.updateById(baseAttrInfo);
            QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
            wrapper.eq("attr_id",id );
            baseAttrValueMapper.delete(wrapper);
        }
        id = baseAttrInfo.getId();
        //插入属性值,获取属性值的集合
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : attrValueList) {
            //插入属性值
            baseAttrValue.setAttrId(id);
            baseAttrValueMapper.insert(baseAttrValue);
        }
    }

    @Override
    public List<BaseAttrValue> getAttrValueList(String attrId) {
        QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_id",attrId);
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.selectList(wrapper);
        return baseAttrValueList;
    }
}
