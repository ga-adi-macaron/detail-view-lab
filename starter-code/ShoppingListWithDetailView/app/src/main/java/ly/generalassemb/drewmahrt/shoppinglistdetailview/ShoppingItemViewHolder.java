package ly.generalassemb.drewmahrt.shoppinglistdetailview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by drewmahrt on 10/21/16.
 */

public class ShoppingItemViewHolder extends RecyclerView.ViewHolder{
    public TextView mNameTextView;

    public ShoppingItemViewHolder(View itemView) {
        super(itemView);

        mNameTextView = (TextView)itemView.findViewById(android.R.id.text1);
    }
}
