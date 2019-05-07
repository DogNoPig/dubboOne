package com.xw.zy.dubbo.one.server.controller;

import com.xw.zy.dubbo.one.api.enums.StatusCode;
import com.xw.zy.dubbo.one.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xw
 * @date 2019/5/7 9:59
 */
@RestController
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    private static final String prefix = "base";

    /**
     * 测试helloworld
     * @author xw
     * @date
     * @return
     * @throws
     * @since
    */
    @GetMapping(prefix+"/one")
    public BaseResponse one(@RequestParam String param){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            response.setData(param);
        }catch (Exception e){
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }


        return response;
    }



}
