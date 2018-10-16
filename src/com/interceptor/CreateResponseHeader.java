package com.interceptor;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.helpers.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateResponseHeader {
	
	public static QName qName = new QName("ResponseHeader", "http://schemas.xml.spdb.com/ResponseHeader/");

	public static SoapHeader createResponseHeader() {
		SoapHeader soapHeader = null;
		String responseId = String.valueOf(Math.random()).substring(2);
		String responseDate = CreateRequestHeader.getCurrentDate();
		Document document = DOMUtils.createDocument();
		Element root = document.createElement("spdb:ResponseHeader");
		root.setAttribute("xmlns:spdb", "http://schemas.xml.spdb.com/Header/");
		Element idElement = document.createElement("responseId");
		idElement.setTextContent(responseId);
		Element dateElement = document.createElement("responseDate");
		dateElement.setTextContent(responseDate);
		root.appendChild(idElement);
		root.appendChild(dateElement);
		soapHeader = new SoapHeader(qName, root);
		return soapHeader;
	}

}
