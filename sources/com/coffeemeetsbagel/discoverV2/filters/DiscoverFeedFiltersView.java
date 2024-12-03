package com.coffeemeetsbagel.discoverV2.filters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import q5.a;

public class DiscoverFeedFiltersView extends a {
    ImageView G;
    CmbTextView H;

    public DiscoverFeedFiltersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void C() {
        this.H = (CmbTextView) findViewById(R.id.flower_count);
        ImageView imageView = (ImageView) findViewById(R.id.flower);
        this.G = imageView;
        imageView.setVisibility(8);
        this.H.setVisibility(8);
    }

    public void D() {
        ((ImageView) findViewById(R.id.discover_search_icon)).setImageResource(R.drawable.ic_check_circle);
    }

    public void E() {
        ((ImageView) findViewById(R.id.discover_search_icon)).setImageResource(R.drawable.discover_search_icon);
    }

    public void F(int i10) {
        this.H = (CmbTextView) findViewById(R.id.flower_count);
        ImageView imageView = (ImageView) findViewById(R.id.flower);
        this.G = imageView;
        imageView.setVisibility(0);
        this.H.setVisibility(0);
        this.H.setText(String.valueOf(i10));
    }
}
