package com.chenmr.parseXML.DOM4J;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chenmr on 2018/4/21/021.
 */
public class ParseXML {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try{
            Document document = reader.read(new File("src/main/resources/config.xml"));
            Element rootElement = document.getRootElement();
            Iterator iterable = rootElement.elementIterator();
            while (iterable.hasNext()){
                System.out.println("============开始遍历某一本书==========");
                Element book = (Element) iterable.next();
                List<Attribute> bookAttrs = book.attributes();
                for(Attribute attribute : bookAttrs){
                    System.out.println(attribute.getName() + " : " + attribute.getValue());
                }
                Iterator it = book.elementIterator();
                while (it.hasNext()){
                    Element bookChild = (Element)it.next();
                    System.out.println(bookChild.getName() + " : " + bookChild.getStringValue());
                }
                System.out.println("============结束遍历某一本书==========");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
