package com.venux.controller;

import com.alibaba.fastjson.JSONObject;
import com.venux.Responses;
import com.venux.dto.DealResultDto;
import com.venux.service.YamlService;
import com.venux.utils.YamlUtils;
import io.codearte.props2yaml.Props2YAML;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 转pros
 *
 * @author Alan Liu
 * @create 2018-11-15 17:03
 **/
@RestController
@RequestMapping(value = "/yaml/")
public class YamlController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private YamlService yamlService;

    @RequestMapping(value = "toProps",method = RequestMethod.POST)
    public ResponseEntity<DealResultDto> yamlToProps(@RequestBody String yamlContent) throws Exception{
        if(StringUtils.isBlank(yamlContent)){
            return Responses.dealError("没有数据可转换哟");
        }
        String props = null;
        try {
            props = yamlService.yamlToProps(yamlContent);
        } catch (Exception e) {
            logger.info("yaml转props出错",e);
            return Responses.dealError("源数据格式不对"+e.getMessage());
        }

        return Responses.dealSuccess(props);
    }

    @RequestMapping(value = "toJson",method = RequestMethod.POST)
    public ResponseEntity<DealResultDto> yamlToJson(@RequestBody String yamlContent) throws Exception{
        if(StringUtils.isBlank(yamlContent)){
            return Responses.dealError("没有数据可转换哟");
        }
        JSONObject json = null;
        try {
            json = yamlService.yamlToJson(yamlContent);
        } catch (Exception e) {
            logger.info("yaml转props出错",e);
            return Responses.dealError("源数据格式不对"+e.getMessage());
        }

        return Responses.dealSuccess(json);
    }
}