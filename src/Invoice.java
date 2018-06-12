import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {

    public static void main(String[] args) throws Exception{
        LineItem lineItem = new LineItem();
        DecimalFormat df2 = new DecimalFormat(".##");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String answer="";
        String itemName;
        int quantity = 0;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(".##");

        while (!answer.equals("n") &&!answer.equals("N")) {
            System.out.println("What did you purchase? \njava book, cobol book, python book");
            ArrayList<String> itemList = new ArrayList<>();
            itemList.add("java book");
            itemList.add("cobol book");
            itemList.add("python book");
            itemName = bf.readLine().toLowerCase();
            while(!itemList.contains(itemName))
                {
                    System.out.println("There are no item with that name.\n");
                    System.out.println("What did you purchase? \njava book, cobol book, python book");
                    itemName = bf.readLine().toLowerCase();
                }
            System.out.println("How many did you order? please input number.");
            quantity = scanner.nextInt();
            while(quantity < 1)
            {
                System.out.println("Please enter valid number.");
                System.out.println("How many did you order? please input number.");
                quantity = scanner.nextInt();
            }

            lineItem.addItems(itemName, quantity);
            System.out.println("Do you want to buy other item? <y/n>");
            answer = scanner.next();
        }
        System.out.println("Item\tQuantity\tDescription\t\tPrice\tTotal");
        System.out.println(lineItem.display());
        System.out.println(lineItem.displayTotal());
    }
}

