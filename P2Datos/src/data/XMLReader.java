
package data;

import graphs.Graph;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XMLReader {

    public void read(String path, Graph myGraph) throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();    //Obtain a new instance of a DocumentBuilderFactory.
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File(path));//Parse the content of the given file as an XML document and return a new DOM document object.
        Element docs = doc.getDocumentElement();
        docs.normalize();
        cargarDatosGVertex(doc, myGraph);
        cargarDatosEdges(doc, myGraph);
    }

    private void cargarDatosGVertex(Document doc, Graph myGraph) {
        NodeList listaGVertex;
        listaGVertex = doc.getElementsByTagName("GVertex");
        for (int i = 0; i < listaGVertex.getLength(); i++) {
            Node myGVertex = listaGVertex.item(i);
            if (myGVertex.getNodeType() == Node.ELEMENT_NODE) {
                Element myElement = (Element) myGVertex;
                int _numero = Integer.parseInt(myElement.getAttribute("numero"));
                int _ejeX = Integer.parseInt(myElement.getAttribute("x"));
                int _ejeY = Integer.parseInt(myElement.getAttribute("y"));
                myGraph.add(_numero, new Point2D.Float(_ejeX, _ejeY));
            }
        }
    }

    private void cargarDatosEdges(Document doc, Graph myGraph) {
        NodeList listaEdges;
        listaEdges = doc.getElementsByTagName("Edge");
        for (int i = 0; i < listaEdges.getLength(); i++) {
            Node myEdge = listaEdges.item(i);
            if (myEdge.getNodeType() == Node.ELEMENT_NODE) {
                if (myEdge.getAttributes().getLength() == 3) {
                    Element myElement = (Element) myEdge;
                    int _head = Integer.parseInt(myElement.getAttribute("head"));
                    int _tail = Integer.parseInt(myElement.getAttribute("tail"));
                    String k = myElement.getAttribute("info");
                    int _info = Integer.parseInt(myElement.getAttribute("info"));
                    myGraph.addArc(_head, _tail, _info);
                }else{
                    Element myElement = (Element) myEdge;
                    int _head = Integer.parseInt(myElement.getAttribute("head"));
                    int _tail = Integer.parseInt(myElement.getAttribute("tail"));
                    myGraph.addArc(_head, _tail);
                }
            }
        }
    }
}