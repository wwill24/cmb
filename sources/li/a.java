package li;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.internal.o;
import com.withpersona.sdk2.inquiry.internal.p;
import org.jivesoftware.smack.packet.Message;
import z1.b;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f32750a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final View f32751b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f32752c;

    private a(@NonNull View view, @NonNull View view2, @NonNull FrameLayout frameLayout) {
        this.f32750a = view;
        this.f32751b = view2;
        this.f32752c = frameLayout;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i10 = o.overlay;
        View a10 = b.a(view, i10);
        if (a10 != null) {
            i10 = o.view_container;
            FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
            if (frameLayout != null) {
                return new a(view, a10, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static a b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(p.pi2_disableable_container, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException(Message.Thread.PARENT_ATTRIBUTE_NAME);
    }

    @NonNull
    public View getRoot() {
        return this.f32750a;
    }
}
