package ii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.withpersona.sdk2.inquiry.document.k;
import com.withpersona.sdk2.inquiry.document.l;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f29953a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29954b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f29955c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29956d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Guideline f29957e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Pi2NavigationBar f29958f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f29959g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Guideline f29960h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final Button f29961j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f29962k;

    private c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull TextView textView2, @NonNull Guideline guideline2, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull RecyclerView recyclerView, @NonNull Guideline guideline3, @NonNull Button button, @NonNull TextView textView3) {
        this.f29953a = coordinatorLayout;
        this.f29954b = textView;
        this.f29955c = guideline;
        this.f29956d = textView2;
        this.f29957e = guideline2;
        this.f29958f = pi2NavigationBar;
        this.f29959g = recyclerView;
        this.f29960h = guideline3;
        this.f29961j = button;
        this.f29962k = textView3;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = k.body;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = k.bottom_guideline;
            Guideline guideline = (Guideline) b.a(view, i10);
            if (guideline != null) {
                i10 = k.disclaimer;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = k.left_guideline;
                    Guideline guideline2 = (Guideline) b.a(view, i10);
                    if (guideline2 != null) {
                        i10 = k.navigation_bar;
                        Pi2NavigationBar pi2NavigationBar = (Pi2NavigationBar) b.a(view, i10);
                        if (pi2NavigationBar != null) {
                            i10 = k.review_item_list;
                            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                            if (recyclerView != null) {
                                i10 = k.right_guideline;
                                Guideline guideline3 = (Guideline) b.a(view, i10);
                                if (guideline3 != null) {
                                    i10 = k.submit_button;
                                    Button button = (Button) b.a(view, i10);
                                    if (button != null) {
                                        i10 = k.title;
                                        TextView textView3 = (TextView) b.a(view, i10);
                                        if (textView3 != null) {
                                            return new c((CoordinatorLayout) view, textView, guideline, textView2, guideline2, pi2NavigationBar, recyclerView, guideline3, button, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(l.pi2_document_review, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f29953a;
    }
}
