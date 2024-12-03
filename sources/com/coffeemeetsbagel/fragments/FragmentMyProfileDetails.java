package com.coffeemeetsbagel.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c9.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLocation;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;
import com.coffeemeetsbagel.dialogs.ChipSelectQuestionDialog;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.f0;
import com.coffeemeetsbagel.dialogs.g0;
import com.coffeemeetsbagel.dialogs.h0;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.enums.Ethnicity;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.Religion;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.profile.SaveMyProfileLocalUseCase;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.qna.GetUserMCQUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.util.RequestCode;
import com.jakewharton.rxrelay2.PublishRelay;
import com.mparticle.kits.AppsFlyerKit;
import com.mparticle.kits.ReportingMessage;
import com.uber.autodispose.t;
import fa.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smack.packet.Message;

public final class FragmentMyProfileDetails extends r7.b implements z9.f, d.a, w8.b {
    private static boolean A0;

    /* renamed from: y0  reason: collision with root package name */
    public static final a f13513y0 = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: z0  reason: collision with root package name */
    public static ModelProfileUpdateDelta f13514z0;
    private CmbEditText B;
    private CmbEditText C;
    private CmbEditText D;
    private DelayAutoCompleteTextView E;
    private DelayAutoCompleteTextView F;
    /* access modifiers changed from: private */
    public CmbTextView G;
    private CmbTextView H;
    private CmbEditText I;
    private CmbEditText J;
    private CmbEditText K;
    private NestedScrollView L;
    private LinearLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private LinearLayout P;
    private LinearLayout Q;
    private LinearLayout R;
    private LinearLayout S;
    private LinearLayout T;
    private LinearLayout U;
    private LinearLayout V;
    private LinearLayout W;
    private LinearLayout X;
    private CmbTextView Y;
    private CmbTextView Z;

    /* renamed from: a0  reason: collision with root package name */
    private CmbTextView f13515a0;

    /* renamed from: b0  reason: collision with root package name */
    private CmbTextView f13516b0;

    /* renamed from: c0  reason: collision with root package name */
    private CmbTextView f13517c0;

    /* renamed from: d  reason: collision with root package name */
    public r f13518d;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public NetworkProfile f13519d0;

    /* renamed from: e  reason: collision with root package name */
    public GetUserMCQUseCase f13520e;

    /* renamed from: e0  reason: collision with root package name */
    private Dialog f13521e0;

    /* renamed from: f  reason: collision with root package name */
    public com.coffeemeetsbagel.qna.e f13522f;

    /* renamed from: f0  reason: collision with root package name */
    private Dialog f13523f0;

    /* renamed from: g  reason: collision with root package name */
    public com.coffeemeetsbagel.qna.j f13524g;

    /* renamed from: g0  reason: collision with root package name */
    private ChipSelectQuestionDialog f13525g0;

    /* renamed from: h  reason: collision with root package name */
    public SaveAnswerUseCase f13526h;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public h0<com.coffeemeetsbagel.dialogs.e> f13527h0;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public h0<com.coffeemeetsbagel.dialogs.e> f13528i0;

    /* renamed from: j  reason: collision with root package name */
    public c9.a f13529j;
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public f0<com.coffeemeetsbagel.dialogs.e> f13530j0;

    /* renamed from: k  reason: collision with root package name */
    public GetSingleSchoolsUseCase f13531k;
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public final Map<String, String> f13532k0 = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public SaveProfilesLocalUseCase f13533l;
    /* access modifiers changed from: private */

    /* renamed from: l0  reason: collision with root package name */
    public final List<String> f13534l0 = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    public SaveMyProfileLocalUseCase f13535m;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public final PublishRelay<Pair<QuestionWAnswers, String>> f13536m0;

    /* renamed from: n  reason: collision with root package name */
    private CmbTextView f13537n;

    /* renamed from: n0  reason: collision with root package name */
    private final jc.b<Void> f13538n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public List<Resource> f13539o0;

    /* renamed from: p  reason: collision with root package name */
    private CmbEditText f13540p;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public Map<String, String> f13541p0;

    /* renamed from: q  reason: collision with root package name */
    private CmbTextView f13542q;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public String f13543q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public String f13544r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public String f13545s0;

    /* renamed from: t  reason: collision with root package name */
    private CmbTextView f13546t;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public String f13547t0;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public String f13548u0;

    /* renamed from: v0  reason: collision with root package name */
    private w8.a f13549v0;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public CmbTextView f13550w;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public s7.b f13551w0;

    /* renamed from: x  reason: collision with root package name */
    private CmbTextView f13552x;
    /* access modifiers changed from: private */

    /* renamed from: x0  reason: collision with root package name */
    public h0<com.coffeemeetsbagel.dialogs.k> f13553x0;

