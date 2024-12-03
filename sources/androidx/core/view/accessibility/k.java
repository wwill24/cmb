package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class k {

    /* renamed from: d  reason: collision with root package name */
    private static int f4755d;

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f4756a;

    /* renamed from: b  reason: collision with root package name */
    public int f4757b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4758c = -1;

    public static class a {
        public static final a A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        public static final a B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, (CharSequence) null, (n) null, n.e.class);
        public static final a C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        public static final a D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        public static final a E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        public static final a F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        @NonNull
        public static final a G;
        @NonNull
        public static final a H;
        @NonNull
        public static final a I;
        @NonNull
        public static final a J;
        public static final a K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        public static final a L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, (CharSequence) null, (n) null, n.f.class);
        public static final a M;
        public static final a N;
        public static final a O;
        @NonNull
        public static final a P;
        @NonNull
        public static final a Q;
        @NonNull
        public static final a R;
        @NonNull
        public static final a S;
        @NonNull
        public static final a T;
        @NonNull
        public static final a U;

        /* renamed from: e  reason: collision with root package name */
        public static final a f4759e = new a(1, (CharSequence) null);

        /* renamed from: f  reason: collision with root package name */
        public static final a f4760f = new a(2, (CharSequence) null);

        /* renamed from: g  reason: collision with root package name */
        public static final a f4761g = new a(4, (CharSequence) null);

        /* renamed from: h  reason: collision with root package name */
        public static final a f4762h = new a(8, (CharSequence) null);

        /* renamed from: i  reason: collision with root package name */
        public static final a f4763i = new a(16, (CharSequence) null);

        /* renamed from: j  reason: collision with root package name */
        public static final a f4764j = new a(32, (CharSequence) null);

        /* renamed from: k  reason: collision with root package name */
        public static final a f4765k = new a(64, (CharSequence) null);

        /* renamed from: l  reason: collision with root package name */
        public static final a f4766l = new a(128, (CharSequence) null);

        /* renamed from: m  reason: collision with root package name */
        public static final a f4767m;

        /* renamed from: n  reason: collision with root package name */
        public static final a f4768n;

        /* renamed from: o  reason: collision with root package name */
        public static final a f4769o;

        /* renamed from: p  reason: collision with root package name */
        public static final a f4770p;

        /* renamed from: q  reason: collision with root package name */
        public static final a f4771q = new a(Opcodes.ACC_SYNTHETIC, (CharSequence) null);

        /* renamed from: r  reason: collision with root package name */
        public static final a f4772r = new a(8192, (CharSequence) null);

        /* renamed from: s  reason: collision with root package name */
        public static final a f4773s = new a(Opcodes.ACC_ENUM, (CharSequence) null);

        /* renamed from: t  reason: collision with root package name */
        public static final a f4774t = new a(32768, (CharSequence) null);

        /* renamed from: u  reason: collision with root package name */
        public static final a f4775u = new a(65536, (CharSequence) null);

        /* renamed from: v  reason: collision with root package name */
        public static final a f4776v = new a((int) Opcodes.ACC_DEPRECATED, (CharSequence) null, (Class<? extends n.a>) n.g.class);

        /* renamed from: w  reason: collision with root package name */
        public static final a f4777w = new a(Opcodes.ASM4, (CharSequence) null);

        /* renamed from: x  reason: collision with root package name */
        public static final a f4778x = new a(Opcodes.ASM8, (CharSequence) null);

        /* renamed from: y  reason: collision with root package name */
        public static final a f4779y = new a(1048576, (CharSequence) null);

        /* renamed from: z  reason: collision with root package name */
        public static final a f4780z = new a(2097152, (CharSequence) null, (Class<? extends n.a>) n.h.class);

        /* renamed from: a  reason: collision with root package name */
        final Object f4781a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4782b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<? extends n.a> f4783c;

        /* renamed from: d  reason: collision with root package name */
        protected final n f4784d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            Class<n.c> cls = n.c.class;
            Class<n.b> cls2 = n.b.class;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13 = null;
            f4767m = new a(256, (CharSequence) null, (Class<? extends n.a>) cls2);
            f4768n = new a(512, (CharSequence) null, (Class<? extends n.a>) cls2);
            f4769o = new a(1024, (CharSequence) null, (Class<? extends n.a>) cls);
            f4770p = new a(2048, (CharSequence) null, (Class<? extends n.a>) cls);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction = null;
            }
            G = new a(accessibilityAction, 16908358, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 29) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction2 = null;
            }
            H = new a(accessibilityAction2, 16908359, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 29) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction3 = null;
            }
            I = new a(accessibilityAction3, 16908360, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 29) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction4 = null;
            }
            J = new a(accessibilityAction4, 16908361, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 26) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction5 = null;
            }
            M = new a(accessibilityAction5, 16908354, (CharSequence) null, (n) null, n.d.class);
            if (i10 >= 28) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction6 = null;
            }
            N = new a(accessibilityAction6, 16908356, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 28) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction7 = null;
            }
            O = new a(accessibilityAction7, 16908357, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 30) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction8 = null;
            }
            P = new a(accessibilityAction8, 16908362, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 30) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            } else {
                accessibilityAction9 = null;
            }
            Q = new a(accessibilityAction9, 16908372, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 32) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction10 = null;
            }
            R = new a(accessibilityAction10, 16908373, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 32) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            } else {
                accessibilityAction11 = null;
            }
            S = new a(accessibilityAction11, 16908374, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 32) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            } else {
                accessibilityAction12 = null;
            }
            T = new a(accessibilityAction12, 16908375, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
            if (i10 >= 33) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            U = new a(accessibilityAction13, 16908376, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        }

        public a(int i10, CharSequence charSequence) {
            this((Object) null, i10, charSequence, (n) null, (Class<? extends n.a>) null);
        }

        public a a(CharSequence charSequence, n nVar) {
            return new a((Object) null, this.f4782b, charSequence, nVar, this.f4783c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4781a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4781a).getLabel();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.n r0 = r4.f4784d
                r1 = 0
                if (r0 == 0) goto L_0x003d
                r0 = 0
                java.lang.Class<? extends androidx.core.view.accessibility.n$a> r2 = r4.f4783c
                if (r2 == 0) goto L_0x0036
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x001e }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x001e }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x001e }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x001e }
                androidx.core.view.accessibility.n$a r1 = (androidx.core.view.accessibility.n.a) r1     // Catch:{ Exception -> 0x001e }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0036
            L_0x001d:
                r0 = r1
            L_0x001e:
                java.lang.Class<? extends androidx.core.view.accessibility.n$a> r6 = r4.f4783c
                if (r6 != 0) goto L_0x0025
                java.lang.String r6 = "null"
                goto L_0x0029
            L_0x0025:
                java.lang.String r6 = r6.getName()
            L_0x0029:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Failed to execute command with argument class ViewCommandArgument: "
                r1.append(r2)
                r1.append(r6)
            L_0x0036:
                androidx.core.view.accessibility.n r6 = r4.f4784d
                boolean r5 = r6.a(r5, r0)
                return r5
            L_0x003d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.k.a.d(android.view.View, android.os.Bundle):boolean");
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f4781a;
            if (obj2 == null) {
                if (aVar.f4781a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.f4781a)) {
                return false;
            } else {
                return true;
            }
        }

        public int hashCode() {
            Object obj = this.f4781a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public a(int i10, CharSequence charSequence, n nVar) {
            this((Object) null, i10, charSequence, nVar, (Class<? extends n.a>) null);
        }

        a(Object obj) {
            this(obj, 0, (CharSequence) null, (n) null, (Class<? extends n.a>) null);
        }

        private a(int i10, CharSequence charSequence, Class<? extends n.a> cls) {
            this((Object) null, i10, charSequence, (n) null, cls);
        }

        a(Object obj, int i10, CharSequence charSequence, n nVar, Class<? extends n.a> cls) {
            this.f4782b = i10;
            this.f4784d = nVar;
            if (obj == null) {
                this.f4781a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f4781a = obj;
            }
            this.f4783c = cls;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f4785a;

        b(Object obj) {
            this.f4785a = obj;
        }

        public static b a(int i10, int i11, boolean z10, int i12) {
            return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f4786a;

        c(Object obj) {
            this.f4786a = obj;
        }

        public static c a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    private k(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4756a = accessibilityNodeInfo;
    }

    public static k C0(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new k(accessibilityNodeInfo);
    }

    public static k N() {
        return C0(AccessibilityNodeInfo.obtain());
    }

    public static k O(View view) {
        return C0(AccessibilityNodeInfo.obtain(view));
    }

    public static k P(k kVar) {
        return C0(AccessibilityNodeInfo.obtain(kVar.f4756a));
    }

    private void T(View view) {
        SparseArray<WeakReference<ClickableSpan>> u10 = u(view);
        if (u10 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < u10.size(); i10++) {
                if (u10.valueAt(i10).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                u10.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    private void V(int i10, boolean z10) {
        Bundle r10 = r();
        if (r10 != null) {
            int i11 = r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            r10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    private void d(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    private void f() {
        this.f4756a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f4756a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f4756a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f4756a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private List<Integer> g(String str) {
        ArrayList<Integer> integerArrayList = this.f4756a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f4756a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String i(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case Opcodes.ACC_SYNTHETIC /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case Opcodes.ACC_ENUM /*16384*/:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case Opcodes.ACC_DEPRECATED /*131072*/:
                return "ACTION_SET_SELECTION";
            case Opcodes.ASM4 /*262144*/:
                return "ACTION_EXPAND";
            case Opcodes.ASM8 /*524288*/:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i10) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean k(int i10) {
        Bundle r10 = r();
        if (r10 != null && (r10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10) {
            return true;
        }
        return false;
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> s(View view) {
        SparseArray<WeakReference<ClickableSpan>> u10 = u(view);
        if (u10 != null) {
            return u10;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(t0.c.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> u(View view) {
        return (SparseArray) view.getTag(t0.c.tag_accessibility_clickable_spans);
    }

    private boolean y() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int z(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i10).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f4755d;
        f4755d = i11 + 1;
        return i11;
    }

    public boolean A() {
        return this.f4756a.isAccessibilityFocused();
    }

    public void A0(boolean z10) {
        this.f4756a.setVisibleToUser(z10);
    }

    public boolean B() {
        return this.f4756a.isCheckable();
    }

    public AccessibilityNodeInfo B0() {
        return this.f4756a;
    }

    public boolean C() {
        return this.f4756a.isChecked();
    }

    public boolean D() {
        return this.f4756a.isClickable();
    }

    public boolean E() {
        return this.f4756a.isEnabled();
    }

    public boolean F() {
        return this.f4756a.isFocusable();
    }

    public boolean G() {
        return this.f4756a.isFocused();
    }

    public boolean H() {
        return this.f4756a.isLongClickable();
    }

    public boolean I() {
        return this.f4756a.isPassword();
    }

    public boolean J() {
        return this.f4756a.isScrollable();
    }

    public boolean K() {
        return this.f4756a.isSelected();
    }

    public boolean L() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f4756a.isShowingHintText();
        }
        return k(4);
    }

    public boolean M() {
        return this.f4756a.isVisibleToUser();
    }

    public boolean Q(int i10, Bundle bundle) {
        return this.f4756a.performAction(i10, bundle);
    }

    public void R() {
        this.f4756a.recycle();
    }

    public boolean S(a aVar) {
        return this.f4756a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f4781a);
    }

    public void U(boolean z10) {
        this.f4756a.setAccessibilityFocused(z10);
    }

    @Deprecated
    public void W(Rect rect) {
        this.f4756a.setBoundsInParent(rect);
    }

    public void X(Rect rect) {
        this.f4756a.setBoundsInScreen(rect);
    }

    public void Y(boolean z10) {
        this.f4756a.setCheckable(z10);
    }

    public void Z(boolean z10) {
        this.f4756a.setChecked(z10);
    }

    public void a(int i10) {
        this.f4756a.addAction(i10);
    }

    public void a0(CharSequence charSequence) {
        this.f4756a.setClassName(charSequence);
    }

    public void b(a aVar) {
        this.f4756a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f4781a);
    }

    public void b0(boolean z10) {
        this.f4756a.setClickable(z10);
    }

    public void c(View view, int i10) {
        this.f4756a.addChild(view, i10);
    }

    public void c0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4756a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f4785a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void d0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4756a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f4786a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            T(view);
            ClickableSpan[] p10 = p(charSequence);
            if (p10 != null && p10.length > 0) {
                r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", t0.c.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> s10 = s(view);
                for (int i10 = 0; i10 < p10.length; i10++) {
                    int z10 = z(p10[i10], s10);
                    s10.put(z10, new WeakReference(p10[i10]));
                    d(p10[i10], (Spanned) charSequence, z10);
                }
            }
        }
    }

    public void e0(CharSequence charSequence) {
        this.f4756a.setContentDescription(charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4756a;
        if (accessibilityNodeInfo == null) {
            if (kVar.f4756a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(kVar.f4756a)) {
            return false;
        }
        if (this.f4758c == kVar.f4758c && this.f4757b == kVar.f4757b) {
            return true;
        }
        return false;
    }

    public void f0(boolean z10) {
        this.f4756a.setDismissable(z10);
    }

    public void g0(boolean z10) {
        this.f4756a.setEnabled(z10);
    }

    public List<a> h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f4756a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void h0(CharSequence charSequence) {
        this.f4756a.setError(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4756a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(boolean z10) {
        this.f4756a.setFocusable(z10);
    }

    @Deprecated
    public int j() {
        return this.f4756a.getActions();
    }

    public void j0(boolean z10) {
        this.f4756a.setFocused(z10);
    }

    public void k0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4756a.setHeading(z10);
        } else {
            V(2, z10);
        }
    }

    @Deprecated
    public void l(Rect rect) {
        this.f4756a.getBoundsInParent(rect);
    }

    public void l0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4756a.setHintText(charSequence);
        } else {
            this.f4756a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void m(Rect rect) {
        this.f4756a.getBoundsInScreen(rect);
    }

    public void m0(View view) {
        this.f4756a.setLabelFor(view);
    }

    public int n() {
        return this.f4756a.getChildCount();
    }

    public void n0(int i10) {
        this.f4756a.setMaxTextLength(i10);
    }

    public CharSequence o() {
        return this.f4756a.getClassName();
    }

    public void o0(CharSequence charSequence) {
        this.f4756a.setPackageName(charSequence);
    }

    public void p0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4756a.setPaneTitle(charSequence);
        } else {
            this.f4756a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public CharSequence q() {
        return this.f4756a.getContentDescription();
    }

    public void q0(View view) {
        this.f4757b = -1;
        this.f4756a.setParent(view);
    }

    public Bundle r() {
        return this.f4756a.getExtras();
    }

    public void r0(View view, int i10) {
        this.f4757b = i10;
        this.f4756a.setParent(view, i10);
    }

    public void s0(CharSequence charSequence) {
        this.f4756a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public CharSequence t() {
        return this.f4756a.getPackageName();
    }

    public void t0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4756a.setScreenReaderFocusable(z10);
        } else {
            V(1, z10);
        }
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb2.append("; boundsInParent: " + rect);
        m(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(t());
        sb2.append("; className: ");
        sb2.append(o());
        sb2.append("; text: ");
        sb2.append(v());
        sb2.append("; contentDescription: ");
        sb2.append(q());
        sb2.append("; viewId: ");
        sb2.append(x());
        sb2.append("; uniqueId: ");
        sb2.append(w());
        sb2.append("; checkable: ");
        sb2.append(B());
        sb2.append("; checked: ");
        sb2.append(C());
        sb2.append("; focusable: ");
        sb2.append(F());
        sb2.append("; focused: ");
        sb2.append(G());
        sb2.append("; selected: ");
        sb2.append(K());
        sb2.append("; clickable: ");
        sb2.append(D());
        sb2.append("; longClickable: ");
        sb2.append(H());
        sb2.append("; enabled: ");
        sb2.append(E());
        sb2.append("; password: ");
        sb2.append(I());
        sb2.append("; scrollable: " + J());
        sb2.append("; [");
        List<a> h10 = h();
        for (int i10 = 0; i10 < h10.size(); i10++) {
            a aVar = h10.get(i10);
            String i11 = i(aVar.b());
            if (i11.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                i11 = aVar.c().toString();
            }
            sb2.append(i11);
            if (i10 != h10.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void u0(boolean z10) {
        this.f4756a.setScrollable(z10);
    }

    public CharSequence v() {
        if (!y()) {
            return this.f4756a.getText();
        }
        List<Integer> g10 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> g11 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> g12 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> g13 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4756a.getText(), 0, this.f4756a.getText().length()));
        for (int i10 = 0; i10 < g10.size(); i10++) {
            spannableString.setSpan(new a(g13.get(i10).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), g10.get(i10).intValue(), g11.get(i10).intValue(), g12.get(i10).intValue());
        }
        return spannableString;
    }

    public void v0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4756a.setShowingHintText(z10);
        } else {
            V(4, z10);
        }
    }

    public String w() {
        if (androidx.core.os.a.c()) {
            return this.f4756a.getUniqueId();
        }
        return this.f4756a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void w0(View view, int i10) {
        this.f4758c = i10;
        this.f4756a.setSource(view, i10);
    }

    public String x() {
        return this.f4756a.getViewIdResourceName();
    }

    public void x0(CharSequence charSequence) {
        if (androidx.core.os.a.b()) {
            this.f4756a.setStateDescription(charSequence);
        } else {
            this.f4756a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void y0(CharSequence charSequence) {
        this.f4756a.setText(charSequence);
    }

    public void z0(View view) {
        this.f4756a.setTraversalAfter(view);
    }
}
