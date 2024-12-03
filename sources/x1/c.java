package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import java.util.Map;

public class c extends n {
    private static final String[] T = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> U = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> V = new C0219c(PointF.class, "topLeft");
    private static final Property<k, PointF> W = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> X = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> Y = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> Z = new g(PointF.class, "position");

    /* renamed from: a0  reason: collision with root package name */
    private static j f18363a0 = new j();
    private int[] Q = new int[2];
    private boolean R = false;
    private boolean S = false;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f18364a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f18365b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f18366c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f18367d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f18364a = viewGroup;
            this.f18365b = bitmapDrawable;
            this.f18366c = view;
            this.f18367d = f10;
        }

        public void onAnimationEnd(Animator animator) {
            d0.b(this.f18364a).b(this.f18365b);
            d0.g(this.f18366c, this.f18367d);
        }
    }

    class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f18369a = new Rect();

        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f18369a);
            Rect rect = this.f18369a;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* renamed from: b */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f18369a);
            this.f18369a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f18369a);
        }
    }

    /* renamed from: x1.c$c  reason: collision with other inner class name */
    class C0219c extends Property<k, PointF> {
        C0219c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            d0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            d0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            d0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f18370a;
        private k mViewBounds;

        h(k kVar) {
            this.f18370a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f18372a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f18373b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Rect f18374c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f18375d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f18376e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f18377f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f18378g;

        i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f18373b = view;
            this.f18374c = rect;
            this.f18375d = i10;
            this.f18376e = i11;
            this.f18377f = i12;
            this.f18378g = i13;
        }

        public void onAnimationCancel(Animator animator) {
            this.f18372a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f18372a) {
                n0.z0(this.f18373b, this.f18374c);
                d0.f(this.f18373b, this.f18375d, this.f18376e, this.f18377f, this.f18378g);
            }
        }
    }

    class j extends o {

        /* renamed from: a  reason: collision with root package name */
        boolean f18380a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f18381b;

        j(ViewGroup viewGroup) {
            this.f18381b = viewGroup;
        }

        public void a(@NonNull n nVar) {
            a0.c(this.f18381b, false);
            this.f18380a = true;
        }

        public void b(@NonNull n nVar) {
            a0.c(this.f18381b, true);
        }

        public void d(@NonNull n nVar) {
            a0.c(this.f18381b, false);
        }

        public void e(@NonNull n nVar) {
            if (!this.f18380a) {
                a0.c(this.f18381b, false);
            }
            nVar.W(this);
        }
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private int f18383a;

        /* renamed from: b  reason: collision with root package name */
        private int f18384b;

        /* renamed from: c  reason: collision with root package name */
        private int f18385c;

        /* renamed from: d  reason: collision with root package name */
        private int f18386d;

        /* renamed from: e  reason: collision with root package name */
        private View f18387e;

        /* renamed from: f  reason: collision with root package name */
        private int f18388f;

        /* renamed from: g  reason: collision with root package name */
        private int f18389g;

        k(View view) {
            this.f18387e = view;
        }

        private void b() {
            d0.f(this.f18387e, this.f18383a, this.f18384b, this.f18385c, this.f18386d);
            this.f18388f = 0;
            this.f18389g = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f18385c = Math.round(pointF.x);
            this.f18386d = Math.round(pointF.y);
            int i10 = this.f18389g + 1;
            this.f18389g = i10;
            if (this.f18388f == i10) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(PointF pointF) {
            this.f18383a = Math.round(pointF.x);
            this.f18384b = Math.round(pointF.y);
            int i10 = this.f18388f + 1;
            this.f18388f = i10;
            if (i10 == this.f18389g) {
                b();
            }
        }
    }

    private void l0(u uVar) {
        View view = uVar.f18493b;
        if (n0.W(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            uVar.f18492a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            uVar.f18492a.put("android:changeBounds:parent", uVar.f18493b.getParent());
            if (this.S) {
                uVar.f18493b.getLocationInWindow(this.Q);
                uVar.f18492a.put("android:changeBounds:windowX", Integer.valueOf(this.Q[0]));
                uVar.f18492a.put("android:changeBounds:windowY", Integer.valueOf(this.Q[1]));
            }
            if (this.R) {
                uVar.f18492a.put("android:changeBounds:clip", n0.u(view));
            }
        }
    }

    private boolean m0(View view, View view2) {
        if (!this.S) {
            return true;
        }
        u y10 = y(view, true);
        if (y10 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == y10.f18493b) {
            return true;
        }
        return false;
    }

    @NonNull
    public String[] I() {
        return T;
    }

    public void h(@NonNull u uVar) {
        l0(uVar);
    }

    public void k(@NonNull u uVar) {
        l0(uVar);
    }

    public Animator q(@NonNull ViewGroup viewGroup, u uVar, u uVar2) {
        int i10;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i11;
        Rect rect;
        Rect rect2;
        ObjectAnimator objectAnimator2;
        u uVar3 = uVar;
        u uVar4 = uVar2;
        if (uVar3 == null || uVar4 == null) {
            return null;
        }
        Map<String, Object> map = uVar3.f18492a;
        Map<String, Object> map2 = uVar4.f18492a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = uVar4.f18493b;
        if (m0(viewGroup2, viewGroup3)) {
            Rect rect3 = (Rect) uVar3.f18492a.get("android:changeBounds:bounds");
            Rect rect4 = (Rect) uVar4.f18492a.get("android:changeBounds:bounds");
            int i12 = rect3.left;
            int i13 = rect4.left;
            int i14 = rect3.top;
            int i15 = rect4.top;
            int i16 = rect3.right;
            int i17 = rect4.right;
            int i18 = rect3.bottom;
            int i19 = rect4.bottom;
            int i20 = i16 - i12;
            int i21 = i18 - i14;
            int i22 = i17 - i13;
            int i23 = i19 - i15;
            View view3 = view2;
            Rect rect5 = (Rect) uVar3.f18492a.get("android:changeBounds:clip");
            Rect rect6 = (Rect) uVar4.f18492a.get("android:changeBounds:clip");
            if ((i20 == 0 || i21 == 0) && (i22 == 0 || i23 == 0)) {
                i10 = 0;
            } else {
                if (i12 == i13 && i14 == i15) {
                    i10 = 0;
                } else {
                    i10 = 1;
                }
                if (!(i16 == i17 && i18 == i19)) {
                    i10++;
                }
            }
            if ((rect5 != null && !rect5.equals(rect6)) || (rect5 == null && rect6 != null)) {
                i10++;
            }
            if (i10 <= 0) {
                return null;
            }
            Rect rect7 = rect6;
            Rect rect8 = rect5;
            if (!this.R) {
                view = view3;
                d0.f(view, i12, i14, i16, i18);
                if (i10 == 2) {
                    if (i20 == i22 && i21 == i23) {
                        animator = f.a(view, Z, A().a((float) i12, (float) i14, (float) i13, (float) i15));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a10 = f.a(kVar, V, A().a((float) i12, (float) i14, (float) i13, (float) i15));
                        ObjectAnimator a11 = f.a(kVar, W, A().a((float) i16, (float) i18, (float) i17, (float) i19));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a10, a11});
                        animatorSet.addListener(new h(kVar));
                        animator = animatorSet;
                    }
                } else if (i12 == i13 && i14 == i15) {
                    animator = f.a(view, X, A().a((float) i16, (float) i18, (float) i17, (float) i19));
                } else {
                    animator = f.a(view, Y, A().a((float) i12, (float) i14, (float) i13, (float) i15));
                }
            } else {
                view = view3;
                d0.f(view, i12, i14, Math.max(i20, i22) + i12, Math.max(i21, i23) + i14);
                if (i12 == i13 && i14 == i15) {
                    objectAnimator = null;
                } else {
                    objectAnimator = f.a(view, Z, A().a((float) i12, (float) i14, (float) i13, (float) i15));
                }
                if (rect8 == null) {
                    i11 = 0;
                    rect = new Rect(0, 0, i20, i21);
                } else {
                    i11 = 0;
                    rect = rect8;
                }
                if (rect7 == null) {
                    rect2 = new Rect(i11, i11, i22, i23);
                } else {
                    rect2 = rect7;
                }
                if (!rect.equals(rect2)) {
                    n0.z0(view, rect);
                    j jVar = f18363a0;
                    Object[] objArr = new Object[2];
                    objArr[i11] = rect;
                    objArr[1] = rect2;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    ofObject.addListener(new i(view, rect7, i13, i15, i17, i19));
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = t.c(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                a0.c(viewGroup4, true);
                a(new j(viewGroup4));
            }
            return animator;
        }
        int intValue = ((Integer) uVar3.f18492a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) uVar3.f18492a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) uVar4.f18492a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) uVar4.f18492a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.Q);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c10 = d0.c(view2);
        d0.g(view2, 0.0f);
        d0.b(viewGroup).a(bitmapDrawable);
        g A = A();
        int[] iArr = this.Q;
        int i24 = iArr[0];
        int i25 = iArr[1];
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{h.a(U, A.a((float) (intValue - i24), (float) (intValue2 - i25), (float) (intValue3 - i24), (float) (intValue4 - i25)))});
        ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c10));
        return ofPropertyValuesHolder;
    }
}
