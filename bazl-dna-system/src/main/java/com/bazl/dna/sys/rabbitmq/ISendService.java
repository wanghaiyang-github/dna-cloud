package com.bazl.dna.sys.rabbitmq;

/**
 * 消息发送测试
 * @author zhaoyong
 *
 */
public interface ISendService {

	/**
	 * 消息发送
	 * @param message
	 */
	public void send(String message);
}
