package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.core.view.e2;

public interface j0 {
    boolean a();

    boolean b();

    boolean c();

    void collapseActionView();

    void d(Menu menu, m.a aVar);

    boolean e();

    void f();

    boolean g();

    Context getContext();

    CharSequence getTitle();

    boolean h();

    void i(int i10);

    Menu j();

    int k();

    e2 l(int i10, long j10);

    ViewGroup m();

    void n(boolean z10);

    void o();

    void p(boolean z10);

    void q();

    void r(z0 z0Var);

    void s(Drawable drawable);

    void setIcon(int i10);

    void setIcon(Drawable drawable);

    void setTitle(CharSequence charSequence);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i10);

    void u(m.a aVar, g.a aVar2);

    void v(int i10);

    int w();

    void x(View view);

    void y();
}
