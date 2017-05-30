package com.springboot.app.base;

import com.springboot.app.Entity.Book;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/29 0029.
 */
public class DomXmlUtil {

    public DocumentBuilder getDocumentBuilder(){
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        //创建DocumentBuilder对象
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return documentBuilder;

    }


    /**
     * 生成xml
     */
    public void createXml(){

        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        Element element = document.createElement("bookStore");
        //向element根节点中添加子节点book
        Element book = document.createElement("Book");

        Element name = document.createElement("name");
        Element author = document.createElement("author");
        Element year = document.createElement("year");
        Element age = document.createElement("age");
        name.setTextContent("测试");
        author.setTextContent("陈良");
        year.setTextContent("2017");
        age.setTextContent("25");
        book.appendChild(name);
        book.appendChild(author);
        book.appendChild(year);
        book.appendChild(age);
        book.setAttribute("id","1");

        //向element根节点中添加子节点book
        Element book1 = document.createElement("Book");

        Element name1 = document.createElement("name");
        Element author1 = document.createElement("author");
        Element year1 = document.createElement("year");
        Element age1 = document.createElement("age");
        name1.setTextContent("测试1");
        author1.setTextContent("陈良");
        year1.setTextContent("2017");
        age1.setTextContent("25");
        book1.appendChild(name1);
        book1.appendChild(author1);
        book1.appendChild(year1);
        book1.appendChild(age1);
        book1.setAttribute("id","2");

        //讲book节点添加到到element根节点中
        element.appendChild(book);
        element.appendChild(book1);
        //将element节点（已经包含了booK）添加到dom树中
        document.appendChild(element);

        //创建TransformerFactory对象
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            //创建Transformer对象
            Transformer transformer = transformerFactory.newTransformer();
            //设置xml是否换行
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(new DOMSource(element),new StreamResult(new File("Book.xml")));

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析xml
     */
    public void parseXml(){
        List<Book> bookList = new ArrayList<Book>();
        Book book = null;
        //获取DocumentBuilder对象
        DocumentBuilder db = getDocumentBuilder();
        try {
            //通过DocumentBuilder对象的parse方法加载xml文件到当前项目下
            Document document = db.parse("book.xml");
            //获取所有节点的集合
            NodeList nodeList = document.getElementsByTagName("Book");
            System.out.println("xml一共有数据："+nodeList.getLength()+"条");
            //遍历每一个node节点
            for(int i =0;i<nodeList.getLength();i++){
                System.out.println("=================遍历第"+i+"个node节点开始====================");
                //获取node节点
                Node node = nodeList.item(i);
                //获取node节点属性集合
                NamedNodeMap namedNodeMap = node.getAttributes();
                System.out.println("第："+i+"条数据属性："+nodeList.getLength()+"条");
                //遍历node节点属性
                for (int j=0;j<namedNodeMap.getLength();j++){
                    //获取属性
                    Node attr = namedNodeMap.item(j);
                    //获取属性名
                    System.out.print("属性名："+attr.getNodeName()+",");
                    //获取属性名
                    System.out.println("属性值："+attr.getNodeValue());
                }

                //解析node节点的子节点
                NodeList childNodes = node.getChildNodes();
                System.out.println("第："+i+"条数据属性："+childNodes.getLength()+"条子节点");
                //遍历childNodes获取每个节点的节点名和节点值
                for (int k=0;k<childNodes.getLength();k++){
                    book = new Book();
                    //区分text类型以及element类型节点
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
                        //获取element类型节点名和节点值
                        String nodeName = childNodes.item(k).getNodeName();
                        System.out.print("子节点名："+nodeName);
                        String nodeValue = childNodes.item(k).getFirstChild().getNodeValue();
                        System.out.println(",子节点值："+nodeValue);
                        switch (nodeName){
                            case "name":
                                book.setName(nodeValue);
                                break;
                            case "age" :
                                book.setAge(nodeValue);
                                break;
                            case "author" :
                                book.setAuthor(nodeValue);
                                break;
                            case "year":
                                book.setYear(nodeValue);
                                break;
                        }
//                        System.out.print(",子节点值："+childNodes.item(k).getTextContent());
                    }
                        bookList.add(book);
                }

                System.out.println("组装数据："+bookList.size());
                System.out.println("=================遍历第"+i+"个node节点结束====================");
            }

            for (Book boo:bookList){
                System.out.println(boo.getName());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DomXmlUtil xmlUtil = new DomXmlUtil();
        xmlUtil.createXml();
        xmlUtil.parseXml();
    }
}
