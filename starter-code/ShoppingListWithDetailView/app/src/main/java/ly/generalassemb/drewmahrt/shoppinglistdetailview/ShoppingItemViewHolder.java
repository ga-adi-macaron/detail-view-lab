package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingItemViewHolder extends RecyclerView.ViewHolder{
    public TextView mNameTextView;
    public LinearLayout mShoppingListView;

    public ShoppingItemViewHolder(View itemView) {
        super(itemView);

        mNameTextView = (TextView)itemView.findViewById(R.id.shopping_item);
        mShoppingListView = (LinearLayout) itemView.findViewById(R.id.shopping_list_item_parent);
    }
}
