package com.cetc.weiwen.commons.async;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import com.cetc.weiwen.result.Result;

@Component
public class DeferredResultHolder<T> {

	private Map<String, DeferredResult<Result<T>>> map = new HashMap<String, DeferredResult<Result<T>>>();

	public Map<String, DeferredResult<Result<T>>> getMap() {
		return map;
	}

	public void setMap(Map<String, DeferredResult<Result<T>>> map) {
		this.map = map;
	}
}
