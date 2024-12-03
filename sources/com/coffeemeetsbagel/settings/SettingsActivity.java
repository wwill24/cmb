package com.coffeemeetsbagel.settings;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.browser.customtabs.d;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import k6.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

public final class SettingsActivity extends c {

    /* renamed from: c  reason: collision with root package name */
    public d f36382c;

    /* renamed from: d  reason: collision with root package name */
    public e f36383d;

    /* renamed from: e  reason: collision with root package name */
    public FeatureFlagRepository f36384e;

    static final class a implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f36385a;

        a(Function1 function1) {
            j.g(function1, "function");
            this.f36385a = function1;
        }

        public final gk.c<?> a() {
            return this.f36385a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f36385a.invoke(obj);
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

    private final void I0() {
        new d.a().a().a(this, Uri.parse(getString(R.string.zendesk_url)));
    }

    /* access modifiers changed from: private */
    public static final void J0(SettingsActivity settingsActivity, SettingsViewModel settingsViewModel, View view) {
        j.g(settingsActivity, "this$0");
        j.g(settingsViewModel, "$viewModel");
        settingsActivity.N0(true);
        settingsViewModel.o(true);
    }

    /* access modifiers changed from: private */
    public static final void K0(SettingsActivity settingsActivity, SettingsViewModel settingsViewModel, View view) {
        j.g(settingsActivity, "this$0");
        j.g(settingsViewModel, "$viewModel");
        settingsActivity.N0(false);
        settingsViewModel.o(false);
    }

    /* access modifiers changed from: private */
    public static final void L0(SettingsActivity settingsActivity, View view) {
        j.g(settingsActivity, "this$0");
        settingsActivity.I0();
    }

    /* access modifiers changed from: private */
    public final void N0(boolean z10) {
        if (z10) {
            CmbTextView cmbTextView = G0().f15720d;
            j.f(cmbTextView, "binding.textViewMetric");
            P0(cmbTextView);
            CmbTextView cmbTextView2 = G0().f15719c;
            j.f(cmbTextView2, "binding.textViewImperial");
            O0(cmbTextView2);
            return;
        }
        CmbTextView cmbTextView3 = G0().f15720d;
        j.f(cmbTextView3, "binding.textViewMetric");
        O0(cmbTextView3);
        CmbTextView cmbTextView4 = G0().f15719c;
        j.f(cmbTextView4, "binding.textViewImperial");
        P0(cmbTextView4);
    }

    private final void O0(CmbTextView cmbTextView) {
        cmbTextView.setBackgroundColor(androidx.core.content.a.getColor(cmbTextView.getContext(), R.color.transparent));
        cmbTextView.setTextColor(androidx.core.content.a.getColor(cmbTextView.getContext(), R.color.light_gray));
    }

    private final void P0(CmbTextView cmbTextView) {
        cmbTextView.setBackground(androidx.core.content.a.getDrawable(cmbTextView.getContext(), R.drawable.rounded_solid_main_radius_12));
        cmbTextView.setTextColor(androidx.core.content.a.getColor(cmbTextView.getContext(), R.color.white));
    }

    public final k6.d G0() {
        k6.d dVar = this.f36382c;
        if (dVar != null) {
            return dVar;
        }
        j.y("binding");
        return null;
    }

    public final e H0() {
        e eVar = this.f36383d;
        if (eVar != null) {
            return eVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void M0(k6.d dVar) {
        j.g(dVar, "<set-?>");
        this.f36382c = dVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bakery.j().Q1(this);
        super.onCreate(bundle);
        k6.d c10 = k6.d.c(LayoutInflater.from(this));
        j.f(c10, "inflate(LayoutInflater.from(this))");
        M0(c10);
        setContentView((View) G0().getRoot());
        SettingsViewModel settingsViewModel = (SettingsViewModel) new i0((l0) this, (i0.b) H0()).a(SettingsViewModel.class);
        settingsViewModel.m().i(this, new a(new SettingsActivity$onCreate$1(this)));
        G0().f15720d.setOnClickListener(new a(this, settingsViewModel));
        G0().f15719c.setOnClickListener(new b(this, settingsViewModel));
        G0().f15718b.setOnClickListener(new c(this));
    }
}
