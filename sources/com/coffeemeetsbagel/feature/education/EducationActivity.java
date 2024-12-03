package com.coffeemeetsbagel.feature.education;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.internal.ServerProtocol;
import f8.x;
import j5.h;

public class EducationActivity extends h implements x7.b {
    private ModelProfileUpdateDelta B;
    /* access modifiers changed from: private */
    public boolean C;

    /* renamed from: w  reason: collision with root package name */
    private String f13005w;

    /* renamed from: x  reason: collision with root package name */
    private String f13006x;

    /* renamed from: y  reason: collision with root package name */
    private String f13007y;

    /* renamed from: z  reason: collision with root package name */
    private String f13008z;

    class a implements MenuItem.OnMenuItemClickListener {
        a() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            EducationActivity.this.M1();
            if (EducationActivity.this.I1()) {
                EducationActivity.this.z1(R.string.onboarding_education_incomplete);
                return true;
            } else if (EducationActivity.this.C) {
                EducationActivity.this.H1();
                return true;
            } else {
                EducationActivity.this.finish();
                return true;
            }
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            EducationActivity.this.K1();
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            EducationActivity.this.K1();
            EducationActivity.this.L1();
        }
    }

    class c implements jc.b<Void> {
        c() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    /* access modifiers changed from: private */
    public void H1() {
        lc.a.c(this, new Intent(this, ActivityMain.class));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r2.f13006x;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I1() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f13005w
            if (r0 == 0) goto L_0x0008
            java.lang.String r1 = r2.f13007y
            if (r1 == 0) goto L_0x001c
        L_0x0008:
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = r2.f13007y
            if (r0 != 0) goto L_0x001c
        L_0x000e:
            java.lang.String r0 = r2.f13006x
            if (r0 == 0) goto L_0x0016
            java.lang.String r1 = r2.f13008z
            if (r1 == 0) goto L_0x001c
        L_0x0016:
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = r2.f13008z
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.education.EducationActivity.I1():boolean");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(View view) {
        H1();
    }

    /* access modifiers changed from: private */
    public void K1() {
        i1().b(new c(), false);
    }

    /* access modifiers changed from: private */
    public void L1() {
        P0().c("Has Education", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* access modifiers changed from: private */
    public void M1() {
        if ((!TextUtils.isEmpty(this.f13005w) && !TextUtils.isEmpty(this.f13007y)) || (!TextUtils.isEmpty(this.f13006x) && !TextUtils.isEmpty(this.f13008z))) {
            this.B.updateEducation(this.f13005w, this.f13007y, this.f13006x, this.f13008z);
            d1().p(new b(), this.B, false);
        }
    }

    public void J(String str) {
        this.f13006x = str;
    }

    public void M(String str) {
        this.f13005w = str;
    }

    public Fragment O0() {
        return new x();
    }

    /* access modifiers changed from: protected */
    public String Z0() {
        return null;
    }

    public void m(String str) {
        this.f13008z = str;
    }

    public void onBackPressed() {
        if (this.C) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = new ModelProfileUpdateDelta();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.C = getIntent().getBooleanExtra(Extra.IS_IN_ONBOARDING, false);
        }
        if (this.C) {
            androidx.appcompat.app.a p02 = p0();
            p02.x(false);
            p02.u(false);
            p02.w(false);
            Bakery.w().z().g("Onboarding School Input");
            View inflate = getLayoutInflater().inflate(R.layout.app_bar_button, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.app_bar_button_text_view);
            textView.setText(R.string.skip);
            p02.s(inflate);
            p02.v(16);
            textView.setOnClickListener(new x7.a(this));
            return;
        }
        v1(getString(R.string.label_education));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, R.id.menu_item_save, 0, R.string.tooltip_save);
        if (this.C) {
            add.setTitle(R.string.done);
        } else {
            add.setIcon(R.drawable.icon_done);
        }
        add.setShowAsAction(2);
        add.setOnMenuItemClickListener(new a());
        return super.onCreateOptionsMenu(menu);
    }

    public void onPause() {
        super.onPause();
        M1();
    }

    public void t(String str) {
        this.f13007y = str;
    }
}
