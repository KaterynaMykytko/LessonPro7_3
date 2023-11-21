package com.itvdn.javaProfessional.ex_002_XML.XMLParser;

import java.io.*;

public class XMLParser {

    private String xml;

    public XMLParser(String path) {
        byte[] buf = null;

        try {
            // RandomAccessFile, конструктор приймає 2 параметри, шлях та ім'я файлового потоку
            RandomAccessFile file = new RandomAccessFile(path, "r");
            try {
                buf = new byte[(int) file.length()];
                file.read(buf);
            } finally {
                file.close();
            }
        } catch (IOException ex) {
        }

        xml = new String(buf);

        System.out.println();
    }

    // Метод визначення "catalog/book/author"
    public String get(String path) {
        // Розбиваємо /
        String[] parts = path.split("/");
        String s_xml = xml;

        for (String s : parts) {
            String toFind = "<" + s + ">";
            // start починається з 1 символу знайденого тега
            int start = s_xml.indexOf(toFind);
            if (start < 0)
                return null;
            else
                start += toFind.length();

            // Знаходимо тег, що закривається
            int end = s_xml.lastIndexOf("</" + s + ">");
            if (end < 0)
                return null;

            // Вирізаємо знайдений рядок
            s_xml = s_xml.substring(start, end);
        }

        return s_xml;
    }
}
