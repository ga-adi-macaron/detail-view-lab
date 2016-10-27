package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    List<ShoppingItem> mShoppingItems;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems) {
        mShoppingItems = shoppingItems;
    }

    @Override
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShoppingItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(final ShoppingItemViewHolder holder, int position) {
        holder.mNameTextView.setText(mShoppingItems.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingItem shoppingItem = mShoppingItems.get(holder.getAdapterPosition());

                Intent myIntent = new Intent(view.getContext(), DisplayActivity.class);
                myIntent.putExtra(DisplayActivity.ITEM_ID_KEY, shoppingItem.getId());
                view.getContext().startActivity(myIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
