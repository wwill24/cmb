package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class b0 implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15701a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f15702b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15703c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f15704d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15705e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f15706f;

    private b0(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView2, @NonNull Guideline guideline) {
        this.f15701a = constraintLayout;
        this.f15702b = cmbButton;
        this.f15703c = cmbTextView;
        this.f15704d = imageView;
        this.f15705e = cmbTextView2;
        this.f15706f = guideline;
    }

    @NonNull
    public static b0 a(@NonNull View view) {
        int i10 = R.id.action_button;
        CmbButton cmbButton = (CmbButton) b.a(view, R.id.action_button);
        if (cmbButton != null) {
            i10 = R.id.action_header;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.action_header);
            if (cmbTextView != null) {
                i10 = R.id.action_image;
                ImageView imageView = (ImageView) b.a(view, R.id.action_image);
                if (imageView != null) {
                    i10 = R.id.action_message;
                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.action_message);
                    if (cmbTextView2 != null) {
                        i10 = R.id.center_image_and_text_guideline;
                        Guideline guideline = (Guideline) b.a(view, R.id.center_image_and_text_guideline);
                        if (guideline != null) {
                            return new b0((ConstraintLayout) view, cmbButton, cmbTextView, imageView, cmbTextView2, guideline);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b0 c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.no_likes, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15701a;
    }
}
