package j5;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import b6.l;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLogin;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.DialogFullscreenSingleButton;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.sync.r;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.store.k0;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import d7.b;
import h5.i;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lc.c;
import lc.z;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.xdata.FormField;
import z9.d;
import z9.f;

public abstract class h extends l implements f, b {

    /* renamed from: e  reason: collision with root package name */
    public Toolbar f15594e;

    /* renamed from: f  reason: collision with root package name */
    public CollapsingToolbarLayout f15595f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f15596g;

    /* renamed from: h  reason: collision with root package name */
    protected CmbToolbar f15597h;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f15598j;

    /* renamed from: k  reason: collision with root package name */
    private Fragment f15599k;

    /* renamed from: l  reason: collision with root package name */
    private CopyOnWriteArrayList<d> f15600l;

    /* renamed from: m  reason: collision with root package name */
    private r7.h f15601m;

    /* renamed from: n  reason: collision with root package name */
    private Dialog f15602n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15603p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f15604q;

    /* renamed from: t  reason: collision with root package name */
    private int f15605t;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15606a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15606a = r0
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.UPGRADE_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15606a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PURGE_LOCAL_DATABASE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j5.h.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(DialogInterface dialogInterface) {
        this.f15602n.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1() {
        Dialog dialog = this.f15602n;
        if (dialog == null) {
            Dialog y12 = y1();
            this.f15602n = y12;
            y12.setOnDismissListener(new e(this));
        } else if (!dialog.isShowing() && !this.f15604q) {
            this.f15604q = true;
            this.f15602n.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit q1() {
        lc.l.c(this);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1() {
        if (!this.f15603p) {
            DialogPrimarySecondaryVertical.f12065a.b(this, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.cmb_logo), t9.a.softUpgradeTitle, t9.a.softUpgradeText, t9.a.softUpgradePrimaryButton, new f(this), t9.a.softUpgradeSecondaryButton, (Function0<Unit>) null, (Function0<Unit>) null);
            this.f15603p = true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s1() {
        c.h(this.f15601m);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(Bundle bundle) {
        r7.h hVar = new r7.h(this);
        this.f15601m = hVar;
        hVar.show();
        String string = bundle.getString(Extra.PURGE_HEADER);
        z1(R.string.problem_with_account_relogin);
        R0().j(this, false, new d(this), string, AnalyticsConstants$Logout.AUTOMATIC, "Purge Local DB");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit u1() {
        lc.l.c(this);
        return null;
    }

    private Dialog y1() {
        return new DialogFullscreenSingleButton(this, R.drawable.cmb_logo, t9.a.hardUpgradeTitle, t9.a.hardUpgradeText, t9.a.hardUpgradeButton, DialogFullscreenSingleButton.PrimaryCtaStyle.NORMAL, new g(this));
    }

    /* access modifiers changed from: protected */
    public void M0() {
        Fragment O0 = O0();
        this.f15599k = O0;
        N0(O0);
    }

    /* access modifiers changed from: protected */
    public void N0(Fragment fragment) {
        getSupportFragmentManager().p().b(Y0(), fragment).i();
    }

    /* access modifiers changed from: protected */
    public abstract Fragment O0();

    public a7.a P0() {
        return Bakery.w().z();
    }

    public b7.c Q0() {
        return Bakery.w().e();
    }

    public d7.c R0() {
        return Bakery.w().g();
    }

    public j S0() {
        return Bakery.w().i();
    }

    public CmbToolbar T0() {
        return this.f15597h;
    }

    public a6.a U0() {
        return Bakery.w().l();
    }

    /* access modifiers changed from: protected */
    public CollapsingToolbarLayout V0() {
        return this.f15595f;
    }

    public v7.d W0() {
        return Bakery.w().o();
    }

    public s9.a X0() {
        return Bakery.w().s();
    }

    /* access modifiers changed from: protected */
    public int Y0() {
        return R.id.frameLayout_activity_fragment_container_master;
    }

    /* access modifiers changed from: protected */
    public abstract String Z0();

    /* access modifiers changed from: protected */
    public int b1() {
        return R.layout.activity_single_fragment;
    }

    public t8.l c1() {
        return Bakery.w().F();
    }

    public ProfileContract$Manager d1() {
        return Bakery.w().G();
    }

    public k0 e1() {
        return Bakery.w().C();
    }

    public t f1() {
        return Bakery.w().H();
    }

    public b9.a g1() {
        return Bakery.w().I();
    }

    public Fragment getFragment() {
        return this.f15599k;
    }

    public hb.c h1() {
        return Bakery.w().M();
    }

    public void i(BannedReason bannedReason, VerificationStatus verificationStatus) {
        Intent intent = new Intent(this, ActivityLogin.class);
        intent.setFlags(268468224);
        intent.putExtra(Extra.DID_LOG_OUT, true);
        intent.putExtra(Extra.IS_ACCOUNT_DELETED, false);
        intent.putExtra(Extra.BANNED_REASON, bannedReason.getApiReason());
        intent.putExtra(Extra.VERIFICATION_STATUS, verificationStatus.getApiStatus());
        intent.putExtra(Extra.VERIFICATION_REFERENCE_ID, verificationStatus.getReferenceId());
        startActivity(intent);
        finish();
    }

    public r i1() {
        return Bakery.w().D();
    }

    public Toolbar j1() {
        return this.f15594e;
    }

    /* access modifiers changed from: protected */
    public boolean k1() {
        boolean z10;
        synchronized (this) {
            Iterator<d> it = this.f15600l.iterator();
            z10 = false;
            while (it.hasNext()) {
                try {
                    it.next().a();
                    z10 = true;
                } catch (Exception e10) {
                    fa.a.i(e10);
                }
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public boolean l1() {
        finish();
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean m1(Bundle bundle, String str) {
        return getSupportFragmentManager().s0(bundle, str) != null;
    }

    public void n0(EventType eventType, Bundle bundle) {
        int i10 = a.f15606a[eventType.ordinal()];
        if (i10 == 1) {
            String string = bundle.getString(Extra.UPGRADE_AVAILABILITY);
            if (string != null && string.equals(FormField.Required.ELEMENT)) {
                runOnUiThread(new a(this));
            } else if (string == null || !string.equals(Session.Feature.OPTIONAL_ELEMENT)) {
                fa.a.i(new IllegalStateException("Unexpected upgrade type in upgrade header: " + string));
            } else {
                runOnUiThread(new b(this));
            }
        } else if (i10 == 2) {
            runOnUiThread(new c(this, bundle));
        }
    }

    /* access modifiers changed from: protected */
    public boolean n1(Fragment fragment) {
        return getSupportFragmentManager().v0().contains(fragment);
    }

    public void onBackPressed() {
        if (!k1()) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        if (getIntent() == null || !getIntent().getBooleanExtra(Extra.SHOW_DLS_THEME, false)) {
            this.f15605t = z.a();
        } else {
            this.f15605t = R.style.CmbAppTheme;
        }
        onApplyThemeResource(getTheme(), this.f15605t, false);
        super.onCreate(bundle);
        setContentView(b1());
        this.f15594e = (Toolbar) findViewById(R.id.toolbar);
        this.f15596g = (AppBarLayout) findViewById(R.id.appbarlayout);
        this.f15595f = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if (w1()) {
            Toolbar toolbar = this.f15594e;
            if (toolbar != null) {
                toolbar.setTitle((CharSequence) null);
                this.f15594e.removeAllViews();
                CmbToolbar cmbToolbar = (CmbToolbar) LayoutInflater.from(this).inflate(R.layout.cmb_toolbar, this.f15594e, false);
                this.f15597h = cmbToolbar;
                this.f15594e.addView(cmbToolbar);
                this.f15594e.setPadding(0, 0, 0, 0);
                this.f15594e.J(0, 0);
            }
        } else {
            Toolbar toolbar2 = this.f15594e;
            if (toolbar2 != null) {
                toolbar2.setVisibility(8);
            }
        }
        if (x1()) {
            if (bundle == null || !m1(bundle, Z0())) {
                M0();
            } else {
                this.f15599k = getSupportFragmentManager().s0(bundle, Z0());
            }
        }
        this.f15600l = new CopyOnWriteArrayList<>();
        this.f15598j = true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c.h(this.f15601m);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        i.d(this, EventType.UPGRADE_AVAILABLE, EventType.PURGE_LOCAL_DATABASE);
        R0().k((b) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!R0().m()) {
            l1();
        }
        i.a(this, EventType.UPGRADE_AVAILABLE, EventType.PURGE_LOCAL_DATABASE);
        R0().k(this);
        if (z.a() == this.f15605t) {
            return;
        }
        if (getIntent() == null || !getIntent().getBooleanExtra(Extra.SHOW_DLS_THEME, false)) {
            recreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Fragment fragment = this.f15599k;
        if (fragment != null && n1(fragment)) {
            getSupportFragmentManager().i1(bundle, Z0(), this.f15599k);
        }
    }

    public void v1(String str) {
        CmbToolbar cmbToolbar = this.f15597h;
        if (cmbToolbar != null) {
            cmbToolbar.setTitle(str);
        }
    }

    /* access modifiers changed from: protected */
    public boolean w1() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean x1() {
        return true;
    }

    public void z1(int i10) {
        View view;
        if (this instanceof ActivityMain) {
            view = getWindow().getDecorView().findViewById(R.id.main_coordinator_layout);
        } else {
            view = getWindow().getDecorView().findViewById(16908290);
        }
        sb.a.i(view, i10);
    }
}
