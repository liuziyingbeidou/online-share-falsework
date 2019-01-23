package com.venux.controller;/**
 * Created by Administrator on 2018/11/15.
 */

import com.venux.Responses;
import com.venux.dto.DealResultDto;
import com.venux.utils.props2yaml.Props2YAML;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 转yaml
 *
 * @author Alan Liu
 * @create 2018-11-15 17:03
 **/
@RestController
@RequestMapping(value = "/props/")
class PropsController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "toYaml",method = RequestMethod.POST)
    public ResponseEntity<DealResultDto> propsToYaml(@RequestBody String propsContent) throws Exception{
        if(StringUtils.isBlank(propsContent)){
            return Responses.dealError("没有数据可转换哟");
        }
        String yaml = null;
        try {
            yaml = Props2YAML.fromContent(propsContent).convert();
        } catch (Exception e) {
            logger.info("props转yaml出错",e);
            return Responses.dealError("源数据格式不对"+e.getMessage());
        }

        return Responses.dealSuccess(yaml);
    }

}
