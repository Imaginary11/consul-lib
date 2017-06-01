package cn.org.imaginary.common.util;

import com.alibaba.fastjson.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

/**
 * Copyright : Abloomy Technologies , Inc .
 * Author    : chen.chi@abloomy.com.cn
 * Date      : 2017/5/2 15 01
 * Version   : V1.0
 * Desc      :
 */
public class YmlUtil {
    private YmlUtil() {
    }

    public static JSONObject getPropFromYaml(String relativePath) throws IllegalAccessException {
        JSONObject ymlProp;
        Map<String, Object> map = null;
        try {
            Yaml yaml = new Yaml();
            URL url = YmlUtil.class.getClassLoader().getResource(relativePath);
            if (url != null) {
                map = (Map) yaml.load(new FileInputStream(url.getFile()));
            }
            ymlProp = (JSONObject) JSONObject.toJSON(map);
            return ymlProp;
        } catch (Exception e) {
            throw new IllegalArgumentException("parse yml error");
        }
    }
}
