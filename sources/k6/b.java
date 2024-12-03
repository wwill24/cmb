package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15695a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbImageView f15696b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15697c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15698d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15699e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f15700f;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull CmbImageView cmbImageView, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4) {
        this.f15695a = constraintLayout;
        this.f15696b = cmbImageView;
        this.f15697c = cmbTextView;
        this.f15698d = cmbTextView2;
        this.f15699e = cmbTextView3;
        this.f15700f = cmbTextView4;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = R.id.bannedImage;
        CmbImageView cmbImageView = (CmbImageView) z1.b.a(view, R.id.bannedImage);
        if (cmbImageView != null) {
            i10 = R.id.bannedMessage;
            CmbTextView cmbTextView = (CmbTextView) z1.b.a(view, R.id.bannedMessage);
            if (cmbTextView != null) {
                i10 = R.id.banned_primary_button;
                CmbTextView cmbTextView2 = (CmbTextView) z1.b.a(view, R.id.banned_primary_button);
                if (cmbTextView2 != null) {
                    i10 = R.id.banned_secondary_button;
                    CmbTextView cmbTextView3 = (CmbTextView) z1.b.a(view, R.id.banned_secondary_button);
                    if (cmbTextView3 != null) {
                        i10 = R.id.bannedTitle;
                        CmbTextView cmbTextView4 = (CmbTextView) z1.b.a(view, R.id.bannedTitle);
                        if (cmbTextView4 != null) {
                            return new b((ConstraintLayout) view, cmbImageView, cmbTextView, cmbTextView2, cmbTextView3, cmbTextView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_banned, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15695a;
    }
}
