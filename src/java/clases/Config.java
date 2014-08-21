/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ckaiser
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Properties;
import javax.security.auth.login.Configuration;

public class Config {

private Properties configFile;

private static Config instance;

private Config() {
    configFile = new java.util.Properties();
    //try 
    //{
        //configFile.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

    //            configFile.load(new FileInputStream("config.properties"));
    //} 
    //catch (Exception eta) 
    //{
    //    eta.printStackTrace();
    //}
    try 
    {
        configFile.load(Configuration.class.getClassLoader().getResourceAsStream("config.properties"));
    } 
    catch (IOException ex) 
    {
        ex.printStackTrace();
    }
}

private String getValue(String key) {
return configFile.getProperty(key);
}

public static String getProperty(String key) {
if (instance == null) instance = new Config();
return instance.getValue(key);
}
}