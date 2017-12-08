package kata5p2.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;
import java.sql.Statement;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MailListReaderDB {
    
    public static List<Mail> read() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        List<Mail> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:.\\KATA5.db");
    
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT Mail FROM MAIL");
      
        
        while (resultset.next()) {
            String mail = resultset.getString("Mail");
            if (!mail.contains("@")) continue;
            mailList.add(new Mail(mail));
        }
        return mailList;
    }

}