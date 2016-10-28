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

        // onClickListener
        holder.mNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.INTENT_KEY,
                        mShoppingItems.get(holder.getAdapterPosition()).getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mShoppingItems.size();
    }
}
