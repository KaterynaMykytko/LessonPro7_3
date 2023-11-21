package org.courses.ex7_3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
    @XmlRootElement(name = "city")
    public class City {
        private String name;
        private String street;
        private int houseNumber;
        private String size;

        public City() {
        }

        public City(String name, String street, int houseNumber, String size) {
            this.name = name;
            this.street = street;
            this.houseNumber = houseNumber;
            this.size = size;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", street='" + street + '\'' +
                    ", houseNumber=" + houseNumber +
                    ", size='" + size + '\'' +
                    '}';
        }


        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }

        public String getStreet() {
            return street;
        }

        @XmlElement
        public void setStreet(String street) {
            this.street = street;
        }

        public int getHouseNumber() {
            return houseNumber;
        }
        @XmlElement
        public void setHouseNumber(int houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getSize() {
            return size;
        }
        @XmlElement
        public void setSize(String size) {
            this.size = size;
        }
    }
