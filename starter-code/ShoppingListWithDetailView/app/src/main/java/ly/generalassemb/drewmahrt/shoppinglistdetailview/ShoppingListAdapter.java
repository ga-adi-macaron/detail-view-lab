package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
    public void onBindViewHolder(ShoppingItemViewHolder holder, int position) {
        holder.mNameTextView.setText(mShoppingItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
