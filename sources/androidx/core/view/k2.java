package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class k2 {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final k2 f4836b;

    /* renamed from: a  reason: collision with root package name */
    private final l f4837a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f4838a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f4839b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f4840c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f4841d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f4838a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f4839b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f4840c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to get visible insets from AttachInfo ");
                sb2.append(e10.getMessage());
            }
        }

        public static k2 a(@NonNull View view) {
            if (f4841d && view.isAttachedToWindow()) {
                try {
                    Object obj = f4838a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f4839b.get(obj);
                        Rect rect2 = (Rect) f4840c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            k2 a10 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a10.r(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get insets from AttachInfo. ");
                    sb2.append(e10.getMessage());
                }
            }
            return null;
        }
    }

    private static class e extends d {
        e() {
        }

        e(@NonNull k2 k2Var) {
            super(k2Var);
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        private final k2 f4850a;

        /* renamed from: b  reason: collision with root package name */
        androidx.core.graphics.b[] f4851b;

        f() {
            this(new k2((k2) null));
        }

        /* access modifiers changed from: protected */
        public final void a() {
            androidx.core.graphics.b[] bVarArr = this.f4851b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[m.b(1)];
                androidx.core.graphics.b bVar2 = this.f4851b[m.b(2)];
                if (bVar2 == null) {
                    bVar2 = this.f4850a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f4850a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f4851b[m.b(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f4851b[m.b(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f4851b[m.b(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 b() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull androidx.core.graphics.b bVar) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.b bVar) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull androidx.core.graphics.b bVar) {
        }

        f(@NonNull k2 k2Var) {
            this.f4850a = k2Var;
        }
    }

    private static class i extends h {
        i(@NonNull k2 k2Var, @NonNull WindowInsets windowInsets) {
            super(k2Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 a() {
            return k2.u(this.f4857c.consumeDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            if (!Objects.equals(this.f4857c, iVar.f4857c) || !Objects.equals(this.f4861g, iVar.f4861g)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return d.e(this.f4857c.getDisplayCutout());
        }

        public int hashCode() {
            return this.f4857c.hashCode();
        }

        i(@NonNull k2 k2Var, @NonNull i iVar) {
            super(k2Var, (h) iVar);
        }
    }

    private static class k extends j {
        @NonNull

        /* renamed from: q  reason: collision with root package name */
        static final k2 f4866q = k2.u(WindowInsets.CONSUMED);

        k(@NonNull k2 k2Var, @NonNull WindowInsets windowInsets) {
            super(k2Var, windowInsets);
        }

        /* access modifiers changed from: package-private */
        public final void d(@NonNull View view) {
        }

        @NonNull
        public androidx.core.graphics.b g(int i10) {
            return androidx.core.graphics.b.d(this.f4857c.getInsets(n.a(i10)));
        }

        k(@NonNull k2 k2Var, @NonNull k kVar) {
            super(k2Var, (j) kVar);
        }
    }

    private static class l {
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        static final k2 f4867b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final k2 f4868a;

        l(@NonNull k2 k2Var) {
            this.f4868a = k2Var;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 a() {
            return this.f4868a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 b() {
            return this.f4868a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 c() {
            return this.f4868a;
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull View view) {
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull k2 k2Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            if (o() != lVar.o() || n() != lVar.n() || !androidx.core.util.c.a(k(), lVar.k()) || !androidx.core.util.c.a(i(), lVar.i()) || !androidx.core.util.c.a(f(), lVar.f())) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public d f() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b g(int i10) {
            return androidx.core.graphics.b.f4587e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f4587e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b j() {
            return k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f4587e;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public androidx.core.graphics.b l() {
            return k();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 m(int i10, int i11, int i12, int i13) {
            return f4867b;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.b[] bVarArr) {
        }

        /* access modifiers changed from: package-private */
        public void q(@NonNull androidx.core.graphics.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void r(k2 k2Var) {
        }

        public void s(androidx.core.graphics.b bVar) {
        }
    }

    public static final class m {
        public static int a() {
            return 8;
        }

        static int b(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 7;
        }
    }

    private static final class n {
        static int a(int i10) {
            int i11;
            int i12 = 0;
            for (int i13 = 1; i13 <= 256; i13 <<= 1) {
                if ((i10 & i13) != 0) {
                    if (i13 == 1) {
                        i11 = WindowInsets$Type.statusBars();
                    } else if (i13 == 2) {
                        i11 = WindowInsets$Type.navigationBars();
                    } else if (i13 == 4) {
                        i11 = WindowInsets$Type.captionBar();
                    } else if (i13 == 8) {
                        i11 = WindowInsets$Type.ime();
                    } else if (i13 == 16) {
                        i11 = WindowInsets$Type.systemGestures();
                    } else if (i13 == 32) {
                        i11 = WindowInsets$Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        i11 = WindowInsets$Type.tappableElement();
                    } else if (i13 == 128) {
                        i11 = WindowInsets$Type.displayCutout();
                    }
                    i12 |= i11;
                }
            }
            return i12;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f4836b = k.f4866q;
        } else {
            f4836b = l.f4867b;
        }
    }

    private k2(@NonNull WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f4837a = new k(this, windowInsets);
        } else if (i10 >= 29) {
            this.f4837a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f4837a = new i(this, windowInsets);
        } else {
            this.f4837a = new h(this, windowInsets);
        }
    }

    static androidx.core.graphics.b m(@NonNull androidx.core.graphics.b bVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, bVar.f4588a - i10);
        int max2 = Math.max(0, bVar.f4589b - i11);
        int max3 = Math.max(0, bVar.f4590c - i12);
        int max4 = Math.max(0, bVar.f4591d - i13);
        if (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) {
            return bVar;
        }
        return androidx.core.graphics.b.b(max, max2, max3, max4);
    }

    @NonNull
    public static k2 u(@NonNull WindowInsets windowInsets) {
        return v(windowInsets, (View) null);
    }

    @NonNull
    public static k2 v(@NonNull WindowInsets windowInsets, View view) {
        k2 k2Var = new k2((WindowInsets) androidx.core.util.h.g(windowInsets));
        if (view != null && n0.V(view)) {
            k2Var.r(n0.I(view));
            k2Var.d(view.getRootView());
        }
        return k2Var;
    }

    @NonNull
    @Deprecated
    public k2 a() {
        return this.f4837a.a();
    }

    @NonNull
    @Deprecated
    public k2 b() {
        return this.f4837a.b();
    }

    @NonNull
    @Deprecated
    public k2 c() {
        return this.f4837a.c();
    }

    /* access modifiers changed from: package-private */
    public void d(@NonNull View view) {
        this.f4837a.d(view);
    }

    public d e() {
        return this.f4837a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k2)) {
            return false;
        }
        return androidx.core.util.c.a(this.f4837a, ((k2) obj).f4837a);
    }

    @NonNull
    public androidx.core.graphics.b f(int i10) {
        return this.f4837a.g(i10);
    }

    @NonNull
    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f4837a.i();
    }

    @Deprecated
    public int h() {
        return this.f4837a.k().f4591d;
    }

    public int hashCode() {
        l lVar = this.f4837a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f4837a.k().f4588a;
    }

    @Deprecated
    public int j() {
        return this.f4837a.k().f4590c;
    }

    @Deprecated
    public int k() {
        return this.f4837a.k().f4589b;
    }

    @NonNull
    public k2 l(int i10, int i11, int i12, int i13) {
        return this.f4837a.m(i10, i11, i12, i13);
    }

    public boolean n() {
        return this.f4837a.n();
    }

    @NonNull
    @Deprecated
    public k2 o(int i10, int i11, int i12, int i13) {
        return new b(this).c(androidx.core.graphics.b.b(i10, i11, i12, i13)).a();
    }

    /* access modifiers changed from: package-private */
    public void p(androidx.core.graphics.b[] bVarArr) {
        this.f4837a.p(bVarArr);
    }

    /* access modifiers changed from: package-private */
    public void q(@NonNull androidx.core.graphics.b bVar) {
        this.f4837a.q(bVar);
    }

    /* access modifiers changed from: package-private */
    public void r(k2 k2Var) {
        this.f4837a.r(k2Var);
    }

    /* access modifiers changed from: package-private */
    public void s(androidx.core.graphics.b bVar) {
        this.f4837a.s(bVar);
    }

    public WindowInsets t() {
        l lVar = this.f4837a;
        if (lVar instanceof g) {
            return ((g) lVar).f4857c;
        }
        return null;
    }

    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f4843e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f4844f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f4845g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f4846h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f4847c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b f4848d;

        c() {
            this.f4847c = h();
        }

        private static WindowInsets h() {
            if (!f4844f) {
                try {
                    f4843e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f4844f = true;
            }
            Field field = f4843e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f4846h) {
                try {
                    f4845g = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                f4846h = true;
            }
            Constructor<WindowInsets> constructor = f4845g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 b() {
            a();
            k2 u10 = k2.u(this.f4847c);
            u10.p(this.f4851b);
            u10.s(this.f4848d);
            return u10;
        }

        /* access modifiers changed from: package-private */
        public void d(androidx.core.graphics.b bVar) {
            this.f4848d = bVar;
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f4847c;
            if (windowInsets != null) {
                this.f4847c = windowInsets.replaceSystemWindowInsets(bVar.f4588a, bVar.f4589b, bVar.f4590c, bVar.f4591d);
            }
        }

        c(@NonNull k2 k2Var) {
            super(k2Var);
            this.f4847c = k2Var.t();
        }
    }

    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets$Builder f4849c;

        d() {
            this.f4849c = new WindowInsets$Builder();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public k2 b() {
            a();
            k2 u10 = k2.u(this.f4849c.build());
            u10.p(this.f4851b);
            return u10;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull androidx.core.graphics.b bVar) {
            this.f4849c.setMandatorySystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull androidx.core.graphics.b bVar) {
            this.f4849c.setStableInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void e(@NonNull androidx.core.graphics.b bVar) {
            this.f4849c.setSystemGestureInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull androidx.core.graphics.b bVar) {
            this.f4849c.setSystemWindowInsets(bVar.e());
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull androidx.core.graphics.b bVar) {
            this.f4849c.setTappableElementInsets(bVar.e());
        }

        d(@NonNull k2 k2Var) {
            super(k2Var);
            WindowInsets$Builder windowInsets$Builder;
            WindowInsets t10 = k2Var.t();
            if (t10 != null) {
                windowInsets$Builder = new WindowInsets$Builder(t10);
            } else {
                new WindowInsets$Builder
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 ? I:android.view.WindowInsets$Builder) =  call: android.view.WindowInsets$Builder.<init>():void type: CONSTRUCTOR in method: androidx.core.view.k2.d.<init>(androidx.core.view.k2):void, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v1 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 51 more
                    */
                /*
                    this = this;
                    r1.<init>(r2)
                    android.view.WindowInsets r2 = r2.t()
                    if (r2 == 0) goto L_0x000f
                    android.view.WindowInsets$Builder r0 = new android.view.WindowInsets$Builder
                    r0.<init>(r2)
                    goto L_0x0014
                L_0x000f:
                    android.view.WindowInsets$Builder r0 = new android.view.WindowInsets$Builder
                    r0.<init>()
                L_0x0014:
                    r1.f4849c = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.k2.d.<init>(androidx.core.view.k2):void");
            }
        }

        private static class h extends g {

            /* renamed from: m  reason: collision with root package name */
            private androidx.core.graphics.b f4862m = null;

            h(@NonNull k2 k2Var, @NonNull WindowInsets windowInsets) {
                super(k2Var, windowInsets);
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public k2 b() {
                return k2.u(this.f4857c.consumeStableInsets());
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public k2 c() {
                return k2.u(this.f4857c.consumeSystemWindowInsets());
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public final androidx.core.graphics.b i() {
                if (this.f4862m == null) {
                    this.f4862m = androidx.core.graphics.b.b(this.f4857c.getStableInsetLeft(), this.f4857c.getStableInsetTop(), this.f4857c.getStableInsetRight(), this.f4857c.getStableInsetBottom());
                }
                return this.f4862m;
            }

            /* access modifiers changed from: package-private */
            public boolean n() {
                return this.f4857c.isConsumed();
            }

            public void s(androidx.core.graphics.b bVar) {
                this.f4862m = bVar;
            }

            h(@NonNull k2 k2Var, @NonNull h hVar) {
                super(k2Var, (g) hVar);
                this.f4862m = hVar.f4862m;
            }
        }

        private static class g extends l {

            /* renamed from: h  reason: collision with root package name */
            private static boolean f4852h = false;

            /* renamed from: i  reason: collision with root package name */
            private static Method f4853i;

            /* renamed from: j  reason: collision with root package name */
            private static Class<?> f4854j;

            /* renamed from: k  reason: collision with root package name */
            private static Field f4855k;

            /* renamed from: l  reason: collision with root package name */
            private static Field f4856l;
            @NonNull

            /* renamed from: c  reason: collision with root package name */
            final WindowInsets f4857c;

            /* renamed from: d  reason: collision with root package name */
            private androidx.core.graphics.b[] f4858d;

            /* renamed from: e  reason: collision with root package name */
            private androidx.core.graphics.b f4859e;

            /* renamed from: f  reason: collision with root package name */
            private k2 f4860f;

            /* renamed from: g  reason: collision with root package name */
            androidx.core.graphics.b f4861g;

            g(@NonNull k2 k2Var, @NonNull WindowInsets windowInsets) {
                super(k2Var);
                this.f4859e = null;
                this.f4857c = windowInsets;
            }

            @SuppressLint({"WrongConstant"})
            @NonNull
            private androidx.core.graphics.b t(int i10, boolean z10) {
                androidx.core.graphics.b bVar = androidx.core.graphics.b.f4587e;
                for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                    if ((i10 & i11) != 0) {
                        bVar = androidx.core.graphics.b.a(bVar, u(i11, z10));
                    }
                }
                return bVar;
            }

            private androidx.core.graphics.b v() {
                k2 k2Var = this.f4860f;
                if (k2Var != null) {
                    return k2Var.g();
                }
                return androidx.core.graphics.b.f4587e;
            }

            private androidx.core.graphics.b w(@NonNull View view) {
                if (Build.VERSION.SDK_INT < 30) {
                    if (!f4852h) {
                        x();
                    }
                    Method method = f4853i;
                    if (!(method == null || f4854j == null || f4855k == null)) {
                        try {
                            Object invoke = method.invoke(view, new Object[0]);
                            if (invoke == null) {
                                return null;
                            }
                            Rect rect = (Rect) f4855k.get(f4856l.get(invoke));
                            if (rect != null) {
                                return androidx.core.graphics.b.c(rect);
                            }
                            return null;
                        } catch (ReflectiveOperationException e10) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to get visible insets. (Reflection error). ");
                            sb2.append(e10.getMessage());
                        }
                    }
                    return null;
                }
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }

            @SuppressLint({"PrivateApi"})
            private static void x() {
                try {
                    f4853i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                    Class<?> cls = Class.forName("android.view.View$AttachInfo");
                    f4854j = cls;
                    f4855k = cls.getDeclaredField("mVisibleInsets");
                    f4856l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                    f4855k.setAccessible(true);
                    f4856l.setAccessible(true);
                } catch (ReflectiveOperationException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get visible insets. (Reflection error). ");
                    sb2.append(e10.getMessage());
                }
                f4852h = true;
            }

            /* access modifiers changed from: package-private */
            public void d(@NonNull View view) {
                androidx.core.graphics.b w10 = w(view);
                if (w10 == null) {
                    w10 = androidx.core.graphics.b.f4587e;
                }
                q(w10);
            }

            /* access modifiers changed from: package-private */
            public void e(@NonNull k2 k2Var) {
                k2Var.r(this.f4860f);
                k2Var.q(this.f4861g);
            }

            public boolean equals(Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                return Objects.equals(this.f4861g, ((g) obj).f4861g);
            }

            @NonNull
            public androidx.core.graphics.b g(int i10) {
                return t(i10, false);
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public final androidx.core.graphics.b k() {
                if (this.f4859e == null) {
                    this.f4859e = androidx.core.graphics.b.b(this.f4857c.getSystemWindowInsetLeft(), this.f4857c.getSystemWindowInsetTop(), this.f4857c.getSystemWindowInsetRight(), this.f4857c.getSystemWindowInsetBottom());
                }
                return this.f4859e;
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public k2 m(int i10, int i11, int i12, int i13) {
                b bVar = new b(k2.u(this.f4857c));
                bVar.c(k2.m(k(), i10, i11, i12, i13));
                bVar.b(k2.m(i(), i10, i11, i12, i13));
                return bVar.a();
            }

            /* access modifiers changed from: package-private */
            public boolean o() {
                return this.f4857c.isRound();
            }

            public void p(androidx.core.graphics.b[] bVarArr) {
                this.f4858d = bVarArr;
            }

            /* access modifiers changed from: package-private */
            public void q(@NonNull androidx.core.graphics.b bVar) {
                this.f4861g = bVar;
            }

            /* access modifiers changed from: package-private */
            public void r(k2 k2Var) {
                this.f4860f = k2Var;
            }

            /* access modifiers changed from: protected */
            @NonNull
            public androidx.core.graphics.b u(int i10, boolean z10) {
                int i11;
                d dVar;
                if (i10 != 1) {
                    androidx.core.graphics.b bVar = null;
                    if (i10 != 2) {
                        if (i10 == 8) {
                            androidx.core.graphics.b[] bVarArr = this.f4858d;
                            if (bVarArr != null) {
                                bVar = bVarArr[m.b(8)];
                            }
                            if (bVar != null) {
                                return bVar;
                            }
                            androidx.core.graphics.b k10 = k();
                            androidx.core.graphics.b v10 = v();
                            int i12 = k10.f4591d;
                            if (i12 > v10.f4591d) {
                                return androidx.core.graphics.b.b(0, 0, 0, i12);
                            }
                            androidx.core.graphics.b bVar2 = this.f4861g;
                            if (bVar2 == null || bVar2.equals(androidx.core.graphics.b.f4587e) || (i11 = this.f4861g.f4591d) <= v10.f4591d) {
                                return androidx.core.graphics.b.f4587e;
                            }
                            return androidx.core.graphics.b.b(0, 0, 0, i11);
                        } else if (i10 == 16) {
                            return j();
                        } else {
                            if (i10 == 32) {
                                return h();
                            }
                            if (i10 == 64) {
                                return l();
                            }
                            if (i10 != 128) {
                                return androidx.core.graphics.b.f4587e;
                            }
                            k2 k2Var = this.f4860f;
                            if (k2Var != null) {
                                dVar = k2Var.e();
                            } else {
                                dVar = f();
                            }
                            if (dVar != null) {
                                return androidx.core.graphics.b.b(dVar.b(), dVar.d(), dVar.c(), dVar.a());
                            }
                            return androidx.core.graphics.b.f4587e;
                        }
                    } else if (z10) {
                        androidx.core.graphics.b v11 = v();
                        androidx.core.graphics.b i13 = i();
                        return androidx.core.graphics.b.b(Math.max(v11.f4588a, i13.f4588a), 0, Math.max(v11.f4590c, i13.f4590c), Math.max(v11.f4591d, i13.f4591d));
                    } else {
                        androidx.core.graphics.b k11 = k();
                        k2 k2Var2 = this.f4860f;
                        if (k2Var2 != null) {
                            bVar = k2Var2.g();
                        }
                        int i14 = k11.f4591d;
                        if (bVar != null) {
                            i14 = Math.min(i14, bVar.f4591d);
                        }
                        return androidx.core.graphics.b.b(k11.f4588a, 0, k11.f4590c, i14);
                    }
                } else if (z10) {
                    return androidx.core.graphics.b.b(0, Math.max(v().f4589b, k().f4589b), 0, 0);
                } else {
                    return androidx.core.graphics.b.b(0, k().f4589b, 0, 0);
                }
            }

            g(@NonNull k2 k2Var, @NonNull g gVar) {
                this(k2Var, new WindowInsets(gVar.f4857c));
            }
        }

        private static class j extends i {

            /* renamed from: n  reason: collision with root package name */
            private androidx.core.graphics.b f4863n = null;

            /* renamed from: o  reason: collision with root package name */
            private androidx.core.graphics.b f4864o = null;

            /* renamed from: p  reason: collision with root package name */
            private androidx.core.graphics.b f4865p = null;

            j(@NonNull k2 k2Var, @NonNull WindowInsets windowInsets) {
                super(k2Var, windowInsets);
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public androidx.core.graphics.b h() {
                if (this.f4864o == null) {
                    this.f4864o = androidx.core.graphics.b.d(this.f4857c.getMandatorySystemGestureInsets());
                }
                return this.f4864o;
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public androidx.core.graphics.b j() {
                if (this.f4863n == null) {
                    this.f4863n = androidx.core.graphics.b.d(this.f4857c.getSystemGestureInsets());
                }
                return this.f4863n;
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public androidx.core.graphics.b l() {
                if (this.f4865p == null) {
                    this.f4865p = androidx.core.graphics.b.d(this.f4857c.getTappableElementInsets());
                }
                return this.f4865p;
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public k2 m(int i10, int i11, int i12, int i13) {
                return k2.u(this.f4857c.inset(i10, i11, i12, i13));
            }

            public void s(androidx.core.graphics.b bVar) {
            }

            j(@NonNull k2 k2Var, @NonNull j jVar) {
                super(k2Var, (i) jVar);
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            private final f f4842a;

            public b() {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    this.f4842a = new e();
                } else if (i10 >= 29) {
                    this.f4842a = new d();
                } else {
                    this.f4842a = new c();
                }
            }

            @NonNull
            public k2 a() {
                return this.f4842a.b();
            }

            @NonNull
            @Deprecated
            public b b(@NonNull androidx.core.graphics.b bVar) {
                this.f4842a.d(bVar);
                return this;
            }

            @NonNull
            @Deprecated
            public b c(@NonNull androidx.core.graphics.b bVar) {
                this.f4842a.f(bVar);
                return this;
            }

            public b(@NonNull k2 k2Var) {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    this.f4842a = new e(k2Var);
                } else if (i10 >= 29) {
                    this.f4842a = new d(k2Var);
                } else {
                    this.f4842a = new c(k2Var);
                }
            }
        }

        public k2(k2 k2Var) {
            if (k2Var != null) {
                l lVar = k2Var.f4837a;
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30 && (lVar instanceof k)) {
                    this.f4837a = new k(this, (k) lVar);
                } else if (i10 >= 29 && (lVar instanceof j)) {
                    this.f4837a = new j(this, (j) lVar);
                } else if (i10 >= 28 && (lVar instanceof i)) {
                    this.f4837a = new i(this, (i) lVar);
                } else if (lVar instanceof h) {
                    this.f4837a = new h(this, (h) lVar);
                } else if (lVar instanceof g) {
                    this.f4837a = new g(this, (g) lVar);
                } else {
                    this.f4837a = new l(this);
                }
                lVar.e(this);
                return;
            }
            this.f4837a = new l(this);
        }
    }
