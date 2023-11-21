package com.itvdn.javaProfessional.ex_005_SAXParser.SAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main {
    public static void main(String args[]) {
        // Ім'я файлу
        final String fileName = "src\\com\\itvdn\\javaProfessional\\ex_005_SAXParser\\SAXParser\\Phonebook.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Тут ми визначили анонімний клас, який розширює клас DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле, щоб вказати, що тег name почався
                boolean name = false;

                // Метод викликається, коли SAXParser "натикається" на початок тегу
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    // Якщо тег має ім'я name, ми цей момент відзначаємо - почався тег name
                    if (qName.equalsIgnoreCase("email")) {
                        name = true;
                    }
                }

                // Метод викликається, коли SAXParser зчитує текст між тегами
                @Override
                public void characters(char[] ch, int start, int length)
                        throws SAXException {
                    // Якщо перед цим ми відзначили, що ім'я тэга name - значить нам треба використовувати текст.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };
            // Стартуємо аналіз методом parse, якому передаємо спадкоємця від DefaultHandler,
            // який буде викликатися в потрібні моменти
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
