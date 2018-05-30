package pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.derby.tools.sysinfo;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
public class prueba {

	 public static void main(String args[]) throws Exception {
		 connectBD conet=new connectBD();  
		 /* ResultSet rs;
		 
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    

		   conect.conexionSQlitepractica();
		    
		     rs = conect.getConexion().createStatement().executeQuery("select departamentos.cod_departamento, departamentos.nom_departamento,departamentos.localidad_deparmento,empleados.id_empleado,empleados.apellido,empleados.oficio,empleados.id_departamento,empleados.salario, empleados.comision,empleados.fecha_alta,empleados.director from departamentos,empleados where empleados.id_departamento=departamentos.cod_departamento");
		     Document doc = builder.newDocument();
			    Element raiz = doc.createElement("UNIDAD_2");
			    raiz.setAttribute("BD", "SQLite");
			    doc.appendChild(raiz);
		    
		    int colCount = rs.getMetaData().getColumnCount();
		    		while (rs.next()) {
		    			
		      Element etiquetadepar = doc.createElement("Departamento");
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(1), rs.getObject(1)+""); //Atributos de la etiqueta departamento
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(2), rs.getObject(2)+"");
		      etiquetadepar.setAttribute(rs.getMetaData().getColumnName(3), rs.getObject(3)+"");
		      raiz.appendChild(etiquetadepar);
		      Element etiquetaemple=  doc.createElement("Empleado");
		      etiquetaemple.setAttribute(rs.getMetaData().getColumnName(4), rs.getObject(4)+"");
		      etiquetadepar.appendChild(etiquetaemple);
		      
		      for (int i = 5; i <= colCount; i++) {
		        
		    	String columnName = rs.getMetaData().getColumnName(i);
		        Object value = rs.getObject(i);
		       
		        Element node = doc.createElement(columnName);
		        node.appendChild(doc.createTextNode(value.toString()));
		        etiquetaemple.appendChild(node);
		      }
		    }
		    DOMSource domSource = new DOMSource(doc);
		    TransformerFactory tf = TransformerFactory.newInstance();
		    Transformer transformer = tf.newTransformer();
		    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		    
		    StreamResult result = new StreamResult(new File("hola.xml"));
		    transformer.transform(domSource, result);
		   
		    //System.out.println(sw.toString());

		    conect.close();
		    rs.close();*/
		 
			String id="";
			String nombre="";
			String loca="";
			String contenido="";

			try {
				
				BufferedReader lector=new BufferedReader(new FileReader(new File("cambios2.txt")));
				contenido=lector.readLine();
				String[] parametros =contenido.split(",");
				for (int i = 0; i < parametros.length; i++) {
					System.out.println(parametros[i]);
				}
				
				
			}catch (FileNotFoundException a){
				JOptionPane.showMessageDialog(null, "FICHERO NO ENCONTRADO", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			} catch (IOException a){
				System.out.println("Error de E/S");
			}
		 
		
		  }
	
    

}
