package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.h;
import androidx.annotation.NonNull;
import androidx.appcompat.view.b;
import androidx.core.view.f;
import d.a;

public class i extends h implements d {

    /* renamed from: d  reason: collision with root package name */
    private f f558d;

    /* renamed from: e  reason: collision with root package name */
    private final f.a f559e = new h(this);

    public i(@NonNull Context context, int i10) {
        super(context, f(context, i10));
        f e10 = e();
        e10.N(f(context, i10));
        e10.x((Bundle) null);
    }

    private static int f(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void F(b bVar) {
    }

    public void H(b bVar) {
    }

    public b O(b.a aVar) {
        return null;
    }

    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        e().e(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        e().y();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return f.e(this.f559e, getWindow().getDecorView(), this, keyEvent);
    }

    @NonNull
    public f e() {
        if (this.f558d == null) {
            this.f558d = f.i(this, this);
        }
        return this.f558d;
    }

    public <T extends View> T findViewById(int i10) {
        return e().j(i10);
    }

    /* access modifiers changed from: package-private */
    public boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean h(int i10) {
        return e().G(i10);
    }

    public void invalidateOptionsMenu() {
        e().t();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        e().s();
        super.onCreate(bundle);
        e().x(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        e().D();
    }

    public void setContentView(int i10) {
        e().I(i10);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().O(charSequence);
    }

    public void setContentView(@NonNull View view) {
        e().J(view);
    }

    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        e().K(view, layoutParams);
    }

    public void setTitle(int i10) {
        super.setTitle(i10);
        e().O(getContext().getString(i10));
    }
}