    /* renamed from: y  reason: collision with root package name */
    private CmbTextView f13554y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public CmbTextView f13555z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13556a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f13557b;

        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|(2:79|80)|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|83) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00b3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00c3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x00db */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00e3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00eb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00f3 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.ProfileQuestion[] r0 = com.coffeemeetsbagel.models.enums.ProfileQuestion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.models.enums.ProfileQuestion r2 = com.coffeemeetsbagel.models.enums.ProfileQuestion.EMPLOYER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.models.enums.ProfileQuestion r3 = com.coffeemeetsbagel.models.enums.ProfileQuestion.OCCUPATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.coffeemeetsbagel.models.enums.ProfileQuestion r4 = com.coffeemeetsbagel.models.enums.ProfileQuestion.ICEBREAKER_ONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.coffeemeetsbagel.models.enums.ProfileQuestion r5 = com.coffeemeetsbagel.models.enums.ProfileQuestion.ICEBREAKER_TWO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.coffeemeetsbagel.models.enums.ProfileQuestion r6 = com.coffeemeetsbagel.models.enums.ProfileQuestion.ICEBREAKER_THREE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.coffeemeetsbagel.models.enums.ProfileQuestion r7 = com.coffeemeetsbagel.models.enums.ProfileQuestion.SCHOOL_ONE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r7 = 7
                com.coffeemeetsbagel.models.enums.ProfileQuestion r8 = com.coffeemeetsbagel.models.enums.ProfileQuestion.SCHOOL_TWO     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                r8 = 8
                com.coffeemeetsbagel.models.enums.ProfileQuestion r9 = com.coffeemeetsbagel.models.enums.ProfileQuestion.LOCATION     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r0[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                r9 = 9
                com.coffeemeetsbagel.models.enums.ProfileQuestion r10 = com.coffeemeetsbagel.models.enums.ProfileQuestion.RELIGION     // Catch:{ NoSuchFieldError -> 0x005a }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r0[r10] = r9     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                r10 = 10
                com.coffeemeetsbagel.models.enums.ProfileQuestion r11 = com.coffeemeetsbagel.models.enums.ProfileQuestion.ETHNICITY     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r0[r11] = r10     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                r11 = 11
                com.coffeemeetsbagel.models.enums.ProfileQuestion r12 = com.coffeemeetsbagel.models.enums.ProfileQuestion.DEGREE_ONE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r12] = r11     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                r12 = 12
                com.coffeemeetsbagel.models.enums.ProfileQuestion r13 = com.coffeemeetsbagel.models.enums.ProfileQuestion.DEGREE_TWO     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r13] = r12     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r13 = 13
                com.coffeemeetsbagel.models.enums.ProfileQuestion r14 = com.coffeemeetsbagel.models.enums.ProfileQuestion.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r14] = r13     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                f13556a = r0
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory[] r0 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r14 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r0[r14] = r1     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.EDUCATION     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.RELIGION     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.ETHNICITY     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.OCCUPATION     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.EMPLOYER     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.ACTIVITY_REPORT     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.ICE_BREAKERS     // Catch:{ NoSuchFieldError -> 0x00cb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cb }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.DATING_STYLE     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.PERSONALITY     // Catch:{ NoSuchFieldError -> 0x00db }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00db }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x00db }
            L_0x00db:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.VALUES     // Catch:{ NoSuchFieldError -> 0x00e3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e3 }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x00e3 }
            L_0x00e3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.INTERESTS     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r0[r1] = r12     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.HOMETOWN     // Catch:{ NoSuchFieldError -> 0x00f3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f3 }
                r0[r1] = r13     // Catch:{ NoSuchFieldError -> 0x00f3 }
            L_0x00f3:
                com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory r1 = com.coffeemeetsbagel.feature.bagelprofile.ProfileCategory.LANGUAGES     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                f13557b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.fragments.FragmentMyProfileDetails.b.<clinit>():void");
        }
    }

    public static final class c extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13558a;

        c(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13558a = fragmentMyProfileDetails;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.j.g(view, "widget");
            CmbLinks.Companion companion = CmbLinks.Companion;
            androidx.fragment.app.h requireActivity = this.f13558a.requireActivity();
            kotlin.jvm.internal.j.f(requireActivity, "requireActivity()");
            companion.launchTermsAndConditions(requireActivity);
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13559a;

        d(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13559a = fragmentMyProfileDetails;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.j.g(editable, "s");
            this.f13559a.o5();
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13560a;

        e(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13560a = fragmentMyProfileDetails;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.j.g(editable, "s");
            this.f13560a.s5();
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }
    }

    public static final class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13561a;

        f(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13561a = fragmentMyProfileDetails;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.j.g(editable, "s");
            this.f13561a.n5();
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13563a;

        g(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13563a = fragmentMyProfileDetails;
        }

        public void afterTextChanged(Editable editable) {
            kotlin.jvm.internal.j.g(editable, "s");
            this.f13563a.t5();
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            kotlin.jvm.internal.j.g(charSequence, "s");
        }
    }

    public static final class h implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13565a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ QuestionWAnswers f13566b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f13567c;

        public i(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers, TextView textView) {
            this.f13565a = fragmentMyProfileDetails;
            this.f13566b = questionWAnswers;
            this.f13567c = textView;
        }

        public void afterTextChanged(Editable editable) {
            this.f13565a.f13536m0.accept(new Pair(this.f13566b, this.f13567c.getText().toString()));
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class j implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13569a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ QuestionWAnswers f13570b;

        public j(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers) {
            this.f13569a = fragmentMyProfileDetails;
            this.f13570b = questionWAnswers;
        }

        public void afterTextChanged(Editable editable) {
            this.f13569a.f13536m0.accept(new Pair(this.f13570b, String.valueOf(editable)));
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class k implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13571a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ QuestionWAnswers f13572b;

        public k(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers) {
            this.f13571a = fragmentMyProfileDetails;
            this.f13572b = questionWAnswers;
        }

        public void afterTextChanged(Editable editable) {
            this.f13571a.f13536m0.accept(new Pair(this.f13572b, String.valueOf(editable)));
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static final class l extends g0<com.coffeemeetsbagel.dialogs.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CmbTextView f13573a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13574b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List<com.coffeemeetsbagel.dialogs.e> f13575c;

        l(CmbTextView cmbTextView, FragmentMyProfileDetails fragmentMyProfileDetails, List<com.coffeemeetsbagel.dialogs.e> list) {
            this.f13573a = cmbTextView;
            this.f13574b = fragmentMyProfileDetails;
            this.f13575c = list;
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
            super.a(eVar);
            if (this.f13573a == this.f13574b.G) {
                this.f13574b.f13543q0 = null;
            } else {
                this.f13574b.f13544r0 = null;
            }
            this.f13573a.setText((CharSequence) null);
            this.f13574b.n5();
            lc.c.h(this.f13574b.f13527h0);
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "item");
            int indexOf = this.f13575c.indexOf(eVar);
            List q22 = this.f13574b.f13539o0;
            kotlin.jvm.internal.j.d(q22);
            String component1 = ((Resource) q22.get(indexOf)).component1();
            if (this.f13573a == this.f13574b.G) {
                this.f13574b.f13543q0 = component1;
            } else {
                this.f13574b.f13544r0 = component1;
            }
            CmbTextView cmbTextView = this.f13573a;
            List q23 = this.f13574b.f13539o0;
            kotlin.jvm.internal.j.d(q23);
            cmbTextView.setText(((Resource) q23.get(indexOf)).getValue());
            this.f13574b.n5();
            lc.c.h(this.f13574b.f13527h0);
        }
    }

    public static final class m implements b.C0132b<com.coffeemeetsbagel.dialogs.e> {
        m() {
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "basicAdapterItem");
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "basicAdapterItem");
        }
    }

    public static final class n implements b.C0132b<com.coffeemeetsbagel.dialogs.e> {
        n() {
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "basicAdapterItem");
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "basicAdapterItem");
        }
    }

    public static final class o extends g0<com.coffeemeetsbagel.dialogs.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13578a;

        o(FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13578a = fragmentMyProfileDetails;
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
            this.f13578a.V3((com.coffeemeetsbagel.dialogs.e) null);
            lc.c.h(this.f13578a.f13528i0);
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
            kotlin.jvm.internal.j.g(eVar, "item");
            this.f13578a.V3(eVar);
            lc.c.h(this.f13578a.f13528i0);
        }
    }

    public static final class p extends g0<com.coffeemeetsbagel.dialogs.k> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ QuestionWAnswers f13585a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentMyProfileDetails f13586b;

        p(QuestionWAnswers questionWAnswers, FragmentMyProfileDetails fragmentMyProfileDetails) {
            this.f13585a = questionWAnswers;
            this.f13586b = fragmentMyProfileDetails;
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.k kVar) {
            Question e10 = this.f13585a.e();
            FragmentMyProfileDetails.Z3(this.f13586b, q.j(), (String) null, e10.component1(), e10.component3().getQuestionGroupApiString(), 2, (Object) null);
            lc.c.h(this.f13586b.f13553x0);
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.k kVar) {
            kotlin.jvm.internal.j.g(kVar, "item");
            Question e10 = this.f13585a.e();
            FragmentMyProfileDetails.Z3(this.f13586b, p.e(kVar.b()), (String) null, e10.component1(), e10.component3().getQuestionGroupApiString(), 2, (Object) null);
            lc.c.h(this.f13586b.f13553x0);
        }
    }

    public FragmentMyProfileDetails() {
        PublishRelay<Pair<QuestionWAnswers, String>> C0 = PublishRelay.C0();
        kotlin.jvm.internal.j.f(C0, "create<Pair<QuestionWAnswers, String?>>()");
        this.f13536m0 = C0;
        this.f13538n0 = new FragmentMyProfileDetails$mCallBackUpdateProfile$1(this);
    }

    private final boolean A3(String str, String str2, boolean z10) {
        if (str == null && str2 == null) {
            return false;
        }
        if (str == null) {
            e4(str2, z10);
        } else if (kotlin.jvm.internal.j.b(str, str2)) {
            return false;
        } else {
            e4(str2, z10);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean A4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.u5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return true;
    }

    /* access modifiers changed from: private */
    public static final void B4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.p5();
        }
    }

    /* JADX WARNING: type inference failed for: r0v113, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"AutoDispose"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void C3(android.view.View r11) {
        /*
            r10 = this;
            r0 = 2131297426(0x7f090492, float:1.8212797E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.M = r0
            r0 = 2131297421(0x7f09048d, float:1.8212786E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.N = r0
            r0 = 2131297427(0x7f090493, float:1.8212799E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.P = r0
            r0 = 2131297420(0x7f09048c, float:1.8212784E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.Q = r0
            r0 = 2131297419(0x7f09048b, float:1.8212782E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.R = r0
            r0 = 2131297424(0x7f090490, float:1.8212793E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.S = r0
            r0 = 2131297417(0x7f090489, float:1.8212778E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.T = r0
            r0 = 2131297422(0x7f09048e, float:1.8212788E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.O = r0
            r0 = 2131297423(0x7f09048f, float:1.821279E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.U = r0
            r0 = 2131297425(0x7f090491, float:1.8212795E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.V = r0
            r0 = 2131297430(0x7f090496, float:1.8212805E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.W = r0
            r0 = 2131297428(0x7f090494, float:1.82128E38)
            android.view.View r0 = r11.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r10.X = r0
            android.widget.LinearLayout r0 = r10.S
            r1 = 0
            r2 = 2131297255(0x7f0903e7, float:1.821245E38)
            if (r0 == 0) goto L_0x0093
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x0094
        L_0x0093:
            r0 = r1
        L_0x0094:
            r10.Z = r0
            android.widget.LinearLayout r0 = r10.T
            if (r0 == 0) goto L_0x00a1
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x00a2
        L_0x00a1:
            r0 = r1
        L_0x00a2:
            r10.f13517c0 = r0
            android.widget.LinearLayout r0 = r10.O
            if (r0 == 0) goto L_0x00af
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x00b0
        L_0x00af:
            r0 = r1
        L_0x00b0:
            r10.f13552x = r0
            android.widget.LinearLayout r0 = r10.N
            if (r0 == 0) goto L_0x00bd
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x00be
        L_0x00bd:
            r0 = r1
        L_0x00be:
            r10.f13550w = r0
            android.widget.LinearLayout r0 = r10.M
            if (r0 == 0) goto L_0x00cb
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x00cc
        L_0x00cb:
            r0 = r1
        L_0x00cc:
            r10.f13546t = r0
            android.widget.LinearLayout r0 = r10.P
            if (r0 == 0) goto L_0x00d9
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            goto L_0x00da
        L_0x00d9:
            r0 = r1
        L_0x00da:
            r10.B = r0
            android.widget.LinearLayout r0 = r10.Q
            if (r0 == 0) goto L_0x00e7
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            goto L_0x00e8
        L_0x00e7:
            r0 = r1
        L_0x00e8:
            r10.C = r0
            android.widget.LinearLayout r0 = r10.U
            if (r0 == 0) goto L_0x00f5
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            goto L_0x00f6
        L_0x00f5:
            r0 = r1
        L_0x00f6:
            r10.D = r0
            android.widget.LinearLayout r0 = r10.V
            if (r0 == 0) goto L_0x0103
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x0104
        L_0x0103:
            r0 = r1
        L_0x0104:
            r10.f13555z = r0
            android.widget.LinearLayout r0 = r10.W
            if (r0 == 0) goto L_0x0111
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x0112
        L_0x0111:
            r0 = r1
        L_0x0112:
            r10.f13515a0 = r0
            android.widget.LinearLayout r0 = r10.X
            if (r0 == 0) goto L_0x011f
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            goto L_0x0120
        L_0x011f:
            r0 = r1
        L_0x0120:
            r10.f13516b0 = r0
            r0 = 2131296760(0x7f0901f8, float:1.8211446E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            r10.f13537n = r0
            r0 = 2131296758(0x7f0901f6, float:1.8211442E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            r10.f13540p = r0
            r0 = 2131297415(0x7f090487, float:1.8212774E38)
            android.view.View r0 = r11.findViewById(r0)
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            r10.f13542q = r0
            r0 = 2131297429(0x7f090495, float:1.8212803E38)
            android.view.View r0 = r11.findViewById(r0)
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            r10.f13554y = r0
            r0 = 2131296761(0x7f0901f9, float:1.8211448E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r0 = (com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView) r0
            r10.E = r0
            r0 = 2131297418(0x7f09048a, float:1.821278E38)
            android.view.View r0 = r11.findViewById(r0)
            android.view.View r0 = r0.findViewById(r2)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            r10.G = r0
            r0 = 2131296762(0x7f0901fa, float:1.821145E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r0 = (com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView) r0
            r10.F = r0
            android.widget.LinearLayout r0 = r10.R
            if (r0 == 0) goto L_0x0186
            android.view.View r0 = r0.findViewById(r2)
            r1 = r0
            com.coffeemeetsbagel.cmb_views.CmbTextView r1 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r1
        L_0x0186:
            r10.H = r1
            f5.i r0 = new f5.i
            r0.<init>()
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r1 = r10.E
            if (r1 == 0) goto L_0x0194
            r1.setAdapter(r0)
        L_0x0194:
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r1 = r10.E
            if (r1 == 0) goto L_0x01a4
            r2 = 2131297527(0x7f0904f7, float:1.8213001E38)
            android.view.View r2 = r11.findViewById(r2)
            android.widget.ProgressBar r2 = (android.widget.ProgressBar) r2
            r1.setLoadingIndicator(r2)
        L_0x01a4:
            f5.i r1 = new f5.i
            r1.<init>()
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r2 = r10.F
            if (r2 == 0) goto L_0x01b0
            r2.setAdapter(r1)
        L_0x01b0:
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r2 = r10.F
            if (r2 == 0) goto L_0x01c0
            r3 = 2131297528(0x7f0904f8, float:1.8213003E38)
            android.view.View r3 = r11.findViewById(r3)
            android.widget.ProgressBar r3 = (android.widget.ProgressBar) r3
            r2.setLoadingIndicator(r3)
        L_0x01c0:
            com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase r2 = r10.m3()
            qj.w r2 = r2.b()
            qj.v r3 = sj.a.a()
            qj.w r2 = r2.E(r3)
            com.uber.autodispose.d r3 = com.uber.autodispose.a.a(r10)
            java.lang.Object r2 = r2.g(r3)
            com.uber.autodispose.t r2 = (com.uber.autodispose.t) r2
            com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$initializeViews$1 r3 = new com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$initializeViews$1
            r3.<init>(r0, r1)
            com.coffeemeetsbagel.fragments.s1 r0 = new com.coffeemeetsbagel.fragments.s1
            r0.<init>(r3)
            com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$initializeViews$2 r1 = com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$initializeViews$2.f13568a
            com.coffeemeetsbagel.fragments.t1 r3 = new com.coffeemeetsbagel.fragments.t1
            r3.<init>(r1)
            r2.b(r0, r3)
            com.coffeemeetsbagel.experiment.r r0 = r10.i3()
            java.lang.String r1 = "ProfileMigration.Enabled.Android"
            boolean r0 = r0.a(r1)
            if (r0 != 0) goto L_0x0214
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r0 = r10.E
            if (r0 != 0) goto L_0x01ff
            goto L_0x0207
        L_0x01ff:
            com.coffeemeetsbagel.fragments.u1 r1 = new com.coffeemeetsbagel.fragments.u1
            r1.<init>(r10)
            r0.setOnItemClickListener(r1)
        L_0x0207:
            com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView r0 = r10.F
            if (r0 != 0) goto L_0x020c
            goto L_0x0214
        L_0x020c:
            com.coffeemeetsbagel.fragments.v1 r1 = new com.coffeemeetsbagel.fragments.v1
            r1.<init>(r10)
            r0.setOnItemClickListener(r1)
        L_0x0214:
            r0 = 2131296745(0x7f0901e9, float:1.8211415E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            r10.I = r0
            r0 = 2131296746(0x7f0901ea, float:1.8211417E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            r10.J = r0
            r0 = 2131296747(0x7f0901eb, float:1.821142E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbEditText r0 = (com.coffeemeetsbagel.cmb_views.CmbEditText) r0
            r10.K = r0
            r0 = 2131297742(0x7f0905ce, float:1.8213438E38)
            android.view.View r0 = r11.findViewById(r0)
            com.coffeemeetsbagel.cmb_views.CmbTextView r0 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r0
            r10.Y = r0
            r0 = 2131297537(0x7f090501, float:1.8213022E38)
            android.view.View r0 = r11.findViewById(r0)
            androidx.core.widget.NestedScrollView r0 = (androidx.core.widget.NestedScrollView) r0
            r10.L = r0
            com.coffeemeetsbagel.models.ModelProfileUpdateDelta r0 = new com.coffeemeetsbagel.models.ModelProfileUpdateDelta
            r0.<init>()
            f13514z0 = r0
            s9.a r0 = r10.G0()
            java.lang.String r1 = "Privacy.GdprCopy.Android"
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L_0x02c1
            r0 = 2131296873(0x7f090269, float:1.8211675E38)
            android.view.View r11 = r11.findViewById(r0)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 0
            r11.setVisibility(r0)
            r1 = 2131887067(0x7f1203db, float:1.940873E38)
            java.lang.String r1 = r10.getString(r1)
            java.lang.String r2 = "getString(R.string.privacy_policy)"
            kotlin.jvm.internal.j.f(r1, r2)
            android.text.SpannableString r8 = new android.text.SpannableString
            r2 = 2131887076(0x7f1203e4, float:1.9408749E38)
            r9 = 1
            java.lang.Object[] r3 = new java.lang.Object[r9]
            r3[r0] = r1
            java.lang.String r0 = r10.getString(r2, r3)
            r8.<init>(r0)
            java.lang.String r2 = r8.toString()
            java.lang.String r0 = "disclaimer.toString()"
            kotlin.jvm.internal.j.f(r2, r0)
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r3 = r1
            int r0 = kotlin.text.StringsKt__StringsKt.b0(r2, r3, r4, r5, r6, r7)
            int r1 = r1.length()
            int r1 = r1 + r0
            android.text.style.ForegroundColorSpan r2 = new android.text.style.ForegroundColorSpan
            r3 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r2.<init>(r3)
            r3 = 18
            r8.setSpan(r2, r0, r1, r3)
            com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$c r2 = new com.coffeemeetsbagel.fragments.FragmentMyProfileDetails$c
            r2.<init>(r10)
            r8.setSpan(r2, r0, r1, r3)
            r11.setText(r8)
            r11.setClickable(r9)
            android.text.method.MovementMethod r0 = android.text.method.LinkMovementMethod.getInstance()
            r11.setMovementMethod(r0)
        L_0x02c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.fragments.FragmentMyProfileDetails.C3(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final boolean C4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.p5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return true;
    }

    /* access modifiers changed from: private */
    public static final void D3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void D4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.t5();
    }

    /* access modifiers changed from: private */
    public static final void E3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final boolean E4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.t5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return false;
    }

    /* access modifiers changed from: private */
    public static final void F3(FragmentMyProfileDetails fragmentMyProfileDetails, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(adapterView, Message.Thread.PARENT_ATTRIBUTE_NAME);
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        kotlin.jvm.internal.j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        String component1 = ((School) itemAtPosition).component1();
        DelayAutoCompleteTextView delayAutoCompleteTextView = fragmentMyProfileDetails.E;
        if (delayAutoCompleteTextView != null) {
            delayAutoCompleteTextView.setText(component1);
        }
        fragmentMyProfileDetails.n5();
    }

    /* access modifiers changed from: private */
    public static final void F4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.X2();
        fragmentMyProfileDetails.U4();
    }

    /* access modifiers changed from: private */
    public static final void G3(FragmentMyProfileDetails fragmentMyProfileDetails, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(adapterView, Message.Thread.PARENT_ATTRIBUTE_NAME);
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        kotlin.jvm.internal.j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        String component1 = ((School) itemAtPosition).component1();
        DelayAutoCompleteTextView delayAutoCompleteTextView = fragmentMyProfileDetails.F;
        if (delayAutoCompleteTextView != null) {
            delayAutoCompleteTextView.setText(component1);
        }
        fragmentMyProfileDetails.n5();
    }

    /* access modifiers changed from: private */
    public static final void G4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.X2();
        fragmentMyProfileDetails.d5();
    }

    private final boolean H3(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        List<String> listSchools = networkProfile.getListSchools();
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        List<String> listDegrees = networkProfile2.getListDegrees();
        String str8 = null;
        if (listSchools.size() > 0) {
            str5 = listSchools.get(0);
        } else {
            str5 = null;
        }
        if (listSchools.size() > 1) {
            str6 = listSchools.get(1);
        } else {
            str6 = null;
        }
        if (listDegrees.size() > 0) {
            str7 = listDegrees.get(0);
        } else {
            str7 = null;
        }
        if (listDegrees.size() > 1) {
            str8 = listDegrees.get(1);
        }
        if (A3(str5, str, true) || A3(str6, str3, true) || A3(str7, str2, false) || A3(str8, str4, false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void H4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.X2();
        Intent intent = new Intent(fragmentMyProfileDetails.getActivity(), ActivityLocation.class);
        intent.putExtra("source", "Edit Profile");
        fragmentMyProfileDetails.requireActivity().startActivityForResult(intent, RequestCode.LOCATION);
        fragmentMyProfileDetails.requireActivity().overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    /* access modifiers changed from: private */
    public static final void I3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void I4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.X2();
        Map<String, String> map = fragmentMyProfileDetails.f13532k0;
        List<String> list = fragmentMyProfileDetails.f13534l0;
        String string = fragmentMyProfileDetails.getString(R.string.label_languages);
        kotlin.jvm.internal.j.f(string, "getString(R.string.label_languages)");
        fragmentMyProfileDetails.b5(map, list, string, fragmentMyProfileDetails.f13548u0, QuestionGroupType.IDENTITY_PROFILE);
    }

    /* access modifiers changed from: private */
    public static final void J3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void J4(List<String> list) {
        LinearLayout linearLayout = this.X;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        CmbTextView cmbTextView = this.f13516b0;
        kotlin.jvm.internal.j.d(cmbTextView);
        cmbTextView.setText((String) list.stream().collect(Collectors.joining(AppsFlyerKit.COMMA)));
        CmbTextView cmbTextView2 = this.f13516b0;
        kotlin.jvm.internal.j.d(cmbTextView2);
        cmbTextView2.setOnClickListener(new v2(this));
    }

    /* access modifiers changed from: private */
    public static final void K3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.S4(QuestionGroupType.PERSONALITY);
    }

    /* access modifiers changed from: private */
    public static final void L3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void L4(ab.a aVar) {
        a.C0491a aVar2 = fa.a.f40771d;
        aVar2.a("FragmentMyProfileDetails", "Setting up group: " + aVar);
        aVar.b().forEach(new l3(this));
    }

    /* access modifiers changed from: private */
    public static final List M3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    private final void M4(TextView textView, QuestionWAnswers questionWAnswers) {
        String str;
        textView.addTextChangedListener(new h());
        Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
        if (answer != null) {
            str = answer.getTextValue();
        } else {
            str = null;
        }
        textView.setText(str);
        textView.addTextChangedListener(new i(this, questionWAnswers, textView));
    }

    /* access modifiers changed from: private */
    public static final void N3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void N4(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers) {
        Location location;
        CmbTextView cmbTextView;
        boolean z10;
        FragmentMyProfileDetails fragmentMyProfileDetails2 = fragmentMyProfileDetails;
        QuestionWAnswers questionWAnswers2 = questionWAnswers;
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails2, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers2, "questionWAnswers");
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("FragmentMyProfileDetails", "Setting up question: " + questionWAnswers.e().getName());
        switch (b.f13556a[ProfileQuestion.Companion.fromString(questionWAnswers.e().getName()).ordinal()]) {
            case 1:
                CmbEditText cmbEditText = fragmentMyProfileDetails2.C;
                if (cmbEditText != null) {
                    fragmentMyProfileDetails2.M4(cmbEditText, questionWAnswers2);
                    return;
                }
                return;
            case 2:
                CmbEditText cmbEditText2 = fragmentMyProfileDetails2.B;
                if (cmbEditText2 != null) {
                    fragmentMyProfileDetails2.M4(cmbEditText2, questionWAnswers2);
                    return;
                }
                return;
            case 3:
                CmbEditText cmbEditText3 = fragmentMyProfileDetails2.I;
                kotlin.jvm.internal.j.d(cmbEditText3);
                fragmentMyProfileDetails2.M4(cmbEditText3, questionWAnswers2);
                return;
            case 4:
                CmbEditText cmbEditText4 = fragmentMyProfileDetails2.J;
                kotlin.jvm.internal.j.d(cmbEditText4);
                fragmentMyProfileDetails2.M4(cmbEditText4, questionWAnswers2);
                return;
            case 5:
                CmbEditText cmbEditText5 = fragmentMyProfileDetails2.K;
                kotlin.jvm.internal.j.d(cmbEditText5);
                fragmentMyProfileDetails2.M4(cmbEditText5, questionWAnswers2);
                return;
            case 6:
                if (!questionWAnswers.d().isEmpty()) {
                    DelayAutoCompleteTextView delayAutoCompleteTextView = fragmentMyProfileDetails2.E;
                    if (delayAutoCompleteTextView != null) {
                        delayAutoCompleteTextView.setText(questionWAnswers.d().get(0).getTextValue());
                    }
                } else {
                    DelayAutoCompleteTextView delayAutoCompleteTextView2 = fragmentMyProfileDetails2.E;
                    if (delayAutoCompleteTextView2 != null) {
                        delayAutoCompleteTextView2.setText((CharSequence) null);
                    }
                }
                DelayAutoCompleteTextView delayAutoCompleteTextView3 = fragmentMyProfileDetails2.E;
                if (delayAutoCompleteTextView3 != null) {
                    delayAutoCompleteTextView3.setOnItemClickListener(new n3(fragmentMyProfileDetails2));
                }
                DelayAutoCompleteTextView delayAutoCompleteTextView4 = fragmentMyProfileDetails2.E;
                if (delayAutoCompleteTextView4 != null) {
                    delayAutoCompleteTextView4.addTextChangedListener(new j(fragmentMyProfileDetails2, questionWAnswers2));
                    return;
                }
                return;
            case 7:
                if (!questionWAnswers.d().isEmpty()) {
                    DelayAutoCompleteTextView delayAutoCompleteTextView5 = fragmentMyProfileDetails2.F;
                    if (delayAutoCompleteTextView5 != null) {
                        delayAutoCompleteTextView5.setText(questionWAnswers.d().get(0).getTextValue());
                    }
                } else {
                    DelayAutoCompleteTextView delayAutoCompleteTextView6 = fragmentMyProfileDetails2.F;
                    if (delayAutoCompleteTextView6 != null) {
                        delayAutoCompleteTextView6.setText((CharSequence) null);
                    }
                }
                DelayAutoCompleteTextView delayAutoCompleteTextView7 = fragmentMyProfileDetails2.F;
                if (delayAutoCompleteTextView7 != null) {
                    delayAutoCompleteTextView7.setOnItemClickListener(new o3(fragmentMyProfileDetails2));
                }
                DelayAutoCompleteTextView delayAutoCompleteTextView8 = fragmentMyProfileDetails2.F;
                if (delayAutoCompleteTextView8 != null) {
                    delayAutoCompleteTextView8.addTextChangedListener(new k(fragmentMyProfileDetails2, questionWAnswers2));
                    return;
                }
                return;
            case 8:
                Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer != null && (location = answer.getLocation()) != null && (cmbTextView = fragmentMyProfileDetails2.f13546t) != null) {
                    List o10 = q.o(location.getCity(), location.getState(), location.getCountry());
                    ArrayList arrayList = new ArrayList();
                    for (Object next : o10) {
                        if (((String) next).length() > 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            arrayList.add(next);
                        }
                    }
                    cmbTextView.setText(CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    return;
                }
                return;
            default:
                aVar.a("FragmentMyProfileDetails", "No setup for: " + questionWAnswers.e().getName());
                return;
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void O4(FragmentMyProfileDetails fragmentMyProfileDetails, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        kotlin.jvm.internal.j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        School school = (School) itemAtPosition;
        DelayAutoCompleteTextView delayAutoCompleteTextView = fragmentMyProfileDetails.E;
        if (delayAutoCompleteTextView != null) {
            delayAutoCompleteTextView.setText(school.getName());
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P4(FragmentMyProfileDetails fragmentMyProfileDetails, AdapterView adapterView, View view, int i10, long j10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        kotlin.jvm.internal.j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        School school = (School) itemAtPosition;
        DelayAutoCompleteTextView delayAutoCompleteTextView = fragmentMyProfileDetails.F;
        if (delayAutoCompleteTextView != null) {
            delayAutoCompleteTextView.setText(school.getName());
        }
    }

    /* access modifiers changed from: private */
    public static final void Q3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void Q4(List<String> list) {
        LinearLayout linearLayout = this.W;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        CmbTextView cmbTextView = this.f13515a0;
        kotlin.jvm.internal.j.d(cmbTextView);
        cmbTextView.setText((String) list.stream().collect(Collectors.joining(AppsFlyerKit.COMMA)));
        CmbTextView cmbTextView2 = this.f13515a0;
        kotlin.jvm.internal.j.d(cmbTextView2);
        cmbTextView2.setOnClickListener(new w1(this));
    }

    /* access modifiers changed from: private */
    public static final void R3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.S4(QuestionGroupType.VALUES);
    }

    /* access modifiers changed from: private */
    public static final void S3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void S4(QuestionGroupType questionGroupType) {
        ChipSelectQuestionDialog chipSelectQuestionDialog = this.f13525g0;
        if (chipSelectQuestionDialog != null) {
            chipSelectQuestionDialog.dismiss();
        }
        Context requireContext = requireContext();
        kotlin.jvm.internal.j.f(requireContext, "requireContext()");
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        String id2 = networkProfile.getId();
        kotlin.jvm.internal.j.f(id2, "selfProfile!!.id");
        ChipSelectQuestionDialog chipSelectQuestionDialog2 = new ChipSelectQuestionDialog(requireContext, id2, questionGroupType, k3(), t3());
        this.f13525g0 = chipSelectQuestionDialog2;
        chipSelectQuestionDialog2.show();
    }

    /* access modifiers changed from: private */
    public static final void T3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void T4(CmbTextView cmbTextView) {
        String str;
        if (!TextUtils.isEmpty(cmbTextView.getText())) {
            str = cmbTextView.getText().toString();
        } else {
            str = null;
        }
        List<Resource> list = this.f13539o0;
        kotlin.jvm.internal.j.d(list);
        ArrayList arrayList = new ArrayList(list.size());
        List<Resource> list2 = this.f13539o0;
        kotlin.jvm.internal.j.d(list2);
        com.coffeemeetsbagel.dialogs.e eVar = null;
        for (Resource component2 : list2) {
            String component22 = component2.component2();
            com.coffeemeetsbagel.dialogs.e eVar2 = new com.coffeemeetsbagel.dialogs.e(component22, (String) null);
            if (kotlin.jvm.internal.j.b(component22, str)) {
                eVar = eVar2;
            }
            arrayList.add(eVar2);
        }
        h0 h0Var = new h0(requireContext(), getString(R.string.label_degree), (String) null, new l(cmbTextView, this, arrayList), arrayList);
        this.f13527h0 = h0Var;
        kotlin.jvm.internal.j.d(h0Var);
        h0Var.show();
        h0<com.coffeemeetsbagel.dialogs.e> h0Var2 = this.f13527h0;
        kotlin.jvm.internal.j.d(h0Var2);
        if (h0Var2.getWindow() != null) {
            h0<com.coffeemeetsbagel.dialogs.e> h0Var3 = this.f13527h0;
            kotlin.jvm.internal.j.d(h0Var3);
            Window window = h0Var3.getWindow();
            kotlin.jvm.internal.j.d(window);
            window.setLayout(-1, -2);
        }
        if (eVar != null) {
            h0<com.coffeemeetsbagel.dialogs.e> h0Var4 = this.f13527h0;
            kotlin.jvm.internal.j.d(h0Var4);
            h0Var4.h(eVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void U3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void U4() {
        String[] stringArray = getResources().getStringArray(R.array.ethnicity);
        List asList = Arrays.asList(Arrays.copyOf(stringArray, stringArray.length));
        String[] stringArray2 = getResources().getStringArray(R.array.ethnicity_api);
        List asList2 = Arrays.asList(Arrays.copyOf(stringArray2, stringArray2.length));
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        List<String> ethnicityAsApiParamsList = networkProfile.getEthnicityAsApiParamsList();
        ArrayList arrayList = new ArrayList(asList.size());
        ArrayList arrayList2 = new ArrayList(ethnicityAsApiParamsList.size());
        int size = asList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = (String) asList2.get(i10);
            com.coffeemeetsbagel.dialogs.e eVar = new com.coffeemeetsbagel.dialogs.e((String) asList.get(i10), str);
            if (ethnicityAsApiParamsList.contains(str)) {
                arrayList2.add(eVar);
            }
            arrayList.add(eVar);
        }
        f0 f0Var = new f0(requireActivity(), getString(R.string.my_profile_preference_advanced_ethnicity_label), (String) null, getString(R.string.done_dls), new m(), arrayList);
        this.f13530j0 = f0Var;
        kotlin.jvm.internal.j.d(f0Var);
        f0Var.k(arrayList2);
        f0<com.coffeemeetsbagel.dialogs.e> f0Var2 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var2);
        ((com.uber.autodispose.p) f0Var2.i().W(new h3(FragmentMyProfileDetails$showEthnicityPicker$2.f13588a)).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i3(new FragmentMyProfileDetails$showEthnicityPicker$3(this)));
        f0<com.coffeemeetsbagel.dialogs.e> f0Var3 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var3);
        f0Var3.show();
        f0<com.coffeemeetsbagel.dialogs.e> f0Var4 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var4);
        if (f0Var4.getWindow() != null) {
            f0<com.coffeemeetsbagel.dialogs.e> f0Var5 = this.f13530j0;
            kotlin.jvm.internal.j.d(f0Var5);
            Window window = f0Var5.getWindow();
            kotlin.jvm.internal.j.d(window);
            window.setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public final void V3(com.coffeemeetsbagel.dialogs.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            str = eVar.b();
        } else {
            str = null;
        }
        if (eVar != null) {
            str2 = eVar.a();
        }
        if (str != null) {
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            if (kotlin.jvm.internal.j.b(str, networkProfile.getReligionApiParam())) {
                str = "";
            }
        }
        h4(true);
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        networkProfile2.setReligion(str);
        NetworkProfile j10 = M0().j();
        kotlin.jvm.internal.j.d(j10);
        j10.setReligion(str);
        ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
        kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
        modelProfileUpdateDelta.updateReligion(str);
        CmbTextView cmbTextView = this.f13554y;
        kotlin.jvm.internal.j.d(cmbTextView);
        cmbTextView.setText(str2);
    }

    /* access modifiers changed from: private */
    public static final List V4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void W3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void W4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void X2() {
        View currentFocus;
        if (isAdded() && requireActivity().getCurrentFocus() != null && (currentFocus = requireActivity().getCurrentFocus()) != null) {
            currentFocus.clearFocus();
        }
    }

    /* access modifiers changed from: private */
    public static final void X3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void X4(Height height, Question question) {
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        if (networkProfile.isHeightUnitMetric()) {
            Dialog dialog = this.f13523f0;
            if (dialog != null) {
                dialog.dismiss();
            }
            com.coffeemeetsbagel.dialogs.p pVar = new com.coffeemeetsbagel.dialogs.p(getActivity(), height, new f3(this, question));
            this.f13523f0 = pVar;
            kotlin.jvm.internal.j.d(pVar);
            pVar.show();
            Dialog dialog2 = this.f13523f0;
            kotlin.jvm.internal.j.d(dialog2);
            if (dialog2.getWindow() != null) {
                Dialog dialog3 = this.f13523f0;
                kotlin.jvm.internal.j.d(dialog3);
                Window window = dialog3.getWindow();
                kotlin.jvm.internal.j.d(window);
                window.setLayout(-1, -2);
                return;
            }
            return;
        }
        Dialog dialog4 = this.f13521e0;
        if (dialog4 != null) {
            dialog4.dismiss();
        }
        com.coffeemeetsbagel.dialogs.n nVar = new com.coffeemeetsbagel.dialogs.n(getActivity(), height, new g3(this, question));
        this.f13521e0 = nVar;
        kotlin.jvm.internal.j.d(nVar);
        nVar.show();
        Dialog dialog5 = this.f13521e0;
        kotlin.jvm.internal.j.d(dialog5);
        if (dialog5.getWindow() != null) {
            Dialog dialog6 = this.f13521e0;
            kotlin.jvm.internal.j.d(dialog6);
            Window window2 = dialog6.getWindow();
            kotlin.jvm.internal.j.d(window2);
            window2.setLayout(-1, -2);
        }
    }

    private final View.OnClickListener Y2(QuestionWAnswers questionWAnswers) {
        return new y3(this, questionWAnswers);
    }

    private final void Y3(List<String> list, String str, String str2, String str3) {
        SaveAnswerUseCase t32 = t3();
        kotlin.jvm.internal.j.d(str2);
        ((com.uber.autodispose.m) SaveAnswerUseCase.d(t32, list, str, str2, str3, (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1008, (Object) null).j(com.uber.autodispose.a.a(this))).f(new j3(), new k3(FragmentMyProfileDetails$postAnswerAndSaveToDb$2.f13587a));
    }

    static /* synthetic */ void Y4(FragmentMyProfileDetails fragmentMyProfileDetails, Height height, Question question, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            question = null;
        }
        fragmentMyProfileDetails.X4(height, question);
    }

    /* access modifiers changed from: private */
    public static final void Z2(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers, "$questionWAnswers");
        fragmentMyProfileDetails.X2();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        questionWAnswers.e().getOptions().forEach(new z3(linkedHashMap));
        fragmentMyProfileDetails.b5(linkedHashMap, fragmentMyProfileDetails.d4(questionWAnswers), questionWAnswers.e().getText(), questionWAnswers.e().getId(), questionWAnswers.e().getGroup());
    }

    static /* synthetic */ void Z3(FragmentMyProfileDetails fragmentMyProfileDetails, List list, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        fragmentMyProfileDetails.Y3(list, str, str2, str3);
    }

    /* access modifiers changed from: private */
    public static final void Z4(FragmentMyProfileDetails fragmentMyProfileDetails, Question question, Height height) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.f(height, "dialogResult");
        fragmentMyProfileDetails.w3(height, question);
    }

    /* access modifiers changed from: private */
    public static final void a3(Map map, Option option) {
        kotlin.jvm.internal.j.g(map, "$choiceMap");
        kotlin.jvm.internal.j.g(option, "<name for destructuring parameter 0>");
        map.put(option.component1(), option.component3());
    }

    /* access modifiers changed from: private */
    public static final void a4() {
        fa.a.f40771d.a("FragmentMyProfileDetails", "save answer - success");
    }

    /* access modifiers changed from: private */
    public static final void a5(FragmentMyProfileDetails fragmentMyProfileDetails, Question question, Height height) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.f(height, "dialogResult");
        fragmentMyProfileDetails.w3(height, question);
    }

    /* access modifiers changed from: private */
    public final void b3(Map<String, String> map) {
        if (!i3().a("ProfileMigration.Enabled.Android")) {
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            List<String> listDegrees = networkProfile.getListDegrees();
            if (!CollectionUtils.isEmpty((List) listDegrees) && !CollectionUtils.isEmpty(map)) {
                CmbTextView cmbTextView = this.G;
                kotlin.jvm.internal.j.d(cmbTextView);
                kotlin.jvm.internal.j.d(map);
                cmbTextView.setText(map.get(listDegrees.get(0)));
                if (listDegrees.size() > 1) {
                    CmbTextView cmbTextView2 = this.H;
                    kotlin.jvm.internal.j.d(cmbTextView2);
                    cmbTextView2.setText(map.get(listDegrees.get(1)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void b4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void b5(Map<String, String> map, List<String> list, String str, String str2, QuestionGroupType questionGroupType) {
        if (map.isEmpty()) {
            fa.a.f40771d.c("FragmentMyProfileDetails", "No options loaded.", new IllegalStateException("Can't show picker."));
            return;
        }
        ArrayList arrayList = new ArrayList(map.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getValue();
            com.coffeemeetsbagel.dialogs.e eVar = new com.coffeemeetsbagel.dialogs.e(str3, (String) next.getKey());
            if (list.contains(str3)) {
                arrayList2.add(eVar);
            }
            arrayList.add(eVar);
        }
        f0 f0Var = new f0(requireActivity(), str, (String) null, getString(R.string.done_dls), new n(), arrayList);
        this.f13530j0 = f0Var;
        kotlin.jvm.internal.j.d(f0Var);
        f0Var.k(arrayList2);
        f0<com.coffeemeetsbagel.dialogs.e> f0Var2 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var2);
        ((com.uber.autodispose.p) f0Var2.i().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new c3(new FragmentMyProfileDetails$showMultiSelectDialog$3(this, str2, questionGroupType)));
        f0<com.coffeemeetsbagel.dialogs.e> f0Var3 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var3);
        f0Var3.show();
        f0<com.coffeemeetsbagel.dialogs.e> f0Var4 = this.f13530j0;
        kotlin.jvm.internal.j.d(f0Var4);
        if (f0Var4.getWindow() != null) {
            f0<com.coffeemeetsbagel.dialogs.e> f0Var5 = this.f13530j0;
            kotlin.jvm.internal.j.d(f0Var5);
            Window window = f0Var5.getWindow();
            kotlin.jvm.internal.j.d(window);
            window.setLayout(-1, -2);
        }
    }

    private final void c3() {
        CmbTextView cmbTextView = this.f13537n;
        kotlin.jvm.internal.j.d(cmbTextView);
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        cmbTextView.setText(networkProfile.getUserFirstName());
        CmbEditText cmbEditText = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText);
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        cmbEditText.setText(networkProfile2.getUserEmail());
        CmbTextView cmbTextView2 = this.f13542q;
        kotlin.jvm.internal.j.d(cmbTextView2);
        NetworkProfile networkProfile3 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile3);
        cmbTextView2.setText(networkProfile3.getAgeString());
        h3();
        if (i3().a("ProfileMigration.Enabled.Android")) {
            ArrayList arrayList = new ArrayList();
            for (QuestionGroupType questionGroupType : q.m(QuestionGroupType.ORIGINAL_PROFILE, QuestionGroupType.EDUCATION_ONE, QuestionGroupType.EDUCATION_TWO, QuestionGroupType.ICEBREAKERS)) {
                com.coffeemeetsbagel.qna.j k32 = k3();
                NetworkProfile networkProfile4 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile4);
                String id2 = networkProfile4.getId();
                kotlin.jvm.internal.j.f(id2, "selfProfile!!.id");
                qj.h<ab.a> a10 = k32.a(id2, questionGroupType, false);
                arrayList.add(a10);
                ((t) a10.L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new w2(new FragmentMyProfileDetails$fillFields$1$1(this)), new x2(new FragmentMyProfileDetails$fillFields$1$2(questionGroupType)));
            }
            ((com.uber.autodispose.n) qj.h.Z(arrayList).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new y2(new FragmentMyProfileDetails$fillFields$2(this)), new z2(FragmentMyProfileDetails$fillFields$3.f13562a));
            return;
        }
        CmbTextView cmbTextView3 = this.f13550w;
        kotlin.jvm.internal.j.d(cmbTextView3);
        NetworkProfile networkProfile5 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile5);
        List<String> ethnicityAsApiParamsList = networkProfile5.getEthnicityAsApiParamsList();
        kotlin.jvm.internal.j.f(ethnicityAsApiParamsList, "selfProfile!!.ethnicityAsApiParamsList");
        cmbTextView3.setText(p3(ethnicityAsApiParamsList));
        String[] stringArray = getResources().getStringArray(R.array.religion);
        kotlin.jvm.internal.j.f(stringArray, "resources.getStringArray(R.array.religion)");
        NetworkProfile networkProfile6 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile6);
        if (!networkProfile6.isMissingReligion()) {
            CmbTextView cmbTextView4 = this.f13554y;
            kotlin.jvm.internal.j.d(cmbTextView4);
            NetworkProfile networkProfile7 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile7);
            cmbTextView4.setText(stringArray[Religion.getIndex(networkProfile7.getReligionApiParam())]);
        }
        NetworkProfile networkProfile8 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile8);
        if (!TextUtils.isEmpty(networkProfile8.getEmployer())) {
            CmbEditText cmbEditText2 = this.C;
            kotlin.jvm.internal.j.d(cmbEditText2);
            NetworkProfile networkProfile9 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile9);
            cmbEditText2.setText(networkProfile9.getEmployer());
        }
        NetworkProfile networkProfile10 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile10);
        if (!TextUtils.isEmpty(networkProfile10.getOccupation())) {
            CmbEditText cmbEditText3 = this.B;
            kotlin.jvm.internal.j.d(cmbEditText3);
            NetworkProfile networkProfile11 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile11);
            cmbEditText3.setText(networkProfile11.getOccupation());
        }
        NetworkProfile networkProfile12 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile12);
        ArrayList<String> icebreakers = networkProfile12.getIcebreakers();
        if (icebreakers != null && (!icebreakers.isEmpty())) {
            CmbEditText cmbEditText4 = this.I;
            kotlin.jvm.internal.j.d(cmbEditText4);
            cmbEditText4.setText(icebreakers.get(0));
            if (icebreakers.size() > 1) {
                CmbEditText cmbEditText5 = this.J;
                kotlin.jvm.internal.j.d(cmbEditText5);
                cmbEditText5.setText(icebreakers.get(1));
                if (icebreakers.size() > 2) {
                    CmbEditText cmbEditText6 = this.K;
                    kotlin.jvm.internal.j.d(cmbEditText6);
                    cmbEditText6.setText(icebreakers.get(2));
                }
            }
        }
        NetworkProfile networkProfile13 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile13);
        List<String> listSchools = networkProfile13.getListSchools();
        if (listSchools != null && listSchools.size() > 0) {
            DelayAutoCompleteTextView delayAutoCompleteTextView = this.E;
            kotlin.jvm.internal.j.d(delayAutoCompleteTextView);
            NetworkProfile networkProfile14 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile14);
            delayAutoCompleteTextView.setText(networkProfile14.getListSchools().get(0));
            if (listSchools.size() > 1) {
                DelayAutoCompleteTextView delayAutoCompleteTextView2 = this.F;
                kotlin.jvm.internal.j.d(delayAutoCompleteTextView2);
                NetworkProfile networkProfile15 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile15);
                delayAutoCompleteTextView2.setText(networkProfile15.getListSchools().get(1));
            }
        }
        b3(this.f13541p0);
        q5();
    }

    private final void c4(ProfileCategory profileCategory) {
        switch (b.f13557b[profileCategory.ordinal()]) {
            case 1:
                f5(this.N, this.f13552x);
                return;
            case 2:
                f5(this.P, this.E);
                return;
            case 3:
                f5(this.O, this.f13554y);
                return;
            case 4:
                f5(this.M, this.f13550w);
                return;
            case 5:
                f5(this.P, this.B);
                return;
            case 6:
                f5(this.Q, this.C);
                return;
            case 7:
                return;
            case 8:
                f5(this.Y, this.I);
                return;
            case 9:
                f5(this.T, this.f13517c0);
                return;
            case 10:
                f5(this.X, this.f13516b0);
                return;
            case 11:
                f5(this.W, this.f13515a0);
                return;
            case 12:
                f5(this.S, this.Z);
                return;
            case 13:
                f5(this.U, this.D);
                return;
            case 14:
                f5(this.V, this.f13555z);
                return;
            default:
                a.C0491a aVar = fa.a.f40771d;
                aVar.a("FragmentMyProfileDetails", profileCategory + " not handled");
                return;
        }
    }

    /* access modifiers changed from: private */
    public static final void c5(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void d3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final List<String> d4(QuestionWAnswers questionWAnswers) {
        List<Answer> d10 = questionWAnswers.d();
        ArrayList arrayList = new ArrayList(r.t(d10, 10));
        for (Answer optionId : d10) {
            arrayList.add(optionId.getOptionId());
        }
        List<Option> options = questionWAnswers.e().getOptions();
        ArrayList<Option> arrayList2 = new ArrayList<>();
        for (T next : options) {
            if (arrayList.contains(((Option) next).getId())) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(r.t(arrayList2, 10));
        for (Option title : arrayList2) {
            arrayList3.add(title.getTitle());
        }
        return CollectionsKt___CollectionsKt.z0(arrayList3);
    }

    private final void d5() {
        String str;
        String[] stringArray = getResources().getStringArray(R.array.religion);
        List asList = Arrays.asList(Arrays.copyOf(stringArray, stringArray.length));
        String[] stringArray2 = getResources().getStringArray(R.array.religion_api);
        List asList2 = Arrays.asList(Arrays.copyOf(stringArray2, stringArray2.length));
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        com.coffeemeetsbagel.dialogs.e eVar = null;
        if (!networkProfile.isMissingReligion()) {
            CmbTextView cmbTextView = this.f13554y;
            kotlin.jvm.internal.j.d(cmbTextView);
            str = cmbTextView.getText().toString();
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList(asList.size());
        int size = asList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = (String) asList2.get(i10);
            com.coffeemeetsbagel.dialogs.e eVar2 = new com.coffeemeetsbagel.dialogs.e((String) asList.get(i10), str2);
            if (kotlin.jvm.internal.j.b(str2, str)) {
                eVar = eVar2;
            }
            arrayList.add(eVar2);
        }
        h0 h0Var = new h0(requireContext(), getString(R.string.label_religion), (String) null, new o(this), arrayList);
        this.f13528i0 = h0Var;
        kotlin.jvm.internal.j.d(h0Var);
        h0Var.show();
        h0<com.coffeemeetsbagel.dialogs.e> h0Var2 = this.f13528i0;
        kotlin.jvm.internal.j.d(h0Var2);
        if (h0Var2.getWindow() != null) {
            h0<com.coffeemeetsbagel.dialogs.e> h0Var3 = this.f13528i0;
            kotlin.jvm.internal.j.d(h0Var3);
            Window window = h0Var3.getWindow();
            kotlin.jvm.internal.j.d(window);
            window.setLayout(-1, -2);
        }
        if (eVar != null) {
            h0<com.coffeemeetsbagel.dialogs.e> h0Var4 = this.f13528i0;
            kotlin.jvm.internal.j.d(h0Var4);
            h0Var4.h(eVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void e3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void e4(String str, boolean z10) {
        String str2;
        HashMap hashMap = new HashMap();
        if (z10) {
            str2 = "School Name";
        } else {
            str2 = "degree";
        }
        hashMap.put(str2, str);
        hashMap.put("source", "Edit Profile");
        C0().trackEvent("Education Updated", hashMap);
    }

    /* access modifiers changed from: private */
    public final void e5(QuestionWAnswers questionWAnswers) {
        ArrayList arrayList = new ArrayList(questionWAnswers.e().getOptions().size());
        HashMap hashMap = new HashMap();
        for (Answer next : questionWAnswers.d()) {
            hashMap.put(next.getOptionId(), next);
        }
        com.coffeemeetsbagel.dialogs.k kVar = null;
        for (Option next2 : questionWAnswers.e().getOptions()) {
            com.coffeemeetsbagel.dialogs.k kVar2 = new com.coffeemeetsbagel.dialogs.k(next2);
            if (hashMap.containsKey(next2.getId())) {
                kVar = kVar2;
            }
            arrayList.add(kVar2);
        }
        h0 h0Var = new h0(requireContext(), questionWAnswers.e().getText(), (String) null, new p(questionWAnswers, this), arrayList);
        this.f13553x0 = h0Var;
        kotlin.jvm.internal.j.d(h0Var);
        h0Var.show();
        h0<com.coffeemeetsbagel.dialogs.k> h0Var2 = this.f13553x0;
        kotlin.jvm.internal.j.d(h0Var2);
        if (h0Var2.getWindow() != null) {
            h0<com.coffeemeetsbagel.dialogs.k> h0Var3 = this.f13553x0;
            kotlin.jvm.internal.j.d(h0Var3);
            Window window = h0Var3.getWindow();
            kotlin.jvm.internal.j.d(window);
            window.setLayout(-1, -2);
        }
        if (kVar != null) {
            h0<com.coffeemeetsbagel.dialogs.k> h0Var4 = this.f13553x0;
            kotlin.jvm.internal.j.d(h0Var4);
            h0Var4.h(kVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void f3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void f4() {
        s7.b bVar = this.f13551w0;
        kotlin.jvm.internal.j.d(bVar);
        ((com.uber.autodispose.n) bVar.G().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new a3(new FragmentMyProfileDetails$setCoreProfileDataListener$1(this)));
    }

    private final void f5(View view, View view2) {
        NestedScrollView nestedScrollView = this.L;
        kotlin.jvm.internal.j.d(nestedScrollView);
        nestedScrollView.post(new m3(this, view, view2));
    }

    /* access modifiers changed from: private */
    public static final void g3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g4(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g5(FragmentMyProfileDetails fragmentMyProfileDetails, View view, View view2) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        NestedScrollView nestedScrollView = fragmentMyProfileDetails.L;
        kotlin.jvm.internal.j.d(nestedScrollView);
        kotlin.jvm.internal.j.d(view);
        nestedScrollView.scrollTo(0, view.getBottom());
        if (view2 == null) {
            return;
        }
        if (view2 instanceof EditText) {
            EditText editText = (EditText) view2;
            editText.requestFocus();
            lc.c.f(fragmentMyProfileDetails.requireActivity(), editText);
            return;
        }
        view2.performClick();
    }

    private final void h3() {
        if (!i3().a("ProfileMigration.Enabled.Android")) {
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            String country = networkProfile.getCountry();
            if (country == null || !kotlin.jvm.internal.j.b(country, "US")) {
                CmbTextView cmbTextView = this.f13546t;
                kotlin.jvm.internal.j.d(cmbTextView);
                NetworkProfile networkProfile2 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile2);
                cmbTextView.setText(networkProfile2.getLocation());
                return;
            }
            CmbTextView cmbTextView2 = this.f13546t;
            kotlin.jvm.internal.j.d(cmbTextView2);
            NetworkProfile networkProfile3 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile3);
            NetworkProfile networkProfile4 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile4);
            cmbTextView2.setText(getString(R.string.edit_profile_city_state_format, networkProfile3.getCity(), networkProfile4.getState()));
        }
    }

    /* access modifiers changed from: private */
    public final void h5(ab.a aVar) {
        aVar.b().forEach(new d3(this));
    }

    /* access modifiers changed from: private */
    public final void i4(List<String> list) {
        LinearLayout linearLayout = this.T;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        String str = (String) list.stream().collect(Collectors.joining(AppsFlyerKit.COMMA));
        a.C0491a aVar = fa.a.f40771d;
        kotlin.jvm.internal.j.f(str, "answers");
        aVar.a("FragmentMyProfileDetails", str);
        CmbTextView cmbTextView = this.f13517c0;
        kotlin.jvm.internal.j.d(cmbTextView);
        cmbTextView.setText(str);
        CmbTextView cmbTextView2 = this.f13517c0;
        kotlin.jvm.internal.j.d(cmbTextView2);
        cmbTextView2.setOnClickListener(new y1(this));
    }

    /* access modifiers changed from: private */
    public static final void i5(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers) {
        int i10;
        Float floatValue;
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers, "questionWAnswers");
        switch (b.f13556a[ProfileQuestion.Companion.fromString(questionWAnswers.e().getName()).ordinal()]) {
            case 9:
                if (!questionWAnswers.d().isEmpty()) {
                    CmbTextView cmbTextView = fragmentMyProfileDetails.f13554y;
                    if (cmbTextView != null) {
                        cmbTextView.setText(fragmentMyProfileDetails.q3(questionWAnswers));
                    }
                } else {
                    CmbTextView cmbTextView2 = fragmentMyProfileDetails.f13554y;
                    if (cmbTextView2 != null) {
                        cmbTextView2.setText((CharSequence) null);
                    }
                }
                CmbTextView cmbTextView3 = fragmentMyProfileDetails.f13554y;
                if (cmbTextView3 != null) {
                    cmbTextView3.setOnClickListener(new q3(fragmentMyProfileDetails, questionWAnswers));
                    return;
                }
                return;
            case 10:
                if (!questionWAnswers.d().isEmpty()) {
                    CmbTextView cmbTextView4 = fragmentMyProfileDetails.f13550w;
                    if (cmbTextView4 != null) {
                        cmbTextView4.setText(fragmentMyProfileDetails.q3(questionWAnswers));
                    }
                } else {
                    CmbTextView cmbTextView5 = fragmentMyProfileDetails.f13550w;
                    if (cmbTextView5 != null) {
                        cmbTextView5.setText((CharSequence) null);
                    }
                }
                CmbTextView cmbTextView6 = fragmentMyProfileDetails.f13550w;
                if (cmbTextView6 != null) {
                    cmbTextView6.setOnClickListener(fragmentMyProfileDetails.Y2(questionWAnswers));
                    return;
                }
                return;
            case 11:
                if (!questionWAnswers.d().isEmpty()) {
                    CmbTextView cmbTextView7 = fragmentMyProfileDetails.G;
                    if (cmbTextView7 != null) {
                        cmbTextView7.setText(fragmentMyProfileDetails.q3(questionWAnswers));
                    }
                } else {
                    CmbTextView cmbTextView8 = fragmentMyProfileDetails.G;
                    if (cmbTextView8 != null) {
                        cmbTextView8.setText((CharSequence) null);
                    }
                }
                CmbTextView cmbTextView9 = fragmentMyProfileDetails.G;
                if (cmbTextView9 != null) {
                    cmbTextView9.setOnClickListener(new r3(fragmentMyProfileDetails, questionWAnswers));
                    return;
                }
                return;
            case 12:
                if (!questionWAnswers.d().isEmpty()) {
                    CmbTextView cmbTextView10 = fragmentMyProfileDetails.H;
                    if (cmbTextView10 != null) {
                        cmbTextView10.setText(fragmentMyProfileDetails.q3(questionWAnswers));
                    }
                } else {
                    CmbTextView cmbTextView11 = fragmentMyProfileDetails.H;
                    if (cmbTextView11 != null) {
                        cmbTextView11.setText((CharSequence) null);
                    }
                }
                CmbTextView cmbTextView12 = fragmentMyProfileDetails.H;
                if (cmbTextView12 != null) {
                    cmbTextView12.setOnClickListener(new s3(fragmentMyProfileDetails, questionWAnswers));
                    return;
                }
                return;
            case 13:
                Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer == null || (floatValue = answer.getFloatValue()) == null) {
                    i10 = 168;
                } else {
                    i10 = c.b(floatValue.floatValue());
                }
                Height height = new Height(i10);
                fragmentMyProfileDetails.r5(height);
                CmbTextView cmbTextView13 = fragmentMyProfileDetails.f13552x;
                if (cmbTextView13 != null) {
                    cmbTextView13.setOnClickListener(new t3(fragmentMyProfileDetails, height, questionWAnswers));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.S4(QuestionGroupType.DATING_STYLE);
    }

    /* access modifiers changed from: private */
    public static final void j5(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers, "$questionWAnswers");
        fragmentMyProfileDetails.X2();
        fragmentMyProfileDetails.e5(questionWAnswers);
    }

    /* access modifiers changed from: private */
    public final void k4(String str) {
        LinearLayout linearLayout = this.U;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        if (str != null) {
            CmbEditText cmbEditText = this.D;
            kotlin.jvm.internal.j.d(cmbEditText);
            cmbEditText.setText(str);
        }
    }

    /* access modifiers changed from: private */
    public static final void k5(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers, "$questionWAnswers");
        fragmentMyProfileDetails.e5(questionWAnswers);
    }

    /* access modifiers changed from: private */
    public final void l4(List<String> list) {
        LinearLayout linearLayout = this.S;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        CmbTextView cmbTextView = this.Z;
        kotlin.jvm.internal.j.d(cmbTextView);
        cmbTextView.setText((String) list.stream().collect(Collectors.joining(AppsFlyerKit.COMMA)));
        CmbTextView cmbTextView2 = this.Z;
        kotlin.jvm.internal.j.d(cmbTextView2);
        cmbTextView2.setOnClickListener(new b3(this));
    }

    /* access modifiers changed from: private */
    public static final void l5(FragmentMyProfileDetails fragmentMyProfileDetails, QuestionWAnswers questionWAnswers, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(questionWAnswers, "$questionWAnswers");
        fragmentMyProfileDetails.e5(questionWAnswers);
    }

    /* access modifiers changed from: private */
    public static final void m4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.S4(QuestionGroupType.INTERESTS);
    }

    /* access modifiers changed from: private */
    public static final void m5(FragmentMyProfileDetails fragmentMyProfileDetails, Height height, QuestionWAnswers questionWAnswers, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(height, "$height");
        kotlin.jvm.internal.j.g(questionWAnswers, "$questionWAnswers");
        fragmentMyProfileDetails.X2();
        fragmentMyProfileDetails.X4(height, questionWAnswers.e());
    }

    /* access modifiers changed from: private */
    public final void n4(List<String> list) {
        LinearLayout linearLayout = this.V;
        kotlin.jvm.internal.j.d(linearLayout);
        linearLayout.setVisibility(0);
        if (!list.isEmpty()) {
            CmbTextView cmbTextView = this.f13555z;
            kotlin.jvm.internal.j.d(cmbTextView);
            cmbTextView.setText((String) list.stream().collect(Collectors.joining(", ")));
        }
    }

    /* access modifiers changed from: private */
    public final void n5() {
        DelayAutoCompleteTextView delayAutoCompleteTextView = this.E;
        kotlin.jvm.internal.j.d(delayAutoCompleteTextView);
        String obj = delayAutoCompleteTextView.getText().toString();
        DelayAutoCompleteTextView delayAutoCompleteTextView2 = this.F;
        kotlin.jvm.internal.j.d(delayAutoCompleteTextView2);
        String obj2 = delayAutoCompleteTextView2.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            if (!TextUtils.isEmpty(obj2)) {
                this.f13543q0 = null;
                CmbTextView cmbTextView = this.G;
                kotlin.jvm.internal.j.d(cmbTextView);
                cmbTextView.setText("");
            } else if (getActivity() != null) {
                NestedScrollView nestedScrollView = this.L;
                kotlin.jvm.internal.j.d(nestedScrollView);
                sb.a.i(nestedScrollView, R.string.error_education_required);
            }
        }
        if (TextUtils.isEmpty(obj2)) {
            this.f13544r0 = null;
            CmbTextView cmbTextView2 = this.H;
            kotlin.jvm.internal.j.d(cmbTextView2);
            cmbTextView2.setText("");
        }
        if (H3(obj, this.f13543q0, obj2, this.f13544r0)) {
            h4(true);
            ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
            kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
            modelProfileUpdateDelta.updateEducation(obj, this.f13543q0, obj2, this.f13544r0);
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            networkProfile.setEducation(obj, obj2);
            NetworkProfile networkProfile2 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile2);
            networkProfile2.setDegrees(this.f13543q0, this.f13544r0);
            NetworkProfile j10 = M0().j();
            kotlin.jvm.internal.j.d(j10);
            j10.setEducation(obj, obj2);
            NetworkProfile j11 = M0().j();
            kotlin.jvm.internal.j.d(j11);
            j11.setDegrees(this.f13543q0, this.f13544r0);
            if (!TextUtils.isEmpty(this.f13543q0) || !TextUtils.isEmpty(this.f13544r0)) {
                w8.a aVar = this.f13549v0;
                kotlin.jvm.internal.j.d(aVar);
                aVar.c();
            }
        }
    }

    private final Height o3() {
        Height height;
        int i10;
        int i11;
        int i12;
        NetworkProfile networkProfile = this.f13519d0;
        boolean z10 = true;
        if (networkProfile == null || !networkProfile.isHeightUnitMetric()) {
            z10 = false;
        }
        if (z10) {
            NetworkProfile networkProfile2 = this.f13519d0;
            if (networkProfile2 != null) {
                i12 = networkProfile2.getHeightCm();
            } else {
                i12 = 168;
            }
            height = new Height(i12);
        } else {
            NetworkProfile networkProfile3 = this.f13519d0;
            if (networkProfile3 != null) {
                i10 = networkProfile3.getHeightFeet();
            } else {
                i10 = 5;
            }
            NetworkProfile networkProfile4 = this.f13519d0;
            if (networkProfile4 != null) {
                i11 = networkProfile4.getHeightInches();
            } else {
                i11 = 6;
            }
            height = new Height(i10, i11);
        }
        return height;
    }

    private final void o4() {
        CmbEditText cmbEditText = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText);
        cmbEditText.setOnFocusChangeListener(new z1(this));
        CmbEditText cmbEditText2 = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText2);
        cmbEditText2.setOnEditorActionListener(new l2(this));
        CmbEditText cmbEditText3 = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText3);
        cmbEditText3.setOnFocusChangeListener(new m2(this));
        CmbEditText cmbEditText4 = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText4);
        cmbEditText4.addTextChangedListener(new d(this));
        CmbEditText cmbEditText5 = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText5);
        cmbEditText5.setOnClickListener(new n2(this));
        CmbEditText cmbEditText6 = this.D;
        kotlin.jvm.internal.j.d(cmbEditText6);
        cmbEditText6.setOnEditorActionListener(new o2(this));
        CmbEditText cmbEditText7 = this.D;
        kotlin.jvm.internal.j.d(cmbEditText7);
        cmbEditText7.setOnFocusChangeListener(new p2(this));
        CmbEditText cmbEditText8 = this.D;
        kotlin.jvm.internal.j.d(cmbEditText8);
        cmbEditText8.addTextChangedListener(new e(this));
        if (!i3().a("ProfileMigration.Enabled.Android")) {
            q2 q2Var = new q2(this);
            r2 r2Var = new r2(this);
            f fVar = new f(this);
            s2 s2Var = new s2(this);
            DelayAutoCompleteTextView delayAutoCompleteTextView = this.E;
            if (delayAutoCompleteTextView != null) {
                delayAutoCompleteTextView.addTextChangedListener(fVar);
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView2 = this.F;
            if (delayAutoCompleteTextView2 != null) {
                delayAutoCompleteTextView2.addTextChangedListener(fVar);
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView3 = this.E;
            if (delayAutoCompleteTextView3 != null) {
                delayAutoCompleteTextView3.setOnFocusChangeListener(q2Var);
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView4 = this.F;
            if (delayAutoCompleteTextView4 != null) {
                delayAutoCompleteTextView4.setOnFocusChangeListener(q2Var);
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView5 = this.E;
            if (delayAutoCompleteTextView5 != null) {
                delayAutoCompleteTextView5.setOnEditorActionListener(r2Var);
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView6 = this.F;
            if (delayAutoCompleteTextView6 != null) {
                delayAutoCompleteTextView6.setOnEditorActionListener(r2Var);
            }
            CmbTextView cmbTextView = this.G;
            if (cmbTextView != null) {
                cmbTextView.setOnClickListener(s2Var);
            }
            CmbTextView cmbTextView2 = this.H;
            if (cmbTextView2 != null) {
                cmbTextView2.setOnClickListener(s2Var);
            }
            LinearLayout linearLayout = this.O;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            CmbTextView cmbTextView3 = this.f13552x;
            kotlin.jvm.internal.j.d(cmbTextView3);
            cmbTextView3.setOnClickListener(new u2(this));
            CmbEditText cmbEditText9 = this.B;
            kotlin.jvm.internal.j.d(cmbEditText9);
            cmbEditText9.setOnFocusChangeListener(new a2(this));
            CmbEditText cmbEditText10 = this.B;
            kotlin.jvm.internal.j.d(cmbEditText10);
            cmbEditText10.setOnEditorActionListener(new b2(this));
            CmbEditText cmbEditText11 = this.C;
            kotlin.jvm.internal.j.d(cmbEditText11);
            cmbEditText11.setOnFocusChangeListener(new c2(this));
            CmbEditText cmbEditText12 = this.C;
            kotlin.jvm.internal.j.d(cmbEditText12);
            cmbEditText12.setOnEditorActionListener(new d2(this));
            g gVar = new g(this);
            e2 e2Var = new e2(this);
            f2 f2Var = new f2(this);
            CmbEditText cmbEditText13 = this.I;
            if (cmbEditText13 != null) {
                cmbEditText13.addTextChangedListener(gVar);
            }
            CmbEditText cmbEditText14 = this.I;
            if (cmbEditText14 != null) {
                cmbEditText14.setOnFocusChangeListener(e2Var);
            }
            CmbEditText cmbEditText15 = this.I;
            if (cmbEditText15 != null) {
                cmbEditText15.setOnEditorActionListener(f2Var);
            }
            CmbEditText cmbEditText16 = this.J;
            if (cmbEditText16 != null) {
                cmbEditText16.setOnFocusChangeListener(e2Var);
            }
            CmbEditText cmbEditText17 = this.J;
            if (cmbEditText17 != null) {
                cmbEditText17.setOnEditorActionListener(f2Var);
            }
            CmbEditText cmbEditText18 = this.J;
            if (cmbEditText18 != null) {
                cmbEditText18.addTextChangedListener(gVar);
            }
            CmbEditText cmbEditText19 = this.K;
            if (cmbEditText19 != null) {
                cmbEditText19.setOnFocusChangeListener(e2Var);
            }
            CmbEditText cmbEditText20 = this.K;
            if (cmbEditText20 != null) {
                cmbEditText20.setOnEditorActionListener(f2Var);
            }
            CmbEditText cmbEditText21 = this.K;
            if (cmbEditText21 != null) {
                cmbEditText21.addTextChangedListener(gVar);
            }
            CmbTextView cmbTextView4 = this.f13550w;
            if (cmbTextView4 != null) {
                cmbTextView4.setOnClickListener(new g2(this));
            }
            CmbTextView cmbTextView5 = this.f13554y;
            kotlin.jvm.internal.j.d(cmbTextView5);
            cmbTextView5.setOnClickListener(new h2(this));
        }
        CmbTextView cmbTextView6 = this.f13546t;
        kotlin.jvm.internal.j.d(cmbTextView6);
        cmbTextView6.setOnClickListener(new j2(this));
        CmbTextView cmbTextView7 = this.f13555z;
        kotlin.jvm.internal.j.d(cmbTextView7);
        cmbTextView7.setOnClickListener(new k2(this));
    }

    /* access modifiers changed from: private */
    public final void o5() {
        CmbEditText cmbEditText = this.f13540p;
        kotlin.jvm.internal.j.d(cmbEditText);
        String valueOf = String.valueOf(cmbEditText.getText());
        if (TextUtils.isEmpty(valueOf)) {
            if (getActivity() != null) {
                NestedScrollView nestedScrollView = this.L;
                kotlin.jvm.internal.j.d(nestedScrollView);
                sb.a.i(nestedScrollView, R.string.error_email_required);
            }
        } else if (!h5.h.a(valueOf) || StringsKt__StringsKt.O(valueOf, "@coffeemeetsbagel.com", false, 2, (Object) null)) {
            if (getActivity() != null) {
                NestedScrollView nestedScrollView2 = this.L;
                kotlin.jvm.internal.j.d(nestedScrollView2);
                sb.a.i(nestedScrollView2, R.string.error_email_invalid);
            }
            CmbEditText cmbEditText2 = this.f13540p;
            kotlin.jvm.internal.j.d(cmbEditText2);
            CmbEditText cmbEditText3 = this.f13540p;
            kotlin.jvm.internal.j.d(cmbEditText3);
            Editable text = cmbEditText3.getText();
            kotlin.jvm.internal.j.d(text);
            cmbEditText2.setSelection(text.length());
        } else {
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            if (!kotlin.jvm.internal.j.b(valueOf, networkProfile.getUserEmail())) {
                h4(true);
                NetworkProfile networkProfile2 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile2);
                CmbEditText cmbEditText4 = this.f13540p;
                kotlin.jvm.internal.j.d(cmbEditText4);
                networkProfile2.setUserEmail(String.valueOf(cmbEditText4.getText()));
                ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
                kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
                CmbEditText cmbEditText5 = this.f13540p;
                kotlin.jvm.internal.j.d(cmbEditText5);
                modelProfileUpdateDelta.updateEmail(String.valueOf(cmbEditText5.getText()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final String p3(List<String> list) {
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getResources().getStringArray(R.array.ethnicity);
        kotlin.jvm.internal.j.f(stringArray, "resources.getStringArray(R.array.ethnicity)");
        for (String index : list) {
            String str = stringArray[Ethnicity.getIndex(index)];
            kotlin.jvm.internal.j.f(str, "ethnicities[Ethnicity.getIndex(selectedEthnicity)]");
            arrayList.add(str);
        }
        String join = StringUtils.join(arrayList);
        kotlin.jvm.internal.j.f(join, "join(localizedEthnicities)");
        return join;
    }

    /* access modifiers changed from: private */
    public static final void p4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.o5();
        }
    }

    private final void p5() {
        CmbEditText cmbEditText = this.C;
        kotlin.jvm.internal.j.d(cmbEditText);
        String valueOf = String.valueOf(cmbEditText.getText());
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        if (!kotlin.jvm.internal.j.b(valueOf, networkProfile.getEmployer())) {
            h4(true);
            NetworkProfile networkProfile2 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile2);
            networkProfile2.setEmployer(valueOf);
            NetworkProfile j10 = M0().j();
            kotlin.jvm.internal.j.d(j10);
            j10.setEmployer(valueOf);
            ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
            kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
            modelProfileUpdateDelta.updateEmployer(valueOf);
        }
    }

    private final String q3(QuestionWAnswers questionWAnswers) {
        if (!(!questionWAnswers.d().isEmpty())) {
            return null;
        }
        HashMap hashMap = new HashMap();
        questionWAnswers.e().getOptions().forEach(new w3(hashMap));
        ArrayList arrayList = new ArrayList();
        questionWAnswers.d().forEach(new x3(hashMap, arrayList));
        return m1.a(", ", arrayList);
    }

    /* access modifiers changed from: private */
    public static final boolean q4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.o5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return true;
    }

    private final void q5() {
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        if (networkProfile.isHeightUnitMetric()) {
            NetworkProfile networkProfile2 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile2);
            int heightCm = networkProfile2.getHeightCm();
            if (heightCm > 0) {
                r5(new Height(heightCm));
                return;
            }
            return;
        }
        NetworkProfile networkProfile3 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile3);
        int heightFeet = networkProfile3.getHeightFeet();
        NetworkProfile networkProfile4 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile4);
        int heightInches = networkProfile4.getHeightInches();
        if (heightFeet > 0) {
            r5(new Height(heightFeet, heightInches));
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(Map map, Option option) {
        kotlin.jvm.internal.j.g(map, "$optionMap");
        kotlin.jvm.internal.j.g(option, "<name for destructuring parameter 0>");
        map.put(option.component1(), option.component3());
    }

    /* access modifiers changed from: private */
    public static final void r4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.o5();
        }
    }

    private final void r5(Height height) {
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        if (networkProfile.isHeightUnitMetric()) {
            CmbTextView cmbTextView = this.f13552x;
            kotlin.jvm.internal.j.d(cmbTextView);
            cmbTextView.setText(getString(R.string.height_metric_format, Integer.valueOf(height.getHeightCentimetres())));
            return;
        }
        CmbTextView cmbTextView2 = this.f13552x;
        kotlin.jvm.internal.j.d(cmbTextView2);
        cmbTextView2.setText(getString(R.string.height_feet_and_inches_format, Integer.valueOf(height.getHeightFeet()), Integer.valueOf(height.getHeightInches())));
    }

    /* access modifiers changed from: private */
    public static final void s3(Map map, List list, Answer answer) {
        kotlin.jvm.internal.j.g(map, "$optionMap");
        kotlin.jvm.internal.j.g(list, "$answers");
        kotlin.jvm.internal.j.g(answer, "<name for destructuring parameter 0>");
        list.add((String) map.get(answer.component2()));
    }

    /* access modifiers changed from: private */
    public static final void s4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        lc.c.e(fragmentMyProfileDetails.requireActivity());
    }

    /* access modifiers changed from: private */
    public final void s5() {
        CmbEditText cmbEditText = this.D;
        kotlin.jvm.internal.j.d(cmbEditText);
        String valueOf = String.valueOf(cmbEditText.getText());
        if (!kotlin.jvm.internal.j.b(valueOf, this.f13545s0)) {
            Z3(this, (List) null, valueOf, this.f13547t0, QuestionGroupType.IDENTITY_PROFILE.getQuestionGroupApiString(), 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean t4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.s5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return true;
    }

    /* access modifiers changed from: private */
    public final void t5() {
        String str;
        String str2;
        String str3;
        if (!i3().a("ProfileMigration.Enabled.Android")) {
            CmbEditText cmbEditText = this.I;
            kotlin.jvm.internal.j.d(cmbEditText);
            String valueOf = String.valueOf(cmbEditText.getText());
            CmbEditText cmbEditText2 = this.J;
            kotlin.jvm.internal.j.d(cmbEditText2);
            String valueOf2 = String.valueOf(cmbEditText2.getText());
            CmbEditText cmbEditText3 = this.K;
            kotlin.jvm.internal.j.d(cmbEditText3);
            String valueOf3 = String.valueOf(cmbEditText3.getText());
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            String str4 = null;
            if (!CollectionUtils.isEmpty((List) networkProfile.getIcebreakers())) {
                NetworkProfile networkProfile2 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile2);
                if (networkProfile2.getIcebreakers().size() > 0) {
                    NetworkProfile networkProfile3 = this.f13519d0;
                    kotlin.jvm.internal.j.d(networkProfile3);
                    str3 = networkProfile3.getIcebreakers().get(0);
                } else {
                    str3 = null;
                }
                NetworkProfile networkProfile4 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile4);
                if (networkProfile4.getIcebreakers().size() > 1) {
                    NetworkProfile networkProfile5 = this.f13519d0;
                    kotlin.jvm.internal.j.d(networkProfile5);
                    str = networkProfile5.getIcebreakers().get(1);
                } else {
                    str = null;
                }
                NetworkProfile networkProfile6 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile6);
                if (networkProfile6.getIcebreakers().size() > 2) {
                    NetworkProfile networkProfile7 = this.f13519d0;
                    kotlin.jvm.internal.j.d(networkProfile7);
                    str4 = networkProfile7.getIcebreakers().get(2);
                }
                String str5 = str4;
                str4 = str3;
                str2 = str5;
            } else {
                str2 = null;
                str = null;
            }
            if (!kotlin.jvm.internal.j.b(valueOf, str4) || !kotlin.jvm.internal.j.b(valueOf2, str) || !kotlin.jvm.internal.j.b(valueOf3, str2)) {
                h4(true);
                ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
                kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
                modelProfileUpdateDelta.updateIcebreakers(valueOf, valueOf2, valueOf3);
                NetworkProfile networkProfile8 = this.f13519d0;
                kotlin.jvm.internal.j.d(networkProfile8);
                networkProfile8.setIcebreakers(valueOf, valueOf2, valueOf3);
                NetworkProfile j10 = M0().j();
                if (j10 != null) {
                    j10.setIcebreakers(valueOf, valueOf2, valueOf3);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void u4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.s5();
        }
    }

    private final void u5() {
        CmbEditText cmbEditText = this.B;
        kotlin.jvm.internal.j.d(cmbEditText);
        String valueOf = String.valueOf(cmbEditText.getText());
        if (TextUtils.isEmpty(valueOf)) {
            if (getActivity() != null) {
                NestedScrollView nestedScrollView = this.L;
                kotlin.jvm.internal.j.d(nestedScrollView);
                sb.a.i(nestedScrollView, R.string.error_occupation_required);
            }
            ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
            kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
            modelProfileUpdateDelta.removeOccupation();
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            networkProfile.setOccupation((String) null);
            return;
        }
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        if (!kotlin.jvm.internal.j.b(valueOf, networkProfile2.getOccupation())) {
            A0 = true;
            NetworkProfile networkProfile3 = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile3);
            networkProfile3.setOccupation(valueOf);
            NetworkProfile j10 = M0().j();
            kotlin.jvm.internal.j.d(j10);
            j10.setOccupation(valueOf);
            ModelProfileUpdateDelta modelProfileUpdateDelta2 = f13514z0;
            kotlin.jvm.internal.j.d(modelProfileUpdateDelta2);
            modelProfileUpdateDelta2.updateOccupation(valueOf);
        }
    }

    /* access modifiers changed from: private */
    public static final void v4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.n5();
        }
    }

    private final void w3(Height height, Question question) {
        Height height2 = height;
        r5(height);
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        networkProfile.setHeight(height2);
        NetworkProfile j10 = M0().j();
        if (j10 != null) {
            j10.setHeight(height2);
        }
        if (question != null) {
            ((com.uber.autodispose.m) SaveAnswerUseCase.d(t3(), (List) null, (String) null, question.getId(), QuestionGroupType.ORIGINAL_PROFILE.getQuestionGroupApiString(), (Integer) null, Float.valueOf((float) height.getHeightCentimetres()), (Float) null, (Float) null, false, (Location) null, 979, (Object) null).j(com.uber.autodispose.a.a(this))).f(new u3(), new v3(FragmentMyProfileDetails$handleHeightPickerDismiss$2.f13564a));
            return;
        }
        h4(true);
        ModelProfileUpdateDelta modelProfileUpdateDelta = f13514z0;
        kotlin.jvm.internal.j.d(modelProfileUpdateDelta);
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        modelProfileUpdateDelta.updateHeight(height2, networkProfile2.isHeightUnitMetric());
        h5.i.b(EventType.HEIGHT_UPDATED);
    }

    /* access modifiers changed from: private */
    public static final boolean w4(FragmentMyProfileDetails fragmentMyProfileDetails, TextView textView, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (i10 != 6) {
            return false;
        }
        fragmentMyProfileDetails.n5();
        lc.c.a(fragmentMyProfileDetails.getActivity());
        return false;
    }

    private final void w5(boolean z10, View view) {
        a.C0491a aVar = fa.a.f40771d;
        aVar.a("FragmentMyProfileDetails", "ENTER #profileEdit");
        if (A0) {
            aVar.a("FragmentMyProfileDetails", "Something changed in #profileEdit");
            Bakery.w().G().p(this.f13538n0, f13514z0, true);
            if (D0().isLoggedIn()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(Extra.WAS_PROFILED_EDITED, true);
                h5.i.c(EventType.PROFILE_SAVED, bundle);
                h5.i.b(EventType.PROFILE_UPDATE);
            }
            A0 = false;
            if (z10 && getActivity() != null) {
                kotlin.jvm.internal.j.d(view);
                sb.a.i(view, R.string.saved);
                return;
            }
            return;
        }
        aVar.a("FragmentMyProfileDetails", "Nothing changed");
    }

    /* access modifiers changed from: private */
    public static final void x3() {
        fa.a.f40771d.a("FragmentMyProfileDetails", "Saved height.");
    }

    /* access modifiers changed from: private */
    public static final void x4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        kotlin.jvm.internal.j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
        fragmentMyProfileDetails.X2();
        fragmentMyProfileDetails.T4((CmbTextView) view);
    }

    /* access modifiers changed from: private */
    public static final void y3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y4(FragmentMyProfileDetails fragmentMyProfileDetails, View view) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        fragmentMyProfileDetails.X2();
        Y4(fragmentMyProfileDetails, fragmentMyProfileDetails.o3(), (Question) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void z4(FragmentMyProfileDetails fragmentMyProfileDetails, View view, boolean z10) {
        kotlin.jvm.internal.j.g(fragmentMyProfileDetails, "this$0");
        if (!z10) {
            fragmentMyProfileDetails.u5();
            return;
        }
        CmbEditText cmbEditText = fragmentMyProfileDetails.B;
        kotlin.jvm.internal.j.d(cmbEditText);
        CmbEditText cmbEditText2 = fragmentMyProfileDetails.B;
        kotlin.jvm.internal.j.d(cmbEditText2);
        cmbEditText.setSelection(cmbEditText2.length());
        lc.c.f(fragmentMyProfileDetails.requireActivity(), fragmentMyProfileDetails.B);
    }

    public final boolean B3() {
        return A0;
    }

    public void L() {
        c9.a l32 = l3();
        kotlin.jvm.internal.j.d(l32);
        ((t) l32.a(ResourceType.DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new b4(new FragmentMyProfileDetails$onResourcesRefreshed$1(this)));
    }

    public final void h4(boolean z10) {
        A0 = z10;
    }

    public final r i3() {
        r rVar = this.f13518d;
        if (rVar != null) {
            return rVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final com.coffeemeetsbagel.qna.e j3() {
        com.coffeemeetsbagel.qna.e eVar = this.f13522f;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.j.y("getMCQAnswersUseCase");
        return null;
    }

    public final com.coffeemeetsbagel.qna.j k3() {
        com.coffeemeetsbagel.qna.j jVar = this.f13524g;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("getQuestionGroupUseCase");
        return null;
    }

    public final c9.a l3() {
        c9.a aVar = this.f13529j;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("getResourcesUseCase");
        return null;
    }

    public final GetSingleSchoolsUseCase m3() {
        GetSingleSchoolsUseCase getSingleSchoolsUseCase = this.f13531k;
        if (getSingleSchoolsUseCase != null) {
            return getSingleSchoolsUseCase;
        }
        kotlin.jvm.internal.j.y("getSchoolsUseCase");
        return null;
    }

    public void n0(EventType eventType, Bundle bundle) {
        String str;
        kotlin.jvm.internal.j.g(eventType, "eventType");
        kotlin.jvm.internal.j.g(bundle, "data");
        if (eventType == EventType.MEASUREMENT_UNITS_UPDATED && !i3().a("ProfileMigration.Enabled.Android")) {
            a.C0491a aVar = fa.a.f40771d;
            if (bundle.getBoolean("is_metric")) {
                str = "metric";
            } else {
                str = "imperial";
            }
            aVar.a("FragmentMyProfileDetails", "User settings changed, units are now: " + str);
            this.f13519d0 = M0().j();
            q5();
        }
    }

    public final GetUserMCQUseCase n3() {
        GetUserMCQUseCase getUserMCQUseCase = this.f13520e;
        if (getUserMCQUseCase != null) {
            return getUserMCQUseCase;
        }
        kotlin.jvm.internal.j.y("getUserMCQwAnswerUseCase");
        return null;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        A0 = true;
        w5(false, this.L);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().g1(this);
        super.onCreate(bundle);
        if (bundle == null) {
            this.f13519d0 = M0().j();
        } else if (bundle.containsKey("user_profile")) {
            this.f13519d0 = (NetworkProfile) bundle.getSerializable("user_profile");
        }
        NetworkProfile networkProfile = this.f13519d0;
        if (networkProfile != null) {
            kotlin.jvm.internal.j.d(networkProfile);
            List<String> listDegrees = networkProfile.getListDegrees();
            if (!CollectionUtils.isEmpty((List) listDegrees)) {
                this.f13543q0 = listDegrees.get(0);
                if (listDegrees.size() > 1) {
                    this.f13544r0 = listDegrees.get(1);
                }
            }
        }
        w8.c cVar = new w8.c(this, M0(), C0());
        this.f13549v0 = cVar;
        cVar.start();
        ((com.uber.autodispose.p) this.f13536m0.q(500, TimeUnit.MILLISECONDS).g(com.uber.autodispose.a.a(this))).c(new x1(new FragmentMyProfileDetails$onCreate$1(this)));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.j.g(layoutInflater, "layoutInflater");
        k6.m G2 = k6.m.G(layoutInflater, viewGroup, false);
        kotlin.jvm.internal.j.f(G2, "inflate(layoutInflater, parent, false)");
        View root = G2.getRoot();
        kotlin.jvm.internal.j.f(root, "binding.root");
        C3(root);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.core_profile_data_questions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        s7.b bVar = new s7.b();
        this.f13551w0 = bVar;
        recyclerView.setAdapter(bVar);
        f4();
        GetUserMCQUseCase n32 = n3();
        kotlin.jvm.internal.j.d(n32);
        ((com.uber.autodispose.n) n32.c(QuestionGroupType.CORE_PROFILE_DATA, false).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new t2(new FragmentMyProfileDetails$onCreateView$1(this)));
        com.coffeemeetsbagel.qna.e j32 = j3();
        kotlin.jvm.internal.j.d(j32);
        NetworkProfile networkProfile = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile);
        String id2 = networkProfile.getId();
        kotlin.jvm.internal.j.f(id2, "selfProfile!!.id");
        ((com.uber.autodispose.n) j32.a(id2, QuestionGroupType.INTERESTS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new a4(new FragmentMyProfileDetails$onCreateView$2(this)), new c4(FragmentMyProfileDetails$onCreateView$3.f13581a));
        com.coffeemeetsbagel.qna.e j33 = j3();
        kotlin.jvm.internal.j.d(j33);
        NetworkProfile networkProfile2 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile2);
        String id3 = networkProfile2.getId();
        kotlin.jvm.internal.j.f(id3, "selfProfile!!.id");
        ((com.uber.autodispose.n) j33.a(id3, QuestionGroupType.DATING_STYLE).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new d4(new FragmentMyProfileDetails$onCreateView$4(this)), new e4(FragmentMyProfileDetails$onCreateView$5.f13582a));
        com.coffeemeetsbagel.qna.j k32 = k3();
        kotlin.jvm.internal.j.d(k32);
        NetworkProfile networkProfile3 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile3);
        String id4 = networkProfile3.getId();
        kotlin.jvm.internal.j.f(id4, "selfProfile!!.id");
        ((t) k32.a(id4, QuestionGroupType.IDENTITY_PROFILE, false).L().D(new n1(FragmentMyProfileDetails$onCreateView$6.f13583a)).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new o1(new FragmentMyProfileDetails$onCreateView$7(this)), new p1(FragmentMyProfileDetails$onCreateView$8.f13584a));
        com.coffeemeetsbagel.qna.e j34 = j3();
        kotlin.jvm.internal.j.d(j34);
        NetworkProfile networkProfile4 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile4);
        String id5 = networkProfile4.getId();
        kotlin.jvm.internal.j.f(id5, "selfProfile!!.id");
        ((com.uber.autodispose.n) j34.a(id5, QuestionGroupType.VALUES).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new q1(new FragmentMyProfileDetails$onCreateView$9(this)), new r1(FragmentMyProfileDetails$onCreateView$10.f13579a));
        com.coffeemeetsbagel.qna.e j35 = j3();
        kotlin.jvm.internal.j.d(j35);
        NetworkProfile networkProfile5 = this.f13519d0;
        kotlin.jvm.internal.j.d(networkProfile5);
        String id6 = networkProfile5.getId();
        kotlin.jvm.internal.j.f(id6, "selfProfile!!.id");
        ((com.uber.autodispose.n) j35.a(id6, QuestionGroupType.PERSONALITY).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new e3(new FragmentMyProfileDetails$onCreateView$11(this)), new p3(FragmentMyProfileDetails$onCreateView$12.f13580a));
        z3(getArguments());
        return root;
    }

    public void onDestroy() {
        super.onDestroy();
        w8.a aVar = this.f13549v0;
        kotlin.jvm.internal.j.d(aVar);
        aVar.stop();
        Dialog dialog = this.f13521e0;
        if (dialog != null) {
            lc.c.h(dialog);
        }
        Dialog dialog2 = this.f13523f0;
        if (dialog2 != null) {
            lc.c.h(dialog2);
        }
        lc.c.h(this.f13527h0);
        lc.c.h(this.f13528i0);
        lc.c.h(this.f13530j0);
    }

    public void onPause() {
        super.onPause();
        w5(false, this.L);
        O0().b(this);
    }

    public void onResume() {
        super.onResume();
        A0 = false;
        Bakery.w().z().f("My Profile - Edit Details");
        NetworkProfile j10 = M0().j();
        if (j10 != null) {
            NetworkProfile networkProfile = this.f13519d0;
            kotlin.jvm.internal.j.d(networkProfile);
            if (!kotlin.jvm.internal.j.b(networkProfile.getLocation(), j10.getLocation())) {
                h4(true);
            }
            this.f13519d0 = j10;
        }
        if (this.f13539o0 == null) {
            c9.a l32 = l3();
            kotlin.jvm.internal.j.d(l32);
            ((t) l32.a(ResourceType.DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new i2(new FragmentMyProfileDetails$onResume$1(this)));
        }
        c3();
        o4();
    }

    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.j.g(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user_profile", this.f13519d0);
    }

    public void onStart() {
        super.onStart();
        h5.i.a(this, EventType.MEASUREMENT_UNITS_UPDATED);
    }

    public void onStop() {
        super.onStop();
        h5.i.d(this, EventType.MEASUREMENT_UNITS_UPDATED);
    }

    public final SaveAnswerUseCase t3() {
        SaveAnswerUseCase saveAnswerUseCase = this.f13526h;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        kotlin.jvm.internal.j.y("saveAnswerUseCase");
        return null;
    }

    public final SaveMyProfileLocalUseCase u3() {
        SaveMyProfileLocalUseCase saveMyProfileLocalUseCase = this.f13535m;
        if (saveMyProfileLocalUseCase != null) {
            return saveMyProfileLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveMyProfileLocalUseCase");
        return null;
    }

    public final SaveProfilesLocalUseCase v3() {
        SaveProfilesLocalUseCase saveProfilesLocalUseCase = this.f13533l;
        if (saveProfilesLocalUseCase != null) {
            return saveProfilesLocalUseCase;
        }
        kotlin.jvm.internal.j.y("saveProfilesLocalUseCase");
        return null;
    }

    public final boolean v5(boolean z10, View view) {
        fa.a.f40771d.a("FragmentMyProfileDetails", "ENTER");
        w5(z10, view);
        return A0;
    }

    public final void z3(Bundle bundle) {
        ProfileCategory profileCategory;
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey(Extra.DEEP_LINK)) {
            Uri uri = (Uri) bundle.getParcelable(Extra.DEEP_LINK);
            if (uri != null) {
                a.C0491a aVar = fa.a.f40771d;
                aVar.a("FragmentMyProfileDetails", "Handling deep link: " + uri);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() >= 3) {
                    ProfileCategory.a aVar2 = ProfileCategory.f12802a;
                    String str = pathSegments.get(2);
                    kotlin.jvm.internal.j.f(str, "segments[2]");
                    ProfileCategory a10 = aVar2.a(str);
                    if (a10 != null) {
                        c4(a10);
                    }
                }
            }
        } else if (bundle.containsKey(Extra.PROFILE_CATEGORY) && bundle.containsKey(Extra.PROFILE_CATEGORY) && (profileCategory = (ProfileCategory) bundle.get(Extra.PROFILE_CATEGORY)) != null) {
            c4(profileCategory);
        }
    }
}
