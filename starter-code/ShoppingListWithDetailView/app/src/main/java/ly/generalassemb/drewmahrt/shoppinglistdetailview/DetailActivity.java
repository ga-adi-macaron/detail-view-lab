package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_ID = "id";

    TextView mName, mDescription, mType, mPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra(ITEM_ID, -1);

        if (id == -1) {
            finish();
        }
        ShoppingItem item = ShoppingSQLiteOpenHelper.getInstance(this).getItemById(id);

        if (item == null) {
            finish();
        }

        mName = (TextView)findViewById(R.id.detailName);
        mDescription = (TextView)findViewById(R.id.detailDescription);
        mPrice = (TextView)findViewById(R.id.detailPrice);
        mType = (TextView)findViewById(R.id.detailType);

        mName.setText(item.getName());
        mDescription.setText(item.getDescription());
        mPrice.setText(item.getPrice());
        mType.setText(item.getType());

    }

}

