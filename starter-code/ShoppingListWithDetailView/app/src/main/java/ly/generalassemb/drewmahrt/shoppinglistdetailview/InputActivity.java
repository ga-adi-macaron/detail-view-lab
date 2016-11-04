package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        final Intent intent = getIntent();

        final EditText nameEdit, descriptionEdit, typeEdit, priceEdit, isleEdit;
        Button addButton;

        nameEdit = (EditText) findViewById(R.id.name_edit);
        descriptionEdit= (EditText) findViewById(R.id.description_edit);
        typeEdit= (EditText) findViewById(R.id.type_edit);
        priceEdit = (EditText) findViewById(R.id.price_edit);
        isleEdit = (EditText) findViewById(R.id.isle_edit);
        addButton = (Button) findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long id = ShoppingSQLiteOpenHelper.getInstance(view.getContext())
                        .addItem(nameEdit.getText().toString(),
                                descriptionEdit.getText().toString(),
                                priceEdit.getText().toString(),
                                typeEdit.getText().toString(),
                                isleEdit.getText().toString());
                intent.putExtra("id",id);
                intent.putExtra("name",nameEdit.getText().toString());
                intent.putExtra("description",descriptionEdit.getText().toString());
                intent.putExtra("price",priceEdit.getText().toString());
                intent.putExtra("type",typeEdit.getText().toString());
                intent.putExtra("isle", isleEdit.getText().toString());

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
