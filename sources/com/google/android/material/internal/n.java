package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import qf.d;
import qf.f;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f19886a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final f f19887b = new a();

    /* renamed from: c  reason: collision with root package name */
    private float f19888c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19889d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<b> f19890e = new WeakReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private d f19891f;

    class a extends f {
        a() {
        }

        public void a(int i10) {
            boolean unused = n.this.f19889d = true;
            b bVar = (b) n.this.f19890e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        public void b(@NonNull Typeface typeface, boolean z10) {
            if (!z10) {
                boolean unused = n.this.f19889d = true;
                b bVar = (b) n.this.f19890e.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public n(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f19886a.measureText(charSequence, 0, charSequence.length());
    }

    public d d() {
        return this.f19891f;
    }

    @NonNull
    public TextPaint e() {
        return this.f19886a;
    }

    public float f(String str) {
        if (!this.f19889d) {
            return this.f19888c;
        }
        float c10 = c(str);
        this.f19888c = c10;
        this.f19889d = false;
        return c10;
    }

    public void g(b bVar) {
        this.f19890e = new WeakReference<>(bVar);
    }

    public void h(d dVar, Context context) {
        if (this.f19891f != dVar) {
            this.f19891f = dVar;
            if (dVar != null) {
                dVar.o(context, this.f19886a, this.f19887b);
                b bVar = this.f19890e.get();
                if (bVar != null) {
                    this.f19886a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f19886a, this.f19887b);
                this.f19889d = true;
            }
            b bVar2 = this.f19890e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z10) {
        this.f19889d = z10;
    }

    public void j(Context context) {
        this.f19891f.n(context, this.f19886a, this.f19887b);
    }
}
