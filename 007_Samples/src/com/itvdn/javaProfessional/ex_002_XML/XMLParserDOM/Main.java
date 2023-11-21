package com.itvdn.javaProfessional.ex_002_XML.XMLParserDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("./src/com/itvdn/javaProfessional/ex_002_XML/XMLParserDOM/1.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Отримуємо об'єкт DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Парсимо об'єкт DocumentBuilder і отримуємо об'єкт Document
            Document doc = db.parse(xmlFile);

            // Повертає об'єкт класу Element, отримуємо кореневий елемент
            Element root = doc.getDocumentElement();
            System.out.println("Кореневий елемент: " + root.getNodeName());
            System.out.println("----------------------");

            // Для кореневого елемента викликаємо метод getChildNodes
            NodeList nl = root.getChildNodes();

            for (int i = 0; i < nl.getLength(); i++) {
                // За номером отримуємо вузол
                Node node = nl.item(i);
                // Перевіряємо певний тип, якщо вузол є елементом, то входимо до тіла
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Book:");
                    System.out.println("Author: " +
                            element.getElementsByTagName("author")
                                    .item(0).
                                    getChildNodes()
                                    .item(0)
                                    .getNodeValue());
                    System.out.println("Title: " + element
                            .getElementsByTagName("title")
                            .item(0)
                            .getChildNodes()
                            .item(0)
                            .getNodeValue());
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}