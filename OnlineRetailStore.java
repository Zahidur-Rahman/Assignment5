import java.util.HashMap;
import java.util.Map;

// Warehouse interface
interface Warehouse {
    Map<String, Integer> getAvailableProducts();
}

// Real Warehouse - The actual warehouse with product inventory
class RealWarehouse implements Warehouse {
    private Map<String, Integer> products;

    public RealWarehouse() {
        products = new HashMap<>();
        products.put("Product A", 100);
        products.put("Product B", 50);
        products.put("Product C", 75);
    }

    @Override
    public Map<String, Integer> getAvailableProducts() {
        return products;
    }
}

// Warehouse Proxy - Proxy for the real warehouse with access control
class WarehouseProxy implements Warehouse {
    private RealWarehouse realWarehouse;

    public WarehouseProxy() {
        realWarehouse = new RealWarehouse();
    }

    @Override
    public Map<String, Integer> getAvailableProducts() {
        // Add access control logic here, e.g., based on location or authorization
        return realWarehouse.getAvailableProducts();
    }
}

public class OnlineRetailStore {
    public static void main(String[] args) {
        Warehouse warehouse = new WarehouseProxy();

        // Simulate accessing the warehouse inventory
        System.out.println("Available Products:");
        Map<String, Integer> products = warehouse.getAvailableProducts();

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
