package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class Controller {
    @GetMapping("/call")
    public String number(){
        return "123";
    }
    @PostMapping("/dbcall")
    public ArrayList<String> numbear(){
        ArrayList<String> arr = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "c##mmoottss";
        String pass = "wltnghks";
        String sql = "select * from ELEVISOR";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                arr.add(rs.getString("city"));
                System.out.println(rs.getString("city"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }
    @PostMapping("/dbrcall")
    public boolean dbr(@RequestBody Map map){
        Connection conn = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "c##mmoottss";
        String pass = "wltnghks";
        String sql = "insert into info values(?,?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,pass);
            pstmt = conn.prepareStatement(sql);
            System.out.println((String) map.get("id"));
            System.out.println((String) map.get("id"));
            System.out.println((String) map.get("id"));
            System.out.println((String) map.get("id"));
            pstmt.setString(1,((String)map.get("id").toString()));
            pstmt.setString(2,((String)map.get("pw").toString()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
