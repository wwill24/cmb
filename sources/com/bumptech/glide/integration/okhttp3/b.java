package com.bumptech.glide.integration.okhttp3;

import androidx.annotation.NonNull;
import java.io.InputStream;
import okhttp3.e;
import okhttp3.x;
import p3.g;
import p3.n;
import p3.o;
import p3.r;

public class b implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f9216a;

    public static class a implements o<g, InputStream> {

        /* renamed from: b  reason: collision with root package name */
        private static volatile e.a f9217b;

        /* renamed from: a  reason: collision with root package name */
        private final e.a f9218a;

        public a() {
            this(b());
        }

        private static e.a b() {
            if (f9217b == null) {
                synchronized (a.class) {
                    if (f9217b == null) {
                        f9217b = new x();
                    }
                }
            }
            return f9217b;
        }

        public void a() {
        }

        @NonNull
        public n<g, InputStream> c(r rVar) {
            return new b(this.f9218a);
        }

        public a(@NonNull e.a aVar) {
            this.f9218a = aVar;
        }
    }

    public b(@NonNull e.a aVar) {
        this.f9216a = aVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull g gVar, int i10, int i11, @NonNull i3.e eVar) {
        return new n.a<>(gVar, new h3.a(this.f9216a, gVar));
    }

    /* renamed from: d */
    public boolean a(@NonNull g gVar) {
        return true;
    }
}
