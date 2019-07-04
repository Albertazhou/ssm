package com.cetc.weiwen.service;

import java.util.Map;

/**
 * 这个接口，主要用于回调函数，如果不考虑用也可以
 * @author jhl
 * @date 2018年8月15日 上午10:55:40
 * @version 1.0 
 *
 */
public interface LogicInterface {

    /**
     * 处理业务
     * @param map
     */
    public Map<String, Object> handler(Map<String, Object> map);
}
