package wh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.t;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final BalloonAnchorOverlayView f24682a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final BalloonAnchorOverlayView f24683b;

    private b(@NonNull BalloonAnchorOverlayView balloonAnchorOverlayView, @NonNull BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        this.f24682a = balloonAnchorOverlayView;
        this.f24683b = balloonAnchorOverlayView2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        if (view != null) {
            BalloonAnchorOverlayView balloonAnchorOverlayView = (BalloonAnchorOverlayView) view;
            return new b(balloonAnchorOverlayView, balloonAnchorOverlayView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(t.balloon_layout_overlay, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public BalloonAnchorOverlayView getRoot() {
        return this.f24682a;
    }
}
