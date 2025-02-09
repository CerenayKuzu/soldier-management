package com.myapp.soldier_management;

import javax.xml.bind.*;
import java.io.File;
import java.util.Date;

public class XMLWriter {
    public static void writeXML(Soldier soldier, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Soldier.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(soldier, new File(filePath));
            System.out.println("XML file created: " + filePath);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Soldier newSoldier = new Soldier(2, "Jane", "Doe", new Date());
        String xmlFilePath = "C:/Users/Ceren/Desktop/soldier-management/new_soldier.xml";
        writeXML(newSoldier, xmlFilePath);
    }
}
