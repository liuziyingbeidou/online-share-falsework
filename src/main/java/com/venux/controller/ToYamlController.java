package com.venux.controller;/**
 * Created by Administrator on 2018/11/15.
 */

import com.venux.Responses;
import com.venux.dto.DealResultDto;
import io.codearte.props2yaml.Props2YAML;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/toyaml/")
class ToYamlController {

    @RequestMapping(value = "props",method = RequestMethod.POST)
    public ResponseEntity<DealResultDto> formatJson(String propsContent) throws Exception{
        DealResultDto dealResultDto = new DealResultDto();
        if(StringUtils.isBlank(propsContent)){
            return Responses.dealError("传入内容空");
        }
        String yaml = Props2YAML.fromContent(propsContent).convert();
        return Responses.dealSuccess(yaml);
    }

}
