package com.venux.yaml;

import com.alibaba.fastjson.JSONObject;
import com.venux.utils.YamlUtils;

public class Yaml2PropsTest {
    public static void main(String[] args){
        String content = "dubbo:\n" +
                "    admin:\n" +
                "        guest:\n" +
                "            password: guest\n" +
                "        root:\n" +
                "            password: root\n" +
                "    registry:\n" +
                "        address: zookeeper://10.0.65.3:2181\n";
        JSONObject jsonObj = YamlUtils.convertToJson(content);

        System.out.println(jsonObj);
        System.out.println(YamlUtils.convertToList(content));


    }
}
