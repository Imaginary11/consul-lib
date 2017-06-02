package cn.org.imaginary.common.core;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Imaginary
 * @see
 * @since 1.0
 */
public interface HealthCheck {
    JSONObject up();

    JSONObject down();
}
