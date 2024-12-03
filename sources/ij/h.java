package ij;

import am.r;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import bm.d;
import ij.e;
import java.util.List;

class h extends e {

    /* renamed from: a  reason: collision with root package name */
    private final TextView.BufferType f29989a;

    /* renamed from: b  reason: collision with root package name */
    private final d f29990b;

    /* renamed from: c  reason: collision with root package name */
    private final m f29991c;

    /* renamed from: d  reason: collision with root package name */
    private final g f29992d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<i> f29993e;

    /* renamed from: f  reason: collision with root package name */
    private final e.b f29994f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f29995g;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f29996a;

        a(TextView textView) {
            this.f29996a = textView;
        }

        public void run() {
            for (i b10 : h.this.f29993e) {
                b10.b(this.f29996a);
            }
        }
    }

    h(@NonNull TextView.BufferType bufferType, e.b bVar, @NonNull d dVar, @NonNull m mVar, @NonNull g gVar, @NonNull List<i> list, boolean z10) {
        this.f29989a = bufferType;
        this.f29994f = bVar;
        this.f29990b = dVar;
        this.f29991c = mVar;
        this.f29992d = gVar;
        this.f29993e = list;
        this.f29995g = z10;
    }

    public void c(@NonNull TextView textView, @NonNull String str) {
        d(textView, e(str));
    }

    public void d(@NonNull TextView textView, @NonNull Spanned spanned) {
        for (i k10 : this.f29993e) {
            k10.k(textView, spanned);
        }
        e.b bVar = this.f29994f;
        if (bVar != null) {
            bVar.a(textView, spanned, this.f29989a, new a(textView));
            return;
        }
        textView.setText(spanned, this.f29989a);
        for (i b10 : this.f29993e) {
            b10.b(textView);
        }
    }

    @NonNull
    public Spanned e(@NonNull String str) {
        Spanned h10 = h(g(str));
        if (!TextUtils.isEmpty(h10) || !this.f29995g || TextUtils.isEmpty(str)) {
            return h10;
        }
        return new SpannableStringBuilder(str);
    }

    @NonNull
    public r g(@NonNull String str) {
        for (i d10 : this.f29993e) {
            str = d10.d(str);
        }
        return this.f29990b.b(str);
    }

    @NonNull
    public Spanned h(@NonNull r rVar) {
        for (i e10 : this.f29993e) {
            e10.e(rVar);
        }
        l a10 = this.f29991c.a();
        rVar.a(a10);
        for (i h10 : this.f29993e) {
            h10.h(rVar, a10);
        }
        return a10.builder().l();
    }
}
