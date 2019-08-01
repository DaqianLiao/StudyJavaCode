package com.ldq.study.io;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

/**
 * Created by diligent_leo on 2016/12/26.
 */
public class ReadXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        URL resource = ClassLoader.getSystemClassLoader().getResource("books.xml");
        if (resource != null) {
            String file = resource.getFile();
            System.out.println(file);
            Document document = documentBuilder.parse(file);
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println(bookList.getLength());
            for (int index = 0; index < bookList.getLength(); index++) {
//            Node item = bookList.item(index);
//            NamedNodeMap itemAttributes = item.getAttributes();
//            for (int index1 = 0; index1 < itemAttributes.getLength(); index1++) {
//                System.out.println(itemAttributes.item(0).getNodeName() +  " : "+ itemAttributes.item(0).getNodeValue());
//            }

                Element element = (Element) bookList.item(index);
                String idValue = element.getAttribute("id");
                System.out.println("idValue = " + idValue);

                NodeList nodeList = bookList.item(index).getChildNodes();
                for (int index2 = 0; index2 < nodeList.getLength(); index2++) {
                    if (nodeList.item(index2).getNodeType() == Node.ELEMENT_NODE) {
                        Node item = nodeList.item(index2);
                        System.out.println("item = " + item.getNodeName() +
                                ", value = " + item.getFirstChild().getNodeValue());
                    }
                }

            }
        }
    }
}
