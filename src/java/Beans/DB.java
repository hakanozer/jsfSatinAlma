/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    // db Değişkenleri
    String url = "jdbc:mysql://localhost:3306/";
    String forname = "com.mysql.jdbc.Driver";
    String dbName = "satinalma";
    String dbUName = "root";
    String dbUPass = "aaaaaa";

    // Bağlantı değişkenleri
    Connection conn = null;
    Statement st = null;

    public Statement baglan() throws SQLException {

        try {
            // kütüphane hazır konuma getiriliyor
            Class.forName(forname);
            conn = DriverManager.getConnection(url + dbName, dbUName, dbUPass);
            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Mysql Bağlantı Hatası : " + e);
        }
        return st;
    }

}
