package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4787a;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final l f4788a;

        a(l lVar) {
            this.f4788a = lVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            k b10 = this.f4788a.b(i10);
            if (b10 == null) {
                return null;
            }
            return b10.B0();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<k> c10 = this.f4788a.c(str, i10);
            if (c10 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c10.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(c10.get(i11).B0());
            }
            return arrayList;
        }

        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f4788a.f(i10, i11, bundle);
        }
    }

    static class b extends a {
        b(l lVar) {
            super(lVar);
        }

        public AccessibilityNodeInfo findFocus(int i10) {
            k d10 = this.f4788a.d(i10);
            if (d10 == null) {
                return null;
            }
            return d10.B0();
        }
    }

    static class c extends b {
        c(l lVar) {
            super(lVar);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f4788a.a(i10, k.C0(accessibilityNodeInfo), str, bundle);
        }
    }

    public l() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4787a = new c(this);
        } else {
            this.f4787a = new b(this);
        }
    }

    public void a(int i10, @NonNull k kVar, @NonNull String str, Bundle bundle) {
    }

    public k b(int i10) {
        return null;
    }

    public List<k> c(@NonNull String str, int i10) {
        return null;
    }

    public k d(int i10) {
        return null;
    }

    public Object e() {
        return this.f4787a;
    }

    public boolean f(int i10, int i11, Bundle bundle) {
        return false;
    }

    public l(Object obj) {
        this.f4787a = obj;
    }
}
