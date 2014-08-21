/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.*; 
import javax.servlet.ServletConfig;

/**
 *
 * @author ckaiser
 */
public class clsConexion {
    private Connection conexion; 
     
    public Connection getConexion() 
    { 
        return conexion; 
    }    

    public void setConexion(Connection conexion) { 
        this.conexion = conexion; 
    }  

    public clsConexion conectar_prueba() { 
        //ServletConfig config = null;
                //super.init(config);
        //String user = config.getInitParameter("userId");
        //Config cfg = new Config();
        //String dbuser   = Config.getProperty("mDbUser");
        //String dbname   = "transito";

        try { 
            Class.forName("oracle.jdbc.OracleDriver"); 
             String BaseDeDatos = "jdbc:oracle:thin:@10.10.1.36:1521:PRTRAN";
            //String BaseDeDatos = "jdbc:oracle:thin:@10.30.1.2:1521:REPLICA"; 

            conexion = DriverManager.getConnection(BaseDeDatos, "transito","transito"); 
            //conexion = DriverManager.getConnection(BaseDeDatos, "USRWEB2","NHU56TGB");    
            if (conexion != null) { 
                System.out.println("Conexion exitosa!"); 
            } else { 
                System.out.println("Conexion fallida!"); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }        return this; 
    } 
    
    public clsConexion conectar_produccion() { 
        try { 
            Class.forName("oracle.jdbc.OracleDriver"); 
            String BaseDeDatos = "jdbc:oracle:thin:@10.30.1.2:1521:REPLICA"; 

            conexion = DriverManager.getConnection(BaseDeDatos, "USRWEB2","NHU56TGB");             
            if (conexion != null) { 
                System.out.println("Conexion exitosa!"); 
            } else { 
                System.out.println("Conexion fallida!"); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }        return this; 
    } 

    public boolean escribir(String sql) { 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeUpdate(sql); 
            getConexion().commit(); 
            sentencia.close(); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            System.out.print("ERROR SQL"); 
            return false; 
        }         
        return true; 
    } 

    public ResultSet consultar(String sql) { 
        ResultSet resultado = null; 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            resultado = sentencia.executeQuery(sql); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        return resultado; 
    } 

}
