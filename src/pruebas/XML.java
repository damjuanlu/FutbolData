package pruebas;

import java.awt.Color;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mysql.jdbc.ResultSetMetaData;

import AD_UT2_1.ConectarBDs;

public class XML{
	
	PanelEmpleado empleados;
	
	public XML() {}
	
	public XML(String nom) throws Exception{

		 ResultSet rs;
		 connectBD conect=new connectBD();   
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    

		   conect.conexionSQlitepractica();
		    
		     rs = conect.getConexion().createStatement().executeQuery("select departamentos.cod_departamento, departamentos.nom_departamento,departamentos.localidad_deparmento,empleados.id_empleado,empleados.apellido,empleados.oficio,empleados.id_departamento,empleados.salario, empleados.comision,empleados.fecha_alta,empleados.director from departamentos,empleados where empleados.id_departamento=departamentos.cod_departamento");
		     Document doc = builder.newDocument();
			    Element raiz = doc.createElement("DEPARTAMENTOS"); // ELeMENTO RAIZ
			    doc.appendChild(raiz); // crEARCION ELEMENTO RIZ 
		    
		    int colCount = rs.getMetaData().getColumnCount(); // SACO EL NUMERO DE COLUMNAS QUE ME DA LA CONSULTA
		    		while (rs.next()) { // EMPIEZO EL BUCLE PARA SACAR CADA PARAMETRO DE LA CONSULTA
		    			
		      Element etiquetadepar = doc.createElement("Departamento"); // CREO LA ETIQUETA HIJA DE LA PRIMERA 
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(1), rs.getObject(1)+""); //Atributos de la etiqueta departamento  ID 
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(2), rs.getObject(2)+""); // NOMNRE 
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(3), rs.getObject(3)+""); // DEPARATAMENTO
		      raiz.appendChild(etiquetadepar); // HAGO QUE CUELGE DE LA ETIQUETA PRINCIPAL 
		      Element etiquetaemple=  doc.createElement("Empleado"); // CREO UNA NUEVA ETIQUETA QUE VA DESCENDEER DE  DEPARTAMENTO 
		      etiquetaemple.setAttribute(rs.getMetaData().getColumnName(4), rs.getObject(4)+""); // OBTENGO CADA UNO DE LOS VALORES DE LA ULTIMA COLUMNA 
		      etiquetadepar.appendChild(etiquetaemple); // HAGO QUE CUELGE DE LA ETIQUETA DEPARTAMENTO 
		      
		      for (int i = 5; i <= colCount; i++) { // EMPIEZO DESDE LA COLUMNA  5 PORQUE SON LOS QUE CONTIENE LOS DATOS DE EMPLEADO
		        
		    	String columnName = rs.getMetaData().getColumnName(i); // MUESTRA EL N0MBRE DE LA COLUMNA
		        Object value = rs.getObject(i); // DA EL VALOR DE LA COLUMNA 
		       
		        Element node = doc.createElement(columnName); // CREAMOS OTRA ETIQUETA QUE VA SER DESCENCIENTE DE OTRA 
		        node.appendChild(doc.createTextNode(value.toString())); // NOS VA DAR CADA UNO DE LOS VALORES EN STRING 
		        etiquetaemple.appendChild(node); // LE DECIMOS QUE VA COLGAR DE UNA ETIQUETA PRINCIPAL 
		      }
		    }
		    DOMSource domSource = new DOMSource(doc); // 
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		    
		    StreamResult result = new StreamResult(new File(nom+".xml"));
		    transformer.transform(domSource, result);
		   
	

		    conect.close();
		    rs.close();
		
		
		}
	
	public String leerXML(String nomfichero) {
		
		
        Border border = BorderFactory.createLineBorder(Color.RED);
        String contenido="";
        try{
            
             BufferedReader lector=new BufferedReader(new FileReader(new File(nomfichero+".xml")));
            
            contenido=lector.readLine()+"\n";

            lector.close();
         
           
            
        }catch (FileNotFoundException a){
			JOptionPane.showMessageDialog(null, "FICHERO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
			empleados.Nomfic.setBorder(border);
		} catch (IOException a){
			System.out.println("Error de E/S");
		}
	
        return contenido;
		}
		
	}


