package wh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.s;
import com.skydoves.balloon.t;
import com.skydoves.balloon.vectortext.VectorTextView;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f24675a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f24676b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f24677c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RadiusLayout f24678d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f24679e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final VectorTextView f24680f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f24681g;

    private a(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull RadiusLayout radiusLayout, @NonNull FrameLayout frameLayout3, @NonNull VectorTextView vectorTextView, @NonNull FrameLayout frameLayout4) {
        this.f24675a = frameLayout;
        this.f24676b = frameLayout2;
        this.f24677c = imageView;
        this.f24678d = radiusLayout;
        this.f24679e = frameLayout3;
        this.f24680f = vectorTextView;
        this.f24681g = frameLayout4;
    }

    @NonNull
    public static a a(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = s.balloon_arrow;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = s.balloon_card;
            RadiusLayout radiusLayout = (RadiusLayout) b.a(view, i10);
            if (radiusLayout != null) {
                i10 = s.balloon_content;
                FrameLayout frameLayout2 = (FrameLayout) b.a(view, i10);
                if (frameLayout2 != null) {
                    i10 = s.balloon_text;
                    VectorTextView vectorTextView = (VectorTextView) b.a(view, i10);
                    if (vectorTextView != null) {
                        i10 = s.balloon_wrapper;
                        FrameLayout frameLayout3 = (FrameLayout) b.a(view, i10);
                        if (frameLayout3 != null) {
                            return new a(frameLayout, frameLayout, imageView, radiusLayout, frameLayout2, vectorTextView, frameLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(t.balloon_layout_body, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f24675a;
    }
}
