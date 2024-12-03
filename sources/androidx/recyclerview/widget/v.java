package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.accessibility.l;
import androidx.core.view.n0;
import java.util.Map;
import java.util.WeakHashMap;

public class v extends androidx.core.view.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f6713d;

    /* renamed from: e  reason: collision with root package name */
    private final a f6714e;

    public static class a extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        final v f6715d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, androidx.core.view.a> f6716e = new WeakHashMap();

        public a(@NonNull v vVar) {
            this.f6715d = vVar;
        }

        public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        public l b(@NonNull View view) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                return aVar.b(view);
            }
            return super.b(view);
        }

        public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        public void g(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull k kVar) {
            if (this.f6715d.o() || this.f6715d.f6713d.getLayoutManager() == null) {
                super.g(view, kVar);
                return;
            }
            this.f6715d.f6713d.getLayoutManager().P0(view, kVar);
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                aVar.g(view, kVar);
            } else {
                super.g(view, kVar);
            }
        }

        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f6716e.get(viewGroup);
            if (aVar != null) {
                return aVar.i(viewGroup, view, accessibilityEvent);
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        public boolean j(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, int i10, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
            if (this.f6715d.o() || this.f6715d.f6713d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f6715d.f6713d.getLayoutManager().j1(view, i10, bundle);
        }

        public void l(@NonNull View view, int i10) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f6716e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        public androidx.core.view.a n(View view) {
            return this.f6716e.remove(view);
        }

        /* access modifiers changed from: package-private */
        public void o(View view) {
            androidx.core.view.a l10 = n0.l(view);
            if (l10 != null && l10 != this) {
                this.f6716e.put(view, l10);
            }
        }
    }

    public v(@NonNull RecyclerView recyclerView) {
        this.f6713d = recyclerView;
        androidx.core.view.a n10 = n();
        if (n10 == null || !(n10 instanceof a)) {
            this.f6714e = new a(this);
        } else {
            this.f6714e = (a) n10;
        }
    }

    public void f(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().L0(accessibilityEvent);
            }
        }
    }

    public void g(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, @SuppressLint({"InvalidNullabilityOverride"}) @NonNull k kVar) {
        super.g(view, kVar);
        if (!o() && this.f6713d.getLayoutManager() != null) {
            this.f6713d.getLayoutManager().N0(kVar);
        }
    }

    public boolean j(@SuppressLint({"InvalidNullabilityOverride"}) @NonNull View view, int i10, @SuppressLint({"InvalidNullabilityOverride"}) Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f6713d.getLayoutManager() == null) {
            return false;
        }
        return this.f6713d.getLayoutManager().h1(i10, bundle);
    }

    @NonNull
    public androidx.core.view.a n() {
        return this.f6714e;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f6713d.t0();
    }
}
