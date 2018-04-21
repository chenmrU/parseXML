package com.chenmr.parseXML.SAX;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * Created by Chenmr on 2018/4/21/021.
 */
public class ParseXML {

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try{
            SAXParser parser = factory.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse("src/main/resources/config.xml", handler);
            List<Book> bookList = handler.getBookList();
            for(Book book : bookList){
                System.out.println(book.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
