package org.maxwell.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description: json工具类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/12 0:55
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * json字符串转JosnNode对象
     */
    public static JsonNode strToJsonNode(String str) {
        try {
            return OBJECT_MAPPER.readTree(str);
        } catch (JsonProcessingException e) {
            return OBJECT_MAPPER.createObjectNode();
        }
    }

}
