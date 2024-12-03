package com.coffeemeetsbagel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.fragments.x0;
import com.coffeemeetsbagel.fragments.z0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.appevents.AppEventsLogger;
import com.uber.autodispose.p;
import e8.d;
import h5.i;
import j5.h;
import j5.x;
import lc.o;

public class ActivityPhotoSelect extends h {
    private int B;
    private String C;
    private String D;
    private boolean E;

    /* renamed from: w  reason: collision with root package name */
    private x0 f10864w;

    /* renamed from: x  reason: collision with root package name */
    private z0 f10865x;

    /* renamed from: y  reason: collision with root package name */
    private d f10866y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10867z;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10868a;

        static {
            int[] iArr = new int[EventType.values().length];
            f10868a = iArr;
            try {
                iArr[EventType.PHOTO_READY_NO_CAPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void B1(Intent intent) {
        intent.setData(o.a(this.D, this));
        intent.putExtra(Extra.PHOTO_ID, this.C);
        intent.putExtra(Extra.PHOTO_INDEX, this.B);
        intent.putExtra(Extra.IMAGE_PATH, this.D);
    }

    private void C1(Intent intent) {
        B1(intent);
        setResult(-1, intent);
        finish();
    }

    private boolean E1() {
        return Extra.SOURCE_FACEBOOK.equals(getIntent().getStringExtra(Extra.KEY_PHOTO_SELECT_SOURCE));
    }

    private boolean F1() {
        return Extra.SOURCE_INSTAGRAM.equals(getIntent().getStringExtra(Extra.KEY_PHOTO_SELECT_SOURCE));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G1(x xVar) throws Exception {
        onBackPressed();
    }

    private void I1() {
        if (getSupportFragmentManager().v0() == null || !getSupportFragmentManager().v0().contains(this.f10865x)) {
            getSupportFragmentManager().p().s(R.id.fragmentContainer_add_photo, this.f10865x).i();
        }
        this.f10867z = true;
    }

    private void J1() {
        if (getSupportFragmentManager().v0() == null || !getSupportFragmentManager().v0().contains(this.f10866y)) {
            Bundle bundle = new Bundle();
            bundle.putInt(Extra.PHOTO_INDEX, this.B);
            bundle.putString(Extra.PHOTO_ID, this.C);
            bundle.putBoolean(Extra.SHOULD_SHOW_CAPTION_FLOW, this.E);
            bundle.putString(Extra.IMAGE_PATH, this.D);
            this.f10866y.setArguments(bundle);
            getSupportFragmentManager().p().s(R.id.fragmentContainer_add_photo, this.f10866y).i();
        }
        this.f10867z = false;
    }

    public int D1() {
        return E1() ? R.string.albums : R.string.instagram;
    }

    public void H1(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("albumId=");
        sb2.append(str);
        sb2.append(", albumName=");
        sb2.append(str2);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("name", str2);
        bundle.putInt(Extra.PHOTO_INDEX, this.B);
        bundle.putString(Extra.PHOTO_ID, this.C);
        bundle.putBoolean(Extra.SHOULD_SHOW_CAPTION_FLOW, this.E);
        bundle.putString(Extra.IMAGE_PATH, this.D);
        this.f10864w.setArguments(bundle);
        if (getSupportFragmentManager().v0() == null || !getSupportFragmentManager().v0().contains(this.f10864w)) {
            getSupportFragmentManager().p().s(R.id.fragmentContainer_add_photo, this.f10864w).i();
            v1(str2);
        }
        this.f10867z = false;
    }

    /* access modifiers changed from: protected */
    public Fragment O0() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public int b1() {
        return R.layout.activity_add_photo_fb;
    }

    public void n0(EventType eventType, Bundle bundle) {
        super.n0(eventType, bundle);
        if (a.f10868a[eventType.ordinal()] == 1) {
            C1(new Intent());
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 1003) {
            if (i10 == 6600 && i11 == -1) {
                B1(intent);
                intent.putExtra("caption", intent.getStringExtra("caption"));
                setResult(-1, intent);
                finish();
            }
        } else if (i11 != -1) {
        } else {
            if (this.E) {
                c1().i(this, i10, i11, intent);
            } else {
                C1(intent);
            }
        }
    }

    public void onBackPressed() {
        if (F1() || this.f10867z) {
            super.onBackPressed();
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            return;
        }
        I1();
        v1(getString(R.string.albums));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.B = intent.getIntExtra(Extra.PHOTO_INDEX, 0);
        this.E = intent.getBooleanExtra(Extra.SHOULD_SHOW_CAPTION_FLOW, true);
        this.D = intent.getStringExtra(Extra.IMAGE_PATH);
        if (intent.hasExtra(Extra.PHOTO_ID)) {
            this.C = intent.getStringExtra(Extra.PHOTO_ID);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mPhotoIndex=");
        sb2.append(this.B);
        sb2.append(", mPhotoIdToReplace=");
        sb2.append(this.C);
        if (E1()) {
            this.f10864w = new x0();
            this.f10865x = new z0();
            I1();
        } else if (F1()) {
            this.f10866y = new d();
            J1();
        } else {
            ha.a.b("source NOT SET");
            this.f10864w = new x0();
            this.f10865x = new z0();
            I1();
        }
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(getString(D1()));
            this.f15597h.X();
        }
        i.a(this, EventType.PHOTO_READY_NO_CAPTION);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        i.d(this, EventType.PHOTO_READY_NO_CAPTION);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            ((p) cmbToolbar.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s(this));
        }
    }

    public boolean x1() {
        return false;
    }
}
