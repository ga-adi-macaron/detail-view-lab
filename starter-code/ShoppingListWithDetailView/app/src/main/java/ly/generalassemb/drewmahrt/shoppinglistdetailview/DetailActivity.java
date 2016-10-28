package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_KEY = "intentKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra(INTENT_KEY, -1);

        if (id == -1){
            finish();
        }

        ShoppingItem shoppingItem = ShoppingSQLiteOpenHelper.getInstance(this)
                .getShoppingItemById(id);

        if (shoppingItem == null){
            finish();
        }

        TextView nameView = (TextView) findViewById(R.id.text_name);
        TextView descriptionView = (TextView) findViewById(R.id.text_description);
        TextView priceView = (TextView) findViewById(R.id.text_price);
        TextView typeView = (TextView) findViewById(R.id.text_type);

        nameView.setText(shoppingItem.getName());
        descriptionView.setText(shoppingItem.getDescription());
        priceView.setText(shoppingItem.getPrice());
        typeView.setText(shoppingItem.getType());
    }
}
