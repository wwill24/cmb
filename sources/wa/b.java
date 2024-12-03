package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView f42107a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f42108b;

    private b(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f42107a = recyclerView;
        this.f42108b = recyclerView2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        if (view != null) {
            RecyclerView recyclerView = (RecyclerView) view;
            return new b(recyclerView, recyclerView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(va.b.prompt_selection, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public RecyclerView getRoot() {
        return this.f42107a;
    }
}
