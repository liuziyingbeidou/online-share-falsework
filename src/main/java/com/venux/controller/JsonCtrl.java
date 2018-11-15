package com.venux.controller;/**
 * Created by Administrator on 2018/11/15.
 */

import com.venux.utils.JsonFormatTool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * JSON格式数据处理
 *
 * @author Alan Liu
 * @create 2018-11-15 17:03
 **/
@RestController
@RequestMapping(value = "/json/")
public class JsonCtrl {

    @RequestMapping(value = "format",method = RequestMethod.GET)
    public String formatJson(String jsonStr) throws Exception{
        String str = "{'age':23,'aihao':['pashan','movies'],'name':{'firstName':'zhang','lastName':'san','aihao':['pashan','movies','name':{'firstName':'zhang','lastName':'san','aihao':['pashan','movies']}]}}";

        return JsonFormatTool.formatJson(str);
    }
}
