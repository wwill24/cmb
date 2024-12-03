package com.coffeemeetsbagel.deactivate;

import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.deactivate.DeactivateCompPresenter;
import com.coffeemeetsbagel.deactivate.g;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.DeactivateReason;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.Reason;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.GetMyOwnProfileLocalUseCase;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.utils.model.Optional;
import com.facebook.internal.ServerProtocol;
import com.uber.autodispose.t;
import d7.g;
import fa.a;
import gk.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;
import qj.w;
import wb.c;

public final class DeactivateCompInteractor extends s<DeactivateCompPresenter, DeactivateCompRouter> implements DeactivateCompPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11983f;

    /* renamed from: g  reason: collision with root package name */
    public ProfileManager f11984g;

    /* renamed from: h  reason: collision with root package name */
    public a7.a f11985h;

    /* renamed from: j  reason: collision with root package name */
    public g f11986j;

    /* renamed from: k  reason: collision with root package name */
    public bb.a f11987k;

    /* renamed from: l  reason: collision with root package name */
    public FeatureFlagRepository f11988l;

    /* renamed from: m  reason: collision with root package name */
    public GetMyOwnProfileLocalUseCase f11989m;

    /* renamed from: n  reason: collision with root package name */
    public c f11990n;

    /* renamed from: p  reason: collision with root package name */
    private final f f11991p = b.b(new DeactivateCompInteractor$reasons$2(this));

    /* renamed from: q  reason: collision with root package name */
    private final List<DeactivateReason> f11992q = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private String f11993t = "";

    /* renamed from: w  reason: collision with root package name */
    private boolean f11994w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final String f11995x = "DeactivateCompInteractor";
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final AtomicReference<CmbLinks.PayItForwardSurveyParameters> f11996y = new AtomicReference<>();

    public static final class a implements ProfileContract$Manager.a<ResponseGeneric> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DeactivateCompInteractor f11997a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z9.g f11998b;

        a(DeactivateCompInteractor deactivateCompInteractor, z9.g gVar) {
            this.f11997a = deactivateCompInteractor;
            this.f11998b = gVar;
        }

        /* renamed from: a */
        public void onSuccess(ResponseGeneric responseGeneric) {
            j.g(responseGeneric, MamElements.MamResultExtension.ELEMENT);
            this.f11997a.W1().b(((g.a) ((DeactivateCompRouter) this.f11997a.B1()).e()).a(), true, this.f11998b, AnalyticsConstants$Logout.USER_INITIATED, new String[0]);
        }

        public void onError(Throwable th2) {
            j.g(th2, "t");
            fa.a.f40771d.c(this.f11997a.f11995x, String.valueOf(th2.getMessage()), th2);
        }
    }

    public static final class b implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DeactivateCompInteractor f11999a;

        b(DeactivateCompInteractor deactivateCompInteractor) {
            this.f11999a = deactivateCompInteractor;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            String str;
            a.C0491a aVar = fa.a.f40771d;
            String str2 = null;
            if (cmbErrorCode != null) {
                str = cmbErrorCode.getErrorMessage();
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            if (cmbErrorCode != null) {
                str2 = cmbErrorCode.getErrorMessage();
            }
            aVar.c("DeactivateComponentInteractor", valueOf, new Throwable(str2));
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            this.f11999a.V1().c("On Hold By User", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
    }

    public DeactivateCompInteractor(boolean z10) {
        this.f11983f = z10;
    }

    private final int N1(List<? extends Reason> list) {
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += ((Reason) list.get(i11)).getIntValue();
        }
        return i10;
    }

    private final void P1() {
        List<DeactivateReason> list = this.f11992q;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (DeactivateReason reasonId : list) {
            arrayList.add(reasonId.getReasonId());
        }
        if (!this.f11983f) {
            h2(arrayList);
        }
        if (arrayList.contains(Reason.IN_A_MATCH)) {
            if (X1().A("PayItForward.Android")) {
                CmbLinks.PayItForwardSurveyParameters payItForwardSurveyParameters = this.f11996y.get();
                j.f(payItForwardSurveyParameters, "surveyLinkParameters.get()");
                ((DeactivateCompRouter) B1()).A(payItForwardSurveyParameters);
            } else if (!this.f11994w) {
                this.f11994w = true;
                ((DeactivateCompRouter) B1()).B();
            }
        } else if (this.f11983f) {
            Q1(arrayList);
        } else {
            ((DeactivateCompRouter) B1()).r(q.m(new Pair(Extra.ON_HOLD_INDEFINITELY, Boolean.TRUE), new Pair(Extra.INPUT_REASON, this.f11993t)));
        }
    }

    private final void Q1(List<? extends Reason> list) {
        c2().U(new a(this, new k(this)), Integer.valueOf(N1(list)), this.f11993t);
    }

    /* access modifiers changed from: private */
    public static final void R1(DeactivateCompInteractor deactivateCompInteractor) {
        j.g(deactivateCompInteractor, "this$0");
        fa.a.f40771d.a(deactivateCompInteractor.f11995x, "Not yet implemented");
    }

    /* access modifiers changed from: private */
    public static final void T1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void U1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final int a2(boolean z10) {
        return z10 ? R.string.delete_reason : R.string.pause_account_section_title;
    }

    /* access modifiers changed from: private */
    public final List<DeactivateReason> b2() {
        Boolean bool;
        String str;
        NetworkProfile j10 = c2().j();
        if (j10 != null) {
            bool = Boolean.valueOf(j10.isFemale());
        } else {
            bool = null;
        }
        DeactivateReason[] deactivateReasonArr = new DeactivateReason[8];
        Reason reason = Reason.BUSY;
        if (j.b(bool, Boolean.TRUE)) {
            str = e2().a(R.string.reason_busy_female, new Object[0]);
        } else {
            str = e2().a(R.string.reason_busy_male, new Object[0]);
        }
        deactivateReasonArr[0] = new DeactivateReason(reason, false, str);
        deactivateReasonArr[1] = new DeactivateReason(Reason.NOT_HEARING_BACK, false, e2().a(R.string.hold_reason_hearing_back, new Object[0]));
        deactivateReasonArr[2] = new DeactivateReason(Reason.IN_A_MATCH, false, e2().a(R.string.hold_reason_met_someone_cmb, new Object[0]));
        deactivateReasonArr[3] = new DeactivateReason(Reason.MATCHED_ELSEWHERE, false, e2().a(R.string.hold_reason_met_someone_elsewhere, new Object[0]));
        deactivateReasonArr[4] = new DeactivateReason(Reason.DISLIKES_MATCHES, false, e2().a(R.string.reason_not_happy_female, new Object[0]));
        deactivateReasonArr[5] = new DeactivateReason(Reason.PREFER_OTHER_SERVICES, false, e2().a(R.string.hold_reason_prefer_others, new Object[0]));
        deactivateReasonArr[6] = new DeactivateReason(Reason.PREFER_OFFLINE_DATING, false, e2().a(R.string.hold_reason_doesnt_prefer_online, new Object[0]));
        deactivateReasonArr[7] = new DeactivateReason(Reason.OTHER, false, e2().a(R.string.other, new Object[0]));
        return q.f(deactivateReasonArr);
    }

    private final List<DeactivateReason> d2() {
        return (List) this.f11991p.getValue();
    }

    private final void g2() {
        boolean z10;
        List<DeactivateReason> list = this.f11992q;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            P1();
        }
    }

    private final void h2(List<? extends Reason> list) {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateOnHold(true);
        modelProfileUpdateDelta.updateReasons(list);
        modelProfileUpdateDelta.updateReactivateDate((String) null);
        modelProfileUpdateDelta.updateInputReason(this.f11993t);
        c2().p(new b(this), modelProfileUpdateDelta, true);
        c2().v0(true);
        c2().w0(this.f11993t);
    }

    private final void i2(int i10) {
        DeactivateReason deactivateReason = d2().get(i10);
        boolean z10 = true;
        deactivateReason.setChecked(!deactivateReason.getChecked());
        if (deactivateReason.getChecked()) {
            this.f11992q.add(deactivateReason);
        } else {
            this.f11992q.remove(deactivateReason);
        }
        if (deactivateReason.getReasonId() == Reason.OTHER) {
            if (deactivateReason.getChecked()) {
                ((DeactivateCompRouter) B1()).z();
            } else {
                this.f11993t = "";
            }
        }
        ((DeactivateCompPresenter) this.f7875e).t(i10);
        DeactivateCompPresenter deactivateCompPresenter = (DeactivateCompPresenter) this.f7875e;
        List<DeactivateReason> list = this.f11992q;
        if (list != null && !list.isEmpty()) {
            z10 = false;
        }
        deactivateCompPresenter.v(z10);
    }

    public void O1() {
        g2();
        V1().i("rating dialog dismissed clicked outside");
    }

    public void Q(int i10) {
        i2(i10);
    }

    public boolean S1(int i10) {
        if (i10 != 4) {
            return false;
        }
        V1().i("rating dialog dismissed back button");
        ((DeactivateCompRouter) B1()).q();
        g2();
        return true;
    }

    public void V0(String str) {
        if (str != null) {
            this.f11993t = str;
        }
    }

    public final a7.a V1() {
        a7.a aVar = this.f11985h;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final d7.g W1() {
        d7.g gVar = this.f11986j;
        if (gVar != null) {
            return gVar;
        }
        j.y("authManager");
        return null;
    }

    public final FeatureFlagRepository X1() {
        FeatureFlagRepository featureFlagRepository = this.f11988l;
        if (featureFlagRepository != null) {
            return featureFlagRepository;
        }
        j.y("featureFlagRepo");
        return null;
    }

    public final c Y1() {
        c cVar = this.f11990n;
        if (cVar != null) {
            return cVar;
        }
        j.y("getActiveSubscriptionUseCase");
        return null;
    }

    public final GetMyOwnProfileLocalUseCase Z1() {
        GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase = this.f11989m;
        if (getMyOwnProfileLocalUseCase != null) {
            return getMyOwnProfileLocalUseCase;
        }
        j.y("getMyOwnProfileLocalUseCase");
        return null;
    }

    public final ProfileManager c2() {
        ProfileManager profileManager = this.f11984g;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public void d0() {
        g2();
    }

    public final bb.a e2() {
        bb.a aVar = this.f11987k;
        if (aVar != null) {
            return aVar;
        }
        j.y("stringProvider");
        return null;
    }

    public void f2() {
        ((DeactivateCompRouter) B1()).u();
        ((DeactivateCompRouter) B1()).q();
        V1().d("rating dialog went to store");
        ((DeactivateCompRouter) B1()).r(p.e(new Pair(Extra.ON_HOLD_INDEFINITELY, Boolean.TRUE)));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((DeactivateCompPresenter) this.f7875e).w(d2());
        ((DeactivateCompPresenter) this.f7875e).u(a2(this.f11983f));
        if (X1().A("PayItForward.Android")) {
            ck.b bVar = ck.b.f24947a;
            w<Triple<ja.b, l, List<Photo>>> L = Z1().c().L();
            j.f(L, "getMyOwnProfileLocalUseCase().firstOrError()");
            w<Optional<vb.a>> L2 = Y1().a().L();
            j.f(L2, "getActiveSubscriptionUseCase().firstOrError()");
            ((t) bVar.a(L, L2).g(com.uber.autodispose.a.a(this))).b(new i(new DeactivateCompInteractor$didBecomeActive$1(this)), new j(new DeactivateCompInteractor$didBecomeActive$2(this)));
        }
    }
}
