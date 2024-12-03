package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertController;

public class b extends i {

    /* renamed from: f  reason: collision with root package name */
    final AlertController f539f = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.b f540a;

        /* renamed from: b  reason: collision with root package name */
        private final int f541b;

        public a(@NonNull Context context) {
            this(context, b.k(context, 0));
        }

        @NonNull
        public b a() {
            b bVar = new b(this.f540a.f421a, this.f541b);
            this.f540a.a(bVar.f539f);
            bVar.setCancelable(this.f540a.f438r);
            if (this.f540a.f438r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f540a.f439s);
            bVar.setOnDismissListener(this.f540a.f440t);
            DialogInterface.OnKeyListener onKeyListener = this.f540a.f441u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        @NonNull
        public Context b() {
            return this.f540a.f421a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f540a;
            bVar.f443w = listAdapter;
            bVar.f444x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f540a.f427g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f540a.f424d = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.f540a.f428h = charSequence;
            return this;
        }

        public a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f540a;
            bVar.f432l = charSequence;
            bVar.f434n = onClickListener;
            return this;
        }

        public a h(DialogInterface.OnKeyListener onKeyListener) {
            this.f540a.f441u = onKeyListener;
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f540a;
            bVar.f429i = charSequence;
            bVar.f431k = onClickListener;
            return this;
        }

        public a j(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f540a;
            bVar.f443w = listAdapter;
            bVar.f444x = onClickListener;
            bVar.I = i10;
            bVar.H = true;
            return this;
        }

        public a k(CharSequence charSequence) {
            this.f540a.f426f = charSequence;
            return this;
        }

        public a(@NonNull Context context, int i10) {
            this.f540a = new AlertController.b(new ContextThemeWrapper(context, b.k(context, i10)));
            this.f541b = i10;
        }
    }

    protected b(@NonNull Context context, int i10) {
        super(context, k(context, i10));
    }

    static int k(@NonNull Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button i(int i10) {
        return this.f539f.c(i10);
    }

    public ListView j() {
        return this.f539f.e();
    }

    public void l(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f539f.k(i10, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void m(CharSequence charSequence) {
        this.f539f.o(charSequence);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f539f.f();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f539f.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f539f.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f539f.q(charSequence);
    }
}
