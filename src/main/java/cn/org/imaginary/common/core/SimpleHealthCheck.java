package cn.org.imaginary.common.core;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public class SimpleHealthCheck implements HealthCheck {
    public JSONObject up() {
        JSONObject status = new JSONObject();
        status.put("status", "up");
        return status;
    }

    public JSONObject down() {
        JSONObject status = new JSONObject();
        status.put("status", "down");
        return status;
    }
}
