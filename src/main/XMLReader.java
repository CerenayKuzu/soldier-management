package com.myapp.soldier_management;

import jakarta.xml.bind.*;

import java.io.File;

public class XMLReader {

    public static MilitaryDatabase readXML(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(MilitaryDatabase.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (MilitaryDatabase) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "C:/Users/Ceren/Desktop/soldier-management/soldier_data.xml";

        MilitaryDatabase militaryDatabase = readXML(xmlFilePath);

        if (militaryDatabase != null) {
            System.out.println("Soldiers:");
            for (Soldier soldier : militaryDatabase.getSoldiers()) {
                System.out.println(soldier.getFirstName() + " " + soldier.getLastName());
            }

            System.out.println("\nRank:");
            for (Rank rank : militaryDatabase.getRanks()) {
                System.out.println(rank.getRankName() + " (Level: " + rank.getRankLevel() + ")");
            }
        } else {
            System.out.println("XML couldn't read.");
        }
    }
}
