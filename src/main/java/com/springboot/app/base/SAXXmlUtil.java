package com.springboot.app.base;

import com.springboot.app.Entity.Book;
import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class SAXXmlUtil {

    public void parseXML(){

        //获取SAXParserFactory实例
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        //通过SAXParserHandler获取SAXParser实例
        SAXParserHandler saxParserHandler = null;
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            saxParserHandler = new SAXParserHandler();

            saxParser.parse("Book.xml",saxParserHandler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
