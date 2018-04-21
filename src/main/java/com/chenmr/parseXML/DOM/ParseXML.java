package com.chenmr.parseXML.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Chenmr on 2018/4/21/021.
 */
public class ParseXML {

    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/main/resources/config.xml");
            //book list
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有" + bookList.getLength() + "本书");
            //遍历book
            for(int i=0; i < bookList.getLength(); i++){
                Node book = bookList.item(i);
                //获取属性值
                NamedNodeMap attrs = book.getAttributes();
                for(int j=0; j<attrs.getLength(); j++){
                    Node attr = attrs.item(j);
                    System.out.println("第" + (i+1) + "本：id=" + attr.getNodeValue());
                }
                //book的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历book的子节点
                for (int j=0; j<childNodes.getLength(); j++){
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(childNodes.item(j).getNodeName() + " : " + childNodes.item(j).getFirstChild().getNodeValue());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
