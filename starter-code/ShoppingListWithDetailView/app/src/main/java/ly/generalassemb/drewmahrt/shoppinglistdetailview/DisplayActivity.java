package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {
    public static final String ITEM_ID_KEY = "item_id_key";
    TextView nameView, descView, priceView, typeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        nameView = (TextView)findViewById(R.id.name_view);
        descView =(TextView)findViewById(R.id.descript_view);
        priceView = (TextView)findViewById(R.id.price_view);
        typeView = (TextView)findViewById(R.id.type_view);


        int idKey = getIntent().getIntExtra(ITEM_ID_KEY, -1);

        if (idKey == -1){
            finish();
        }

        nameView.setText(ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemById(idKey).getName());
        descView.setText(ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemById(idKey).getDescription());
        priceView.setText(ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemById(idKey).getPrice());
        typeView.setText(ShoppingSQLiteOpenHelper.getInstance(this).getShoppingItemById(idKey).getType());
    }
}
