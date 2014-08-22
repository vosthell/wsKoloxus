/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webs;

import clases.clsConexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author ckaiser
 */
@WebService(serviceName = "list_procesos")
public class list_procesos {
    
    /**
     * Consulta la cedula enviandole la placa
     */
    
    @WebMethod(operationName = "consultar_cedula_por_placa")
    public String consultar_cedula_por_placa(@WebParam(name = "placa") String placa) {
        String mensaje = "";
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba();
        String sql = "{call WEB_INTER_INFRACCIONES_1.consulta_identificacion(?, ?, ?)}";
        
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, placa); 
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);
            cstm.executeUpdate();  
            
            mensaje = ""+cstm.getString(2);
        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            mensaje = sqlException.getMessage();
        }       
        return mensaje;
        //return "";
    }

    /**
     * Consulta lso datos de una persona por la cedula
     */
    
    @WebMethod(operationName = "consultar_datos_por_cedula")
    public ArrayList consultar_datos_por_cedula(@WebParam(name = "cedula") String cedula) {
        String mensaje = "";
        //private ArrayList ListData;
        ArrayList al = new ArrayList();
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call WEB_INTER_LICENCIAS.Datos_Licencia(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula); 
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);
            cstm.registerOutParameter(7, OracleTypes.VARCHAR);
            cstm.registerOutParameter(8, OracleTypes.VARCHAR);
            cstm.registerOutParameter(9, OracleTypes.VARCHAR);
            cstm.registerOutParameter(10, OracleTypes.VARCHAR);
            cstm.registerOutParameter(11, OracleTypes.VARCHAR);
            cstm.registerOutParameter(12, OracleTypes.VARCHAR);
            cstm.registerOutParameter(13, OracleTypes.VARCHAR);
            cstm.registerOutParameter(14, OracleTypes.VARCHAR);
            cstm.registerOutParameter(15, OracleTypes.VARCHAR);
            cstm.registerOutParameter(16, OracleTypes.VARCHAR);
            cstm.registerOutParameter(17, OracleTypes.VARCHAR);
            cstm.registerOutParameter(18, OracleTypes.VARCHAR);
            cstm.registerOutParameter(19, OracleTypes.VARCHAR);
            cstm.registerOutParameter(20, OracleTypes.VARCHAR);
            cstm.registerOutParameter(21, OracleTypes.DOUBLE);
            cstm.registerOutParameter(22, OracleTypes.CURSOR);
            cstm.registerOutParameter(23, OracleTypes.CURSOR);
            cstm.registerOutParameter(24, OracleTypes.CURSOR);
            cstm.registerOutParameter(25, OracleTypes.CURSOR);
            cstm.registerOutParameter(26, OracleTypes.VARCHAR);
            cstm.registerOutParameter(27, OracleTypes.VARCHAR);
            
            cstm.executeUpdate();  
            
           /* mensaje = mensaje + "<datos>";
            mensaje = mensaje + "<persona>" + cstm.getString(21) + "</persona>";
            mensaje = mensaje + "<nombres>" + cstm.getString(2) + "</nombres>";
            mensaje = mensaje + "<sangre>"  + cstm.getString(9) + "</sangre>";            
            mensaje = mensaje + "<existe>"  + cstm.getString(26) + "</existe>";
            mensaje = mensaje + "<mensaje>"  + cstm.getString(27) + "</mensaje>";
            mensaje = mensaje + "</datos>";*/
           al.add(cstm.getString(21));
            al.add(cstm.getString(2));
            al.add(cstm.getString(9));
            al.add(cstm.getString(26));
            al.add(cstm.getString(27));
            
            //mensaje = ""+cstm.getString(2);
        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            mensaje = sqlException.getMessage();
        }   
               
        //return mensaje;
        return al;
        // get cursor and cast it to ResultSet
        //rs = (ResultSet) callableStatement.getObject(2);

        // loop it like normal
        /*while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String userName = rs.getString("USERNAME");
        }*/
    }
    
    @WebMethod(operationName = "consultar_datos_por_cedula_2")
    public String[] consultar_datos_por_cedula_2(@WebParam(name = "cedula") String cedula) {
        
        String[] words = new String [5];         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call WEB_INTER_LICENCIAS.Datos_Licencia(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula); 
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //nombres
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //tipo_identificacion
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //fecha nacimiento
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //localidad
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //provincia
            cstm.registerOutParameter(7, OracleTypes.VARCHAR);  //pais
            cstm.registerOutParameter(8, OracleTypes.VARCHAR);  //sexo
            cstm.registerOutParameter(9, OracleTypes.VARCHAR);  //sangre
            cstm.registerOutParameter(10, OracleTypes.VARCHAR); //cabello
            cstm.registerOutParameter(11, OracleTypes.VARCHAR); //ojo
            cstm.registerOutParameter(12, OracleTypes.VARCHAR); //test
            cstm.registerOutParameter(13, OracleTypes.VARCHAR); //estatura
            cstm.registerOutParameter(14, OracleTypes.VARCHAR); //estado civil
            cstm.registerOutParameter(15, OracleTypes.VARCHAR); //profesion
            cstm.registerOutParameter(16, OracleTypes.VARCHAR); //direccion
            cstm.registerOutParameter(17, OracleTypes.VARCHAR); ///telefono
            cstm.registerOutParameter(18, OracleTypes.VARCHAR); //canton
            cstm.registerOutParameter(19, OracleTypes.VARCHAR); //provincia
            cstm.registerOutParameter(20, OracleTypes.VARCHAR); //pais
            cstm.registerOutParameter(21, OracleTypes.DOUBLE);  //person   a
            cstm.registerOutParameter(22, OracleTypes.CURSOR);  //licencias
            cstm.registerOutParameter(23, OracleTypes.CURSOR);  //bloqueo
            cstm.registerOutParameter(24, OracleTypes.CURSOR);  //restriccion
            cstm.registerOutParameter(25, OracleTypes.CURSOR);  //citaciones
            cstm.registerOutParameter(26, OracleTypes.VARCHAR); //existe
            cstm.registerOutParameter(27, OracleTypes.VARCHAR); //mensaje
            
            cstm.executeUpdate();  
            
           
            words[0] = cstm.getString(21);  //id persona
            words[1] = cstm.getString(2);   //nombre
            words[2] = cstm.getString(9);   //sangre
            words[3] = cstm.getString(26);  //existe
            words[4] = cstm.getString(27);  //mensaje
            
            //mensaje = ""+cstm.getString(2);
        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = sqlException.getMessage();
        }   
               
        //return mensaje;
        return words;
        // get cursor and cast it to ResultSet
        //rs = (ResultSet) callableStatement.getObject(2);

        // loop it like normal
        /*while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String userName = rs.getString("USERNAME");
        }*/
    }
    
    @WebMethod(operationName = "bidimensional")
    public String[][] bidimensional(@WebParam(name = "cedula") String cedula) {
        int filas = 2;
        int columnas = 3;
        String [][] nombres = new String [filas][columnas];
        nombres[0][0] = "0";
        nombres[0][1] = "CHRISTIAN";
        nombres[0][2] = "KAISER";
                
        nombres[1][0] = "1";
        nombres[1][1] = "MONICA";
        nombres[1][2] = "VENEGAS";
        return nombres;
    }
    
    @WebMethod(operationName = "consultar_empleado")
    public String consultar_empleado(@WebParam(name = "cedula") String cedula) {
        String mensaje = "";
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba();        
        String sql = "{call web_api_transacciones.wep_consulta_empleado(?, ?)}";       
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_cedula
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_error          
            cstm.executeUpdate();  
            
            mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) 
        {
            //throw new MyException("error text", sqlException);
            mensaje = sqlException.getMessage();
        }       
        return mensaje;
        //return "";
    }
    
    @WebMethod(operationName = "consultar_empleado_datos")
    public String consultar_empleado_datos(@WebParam(name = "cedula") String cedula) {
        String mensaje = "";
        ResultSet rs = null; 
        
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba();        
        String sql = "{call web_api_transacciones.wep_consulta_certificado(?, ?, ?)}";       
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_cedula
            cstm.registerOutParameter(2, OracleTypes.CURSOR);  //c_certificado   
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_error          
            cstm.executeUpdate();  
            
            rs = (ResultSet)cstm.getObject(2); //Forma #1	
            //rs = ((OracleCallableStatement)cstm).getCursor( 2 ); //Forma #2            
            //mensaje = ""+cstm.getString(2);   
            //Lleno el Objeto ... 
            while( rs.next( ) ){                 //Seteos en base a los obtenido en el Store Procedure. 
                mensaje = rs.getString("NOMBRE_COMPLETO");                
            } 
        } 
        catch (Exception sqlException) 
        {
            //throw new MyException("error text", sqlException);
            mensaje = sqlException.getMessage();
        }       
        return mensaje;
        //return "";
    }
    
}
