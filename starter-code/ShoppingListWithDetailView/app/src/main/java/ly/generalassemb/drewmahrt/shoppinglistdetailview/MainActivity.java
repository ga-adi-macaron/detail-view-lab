package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SHOPPING_LIST_KEY = "SHOPPING_LIST";
    public static final int ADD_REQUEST = 88;
    private RecyclerView mShoppingListRecyclerView;
    private ShoppingListAdapter mAdapter;
    private List<ShoppingItem> mShoppingList;
    private Button mAddItemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
//        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
//        dbSetup.getReadableDatabase();

        //Setup the RecyclerView
        mShoppingListRecyclerView = (RecyclerView) findViewById(R.id.shopping_list_recyclerview);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(this);
        mShoppingList = db.getShoppingList();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        mShoppingListRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new ShoppingListAdapter(mShoppingList);
        mShoppingListRecyclerView.setAdapter(mAdapter);

        mAddItemButton = (Button)findViewById(R.id.add_button);
        mAddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddItemActivity.class), ADD_REQUEST);
                mShoppingListRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case ADD_REQUEST:
                if(resultCode == RESULT_OK){
                    mShoppingList = ShoppingSQLiteOpenHelper.getInstance(this).getShoppingList();
                    mAdapter.replaceData(mShoppingList);
                }
        }
    }
}
