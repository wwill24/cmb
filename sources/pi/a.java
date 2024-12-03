package pi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.withpersona.sdk2.inquiry.permissions.d;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f33755a;

    private a(@NonNull View view) {
        this.f33755a = view;
    }

    @NonNull
    public static a a(@NonNull View view) {
        if (view != null) {
            return new a(view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static a b(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(d.pi2_check_request_permission_rationale_state, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    public View getRoot() {
        return this.f33755a;
    }
}
