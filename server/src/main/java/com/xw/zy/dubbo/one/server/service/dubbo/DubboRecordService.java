package com.xw.zy.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.xw.zy.dubbo.one.api.enums.StatusCode;
import com.xw.zy.dubbo.one.api.request.PushOrderDto;
import com.xw.zy.dubbo.one.api.response.BaseResponse;
import com.xw.zy.dubbo.one.api.service.IDubboRecordService;
import com.xw.zy.dubbo.one.model.entity.ItemInfo;
import com.xw.zy.dubbo.one.model.entity.OrderRecord;
import com.xw.zy.dubbo.one.model.mapper.ItemInfoMapper;
import com.xw.zy.dubbo.one.model.mapper.OrderRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Date;

/**
 * @author xw
 * @date 2019/5/7 16:49
 */
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("/record")
public class DubboRecordService implements IDubboRecordService {
    private static Logger log = LoggerFactory.getLogger(DubboRecordService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Autowired
    private OrderRecordMapper orderRecordMapper;
    /**
     * @author xw
     * @date
     * 下单服务实现
     * @return
     * @throws
     * @since
    */
    @Override
    @POST
    @Path("/push")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public BaseResponse pushOrder(PushOrderDto dto) {
        if (dto.getItemId() == null || dto.getItemId() <= 0 || dto.getCustomerName() == null || dto.getTotal() == null){
            return  new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(dto.getItemId());
            if (itemInfo == null ){
                return  new BaseResponse(StatusCode.ItemNotExist);
            }

            OrderRecord orderRecord = new OrderRecord();
            BeanUtils.copyProperties(dto,orderRecord);
            orderRecord.setOrderTime(new Date());
            orderRecordMapper.insertSelective(orderRecord);
            response.setData(orderRecord.getId());
        }catch (Exception e){
            e.printStackTrace();
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;

    }
}
