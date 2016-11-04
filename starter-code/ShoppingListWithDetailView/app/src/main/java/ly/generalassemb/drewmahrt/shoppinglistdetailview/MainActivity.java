package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistdetailview.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 12;
    ShoppingListAdapter mAdapter;
    ShoppingSQLiteOpenHelper db;
    List<ShoppingItem> shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        //Setup the RecyclerView
        RecyclerView shoppingListRecyclerView = (RecyclerView) findViewById(R.id.shopping_list_recyclerview);

        db = ShoppingSQLiteOpenHelper.getInstance(this);
        shoppingList = db.getShoppingList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        shoppingListRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new ShoppingListAdapter(shoppingList);
        shoppingListRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){

                long id = data.getLongExtra("id", -1);

                shoppingList.add(new ShoppingItem(
                        (int)id,
                        data.getStringExtra("name"),
                        data.getStringExtra("description"),
                        data.getStringExtra("price"),
                        data.getStringExtra("type"),
                        data.getStringExtra("isle")
                ));
                mAdapter.notifyItemInserted(ShoppingSQLiteOpenHelper.getInstance(this).getShoppingList().size()-1);
            }
        }
    }
}
