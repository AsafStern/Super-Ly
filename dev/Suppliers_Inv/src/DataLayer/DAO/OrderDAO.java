package DataLayer.DAO;

import BussinessLayer.Response;
import BussinessLayer.ResponseT;
import DataLayer.DTO.OrderDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO extends DAO{


    public Response insert(Integer orderID, Integer supplierID, boolean delivered, LocalDate supplyDate, double price) {

        String order = "INSERT INTO Orders (orderID, supplierID, delivered, supplyDate, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConn().value;
             PreparedStatement pstmt = conn.prepareStatement(order);) {

            // inserting to employee table
            pstmt.setInt(1, orderID);
            pstmt.setInt(2, supplierID);
            pstmt.setBoolean(3,delivered);
            pstmt.setDate(4, Date.valueOf(supplyDate));
            pstmt.setFloat(5, (float) price);


            pstmt.execute();

        } catch (SQLException e) {
            return new Response(e.getMessage());
        }
        return new Response();
    }


    public Response insert(OrderDTO order){
        return insert(order.getOrderID(), order.getSupplierID(), order.isDelivered(), order.getSupplyDate(), order.getPrice());
    }

    //SELECT
    public ResponseT<OrderDTO> get(Integer orderID){
        String orderSQL = String.format("SELECT * FROM Orders WHERE orderID = %s", orderID);

        try(Connection conn = getConn().value;
            Statement ordStmt = conn.createStatement();
            ResultSet ordRs = ordStmt.executeQuery(orderSQL);){

            if(ordRs.isClosed())
                return new ResponseT<>(null, String.format("orderID %s not found", orderID));
            OrderDTO order = new OrderDTO(ordRs.getInt("orderID"),
                    ordRs.getInt("supplierID"), ordRs.getBoolean("delivered"),
                    ordRs.getDate("supplyDate").toLocalDate(), ordRs.getFloat("price"));

            return new ResponseT<>(order);

        }catch(SQLException e){
            e.printStackTrace();
            return new ResponseT<>(null, e.getMessage());
        }

    }

    public Response delete(Integer orderID) {
        String SQL = "DELETE FROM Orders WHERE orderID = ?";
        try {
            ResponseT<Connection> r = getConn();
            if(!r.ErrorOccured()) {
                PreparedStatement ps = r.value.prepareStatement(SQL);
                ps.setInt(1, orderID);

                ps.execute();
            }
        }catch (SQLException e) {
            return new Response(e.getMessage());
        }
        return new ResponseT(orderID);
    }
    //TODO: update functions ???????

    public ResponseT<List<OrderDTO>> read() {
        String SQL = "SELECT * FROM Supplier";
        List<OrderDTO> orderList = new LinkedList<>();
        try {
            ResponseT<Connection> r = getConn();
            if(!r.ErrorOccured()) {
                PreparedStatement ps = r.value.prepareStatement(SQL);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    orderList.add(new OrderDTO(rs.getInt("orderID"), rs.getInt("supplierID"),
                            rs.getBoolean("delivered"), rs.getDate("supplyDate").toLocalDate(),
                            rs.getDouble("price")));
                }
            }
        }catch (Exception e) {
            return new ResponseT("cannot get faulty item");
        }
        return new ResponseT<>(orderList);
    }
}
