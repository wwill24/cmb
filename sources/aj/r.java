package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class r implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24882a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f24883b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f24884c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24885d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final MaterialCardView f24886e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f24887f;

    private r(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView, @NonNull ImageView imageView2) {
        this.f24882a = constraintLayout;
        this.f24883b = textView;
        this.f24884c = imageView;
        this.f24885d = textView2;
        this.f24886e = materialCardView;
        this.f24887f = imageView2;
    }

    @NonNull
    public static r a(@NonNull View view) {
        int i10 = g.add_signature_label;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = g.edit_signature_icon;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = g.error_label;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = g.signature_container;
                    MaterialCardView materialCardView = (MaterialCardView) b.a(view, i10);
                    if (materialCardView != null) {
                        i10 = g.signature_preview;
                        ImageView imageView2 = (ImageView) b.a(view, i10);
                        if (imageView2 != null) {
                            return new r((ConstraintLayout) view, textView, imageView, textView2, materialCardView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static r c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_signature_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24882a;
    }
}
