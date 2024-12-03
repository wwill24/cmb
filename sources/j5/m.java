package j5;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLocation;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.util.RequestCode;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.i;
import com.google.android.gms.location.j;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import fa.a;
import g8.l;
import java.util.Optional;
import lc.c;
import lc.q;
import qj.w;
import qj.y;

public abstract class m extends h implements d.b, d.c, i {

    /* renamed from: w  reason: collision with root package name */
    private d f15611w;

    /* renamed from: x  reason: collision with root package name */
    private LocationRequest f15612x;

    /* renamed from: y  reason: collision with root package name */
    private Dialog f15613y;

    private void G1() {
        if (!H1()) {
            Q1();
        } else {
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), RequestCode.LOCATION_SETTINGS);
        }
        this.f15613y.dismiss();
    }

    @TargetApi(23)
    private boolean H1() {
        return checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(y yVar) throws Exception {
        Optional optional;
        Location lastLocation = j.f39594b.getLastLocation(this.f15611w);
        if (lastLocation == null) {
            optional = Optional.empty();
        } else {
            optional = Optional.of(lastLocation);
        }
        yVar.onSuccess(optional);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(Optional optional) throws Exception {
        if (optional.isPresent()) {
            M1((Location) optional.get());
        } else {
            N1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1(Throwable th2) throws Exception {
        a.g("AbstractActivityLocation", "Failed to get last known location.", th2);
        N1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(x xVar) throws Exception {
        G1();
    }

    private void M1(Location location) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("location", location);
        h5.i.c(EventType.LOCATION_UPDATED, bundle);
    }

    private void Q1() {
        startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), (String) null)), RequestCode.LOCATION_SETTINGS_APP_PERMISSIONS);
    }

    private void R1() {
        b0 b0Var = new b0(this, R.string.location_disabled_title, R.string.location_disabled_text, R.string.location_disabled_go_to_settings);
        this.f15613y = b0Var;
        b0 b0Var2 = b0Var;
        ((p) b0Var.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l(this));
        this.f15613y.show();
    }

    private void S1() {
        if (this.f15611w.m()) {
            j.f39594b.removeLocationUpdates(this.f15611w, this);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void E1() {
        this.f15611w = new d.a(this).b(this).c(this).a(j.f39593a).d();
    }

    public void F1() {
        if (!q.f(this)) {
            R1();
        } else {
            ((t) w.k(new i(this)).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new j(this), new k(this));
        }
    }

    public void N1() {
        if (this.f15611w.m()) {
            try {
                j.f39594b.requestLocationUpdates(this.f15611w, this.f15612x, this);
            } catch (SecurityException e10) {
                a.i(e10);
            }
        } else if (!this.f15611w.n()) {
            this.f15611w.d();
        }
    }

    public void O1() {
        if (!H1()) {
            requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, RequestCode.PERMISSION_LOCATION);
        } else {
            F1();
        }
    }

    public void P1() {
        LocationRequest locationRequest = new LocationRequest();
        this.f15612x = locationRequest;
        locationRequest.c1(5000);
        this.f15612x.W0(2000);
        this.f15612x.d1(1);
        this.f15612x.h1(102);
    }

    public void c(Bundle bundle) {
        try {
            j.f39594b.requestLocationUpdates(this.f15611w, this.f15612x, this);
            F1();
        } catch (SecurityException e10) {
            a.i(e10);
        }
    }

    public void f(int i10) {
        this.f15611w.d();
    }

    public void g(@NonNull ConnectionResult connectionResult) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection failed: ConnectionResult.getErrorCode() = ");
        sb2.append(connectionResult.S());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 9278) {
            if (i10 == 9284) {
                if (H1()) {
                    N1();
                } else {
                    super.z1(R.string.location_unavailable);
                }
            }
        } else if (H1() && q.f(this)) {
            N1();
        } else if (H1() || !q.f(this)) {
            super.z1(R.string.location_unavailable);
        } else {
            Q1();
        }
    }

    public void onBackPressed() {
        c.a(this);
        if (!(this instanceof ActivityLocation)) {
            super.onBackPressed();
        } else if (((l) getFragment()).n1() && !((l) getFragment()).B1()) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        E1();
        P1();
    }

    public void onLocationChanged(Location location) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Received location update: ");
        sb2.append(location);
        M1(location);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        S1();
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("requestCode=");
        sb2.append(i10);
        sb2.append(", permissions=");
        sb2.append(strArr);
        sb2.append(", grantResults=");
        sb2.append(iArr);
        if (i10 == 9277) {
            if (iArr.length >= 1 && iArr[0] == 0) {
                F1();
            } else if (shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION")) {
                super.z1(R.string.location_disabled_text);
            } else {
                R1();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (this.f15611w.m()) {
            this.f15611w.e();
        }
    }
}
