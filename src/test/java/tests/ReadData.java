package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.SQLException;

public class ReadData {

    @Before
    public void setUp(){
        DBUtils.createConnection();
    }

    @Test
    public void readData() throws SQLException {
        //Hotel de Name column uni ver
        String query="SELECT Name FROM dbo.tHOTEL;";
        DBUtils.executeQuery(query);// Su an query calisti. Datalar resultSet in icinde

        //Bu Adimdan sonra resultSet objecsini kullanaral datalari okuyabilirim
        //Satir atlatiyorum
        DBUtils.getResultset().next();
        DBUtils.getResultset().next();
        DBUtils.getResultset().next();
        //resultSet => DBUtils.getResultset()
        //resultSet.getString yada resultSet.getObject methodu ile datalari okuyabiliriz
        Object ilkIsim=DBUtils.getResultset().getObject("Name");
        System.out.println(ilkIsim);
        //Bir sonraki deger varsa while looun icine gir, yoksa loopa girme
        while (DBUtils.getResultset().next()){
            String names=DBUtils.getResultset().getString("Name");
            System.out.println(names);
        }

        //15. satira git
        DBUtils.getResultset().absolute(15);
        String deger15=DBUtils.getResultset().getString("Name");
        System.out.println("deget 15 : "+deger15);
        //15. Hotelde ki 15. Satirdaki ismin LILLE olup olmadigini kontrol et
        Assert.assertEquals(deger15,"LILLE");





    }
}
