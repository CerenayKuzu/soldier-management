package com.myapp.soldier_management;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONReader {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file and convert it into a Java object
            MilitaryDatabase database = objectMapper.readValue(new File("C:/Users/Ceren/Desktop/military_data.json"), MilitaryDatabase.class);

            List<Soldier> soldiers = database.getSoldiers();
            for (Soldier soldier : soldiers) {
                System.out.println("Soldier ID: " + soldier.getSoldierId());
                System.out.println("Name: " + soldier.getFirstName() + " " + soldier.getLastName());
                System.out.println("Date of Birth: " + soldier.getDob());
                System.out.println("Rank: " + soldier.getRank().getRankName());
                System.out.println("Unit: " + soldier.getUnit().getUnitName());
                System.out.println("Department: " + soldier.getDepartment().getDepartmentName());
                System.out.println("Missions: " + soldier.getMissions().size() + " missions\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
