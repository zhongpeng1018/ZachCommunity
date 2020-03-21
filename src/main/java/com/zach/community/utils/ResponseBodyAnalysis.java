package com.zach.community.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zach - 吸柒
 * 工具类
 * 功能:解析响应主体的参数
 */

public class ResponseBodyAnalysis {

    private Map<String, String> resultMap;

    /**
     * 获得格式化参数
     * @param ResponseBody
     * @excep
     * @return
     */
    public Map<String, String> parseResponseBody(String ResponseBody) {
        String[] bodyKeyValue = ResponseBody.split("&");
        if (bodyKeyValue.length > 0) {
            resultMap = new HashMap<String, String>();
            for (String kv : bodyKeyValue) {
                String[] params = kv.split("=");
                resultMap.put(params[0], params[1]);
            }
            return resultMap;
        }
        return null;
    }

}
