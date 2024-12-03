package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import org.jivesoftware.smack.packet.Message;
import ti.h;
import ti.i;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f33905a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33906b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f33907c;

    private c(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f33905a = view;
        this.f33906b = imageView;
        this.f33907c = imageView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = h.back_button;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.cancel_button;
            ImageView imageView2 = (ImageView) b.a(view, i10);
            if (imageView2 != null) {
                return new c(view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(i.pi2_navigation_bar, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException(Message.Thread.PARENT_ATTRIBUTE_NAME);
    }

    @NonNull
    public View getRoot() {
        return this.f33905a;
    }
}
