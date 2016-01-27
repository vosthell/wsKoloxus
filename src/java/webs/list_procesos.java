/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webs;

import clases.clsConexion;
import clases.clsData;
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
        objConexion.conectar();
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
            mensaje = "Error en SQL: " + sqlException.getMessage();
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
        objConexion.conectar(); 
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
        objConexion.conectar(); 
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
        objConexion.conectar();        
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
        objConexion.conectar();        
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
    
    @WebMethod(operationName = "verifica_reg_empleado")
    public String verifica_reg_empleado(@WebParam(name = "cedula") String cedula) {
        String mensaje = "";
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar();        
        String sql = "{call web_api_transacciones.wep_consulta_certi(?, ?)}";       
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
    
    @WebMethod(operationName = "verifica_reg_empleado_transito")
    public String verifica_reg_empleado_transito(@WebParam(name = "cedula") String cedula) {
        String mensaje = "";
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_transito();  
        ResultSet rs = null; 
        String sql = "{call WEB_API_TRANSACCIONES.WEP_CONSULTA_CERTI(?, ?)}";       
        try
        {
            /*CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_cedula
            cstm.registerOutParameter(2, OracleTypes.CURSOR);  //c_certificado     
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_error          
            cstm.executeUpdate(); 
            
            rs = (ResultSet)cstm.getObject(2); //Forma #1	
           mensaje = "N";
            while( rs.next( ) ){  
                mensaje = "S";
            }*/
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_cedula
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_error          
            cstm.executeUpdate();  
            
            mensaje = ""+cstm.getString(2); 
            
            //mensaje = ""+cstm.getString(3);        
        } 
        catch (Exception sqlException) 
        {
            //throw new MyException("error text", sqlException);
            mensaje = sqlException.getMessage();
        }       
        return mensaje;
        //return "";
    }
    
    @WebMethod(operationName = "consulta_usuario_web")
    public String[] consulta_usuario_web(@WebParam(name = "cedula") String cedula)
    {
        String[] words = new String [5];         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_api_transacciones.consulta_usuario_web(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_identificacion
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_nombres
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_apellidos
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_email
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_estado
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();              
           
            words[0] = cstm.getString(2);  
            words[1] = cstm.getString(3);   
            words[2] = cstm.getString(4);   
            words[3] = cstm.getString(5);  
            words[4] = cstm.getString(6);  
            
            //mensaje = ""+cstm.getString(2);        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = sqlException.getMessage();
        }                  
        //return mensaje;
        return words;
    }
    
     @WebMethod(operationName = "consulta_usuario_web_prueba")
    public String[] consulta_usuario_web_prueba(@WebParam(name = "cedula") String cedula)
    {
        String[] words = new String [5];         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call web_api_transacciones.consulta_usuario_web(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_identificacion
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_nombres
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_apellidos
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_email
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_estado
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();              
           
            words[0] = cstm.getString(2);  
            words[1] = cstm.getString(3);   
            words[2] = cstm.getString(4);   
            words[3] = cstm.getString(5);  
            words[4] = cstm.getString(6);  
            
            //mensaje = ""+cstm.getString(2);        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = sqlException.getMessage();
        }                  
        //return mensaje;
        return words;
    }
     
    @WebMethod(operationName = "gcp_consulta_user_app")
    public String[] gcp_consulta_user_app(@WebParam(name = "usuario") String usuario)
    {
        String[] words = new String [3];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        ResultSet rs = null; 
        String sql = "{call GCK_API_CONSULTA_WEB.GCP_CONSULTA_USER(?, ?, ?, ?)}";        
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
            
            cstm.setString(1, usuario);                         //pv_user
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_clave
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_descripcion
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_error
                        
            cstm.executeUpdate();       
                           
            clsData oListaTemporal = new clsData();
            words[0] = desencriptar(cstm.getString(2));  
            words[1] = cstm.getString(3);
            words[2] = cstm.getString(4);        
        } 
        catch (Exception sqlException) 
        {
            words[0] = sqlException.getMessage();
        }          
        return words;
    }
    
    @WebMethod(operationName = "gcp_consulta_user_app_prueba")
    public String[] gcp_consulta_user_app_prueba(@WebParam(name = "usuario") String usuario)
    {
        String[] words = new String [3];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        ResultSet rs = null; 
        String sql = "{call GCK_API_CONSULTA_WEB.GCP_CONSULTA_USER(?, ?, ?, ?)}";        
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);
            
            cstm.setString(1, usuario);                         //pv_user
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_clave
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_descripcion
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_error
                        
            cstm.executeUpdate();       
                           
            clsData oListaTemporal = new clsData();
            words[0] = desencriptar(cstm.getString(2));  
            words[1] = cstm.getString(3);
            words[2] = cstm.getString(4);        
        } 
        catch (Exception sqlException) 
        {
            words[0] = sqlException.getMessage();
        }          
        return words;
    }
    
    //CONSULTAR SI ESTA ACTIVADO
    @WebMethod(operationName = "gcp_consulta_user")
    public String[] gcp_consulta_user(@WebParam(name = "cedula") String cedula)
    {
        String[] words = new String [5];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call gck_api_consulta_web_2.gcp_consulta_user(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_identificacion
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_clave
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_descripcion
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_estado_act
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_fecha_ultimo_cceso
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
           
            cstm.executeUpdate();            
           
            words[0] = desencriptar(cstm.getString(2));  
            words[1] = cstm.getString(3);   
            words[2] = cstm.getString(4);   
            words[3] = cstm.getString(5);  
            words[4] = cstm.getString(6);          
            //mensaje = ""+cstm.getString(2);        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "gcp_consulta_user_prueba")
    public String[] gcp_consulta_user_prueba(@WebParam(name = "cedula") String cedula)
    {
        String[] words = new String [5];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call gck_api_consulta_web_2.gcp_consulta_user(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_identificacion
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_clave
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_descripcion
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_estado_act
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_fecha_ultimo_cceso
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
           
            cstm.executeUpdate();            
           
            words[0] = desencriptar(cstm.getString(2));  
            words[1] = cstm.getString(3);   
            words[2] = cstm.getString(4);   
            words[3] = cstm.getString(5);  
            words[4] = cstm.getString(6);          
            //mensaje = ""+cstm.getString(2);        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "actualiza_usuario_web")
    public String actualiza_usuario_web(@WebParam(name = "cedula") String cedula, @WebParam(name = "campo") String campo, @WebParam(name = "valor") String valor)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_api_transacciones.actualiza_usuario_web(?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, cedula);                          //pv_identificacion
            cstm.setString(2, campo);  //pv_campo
            cstm.setString(3, valor);  //pv_valor
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = cstm.getString(4);              
            //mensaje = ""+cstm.getString(2);        
        } catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_consulta")
    public String ingresar_audit_consulta(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "observaciones") String observaciones)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_consulta(?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);    //pv_ip
            cstm.setString(3, sesion_php);         //pv_sesion_php
            cstm.setString(4, observaciones);         //pv_observaciones
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();  
            
            words = cstm.getString(5);      
            
            if(words=="")
                words = "EXITO";
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
     @WebMethod(operationName = "ingresar_audit_consult_pv")
    public String ingresar_audit_consult_pv(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "observaciones") String observaciones,
                                            @WebParam(name = "usuario") String usuario,
                                            @WebParam(name = "institucion") String institucion,
                                            @WebParam(name = "oficio") String oficio)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_consult_pv(?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);    //pv_ip
            cstm.setString(3, sesion_php);         //pv_sesion_php
            cstm.setString(4, observaciones);         //pv_observaciones
            cstm.setString(5, usuario);         //pv_observaciones
            cstm.setString(6, institucion);      //pv_observaciones
            cstm.setString(7, oficio);         //pv_oficio
            cstm.registerOutParameter(8, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();  
            
            words = cstm.getString(8);      
            
            if(words=="")
                words = "EXITO";
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
     
      @WebMethod(operationName = "ingresar_audit_consult_pv_prueba")
    public String ingresar_audit_consult_pv_prueba(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "observaciones") String observaciones,
                                            @WebParam(name = "usuario") String usuario,
                                            @WebParam(name = "institucion") String institucion,
                                            @WebParam(name = "oficio") String oficio)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call cek_servicios.ingresar_audit_consult_pv(?, ?, ?, ?, ?, ?, ?,?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);    //pv_ip
            cstm.setString(3, sesion_php);         //pv_sesion_php
            cstm.setString(4, observaciones);         //pv_observaciones
            cstm.setString(5, usuario);         //pv_observaciones
            cstm.setString(6, institucion);         //pv_observaciones
            cstm.setString(7, oficio);         //pv_oficio
            cstm.registerOutParameter(8, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();  
            
            words = cstm.getString(8);      
            
            if(words=="")
                words = "EXITO";
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_certificado")
    public String ingresar_audit_certificado(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "codigo_certificado") String codigo_certificado,
                                            @WebParam(name = "observaciones") String observaciones)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_certificado(?, ?, ?, ?, ?,?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);              //pv_identificacion
            cstm.setString(2, ip);                          //pv_ip
            cstm.setString(3, sesion_php);                  //pv_sesion_php
            cstm.setString(4, observaciones);               //pv_observaciones
            cstm.setString(5, codigo_certificado);          //pv_codigo_certificado 
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = cstm.getString(6);              
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    
    
    @WebMethod(operationName = "ingresar_audit_certif_pv")
    public String ingresar_audit_certif_pv(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "codigo_certificado") String codigo_certificado,
                                            @WebParam(name = "ruc") String ruc,
                                            @WebParam(name = "entidad") String entidad,
                                            @WebParam(name = "formulario") String formulario,
                                            @WebParam(name = "fecha") String fecha,
                                            @WebParam(name = "suscrito") String suscrito,
                                            @WebParam(name = "posesion") String posesion,
                                            @WebParam(name = "observaciones") String observaciones)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_certif_pv(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.setString(4, observaciones);       //pv_observaciones
            cstm.setString(5, codigo_certificado);  //pv_codigo_certificado 
            cstm.setString(6, ruc);                 //pv_codigo_certificado 
            cstm.setString(7, entidad);             //pv_codigo_certificado 
            cstm.setString(8, formulario);          //pv_codigo_certificado 
            cstm.setString(9, fecha);               //pv_codigo_certificado 
            cstm.setString(10, suscrito);           //pv_codigo_certificado 
            cstm.setString(11, posesion);           //pv_codigo_certificado 
            cstm.registerOutParameter(12, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = cstm.getString(12);              
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_certif_pv_prueba")
    public String ingresar_audit_certif_pv_prueba(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "codigo_certificado") String codigo_certificado,
                                            @WebParam(name = "ruc") String ruc,
                                            @WebParam(name = "entidad") String entidad,
                                            @WebParam(name = "formulario") String formulario,
                                            @WebParam(name = "fecha") String fecha,
                                            @WebParam(name = "suscrito") String suscrito,
                                            @WebParam(name = "posesion") String posesion,
                                            @WebParam(name = "observaciones") String observaciones)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call cek_servicios.ingresar_audit_certif_pv(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.setString(4, observaciones);       //pv_observaciones
            cstm.setString(5, codigo_certificado);  //pv_codigo_certificado 
            cstm.setString(6, ruc);                 //pv_codigo_certificado 
            cstm.setString(7, entidad);             //pv_codigo_certificado 
            cstm.setString(8, formulario);          //pv_codigo_certificado 
            cstm.setString(9, fecha);               //pv_codigo_certificado 
            cstm.setString(10, suscrito);           //pv_codigo_certificado 
            cstm.setString(11, posesion);           //pv_codigo_certificado 
            cstm.registerOutParameter(12, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = cstm.getString(12);              
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_certif_pv_2")
    public String ingresar_audit_certif_pv_2(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "codigo_certificado") String codigo_certificado,
                                            @WebParam(name = "ruc") String ruc,
                                            @WebParam(name = "entidad") String entidad,
                                            @WebParam(name = "formulario") String formulario,
                                            @WebParam(name = "fecha") String fecha,
                                            @WebParam(name = "suscrito") String suscrito,
                                            @WebParam(name = "posesion") String posesion,
                                            @WebParam(name = "observaciones") String observaciones)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_certif_pv_2(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.setString(4, observaciones);       //pv_observaciones
            cstm.setString(5, codigo_certificado);  //pv_codigo_certificado 
            cstm.setString(6, ruc);                 //pv_codigo_certificado 
            cstm.setString(7, entidad);             //pv_codigo_certificado 
            cstm.setString(8, formulario);          //pv_codigo_certificado 
            cstm.setString(9, fecha);               //pv_codigo_certificado 
            cstm.setString(10, suscrito);           //pv_codigo_certificado 
            cstm.setString(11, posesion);           //pv_codigo_certificado 
            cstm.registerOutParameter(12, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = cstm.getString(12);              
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "consultar_id_certificado")
    public String consultar_id_certificado(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php
                                            )
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.consultar_id_certificado(?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.registerOutParameter(4, OracleTypes.NUMBER);       //pn_id_certificado
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = ""+cstm.getString(4);              
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    
    
     @WebMethod(operationName = "consultar_id_certif_pv")
    public String consultar_id_certif_pv(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "oficio") String oficio
                                            )
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.consultar_id_certif_pv(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.setString(4, oficio);              //pv_oficio
            cstm.registerOutParameter(5, OracleTypes.NUMBER);       //pn_id_certificado
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = ""+cstm.getString(5);              
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
     @WebMethod(operationName = "consultar_id_certif_pv_prueba")
    public String consultar_id_certif_pv_prueba(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "oficio") String oficio
                                            )
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar_prueba(); 
        String sql = "{call cek_servicios.consultar_id_certif_pv(?, ?, ?, ?, ?, ?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);                  //pv_ip
            cstm.setString(3, sesion_php);          //pv_sesion_php
            cstm.setString(4, oficio);              //pv_oficio
            cstm.registerOutParameter(5, OracleTypes.NUMBER);       //pn_id_certificado
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words = ""+cstm.getString(5);              
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_verifica")
    public String ingresar_audit_verifica(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip, 
                                            @WebParam(name = "sesion_php") String sesion_php,
                                            @WebParam(name = "observaciones") String observaciones,
                                            @WebParam(name = "email_anterior") String email_anterior,
                                            @WebParam(name = "email_nuevo") String email_nuevo)
    {
        String words = "";         
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_verifica(?, ?, ?, ?, ?,?,?)}";
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);      //pv_identificacion
            cstm.setString(2, ip);    //pv_ip
            cstm.setString(3, sesion_php);         //pv_sesion_php
            cstm.setString(4, observaciones);         //pv_observaciones
            cstm.setString(5, email_anterior);         //pv_email_anterior
            cstm.setString(6, email_nuevo);         //pv_email_nuevo
            cstm.registerOutParameter(7, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();  
            
            words = cstm.getString(7);      
            
            if(words=="")
                words = "EXITO";
            //mensaje = ""+cstm.getString(2);        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words = sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "retorna_datos_cit_radar")
    public String[] retorna_datos_cit_radar(@WebParam(name = "citacion") String citacion, 
                                            @WebParam(name = "placa") String placa                                            
                                            )
    {
        String[] words = new String [17];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_inter_infracciones_1.retorna_datos_cit_radar(?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";//19
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, citacion);                        //pv_citacion
            cstm.setString(2, placa);                           //pv_placa
            
            cstm.registerOutParameter(3, OracleTypes.DATE);   //pd_fecha_captura
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_hora_captura
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);   //pv_sitio
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_velocidadlim
            cstm.registerOutParameter(7, OracleTypes.VARCHAR);   //pv_velocidadcap
            cstm.registerOutParameter(8, OracleTypes.VARCHAR);  //pv_latitud
            cstm.registerOutParameter(9, OracleTypes.VARCHAR);   //pv_longitud
            cstm.registerOutParameter(10, OracleTypes.VARCHAR); //pv_marca
            cstm.registerOutParameter(11, OracleTypes.VARCHAR);  //pv_modelo
            cstm.registerOutParameter(12, OracleTypes.VARCHAR); //pv_clave
            cstm.registerOutParameter(13, OracleTypes.VARCHAR);  //pv_servicio
            cstm.registerOutParameter(14, OracleTypes.VARCHAR); //pv_color
            cstm.registerOutParameter(15, OracleTypes.VARCHAR);  //pv_codigo_vig
            cstm.registerOutParameter(16, OracleTypes.VARCHAR); //pv_nombre_infr
            cstm.registerOutParameter(17, OracleTypes.VARCHAR);  //pv_ident_infr
            cstm.registerOutParameter(18, OracleTypes.VARCHAR); //pv_nombre_vig
            cstm.registerOutParameter(19, OracleTypes.VARCHAR);  //pv_error
     
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(3);     
            words[1] = cstm.getString(4);     
            words[2] = cstm.getString(5);     
            words[3] = cstm.getString(6);     
            words[4] = cstm.getString(7);     
            words[5] = cstm.getString(8);     
            words[6] = cstm.getString(9);     
            words[7] = cstm.getString(10);     
            words[8] = cstm.getString(11);     
            words[9] = cstm.getString(12);     
            words[10] = cstm.getString(13);     
            words[11] = cstm.getString(14);     
            words[12] = cstm.getString(15);     
            words[13] = cstm.getString(16);     
            words[14] = cstm.getString(17);     
            words[15] = cstm.getString(18);     
            words[16] = cstm.getString(19);             
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_audit_dc")
    public String[] ingresar_audit_dc(@WebParam(name = "identificacion") String identificacion, 
                                            @WebParam(name = "ip") String ip,   
                                            @WebParam(name = "sesion_php") String sesion_php,   
                                            @WebParam(name = "observaciones") String observaciones,   
                                            @WebParam(name = "usuario") String usuario,  
                                            @WebParam(name = "institucion") String institucion
                                            )
    {
        String[] words = new String [3];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_audit_dc(?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?)}";//9
                    
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, identificacion);                  //pv_identificacion
            cstm.setString(2, ip);                              //pv_ip
            cstm.setString(3, sesion_php);                      //pv_sesion_php
            cstm.setString(4, observaciones);                   //pv_observaciones
            cstm.setString(5, usuario);                         //pv_usuario
            cstm.setString(6, institucion);                     //pv_institucion
            cstm.registerOutParameter(7, OracleTypes.VARCHAR); //pv_id_duplicado
            cstm.registerOutParameter(8, OracleTypes.VARCHAR); //pv_id_auditoria
            cstm.registerOutParameter(9, OracleTypes.VARCHAR); //pv_error           
     
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(7); //duplicado    
            words[1] = cstm.getString(8);    //auditoria
            words[2] = cstm.getString(9);                           
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "ingresar_codigo_dc")
    public String[] ingresar_codigo_dc(@WebParam(name = "id_auditoria")         String id_auditoria, 
                                            @WebParam(name = "codigo_duplicado") String codigo_duplicado                                            
                                            )
    {
        String[] words = new String [1];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call cek_servicios.ingresar_codigo_dc(?, ?, ?)}";//9
                    
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, id_auditoria);                  //pv_id_audit
            cstm.setString(2, codigo_duplicado);              //pv_codigo_duplicado
            cstm.registerOutParameter(3, OracleTypes.VARCHAR); //pv_error           
     
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(3);                                        
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    /*@WebMethod(operationName = "Infracciones_x_citacion")
    public String[] Infracciones_x_citacion(@WebParam(name = "citacion") String citacion                                                                                       
                                            )
    {
        String[] words = new String [17];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_inter_infracciones_1.Infracciones_x_citacion(?, ?)}";//2
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, citacion);                        //pv_citacion            
            cstm.registerOutParameter(2, OracleTypes.CURSOR);  //C_INFRAC       
     
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(3);     
            words[1] = cstm.getString(4);     
            words[2] = cstm.getString(5);     
            words[3] = cstm.getString(6);     
            words[4] = cstm.getString(7);     
            words[5] = cstm.getString(8);     
            words[6] = cstm.getString(9);     
            words[7] = cstm.getString(10);     
            words[8] = cstm.getString(11);     
            words[9] = cstm.getString(12);     
            words[10] = cstm.getString(13);     
            words[11] = cstm.getString(14);     
            words[12] = cstm.getString(15);     
            words[13] = cstm.getString(16);     
            words[14] = cstm.getString(17);     
            words[15] = cstm.getString(18);     
            words[16] = cstm.getString(19);             
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }*/

    @WebMethod(operationName = "retorna_uniformado")
    public String[] retorna_uniformado(@WebParam(name = "citacion") String citacion)
    {
        String[] words = new String [3];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_inter_infracciones_1.retorna_uniformado(?, ?, ?, ?)}";//4
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1, citacion);                        //pv_sec_libretin            
            cstm.registerOutParameter(2, OracleTypes.DOUBLE);   //pn_persona_uni
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_dec_persona_uni
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_error
     
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(2);     
            words[1] = cstm.getString(3);     
            words[2] = cstm.getString(4);                       
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    @WebMethod(operationName = "retorna_datos_veh")
    public String[] retorna_datos_veh(@WebParam(name = "placa") String placa)
    {
        String[] words = new String [6];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_inter_infracciones_1.retorna_datos_veh(?, ?, ?, ?, ?, ?, ?)}";//7
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1,placa);                        //pv_placa
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //pv_marca
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_modelo
            cstm.registerOutParameter(4, OracleTypes.VARCHAR);  //pv_clase
            cstm.registerOutParameter(5, OracleTypes.VARCHAR);  //pv_color
            cstm.registerOutParameter(6, OracleTypes.VARCHAR);  //pv_propietario
            cstm.registerOutParameter(7, OracleTypes.VARCHAR);  //pv_error
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(2);     
            words[1] = cstm.getString(3);     
            words[2] = cstm.getString(4);
            words[3] = cstm.getString(5);
            words[4] = cstm.getString(6);
            words[5] = cstm.getString(7);
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }
    
    
    
    
    /*@WebMethod(operationName = "consultar_notificacion")
    public String[] consultar_notificacion(@WebParam(name = "citacion") String citacion)
    {
        String[] words = new String [6];
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar(); 
        String sql = "{call web_inter_infracciones_1.retorna_datos_veh(?, ?, ?)}";//7
        try
        {
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql);            
            cstm.setString(1,placa);                            //pv_citacion
            cstm.registerOutParameter(2, OracleTypes.VARCHAR);  //c_notificacion
            cstm.registerOutParameter(3, OracleTypes.VARCHAR);  //pv_error            
            cstm.executeUpdate();            
           
            words[0] = cstm.getString(2);     
            words[1] = cstm.getString(3);     
            words[2] = cstm.getString(4);
            words[3] = cstm.getString(5);
            words[4] = cstm.getString(6);
            words[5] = cstm.getString(7);
        } 
        catch (Exception sqlException) {
            //throw new MyException("error text", sqlException);
            words[0] = "Exception SQL: " + sqlException.getMessage();
        }                 
        //return mensaje;
        return words;
    }*/
    /*@WebMethod(operationName = "Infracciones_x_identificacion")
    public ArrayList<clsData> Infracciones_x_identificacion(@WebParam(name = "identificacion") String identificacion) {
        ArrayList<clsData> data = new ArrayList<clsData>();  
        
        //String [][] nombres = new String [1][1];
        ResultSet rs = null; 
        
        clsConexion objConexion = new clsConexion(); 
        objConexion.conectar();        
        String sql = "{call web_inter_infracciones_1.Infracciones_x_identificacion(?, ?)}";
        try
        {
            
            CallableStatement cstm = objConexion.getConexion().prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                    ResultSet.CONCUR_READ_ONLY);            
            cstm.setString(1, identificacion);                 //pv_identificacion
            cstm.registerOutParameter(2, OracleTypes.CURSOR);  //C_INFRAC            
            cstm.executeUpdate();  
            
            rs = (ResultSet)cstm.getObject(2); //Forma #1	
           
            while( rs.next( ) ){               
                clsData oListaTemporal = new clsData();
                oListaTemporal.setDato1(rs.getString("FACTURA"));
                oListaTemporal.setDato2(rs.getString("NUM_INFRACCION"));
                oListaTemporal.setDato3(rs.getString("TIPO_INFRACCION"));
                oListaTemporal.setDato4(rs.getString("IDENTIFICACION"));
                oListaTemporal.setDato5(rs.getString("PLACA"));
                oListaTemporal.setDato6(rs.getString("FEC_INFRACCION"));
                oListaTemporal.setDato7(rs.getString("web_inter_infracciones_1.mapea"));
                oListaTemporal.setDato8(rs.getString("PUNTOS"));
                oListaTemporal.setDato9(rs.getString("CONTRAVENCION"));
                oListaTemporal.setDato10(rs.getString("VAL_CONTRAV"));
                oListaTemporal.setDato11(rs.getString("MUL_CONTRAV"));
                oListaTemporal.setDato12(rs.getString("TOTAL"));
                oListaTemporal.setDato13(rs.getString("DIRECCION"));
                oListaTemporal.setDato14(rs.getString("PDF"));
                data.add(oListaTemporal);
            } 
        } 
        catch (Exception sqlException) 
        {
            //throw new MyException("error text", sqlException);            
            //nombres[0][0] = "Error en SQL4: " + sqlException.getMessage();
        }     
        return data;
    }*/ 
        
    private static String desencriptar(java.lang.String texto) {
        clave.Service1 service = new clave.Service1();
        clave.Service1Soap port = service.getService1Soap();
        return port.desencriptar(texto);
    }
}
