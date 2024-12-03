package com.skydoves.balloon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.MovementMethod;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f22845a;

    /* renamed from: b  reason: collision with root package name */
    private final float f22846b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22847c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22848d;

    /* renamed from: e  reason: collision with root package name */
    private final MovementMethod f22849e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22850f;

    /* renamed from: g  reason: collision with root package name */
    private final Typeface f22851g;

    /* renamed from: h  reason: collision with root package name */
    private final Float f22852h;

    /* renamed from: i  reason: collision with root package name */
    private final int f22853i;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f22854a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f22855b = "";

        /* renamed from: c  reason: collision with root package name */
        private float f22856c = 12.0f;

        /* renamed from: d  reason: collision with root package name */
        private int f22857d = -1;

        /* renamed from: e  reason: collision with root package name */
        private boolean f22858e;

        /* renamed from: f  reason: collision with root package name */
        private MovementMethod f22859f;

        /* renamed from: g  reason: collision with root package name */
        private int f22860g;

        /* renamed from: h  reason: collision with root package name */
        private Typeface f22861h;

        /* renamed from: i  reason: collision with root package name */
        private Float f22862i;

        /* renamed from: j  reason: collision with root package name */
        private int f22863j = 17;

        public a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            this.f22854a = context;
            o oVar = o.f32141a;
        }

        public final w a() {
            return new w(this, (DefaultConstructorMarker) null);
        }

        public final MovementMethod b() {
            return this.f22859f;
        }

        public final CharSequence c() {
            return this.f22855b;
        }

        public final int d() {
            return this.f22857d;
        }

        public final int e() {
            return this.f22863j;
        }

        public final boolean f() {
            return this.f22858e;
        }

        public final Float g() {
            return this.f22862i;
        }

        public final float h() {
            return this.f22856c;
        }

        public final int i() {
            return this.f22860g;
        }

        public final Typeface j() {
            return this.f22861h;
        }

        public final a k(CharSequence charSequence) {
            j.g(charSequence, "value");
            this.f22855b = charSequence;
            return this;
        }

        public final a l(int i10) {
            this.f22857d = i10;
            return this;
        }

        public final a m(int i10) {
            this.f22863j = i10;
            return this;
        }

        public final a n(boolean z10) {
            this.f22858e = z10;
            return this;
        }

        public final a o(Float f10) {
            this.f22862i = f10;
            return this;
        }

        public final a p(float f10) {
            this.f22856c = f10;
            return this;
        }

        public final a q(int i10) {
            this.f22860g = i10;
            return this;
        }

        public final a r(Typeface typeface) {
            this.f22861h = typeface;
            return this;
        }
    }

    private w(a aVar) {
        this.f22845a = aVar.c();
        this.f22846b = aVar.h();
        this.f22847c = aVar.d();
        this.f22848d = aVar.f();
        this.f22849e = aVar.b();
        this.f22850f = aVar.i();
        this.f22851g = aVar.j();
        this.f22852h = aVar.g();
        this.f22853i = aVar.e();
    }

    public /* synthetic */ w(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final MovementMethod a() {
        return this.f22849e;
    }

    public final CharSequence b() {
        return this.f22845a;
    }

    public final int c() {
        return this.f22847c;
    }

    public final int d() {
        return this.f22853i;
    }

    public final boolean e() {
        return this.f22848d;
    }

    public final Float f() {
        return this.f22852h;
    }

    public final float g() {
        return this.f22846b;
    }

    public final int h() {
        return this.f22850f;
    }

    public final Typeface i() {
        return this.f22851g;
    }
}
