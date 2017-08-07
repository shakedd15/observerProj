import java.util.Scanner;

/**
 * Created by ARMID060817M on 8/7/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        StockManagerObservable stockManagerObs1 = new StockManagerObservable();
        StockManagerObserver manager = new StockManagerObserver(stockManagerObs1);
        StockManagerObserver userTwo = new StockManagerObserver(stockManagerObs1);
        StockManagerObserver userThree = new StockManagerObserver(stockManagerObs1);
        int command = 6;
        do {
            System.out.print("press 1- to add new item to stock\n" +
                    "press 2- to delete item from stock\n" +
                    "press 3- to change current item\n" +
                    "press 4- to save changes\n" +
                    "press 5- to change to another User\n");
            command = reader.nextInt();

            switch (command){
                case (1):{
                    System.out.print("enter itemId and itemType\n");
                    int id = reader.nextInt();
                    String type = reader.next();
                    stockManagerObs1.addItem(new Item(id,type));
                    break;
                }
                case (2):{
                    System.out.print("please enter the item id to delete\n");
                    int id = reader.nextInt();
                    stockManagerObs1.removeItem(id);
                    break;
                }
                case (3):{
                    System.out.print("please enter the item id and the type you would like to change\n");
                    int id = reader.nextInt();
                    String type = reader.next();
                    stockManagerObs1.changeCurrentItem(id, type);
                    break;
                }
                case (4):{
                    stockManagerObs1.saveChanges();
                    break;
                }
                case (5):{
                    System.out.print("please enter the user you would like to see 1-2-3\n");
                    int id = reader.nextInt();
                    stockManagerObs1.changeCurrentUser(id);
                    break;
                }
            }
        }while (true);

    }
}
