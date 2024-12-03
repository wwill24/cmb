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
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15669a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbButton f15670b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15671c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f15672d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15673e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f15674f;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView2, @NonNull Guideline guideline) {
        this.f15669a = constraintLayout;
        this.f15670b = cmbButton;
        this.f15671c = cmbTextView;
        this.f15672d = imageView;
        this.f15673e = cmbTextView2;
        this.f15674f = guideline;
    }

    @NonNull
    public static a a(@NonNull View view) {
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
                            return new a((ConstraintLayout) view, cmbButton, cmbTextView, imageView, cmbTextView2, guideline);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.action_card, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15669a;
    }
}
