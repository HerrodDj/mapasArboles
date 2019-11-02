/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import graphs.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Juan Carlos
 */
public class gestorXML {
    File xmlFile;
    JAXBContext jaxbContext;
    public gestorXML() {
        xmlFile = new File("C:\\Users\\Juan Carlos\\Downloads\\DivisionAdministrativa\\src\\DOM\\division (jerÃ¡rquica).xml");
    }

    public void ReadXml() throws FileNotFoundException, JAXBException {
        try {
            jaxbContext = JAXBContext.newInstance(Graph.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Graph divAdmin = (Graph) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(divAdmin.toString());
            System.out.println("\nTerminado");
        } catch (JAXBException e) {
            System.err.printf("ExcepciÃ³n: '%s'%n", e.getMessage());
        }
    }
}