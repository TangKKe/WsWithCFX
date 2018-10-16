package com.interceptor;

import java.util.Calendar;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.helpers.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * 生成SoapHeader。
 * @author tangke
 *
 */
public class CreateRequestHeader {

	public static QName qName = new QName("RequestHeader", "http://schemas.xml.spdb.com/RequestHeader/");

	public static SoapHeader createRequestHeader() {
		SoapHeader soapHeader = null;
		String requestId = String.valueOf(Math.random()).substring(2);
		String requestDate = getCurrentDate();
		Document document = DOMUtils.createDocument();
		Element root = document.createElement("spdb:RequestHeader");
		root.setAttribute("xmlns:spdb", "http://schemas.xml.spdb.com/Header/");
		Element idElement = document.createElement("requestId");
		idElement.setTextContent(requestId);
		Element dateElement = document.createElement("requestDate");
		dateElement.setTextContent(requestDate);
		root.appendChild(idElement);
		root.appendChild(dateElement);
		soapHeader = new SoapHeader(qName, root);
		return soapHeader;
	}

	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		String yString = String.valueOf(year);
		String mString = String.valueOf(month);
		String dString = String.valueOf(date);
		return yString + "-" + mString + "-" + dString;

	}

}
