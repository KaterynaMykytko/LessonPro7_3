package com.itvdn.javaProfessional.ex_003_JAXB.JAXB;

import javax.xml.bind.*;
import java.io.File;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws JAXBException {
        Catalog catal = new Catalog();
        catal.add(new Book("Author1", "Title1", 40.55, new Date()));
        catal.add(new Book("Author2", "Title2", 30, new Date()));

        try {
            // Створюємо файл
            File file = new File("./src/com/itvdn/javaProfessional/ex_003_JAXB/JAXB/output.xml");
            // Викликаємо статичний метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            // Повертає об'єкт класу Marshaller, щоб трансформувати об'єкт
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельне форматування
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записуємо у файл, marshal(з пам'яті, у файл)
            mar.marshal(catal, file);
            mar.marshal(catal, System.out);

            // Зчитуємо з файлу
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            catal = (Catalog) unmar.unmarshal(file);
            System.out.println(catal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}