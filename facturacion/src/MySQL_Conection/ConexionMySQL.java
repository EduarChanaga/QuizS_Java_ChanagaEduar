package MySQL_Conection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionMySQL {

    private String driver;
    private String url;
    private String username;
    private String password;

    public ConexionMySQL() {
        // Cargar propiedades desde el archivo Config.properties
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.properties")) {
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar el archivo Config.properties");
                return;
            }
            // Cargar las propiedades del archivo
            props.load(input);
            

            // Obtener los valores de las propiedades
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (Exception ex) {
            // Manejo de errores
            
        }
    }

    public Connection conectarMySQL() throws SQLException {
        System.out.println("Conexion exitosa");
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;
    }

}