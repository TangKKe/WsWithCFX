package com.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * 拦截器。
 * @author tangke
 *
 */
public class OutInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public OutInterceptor() {
		super(Phase.PRE_STREAM);		
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		/**
		 * soap消息中添加<?xml version="1.0" encoding="UTF-8"?>
		 */
		soapMessage.getExchange().put(StaxOutInterceptor.FORCE_START_DOCUMENT, Boolean.TRUE);
		
		List<Header> list = soapMessage.getHeaders();
		SoapHeader responseHeader = CreateResponseHeader.createResponseHeader();
		list.add(0, responseHeader);
		
		
	}

}
