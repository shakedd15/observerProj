import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARMID060817M on 8/7/2017.
 */
public class StockManagerObservable implements Command {
    ArrayList<Observer> observers = new ArrayList<>();
    private boolean isPressSave = false;
    private List<Item> stock = new ArrayList<Item>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        int indexofObsv = observers.indexOf(observer);
        System.out.println("Observer " + (indexofObsv+1) + " DELETED");
        observers.remove(indexofObsv);

    }

    @Override
    public void notifyAllObservers() {
        List<Item> stockCopy = stock;
        this.observers.get(0).update(stockCopy);
        this.observers.get(2).update(stockCopy);
        if(isPressSave){
            this.observers.get(1).update(stockCopy);
            this.isPressSave = false;
        }
    }

    public void addItem(Item item) {
        this.stock.add(item);
        notifyAllObservers();
    }

    public void removeItem(int itemId) {
        this.stock.forEach(item -> {
            if(item.Id == itemId){
                this.stock.remove(item);
            }
        });
        notifyAllObservers();
    }

    public void changeCurrentItem(int itemId, String stockType) {
        this.stock.forEach(item -> {
            if(item.Id == itemId){
                item.stockType = stockType;
            }
        });
        notifyAllObservers();
    }

    public void saveChanges() {
        this.isPressSave = true;
        notifyAllObservers();
    }

    public void changeCurrentUser(int userId) {
        observers.get(userId-1).printAll();
    }
}
