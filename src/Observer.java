import java.util.List;

/**
 * Created by ARMID060817M on 8/7/2017.
 */
public interface Observer {

    public abstract void update(List<Item> stock);
    public void printAll();
}
