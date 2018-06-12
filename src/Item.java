import com.sun.xml.internal.ws.api.message.Attachment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Item {

    public ArrayList<String> firstItem;
    public ArrayList<String> secondItem;
    public ArrayList<String> thirdItem;
    public HashMap<String, ArrayList> items = new HashMap<>();


    String itemNum;
    String itemDescription;
    double price;
    double eachPrice;
    boolean taxable;

    /*
    constructor will make arrayList with arrayList
     */
    public Item()
    {
        firstItem = new ArrayList<String>();
        firstItem.add("J001");
        firstItem.add("45.00");
        firstItem.add("true");
        ///System.out.println(firstItem);

        secondItem = new ArrayList<String>();
        secondItem.add("C001");
        secondItem.add("50.00");
        secondItem.add("true");
        //System.out.println(secondItem);

        thirdItem = new ArrayList<String>();
        thirdItem.add("P001");
        thirdItem.add("35.00");
        thirdItem.add("false");
        //System.out.println(thirdItem);

        items.put("java book", firstItem);
        items.put("cobol book", secondItem);
        items.put("python book", thirdItem);

    }
    /*
    will return hashmap of items/ key is the name and value
    inner arrayList will contain imformation on the each item
     */
    public HashMap<String, ArrayList> getItemlist()
    {
        return items;
    }

    public String getItemNum(String productName)
    {
        return items.get(productName).get(0).toString();
    }


    public double getPrice(String productName)
    {
        return (double) items.get(productName).get(1);
    }

    public boolean getTaxable(String productName)
    {
        return (boolean) items.get(productName).get(2);
    }

}
