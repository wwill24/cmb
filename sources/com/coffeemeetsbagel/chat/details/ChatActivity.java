package com.coffeemeetsbagel.chat.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.n;
import androidx.fragment.app.Fragment;
import b6.r;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.components.lifecycle.ActivityLifecycleEvent;
import com.coffeemeetsbagel.feature.chat.header.a;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.fragments.g1;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.coffeemeetsbagel.store.UpsellErrorDialog;
import com.coffeemeetsbagel.store.premium_upsell.PremiumUpsellComponentActivity;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.appevents.AppEventsLogger;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import io.reactivex.subjects.CompletableSubject;
import io.reactivex.subjects.PublishSubject;
import j5.h;
import j5.x;
import java.util.Collections;
import java.util.Objects;
import jc.b;
import k6.c0;
import lc.t;
import n5.h1;
import n5.q;
import o5.d;

public class ChatActivity extends h {
    /* access modifiers changed from: private */
    public final g1 B = new g1();
    private d C;
    private boolean D = false;
    public final CompletableSubject E = CompletableSubject.L();
    public final PublishSubject<x> F = PublishSubject.C0();

    /* renamed from: w  reason: collision with root package name */
    s9.a f11469w;

    /* renamed from: x  reason: collision with root package name */
    private Bagel f11470x;

    /* renamed from: y  reason: collision with root package name */
    private NetworkProfile f11471y;

    /* renamed from: z  reason: collision with root package name */
    private c0 f11472z;

