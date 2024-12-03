package com.coffeemeetsbagel.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.c;
import androidx.browser.customtabs.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.leanplum.Leanplum;
import com.leanplum.callbacks.VariablesChangedCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class OutageModeActivity extends c implements t.a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f10872c = new a((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    private static final String f10873d = "MaintenanceMode";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static boolean f10874e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return OutageModeActivity.f10874e;
        }

        public final void b(Context context) {
            j.g(context, "appContext");
            if (!a()) {
                c(true);
                Intent intent = new Intent(context, OutageModeActivity.class);
                intent.addFlags(805339136);
                context.startActivity(intent);
            }
        }

        public final void c(boolean z10) {
            OutageModeActivity.f10874e = z10;
        }
    }

    public static final class b extends VariablesChangedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProgressBar f10875a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutageModeActivity f10876b;

        b(ProgressBar progressBar, OutageModeActivity outageModeActivity) {
            this.f10875a = progressBar;
            this.f10876b = outageModeActivity;
        }

        public void variablesChanged() {
            this.f10875a.setVisibility(8);
            this.f10876b.H0();
        }
    }

    /* access modifiers changed from: private */
    public final void H0() {
        boolean z10;
        boolean z11;
        String str;
        boolean z12;
        String str2;
        boolean z13;
        String str3;
        boolean z14;
        int i10;
        boolean z15;
        String str4;
        ImageView imageView = (ImageView) findViewById(R.id.image);
        String str5 = t9.a.outageModalIconUrl;
        j.f(str5, "outageModalIconUrl");
        boolean z16 = true;
        int i11 = 0;
        if (str5.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            com.coffeemeetsbagel.image_loader.b bVar = com.coffeemeetsbagel.image_loader.b.f13967a;
            String str6 = t9.a.outageModalIconUrl;
            j.f(str6, "outageModalIconUrl");
            bVar.b(this, str6, imageView, (Integer) null, (Integer) null, new ImageLoaderContract.b(120, 120), q.j(), h0.i(), new OutageModeActivity$displayVariables$1(imageView), (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, ImageLoaderContract.MemoryConfig.NO_STORE);
        } else {
            imageView.setImageResource(R.drawable.ic_outage);
        }
        CmbTextView cmbTextView = (CmbTextView) findViewById(R.id.outage_title);
        String str7 = t9.a.outageModalTitle;
        j.f(str7, "outageModalTitle");
        if (str7.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = t9.a.outageModalTitle;
        } else {
            str = getString(R.string.maintenance_mode_title);
        }
        cmbTextView.setText(str);
        CmbTextView cmbTextView2 = (CmbTextView) findViewById(R.id.outage_description);
        String str8 = t9.a.outageModalDescription;
        j.f(str8, "outageModalDescription");
        if (str8.length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            str2 = t9.a.outageModalDescription;
        } else {
            str2 = getString(R.string.maintenance_mode_description);
        }
        cmbTextView2.setText(str2);
        CmbTextView cmbTextView3 = (CmbTextView) findViewById(R.id.primary_button);
        String str9 = t9.a.outageModalPrimaryButton;
        j.f(str9, "outageModalPrimaryButton");
        if (str9.length() > 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            str3 = t9.a.outageModalPrimaryButton;
        } else {
            str3 = getString(R.string.check_status);
        }
        cmbTextView3.setText(str3);
        CharSequence text = cmbTextView3.getText();
        j.f(text, "primaryButton.text");
        if (text.length() > 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        cmbTextView3.setVisibility(i10);
        CmbTextView cmbTextView4 = (CmbTextView) findViewById(R.id.secondary_button);
        String str10 = t9.a.outageModalSecondaryButton;
        j.f(str10, "outageModalSecondaryButton");
        if (str10.length() > 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            str4 = t9.a.outageModalSecondaryButton;
        } else {
            str4 = "";
        }
        cmbTextView4.setText(str4);
        CharSequence text2 = cmbTextView4.getText();
        j.f(text2, "secondaryButton.text");
        if (text2.length() <= 0) {
            z16 = false;
        }
        if (!z16) {
            i11 = 8;
        }
        cmbTextView4.setVisibility(i11);
    }

    public static final void I0(Context context) {
        f10872c.b(context);
    }

    /* access modifiers changed from: private */
    public static final void J0(OutageModeActivity outageModeActivity, View view) {
        j.g(outageModeActivity, "this$0");
        String str = t9.a.outageModalPrimaryButtonUrl;
        j.f(str, "outageModalPrimaryButtonUrl");
        if (r.J(str, "http", false, 2, (Object) null)) {
            new d.a().a().a(outageModeActivity, Uri.parse(t9.a.outageModalPrimaryButtonUrl));
            return;
        }
        CmbLinks.Companion.launchCmbStatusPage(outageModeActivity);
    }

    /* access modifiers changed from: private */
    public static final void K0(OutageModeActivity outageModeActivity, View view) {
        j.g(outageModeActivity, "this$0");
        outageModeActivity.finishAndRemoveTask();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public void I() {
        if (!Bakery.w().H().n()) {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            j.d(launchIntentForPackage);
            launchIntentForPackage.addFlags(805339136);
            startActivity(launchIntentForPackage);
            finish();
        }
    }

    public void onBackPressed() {
        finishAndRemoveTask();
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_maintenance_mode);
        Leanplum.addVariablesChangedHandler(new b((ProgressBar) findViewById(R.id.loadingSpinner), this));
        f10874e = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        f10874e = false;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        ((CmbTextView) findViewById(R.id.primary_button)).setOnClickListener(new z(this));
        ((CmbTextView) findViewById(R.id.secondary_button)).setOnClickListener(new a0(this));
        Bakery.w().H().e(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        Bakery.w().H().k(this);
    }
}
