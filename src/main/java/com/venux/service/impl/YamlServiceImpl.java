package com.venux.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.venux.Responses;
import com.venux.constant.SymbolConstant;
import com.venux.service.YamlService;
import com.venux.utils.YamlUtils;
import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YamlServiceImpl implements YamlService {

    @Override
    public String yamlToProps(String yamlContent) throws Exception {
        StringBuffer props = new StringBuffer();
        List<String> propsList = YamlUtils.convertToList(yamlContent);
        if(null != propsList){
            for (String propsItem : propsList) {
                props.append(propsItem).append(SymbolConstant.LINE_BREAK);
            }
        }
        return String.valueOf(props);
    }

    @Override
    public JSONObject yamlToJson(String yamlContent) throws Exception {
        return YamlUtils.convertToJson(yamlContent);
    }
}
