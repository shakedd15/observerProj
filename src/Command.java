/**
 * Created by ARMID060817M on 8/7/2017.
 */
public interface Command {

    void addObserver(Observer observer);
    void delObserver(Observer observer);
    void notifyAllObservers();
}
