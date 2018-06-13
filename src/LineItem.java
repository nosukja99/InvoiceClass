import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LineItem {

    DecimalFormat df2 = new DecimalFormat(".00");
    HashMap<String, ArrayList> items = new HashMap<>();
    HashMap<String, Integer> orderedItemName = new HashMap<>();
    double totalEachItem;
    double subTotalTaxable;
    double subTotalUntaxable;
    double tax;
    double grandTotal;
    int qty;

    public LineItem()
    {
        Item item = new Item();
        items = item.getItemlist();
        //System.out.println("%%%%%%%%"+items);
    }

    public HashMap addItems(String name, int qty)
    {
        orderedItemName.put(name, qty);
        //System.out.println("########"+orderedItemName);
        return orderedItemName;
    }

    public double getEachPrice(String name, int qty)
    {
        totalEachItem = Double.parseDouble(items.get(name).get(1).toString())* qty;
        //System.out.println("Each price: **"+totalEachItem);
        return totalEachItem;
    }

    public boolean taxable(String name)
    {
        return Boolean.valueOf(items.get(name).get(2).toString());
    }

    public double subTotalTaxable(HashMap orderedItemName)
    {
        //System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        Iterator it = orderedItemName.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            //System.out.println("!!!!!!!!!!!!!!");
            qty = (int) orderedItemName.get(pair.getKey());
            //System.out.println("!!!!!!!!!!!!!!"+taxable(pair.getKey().toString()));
           if (taxable(pair.getKey().toString())) {
               subTotalTaxable = subTotalTaxable + getEachPrice((String) pair.getKey(), qty);
           }
        }
        return subTotalTaxable;
    }


    public double subTotalUntaxable(HashMap orderedItemName)
    {
        Iterator it = orderedItemName.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            qty = (int) orderedItemName.get(pair.getKey());
            if (taxable(pair.getKey().toString())==false) {
                subTotalUntaxable = subTotalUntaxable + getEachPrice((String) pair.getKey(), qty);
            }
        }
        return subTotalUntaxable;
    }

    public double caculateTax(double subTotalTaxable)
    {
        tax =subTotalTaxable*0.06;
        return tax;
    }

    public double calculateGrandTotal(double subTotalTaxable, double subTotalUntaxable)
    {
        grandTotal =  tax+ subTotalTaxable+subTotalUntaxable;
        return grandTotal;
    }

    public String display() {
        Iterator it = orderedItemName.entrySet().iterator();
        String display = "";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            display =display+"\n"+items.get(pair.getKey()).get(0) + "\t" + orderedItemName.get(pair.getKey()).toString()
                    + "\t\t\t" + pair.getKey() + "\t\t" + items.get(pair.getKey()).get(1)
                    + "\t" + getEachPrice(pair.getKey().toString(),orderedItemName.get(pair.getKey()))+"\n";
        }

        return display;
    }

    public String displayTotal()
    {
        return "Taxable subtotal: $"+df2.format(subTotalTaxable(orderedItemName))+"\nUntaxable subtotal: $"+df2.format(subTotalUntaxable(orderedItemName))
                +"\nTax: $"+df2.format(caculateTax(subTotalTaxable))+"\nGrand Total: $"+df2.format(calculateGrandTotal(subTotalTaxable, subTotalUntaxable));
    }


}
