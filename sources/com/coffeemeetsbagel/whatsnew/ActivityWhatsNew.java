package com.coffeemeetsbagel.whatsnew;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.whatsnew.b;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

public final class ActivityWhatsNew extends c implements b.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f37610f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ViewPager2 f37611c;

    /* renamed from: d  reason: collision with root package name */
    private WhatsNewViewModel f37612d;

    /* renamed from: e  reason: collision with root package name */
    public f f37613e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity) {
            j.g(activity, IdentityHttpResponse.CONTEXT);
            activity.startActivity(new Intent(activity, ActivityWhatsNew.class));
        }
    }

    static final class b implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f37614a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f37614a = function1;
        }

        public final gk.c<?> a() {
            return this.f37614a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f37614a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof f)) {
                return false;
            }
            return j.b(a(), ((f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    private final boolean D0() {
        ViewPager2 viewPager2 = this.f37611c;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            j.y("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem() + 1;
        ViewPager2 viewPager23 = this.f37611c;
        if (viewPager23 == null) {
            j.y("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        RecyclerView.Adapter adapter = viewPager22.getAdapter();
        j.d(adapter);
        return currentItem < adapter.g();
    }

    private final void F0() {
        WhatsNewViewModel whatsNewViewModel = this.f37612d;
        if (whatsNewViewModel == null) {
            j.y("itemViewModel");
            whatsNewViewModel = null;
        }
        whatsNewViewModel.g().i(this, new b(new ActivityWhatsNew$observePages$1(this)));
    }

    public final f E0() {
        f fVar = this.f37613e;
        if (fVar != null) {
            return fVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public void d() {
        finish();
    }

    public void e() {
        if (D0()) {
            ViewPager2 viewPager2 = this.f37611c;
            ViewPager2 viewPager22 = null;
            if (viewPager2 == null) {
                j.y("viewPager");
                viewPager2 = null;
            }
            ViewPager2 viewPager23 = this.f37611c;
            if (viewPager23 == null) {
                j.y("viewPager");
            } else {
                viewPager22 = viewPager23;
            }
            viewPager2.setCurrentItem(viewPager22.getCurrentItem() + 1);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        ViewPager2 viewPager2 = this.f37611c;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            j.y("viewPager");
            viewPager2 = null;
        }
        if (viewPager2.getCurrentItem() == 0) {
            finish();
            return;
        }
        ViewPager2 viewPager23 = this.f37611c;
        if (viewPager23 == null) {
            j.y("viewPager");
            viewPager23 = null;
        }
        ViewPager2 viewPager24 = this.f37611c;
        if (viewPager24 == null) {
            j.y("viewPager");
        } else {
            viewPager22 = viewPager24;
        }
        viewPager23.setCurrentItem(viewPager22.getCurrentItem() - 1);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bakery.j().S1(this);
        setContentView((int) R.layout.activity_whats_new);
        View findViewById = findViewById(R.id.viewPager);
        j.f(findViewById, "findViewById(R.id.viewPager)");
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        this.f37611c = viewPager2;
        WhatsNewViewModel whatsNewViewModel = null;
        if (viewPager2 == null) {
            j.y("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new b(new ArrayList(), this));
        WhatsNewViewModel whatsNewViewModel2 = (WhatsNewViewModel) new i0((l0) this, (i0.b) E0()).a(WhatsNewViewModel.class);
        this.f37612d = whatsNewViewModel2;
        if (whatsNewViewModel2 == null) {
            j.y("itemViewModel");
        } else {
            whatsNewViewModel = whatsNewViewModel2;
        }
        whatsNewViewModel.i();
        F0();
    }
}
