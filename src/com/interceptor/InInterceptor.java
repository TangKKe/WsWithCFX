package com.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 拦截器。
 * @author tangke
 *
 */
public class InInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InInterceptor.class);

	public InInterceptor() {
		super(Phase.PRE_STREAM);
	}

	@Override
	public void handleMessage(SoapMessage soapMessage) throws Fault {
		LOGGER.info("开始执行请求报文拦截器");
		List<Header> list = soapMessage.getHeaders();
		SoapHeader requestHeader = CreateRequestHeader.createRequestHeader();
		list.add(0, requestHeader);
		
		Map<String , Object> map = soapMessage.getExchange();
		Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
		if(iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			System.out.println("soapMessage.getExchange()---key="+entry.getKey()+"---value" + entry.getValue());
		}
		
	}

}
