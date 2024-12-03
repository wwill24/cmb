package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.viewpager.widget.ViewPager;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.inbox.g;
import com.clevertap.android.sdk.p;
import com.google.android.material.tabs.TabLayout;
import i4.t;
import i4.u;
import i4.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class CTInboxActivity extends h implements g.b {

    /* renamed from: h  reason: collision with root package name */
    public static int f10465h;

    /* renamed from: a  reason: collision with root package name */
    i f10466a;

    /* renamed from: b  reason: collision with root package name */
    CTInboxStyleConfig f10467b;

    /* renamed from: c  reason: collision with root package name */
    TabLayout f10468c;

    /* renamed from: d  reason: collision with root package name */
    ViewPager f10469d;

    /* renamed from: e  reason: collision with root package name */
    private CleverTapInstanceConfig f10470e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<c> f10471f;

    /* renamed from: g  reason: collision with root package name */
    private CleverTapAPI f10472g;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            CTInboxActivity.this.finish();
        }
    }

    class b implements TabLayout.d {
        b() {
        }

        public void a(TabLayout.g gVar) {
            g gVar2 = (g) CTInboxActivity.this.f10466a.u(gVar.g());
            if (gVar2.E0() != null) {
                gVar2.E0().O1();
            }
        }

        public void b(TabLayout.g gVar) {
            g gVar2 = (g) CTInboxActivity.this.f10466a.u(gVar.g());
            if (gVar2.E0() != null) {
                gVar2.E0().N1();
            }
        }

        public void c(TabLayout.g gVar) {
        }
    }

    public interface c {
        void a(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle);

        void b(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z10);
    }

    private String q0() {
        return this.f10470e.e() + ":CT_INBOX_LIST_VIEW_FRAGMENT";
    }

    public void E(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z10) {
        k0(bundle, cTInboxMessage, hashMap, z10);
    }

    /* access modifiers changed from: package-private */
    public void k0(Bundle bundle, CTInboxMessage cTInboxMessage, HashMap<String, String> hashMap, boolean z10) {
        c r02 = r0();
        if (r02 != null) {
            r02.b(this, cTInboxMessage, bundle, hashMap, z10);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.f10467b = (CTInboxStyleConfig) extras.getParcelable("styleConfig");
                Bundle bundle2 = extras.getBundle("configBundle");
                if (bundle2 != null) {
                    this.f10470e = (CleverTapInstanceConfig) bundle2.getParcelable("config");
                }
                CleverTapAPI F = CleverTapAPI.F(getApplicationContext(), this.f10470e);
                this.f10472g = F;
                if (F != null) {
                    s0(F);
                }
                f10465h = getResources().getConfiguration().orientation;
                setContentView(v.inbox_activity);
                Toolbar toolbar = (Toolbar) findViewById(u.toolbar);
                toolbar.setTitle((CharSequence) this.f10467b.f());
                toolbar.setTitleTextColor(Color.parseColor(this.f10467b.g()));
                toolbar.setBackgroundColor(Color.parseColor(this.f10467b.e()));
                Drawable e10 = androidx.core.content.res.h.e(getResources(), t.ct_ic_arrow_back_white_24dp, (Resources.Theme) null);
                if (e10 != null) {
                    e10.setColorFilter(Color.parseColor(this.f10467b.a()), PorterDuff.Mode.SRC_IN);
                }
                toolbar.setNavigationIcon(e10);
                toolbar.setNavigationOnClickListener(new a());
                LinearLayout linearLayout = (LinearLayout) findViewById(u.inbox_linear_layout);
                linearLayout.setBackgroundColor(Color.parseColor(this.f10467b.d()));
                this.f10468c = (TabLayout) linearLayout.findViewById(u.tab_layout);
                this.f10469d = (ViewPager) linearLayout.findViewById(u.view_pager);
                TextView textView = (TextView) findViewById(u.no_message_view);
                Bundle bundle3 = new Bundle();
                bundle3.putParcelable("config", this.f10470e);
                bundle3.putParcelable("styleConfig", this.f10467b);
                int i10 = 0;
                if (!this.f10467b.o()) {
                    this.f10469d.setVisibility(8);
                    this.f10468c.setVisibility(8);
                    ((FrameLayout) findViewById(u.list_view_fragment)).setVisibility(0);
                    CleverTapAPI cleverTapAPI = this.f10472g;
                    if (cleverTapAPI == null || cleverTapAPI.y() != 0) {
                        textView.setVisibility(8);
                        for (Fragment next : getSupportFragmentManager().v0()) {
                            if (next.getTag() != null && !next.getTag().equalsIgnoreCase(q0())) {
                                i10 = 1;
                            }
                        }
                        if (i10 == 0) {
                            g gVar = new g();
                            gVar.setArguments(bundle3);
                            getSupportFragmentManager().p().c(u.list_view_fragment, gVar, q0()).i();
                            return;
                        }
                        return;
                    }
                    textView.setBackgroundColor(Color.parseColor(this.f10467b.d()));
                    textView.setVisibility(0);
                    textView.setText(this.f10467b.h());
                    textView.setTextColor(Color.parseColor(this.f10467b.i()));
                    return;
                }
                this.f10469d.setVisibility(0);
                ArrayList<String> m10 = this.f10467b.m();
                this.f10466a = new i(getSupportFragmentManager(), m10.size() + 1);
                this.f10468c.setVisibility(0);
                this.f10468c.setTabGravity(0);
                this.f10468c.setTabMode(1);
                this.f10468c.setSelectedTabIndicatorColor(Color.parseColor(this.f10467b.k()));
                this.f10468c.P(Color.parseColor(this.f10467b.n()), Color.parseColor(this.f10467b.j()));
                this.f10468c.setBackgroundColor(Color.parseColor(this.f10467b.l()));
                Bundle bundle4 = (Bundle) bundle3.clone();
                bundle4.putInt("position", 0);
                g gVar2 = new g();
                gVar2.setArguments(bundle4);
                this.f10466a.x(gVar2, this.f10467b.c(), 0);
                while (i10 < m10.size()) {
                    String str = m10.get(i10);
                    i10++;
                    Bundle bundle5 = (Bundle) bundle3.clone();
                    bundle5.putInt("position", i10);
                    bundle5.putString("filter", str);
                    g gVar3 = new g();
                    gVar3.setArguments(bundle5);
                    this.f10466a.x(gVar3, str, i10);
                    this.f10469d.setOffscreenPageLimit(i10);
                }
                this.f10469d.setAdapter(this.f10466a);
                this.f10466a.k();
                this.f10469d.c(new TabLayout.h(this.f10468c));
                this.f10468c.h(new b());
                this.f10468c.setupWithViewPager(this.f10469d);
                return;
            }
            throw new IllegalArgumentException();
        } catch (Throwable th2) {
            p.r("Cannot find a valid notification inbox bundle to show!", th2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.f10467b.o()) {
            for (Fragment next : getSupportFragmentManager().v0()) {
                if (next instanceof g) {
                    p.o("Removing fragment - " + next.toString());
                    getSupportFragmentManager().v0().remove(next);
                }
            }
        }
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void p0(Bundle bundle, CTInboxMessage cTInboxMessage) {
        p.o("CTInboxActivity:didShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.f() + "]");
        c r02 = r0();
        if (r02 != null) {
            r02.a(this, cTInboxMessage, bundle);
        }
    }

    public void r(Context context, CTInboxMessage cTInboxMessage, Bundle bundle) {
        p.o("CTInboxActivity:messageDidShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.f() + "]");
        p0(bundle, cTInboxMessage);
    }

    /* access modifiers changed from: package-private */
    public c r0() {
        c cVar;
        try {
            cVar = this.f10471f.get();
        } catch (Throwable unused) {
            cVar = null;
        }
        if (cVar == null) {
            this.f10470e.n().t(this.f10470e.e(), "InboxActivityListener is null for notification inbox ");
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public void s0(c cVar) {
        this.f10471f = new WeakReference<>(cVar);
    }
}
