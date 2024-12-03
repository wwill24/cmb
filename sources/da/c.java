package da;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.likes_you.r0;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40567a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f40568b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f40569c;

    private c(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f40567a = constraintLayout;
        this.f40568b = textView;
        this.f40569c = textView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = r0.tab_counter;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = r0.tab_title;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                return new c((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40567a;
    }
}
