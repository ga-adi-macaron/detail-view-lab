package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText mEditName;
    private EditText mEditDescription;
    private EditText mEditPrice;
    private EditText mEditType;
    private EditText mEditExpirationDate;
    private Button mSubmitButton;
    public static final String ITEM_DATA = "item_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mEditName = (EditText)findViewById(R.id.new_item_name);
        mEditDescription = (EditText)findViewById(R.id.new_item_description);
        mEditPrice = (EditText)findViewById(R.id.new_item_price);
        mEditType = (EditText)findViewById(R.id.new_item_type);
        mEditExpirationDate = (EditText)findViewById(R.id.new_expiration_date);
        mSubmitButton = (Button)findViewById(R.id.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEditName.getText().toString();
                String description = mEditDescription.getText().toString();
                String price = mEditPrice.getText().toString();
                String type = mEditType.getText().toString();
                String expir = mEditExpirationDate.getText().toString();

                ShoppingSQLiteOpenHelper.getInstance(view.getContext()).addItem(
                        name,
                        description,
                        price,
                        type,
                        expir);


                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
