package com.venux.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.yaml.snakeyaml.Yaml;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: YamlUtils
* @Description: (Yaml转换工具类)
 */
public class YamlUtils {

   /**
    * Yaml转json
    * @param yamlString
    * @return
    */
   public static JSONObject convertToJson(String yamlString) {
       Yaml yaml= new Yaml();
       Map<String, Object> map = (Map<String, Object>) yaml.load(yamlString);
       JSONObject jsonObject=new JSONObject(map);
       return jsonObject;
   }
   
   /**
    * Yaml转Object
    * @param yamlString
    * @return
    */
   public static Object convertToObject(String yamlString) {
       Yaml yaml= new Yaml();
       Object obj = yaml.load(yamlString);
       return obj;
   }

    /**
     * Yaml转List
     * @param yamlString
     * @return
     */
    public static List<String> convertToList(String yamlString){
        final String DOT = ".";
        List<String> lines = new LinkedList<>();
        try {
            YAMLFactory yamlFactory = new YAMLFactory();
            YAMLParser parser = yamlFactory.createParser(new StringReader(yamlString));

            String key = "";
            String value = null;
            JsonToken token = parser.nextToken();
            while (token != null) {
                if (JsonToken.START_OBJECT.equals(token)) {
                    // do nothing
                } else if (JsonToken.FIELD_NAME.equals(token)) {
                    if (key.length() > 0) {
                        key = key + DOT;
                    }
                    key = key + parser.getCurrentName();

                    token = parser.nextToken();
                    if (JsonToken.START_OBJECT.equals(token)) {
                        continue;
                    }
                    value = parser.getText();
                    lines.add(key + "=" + value);

                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    }
                    value = null;
                } else if (JsonToken.END_OBJECT.equals(token)) {
                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    } else {
                        key = "";
                        //lines.add("");
                    }
                }
                token = parser.nextToken();
            }
            parser.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}