import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ACuser(User TEXT, pass TEXT)");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
        Connect_Interface connect = new Connect_Interface();
        connect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connect.setResizable(false);
        connect.setVisible(true);
    }
}
