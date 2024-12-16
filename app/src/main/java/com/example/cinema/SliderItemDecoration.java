package com.example.cinema;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SliderItemDecoration extends RecyclerView.ItemDecoration {

    private final int firstItemMargin;
    private final int itemSpacing;

    public SliderItemDecoration(Context context) {
        Resources resources = context.getResources();
        this.firstItemMargin = resources.getDimensionPixelSize(R.dimen.slider_first_item_margin);
        this.itemSpacing = resources.getDimensionPixelSize(R.dimen.slider_item_spacing);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);


        if (position == 0) {
            outRect.left = firstItemMargin;
            outRect.right = itemSpacing;
        } else {
            outRect.left = itemSpacing;
            outRect.right = itemSpacing;
        }
    }
}