    class a implements b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tonReceiveError: ");
            sb2.append(cmbErrorCode);
            fa.a.f("ChatActivity", "Error on attempting to sync sync");
            if (ActivityLifecycleEvent.RESUME == ChatActivity.this.x0()) {
                ChatActivity.this.getSupportFragmentManager().p().r(ChatActivity.this.B).i();
                ChatActivity.this.M0();
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tonReceiveSuccess: ");
            sb2.append(successStatus);
            if (ActivityLifecycleEvent.RESUME == ChatActivity.this.x0()) {
                Toolbar toolbar = ChatActivity.this.f15594e;
                if (toolbar != null) {
                    toolbar.setVisibility(0);
                }
                ChatActivity.this.getSupportFragmentManager().p().r(ChatActivity.this.B).i();
                ChatActivity.this.M0();
            }
        }
    }

    private void E1() {
        if (I1()) {
            M0();
            return;
        }
        fa.a.f("ChatActivity", "Invalid bagel=" + this.f11470x);
        fa.a.i(new IllegalStateException("Cannot show conversation for bagel with invalid connection data."));
    }

    private boolean I1() {
        Bagel bagel = this.f11470x;
        if (bagel == null || TextUtils.isEmpty(bagel.getDecouplingDate()) || TextUtils.isEmpty(this.f11470x.getCoupleId())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1() throws Exception {
        r.a(new com.coffeemeetsbagel.feature.chat.header.a((a.c) this.C.A0()).b(this.f11472z, this.f11470x.getId()));
    }

    public static Intent K1(Context context, Bagel bagel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Extra.BAGEL, bagel);
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtras(bundle);
        return intent;
    }

    private void L1() {
        Bagel bagel = this.f11470x;
        if (bagel != null && !TextUtils.isEmpty(bagel.getProfileId())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\tBagel=");
            sb2.append(this.f11470x.getProfileId());
            MongooseSyncJobService.D(getApplicationContext(), Collections.singletonList(t.g(this.f11470x.getProfileId())));
        }
    }

    private void M1() {
        if (this.C == null) {
            this.C = (d) getSupportFragmentManager().j0("TAG_DEPENDENCY_FRAGMENT");
        }
        if (this.C == null) {
            this.C = new d();
            getSupportFragmentManager().p().e(this.C, "TAG_DEPENDENCY_FRAGMENT").i();
        }
    }

    private void N1() {
        N0(this.B);
        Toolbar toolbar = this.f15594e;
        if (toolbar != null) {
            toolbar.setVisibility(8);
        }
    }

    public static void P1(Context context, Bagel bagel) {
        context.startActivity(K1(context, bagel));
    }

    private void Q1() {
        Bakery.w().D().b(new a(), false);
    }

    private void R1() {
        Bakery.w().A().Q(this.f11470x);
    }

    public void F1() {
        ((m) this.E.j(com.uber.autodispose.a.a(this))).g(new q(this));
    }

    public void G1() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void H1() {
        Intent intent = new Intent(this, ActivityMain.class);
        intent.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_PAGE_CHATS);
        intent.putExtra(Extra.CHAT_LOAD_ERROR, true);
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void N0(Fragment fragment) {
        super.N0(fragment);
        if (fragment instanceof h1) {
            c0 c10 = c0.c(LayoutInflater.from(this));
            this.f11472z = c10;
            ((h1) fragment).m3(c10.getRoot());
            PublishSubject<x> publishSubject = this.F;
            Objects.requireNonNull(publishSubject);
            ((p) this.f11472z.f15713d.a().g(com.uber.autodispose.a.a(this))).c(new n5.p(publishSubject));
            this.E.onComplete();
        }
    }

    public Fragment O0() {
        return h1.d3(this.f11470x);
    }

    public void O1() {
        PremiumUpsellComponentActivity.f36846j.b(this, new PurchaseSource(ModelDeeplinkData.VALUE_PAGE_CHAT, "read receipt"));
    }

    public String Z0() {
        return "KEY_CONVERSATION";
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("requestCode=");
        sb2.append(i10);
        sb2.append(", resultCode=");
        sb2.append(i11);
        sb2.append(", data=");
        sb2.append(intent);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 9279 || i10 == 9281 || i10 == 9304) {
            if (i11 == 50 && !isFinishing() && intent.getStringExtra(Extra.BAGEL_ID).equals(this.f11470x.getId())) {
                Intent intent2 = new Intent();
                intent2.putExtra(Extra.BAGEL_ID, intent.getStringExtra(Extra.BAGEL_ID));
                intent2.putExtra(Extra.WAS_REPORTED, intent.getBooleanExtra(Extra.WAS_REPORTED, false));
                intent2.putExtra(Extra.IS_CONNECTED, true);
                setResult(50, intent2);
                finish();
            }
        } else if (i10 != 435345) {
            if (i10 == 9285 || i10 == 9286) {
                getFragment().onActivityResult(i10, i11, intent);
            }
        } else if (i11 == 242) {
            P0().d("Upsell Error Dialog Shown");
            UpsellErrorDialog.f36742a.a(this);
        }
    }

    public void onBackPressed() {
        if (getIntent().getBooleanExtra(Extra.IS_FROM_PUSH, false) || getIntent().getBooleanExtra("NAVIGATE_TO_CHAT_LIST", false)) {
            Intent a10 = n.a(this);
            a10.putExtra("is_from_chat_push", true);
            n.e(this, a10);
        }
        G1();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate(): savedInstanceState=");
        sb2.append(bundle);
        this.f11471y = d1().j();
        if (bundle != null) {
            this.f11470x = (Bagel) bundle.getSerializable(Extra.BAGEL);
        } else if (getIntent() != null) {
            Bagel bagel = (Bagel) getIntent().getSerializableExtra(Extra.BAGEL);
            this.f11470x = bagel;
            if (bagel == null) {
                String stringExtra = getIntent().getStringExtra(Extra.BAGEL_ID);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\tbagelId=");
                sb3.append(stringExtra);
                this.f11470x = Bakery.w().i().k(stringExtra);
            }
            this.D = getIntent().getBooleanExtra(Extra.IS_FROM_PUSH, false);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\tfromPush=");
            sb4.append(this.D);
        }
        if (bundle == null) {
            Bakery.w().z().k(getIntent());
        }
        if (this.f11470x == null) {
            P0().d("Chat Missing Bagel Alert");
            fa.a.g("ChatActivity", "Not showing chat because the bagel is null", new IllegalArgumentException("No bagel"));
            H1();
        } else if (this.f11471y == null) {
            fa.a.g("ChatActivity", "Chat Loading error because profile is null", new IllegalArgumentException("No Profile"));
            H1();
        } else {
            M1();
            if (this.D) {
                N1();
                Q1();
                L1();
            } else {
                E1();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\tmBagel=");
            sb5.append(this.f11470x);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        if (!isFinishing()) {
            R1();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(Bakery.w());
        if (!I1()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(Extra.BAGEL, this.f11470x);
    }

    public boolean x1() {
        return false;
    }
}
