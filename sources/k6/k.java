package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class k implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f15773a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbEditText f15774b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbEditText f15775c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbEditText f15776d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f15777e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f15778f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ScrollView f15779g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f15780h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f15781j;

    private k(@NonNull ScrollView scrollView, @NonNull CmbEditText cmbEditText, @NonNull CmbEditText cmbEditText2, @NonNull CmbEditText cmbEditText3, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ScrollView scrollView2, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2) {
        this.f15773a = scrollView;
        this.f15774b = cmbEditText;
        this.f15775c = cmbEditText2;
        this.f15776d = cmbEditText3;
        this.f15777e = imageView;
        this.f15778f = linearLayout;
        this.f15779g = scrollView2;
        this.f15780h = cmbTextView;
        this.f15781j = cmbTextView2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        int i10 = R.id.editText0;
        CmbEditText cmbEditText = (CmbEditText) b.a(view, R.id.editText0);
        if (cmbEditText != null) {
            i10 = R.id.editText1;
            CmbEditText cmbEditText2 = (CmbEditText) b.a(view, R.id.editText1);
            if (cmbEditText2 != null) {
                i10 = R.id.editText2;
                CmbEditText cmbEditText3 = (CmbEditText) b.a(view, R.id.editText2);
                if (cmbEditText3 != null) {
                    i10 = R.id.imageView_private;
                    ImageView imageView = (ImageView) b.a(view, R.id.imageView_private);
                    if (imageView != null) {
                        i10 = R.id.relativeLayout_container;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, R.id.relativeLayout_container);
                        if (linearLayout != null) {
                            ScrollView scrollView = (ScrollView) view;
                            i10 = R.id.textView_prompt;
                            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.textView_prompt);
                            if (cmbTextView != null) {
                                i10 = R.id.textView_title;
                                CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.textView_title);
                                if (cmbTextView2 != null) {
                                    return new k(scrollView, cmbEditText, cmbEditText2, cmbEditText3, imageView, linearLayout, scrollView, cmbTextView, cmbTextView2);
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
    public static k c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_icebreakers, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f15773a;
    }
}
