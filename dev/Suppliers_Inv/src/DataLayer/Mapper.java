package DataLayer;

import BussinessLayer.Inventory.Category;
import BussinessLayer.ResponseT;
import DataLayer.DAO.*;
import DataLayer.DTO.BillOfQuantityDTO;
import DataLayer.DTO.OrderDTO;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
        /**
         * This class holds the identity maps of Employees and Shifts.
         * Any access to the data base goes through here.
         */
        private BillOfQuantityDAO billOfQuantityDAO;
        private CategoryDAO categoryDAO;
        private OrderDAO orderDAO;
        private ProductsInOrderDAO productsInOrderDAO;
        private ProductsOfSupplierDAO productsOfSupplierDAO;
        private SupplierDAO supplierDAO;
        private Map<Integer, BillOfQuantityDTO> billsOfQuantity;
        private Map<Integer, OrderDTO> orders;

        private static class MapperHolder {
            private static Mapper instance = new Mapper();
        }

        private Mapper() {
            billOfQuantityDAO = new BillOfQuantityDAO();
            categoryDAO = new CategoryDAO();
            orderDAO = new OrderDAO();
            productsInOrderDAO = new ProductsInOrderDAO();
            productsOfSupplierDAO = new ProductsOfSupplierDAO();
            supplierDAO = new SupplierDAO();
            billsOfQuantity = new HashMap<>();
            orders = new HashMap<>();
        }

        public static Mapper getInstance(){
            return MapperHolder.instance;
        }

        public ResponseT<BillOfQuantityDTO> getBillOfQuantity(Integer supplierID) {
            if (billsOfQuantity.containsKey(supplierID))
                return new ResponseT<>(billsOfQuantity.get(supplierID));
            ResponseT<BillOfQuantityDTO> bill = billOfQuantityDAO.get(supplierID);
            if (!bill.ErrorOccured())
                billsOfQuantity.put(supplierID, bill.value);
            return bill;
        }

    public ResponseT<OrderDTO> getOrder(Integer orderID) {
        if (orders.containsKey(orderID))
            return new ResponseT<>(orders.get(orderID));
        ResponseT<OrderDTO> order = orderDAO.get(orderID);
        if (!order.ErrorOccured())
            orders.put(orderID, order.value);
        return order;
    }


}
