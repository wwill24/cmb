package com.coffeemeetsbagel.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f37584a;

    /* renamed from: b  reason: collision with root package name */
    private final CmbToolbar f37585b;

    /* renamed from: c  reason: collision with root package name */
    private List<View> f37586c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f37587d;

    /* renamed from: e  reason: collision with root package name */
    private String f37588e;

    public interface a {
        void a(b bVar);

        boolean b(b bVar);
    }

    b(a aVar, CmbToolbar cmbToolbar) {
        this.f37584a = aVar;
        this.f37585b = cmbToolbar;
    }

    public void a() {
        this.f37584a.a(this);
        this.f37585b.J();
        List<View> list = this.f37586c;
        if (list != null) {
            for (View C : list) {
                this.f37585b.C(C);
            }
        }
        String str = this.f37588e;
        if (str != null) {
            this.f37585b.setTitle(str);
        }
        Drawable drawable = this.f37587d;
        if (drawable != null) {
            this.f37585b.setLeftIcon(drawable);
        }
        this.f37585b.I();
    }

    /* access modifiers changed from: package-private */
    public void b(Drawable drawable) {
        this.f37587d = drawable;
    }

    /* access modifiers changed from: package-private */
    public void c(List<View> list) {
        this.f37586c = list;
    }

    public void d(String str) {
        if (this.f37588e == null) {
            this.f37588e = this.f37585b.getTitleText();
        }
        this.f37585b.setTitle(str);
    }
}
