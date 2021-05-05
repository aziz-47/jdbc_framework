package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.SQLException;

public class CreateData {
    @Before
    public void setUp(){
        DBUtils.createConnection();
    }

    @Test
    public void createData() throws SQLException {

        String create = "INSERT INTO dbo.tHOTEL (Code, Name, Address, Phone, Email, IDGroup, CreateDate,CreateUser) VALUES ('555', 'Karadeniz', 'test addressjdbc', '501414442', 'palamut@karadeniz.comjbc', 2222, '2020-10-04 13:38:47.597',4)";
        String read = "SELECT Name FROM dbo.tHOTEL;";
        DBUtils.executeQuery(read);
        DBUtils.getResultset().next();
        //DATA CREATE ETMEDEN ONCE
        while (DBUtils.getResultset().next()) {
            String names = DBUtils.getResultset().getString("Name");
            System.out.println(names);
        }

        //create quer yi calistir
        DBUtils.executeQuery(create);


    }
}
