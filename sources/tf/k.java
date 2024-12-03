package tf;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import bf.l;

public class k {

    /* renamed from: m  reason: collision with root package name */
    public static final c f24546m = new i(0.5f);

    /* renamed from: a  reason: collision with root package name */
    d f24547a;

    /* renamed from: b  reason: collision with root package name */
    d f24548b;

    /* renamed from: c  reason: collision with root package name */
    d f24549c;

    /* renamed from: d  reason: collision with root package name */
    d f24550d;

    /* renamed from: e  reason: collision with root package name */
    c f24551e;

    /* renamed from: f  reason: collision with root package name */
    c f24552f;

    /* renamed from: g  reason: collision with root package name */
    c f24553g;

    /* renamed from: h  reason: collision with root package name */
    c f24554h;

    /* renamed from: i  reason: collision with root package name */
    f f24555i;

    /* renamed from: j  reason: collision with root package name */
    f f24556j;

    /* renamed from: k  reason: collision with root package name */
    f f24557k;

    /* renamed from: l  reason: collision with root package name */
    f f24558l;

    public interface c {
        @NonNull
        c a(@NonNull c cVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    @NonNull
    private static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new a((float) i12));
    }

    @NonNull
    private static b d(Context context, int i10, int i11, @NonNull c cVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(l.ShapeAppearance);
        try {
            int i12 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamily, 0);
            int i13 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = obtainStyledAttributes.getInt(l.ShapeAppearance_cornerFamilyBottomLeft, i12);
            c m10 = m(obtainStyledAttributes, l.ShapeAppearance_cornerSize, cVar);
            c m11 = m(obtainStyledAttributes, l.ShapeAppearance_cornerSizeTopLeft, m10);
            c m12 = m(obtainStyledAttributes, l.ShapeAppearance_cornerSizeTopRight, m10);
            c m13 = m(obtainStyledAttributes, l.ShapeAppearance_cornerSizeBottomRight, m10);
            return new b().y(i13, m11).C(i14, m12).u(i15, m13).q(i16, m(obtainStyledAttributes, l.ShapeAppearance_cornerSizeBottomLeft, m10));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new a((float) i12));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, int i10, int i11, @NonNull c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.MaterialShape, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(l.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    private static c m(TypedArray typedArray, int i10, @NonNull c cVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return cVar;
        }
        int i11 = peekValue.type;
        if (i11 == 5) {
            return new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i11 == 6) {
            return new i(peekValue.getFraction(1.0f, 1.0f));
        }
        return cVar;
    }

    @NonNull
    public f h() {
        return this.f24557k;
    }

    @NonNull
    public d i() {
        return this.f24550d;
    }

    @NonNull
    public c j() {
        return this.f24554h;
    }

    @NonNull
    public d k() {
        return this.f24549c;
    }

    @NonNull
    public c l() {
        return this.f24553g;
    }

    @NonNull
    public f n() {
        return this.f24558l;
    }

    @NonNull
    public f o() {
        return this.f24556j;
    }

    @NonNull
    public f p() {
        return this.f24555i;
    }

    @NonNull
    public d q() {
        return this.f24547a;
    }

    @NonNull
    public c r() {
        return this.f24551e;
    }

    @NonNull
    public d s() {
        return this.f24548b;
    }

    @NonNull
    public c t() {
        return this.f24552f;
    }

