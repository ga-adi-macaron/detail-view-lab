package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    public static final String IDKEY = "IDKEY";
    public TextView mText1, mText2, mText3, mText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mText1 = (TextView) findViewById(R.id.text1);
        mText2 = (TextView) findViewById(R.id.text2);
        mText3 = (TextView) findViewById(R.id.text3);
        mText4 = (TextView) findViewById(R.id.text4);

        int id = getIntent().getIntExtra(IDKEY,-1);
        if(id == -1){finish();}

        ShoppingItem item = ShoppingSQLiteOpenHelper
                .getInstance(this)
                .getItemId(id);

        if(item == null){finish();}

        mText1.setText(item.getName());
        mText2.setText(item.getDescription());
        mText3.setText(item.getPrice());
        mText4.setText(item.getType());





    }
}
