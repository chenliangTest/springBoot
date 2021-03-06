package com.springboot.app.base.utils;

import com.springboot.app.Entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/30 0030.
 */
public class SAXParserHandler extends DefaultHandler {

    private List<Book> books = null;
    private Book book = null;
    private String preTag = null;//作用是记录解析时的上一个节点名称

    public List<Book> getBooks(InputStream xmlStream) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse(xmlStream, handler);
        return handler.getBooks();
    }

    public List<Book> getBooks(){
        return books;
    }

    @Override
    public void startDocument() throws SAXException {
        books = new ArrayList<Book>();

        super.startDocument();
        System.out.println("sax解析开始");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        /*if("book".equals(qName)){
            book = new Book();
            book.setName(attributes.getValue(0));
        }
        if("author".equals(qName)){
            book = new Book();
            book.setAuthor(attributes.getValue(0));
        }
        if("year".equals(qName)){
            book = new Book();
            book.setYear(attributes.getValue(0));
        }
        if("age".equals(qName)){
            book = new Book();
            book.setAge(attributes.getValue(0));
        }
        preTag = qName;//将正在解析的节点名称赋给preTag*/
        super.startElement(uri,localName,qName,attributes);
        if (qName.equals("book")){
            String value = attributes.getValue("id");
            System.out.println(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if("book".equals(qName)){
            books.add(book);
            book = null;
        }
        preTag = null;/**当解析结束时置为空。这里很重要，例如，当图中画3的位置结束后，会调用这个方法
         ，如果这里不把preTag置为null，根据startElement(....)方法，preTag的值还是book，当文档顺序读到图
         中标记4的位置时，会执行characters(char[] ch, int start, int length)这个方法，而characters(....)方
         法判断preTag!=null，会执行if判断的代码，这样就会把空值赋值给book，这不是我们想要的。*/
        //super.endDocument();
        //System.out.println("sax解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(preTag!=null){
            String content = new String(ch,start,length);
            if("name".equals(preTag)){
                book.setName(content);
            }
        }
    }
}
