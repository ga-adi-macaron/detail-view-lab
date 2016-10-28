package ly.generalassemb.drewmahrt.shoppinglistdetailview;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingItem {
    private int mId;
    private String mName, mDescription, mPrice, mType, mExpirationDate;

    public ShoppingItem(int id, String name, String description, String price, String type, String expir) {
        mId = id;
        mName = name;
        mDescription = description;
        mPrice = price;
        mType = type;
        mExpirationDate = expir;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getType() {
        return mType;
    }

    public String getExpirationDate(){
        return mExpirationDate;
    }
}
