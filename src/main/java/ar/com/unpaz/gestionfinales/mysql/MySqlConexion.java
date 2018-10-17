package ar.com.unpaz.gestionfinales.mysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlConexion {

  private static Connection connection;

  private static String url;
  private static String user;
  private static String pass;

  private MySqlConexion() {
    throw new AssertionError();
  }

  public final synchronized static Connection getConexion() {
    if (connection == null) {
      try {
        connection = createConnection();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  private static Connection createConnection() throws Exception {
    Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownJob()));
    final String path = "src/main/resources/mysql-properties.xml";
    Properties prop = new Properties();
    FileInputStream fis = new FileInputStream(path);
    prop.loadFromXML(fis);
    url = prop.getProperty("url");
    user = prop.getProperty("user");
    pass = prop.getProperty("pass");
    return DriverManager.getConnection(url, user, pass);
  }
  
  private static class ShutdownJob implements Runnable {
    @Override
    public void run() {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (Exception exception) {
        exception.printStackTrace();
      }
    }
  }

}
