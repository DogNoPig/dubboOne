package com.xw.zy.dubbo.one.api.service;

import com.xw.zy.dubbo.one.api.response.BaseResponse;

/**
 * @author xw
 * @date 2019/5/7 11:30
 */
public interface ItemInfoService {
    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo, Integer pageSize, String search);
}
