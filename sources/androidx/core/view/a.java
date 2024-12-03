package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.l;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import t0.c;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final View.AccessibilityDelegate f4747c = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    private final View.AccessibilityDelegate f4748a;

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f4749b;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    static final class C0044a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f4750a;

        C0044a(a aVar) {
            this.f4750a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f4750a.a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            l b10 = this.f4750a.b(view);
            if (b10 != null) {
                return (AccessibilityNodeProvider) b10.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4750a.f(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            k C0 = k.C0(accessibilityNodeInfo);
            C0.t0(n0.Z(view));
            C0.k0(n0.U(view));
            C0.p0(n0.p(view));
            C0.x0(n0.J(view));
            this.f4750a.g(view, C0);
            C0.e(accessibilityNodeInfo.getText(), view);
            List<k.a> c10 = a.c(view);
            for (int i10 = 0; i10 < c10.size(); i10++) {
                C0.b(c10.get(i10));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f4750a.h(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f4750a.i(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f4750a.j(view, i10, bundle);
        }

        public void sendAccessibilityEvent(View view, int i10) {
            this.f4750a.l(view, i10);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f4750a.m(view, accessibilityEvent);
        }
    }

    static class b {
        static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i10, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i10, bundle);
        }
    }

    public a() {
        this(f4747c);
    }

    static List<k.a> c(View view) {
        List<k.a> list = (List) view.getTag(c.tag_accessibility_actions);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] p10 = k.p(view.createAccessibilityNodeInfo().getText());
            int i10 = 0;
            while (p10 != null && i10 < p10.length) {
                if (clickableSpan.equals(p10[i10])) {
                    return true;
                }
                i10++;
            }
        }
        return false;
    }

    private boolean k(int i10, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(c.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i10)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f4748a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public l b(@NonNull View view) {
        AccessibilityNodeProvider a10 = b.a(this.f4748a, view);
        if (a10 != null) {
            return new l(a10);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate d() {
        return this.f4749b;
    }

    public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f4748a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(@NonNull View view, @NonNull k kVar) {
        this.f4748a.onInitializeAccessibilityNodeInfo(view, kVar.B0());
    }

    public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f4748a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.f4748a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(@NonNull View view, int i10, Bundle bundle) {
        List<k.a> c10 = c(view);
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= c10.size()) {
                break;
            }
            k.a aVar = c10.get(i11);
            if (aVar.b() == i10) {
                z10 = aVar.d(view, bundle);
                break;
            }
            i11++;
        }
        if (!z10) {
            z10 = b.b(this.f4748a, view, i10, bundle);
        }
        if (z10 || i10 != c.accessibility_action_clickable_span || bundle == null) {
            return z10;
        }
        return k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void l(@NonNull View view, int i10) {
        this.f4748a.sendAccessibilityEvent(view, i10);
    }

    public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.f4748a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.f4748a = accessibilityDelegate;
        this.f4749b = new C0044a(this);
    }
}
