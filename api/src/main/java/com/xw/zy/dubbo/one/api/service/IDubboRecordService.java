package com.xw.zy.dubbo.one.api.service;

import com.xw.zy.dubbo.one.api.request.PushOrderDto;
import com.xw.zy.dubbo.one.api.response.BaseResponse;

/**
 * @author xw
 * @date 2019/5/7 16:43
 */
public interface IDubboRecordService {
    BaseResponse pushOrder(PushOrderDto dto);
}
