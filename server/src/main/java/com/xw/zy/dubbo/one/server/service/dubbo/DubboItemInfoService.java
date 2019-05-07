package com.xw.zy.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xw.zy.dubbo.one.api.enums.StatusCode;
import com.xw.zy.dubbo.one.api.response.BaseResponse;
import com.xw.zy.dubbo.one.api.service.ItemInfoService;
import com.xw.zy.dubbo.one.model.entity.ItemInfo;
import com.xw.zy.dubbo.one.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author xw
 * @date 2019/5/7 11:32
 */
@Service(protocol = {"dubbo","rest"},version = "1.0",timeout = 3000,validation = "true")
@Path("moocOne")
public class DubboItemInfoService implements ItemInfoService {
    private static final Logger log = LoggerFactory.getLogger(DubboItemInfoService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;
    /**
     * @author xw
     * @date
     * 列表查询服务-实际的业务实现逻辑
     * @return
     * @throws
     * @since
    */
    @Override
    @Path("item/list")
    public BaseResponse listItems() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            List<ItemInfo> list = itemInfoMapper.selectAll();
            log.info("查询到的商品列表数据：{}",list);
            response.setData(list);
        }catch (Exception e){
            log.error("列表查询服务-出现异常：",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    /**
     * @author xw
     * @date
     * 列表查询-分页查询
     * @return
     * @throws
     * @since
    */
    @Override
    @Path("item/page/list")
    public BaseResponse listPageItems(@QueryParam("pageNo")Integer pageNo, @QueryParam("pageSize") Integer pageSize, @QueryParam("search")String search) {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //分页组件
            PageHelper.startPage(pageNo, pageSize);
            PageInfo info = new PageInfo<>(itemInfoMapper.selectAllByParams(search));
            response.setData(info);
        }catch (Exception e){
            log.error("列表查询-分页查询服务-出现异常：",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }


}
