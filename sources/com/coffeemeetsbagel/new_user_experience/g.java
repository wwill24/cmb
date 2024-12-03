package com.coffeemeetsbagel.new_user_experience;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import kotlin.jvm.internal.j;
import x1.m;
import x1.p;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f34977a;

    /* renamed from: b  reason: collision with root package name */
    private final m f34978b = new m(48);

    /* renamed from: c  reason: collision with root package name */
    private final ViewGroup f34979c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34980d;

    public g(ViewGroup viewGroup) {
        j.g(viewGroup, "rootViewGroup");
        this.f34977a = viewGroup;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onboarding_error_sheet, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f34979c = (ViewGroup) inflate;
    }

    public final void a() {
        ((TextView) this.f34979c.findViewById(R.id.error_message)).setText((CharSequence) null);
        if (this.f34980d) {
            p.a(this.f34977a, this.f34978b);
            this.f34977a.removeView(this.f34979c);
            this.f34980d = false;
        }
    }

    public final void b(String str) {
        ((TextView) this.f34979c.findViewById(R.id.error_message)).setText(str);
        if (!this.f34980d) {
            p.a(this.f34977a, this.f34978b);
            try {
                this.f34977a.addView(this.f34979c);
            } catch (IllegalStateException unused) {
            }
        }
        this.f34980d = true;
    }
}
