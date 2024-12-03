package vi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import org.jivesoftware.smack.packet.Message;
import ti.h;
import ti.i;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f33908a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f33909b;

    private d(@NonNull View view, @NonNull ProgressBar progressBar) {
        this.f33908a = view;
        this.f33909b = progressBar;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = h.progress_bar;
        ProgressBar progressBar = (ProgressBar) b.a(view, i10);
        if (progressBar != null) {
            return new d(view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(i.pi2_ui_button_with_loading_indicator, viewGroup);
            return a(viewGroup);
        }
        throw new NullPointerException(Message.Thread.PARENT_ATTRIBUTE_NAME);
    }

    @NonNull
    public View getRoot() {
        return this.f33908a;
    }
}
