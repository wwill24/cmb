package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.d0 {
    private a(@NonNull FrameLayout frameLayout) {
        super(frameLayout);
    }

    @NonNull
    static a V(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(n0.k());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FrameLayout W() {
        return (FrameLayout) this.f6302a;
    }
}
