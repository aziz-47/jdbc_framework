package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.security.pkcs11.Secmod;
import utilities.DBUtils;


public class DBUtilsTest {

    @Before
    public void setUp(){
        DBUtils.createConnection();
    }

    @Test
    public void dbUtilsTest() throws Exception {
        //DBUtils deki methodlari nasil kullanabilirim?
        //1. Query Yaz
        String query="SELECT * FROM dbo.tHOTEL WHERE IDHotel=15;";
        //2. DBUtils deki executeQuery ti kullarak calistir
        DBUtils.executeQuery(query);
        //3. DBUtils deki diger methodlari kullanarak islem yapabiliriz
        System.out.println("Number Of Row => "+DBUtils.getRowCount());
        System.out.println("Current Cell Value => "+DBUtils.getCellValue(query));
        System.out.println("Get Row List => "+DBUtils.getRowList(query));
        System.out.println("Get Row Map => "+DBUtils.getRowMap(query));
        System.out.println("Get Query Result => "+ DBUtils.getQueryResultList(query));
        //Kullanilan yaygin methodlardan:
        System.out.println("GEt Column Data => "+DBUtils.getColumnData(query,"Email"));

        //15. satirdaki Email in UUpdatingg@gmail.com oldugunu dogrula
        Assert.assertEquals(DBUtils.getColumnData(query,"Email").toString(),"[UUpdatingg@gmail.com]");

        //15. satirda Johnson diye bir data nin olup olmadigini test et
        Assert.assertTrue(DBUtils.getRowList(query).contains("Johnson"));


    }
}
