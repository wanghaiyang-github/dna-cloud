package com.bazl.dna.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 多数据源支持
 * @author zhaoyong
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 获取数据源类型
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return ContextHolder.getDataSource();
	}
	
}
