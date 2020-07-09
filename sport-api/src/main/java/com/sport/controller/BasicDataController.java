package com.sport.controller;

import com.github.pagehelper.PageInfo;
import com.sport.common.result.CommResult;
import com.sport.common.result.HttpResult;
import com.sport.entity.BasicDataEntity;
import com.sport.service.BasicDataService;
import com.sport.vo.BasicDataVO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author macos·lxk
 * @create 2020/7/8 3:27 下午
 */
@Api(value = "API - BisicDataController",description = "基础数据接口说明")
@Controller
@ResponseBody
@RequestMapping("basicData")
public class BasicDataController {
    @Resource
    private BasicDataService basicDataService;

    @ApiOperation(value="获取基础数据", response= CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response= BasicDataVO.class)
    })
    @PostMapping(value = "/getBasicDataByType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResult<BasicDataVO> getBasicDataByType(HttpServletRequest request,
                                                      @ApiParam(value = "数据类型",required=true)@RequestParam("type")String type){
        HttpResult<BasicDataVO> result = new HttpResult<>();
        List<BasicDataVO> list = null;
        if (type != null) {
            list = basicDataService.getBasicDataByType(Short.valueOf(type));
        }

        result.setData(list);
        return result;
    }

    @ApiOperation(value="添加", response=CommResult.class)
    @PostMapping(value = "insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult insertBasicData(HttpServletRequest request,BasicDataEntity basicDataEntity){
        boolean flag = basicDataService.insertBasicData(basicDataEntity);
        if(flag){
            return CommResult.ok();
        }
        return CommResult.error("添加失败。");
    }

    @ApiOperation(value="查询所有类型", response=CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=BasicDataVO.class)
    })
    @PostMapping(value = "/getAllNames",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult getAllNames(HttpServletRequest request){
        List<BasicDataVO> list = basicDataService.getAllNames();
        System.out.println(list);
        return CommResult.ok(list);
    }

    @ApiOperation(value="查询所有数据", response=CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=BasicDataVO.class)
    })
    @PostMapping(value = "getAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommResult getAllBasicData(HttpServletRequest request,BasicDataEntity entity){
        List<BasicDataVO> list = basicDataService.getAllBasicDataListByCondition(entity);
        return CommResult.ok(list);
    }

    @ApiOperation(value="分页查询所有数据", response=CommResult.class)
    @ApiResponses({
            @ApiResponse(code=200,message="成功,返回content中vo类参数如下", response=BasicDataVO.class)
    })
    @PostMapping(value = "getAllByPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public HttpResult<BasicDataVO> getAllByPageBasicData(HttpServletRequest request,
                                                         @ApiParam(value = "起始页",required = true)@RequestParam(value = "page",defaultValue="1")Integer page,
                                                         @ApiParam(value = "每页条数",required = true)@RequestParam(value = "size",defaultValue="10")Integer size,BasicDataEntity entity){
        HttpResult<BasicDataVO> result = new HttpResult<>();
        PageInfo<BasicDataVO> pages = basicDataService.getPageBasicDataListByCondition(page,size,entity);
        result.setData(pages.getList());
        result.setiTotalRecords(pages.getTotal());
        return result;
    }
}
