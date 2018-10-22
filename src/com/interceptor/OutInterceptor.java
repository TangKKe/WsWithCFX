package com.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 拦截器。
 * @author tangke
 *
 */
public class OutInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OutInterceptor.class);

	public OutInterceptor() {
		super(Phase.PRE_STREAM);		
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		/**
		 * soap消息中添加<?xml version="1.0" encoding="UTF-8"?>
		 */
		LOGGER.info("返回报文拦截器，开始执行返回报文处理");
		soapMessage.getExchange().put(StaxOutInterceptor.FORCE_START_DOCUMENT, Boolean.TRUE);
		
		List<Header> list = soapMessage.getHeaders();
		SoapHeader responseHeader = CreateResponseHeader.createResponseHeader();
		list.add(0, responseHeader);
		
		
	}

}
