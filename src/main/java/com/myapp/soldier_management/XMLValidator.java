package com.myapp.soldier_management;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.IOException;

public class XMLValidator {
    public static boolean validateXML(String xmlFilePath, String xsdFilePath) {
        try {
            
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            
            Schema schema = factory.newSchema(new File(xsdFilePath));
            
            
            Validator validator = schema.newValidator();
            
            
            validator.validate(new StreamSource(new File(xmlFilePath)));

            System.out.println("XML file validated successfully");
            return true;
        } catch (SAXException e) {
            System.out.println("XML validation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }
        return false;
    }
}
