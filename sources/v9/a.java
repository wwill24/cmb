package v9;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public class a extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private ImageView f18154u;

    /* renamed from: v  reason: collision with root package name */
    private CmbTextView f18155v;

    public a(View view) {
        super(view);
        this.f18154u = (ImageView) view.findViewById(R.id.share_dialog_item_icon);
        this.f18155v = (CmbTextView) view.findViewById(R.id.share_dialog_item_label);
    }

    public CmbTextView V() {
        return this.f18155v;
    }

    public ImageView W() {
        return this.f18154u;
    }
}
