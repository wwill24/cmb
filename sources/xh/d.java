package xh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import com.skydoves.balloon.l;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class d {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24684a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.skydoves.balloon.IconGravity[] r0 = com.skydoves.balloon.IconGravity.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.skydoves.balloon.IconGravity r1 = com.skydoves.balloon.IconGravity.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.skydoves.balloon.IconGravity r1 = com.skydoves.balloon.IconGravity.TOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.skydoves.balloon.IconGravity r1 = com.skydoves.balloon.IconGravity.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.skydoves.balloon.IconGravity r1 = com.skydoves.balloon.IconGravity.END     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f24684a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xh.d.a.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(android.widget.TextView r9, zh.a r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r9, r0)
            java.lang.String r0 = "vectorTextViewParams"
            kotlin.jvm.internal.j.g(r10, r0)
            java.lang.Integer r0 = r10.m()
            r1 = 0
            if (r0 != 0) goto L_0x004b
            java.lang.Integer r0 = r10.l()
            if (r0 == 0) goto L_0x002c
            int r0 = r0.intValue()
            android.content.Context r2 = r9.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r0 = r2.getDimensionPixelSize(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            if (r0 != 0) goto L_0x004b
            java.lang.Integer r0 = r10.o()
            if (r0 == 0) goto L_0x004a
            int r0 = r0.intValue()
            android.content.Context r2 = r9.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r0 = r2.getDimensionPixelSize(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x004b
        L_0x004a:
            r0 = r1
        L_0x004b:
            java.lang.Integer r2 = r10.n()
            if (r2 != 0) goto L_0x008b
            java.lang.Integer r2 = r10.q()
            if (r2 == 0) goto L_0x006c
            int r2 = r2.intValue()
            android.content.Context r3 = r9.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r2 = r3.getDimensionPixelSize(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x006d
        L_0x006c:
            r2 = r1
        L_0x006d:
            if (r2 != 0) goto L_0x008b
            java.lang.Integer r2 = r10.o()
            if (r2 == 0) goto L_0x008a
            int r2 = r2.intValue()
            android.content.Context r3 = r9.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r2 = r3.getDimensionPixelSize(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x008b
        L_0x008a:
            r2 = r1
        L_0x008b:
            android.graphics.drawable.Drawable r3 = r10.h()
            if (r3 != 0) goto L_0x00a5
            java.lang.Integer r3 = r10.i()
            if (r3 == 0) goto L_0x00a4
            int r3 = r3.intValue()
            android.content.Context r4 = r9.getContext()
            android.graphics.drawable.Drawable r3 = e.a.b(r4, r3)
            goto L_0x00a5
        L_0x00a4:
            r3 = r1
        L_0x00a5:
            java.lang.String r4 = "context"
            if (r3 == 0) goto L_0x00bf
            android.content.Context r5 = r9.getContext()
            kotlin.jvm.internal.j.f(r5, r4)
            android.graphics.drawable.Drawable r3 = xh.b.f(r3, r5, r2, r0)
            if (r3 == 0) goto L_0x00bf
            java.lang.Integer r5 = r10.p()
            android.graphics.drawable.Drawable r3 = xh.b.g(r3, r5)
            goto L_0x00c0
        L_0x00bf:
            r3 = r1
        L_0x00c0:
            android.graphics.drawable.Drawable r5 = r10.f()
            if (r5 != 0) goto L_0x00da
            java.lang.Integer r5 = r10.g()
            if (r5 == 0) goto L_0x00d9
            int r5 = r5.intValue()
            android.content.Context r6 = r9.getContext()
            android.graphics.drawable.Drawable r5 = e.a.b(r6, r5)
            goto L_0x00da
        L_0x00d9:
            r5 = r1
        L_0x00da:
            if (r5 == 0) goto L_0x00f2
            android.content.Context r6 = r9.getContext()
            kotlin.jvm.internal.j.f(r6, r4)
            android.graphics.drawable.Drawable r5 = xh.b.f(r5, r6, r2, r0)
            if (r5 == 0) goto L_0x00f2
            java.lang.Integer r6 = r10.p()
            android.graphics.drawable.Drawable r5 = xh.b.g(r5, r6)
            goto L_0x00f3
        L_0x00f2:
            r5 = r1
        L_0x00f3:
            android.graphics.drawable.Drawable r6 = r10.d()
            if (r6 != 0) goto L_0x010d
            java.lang.Integer r6 = r10.e()
            if (r6 == 0) goto L_0x010c
            int r6 = r6.intValue()
            android.content.Context r7 = r9.getContext()
            android.graphics.drawable.Drawable r6 = e.a.b(r7, r6)
            goto L_0x010d
        L_0x010c:
            r6 = r1
        L_0x010d:
            if (r6 == 0) goto L_0x0125
            android.content.Context r7 = r9.getContext()
            kotlin.jvm.internal.j.f(r7, r4)
            android.graphics.drawable.Drawable r6 = xh.b.f(r6, r7, r2, r0)
            if (r6 == 0) goto L_0x0125
            java.lang.Integer r7 = r10.p()
            android.graphics.drawable.Drawable r6 = xh.b.g(r6, r7)
            goto L_0x0126
        L_0x0125:
            r6 = r1
        L_0x0126:
            android.graphics.drawable.Drawable r7 = r10.j()
            if (r7 != 0) goto L_0x0140
            java.lang.Integer r7 = r10.k()
            if (r7 == 0) goto L_0x013f
            int r7 = r7.intValue()
            android.content.Context r8 = r9.getContext()
            android.graphics.drawable.Drawable r7 = e.a.b(r8, r7)
            goto L_0x0140
        L_0x013f:
            r7 = r1
        L_0x0140:
            if (r7 == 0) goto L_0x0157
            android.content.Context r8 = r9.getContext()
            kotlin.jvm.internal.j.f(r8, r4)
            android.graphics.drawable.Drawable r0 = xh.b.f(r7, r8, r2, r0)
            if (r0 == 0) goto L_0x0157
            java.lang.Integer r1 = r10.p()
            android.graphics.drawable.Drawable r1 = xh.b.g(r0, r1)
        L_0x0157:
            boolean r0 = r10.r()
            if (r0 == 0) goto L_0x0161
            r9.setCompoundDrawablesWithIntrinsicBounds(r5, r1, r3, r6)
            goto L_0x0164
        L_0x0161:
            r9.setCompoundDrawablesWithIntrinsicBounds(r3, r1, r5, r6)
        L_0x0164:
            java.lang.Integer r0 = r10.a()
            if (r0 == 0) goto L_0x0172
            int r0 = r0.intValue()
            r9.setCompoundDrawablePadding(r0)
            goto L_0x018b
        L_0x0172:
            java.lang.Integer r0 = r10.b()
            if (r0 == 0) goto L_0x018b
            int r0 = r0.intValue()
            android.content.Context r1 = r9.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r0 = r1.getDimensionPixelSize(r0)
            r9.setCompoundDrawablePadding(r0)
        L_0x018b:
            java.lang.CharSequence r10 = r10.c()
            r9.setContentDescription(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xh.d.a(android.widget.TextView, zh.a):void");
    }

    public static final /* synthetic */ void b(VectorTextView vectorTextView, l lVar) {
        boolean z10;
        zh.a aVar;
        VectorTextView vectorTextView2 = vectorTextView;
        j.g(vectorTextView2, "<this>");
        j.g(lVar, "iconForm");
        if (lVar.a() != null) {
            int h10 = lVar.h();
            int f10 = lVar.f();
            int g10 = lVar.g();
            CharSequence d10 = lVar.d();
            Integer valueOf = Integer.valueOf(lVar.c());
            if (valueOf.intValue() != Integer.MIN_VALUE) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!Boolean.valueOf(z10).booleanValue()) {
                valueOf = null;
            }
            zh.a aVar2 = r5;
            zh.a aVar3 = new zh.a((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, false, d10, Integer.valueOf(g10), Integer.valueOf(h10), Integer.valueOf(f10), (Integer) null, valueOf, (Integer) null, (Integer) null, (Integer) null, 238079, (DefaultConstructorMarker) null);
            int i10 = a.f24684a[lVar.e().ordinal()];
            if (i10 == 1) {
                aVar = aVar2;
                aVar.w(lVar.a());
                aVar.x(lVar.b());
            } else if (i10 == 2) {
                aVar = aVar2;
                aVar.y(lVar.a());
                aVar.z(lVar.b());
            } else if (i10 == 3) {
                aVar = aVar2;
                aVar.s(lVar.a());
                aVar.t(lVar.b());
            } else if (i10 != 4) {
                aVar = aVar2;
            } else {
                aVar = aVar2;
                aVar.u(lVar.a());
                aVar.v(lVar.b());
            }
            vectorTextView2.setDrawableTextViewParams(aVar);
        }
    }

    public static final /* synthetic */ void c(TextView textView, w wVar) {
        CharSequence charSequence;
        Unit unit;
        j.g(textView, "<this>");
        j.g(wVar, "textForm");
        boolean e10 = wVar.e();
        if (e10) {
            charSequence = d(wVar.b().toString());
        } else if (!e10) {
            charSequence = wVar.b();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(charSequence);
        textView.setTextSize(wVar.g());
        textView.setGravity(wVar.d());
        textView.setTextColor(wVar.c());
        Float f10 = wVar.f();
        if (f10 != null) {
            textView.setLineSpacing(f10.floatValue(), 1.0f);
        }
        Typeface i10 = wVar.i();
        if (i10 != null) {
            textView.setTypeface(i10);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            textView.setTypeface(textView.getTypeface(), wVar.h());
        }
        MovementMethod a10 = wVar.a();
        if (a10 != null) {
            textView.setMovementMethod(a10);
        }
    }

    private static final Spanned d(String str) {
        return Html.fromHtml(str, 0);
    }
}
