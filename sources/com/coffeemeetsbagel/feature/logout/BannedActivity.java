package com.coffeemeetsbagel.feature.logout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.c;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.util.RequestCode;
import com.withpersona.sdk2.inquiry.Inquiry;
import com.withpersona.sdk2.inquiry.InquiryResponse;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

public final class BannedActivity extends c {

    /* renamed from: h  reason: collision with root package name */
    public static final a f13061h = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f13062c = "BannedActivity";

    /* renamed from: d  reason: collision with root package name */
    public m f13063d;

    /* renamed from: e  reason: collision with root package name */
    private k6.b f13064e;

    /* renamed from: f  reason: collision with root package name */
    private l f13065f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.activity.result.c<Inquiry> f13066g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, BannedReason bannedReason, VerificationStatus verificationStatus) {
            j.g(activity, "activity");
            j.g(bannedReason, "bannedReason");
            j.g(verificationStatus, "verificationStatus");
            Intent intent = new Intent(activity, BannedActivity.class);
            intent.putExtra(Extra.BANNED_REASON, bannedReason.getApiReason());
            intent.putExtra(Extra.VERIFICATION_STATUS, verificationStatus.getApiStatus());
            intent.putExtra(Extra.VERIFICATION_REFERENCE_ID, verificationStatus.getReferenceId());
            activity.startActivityForResult(intent, RequestCode.VERIFICATION);
        }
    }

    static final class b implements u, f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13067a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f13067a = function1;
        }

        public final gk.c<?> a() {
            return this.f13067a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f13067a.invoke(obj);
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

    public BannedActivity() {
        androidx.activity.result.c<Inquiry> registerForActivityResult = registerForActivityResult(new Inquiry.Contract(), new h(this));
        j.f(registerForActivityResult, "registerForActivityResul…del.setResponse(it)\n    }");
        this.f13066g = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void S0(BannedActivity bannedActivity, InquiryResponse inquiryResponse) {
        j.g(bannedActivity, "this$0");
        l lVar = bannedActivity.f13065f;
        if (lVar == null) {
            j.y("viewModel");
            lVar = null;
        }
        j.f(inquiryResponse, "it");
        lVar.h(inquiryResponse);
    }

    private final void T0() {
        fa.a.f40771d.a(this.f13062c, "observeResponse()");
        l lVar = this.f13065f;
        if (lVar == null) {
            j.y("viewModel");
            lVar = null;
        }
        lVar.f().i(this, new b(new BannedActivity$observeResponse$1(this)));
    }

    private final void U0() {
        fa.a.f40771d.a(this.f13062c, "observeStatus()");
        l lVar = this.f13065f;
        if (lVar == null) {
            j.y("viewModel");
            lVar = null;
        }
        lVar.g().i(this, new b(new BannedActivity$observeStatus$1(this)));
    }

    /* access modifiers changed from: private */
    public final void V0() {
        k6.b bVar = this.f13064e;
        k6.b bVar2 = null;
        if (bVar == null) {
            j.y("binding");
            bVar = null;
        }
        bVar.getRoot().setVisibility(0);
        k6.b bVar3 = this.f13064e;
        if (bVar3 == null) {
            j.y("binding");
            bVar3 = null;
        }
        bVar3.f15696b.setImageResource(R.drawable.banned_logo);
        k6.b bVar4 = this.f13064e;
        if (bVar4 == null) {
            j.y("binding");
            bVar4 = null;
        }
        bVar4.f15700f.setText(R.string.banned_title);
        k6.b bVar5 = this.f13064e;
        if (bVar5 == null) {
            j.y("binding");
            bVar5 = null;
        }
        bVar5.f15697c.setText(R.string.banned_description);
        k6.b bVar6 = this.f13064e;
        if (bVar6 == null) {
            j.y("binding");
            bVar6 = null;
        }
        bVar6.f15698d.setText(R.string.contact_support);
        k6.b bVar7 = this.f13064e;
        if (bVar7 == null) {
            j.y("binding");
            bVar7 = null;
        }
        bVar7.f15698d.setOnClickListener(new d(this));
        k6.b bVar8 = this.f13064e;
        if (bVar8 == null) {
            j.y("binding");
            bVar8 = null;
        }
        bVar8.f15699e.setText(R.string.review_guidelines);
        k6.b bVar9 = this.f13064e;
        if (bVar9 == null) {
            j.y("binding");
        } else {
            bVar2 = bVar9;
        }
        bVar2.f15699e.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    public static final void W0(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        CmbLinks.Companion.launchVerificationSupport(bannedActivity);
    }

    /* access modifiers changed from: private */
    public static final void X0(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        CmbLinks.Companion.launchCommunityGuidelines(bannedActivity);
    }

    /* access modifiers changed from: private */
    public final void Y0() {
        k6.b bVar = this.f13064e;
        k6.b bVar2 = null;
        if (bVar == null) {
            j.y("binding");
            bVar = null;
        }
        bVar.getRoot().setVisibility(0);
        k6.b bVar3 = this.f13064e;
        if (bVar3 == null) {
            j.y("binding");
            bVar3 = null;
        }
        bVar3.f15696b.setImageResource(R.drawable.verification_required_asset);
        k6.b bVar4 = this.f13064e;
        if (bVar4 == null) {
            j.y("binding");
            bVar4 = null;
        }
        bVar4.f15700f.setText(R.string.banned_in_review_title);
        k6.b bVar5 = this.f13064e;
        if (bVar5 == null) {
            j.y("binding");
            bVar5 = null;
        }
        bVar5.f15697c.setText(R.string.banned_in_review_description);
        k6.b bVar6 = this.f13064e;
        if (bVar6 == null) {
            j.y("binding");
            bVar6 = null;
        }
        bVar6.f15698d.setText(R.string.got_it);
        k6.b bVar7 = this.f13064e;
        if (bVar7 == null) {
            j.y("binding");
            bVar7 = null;
        }
        bVar7.f15698d.setOnClickListener(new f(this));
        k6.b bVar8 = this.f13064e;
        if (bVar8 == null) {
            j.y("binding");
            bVar8 = null;
        }
        bVar8.f15699e.setText(R.string.contact_support);
        k6.b bVar9 = this.f13064e;
        if (bVar9 == null) {
            j.y("binding");
        } else {
            bVar2 = bVar9;
        }
        bVar2.f15699e.setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    public static final void Z0(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        bannedActivity.setResult(72);
        bannedActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void b1(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        CmbLinks.Companion.launchVerificationSupport(bannedActivity);
    }

    /* access modifiers changed from: private */
    public final void c1() {
        k6.b bVar = this.f13064e;
        k6.b bVar2 = null;
        if (bVar == null) {
            j.y("binding");
            bVar = null;
        }
        bVar.getRoot().setVisibility(0);
        k6.b bVar3 = this.f13064e;
        if (bVar3 == null) {
            j.y("binding");
            bVar3 = null;
        }
        bVar3.f15696b.setImageResource(R.drawable.banned_error);
        k6.b bVar4 = this.f13064e;
        if (bVar4 == null) {
            j.y("binding");
            bVar4 = null;
        }
        bVar4.f15700f.setText(R.string.banned_error_title);
        k6.b bVar5 = this.f13064e;
        if (bVar5 == null) {
            j.y("binding");
            bVar5 = null;
        }
        bVar5.f15697c.setText(R.string.banned_error_description);
        k6.b bVar6 = this.f13064e;
        if (bVar6 == null) {
            j.y("binding");
            bVar6 = null;
        }
        bVar6.f15698d.setText(R.string.check_status_page);
        k6.b bVar7 = this.f13064e;
        if (bVar7 == null) {
            j.y("binding");
            bVar7 = null;
        }
        bVar7.f15698d.setOnClickListener(new i(this));
        k6.b bVar8 = this.f13064e;
        if (bVar8 == null) {
            j.y("binding");
            bVar8 = null;
        }
        bVar8.f15699e.setText(R.string.got_it);
        k6.b bVar9 = this.f13064e;
        if (bVar9 == null) {
            j.y("binding");
        } else {
            bVar2 = bVar9;
        }
        bVar2.f15699e.setOnClickListener(new j(this));
    }

    /* access modifiers changed from: private */
    public static final void d1(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        CmbLinks.Companion.launchCmbStatusPage(bannedActivity);
    }

    /* access modifiers changed from: private */
    public static final void e1(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        bannedActivity.setResult(72);
        bannedActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void f1() {
        k6.b bVar = this.f13064e;
        k6.b bVar2 = null;
        if (bVar == null) {
            j.y("binding");
            bVar = null;
        }
        bVar.getRoot().setVisibility(0);
        k6.b bVar3 = this.f13064e;
        if (bVar3 == null) {
            j.y("binding");
            bVar3 = null;
        }
        bVar3.f15696b.setImageResource(R.drawable.verification_required_asset);
        k6.b bVar4 = this.f13064e;
        if (bVar4 == null) {
            j.y("binding");
            bVar4 = null;
        }
        bVar4.f15700f.setText(R.string.banned_rejected_title);
        k6.b bVar5 = this.f13064e;
        if (bVar5 == null) {
            j.y("binding");
            bVar5 = null;
        }
        bVar5.f15697c.setText(R.string.banned_rejected_description);
        k6.b bVar6 = this.f13064e;
        if (bVar6 == null) {
            j.y("binding");
            bVar6 = null;
        }
        bVar6.f15698d.setText(R.string.contact_support);
        k6.b bVar7 = this.f13064e;
        if (bVar7 == null) {
            j.y("binding");
            bVar7 = null;
        }
        bVar7.f15698d.setOnClickListener(new b(this));
        k6.b bVar8 = this.f13064e;
        if (bVar8 == null) {
            j.y("binding");
            bVar8 = null;
        }
        bVar8.f15699e.setText(R.string.got_it);
        k6.b bVar9 = this.f13064e;
        if (bVar9 == null) {
            j.y("binding");
        } else {
            bVar2 = bVar9;
        }
        bVar2.f15699e.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    public static final void g1(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        CmbLinks.Companion.launchVerificationSupport(bannedActivity);
    }

    /* access modifiers changed from: private */
    public static final void h1(BannedActivity bannedActivity, View view) {
        j.g(bannedActivity, "this$0");
        bannedActivity.setResult(72);
        bannedActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void i1(String str) {
        fa.a.f40771d.a(this.f13062c, "showVerificationMode(): " + str);
        k6.b bVar = this.f13064e;
        l lVar = null;
        if (bVar == null) {
            j.y("binding");
            bVar = null;
        }
        bVar.getRoot().setVisibility(8);
        l lVar2 = this.f13065f;
        if (lVar2 == null) {
            j.y("viewModel");
        } else {
            lVar = lVar2;
        }
        lVar.j(this.f13066g, str);
    }

    public final m R0() {
        m mVar = this.f13063d;
        if (mVar != null) {
            return mVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bakery.j().K1(this);
        VerificationStatus fromApiKey = VerificationStatus.Companion.fromApiKey(getIntent().getStringExtra(Extra.VERIFICATION_STATUS));
        String stringExtra = getIntent().getStringExtra(Extra.VERIFICATION_REFERENCE_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        fromApiKey.setReferenceId(stringExtra);
        BannedReason fromApiKey2 = BannedReason.Companion.fromApiKey(getIntent().getStringExtra(Extra.BANNED_REASON));
        l lVar = (l) new i0((l0) this, (i0.b) R0()).a(l.class);
        this.f13065f = lVar;
        k6.b bVar = null;
        if (lVar == null) {
            j.y("viewModel");
            lVar = null;
        }
        lVar.i(fromApiKey2, fromApiKey);
        k6.b c10 = k6.b.c(getLayoutInflater());
        j.f(c10, "inflate(layoutInflater)");
        this.f13064e = c10;
        if (c10 == null) {
            j.y("binding");
        } else {
            bVar = c10;
        }
        setContentView((View) bVar.getRoot());
        U0();
        T0();
    }
}
