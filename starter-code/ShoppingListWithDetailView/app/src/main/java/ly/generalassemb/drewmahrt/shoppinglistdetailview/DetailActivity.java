package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String ID_KEY = "idKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra(ID_KEY,-1);

        if (id == -1) {
            finish();
        }

        ShoppingItem detailItem
                = ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemById(id);

        if (detailItem == null) {
            finish();
        }

        TextView nameView = (TextView) findViewById(R.id.name);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        TextView priceView = (TextView) findViewById(R.id.price);
        TextView typeView = (TextView) findViewById(R.id.type);

        nameView.setText(detailItem.getName());
        descriptionView.setText(detailItem.getDescription());
        priceView.setText(detailItem.getPrice());
        typeView.setText(detailItem.getType());
    }
}
