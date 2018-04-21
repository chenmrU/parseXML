package com.chenmr.parseXML.JDOM;

import com.chenmr.parseXML.entity.Book;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenmr on 2018/4/21/021.
 */
public class ParseXML {

    public static void main(String[] args) {
        List<Book> resultList = new ArrayList<Book>();
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in;
        try{
            in = new FileInputStream("src/main/resources/config.xml");
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            Document document = saxBuilder.build(isr);
            Element rootElement = document.getRootElement();
            List<Element> bookList = rootElement.getChildren();
            for(Element element : bookList){
                Book book = new Book();
                System.out.println("========开始解析第" + (bookList.indexOf(element)+1) + "本书============");
                List<Attribute> attrList = element.getAttributes();
                for(Attribute attribute : attrList){
                    String attrName = attribute.getName();
                    String attrValue = attribute.getValue();
                    System.out.println(attrName + " : " + attrValue);
                    if ("id".equals(attrName)){
                        book.setId(attrValue);
                    }
                }
                List<Element> bookChilds = element.getChildren();
                for(Element child : bookChilds){
                    System.out.println(child.getName() + " : " + child.getValue());
                    if ("name".equals(child.getName())){
                        book.setName(child.getValue());
                    }else if ("author".equals(child.getName())){
                        book.setAuthor(child.getValue());
                    }else if ("year".equals(child.getName())){
                        book.setYear(child.getValue());
                    }else if ("price".equals(child.getName())){
                        book.setPrice(child.getValue());
                    }
                }
                resultList.add(book);
                System.out.println("========结束解析第" + (bookList.indexOf(element)+1) + "本书============");
            }
            for (Book book : resultList){
                System.out.println(book.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
