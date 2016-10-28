package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShoppingItemDetailActivity extends AppCompatActivity {
    public static final String ITEM_ID = "ITEM ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_item_detail);

        int id = getIntent().getIntExtra(ITEM_ID, -1);

        if(id == -1) {
            finish();
        }

        ShoppingItem currentItem = ShoppingSQLiteOpenHelper.getInstance(getApplicationContext())
                .getShoppingList().get(id);

        if(currentItem == null) {
            finish();
        }

        TextView title = (TextView)findViewById(R.id.name);
        TextView desc = (TextView)findViewById(R.id.description);
        TextView price = (TextView)findViewById(R.id.price);
        TextView type = (TextView)findViewById(R.id.type);

        title.setText(currentItem.getName());
        desc.setText(currentItem.getDescription());
        price.setText(currentItem.getPrice());
        type.setText(currentItem.getType());
    }
}
