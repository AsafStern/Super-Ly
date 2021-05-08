package BussinessLayer.Supplier;
import BussinessLayer.Response;
import BussinessLayer.ResponseT;
import DataLayer.Mapper;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;


// Singleton
public class FacadeSupplier {

    private static FacadeSupplier facadeSupplier = null;

    private SupplierController supController;
    private OrderController orderController;
    private HashMap<Integer, LinkedList<Integer>> supplierOrder;


    private FacadeSupplier() {
        supController = SupplierController.getInstance();
        orderController = OrderController.getInstance();
        supplierOrder = new HashMap<>();
    }

    public static FacadeSupplier getInstance() {
        if (facadeSupplier == null)
            facadeSupplier = new FacadeSupplier();

        return facadeSupplier;
    }


    /***************** Supplier & Products Functions: ***************/

    public Response createSupCard(String supplierName, int supplierID, String address, String email, int bankAcc,
                                  String paymentMethod, String contacts, String infoSupplyDay, boolean pickUp) {
        try{
            supController.createSupCard(supplierName, supplierID, address, email, bankAcc, paymentMethod, contacts, infoSupplyDay, pickUp);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response deleteSupCard(int supplierID){
        try {
            supController.deleteSupCard(supplierID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response addBillOfQuantity(int supplierID, HashMap<Integer, Integer> minQuantityForDis,  HashMap<Integer, Integer> discountList) {
        try{
            supController.addBillOfQuantity(supplierID, minQuantityForDis,discountList);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response deleteBillOfQuantity(int supplierID) {
        try {
            supController.deleteBillOfQuantity(supplierID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response editMinQuantity(int supplierID, int pid, int newQ) {
        try{
            orderController.editMinQuantity(supplierID,pid,newQ);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response editDiscount(int supplierID, int pid, int discount) {
        try{
            orderController.editDiscount(supplierID,pid,discount);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response addProdToBill(int supplierID, int pid, int minQ, int discount) {
        try{
            orderController.addProdToBill(supplierID,pid,minQ,discount);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response removeProdFromBill(int supplierID, int pid) {
        try{
            orderController.removeProdFromBill(supplierID,pid);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response EditSupplierName(int supplierID, String supplierName) {
        try{
            supController.EditSupplierName(supplierID , supplierName);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response EditAddress(int supplierID, String address) {
        try {
            supController.EditAddress(supplierID, address);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response EditEmail(int supplierID, String email) {
        try{
            supController.EditEmail(supplierID , email);
            return new Response();
        }
        catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response EditBankAccount(int supplierID, int bankAccount) {
        try {
            supController.EditBankAccount(supplierID , bankAccount);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response EditPaymentMethod(int supplierID, String payment) {
        try {
            supController.EditPaymentMethod(supplierID , payment);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response EditContact(int supplierID, String contact) {
        try {
            supController.EditContact(supplierID , contact);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response EditInfoSupDay(int supplierID, String infoSupDay) {
        try {
            supController.EditInfoSupDay(supplierID , infoSupDay);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response EditPickup(int supplierID, boolean pickup) {
        try {
            supController.EditPickup(supplierID , pickup);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<String> showSupplierCard(int supplierID){
        try {
            String s = supController.showSupplierCard(supplierID);
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public Response addProductToSupplier(int supplierID, int productID, String name, String category, double price) {
        try {
            supController.addProductToSupplier(supplierID, productID, name, category, price);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response removeProductToSupplier(int supplierID, int productID) {
        try {
            supController.removeProductToSupplier(supplierID, productID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<String> showSupplierProducts(int supplierID){
        try {
            String s = supController.showSupplierProducts(supplierID);
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public ResponseT<String> showAllSupplier(){
        try {
            String s = supController.showAllSupplier();
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public Response checkSuppExist(int suppID) {
        try {
            supController.checkSuppExist(suppID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response checkSuppNotExist(int suppID){
        try{
            supController.checkSuppNotExist(suppID);
            return new Response();
        }catch (Exception e){
            return new Response(e.getMessage());
        }
    }

    public Response checkBillExist(int suppID) {
        try {
            supController.checkBillExist(suppID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response checkBillNotExist(int suppID) {
        try {
            supController.checkBillNotExist(suppID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response checkProductExist(int supID, int prodID){
        try {
            supController.checkProductExist(supID,prodID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response checkProductInBillOfQ(int supID, int prodID){
        try {
            supController.checkProductInBillOfQ(supID,prodID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    /***************** Orders Functions: ***************/


    public ResponseT<Integer> createOrder(int supplierID){
        try{
            int orderID = orderController.createOrder(supplierID);
            LinkedList<Integer> ordersOfSupplier = supplierOrder.get(supplierID);
            if( ordersOfSupplier != null){
                ordersOfSupplier.add(orderID);
            }
            else{
                ordersOfSupplier = new LinkedList<>();
                ordersOfSupplier.add(orderID);

                supplierOrder.put(supplierID,ordersOfSupplier);
            }
            return new ResponseT<>(orderID);
        }catch(Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public ResponseT<Integer> createPeriodicOrder(int interval, LocalDate date){
        try{
            int orderID = orderController.createPeriodicOrder(interval,date);
            return new ResponseT<>(orderID);
        }catch(Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public Response addProductToOrder(int orderID, int productID , int quantity) {
        try {
            orderController.addProductToOrder(orderID, productID, quantity);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response addProductToPeriodicOrder(int orderID, int productID , int quantity) {
        try {
            orderController.addProductToPeriodicOrder(orderID, productID, quantity);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response removeFromOrder(int productID , int orderID) {
        try {
            orderController.removeFromOrder(productID ,orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response removeOrder(int orderID) {
        try {
            orderController.removeOrder(orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response removePOrder(int orderID) {
        try {
            orderController.removePOrder(orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response removePeriodicOrder(int orderID) {
        try {
            orderController.removePeriodicOrder(orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response updateProdQuantity(int orderID, int productID, int quantity) {
        try {
            orderController.updateProdQuantity(orderID, productID,quantity);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<String> showAllOrders(){
        try {
            String s = orderController.showAllOrders();
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public ResponseT<String> showAllPOrders(){
        try {
            String s = orderController.showAllPOrders();
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public ResponseT<String> showOrdersBySupplier(int supplierID) {
        try {
            String allOrders = '\n'+ "All Supplier Number:" + supplierID + " Orders Are: " ;
            Response res = checkSuppExist(supplierID);
            LinkedList<Integer> listOfOrders = supplierOrder.get(supplierID);
            if (listOfOrders == null){
                return new ResponseT<>('\n' + " No Orders Yet For This Supplier");
            }
            for(Integer order : listOfOrders){
                allOrders += '\n' + "Order ID: "+ order +  ", Date: " + orderController.orders.get(order).getDate()  ;
            }
            return new ResponseT<>(allOrders + '\n');
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public Response finalPriceForOrder(int OrderID, int suppID){
        try {
            orderController.finalPriceForOrder(OrderID, suppID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<String> showOrder(int orderID){
        try {
            String s = orderController.showOrder(orderID);
            return new ResponseT<>(s);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    public boolean isEmptyOrder(int orderID){
        return orderController.isEmptyOrder(orderID);
    }

    public boolean isEmptyPOrder(int orderID){
        return orderController.isEmptyPOrder(orderID);
    }

    public Response productInOrder(int orderID, int prodID){
        try {
            orderController.productInOrder(orderID, prodID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public ResponseT<HashMap<Integer, Integer>> getProductOfporder(int orderID) {
        try {
            HashMap<Integer, Integer> prods = orderController.getProductOfporder(orderID);
            return new ResponseT<>(prods);
        } catch (Exception e) {
            return new ResponseT<>(e.getMessage());
        }
    }

    // this function iterate over all suppliers and find for each product in the param:prods the cheapest supplier
    public HashMap<Integer, HashMap<Integer, Integer>> findCheapestSupplier(HashMap<Integer, Integer> prods) {
        HashMap<Integer, HashMap<Integer, Integer>> supplierAndProds = new HashMap<>(); //Integer:supplier, HashMap: his products
        // iterate over all items that we need to find them cheapest supplier
        for(Integer item : prods.keySet()){
            int cheapestSupplier = -1;
            double cheapestPrice = -1;
            HashMap<Integer, HashMap<Integer, Product>> SAP = orderController.prodController.getSupplierProd();
            // iterate over all suppliers
            for(Integer supplierID : SAP.keySet()){
                HashMap<Integer, Product> products = SAP.get(supplierID);
                // iterate over all supplierID products
                for(Product product : products.values()){
                    if(product.getProductID() == item){
                        // if only one supplier supply this product
                        if(cheapestSupplier == -1){
                            cheapestSupplier = supplierID;
                            cheapestPrice = product.getPrice();
                        }
                        else{
                            // if we found cheaper supplier that supply this product
                            if(product.getPrice() < cheapestPrice){
                                cheapestSupplier = supplierID;
                                cheapestPrice = product.getPrice();
                            }
                        }
                    }
                    if (cheapestSupplier == -1){
                        throw new IllegalArgumentException("The System Did Not Found Any Supplier That Supply Item Number: "+ product.getProductID());
                    }
                }
            }
            // add to the supplier the item
            HashMap<Integer, Integer> products;//itemID + quantity
            if(supplierAndProds.containsKey(cheapestSupplier)){
                products = supplierAndProds.get(cheapestSupplier);
            }
            else{
                products = new HashMap<>();
            }
            products.put(item,prods.get(item)); //itemID + quantity
            supplierAndProds.put(cheapestSupplier,products);
        }
        return supplierAndProds;
    }


    public boolean checkOrderPExist(int orderID) {
        return orderController.checkOrderPExist(orderID);
    }

    public HashMap<Integer, PeriodicOrder> checkForApproachingPOrders() {
        return orderController.checkForApproachingPOrders();
    }

    public Response removeProdFromPOrder(int productID, int orderID) {
        try {
            orderController.removeProdFromPOrder(productID ,orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response changeInterval(int interval, int orderID) {
        try {
            orderController.changeInterval(interval ,orderID);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    public Response editQuantityForPOrder(int productID, int orderID, int quant) {
        try {
            orderController.editQuantityForPOrder(orderID, productID,quant);
            return new Response();
        } catch (Exception e) {
            return new Response(e.getMessage());
        }
    }
}