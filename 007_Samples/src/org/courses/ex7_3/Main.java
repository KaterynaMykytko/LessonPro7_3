package org.courses.ex7_3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Catalog catalog = new Catalog();
        City city1 = new City("Chernihiv", "Pavlova", 15, "big");
        City city2 = new City("Kiev", "Lesi Ukrainki", 30, "big");

        catalog.add(city1);
        catalog.add(city2);

        try {
            // Створюємо файл
            File file = new File("/Users/sergey.mikitko/Downloads/007_Serialization_XML_and_JSON/" +
                    "007_Samples/src/org/courses/ex7_3/output.xml");
            // Викликаємо статичний метод JAXBContext
            JAXBContext jaxbContext = JAXBContext.newInstance(City.class, Catalog.class);
            // Повертає об'єкт класу Marshaller, щоб трансформувати об'єкт
            Marshaller mar = jaxbContext.createMarshaller();

            // Читабельне форматування
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записуємо у файл, marshal(з пам'яті, у файл)
            mar.marshal(catalog, file);
            mar.marshal(catalog, System.out);

            // Зчитуємо з файлу
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmar.unmarshal(file);
            System.out.println(catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

