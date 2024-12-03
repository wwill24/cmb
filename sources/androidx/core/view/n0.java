package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.View$OnUnhandledKeyEventListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.core.view.a;
import androidx.core.view.accessibility.k;
import androidx.core.view.k2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f4876a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static WeakHashMap<View, e2> f4877b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Field f4878c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f4879d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4880e = {t0.c.accessibility_custom_action_0, t0.c.accessibility_custom_action_1, t0.c.accessibility_custom_action_2, t0.c.accessibility_custom_action_3, t0.c.accessibility_custom_action_4, t0.c.accessibility_custom_action_5, t0.c.accessibility_custom_action_6, t0.c.accessibility_custom_action_7, t0.c.accessibility_custom_action_8, t0.c.accessibility_custom_action_9, t0.c.accessibility_custom_action_10, t0.c.accessibility_custom_action_11, t0.c.accessibility_custom_action_12, t0.c.accessibility_custom_action_13, t0.c.accessibility_custom_action_14, t0.c.accessibility_custom_action_15, t0.c.accessibility_custom_action_16, t0.c.accessibility_custom_action_17, t0.c.accessibility_custom_action_18, t0.c.accessibility_custom_action_19, t0.c.accessibility_custom_action_20, t0.c.accessibility_custom_action_21, t0.c.accessibility_custom_action_22, t0.c.accessibility_custom_action_23, t0.c.accessibility_custom_action_24, t0.c.accessibility_custom_action_25, t0.c.accessibility_custom_action_26, t0.c.accessibility_custom_action_27, t0.c.accessibility_custom_action_28, t0.c.accessibility_custom_action_29, t0.c.accessibility_custom_action_30, t0.c.accessibility_custom_action_31};

    /* renamed from: f  reason: collision with root package name */
    private static final j0 f4881f = new m0();

    /* renamed from: g  reason: collision with root package name */
    private static final e f4882g = new e();

    class a extends f<Boolean> {
        a(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(@NonNull View view) {
            return Boolean.valueOf(q.d(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(@NonNull View view, Boolean bool) {
            q.i(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    class b extends f<CharSequence> {
        b(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return q.b(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            q.h(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class c extends f<CharSequence> {
        c(int i10, Class cls, int i11, int i12) {
            super(i10, cls, i11, i12);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public CharSequence d(View view) {
            return s.a(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, CharSequence charSequence) {
            s.c(view, charSequence);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    class d extends f<Boolean> {
        d(int i10, Class cls, int i11) {
            super(i10, cls, i11);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Boolean d(View view) {
            return Boolean.valueOf(q.c(view));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public void e(View view, Boolean bool) {
            q.g(view, bool.booleanValue());
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public boolean h(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f4883a = new WeakHashMap<>();

        e() {
        }

        private void b(View view, boolean z10) {
            boolean z11;
            int i10;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10 != z11) {
                if (z11) {
                    i10 = 16;
                } else {
                    i10 = 32;
                }
                n0.b0(view, i10);
                this.f4883a.put(view, Boolean.valueOf(z11));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            h.o(view.getViewTreeObserver(), this);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            boolean z10;
            WeakHashMap<View, Boolean> weakHashMap = this.f4883a;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            weakHashMap.put(view, Boolean.valueOf(z10));
            view.addOnAttachStateChangeListener(this);
            if (k.b(view)) {
                c(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(View view) {
            this.f4883a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.f4883a.entrySet()) {
                    b((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f4884a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f4885b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4886c;

        /* renamed from: d  reason: collision with root package name */
        private final int f4887d;

        f(int i10, Class<T> cls, int i11) {
            this(i10, cls, 0, i11);
        }

        private boolean b() {
            return true;
        }

        private boolean c() {
            return Build.VERSION.SDK_INT >= this.f4886c;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Boolean bool, Boolean bool2) {
            boolean z10;
            boolean z11;
            if (bool == null || !bool.booleanValue()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (bool2 == null || !bool2.booleanValue()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10 == z11) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract T d(View view);

        /* access modifiers changed from: package-private */
        public abstract void e(View view, T t10);

        /* access modifiers changed from: package-private */
        public T f(View view) {
            if (c()) {
                return d(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f4884a);
            if (this.f4885b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(View view, T t10) {
            if (c()) {
                e(view, t10);
            } else if (b() && h(f(view), t10)) {
                n0.j(view);
                view.setTag(this.f4884a, t10);
                n0.b0(view, this.f4887d);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean h(T t10, T t11);

        f(int i10, Class<T> cls, int i11, int i12) {
            this.f4884a = i10;
            this.f4885b = cls;
            this.f4887d = i11;
            this.f4886c = i12;
        }
    }

    static class g {
        static boolean a(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    static class h {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i10, Bundle bundle) {
            return view.performAccessibilityAction(i10, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i10, int i11, int i12, int i13) {
            view.postInvalidateOnAnimation(i10, i11, i12, i13);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j10) {
            view.postOnAnimationDelayed(runnable, j10);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z10) {
            view.setHasTransientState(z10);
        }

        static void s(View view, int i10) {
            view.setImportantForAccessibility(i10);
        }
    }

    static class i {
        static int a() {
            return View.generateViewId();
        }

        static Display b(@NonNull View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i10) {
            view.setLabelFor(i10);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i10) {
            view.setLayoutDirection(i10);
        }

        static void k(View view, int i10, int i11, int i12, int i13) {
            view.setPaddingRelative(i10, i11, i12, i13);
        }
    }

    static class j {
        static Rect a(@NonNull View view) {
            return view.getClipBounds();
        }

        static boolean b(@NonNull View view) {
            return view.isInLayout();
        }

        static void c(@NonNull View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static class k {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(@NonNull View view) {
            return view.isLaidOut();
        }

        static boolean d(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }

        static void f(View view, int i10) {
            view.setAccessibilityLiveRegion(i10);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i10) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }

    static class l {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    private static class m {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a  reason: collision with root package name */
            k2 f4888a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ View f4889b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ h0 f4890c;

            a(View view, h0 h0Var) {
                this.f4889b = view;
                this.f4890c = h0Var;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                k2 v10 = k2.v(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 30) {
                    m.a(windowInsets, this.f4889b);
                    if (v10.equals(this.f4888a)) {
                        return this.f4890c.a(view, v10).t();
                    }
                }
                this.f4888a = v10;
                k2 a10 = this.f4890c.a(view, v10);
                if (i10 >= 30) {
                    return a10.t();
                }
                n0.p0(view);
                return a10.t();
            }
        }

        static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(t0.c.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static k2 b(@NonNull View view, @NonNull k2 k2Var, @NonNull Rect rect) {
            WindowInsets t10 = k2Var.t();
            if (t10 != null) {
                return k2.v(view.computeSystemWindowInsets(t10, rect), view);
            }
            rect.setEmpty();
            return k2Var;
        }

        static boolean c(@NonNull View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        static boolean d(@NonNull View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static k2 j(@NonNull View view) {
            return k2.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(@NonNull View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f10) {
            view.setElevation(f10);
        }

        static void t(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        static void u(@NonNull View view, h0 h0Var) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(t0.c.tag_on_apply_window_listener, h0Var);
            }
            if (h0Var == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(t0.c.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, h0Var));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f10) {
            view.setTranslationZ(f10);
        }

        static void x(@NonNull View view, float f10) {
            view.setZ(f10);
        }

        static boolean y(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class n {
        public static k2 a(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            k2 u10 = k2.u(rootWindowInsets);
            u10.r(u10);
            u10.d(view.getRootView());
            return u10;
        }

        static int b(@NonNull View view) {
            return view.getScrollIndicators();
        }

        static void c(@NonNull View view, int i10) {
            view.setScrollIndicators(i10);
        }

        static void d(@NonNull View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }
    }

    static class o {
        static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(@NonNull View view, ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class p {
        static void a(@NonNull View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        static int b(View view) {
            return view.getImportantForAutofill();
        }

        static int c(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        static boolean d(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        static boolean e(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        static boolean g(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View h(@NonNull View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        static boolean i(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        static void j(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(@NonNull View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        static void l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        static void m(@NonNull View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        static void n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        static void o(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class q {
        static void a(@NonNull View view, @NonNull v vVar) {
            int i10 = t0.c.tag_unhandled_key_listeners;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(i10);
            if (gVar == null) {
                gVar = new androidx.collection.g();
                view.setTag(i10, gVar);
            }
            Objects.requireNonNull(vVar);
            l1 l1Var = new l1(vVar);
            gVar.put(vVar, l1Var);
            view.addOnUnhandledKeyEventListener(l1Var);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(@NonNull View view, @NonNull v vVar) {
            View$OnUnhandledKeyEventListener view$OnUnhandledKeyEventListener;
            androidx.collection.g gVar = (androidx.collection.g) view.getTag(t0.c.tag_unhandled_key_listeners);
            if (gVar != null && (view$OnUnhandledKeyEventListener = (View$OnUnhandledKeyEventListener) gVar.get(vVar)) != null) {
                view.removeOnUnhandledKeyEventListener(view$OnUnhandledKeyEventListener);
            }
        }

        static <T> T f(View view, int i10) {
            return view.requireViewById(i10);
        }

        static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }
    }

    private static class r {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class s {
        static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static s2 b(@NonNull View view) {
            WindowInsetsController a10 = view.getWindowInsetsController();
            if (a10 != null) {
                return s2.e(a10);
            }
            return null;
        }

        static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class t {
        public static String[] a(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static c b(@NonNull View view, @NonNull c cVar) {
            ContentInfo f10 = cVar.f();
            ContentInfo a10 = view.performReceiveContent(f10);
            if (a10 == null) {
                return null;
            }
            if (a10 == f10) {
                return cVar;
            }
            return c.g(a10);
        }

        public static void c(@NonNull View view, String[] strArr, i0 i0Var) {
            if (i0Var == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new u(i0Var));
            }
        }
    }

    private static final class u implements OnReceiveContentListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final i0 f4891a;

        u(@NonNull i0 i0Var) {
            this.f4891a = i0Var;
        }

        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            c g10 = c.g(contentInfo);
            c a10 = this.f4891a.a(view, g10);
            if (a10 == null) {
                return null;
            }
            if (a10 == g10) {
                return contentInfo;
            }
            return a10.f();
        }
    }

    public interface v {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    static class w {

        /* renamed from: d  reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f4892d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f4893a = null;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f4894b = null;

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<KeyEvent> f4895c = null;

        w() {
        }

        static w a(View view) {
            int i10 = t0.c.tag_unhandled_key_event_manager;
            w wVar = (w) view.getTag(i10);
            if (wVar != null) {
                return wVar;
            }
            w wVar2 = new w();
            view.setTag(i10, wVar2);
            return wVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f4893a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c10 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c10 != null) {
                            return c10;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f4894b == null) {
                this.f4894b = new SparseArray<>();
            }
            return this.f4894b;
        }

        private boolean e(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(t0.c.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((v) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f4893a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f4892d;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.f4893a == null) {
                        this.f4893a = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = f4892d;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.f4893a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f4893a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c10 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c10 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(c10));
                }
            }
            if (c10 != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean f(KeyEvent keyEvent) {
            int indexOfKey;
            WeakReference<KeyEvent> weakReference = this.f4895c;
            if (weakReference != null && weakReference.get() == keyEvent) {
                return false;
            }
            this.f4895c = new WeakReference<>(keyEvent);
            WeakReference weakReference2 = null;
            SparseArray<WeakReference<View>> d10 = d();
            if (keyEvent.getAction() == 1 && (indexOfKey = d10.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference2 = d10.valueAt(indexOfKey);
                d10.removeAt(indexOfKey);
            }
            if (weakReference2 == null) {
                weakReference2 = d10.get(keyEvent.getKeyCode());
            }
            if (weakReference2 == null) {
                return false;
            }
            View view = (View) weakReference2.get();
            if (view != null && n0.V(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static int A(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return p.b(view);
        }
        return 0;
    }

    public static void A0(@NonNull View view, float f10) {
        m.s(view, f10);
    }

    public static int B(@NonNull View view) {
        return i.d(view);
    }

    @Deprecated
    public static void B0(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    public static int C(@NonNull View view) {
        return h.d(view);
    }

    public static void C0(@NonNull View view, boolean z10) {
        h.r(view, z10);
    }

    public static int D(@NonNull View view) {
        return h.e(view);
    }

    public static void D0(@NonNull View view, int i10) {
        h.s(view, i10);
    }

    public static String[] E(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return t.a(view);
        }
        return (String[]) view.getTag(t0.c.tag_on_receive_content_mime_types);
    }

    public static void E0(@NonNull View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.l(view, i10);
        }
    }

    public static int F(@NonNull View view) {
        return i.e(view);
    }

    public static void F0(@NonNull View view, int i10) {
        i.h(view, i10);
    }

    public static int G(@NonNull View view) {
        return i.f(view);
    }

    public static void G0(@NonNull View view, boolean z10) {
        m.t(view, z10);
    }

    public static ViewParent H(@NonNull View view) {
        return h.f(view);
    }

    public static void H0(@NonNull View view, h0 h0Var) {
        m.u(view, h0Var);
    }

    public static k2 I(@NonNull View view) {
        return n.a(view);
    }

    public static void I0(@NonNull View view, int i10, int i11, int i12, int i13) {
        i.k(view, i10, i11, i12, i13);
    }

    public static CharSequence J(@NonNull View view) {
        return R0().f(view);
    }

    public static void J0(@NonNull View view, l0 l0Var) {
        Object obj;
        if (l0Var != null) {
            obj = l0Var.a();
        } else {
            obj = null;
        }
        o.d(view, (PointerIcon) obj);
    }

    public static String K(@NonNull View view) {
        return m.k(view);
    }

    public static void K0(@NonNull View view, boolean z10) {
        r0().g(view, Boolean.valueOf(z10));
    }

    @Deprecated
    public static float L(View view) {
        return view.getTranslationY();
    }

    public static void L0(@NonNull View view, int i10, int i11) {
        n.d(view, i10, i11);
    }

    public static float M(@NonNull View view) {
        return m.l(view);
    }

    public static void M0(@NonNull View view, CharSequence charSequence) {
        R0().g(view, charSequence);
    }

    @Deprecated
    public static s2 N(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return s.b(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return i2.a(window, view);
                }
                return null;
            }
        }
        return null;
    }

    public static void N0(@NonNull View view, String str) {
        m.v(view, str);
    }

    @Deprecated
    public static int O(@NonNull View view) {
        return h.g(view);
    }

    public static void O0(@NonNull View view, float f10) {
        m.w(view, f10);
    }

    public static float P(@NonNull View view) {
        return m.m(view);
    }

    private static void P0(View view) {
        if (z(view) == 0) {
            D0(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (z((View) parent) == 4) {
                D0(view, 2);
                return;
            }
        }
    }

    public static boolean Q(@NonNull View view) {
        return m(view) != null;
    }

    public static void Q0(@NonNull View view, float f10) {
        m.x(view, f10);
    }

    public static boolean R(@NonNull View view) {
        return g.a(view);
    }

    private static f<CharSequence> R0() {
        return new c(t0.c.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean S(@NonNull View view) {
        return h.h(view);
    }

    public static void S0(@NonNull View view) {
        m.z(view);
    }

    public static boolean T(@NonNull View view) {
        return h.i(view);
    }

    public static boolean U(@NonNull View view) {
        Boolean f10 = b().f(view);
        if (f10 == null || !f10.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean V(@NonNull View view) {
        return k.b(view);
    }

    public static boolean W(@NonNull View view) {
        return k.c(view);
    }

    public static boolean X(@NonNull View view) {
        return m.p(view);
    }

    public static boolean Y(@NonNull View view) {
        return i.g(view);
    }

    public static boolean Z(@NonNull View view) {
        Boolean f10 = r0().f(view);
        if (f10 == null || !f10.booleanValue()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ c a0(c cVar) {
        return cVar;
    }

    private static f<Boolean> b() {
        return new d(t0.c.tag_accessibility_heading, Boolean.class, 28);
    }

    static void b0(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (p(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            int i11 = 32;
            if (o(view) != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = 2048;
                }
                obtain.setEventType(i11);
                k.g(obtain, i10);
                if (z10) {
                    obtain.getText().add(p(view));
                    P0(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                k.g(obtain2, i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(p(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    k.e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(view.getParent().getClass().getSimpleName());
                    sb2.append(" does not fully implement ViewParent");
                }
            }
        }
    }

    public static int c(@NonNull View view, @NonNull CharSequence charSequence, @NonNull androidx.core.view.accessibility.n nVar) {
        int r10 = r(view, charSequence);
        if (r10 != -1) {
            d(view, new k.a(r10, charSequence, nVar));
        }
        return r10;
    }

    public static void c0(@NonNull View view, int i10) {
        view.offsetLeftAndRight(i10);
    }

    private static void d(@NonNull View view, @NonNull k.a aVar) {
        j(view);
        n0(aVar.b(), view);
        q(view).add(aVar);
        b0(view, 0);
    }

    public static void d0(@NonNull View view, int i10) {
        view.offsetTopAndBottom(i10);
    }

    @NonNull
    public static e2 e(@NonNull View view) {
        if (f4877b == null) {
            f4877b = new WeakHashMap<>();
        }
        e2 e2Var = f4877b.get(view);
        if (e2Var != null) {
            return e2Var;
        }
        e2 e2Var2 = new e2(view);
        f4877b.put(view, e2Var2);
        return e2Var2;
    }

    @NonNull
    public static k2 e0(@NonNull View view, @NonNull k2 k2Var) {
        WindowInsets t10 = k2Var.t();
        if (t10 != null) {
            WindowInsets b10 = l.b(view, t10);
            if (!b10.equals(t10)) {
                return k2.v(b10, view);
            }
        }
        return k2Var;
    }

    @NonNull
    public static k2 f(@NonNull View view, @NonNull k2 k2Var, @NonNull Rect rect) {
        return m.b(view, k2Var, rect);
    }

    public static void f0(@NonNull View view, @NonNull androidx.core.view.accessibility.k kVar) {
        view.onInitializeAccessibilityNodeInfo(kVar.B0());
    }

    @NonNull
    public static k2 g(@NonNull View view, @NonNull k2 k2Var) {
        WindowInsets t10 = k2Var.t();
        if (t10 != null) {
            WindowInsets a10 = l.a(view, t10);
            if (!a10.equals(t10)) {
                return k2.v(a10, view);
            }
        }
        return k2Var;
    }

    private static f<CharSequence> g0() {
        return new b(t0.c.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).b(view, keyEvent);
    }

    public static boolean h0(@NonNull View view, int i10, Bundle bundle) {
        return h.j(view, i10, bundle);
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return w.a(view).f(keyEvent);
    }

    public static c i0(@NonNull View view, @NonNull c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("performReceiveContent: ");
            sb2.append(cVar);
            sb2.append(", view=");
            sb2.append(view.getClass().getSimpleName());
            sb2.append("[");
            sb2.append(view.getId());
            sb2.append("]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return t.b(view, cVar);
        }
        i0 i0Var = (i0) view.getTag(t0.c.tag_on_receive_content_listener);
        if (i0Var == null) {
            return x(view).a(cVar);
        }
        c a10 = i0Var.a(view, cVar);
        if (a10 == null) {
            return null;
        }
        return x(view).a(a10);
    }

    static void j(@NonNull View view) {
        a l10 = l(view);
        if (l10 == null) {
            l10 = new a();
        }
        s0(view, l10);
    }

    public static void j0(@NonNull View view) {
        h.k(view);
    }

    public static int k() {
        return i.a();
    }

    public static void k0(@NonNull View view, @NonNull Runnable runnable) {
        h.m(view, runnable);
    }

    public static a l(@NonNull View view) {
        View.AccessibilityDelegate m10 = m(view);
        if (m10 == null) {
            return null;
        }
        if (m10 instanceof a.C0044a) {
            return ((a.C0044a) m10).f4750a;
        }
        return new a(m10);
    }

    @SuppressLint({"LambdaLast"})
    public static void l0(@NonNull View view, @NonNull Runnable runnable, long j10) {
        h.n(view, runnable, j10);
    }

    private static View.AccessibilityDelegate m(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return r.a(view);
        }
        return n(view);
    }

    public static void m0(@NonNull View view, int i10) {
        n0(i10, view);
        b0(view, 0);
    }

    private static View.AccessibilityDelegate n(@NonNull View view) {
        if (f4879d) {
            return null;
        }
        if (f4878c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f4878c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f4879d = true;
                return null;
            }
        }
        try {
            Object obj = f4878c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f4879d = true;
            return null;
        }
    }

    private static void n0(int i10, View view) {
        List<k.a> q10 = q(view);
        for (int i11 = 0; i11 < q10.size(); i11++) {
            if (q10.get(i11).b() == i10) {
                q10.remove(i11);
                return;
            }
        }
    }

    public static int o(@NonNull View view) {
        return k.a(view);
    }

    public static void o0(@NonNull View view, @NonNull k.a aVar, CharSequence charSequence, androidx.core.view.accessibility.n nVar) {
        if (nVar == null && charSequence == null) {
            m0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, nVar));
        }
    }

    public static CharSequence p(@NonNull View view) {
        return g0().f(view);
    }

    public static void p0(@NonNull View view) {
        l.c(view);
    }

    private static List<k.a> q(View view) {
        int i10 = t0.c.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    public static void q0(@NonNull View view, @SuppressLint({"ContextFirst"}) @NonNull Context context, @NonNull int[] iArr, AttributeSet attributeSet, @NonNull TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            r.c(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    private static int r(View view, @NonNull CharSequence charSequence) {
        boolean z10;
        List<k.a> q10 = q(view);
        for (int i10 = 0; i10 < q10.size(); i10++) {
            if (TextUtils.equals(charSequence, q10.get(i10).c())) {
                return q10.get(i10).b();
            }
        }
        int i11 = -1;
        int i12 = 0;
        while (true) {
            int[] iArr = f4880e;
            if (i12 >= iArr.length || i11 != -1) {
                return i11;
            }
            int i13 = iArr[i12];
            boolean z11 = true;
            for (int i14 = 0; i14 < q10.size(); i14++) {
                if (q10.get(i14).b() != i13) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 &= z10;
            }
            if (z11) {
                i11 = i13;
            }
            i12++;
        }
        return i11;
    }

    private static f<Boolean> r0() {
        return new a(t0.c.tag_screen_reader_focusable, Boolean.class, 28);
    }

    public static ColorStateList s(@NonNull View view) {
        return m.g(view);
    }

    public static void s0(@NonNull View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (m(view) instanceof a.C0044a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.d();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static PorterDuff.Mode t(@NonNull View view) {
        return m.h(view);
    }

    public static void t0(@NonNull View view, boolean z10) {
        b().g(view, Boolean.valueOf(z10));
    }

    public static Rect u(@NonNull View view) {
        return j.a(view);
    }

    public static void u0(@NonNull View view, int i10) {
        k.f(view, i10);
    }

    public static Display v(@NonNull View view) {
        return i.b(view);
    }

    public static void v0(@NonNull View view, CharSequence charSequence) {
        g0().g(view, charSequence);
        if (charSequence != null) {
            f4882g.a(view);
        } else {
            f4882g.d(view);
        }
    }

    public static float w(@NonNull View view) {
        return m.i(view);
    }

    public static void w0(@NonNull View view, Drawable drawable) {
        h.q(view, drawable);
    }

    private static j0 x(@NonNull View view) {
        if (view instanceof j0) {
            return (j0) view;
        }
        return f4881f;
    }

    public static void x0(@NonNull View view, ColorStateList colorStateList) {
        m.q(view, colorStateList);
    }

    public static boolean y(@NonNull View view) {
        return h.b(view);
    }

    public static void y0(@NonNull View view, PorterDuff.Mode mode) {
        m.r(view, mode);
    }

    public static int z(@NonNull View view) {
        return h.c(view);
    }

    public static void z0(@NonNull View view, Rect rect) {
        j.c(view, rect);
    }
}
