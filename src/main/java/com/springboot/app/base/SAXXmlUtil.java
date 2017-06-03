package com.springboot.app.base;

import com.springboot.app.Entity.Book;
import com.springboot.app.base.utils.SAXParserHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class SAXXmlUtil {

    public void parseXML(){

        //获取SAXParserFactory实例
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        //通过SAXParserHandler获取SAXParser实例
//        SAXParserHandler saxParserHandler = null;
        try {
//            SAXParser saxParser = saxParserFactory.newSAXParser();
//
//            saxParserHandler = new SAXParserHandler();
//
//            saxParser.parse("Book.xml",saxParserHandler);

            SAXParserHandler sax = new SAXParserHandler();
            InputStream input = new FileInputStream(new File("book1.xml"));
                    //this.getClass().getClassLoader().getResourceAsStream("book1.xml");
            List<Book> books = sax.getBooks(input);
            for(Book book : books){
                System.out.println(book.getName()+","+book.getAuthor()+","+book.getAge()+","+book.getYear());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建xml
     * @param booklist
     */
    public void saxCreateXml(List<Book> booklist){
        try {
            //创建SAXTransformerFactory对象
            SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
            //创建TransformerHandler对象
            TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
            //创建Transformer对象
            Transformer transformer = transformerHandler.getTransformer();
            //4：利用transformer的对象对xml文件格式进行设置

            //1:利用OutputKeys.ENCODING设定xml文件的编码
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            //2:利用OutputKeys.INDENT设定xml文件是否换行
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");

            //5:创建file对象用来保存xml文件
            File file = new File("book1.xml");
            //判断file文件是否存在，如果不存在的话，则创建一个相应的file文件
            if (!file.exists()){
                file.createNewFile();
            }

            //6创建RESULT对象，使其与TransformerHandler的对象相关联
            Result result = new StreamResult(new FileOutputStream(file));
            transformerHandler.setResult(result);


            /*
             * 上面准备工作完毕，利用TransformerHandler对象对xml文件的节点进行编写
             * 7:主要工作就是利用startDocument，endDocument,startElement,endElement等方法编写bookstore的各个节点
             * 8:    //创建AttributesImpl对象，为下面循环使用attr而做准备的,是xml文件中的每一个节点都可以赋属性
             * 9:注意一定要清空bookstore中attr属性，因为如果bookstore中属性值存在的话，是会影响后面book节点的属性值的
             * 10：对于节点之间的文本文件的建立用characters（）方法，其中第一个参数是char[]数组，第二个参数是数组的开始位置，第三个参数是数组的结束位置。
           */
            transformerHandler.startDocument();
            AttributesImpl attributes = new AttributesImpl();
            transformerHandler.startElement("","","bookstore",attributes);

            for (Book book :booklist) {
                attributes.clear();
                attributes.addAttribute("","","id","","1");
                transformerHandler.startElement("","","book",attributes);

                if (book.getName()!=null && !book.getName().trim().equals("")){
                    attributes.clear();
                    transformerHandler.startElement("","","name",attributes);
                    transformerHandler.characters(book.getName().toCharArray(),0,book.getName().length());
                    transformerHandler.endElement("","","name");
                }

                if (book.getAuthor()!=null && !book.getAuthor().trim().equals("")){
                    attributes.clear();
                    transformerHandler.startElement("","","author",attributes);
                    transformerHandler.characters(book.getAuthor().toCharArray(),0,book.getAuthor().length());
                    transformerHandler.endElement("","","author");
                }

                if (book.getAge()!=null && !book.getAge().trim().equals("")){
                    attributes.clear();
                    transformerHandler.startElement("","","age",attributes);
                    transformerHandler.characters(book.getAge().toCharArray(),0,book.getAge().length());
                    transformerHandler.endElement("","","age");
                }

                if (book.getYear()!=null && !book.getYear().trim().equals("")){
                    attributes.clear();
                    transformerHandler.startElement("","","year",attributes);
                    transformerHandler.characters(book.getYear().toCharArray(),0,book.getYear().length());
                    transformerHandler.endElement("","","year");
                }

                transformerHandler.endElement("","","book");

            }
            transformerHandler.endElement("","","bookstore");
            transformerHandler.endDocument();

        } catch (TransformerFactoryConfigurationError transformerFactoryConfigurationError) {
            transformerFactoryConfigurationError.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        List<Book> list = new ArrayList<Book>();
        Book book = new Book();
        book.setName("测试");
        book.setYear("12");
        book.setAuthor("陈亮");
        book.setAge("25");

        Book book1 = new Book();
        book1.setName("测试1");
        book1.setYear("12");
        book1.setAuthor("陈亮");
        book1.setAge("25");

        Book book2 = new Book();
        book2.setName("测试2");
        book2.setYear("12");
        book2.setAuthor("陈亮");
        book2.setAge("25");

        list.add(book);
        list.add(book1);
        list.add(book2);
        SAXXmlUtil saxXmlUtil = new SAXXmlUtil();
        saxXmlUtil.saxCreateXml(list);

        saxXmlUtil.parseXML();
    }
}
