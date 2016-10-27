package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String ITEM_ID_KEY = "itemIDKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra(ITEM_ID_KEY, -1);

        if (id == -1) {
            finish();
        }

        ShoppingItem shoppingItem = ShoppingSQLiteOpenHelper.
                getInstance(this).getShoppingItemById(id);

        if (shoppingItem == null) {
            finish();
        }

        TextView mName = (TextView) findViewById(R.id.name);
        TextView mDesc = (TextView) findViewById(R.id.description);
        TextView mPrice = (TextView) findViewById(R.id.price);
        TextView mType = (TextView) findViewById(R.id.type);

        mName.setText(shoppingItem.getName());
        mDesc.setText(shoppingItem.getDescription());
        mPrice.setText(shoppingItem.getPrice());
        mType.setText(shoppingItem.getType());
    }
}
