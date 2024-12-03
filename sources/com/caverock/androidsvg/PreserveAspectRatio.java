package com.caverock.androidsvg;

public class PreserveAspectRatio {

    /* renamed from: c  reason: collision with root package name */
    public static final PreserveAspectRatio f9649c = new PreserveAspectRatio((Alignment) null, (Scale) null);

    /* renamed from: d  reason: collision with root package name */
    public static final PreserveAspectRatio f9650d = new PreserveAspectRatio(Alignment.none, (Scale) null);

    /* renamed from: e  reason: collision with root package name */
    public static final PreserveAspectRatio f9651e;

    /* renamed from: f  reason: collision with root package name */
    public static final PreserveAspectRatio f9652f;

    /* renamed from: g  reason: collision with root package name */
    public static final PreserveAspectRatio f9653g;

    /* renamed from: h  reason: collision with root package name */
    public static final PreserveAspectRatio f9654h;

    /* renamed from: i  reason: collision with root package name */
    public static final PreserveAspectRatio f9655i;

    /* renamed from: j  reason: collision with root package name */
    public static final PreserveAspectRatio f9656j;

    /* renamed from: k  reason: collision with root package name */
    public static final PreserveAspectRatio f9657k;

    /* renamed from: a  reason: collision with root package name */
    private Alignment f9658a;

    /* renamed from: b  reason: collision with root package name */
    private Scale f9659b;

    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        f9651e = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        f9652f = new PreserveAspectRatio(alignment2, scale);
        f9653g = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        f9654h = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        f9655i = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        f9656j = new PreserveAspectRatio(alignment, scale2);
        f9657k = new PreserveAspectRatio(alignment2, scale2);
    }

    PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f9658a = alignment;
        this.f9659b = scale;
    }

    public Alignment a() {
        return this.f9658a;
    }

    public Scale b() {
        return this.f9659b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        if (this.f9658a == preserveAspectRatio.f9658a && this.f9659b == preserveAspectRatio.f9659b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f9658a + " " + this.f9659b;
    }
}
