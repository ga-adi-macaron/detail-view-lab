package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String ID_KEY = "id";
    TextView mNameText,mDescriptionText,mTypeText,mPriceText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int id = getIntent().getIntExtra(ID_KEY,-1);
        if (id==-1){
            finish();
        }
        ShoppingItem shoppingItem =ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemByID(id);

        if (shoppingItem == null){
            finish();
        }
        mNameText = (TextView) findViewById(R.id.name_text);
        mDescriptionText= (TextView) findViewById(R.id.description_text);
        mTypeText= (TextView) findViewById(R.id.type_text);
        mPriceText= (TextView) findViewById(R.id.price_text);

        mNameText.setText(shoppingItem.getName());
        mDescriptionText.setText(shoppingItem.getDescription());
        mTypeText.setText(shoppingItem.getType());
        mPriceText.setText("$"+shoppingItem.getPrice());
    }
}
