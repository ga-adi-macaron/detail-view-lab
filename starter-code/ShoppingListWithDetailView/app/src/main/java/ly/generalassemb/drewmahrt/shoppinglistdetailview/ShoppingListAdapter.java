package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingItemViewHolder> {
    private List<ShoppingItem> mShoppingItems;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems) {
        mShoppingItems = shoppingItems;
    }

    @Override
    public ShoppingItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShoppingItemViewHolder holder, int position) {
        final ShoppingItem currentItem = mShoppingItems.get(holder.getAdapterPosition());

        holder.mNameTextView.setText(currentItem.getName());

        holder.mShoppingListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ShoppingItemDetailActivity.class);
                intent.putExtra(ShoppingItemDetailActivity.ITEM_ID, currentItem.getId()-1);
                holder.mShoppingListView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
