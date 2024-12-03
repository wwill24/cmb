package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import f1.b;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class m {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final b f5489a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final char[] f5490b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final a f5491c = new a(1024);
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f5492d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<a> f5493a;

        /* renamed from: b  reason: collision with root package name */
        private g f5494b;

        private a() {
            this(1);
        }

        /* access modifiers changed from: package-private */
        public a a(int i10) {
            SparseArray<a> sparseArray = this.f5493a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i10);
        }

        /* access modifiers changed from: package-private */
        public final g b() {
            return this.f5494b;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull g gVar, int i10, int i11) {
            a a10 = a(gVar.b(i10));
            if (a10 == null) {
                a10 = new a();
                this.f5493a.put(gVar.b(i10), a10);
            }
            if (i11 > i10) {
                a10.c(gVar, i10 + 1, i11);
            } else {
                a10.f5494b = gVar;
            }
        }

        a(int i10) {
            this.f5493a = new SparseArray<>(i10);
        }
    }

    private m(@NonNull Typeface typeface, @NonNull b bVar) {
        this.f5492d = typeface;
        this.f5489a = bVar;
        this.f5490b = new char[(bVar.k() * 2)];
        a(bVar);
    }

    private void a(b bVar) {
        int k10 = bVar.k();
        for (int i10 = 0; i10 < k10; i10++) {
            g gVar = new g(this, i10);
            Character.toChars(gVar.f(), this.f5490b, i10 * 2);
            h(gVar);
        }
    }

    @NonNull
    public static m b(@NonNull Typeface typeface, @NonNull ByteBuffer byteBuffer) throws IOException {
        try {
            androidx.core.os.m.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, l.b(byteBuffer));
        } finally {
            androidx.core.os.m.b();
        }
    }

    @NonNull
    public char[] c() {
        return this.f5490b;
    }

    @NonNull
    public b d() {
        return this.f5489a;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f5489a.l();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a f() {
        return this.f5491c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g() {
        return this.f5492d;
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull g gVar) {
        boolean z10;
        h.h(gVar, "emoji metadata cannot be null");
        if (gVar.c() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "invalid metadata codepoint length");
        this.f5491c.c(gVar, 0, gVar.c() - 1);
    }
}
