package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.b;
import androidx.appcompat.app.c;
import androidx.lifecycle.a0;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import coil.ImageLoader;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate;
import com.withpersona.sdk2.inquiry.launchers.k;
import com.withpersona.sdk2.inquiry.launchers.q;
import com.withpersona.sdk2.inquiry.launchers.u;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderConfig;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput;
import gk.f;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;
import ui.e;

public final class InquiryActivity extends c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f26084d = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final f f26085c = new h0(l.b(InquiryViewModel.class), new InquiryActivity$special$$inlined$viewModels$default$2(this), new InquiryActivity$special$$inlined$viewModels$default$1(this), new InquiryActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    public static final class InquiryViewModel extends f0 {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final a0 f26086d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public g f26087e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public i<InquiryWorkflow.a> f26088f;

        /* renamed from: g  reason: collision with root package name */
        private Environment f26089g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final d<InquiryWorkflow.Output> f26090h = g.b(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);

        /* renamed from: i  reason: collision with root package name */
        private final e f26091i;

        /* renamed from: j  reason: collision with root package name */
        private final u<Uri, Boolean> f26092j;

        /* renamed from: k  reason: collision with root package name */
        private final u<androidx.activity.result.e, List<Uri>> f26093k;

        /* renamed from: l  reason: collision with root package name */
        private final u<String[], List<Uri>> f26094l;

        /* renamed from: m  reason: collision with root package name */
        private final u<String, Boolean> f26095m;

        /* renamed from: n  reason: collision with root package name */
        private final u<String[], Uri> f26096n;

        /* renamed from: o  reason: collision with root package name */
        private final u<PassportNfcReaderConfig, PassportNfcReaderOutput> f26097o;

        /* renamed from: p  reason: collision with root package name */
        private final f f26098p;

        public InquiryViewModel(a0 a0Var) {
            j.g(a0Var, "savedStateHandle");
            this.f26086d = a0Var;
            this.f26091i = new e(a0Var);
            this.f26092j = com.withpersona.sdk2.inquiry.launchers.e.h();
            this.f26093k = com.withpersona.sdk2.inquiry.launchers.e.f();
            this.f26094l = com.withpersona.sdk2.inquiry.launchers.e.d();
            this.f26095m = q.b();
            this.f26096n = k.b();
            this.f26097o = com.withpersona.sdk2.inquiry.nfc.e.b();
            this.f26098p = b.b(new InquiryActivity$InquiryViewModel$renderings$2(this));
        }

        private final void u(b bVar) {
            this.f26092j.e(bVar);
            this.f26093k.e(bVar);
            this.f26094l.e(bVar);
            this.f26095m.e(bVar);
            this.f26096n.e(bVar);
            this.f26097o.e(bVar);
        }

        public final e j() {
            return this.f26091i;
        }

        public final u<String[], Uri> k() {
            return this.f26096n;
        }

        public final u<String[], List<Uri>> l() {
            return this.f26094l;
        }

        public final u<PassportNfcReaderConfig, PassportNfcReaderOutput> m() {
            return this.f26097o;
        }

        public final u<Uri, Boolean> n() {
            return this.f26092j;
        }

        public final r<Object> o() {
            return (r) this.f26098p.getValue();
        }

        public final u<String, Boolean> p() {
            return this.f26095m;
        }

        public final u<androidx.activity.result.e, List<Uri>> q() {
            return this.f26093k;
        }

        public final void r(b bVar, g gVar, InquiryWorkflow.a aVar, Environment environment) {
            j.g(bVar, "activityResultCaller");
            j.g(gVar, "component");
            j.g(aVar, "props");
            j.g(environment, "environment");
            this.f26087e = gVar;
            this.f26089g = environment;
            i<InquiryWorkflow.a> iVar = this.f26088f;
            if (iVar != null) {
                if (iVar == null) {
                    j.y("props");
                    iVar = null;
                }
                iVar.setValue(aVar);
            } else {
                this.f26088f = s.a(aVar);
            }
            u(bVar);
        }

        public final void s() {
            ImageLoader f10;
            g gVar = this.f26087e;
            if (gVar != null && (f10 = gVar.f()) != null) {
                f10.shutdown();
            }
        }

        public final void t(Context context) {
            com.withpersona.sdk2.inquiry.shared.device.a b10;
            j.g(context, "applicationContext");
            g gVar = this.f26087e;
            if (gVar != null && (b10 = gVar.b()) != null) {
                b10.a(context);
            }
        }

        public final Object v(kotlin.coroutines.c<? super InquiryWorkflow.Output> cVar) {
            return this.f26090h.E(cVar);
        }

        public final com.squareup.workflow1.ui.s w() {
            g gVar = this.f26087e;
            if (gVar != null) {
                return gVar.c();
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str) {
            if (str != null) {
                return StringsKt__StringsKt.N0(str, "Bearer ", (String) null, 2, (Object) null);
            }
            return null;
        }
    }

    private final String D0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("ACCOUNT_ID_KEY");
        }
        return null;
    }

    private final boolean E0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean("ENABLE_ERROR_LOGGING", true);
        }
        return true;
    }

    private final Environment F0() {
        String str;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            str = extras.getString("ENVIRONMENT_KEY");
        } else {
            str = null;
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -2056856391) {
                if (hashCode == -1711584601 && str.equals("SANDBOX")) {
                    return Environment.SANDBOX;
                }
            } else if (str.equals("PRODUCTION")) {
                return Environment.PRODUCTION;
            }
        }
        return Environment.PRODUCTION;
    }

    private final InquiryFieldsMap G0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return (InquiryFieldsMap) extras.getParcelable("FIELDS_MAP_KEY");
        }
        return null;
    }

    private final String H0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("INQUIRY_ID_KEY");
        }
        return null;
    }

    private final String I0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("REFERENCE_ID_KEY");
        }
        return null;
    }

    private final boolean J0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean("RETURN_COLLECTED_DATA", false);
        }
        return false;
    }

    private final String K0() {
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("SERVER_ENDPOINT", "https://withpersona.com") : null;
        return string == null ? "https://withpersona.com" : string;
    }

    private final String L0() {
        String string;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (string = extras.getString("SESSION_TOKEN_KEY")) == null) {
            return null;
        }
        return "Bearer " + string;
    }

    private final boolean M0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean("SHOULD_AUTO_FALLBACK", false);
        }
        return false;
    }

    private final StaticInquiryTemplate N0() {
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                return (StaticInquiryTemplate) extras.getParcelable("STATIC_INQUIRY_TEMPLATE_KEY", StaticInquiryTemplate.class);
            }
            return null;
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            return (StaticInquiryTemplate) extras2.getParcelable("STATIC_INQUIRY_TEMPLATE_KEY");
        }
        return null;
    }

    private final String O0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("TEMPLATE_ID_KEY");
        }
        return null;
    }

    private final String P0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString("TEMPLATE_VERSION_KEY");
        }
        return null;
    }

    private final Integer Q0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return Integer.valueOf(extras.getInt("THEME_KEY"));
        }
        return null;
    }

    private final boolean R0() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean("USE_SERVER_STYLES", true);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final InquiryViewModel S0() {
        return (InquiryViewModel) this.f26085c.getValue();
    }

    private final boolean T0() {
        String L0 = L0();
        if (L0 == null || !StringsKt__StringsKt.N(L0, 10, false, 2, (Object) null)) {
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("PERSONA_ACTIVITY_RESULT", "INQUIRY_ERROR");
        intent.putExtra("ERROR_DEBUG_MESSAGE_KEY", "Invalid session token.");
        Unit unit = Unit.f32013a;
        setResult(0, intent);
        finish();
        return false;
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$a] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r22) {
        /*
            r21 = this;
            r0 = r21
            mi.d.a(r21)
            boolean r1 = r21.E0()
            if (r1 == 0) goto L_0x000e
            mi.d.d(r21)
        L_0x000e:
            super.onCreate(r22)
            boolean r1 = r21.T0()
            if (r1 != 0) goto L_0x0018
            return
        L_0x0018:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "PERSONA_ACTIVITY_RESULT"
            java.lang.String r3 = "INQUIRY_CANCELED"
            r1.putExtra(r2, r3)
            java.lang.String r2 = r21.H0()
            java.lang.String r3 = "INQUIRY_ID_KEY"
            r1.putExtra(r3, r2)
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$a r2 = f26084d
            java.lang.String r3 = r21.L0()
            java.lang.String r2 = r2.a(r3)
            java.lang.String r3 = "SESSION_TOKEN_KEY"
            r1.putExtra(r3, r2)
            kotlin.Unit r2 = kotlin.Unit.f32013a
            r2 = 0
            r0.setResult(r2, r1)
            java.lang.Integer r1 = r21.Q0()
            if (r1 == 0) goto L_0x004f
            int r1 = r1.intValue()
            r0.setTheme(r1)
        L_0x004f:
            java.lang.String r1 = r21.getPackageName()
            java.lang.String r3 = "packageName"
            kotlin.jvm.internal.j.f(r1, r3)
            java.lang.String r3 = "com.withpersona"
            r4 = 2
            r5 = 0
            boolean r1 = kotlin.text.r.J(r1, r3, r2, r4, r5)
            if (r1 == 0) goto L_0x0067
            java.lang.String r1 = r21.K0()
            goto L_0x0069
        L_0x0067:
            java.lang.String r1 = "https://withpersona.com"
        L_0x0069:
            boolean r3 = r21.J0()
            if (r3 == 0) goto L_0x0078
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r3 = r21.S0()
            ui.e r3 = r3.j()
            goto L_0x007d
        L_0x0078:
            ui.d r3 = new ui.d
            r3.<init>()
        L_0x007d:
            boolean r6 = r21.M0()
            if (r6 == 0) goto L_0x008b
            com.withpersona.sdk2.inquiry.internal.fallbackmode.b r6 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.b
            com.withpersona.sdk2.inquiry.internal.fallbackmode.d$a r7 = com.withpersona.sdk2.inquiry.internal.fallbackmode.d.a.f26376a
            r6.<init>(r7)
            goto L_0x00b0
        L_0x008b:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate r6 = r21.N0()
            boolean r7 = r6 instanceof com.withpersona.sdk2.inquiry.internal.fallbackmode.LocalStaticInquiryTemplate
            if (r7 == 0) goto L_0x0096
            com.withpersona.sdk2.inquiry.internal.fallbackmode.LocalStaticInquiryTemplate r6 = (com.withpersona.sdk2.inquiry.internal.fallbackmode.LocalStaticInquiryTemplate) r6
            goto L_0x0097
        L_0x0096:
            r6 = r5
        L_0x0097:
            if (r6 == 0) goto L_0x00a9
            com.withpersona.sdk2.inquiry.internal.fallbackmode.b r7 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.b
            com.withpersona.sdk2.inquiry.internal.fallbackmode.d$b r8 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.d$b
            int r6 = r6.a()
            r8.<init>(r6)
            r7.<init>(r8)
            r6 = r7
            goto L_0x00b0
        L_0x00a9:
            com.withpersona.sdk2.inquiry.internal.fallbackmode.b r6 = new com.withpersona.sdk2.inquiry.internal.fallbackmode.b
            com.withpersona.sdk2.inquiry.internal.fallbackmode.d$a r7 = com.withpersona.sdk2.inquiry.internal.fallbackmode.d.a.f26376a
            r6.<init>(r7)
        L_0x00b0:
            com.withpersona.sdk2.inquiry.internal.b$b r7 = com.withpersona.sdk2.inquiry.internal.b.a()
            com.withpersona.sdk2.inquiry.internal.d r8 = new com.withpersona.sdk2.inquiry.internal.d
            r8.<init>(r0)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.f(r8)
            com.withpersona.sdk2.inquiry.launchers.a r8 = new com.withpersona.sdk2.inquiry.launchers.a
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r9 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r9 = r9.n()
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r10 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r10 = r10.l()
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r11 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r11 = r11.q()
            r8.<init>(r9, r10, r11)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.d(r8)
            com.withpersona.sdk2.inquiry.launchers.i r8 = new com.withpersona.sdk2.inquiry.launchers.i
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r9 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r9 = r9.k()
            r8.<init>(r9)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.e(r8)
            com.withpersona.sdk2.inquiry.launchers.o r8 = new com.withpersona.sdk2.inquiry.launchers.o
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r9 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r9 = r9.p()
            r8.<init>(r9)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.j(r8)
            com.withpersona.sdk2.inquiry.nfc.c r8 = new com.withpersona.sdk2.inquiry.nfc.c
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r9 = r21.S0()
            com.withpersona.sdk2.inquiry.launchers.u r9 = r9.m()
            r8.<init>(r9)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.i(r8)
            com.withpersona.sdk2.inquiry.network.NetworkModule r8 = new com.withpersona.sdk2.inquiry.network.NetworkModule
            boolean r9 = r21.R0()
            r8.<init>(r9)
            com.withpersona.sdk2.inquiry.internal.b$b r7 = r7.h(r8)
            ui.b r8 = new ui.b
            r8.<init>(r3)
            com.withpersona.sdk2.inquiry.internal.b$b r3 = r7.c(r8)
            com.withpersona.sdk2.inquiry.internal.network.c r7 = new com.withpersona.sdk2.inquiry.internal.network.c
            r7.<init>(r1)
            com.withpersona.sdk2.inquiry.internal.b$b r1 = r3.g(r7)
            com.withpersona.sdk2.inquiry.internal.b$b r1 = r1.a(r6)
            com.withpersona.sdk2.inquiry.internal.g r1 = r1.b()
            ji.a r3 = r1.a()
            boolean r6 = r21.M0()
            if (r6 != 0) goto L_0x0148
            com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate r6 = r21.N0()
            if (r6 == 0) goto L_0x0149
        L_0x0148:
            r2 = 1
        L_0x0149:
            r3.b(r2)
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r2 = r21.S0()
            com.withpersona.sdk2.inquiry.internal.Environment r3 = r21.F0()
            java.lang.String r6 = r21.H0()
            if (r6 == 0) goto L_0x0173
            com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$a r6 = new com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$a
            java.lang.String r7 = r21.H0()
            kotlin.jvm.internal.j.d(r7)
            java.lang.String r8 = r21.L0()
            com.withpersona.sdk2.inquiry.internal.Environment r9 = r21.F0()
            java.lang.Integer r10 = r21.Q0()
            r6.<init>(r7, r8, r9, r10)
            goto L_0x01a8
        L_0x0173:
            java.lang.String r12 = r21.O0()
            java.lang.String r13 = r21.P0()
            java.lang.String r14 = r21.D0()
            java.lang.String r15 = r21.I0()
            com.withpersona.sdk2.inquiry.internal.InquiryFieldsMap r6 = r21.G0()
            if (r6 == 0) goto L_0x0190
            java.util.Map r6 = r6.a()
            r16 = r6
            goto L_0x0192
        L_0x0190:
            r16 = r5
        L_0x0192:
            com.withpersona.sdk2.inquiry.internal.Environment r19 = r21.F0()
            java.lang.Integer r20 = r21.Q0()
            com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate r17 = r21.N0()
            boolean r18 = r21.M0()
            com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$b r6 = new com.withpersona.sdk2.inquiry.internal.InquiryWorkflow$a$b
            r11 = r6
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
        L_0x01a8:
            java.lang.String r7 = "component"
            kotlin.jvm.internal.j.f(r1, r7)
            r2.r(r0, r1, r6, r3)
            com.squareup.workflow1.ui.WorkflowLayout r2 = new com.squareup.workflow1.ui.WorkflowLayout
            r2.<init>(r0, r5, r4, r5)
            androidx.lifecycle.Lifecycle r3 = r21.getLifecycle()
            java.lang.String r4 = "lifecycle"
            kotlin.jvm.internal.j.f(r3, r4)
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r4 = r21.S0()
            kotlinx.coroutines.flow.r r4 = r4.o()
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$InquiryViewModel r6 = r21.S0()
            com.squareup.workflow1.ui.s r6 = r6.w()
            r2.b(r3, r4, r6)
            r0.setContentView((android.view.View) r2)
            androidx.lifecycle.g r7 = androidx.lifecycle.m.a(r21)
            r8 = 0
            r9 = 0
            com.withpersona.sdk2.inquiry.internal.InquiryActivity$onCreate$4 r10 = new com.withpersona.sdk2.inquiry.internal.InquiryActivity$onCreate$4
            r10.<init>(r0, r1, r5)
            r11 = 3
            r12 = 0
            kotlinx.coroutines.s1 unused = kotlinx.coroutines.j.d(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.InquiryActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        S0().s();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            mi.d.e(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        InquiryViewModel S0 = S0();
        Context applicationContext = getApplicationContext();
        j.f(applicationContext, "this.applicationContext");
        S0.t(applicationContext);
    }
}
