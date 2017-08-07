import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARMID060817M on 8/7/2017.
 */
public class StockManagerObserver implements Observer {

    private List<Item> stock = new ArrayList<Item>();
    private static int observerIDTrack = 0;
    private int observerID;

    public StockManagerObserver(Command command) {
        observerID = ++observerIDTrack;
        System.out.println("Observer " + observerID + " Created");
        command.addObserver(this);
    }

    @Override
    public void update(List<Item> stock) {
        this.stock.clear();
        this.stock.addAll(stock);
        printAll();
    }

    @Override
    public void printAll() {
        System.out.print("stock:{");
        stock.forEach(item -> {
            System.out.print("[id: " + item.Id + ", type: " + item.stockType + "]");
        });
        System.out.print("}\n");
    }
}