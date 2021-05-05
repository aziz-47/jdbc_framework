package com.techproed;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class DataBaseTesting {


    //Dtabase URL
    String url = "jdbc:mysql://107.182.225.121:3306/LibraryMgmt";
    //kullanici adi
    String username = "techpro";
    //sifre
    String password = "tchpr2020";

    //Connection ,Statemnet, ResultSet, objelerini olusturlaim

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Before
    public  void setUp() throws SQLException {
        //getConnectiona methodu ile database baglaniyoruz
        connection= DriverManager.getConnection(url,username,password);
        //createStatement methoduyla statement objesini olusturyoruz.Bu objeyi kullnarak resutset objesini olusturacagiz
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    @Test
    public void Test1() throws SQLException {
        resultSet=statement.executeQuery("SELECT * FROM Book;");
        //ilk satiri atliyoruz
        resultSet.next();
        String deger1= resultSet.getString("BookName");
        System.out.println("DEGER1 : " + deger1);

        //TC_02_BookName deki tum degerleri yazdirinz
        int rowSayisi=1;//su an ilkk satirda oldugumuzdan 1 den basliyoruz
         while (resultSet.next()){
            Object  deger2= resultSet.getObject("BookName");
             System.out.println(deger2.toString());
             rowSayisi++;

         }
        //TC_03_toplam kac 14 satirin olup olmadigini test et
        Assert.assertEquals(14,rowSayisi);
       // System.out.println(rowSayisi); bu row saysisni bulduk


        //TC_04_5. degerin JAVA olup olmadigini test et
        //5 satira git
        resultSet.absolute(5);
        //5. satira git o satirdaki degeri al ve karsilastirma yap
       String deger5 = resultSet.getString("BookName");
       Assert.assertEquals("JAVA",deger5);//FAILED. BUG BULDUK


    }
    @Test

    public void Test2() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM Book;");
        //TC_05_son degerin UIPath olup olmadigini test et
        resultSet.last();
        String degerSon = resultSet.getString("BookName");
        Assert.assertEquals("UIPath", degerSon);

        //TC_06_ilk satirdaki degerin SQL olup olmadigii test et
        resultSet.first();
        String actualResult= resultSet.getString("BookName");
        String expectedResult="SQL";
        Assert.assertEquals(expectedResult,actualResult);


    }

    @Test
    public void  Test3() throws SQLException {
        //MetaData: Datayla ilgili datalar
        DatabaseMetaData dbMetaData = connection.getMetaData();
        System.out.println("USERNAME: " + dbMetaData.getUserName());
        System.out.println("PRODUCT NAME: "+dbMetaData.getDatabaseProductName());
        System.out.println("Database verison :" +dbMetaData.getDatabaseProductVersion());
    }
}
