package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String ITEM_ID_KEY = "id";
    private TextView mNameView;
    private TextView mDescriptionView;
    private TextView mPriceView;
    private TextView mTypeView;
    private TextView mExpirView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int itemID = getIntent().getIntExtra(ITEM_ID_KEY, -1);
        if(itemID==-1){finish();}

        ShoppingItem item = ShoppingSQLiteOpenHelper.getInstance(this).getItemById(itemID);
        if(item==null){finish();}

        mNameView = (TextView)findViewById(R.id.item_name);
        mDescriptionView = (TextView)findViewById(R.id.item_description);
        mPriceView = (TextView)findViewById(R.id.item_price);
        mTypeView = (TextView)findViewById(R.id.item_type);
        mExpirView = (TextView)findViewById(R.id.expiration_date);

        mNameView.setText(item.getName());
        mDescriptionView.setText(item.getDescription());
        mPriceView.setText(item.getPrice());
        mTypeView.setText(item.getType());
        mExpirView.setText(item.getExpirationDate());


    }
}
