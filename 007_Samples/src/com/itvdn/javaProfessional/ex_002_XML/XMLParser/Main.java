package com.itvdn.javaProfessional.ex_002_XML.XMLParser;

public class Main {
    public static void main(String[] args) {
        // Зчитуємо файл.xml
        XMLParser xml =
                new XMLParser("./src/com/itvdn/javaProfessional/ex_002_XML/XMLParser/1.xml");
        // Вказуємо шлях, що зчитуватимемо з файлу xml
        String value = xml.get("catalog/book/author");
        String value1 = xml.get("catalog/book2/price");
        System.out.println(value);
        System.out.println(value1);
    }
}
