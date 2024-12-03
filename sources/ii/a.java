package ii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.document.k;
import com.withpersona.sdk2.inquiry.document.l;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f29946a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29947b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ThemeableLottieAnimationView f29948c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29949d;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull TextView textView2) {
        this.f29946a = constraintLayout;
        this.f29947b = textView;
        this.f29948c = themeableLottieAnimationView;
        this.f29949d = textView2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = k.body;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = k.loading_animation;
            ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) b.a(view, i10);
            if (themeableLottieAnimationView != null) {
                i10 = k.title;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new a((ConstraintLayout) view, textView, themeableLottieAnimationView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(l.pi2_document_loading, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f29946a;
    }
}
