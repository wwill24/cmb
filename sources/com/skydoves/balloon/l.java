package com.skydoves.balloon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f22809a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f22810b;

    /* renamed from: c  reason: collision with root package name */
    private final IconGravity f22811c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22812d;

    /* renamed from: e  reason: collision with root package name */
    private final int f22813e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22814f;

    /* renamed from: g  reason: collision with root package name */
    private final int f22815g;

    /* renamed from: h  reason: collision with root package name */
    private final CharSequence f22816h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f22817a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f22818b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f22819c;

        /* renamed from: d  reason: collision with root package name */
        private IconGravity f22820d = IconGravity.START;

        /* renamed from: e  reason: collision with root package name */
        private int f22821e;

        /* renamed from: f  reason: collision with root package name */
        private int f22822f;

        /* renamed from: g  reason: collision with root package name */
        private int f22823g;

        /* renamed from: h  reason: collision with root package name */
        private int f22824h;

        /* renamed from: i  reason: collision with root package name */
        private CharSequence f22825i;

        public a(Context context) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            this.f22817a = context;
            float f10 = (float) 28;
            this.f22821e = c.b(TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics()));
            this.f22822f = c.b(TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics()));
            this.f22823g = c.b(TypedValue.applyDimension(1, (float) 8, Resources.getSystem().getDisplayMetrics()));
            this.f22824h = -1;
            o oVar = o.f32141a;
            this.f22825i = "";
        }

        public final l a() {
            return new l(this, (DefaultConstructorMarker) null);
        }

        public final Drawable b() {
            return this.f22818b;
        }

        public final Integer c() {
            return this.f22819c;
        }

        public final int d() {
            return this.f22824h;
        }

        public final CharSequence e() {
            return this.f22825i;
        }

        public final IconGravity f() {
            return this.f22820d;
        }

        public final int g() {
            return this.f22822f;
        }

        public final int h() {
            return this.f22823g;
        }

        public final int i() {
            return this.f22821e;
        }

        public final a j(Drawable drawable) {
            this.f22818b = drawable;
            return this;
        }

        public final a k(IconGravity iconGravity) {
            j.g(iconGravity, "value");
            this.f22820d = iconGravity;
            return this;
        }

        public final a l(int i10) {
            this.f22824h = i10;
            return this;
        }

        public final a m(int i10) {
            this.f22822f = i10;
            return this;
        }

        public final a n(int i10) {
            this.f22823g = i10;
            return this;
        }

        public final a o(int i10) {
            this.f22821e = i10;
            return this;
        }
    }

    private l(a aVar) {
        this.f22809a = aVar.b();
        this.f22810b = aVar.c();
        this.f22811c = aVar.f();
        this.f22812d = aVar.i();
        this.f22813e = aVar.g();
        this.f22814f = aVar.h();
        this.f22815g = aVar.d();
        this.f22816h = aVar.e();
    }

    public /* synthetic */ l(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public final Drawable a() {
        return this.f22809a;
    }

    public final Integer b() {
        return this.f22810b;
    }

    public final int c() {
        return this.f22815g;
    }

    public final CharSequence d() {
        return this.f22816h;
    }

    public final IconGravity e() {
        return this.f22811c;
    }

    public final int f() {
        return this.f22813e;
    }

    public final int g() {
        return this.f22814f;
    }

    public final int h() {
        return this.f22812d;
    }
}
