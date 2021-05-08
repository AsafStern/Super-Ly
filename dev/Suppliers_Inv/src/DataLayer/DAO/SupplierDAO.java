package DataLayer.DAO;
import BussinessLayer.Response;
import BussinessLayer.ResponseT;
import DataLayer.DTO.SupplierDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class SupplierDAO extends DAO {

    public Response insert(Integer ID, String name, String address, String email, Integer bankAcc, String paymentMethod,
                           String infoSupDay, String contacts, boolean pickUp) {

        String supplier = "INSERT INTO Supplier (ID, name, address, email, bankAcc, paymentMethod ,infoSupDay, contacts, pickUp) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = getConn().value;
             PreparedStatement pstmt = conn.prepareStatement(supplier);) {

            // inserting to employee table
            pstmt.setInt(1, ID);
            pstmt.setString(2, name);
            pstmt.setString(3,address);
            pstmt.setString(4, email);
            pstmt.setInt(5, bankAcc);
            pstmt.setString(6, paymentMethod);
            pstmt.setString(7, infoSupDay);
            pstmt.setString(8, contacts);
            pstmt.setBoolean(9, pickUp);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            return new Response(e.getMessage());
        }
        return new Response();
    }


    public Response insert(SupplierDTO supplier){
        return insert(supplier.getID(), supplier.getName(), supplier.getAddress(), supplier.getEmail(),
                supplier.getBankAcc(), supplier.getPaymentMethod(), supplier.getInfoSupDay(),
                supplier.getContacts(), supplier.isPickUp());
    }

    //TODO
    public Response update(String col, String ID, String newVal){
        String sql = String.format("UPDATE Employees SET %s = ? WHERE EmpID = ?", col);

        try(Connection conn = getConn().value;
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, newVal);
            pstmt.setString(2, ID);

            pstmt.executeUpdate();

        }catch(SQLException e){
            return new Response(e.getMessage());
        }

        return new Response();
    }

    public Response delete(Integer supplierID) {
        String SQL = "DELETE FROM Supplier WHERE supplierID = ?";
        try {
            ResponseT<Connection> r = getConn();
            if(!r.ErrorOccured()) {
                PreparedStatement ps = r.value.prepareStatement(SQL);
                ps.setInt(1, supplierID);

                if(!ps.execute()) {
                    return new Response("cannot delete supplier "+ supplierID+" from db");
                }
            }
        }catch (SQLException e) {
            return new Response(e.getMessage());
        }
        return new ResponseT(supplierID);
    }

    public ResponseT<List<SupplierDTO>> read() {
        String SQL = "SELECT * FROM Supplier";
        List<SupplierDTO> supplierList = new LinkedList<>();
        try {
            ResponseT<Connection> r = getConn();
            if(!r.ErrorOccured()) {
                PreparedStatement ps = r.value.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    supplierList.add(new SupplierDTO(rs.getInt("ID"), rs.getString("name"),
                            rs.getString("address"), rs.getString("email"),
                            rs.getInt("bankAcc"), rs.getString("paymentMethod"),
                            rs.getString("infoSupDay"), rs.getString("contacts"), rs.getBoolean("pickUp")));
                }
            }
        }catch (Exception e) {
            return new ResponseT("cannot get faulty item");
        }
        return new ResponseT<>(supplierList);
    }

}