package tests;

import org.junit.Before;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.SQLException;

public class UpdateData {

    @Before
    public void setUp(){
        DBUtils.createConnection();
    }

    @Test
    public void updateData() throws SQLException {
        //Hotel de Name column uni ver
        String query="SELECT Email FROM dbo.tHOTEL;";
        DBUtils.executeQuery(query);// Su an query calisti. Datalar resultSet in icinde
        DBUtils.getResultset().next();
        DBUtils.getResultset().next();
        while (DBUtils.getResultset().next()){
            String names=DBUtils.getResultset().getString("Email");
            System.out.println(names);

        }

        String update="UPDATE dbo.tHOTEL SET Email = 'jdbc@email.com' WHERE IDHotel = 10;";
        DBUtils.executeQuery(query);

        while (DBUtils.getResultset().next()){
            String names=DBUtils.getResultset().getString("Email");
            System.out.println(names);



        }}
}
