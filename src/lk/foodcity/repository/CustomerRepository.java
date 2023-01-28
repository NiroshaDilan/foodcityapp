/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.foodcity.repository;

import lk.foodcity.db.DBConnection;
import lk.foodcity.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author Hp
 */
public class CustomerRepository {
    
    public int addCustomer(CustomerDto custmerDto) throws SQLException {
        String sql = "INSERT INTO customer(cus_nic, cus_name, dob, phone, email)"
                + " VALUES(?, ?, ?, ?, ?)";
        
        try (Connection con = new DBConnection().getConnection();
              PreparedStatement ps = con.prepareStatement(sql)){
          
            ps.setString(1, custmerDto.getCustomerNic());
            ps.setString(2, custmerDto.getCustomerName());
            ps.setDate(3, Date.valueOf(custmerDto.getDateOfBirth()));
            ps.setString(4, custmerDto.getPhoneNumber());
            ps.setString(5, custmerDto.getEmail());
            
            return ps.executeUpdate();
        } finally {    
        }
    }
    
    public CustomerDto getCustomerByNic(String nic) throws SQLException {
        ResultSet rs = null;
        String sql = "SELECT * FROM customer WHERE cus_nic = ?";
        try(Connection con = new DBConnection().getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, nic);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                CustomerDto dto = new CustomerDto();
                
                dto.setCustomerId(rs.getInt("cus_id"));
                dto.setCustomerNic(rs.getString("cus_nic"));
                dto.setCustomerName(rs.getString("cus_name"));
                dto.setDateOfBirth(
                        String.valueOf(rs.getDate("dob")));
                dto.setPhoneNumber(rs.getString("phone"));
                dto.setEmail(rs.getString("email"));
                
                return dto;
            }
            
        } finally {
            if (rs != null)
                rs.close();
        }
        
        return null;
    }
    
    public int updateCustomerByNic(CustomerDto customerDto) throws SQLException {
        String sql = "UPDATE customer SET cus_name = ?, dob = ?, phone = ?, "
                + "email = ? WHERE cus_nic = ?";
        try(Connection con = new DBConnection().getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, customerDto.getCustomerName());
            pstmt.setDate(2, Date.valueOf(customerDto.getDateOfBirth()));
            pstmt.setString(3, customerDto.getPhoneNumber());
            pstmt.setString(4, customerDto.getEmail());
            pstmt.setString(5, customerDto.getCustomerNic());
            
            int updatedRow = pstmt.executeUpdate();
            
            if (updatedRow == 1) {
                return updatedRow;
            }
         
        } finally {}
        return 0;
    }
}
