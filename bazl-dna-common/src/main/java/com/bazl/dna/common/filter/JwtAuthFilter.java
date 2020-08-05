/*
 *    Copyright 2016 10gen Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.bazl.dna.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bazl.dna.util.JwtUtils;
import com.bazl.dna.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;


/**
 * @Description:用于对客户端调用请求时验证token的合法性
 * @author zhaoyong
 * @date 2016年10月31日
 */
@Component
public class JwtAuthFilter implements Filter {


	@Value("${ACCESS_TOKEN_SECRET}")
	private String secret;
	

	// 日志
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader("Authorization");// 获取Token
		if (!Strings.isNullOrEmpty(authToken)) {//验证token
			String tokenInfo = JwtUtils.getUsernameFromToken(authToken, secret);
			if (tokenInfo != null ) {
				try {
					JSONObject json = JSON.parseObject(tokenInfo);
					AuthUser userDetails = new AuthUser(json.getString("userId"), json.getString("userName"),
							json.getString("password"),json.getString("tokenType"),json.getString("roleList"), 
							json.getString("jobList"),json.getString("isAdmin"),json.getString("orgId"),
							json.getString("userType"));
					if (Boolean.TRUE.equals(JwtUtils.validateToken(authToken, secret))) {
						httpRequest.setAttribute(RequestUtils.AUTH_USER, userDetails);
						httpRequest.setAttribute(RequestUtils.ACCESS_TOKEN, authToken);
						RequestUtils.setHttpRequest(httpRequest);
					}
				} catch (Exception e) {
					LOGGER.info(e.getMessage());
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// init
	}

	@Override
	public void destroy() {
		// destroy
	}

}
