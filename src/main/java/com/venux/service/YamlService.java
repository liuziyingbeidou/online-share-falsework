package com.venux.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface YamlService {

    /**
     * yaml转properties
     * @param yamlContent
     * @return
     * @throws Exception
     */
    public String yamlToProps(String yamlContent) throws Exception;

    /**
     * yaml转json
     * @param yamlContent
     * @return
     * @throws Exception
     */
    public JSONObject yamlToJson(String yamlContent) throws Exception;
}
