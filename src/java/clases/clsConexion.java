/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.*; 
import java.util.List;
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
        List<String> data_server = consultarDataBd(); 
        String ip           = data_server.get(0); //ip server
        String instancia    = data_server.get(1); //instancia
        String usuario      = data_server.get(2); //user
        String pass         = data_server.get(3); //pass       

        try { 
            Class.forName("oracle.jdbc.OracleDriver"); 
             String BaseDeDatos = "jdbc:oracle:thin:@" + ip + ":1521:" + instancia;
            //String BaseDeDatos = "jdbc:oracle:thin:@10.30.1.2:1521:REPLICA"; 

            conexion = DriverManager.getConnection(BaseDeDatos, usuario, pass); 
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

    private static java.util.List<java.lang.String> consultarDataBd() {
        clases.ListProcesos_Service service = new clases.ListProcesos_Service();
        clases.ListProcesos port = service.getListProcesosPort();
        return port.consultarDataBd();
    }

   

  

   

   

}
