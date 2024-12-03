package x1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private Context f18419a;

    /* renamed from: b  reason: collision with root package name */
    private int f18420b = -1;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f18421c;

    /* renamed from: d  reason: collision with root package name */
    private View f18422d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f18423e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f18424f;

    public k(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.f18421c = viewGroup;
        this.f18422d = view;
    }

    public static k c(@NonNull ViewGroup viewGroup) {
        return (k) viewGroup.getTag(i.transition_current_scene);
    }

    static void f(@NonNull ViewGroup viewGroup, k kVar) {
        viewGroup.setTag(i.transition_current_scene, kVar);
    }

    public void a() {
        if (this.f18420b > 0 || this.f18422d != null) {
            d().removeAllViews();
            if (this.f18420b > 0) {
                LayoutInflater.from(this.f18419a).inflate(this.f18420b, this.f18421c);
            } else {
                this.f18421c.addView(this.f18422d);
            }
        }
        Runnable runnable = this.f18423e;
        if (runnable != null) {
            runnable.run();
        }
        f(this.f18421c, this);
    }

    public void b() {
        Runnable runnable;
        if (c(this.f18421c) == this && (runnable = this.f18424f) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup d() {
        return this.f18421c;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f18420b > 0;
    }
}
