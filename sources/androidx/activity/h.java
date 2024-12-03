package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;
import r1.c;
import r1.d;

public class h extends Dialog implements l, n, d {

    /* renamed from: a  reason: collision with root package name */
    private n f341a;

    /* renamed from: b  reason: collision with root package name */
    private final c f342b = c.f17246d.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final OnBackPressedDispatcher f343c = new OnBackPressedDispatcher(new g(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, int i10) {
        super(context, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    private final n b() {
        n nVar = this.f341a;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.f341a = nVar2;
        return nVar2;
    }

    private final void c() {
        Window window = getWindow();
        j.d(window);
        View decorView = window.getDecorView();
        j.f(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.b(decorView, this);
        Window window2 = getWindow();
        j.d(window2);
        View decorView2 = window2.getDecorView();
        j.f(decorView2, "window!!.decorView");
        q.a(decorView2, this);
        Window window3 = getWindow();
        j.d(window3);
        View decorView3 = window3.getDecorView();
        j.f(decorView3, "window!!.decorView");
        ViewTreeSavedStateRegistryOwner.b(decorView3, this);
    }

    /* access modifiers changed from: private */
    public static final void d(h hVar) {
        j.g(hVar, "this$0");
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j.g(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public Lifecycle getLifecycle() {
        return b();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f343c;
    }

    public a getSavedStateRegistry() {
        return this.f342b.b();
    }

    public void onBackPressed() {
        this.f343c.e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f343c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            j.f(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.f(onBackInvokedDispatcher);
        }
        this.f342b.d(bundle);
        b().j(Lifecycle.Event.ON_CREATE);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        j.f(onSaveInstanceState, "super.onSaveInstanceState()");
        this.f342b.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        b().j(Lifecycle.Event.ON_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        b().j(Lifecycle.Event.ON_DESTROY);
        this.f341a = null;
        super.onStop();
    }

    public void setContentView(int i10) {
        c();
        super.setContentView(i10);
    }

    public void setContentView(View view) {
        j.g(view, "view");
        c();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j.g(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