    public boolean u(@NonNull RectF rectF) {
        boolean z10;
        boolean z11;
        boolean z12;
        Class<f> cls = f.class;
        if (!this.f24558l.getClass().equals(cls) || !this.f24556j.getClass().equals(cls) || !this.f24555i.getClass().equals(cls) || !this.f24557k.getClass().equals(cls)) {
            z10 = false;
        } else {
            z10 = true;
        }
        float a10 = this.f24551e.a(rectF);
        if (this.f24552f.a(rectF) == a10 && this.f24554h.a(rectF) == a10 && this.f24553g.a(rectF) == a10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!(this.f24548b instanceof j) || !(this.f24547a instanceof j) || !(this.f24549c instanceof j) || !(this.f24550d instanceof j)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z10 || !z11 || !z12) {
            return false;
        }
        return true;
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public k w(float f10) {
        return v().o(f10).m();
    }

    @NonNull
    public k x(@NonNull c cVar) {
        return v().p(cVar).m();
    }

    @NonNull
    public k y(@NonNull c cVar) {
        return v().B(cVar.a(r())).F(cVar.a(t())).t(cVar.a(j())).x(cVar.a(l())).m();
    }

    private k(@NonNull b bVar) {
        this.f24547a = bVar.f24559a;
        this.f24548b = bVar.f24560b;
        this.f24549c = bVar.f24561c;
        this.f24550d = bVar.f24562d;
        this.f24551e = bVar.f24563e;
        this.f24552f = bVar.f24564f;
        this.f24553g = bVar.f24565g;
        this.f24554h = bVar.f24566h;
        this.f24555i = bVar.f24567i;
        this.f24556j = bVar.f24568j;
        this.f24557k = bVar.f24569k;
        this.f24558l = bVar.f24570l;
    }

    public static final class b {
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public d f24559a = h.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public d f24560b = h.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public d f24561c = h.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public d f24562d = h.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public c f24563e = new a(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public c f24564f = new a(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        public c f24565g = new a(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        public c f24566h = new a(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public f f24567i = h.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        public f f24568j = h.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        public f f24569k = h.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        public f f24570l = h.c();

        public b() {
        }

        private static float n(d dVar) {
            if (dVar instanceof j) {
                return ((j) dVar).f24545a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f24498a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(float f10) {
            this.f24563e = new a(f10);
            return this;
        }

        @NonNull
        public b B(@NonNull c cVar) {
            this.f24563e = cVar;
            return this;
        }

        @NonNull
        public b C(int i10, @NonNull c cVar) {
            return D(h.a(i10)).F(cVar);
        }

        @NonNull
        public b D(@NonNull d dVar) {
            this.f24560b = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                E(n10);
            }
            return this;
        }

        @NonNull
        public b E(float f10) {
            this.f24564f = new a(f10);
            return this;
        }

        @NonNull
        public b F(@NonNull c cVar) {
            this.f24564f = cVar;
            return this;
        }

        @NonNull
        public k m() {
            return new k(this);
        }

        @NonNull
        public b o(float f10) {
            return A(f10).E(f10).w(f10).s(f10);
        }

        @NonNull
        public b p(@NonNull c cVar) {
            return B(cVar).F(cVar).x(cVar).t(cVar);
        }

        @NonNull
        public b q(int i10, @NonNull c cVar) {
            return r(h.a(i10)).t(cVar);
        }

        @NonNull
        public b r(@NonNull d dVar) {
            this.f24562d = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                s(n10);
            }
            return this;
        }

        @NonNull
        public b s(float f10) {
            this.f24566h = new a(f10);
            return this;
        }

        @NonNull
        public b t(@NonNull c cVar) {
            this.f24566h = cVar;
            return this;
        }

        @NonNull
        public b u(int i10, @NonNull c cVar) {
            return v(h.a(i10)).x(cVar);
        }

        @NonNull
        public b v(@NonNull d dVar) {
            this.f24561c = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                w(n10);
            }
            return this;
        }

        @NonNull
        public b w(float f10) {
            this.f24565g = new a(f10);
            return this;
        }

        @NonNull
        public b x(@NonNull c cVar) {
            this.f24565g = cVar;
            return this;
        }

        @NonNull
        public b y(int i10, @NonNull c cVar) {
            return z(h.a(i10)).B(cVar);
        }

        @NonNull
        public b z(@NonNull d dVar) {
            this.f24559a = dVar;
            float n10 = n(dVar);
            if (n10 != -1.0f) {
                A(n10);
            }
            return this;
        }

        public b(@NonNull k kVar) {
            this.f24559a = kVar.f24547a;
            this.f24560b = kVar.f24548b;
            this.f24561c = kVar.f24549c;
            this.f24562d = kVar.f24550d;
            this.f24563e = kVar.f24551e;
            this.f24564f = kVar.f24552f;
            this.f24565g = kVar.f24553g;
            this.f24566h = kVar.f24554h;
            this.f24567i = kVar.f24555i;
            this.f24568j = kVar.f24556j;
            this.f24569k = kVar.f24557k;
            this.f24570l = kVar.f24558l;
        }
    }

    public k() {
        this.f24547a = h.b();
        this.f24548b = h.b();
        this.f24549c = h.b();
        this.f24550d = h.b();
        this.f24551e = new a(0.0f);
        this.f24552f = new a(0.0f);
        this.f24553g = new a(0.0f);
        this.f24554h = new a(0.0f);
        this.f24555i = h.c();
        this.f24556j = h.c();
        this.f24557k = h.c();
        this.f24558l = h.c();
    }
}
