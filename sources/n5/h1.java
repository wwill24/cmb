package n5;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bagel_profile.BagelProfileComponentActivity;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.dialogs.b0;
import com.coffeemeetsbagel.feature.chat.features.photo.FullscreenPhotoActivity;
import com.coffeemeetsbagel.feature.chat.features.reopen.ChatReopenPromptType;
import com.coffeemeetsbagel.feature.chat.features.reopen.ChatReopenView;
import com.coffeemeetsbagel.feature.chatlist.a1;
import com.coffeemeetsbagel.hidereport.main.HideReportComponentActivity;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbMessage;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.MessageBase;
import com.coffeemeetsbagel.models.MessageToSend;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.models.responses.ResponseBagel;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.shop.ShopComponentActivity;
import com.coffeemeetsbagel.stickers.StickerRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.domain.BenefitKeys;
import com.coffeemeetsbagel.util.RequestCode;
import com.coffeemeetsbagel.utils.model.Optional;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import j5.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k7.a0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import n8.s;
import org.jivesoftware.smackx.chatstates.ChatState;
import qj.q;
import r7.i;
import w9.b;

public class h1 extends r7.b implements z9.f, k7.g, k7.a, k7.c, j.b, a1 {
    /* access modifiers changed from: private */
    public HashMap<View, View> B;
    /* access modifiers changed from: private */
    public int C = 0;
    /* access modifiers changed from: private */
    public ViewGroup D;
    /* access modifiers changed from: private */
    public r7.i E;
    private ViewGroup F;
    private Dialog G;
    private Dialog H;
    private Dialog I;
    /* access modifiers changed from: private */
    public ChatReopenView J;
    /* access modifiers changed from: private */
    public androidx.constraintlayout.widget.c K;
    /* access modifiers changed from: private */
    public androidx.constraintlayout.widget.c L;
    private ImageView M;
    private GridView N;
    private RelativeLayout O;
    private m7.a P;
    private ImageView Q;
    private TextView R;
    private r7.h S;
    private CmbLinearLayout T;
    private int U;
    /* access modifiers changed from: private */
    public k7.d V;
    private tj.b W;
    private Map<Integer, CmbMessage> X;
    private final tj.a Y = new tj.a();
    private final io.reactivex.subjects.a<View> Z = io.reactivex.subjects.a.C0();

    /* renamed from: a0  reason: collision with root package name */
    private final i f16483a0 = new i();

    /* renamed from: b0  reason: collision with root package name */
    s f16484b0;

    /* renamed from: c0  reason: collision with root package name */
    l8.h f16485c0;

    /* renamed from: d  reason: collision with root package name */
    private final long f16486d = 200;

    /* renamed from: d0  reason: collision with root package name */
    y8.a f16487d0;

    /* renamed from: e  reason: collision with root package name */
    private final float f16488e = 1.0f;

    /* renamed from: e0  reason: collision with root package name */
    p5.b f16489e0;

    /* renamed from: f  reason: collision with root package name */
    private final float f16490f = 0.8f;

    /* renamed from: f0  reason: collision with root package name */
    wb.c f16491f0;

    /* renamed from: g  reason: collision with root package name */
    private final float f16492g = 0.0f;

    /* renamed from: g0  reason: collision with root package name */
    c9.a f16493g0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Bagel f16494h;

    /* renamed from: h0  reason: collision with root package name */
    com.coffeemeetsbagel.feature.bagel.s f16495h0;

    /* renamed from: i0  reason: collision with root package name */
    StickerRepository f16496i0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public k f16497j;

    /* renamed from: j0  reason: collision with root package name */
    p5.a f16498j0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public EditText f16499k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ImageView f16500l;

    /* renamed from: m  reason: collision with root package name */
    private View f16501m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ListView f16502n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16503p;

    /* renamed from: q  reason: collision with root package name */
    private NetworkProfile f16504q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Price f16505t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f16506w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public k7.f f16507x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public CountDownTimer f16508y = null;

    /* renamed from: z  reason: collision with root package name */
    private n7.a f16509z = null;

    class a implements i.a {
        a() {
        }

        public void a() {
            if (h1.this.J != null) {
                h1 h1Var = h1.this;
                h1Var.I3(h1Var.K);
            }
        }

        public void b() {
            if (h1.this.J != null) {
                h1 h1Var = h1.this;
                h1Var.I3(h1Var.L);
            }
            if (((float) h1.this.f16502n.getFirstVisiblePosition()) / ((float) h1.this.f16497j.getCount()) <= 0.5f) {
                h1.this.V.n();
            }
        }
    }

    class b implements vj.f<Map<String, Price>> {
        b() {
        }

        /* renamed from: a */
        public void accept(Map<String, Price> map) throws Exception {
            h1.this.f16505t = map.get(PurchaseType.REOPEN_CHAT.d());
        }
    }

    class c implements TextWatcher {

        class a extends CountDownTimer {
            a(long j10, long j11) {
                super(j10, j11);
            }

            public void onFinish() {
                h1.this.F0().g(h1.this.f16494h, h1.this.f16499k.getText());
                h1.this.f16507x.a();
            }

            public void onTick(long j10) {
            }
        }

        c() {
        }

        public void afterTextChanged(Editable editable) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("afterTextChanged: ");
            sb2.append(editable.toString());
            if (!TextUtils.isEmpty(editable.toString())) {
                h1.this.f16500l.setEnabled(true);
                h1.this.f16507x.c();
                if (h1.this.f16508y != null) {
                    h1.this.f16508y.cancel();
                }
                h1.this.f16508y = new a(3000, 1000).start();
                return;
            }
            h1.this.f16500l.setEnabled(false);
            h1.this.F0().a(h1.this.f16494h);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    class d implements Animation.AnimationListener {
        d() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            h1.this.D.setTranslationY((float) h1.this.C);
            h1.this.D.animate().setDuration(200).translationY(0.0f);
        }
    }

    class e implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ValueAnimator f16515a;

        e(ValueAnimator valueAnimator) {
            this.f16515a = valueAnimator;
        }

        public void onAnimationEnd(Animation animation) {
            h1.this.i2();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            this.f16515a.start();
        }
    }

    class f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f16517a;

        f(View view) {
            this.f16517a = view;
        }

        public void onAnimationEnd(Animation animation) {
            View view = (View) h1.this.B.get(this.f16517a);
            if (view != null) {
                h1.this.A3(view);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    class g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f16519a;

        g(View view) {
            this.f16519a = view;
        }

        public void onAnimationEnd(Animation animation) {
            View view = (View) h1.this.B.get(this.f16519a);
            if (view != null) {
                h1.this.m2(view);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16521a;

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
                f16521a = r0
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.CHAT_EXTENDED_PUSH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16521a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.CONNECTION_DETAILS_UPDATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.h1.h.<clinit>():void");
        }
    }

    private class i implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16522a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16523b;

        private i() {
            this.f16522a = false;
            this.f16523b = false;
        }

        public boolean a() {
            return this.f16522a;
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            if (h1.this.E.a()) {
                this.f16522a = true;
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 0) {
                if (!this.f16523b) {
                    this.f16522a = false;
                }
                this.f16523b = true;
            } else {
                this.f16523b = false;
            }
            absListView.setOnTouchListener(h1.this.E);
        }
    }

    /* access modifiers changed from: private */
    public void A3(View view) {
        ScaleAnimation d22 = d2();
        view.setAnimation(d22);
        d22.start();
        d22.setAnimationListener(new f(view));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B2(List list, ConnectionDetails connectionDetails) throws Exception {
        this.F.findViewById(R.id.loading_view).setVisibility(8);
        this.V.s(list, connectionDetails);
        c2();
    }

    private void B3() {
        if (this.f16509z != null) {
            int measuredHeight = this.D.getMeasuredHeight();
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            ValueAnimator duration = ValueAnimator.ofInt(new int[]{measuredHeight, 0}).setDuration(200);
            duration.addUpdateListener(new q0(this, layoutParams));
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 0.0f, 1.0f);
            scaleAnimation.setDuration(200);
            this.f16509z.f16637b.startAnimation(scaleAnimation);
            scaleAnimation.setAnimationListener(new e(duration));
        }
    }

    private void C3() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(200);
        this.f16509z.f16637b.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new d());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit D2() {
        G3(false);
        HideReportComponentActivity.f13953j.a(requireActivity(), this.f16494h.getProfileId(), this.f16494h.getId(), false, this.f16494h.isConnected(), "chat_detail", Extra.BAGEL);
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: D3 */
    public void m2(View view) {
        ScaleAnimation f22 = f2();
        view.setAnimation(f22);
        f22.start();
        f22.setAnimationListener(new g(view));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit E2() {
        G3(true);
        HideReportComponentActivity.f13953j.a(requireActivity(), this.f16494h.getProfileId(), this.f16494h.getId(), true, this.f16494h.isConnected(), "chat_detail", Extra.BAGEL);
        return null;
    }

    private void E3(long j10, CmbToolbar cmbToolbar) {
        ((p) q.T(1, TimeUnit.SECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new g0(this, j10, cmbToolbar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F2(View view) {
        g3();
    }

    private void F3() {
        CmbToolbar T0 = ((j5.h) requireActivity()).T0();
        if (T0 != null) {
            Date date = DateUtils.getDate(this.f16494h.getDecouplingDate());
            if (date == null) {
                u3(T0);
                return;
            }
            long time = date.getTime();
            long currentTimeMillis = time - System.currentTimeMillis();
            if (currentTimeMillis > 86400000) {
                l3();
                T0.R();
                ((p) q.R(currentTimeMillis - 86400000, 1, TimeUnit.MILLISECONDS).n0(1).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d0(this, time, T0));
            } else if (currentTimeMillis > 0) {
                l3();
                E3(time, T0);
            } else {
                this.f16503p = true;
                u3(T0);
                l3();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G2(View view) {
        f3();
    }

    private void G3(boolean z10) {
        String str;
        if (z10) {
            str = "hide";
        } else {
            str = "report";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        hashMap.put(Extra.IS_CONNECTED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        hashMap.put("block_source", "chat_detail");
        C0().trackEvent("Block Confirmation Modal CTA Tapped", hashMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H2(x xVar) throws Exception {
        s8.b bVar = new s8.b(getContext(), new z(this), new a0(this));
        this.H = bVar;
        bVar.show();
    }

    private void H3(boolean z10) {
        if (z10) {
            C0().d("Chat Detail - Block Tapped");
        } else {
            C0().d("Chat Detail - Report Tapped");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I2(x xVar) throws Exception {
        ((ChatActivity) requireActivity()).G1();
    }

    /* access modifiers changed from: private */
    public void I3(androidx.constraintlayout.widget.c cVar) {
        x1.b bVar = new x1.b();
        bVar.c0(250);
        bVar.a(new com.coffeemeetsbagel.view.a());
        ChatReopenView chatReopenView = this.J;
        if (chatReopenView != null) {
            x1.p.a(chatReopenView, bVar);
            cVar.c(this.J);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J2(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) requireContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.f16499k.getWindowToken(), 0);
        }
        if (this.O.getVisibility() == 0) {
            j2();
        } else {
            this.f16507x.f();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K2() {
        this.f16502n.setSelection(this.f16497j.getCount() - 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L2(List list) throws Exception {
        this.f16497j.J(list);
        this.f16497j.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N2(Optional optional) throws Exception {
        this.f16497j.S(optional.d());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O2(ResponseBagel responseBagel) {
        this.f16506w = true;
        lc.c.h(this.G);
        responseBagel.getResult().setProfile(this.f16494h.getProfile());
        Bagel result = responseBagel.getResult();
        this.f16494h = result;
        if (result.getLastUpdated() == null || this.f16494h.getLastUpdated().isEmpty()) {
            String str = "bagel " + this.f16494h.getId() + " missing last_updated";
            fa.a.g("ChatFragment", str, new IllegalArgumentException(str));
        }
        i3();
        l3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P2(Throwable th2) {
        lc.c.h(this.G);
        x3(R.string.could_not_reopen_chat);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q2(View view) {
        z3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R2(View view) {
        O();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S2(x xVar) throws Exception {
        requireActivity().onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T2(x xVar) throws Exception {
        e3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U2(Price price, View view) {
        g2(price);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V2(AdapterView adapterView, View view, int i10, long j10) {
        this.f16507x.g((StickerNetwork) this.P.getItem(i10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit W2() {
        ((ChatActivity) requireActivity()).O1();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X2(Long l10) throws Exception {
        DialogPrimarySecondaryVertical.f12065a.a(requireContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, Integer.valueOf(R.drawable.ic_read_receipt), R.string.read_receipt_upsell_header, R.string.read_receipt_upsell_message, R.string.upgrade_now, new a1(this), Integer.valueOf(R.string.read_receipt_upsell_negative), (Function0<Unit>) null, (Function0<Unit>) null);
        C0().d("Chat Read Receipt Upsell Viewed");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y2(ViewGroup.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        if (layoutParams != null) {
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.D.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z2(long j10, CmbToolbar cmbToolbar, Long l10) throws Exception {
        int round = Math.round((float) ((j10 - System.currentTimeMillis()) / 1000));
        if (!this.f16494h.isPastDecouplingDate()) {
            cmbToolbar.setSubtitle(DateUtils.getCountdownTimerFromSeconds(round));
            return;
        }
        u3(cmbToolbar);
        l3();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a3(long j10, CmbToolbar cmbToolbar, Long l10) throws Exception {
        E3(j10, cmbToolbar);
    }

    private void b2(View view, View view2, View view3) {
        this.B.put(view, view2);
        this.B.put(view2, view3);
        this.B.put(view3, view);
        A3(view);
        new Handler().postDelayed(new w0(this, view), 200);
    }

    private boolean b3(ListView listView) {
        if (listView.getLastVisiblePosition() != listView.getAdapter().getCount() - 1 || listView.getChildAt(listView.getChildCount() - 1).getBottom() > listView.getHeight()) {
            return false;
        }
        return true;
    }

    private void c2() {
        ((t) this.f16484b0.y(this.f16494h.getId()).x(new l0()).B(new m0()).w0().K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new o0(this));
    }

    private void c3(ImageView imageView, NetworkProfile networkProfile) {
        q5.f.e(imageView);
        if (networkProfile == null) {
            fa.a.i(new IllegalStateException("profile null in load avatar"));
        }
        if (networkProfile == null || networkProfile.getProfilePhoto() == null || TextUtils.isEmpty(networkProfile.getProfilePhoto().getUrl())) {
            ImageView imageView2 = imageView;
            com.coffeemeetsbagel.image_loader.b.f13967a.a(requireContext(), R.drawable.icon_profile_placeholder, imageView2, (ImageLoaderContract.b) null, Arrays.asList(new b.c[]{b.c.f18331a}), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null);
            return;
        }
        String url = networkProfile.getProfilePhoto().getUrl();
        ImageView imageView3 = imageView;
        com.coffeemeetsbagel.image_loader.b.f13967a.b(requireContext(), url, imageView3, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, new ImageLoaderContract.b(190, 190), Arrays.asList(new b.c[]{b.c.f18331a}), Collections.emptyMap(), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    private ScaleAnimation d2() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f);
        scaleAnimation.setDuration(200);
        return scaleAnimation;
    }

    public static Fragment d3(@NonNull Bagel bagel) {
        h1 h1Var = new h1();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Extra.BAGEL, bagel);
        h1Var.setArguments(bundle);
        return h1Var;
    }

    private int e2(List<CmbMessage> list) {
        int i10;
        if (this.f16502n.getLastVisiblePosition() == this.f16497j.getCount() - 1) {
            return list.size() - 1;
        }
        int firstVisiblePosition = this.f16502n.getFirstVisiblePosition();
        if (list.size() == 0) {
            i10 = 0;
        } else {
            i10 = list.size() - 1;
        }
        CmbMessage cmbMessage = (CmbMessage) this.f16497j.getItem(firstVisiblePosition);
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (list.get(i11).equals(cmbMessage)) {
                i10 = i11;
            }
        }
        return i10;
    }

    private void e3() {
        String str;
        if (!this.f16506w && getActivity() != null && !getActivity().isFinishing()) {
            int beanCost = this.f16505t.getBeanCost(1);
            if (this.f16505t.isUnlimited() || beanCost == 0) {
                str = getString(R.string.no_beans_free_reopen);
            } else {
                str = getResources().getQuantityString(R.plurals.use_n_beans_to_reopen, beanCost, new Object[]{Integer.valueOf(beanCost)});
            }
            String string = getString(R.string.reopen_chat);
            String string2 = getString(R.string.continue_lc);
            String string3 = getString(R.string.not_now);
            DialogPrimarySecondaryVertical.f12065a.b(requireContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, string, str, string2, new u0(this), string3, (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    private ScaleAnimation f2() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f);
        scaleAnimation.setDuration(200);
        return scaleAnimation;
    }

    private void f3() {
        this.H.dismiss();
        v3(R.drawable.ic_report, R.string.report_post_connection_title, R.string.report_post_connection_description, new k0(this));
        H3(false);
    }

    private void g2(Price price) {
        lc.c.h(this.I);
        Intent intent = new Intent(getActivity(), ShopComponentActivity.class);
        intent.putExtra(Extra.PURCHASE_TYPE, PurchaseType.DISCOVER_LIKES);
        intent.putExtra(Extra.PRICE, price);
        intent.putExtra(Extra.ITEM_COUNT, 1);
        lc.a.e(this, intent, RequestCode.BEAN_SHOP);
    }

    private void g3() {
        this.H.dismiss();
        v3(R.drawable.ic_hide, R.string.hide_post_connection_title, R.string.hide_post_connection_description, new i0(this));
        H3(true);
    }

    private void h2() {
        ChatReopenView chatReopenView = this.J;
        if (chatReopenView != null) {
            this.F.removeView(chatReopenView);
            this.J = null;
        }
    }

    private void h3() {
        int beanCost = this.f16505t.getBeanCost(1);
        long j10 = (long) beanCost;
        if (j10 <= M0().j().getBeans()) {
            r7.h hVar = new r7.h(getContext());
            this.G = hVar;
            hVar.show();
            E0().j(beanCost, this.f16494h.getId(), new x(this), new y(this));
            return;
        }
        w3(j10, this.f16505t);
    }

    /* access modifiers changed from: private */
    public void i2() {
        if (this.f16509z != null) {
            this.D.setVisibility(8);
            this.f16509z = null;
            this.f16502n.removeFooterView(this.D);
        }
    }

    private void i3() {
        boolean z10;
        Date date = DateUtils.getDate(this.f16494h.getDecouplingDate());
        if (date != null) {
            if (System.currentTimeMillis() > date.getTime()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f16503p = z10;
        }
    }

    private void j3() {
        this.f16502n.smoothScrollToPosition(this.f16497j.getCount());
    }

    private void k2() {
        if (this.f16509z == null) {
            n7.a aVar = new n7.a(requireActivity().getLayoutInflater(), this.f16502n);
            this.f16509z = aVar;
            this.D = aVar.f16645j;
            o3();
        }
    }

    private void k3() {
        String obj = this.f16499k.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            this.f16507x.a();
            F0().k(obj, this.f16494h, this);
            this.f16499k.setText("");
        }
        F0().a(this.f16494h);
    }

    private boolean l2(List<CmbMessage> list) {
        CmbMessage cmbMessage;
        CmbMessage cmbMessage2 = null;
        if (this.f16497j.getCount() == 0) {
            cmbMessage = null;
        } else {
            k kVar = this.f16497j;
            cmbMessage = (CmbMessage) kVar.getItem(kVar.getCount() - 1);
        }
        if (list.size() != 0) {
            cmbMessage2 = list.get(list.size() - 1);
        }
        if (cmbMessage == null || cmbMessage2 == null || cmbMessage2.equals(cmbMessage)) {
            return false;
        }
        return true;
    }

    private void l3() {
        if (s3()) {
            t3();
            this.f16500l.setVisibility(0);
            this.f16499k.setVisibility(0);
            this.f16501m.setVisibility(0);
        } else if (this.f16503p || this.f16494h.isBlocked() || this.f16494h.isPairBlocked()) {
            h2();
            this.f16500l.setVisibility(8);
            this.f16499k.setVisibility(8);
            this.f16501m.setVisibility(8);
        } else {
            h2();
            this.f16500l.setVisibility(0);
            this.f16499k.setVisibility(0);
            this.f16501m.setVisibility(0);
            q5.f.e(this.M);
            this.M.setVisibility(0);
            this.M.setOnClickListener(new e0(this));
            q5.f.e(this.Q);
            this.Q.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2(List list, Optional optional) throws Exception {
        boolean z10;
        if (!optional.d() || !((vb.a) optional.c()).h(BenefitKeys.READ_RECEIPTS)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && list.size() > 0 && this.f16504q != null) {
            CmbMessage cmbMessage = (CmbMessage) list.get(list.size() - 1);
            long timeElapsed = DateUtils.getTimeElapsed(cmbMessage.getDateSent());
            if (cmbMessage.isFromMe(this.f16504q.getId()) && this.f16498j0.a(timeElapsed)) {
                y3();
            }
        }
    }

    private void n3() {
        this.D.measure(0, 0);
        this.C = this.D.getMeasuredHeight();
    }

    private void o3() {
        this.D.setVisibility(0);
        this.f16509z.f16642g.setVisibility(8);
        this.f16509z.f16643h.setVisibility(8);
        this.f16509z.f16644i.setVisibility(4);
        View view = this.f16509z.f16639d;
        view.setVisibility(0);
        this.f16509z.f16640e.setVisibility(0);
        this.f16509z.f16641f.setVisibility(0);
        n3();
        this.D.setTranslationY((float) this.C);
        this.f16502n.addFooterView(this.D);
        C3();
        n7.a aVar = this.f16509z;
        b2(view, aVar.f16640e, aVar.f16641f);
        ImageView imageView = this.f16509z.f16638c;
        c3(imageView, this.f16494h.getProfile());
        imageView.setOnClickListener(new v0(this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean p2(PendingMessage pendingMessage) throws Exception {
        return pendingMessage.getStatus() == MessageStatus.NOT_SENT;
    }

    private void p3(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setTextWatcher(): ");
        sb2.append(str);
        this.f16499k.addTextChangedListener(new c());
        if (!TextUtils.isEmpty(str)) {
            this.f16499k.setText(str);
            this.f16500l.setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q2(List list) throws Exception {
        this.V.g(list);
    }

    private void q3() {
        CmbToolbar T0 = ((j5.h) requireActivity()).T0();
        if (T0 != null) {
            T0.setTitle(this.f16494h.getProfile().getUserFirstName());
            T0.X();
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) requireActivity().getLayoutInflater().inflate(R.layout.overflow_menu_item, T0, false);
            this.T = cmbLinearLayout;
            T0.C(cmbLinearLayout);
            ((p) T0.T().g(com.uber.autodispose.a.a(this))).c(new b0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r2(MessageBase messageBase) {
        int i10;
        if (isAdded() && (messageBase instanceof MessageToSend)) {
            messageBase.setStatus(MessageStatus.NOT_SENT);
            MessageToSend messageToSend = (MessageToSend) messageBase;
            CmbMessage cmbMessage = new CmbMessage(messageToSend);
            cmbMessage.setSenderID(messageToSend.getSenderID());
            if (cmbMessage.getText() != null) {
                i10 = cmbMessage.getText().hashCode();
            } else {
                i10 = cmbMessage.getImageUrl().hashCode();
            }
            if (this.X.get(Integer.valueOf(i10)) == null) {
                this.X.put(Integer.valueOf(i10), cmbMessage);
                this.f16497j.n(cmbMessage);
            } else {
                this.X.get(Integer.valueOf(i10)).setStatus(cmbMessage.getStatus());
                this.f16497j.notifyDataSetChanged();
            }
        }
        this.f16487d0.a(this.f16494h.getId(), this.f16494h.getProfile().getUserFirstName());
    }

    private void r3() {
        tj.b bVar = this.W;
        if ((bVar == null || bVar.c()) && !isRemoving()) {
            this.W = ((p) this.J.B().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new j0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s2(MessageBase messageBase) {
        int i10;
        if (messageBase instanceof MessageToSend) {
            MessageToSend messageToSend = (MessageToSend) messageBase;
            CmbMessage cmbMessage = new CmbMessage(messageToSend);
            cmbMessage.setSenderID(messageToSend.getSenderID());
            if (cmbMessage.getText() != null) {
                i10 = cmbMessage.getText().hashCode();
            } else {
                i10 = cmbMessage.getImageUrl().hashCode();
            }
            if (this.X.get(Integer.valueOf(i10)) == null) {
                cmbMessage.setStatus(MessageStatus.SENDING);
                this.X.put(Integer.valueOf(i10), cmbMessage);
                this.f16497j.n(cmbMessage);
                return;
            }
            this.X.get(Integer.valueOf(i10)).setStatus(MessageStatus.SENDING);
            this.f16497j.notifyDataSetChanged();
        }
    }

    private boolean s3() {
        return this.f16494h.isPastDecouplingDate() && this.f16505t != null && !this.f16494h.isPairBlocked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t2(View view) throws Exception {
        this.f16502n.addHeaderView(view);
    }

    private void t3() {
        boolean equals = NetworkProfile.MALE.equals(this.f16494h.getProfile().getGender());
        if (this.J == null) {
            C0().g("Chat Expired");
            ChatReopenView chatReopenView = (ChatReopenView) getLayoutInflater().inflate(R.layout.chat_reopen_open_dls, this.F, false);
            this.J = chatReopenView;
            if (chatReopenView != null) {
                chatReopenView.setType(ChatReopenPromptType.b(equals));
                r3();
                int generateViewId = View.generateViewId();
                this.J.setId(generateViewId);
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.f((ConstraintLayout) this.F);
                cVar.m(generateViewId, -2);
                cVar.n(generateViewId, 0);
                cVar.h(generateViewId, 4, this.U, 4);
                cVar.h(generateViewId, 6, this.U, 6);
                cVar.h(generateViewId, 7, this.U, 7);
                this.F.addView(this.J);
                cVar.c((ConstraintLayout) this.F);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean u2(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 0 || keyEvent.getAction() != 0) {
            return true;
        }
        k3();
        return true;
    }

    private void u3(CmbToolbar cmbToolbar) {
        if (cmbToolbar != null) {
            cmbToolbar.setSubtitle(getResources().getString(R.string.timer_blank));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v2(View view, boolean z10) {
        if (z10) {
            j2();
        }
    }

    private void v3(int i10, int i11, int i12, Function0<Unit> function0) {
        DialogPrimarySecondaryVertical.f12065a.a(requireContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.DESTRUCTIVE, Integer.valueOf(i10), i11, i12, R.string.continue_lc, function0, Integer.valueOf(R.string.cancel), (Function0<Unit>) null, (Function0<Unit>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w2(View view) {
        j2();
    }

    private void w3(long j10, Price price) {
        b0 b0Var = new b0(getActivity(), R.string.dialog_notenoughbeans_title, R.string.dialog_notenoughbeans_content, R.string.dialog_notenoughbeans_button);
        this.I = b0Var;
        b0 b0Var2 = b0Var;
        b0Var.b(new h0(this, price));
        this.I.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x2(View view) {
        k3();
    }

    private void x3(int i10) {
        if (getActivity() != null) {
            View findViewById = getActivity().getWindow().getDecorView().findViewById(16908290);
            if (isAdded()) {
                sb.a.i(findViewById, i10);
            } else {
                fa.a.g("ChatFragment", "Fragment is not attached to an activity", new IllegalStateException("Fragment is not attached to an activity"));
            }
        } else {
            fa.a.g("ChatFragment", "Activity is null", new NullPointerException("Activity is null"));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit y2() {
        h3();
        return null;
    }

    private void y3() {
        ((p) q.t0(1500, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new x0(this));
        this.f16498j0.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z2(ChatState chatState) throws Exception {
        this.f16507x.h(chatState == ChatState.composing);
    }

    private void z3() {
        try {
            lc.a.e(this, new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), RequestCode.PICK_PHOTO_GALLERY_CHAT);
        } catch (ActivityNotFoundException unused) {
            x3(R.string.error_no_picker_intent);
        }
    }

    public void A() {
        if (isAdded()) {
            ((ChatActivity) requireActivity()).O1();
        }
    }

    public void G() {
        this.R.setVisibility(0);
        this.N.setVisibility(8);
    }

    public void I() {
        j2();
        w0();
    }

    public void J(List<CmbMessage> list, CmbMessage cmbMessage) {
        boolean z10;
        boolean b32 = b3(this.f16502n);
        boolean a10 = this.f16483a0.a();
        if (b32 || !a10) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (l2(list) && !z10) {
            x3(R.string.chat_message_received);
        }
        ((t) this.f16491f0.a().L().g(com.uber.autodispose.a.a(this))).b(new r0(this, list), new s0());
        this.f16497j.I(list, cmbMessage);
        this.f16497j.notifyDataSetChanged();
        this.f16485c0.d(this.f16494h.getProfileId());
        if (z10) {
            j3();
            return;
        }
        int e22 = e2(list);
        this.f16502n.setSelection(e22);
        this.f16502n.smoothScrollToPosition(e22);
    }

    public void N(List<StickerNetwork> list) {
        this.O.setVisibility(0);
        this.R.setVisibility(8);
        this.N.setVisibility(0);
        if (this.P == null) {
            m7.a aVar = new m7.a(list, getContext());
            this.P = aVar;
            this.N.setAdapter(aVar);
            this.N.setOnItemClickListener(new p0(this));
        }
    }

    public void O() {
        Intent intent = new Intent(getActivity(), BagelProfileComponentActivity.class);
        intent.putExtra(Extra.BAGEL, this.f16494h);
        intent.putExtra("source", ModelDeeplinkData.VALUE_PAGE_CHAT);
        startActivityForResult(intent, RequestCode.GENERIC);
    }

    public void W() {
        lc.c.h(this.G);
    }

    public void X() {
        B3();
    }

    public void Y(int i10) {
        lc.c.h(this.G);
        x3(i10);
    }

    public void c0() {
        lc.c.h(this.G);
        Y(R.string.media_upload_error);
    }

    public void e0(CmbMessage cmbMessage) {
        this.f16507x.a();
        F0().d(cmbMessage.getText(), this.f16494h, this, cmbMessage.getPendingMessageId());
    }

    public void h0(String str) {
        this.X.clear();
        c2();
    }

    public void j2() {
        this.O.setVisibility(8);
    }

    public void k0() {
        k2();
    }

    public void l() {
        this.f16507x.l();
    }

    public void l0(List<CmbMessage> list) {
        this.f16497j.F();
        for (CmbMessage next : list) {
            this.X.put(Integer.valueOf(next.getText().hashCode()), next);
            this.f16497j.n(next);
        }
    }

    public void m3(View view) {
        this.Z.d(view);
    }

    public void n0(EventType eventType, Bundle bundle) {
        int i10 = h.f16521a[eventType.ordinal()];
        if (i10 == 1) {
            if (this.f16494h.getId().equals(bundle.getString(Extra.BAGEL_ID))) {
                i3();
                l3();
            }
        } else if (i10 == 2) {
            E0().s();
        }
    }

    public void o(MessageBase messageBase) {
        this.F.post(new t0(this, messageBase));
    }

    public void o0() {
        Bagel D2;
        if (this.f16494h != null && (D2 = E0().D(this.f16494h.getCoupleId())) != null) {
            this.f16494h = D2;
            new ArrayList().add(this.f16494h);
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        if (i10 != 5400) {
            if (i10 == 9279 || i10 == 9304) {
                if (i11 == 50) {
                    requireActivity().finish();
                }
            } else if (i10 != 9285) {
                if (i10 == 9286) {
                    if (i11 == -1) {
                        if (this.G == null) {
                            this.G = new r7.h(getContext());
                        }
                        this.G.show();
                        this.f16507x.d(this);
                        this.f16507x.b(intent);
                    } else if (i11 == 0) {
                        z3();
                    } else if (i11 == 53) {
                        Y(R.string.image_too_large_error);
                    }
                }
            } else if (i11 == -1) {
                Intent intent2 = new Intent(getActivity(), FullscreenPhotoActivity.class);
                if (intent.getData() == null) {
                    str = "";
                } else {
                    str = intent.getData().toString();
                }
                intent2.putExtra(Extra.IMAGE_URI, str);
                startActivityForResult(intent2, RequestCode.PICK_PHOTO_CONFIRMATION);
            }
        } else if (i11 == -1) {
            h3();
        }
    }

    public void onAttach(Context context) {
        Bakery.j().q1(this);
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        this.K = cVar;
        cVar.e(requireContext(), R.layout.chat_reopen_open_dls);
        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
        this.L = cVar2;
        cVar2.e(requireContext(), R.layout.chat_reopen_closed_dls);
        this.X = new HashMap();
        if (bundle != null) {
            if (M0().j() == null && getActivity() != null) {
                getActivity().finish();
            }
            if (bundle.containsKey(Extra.BAGEL)) {
                this.f16494h = (Bagel) bundle.getSerializable(Extra.BAGEL);
            }
            if (bundle.containsKey("profile")) {
                this.f16504q = (NetworkProfile) bundle.getSerializable("profile");
            }
        } else if (getArguments() != null) {
            this.f16494h = (Bagel) getArguments().getSerializable(Extra.BAGEL);
            this.f16504q = M0().j();
        } else {
            throw new IllegalArgumentException("Bagel and its connection details cannot be null on connection chat screen");
        }
        Bagel bagel = this.f16494h;
        if (bagel == null || bagel.getDecouplingDate() == null || this.f16494h.getCoupleId() == null) {
            throw new IllegalArgumentException("Bagel and its connection details cannot be null on connection chat screen");
        }
        this.E = new r7.i(new a());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bagel=");
        sb2.append(this.f16494h);
        sb2.append(", mProfile=");
        sb2.append(this.f16504q);
        String coupleId = this.f16494h.getCoupleId();
        i3();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("coupleId=");
        sb3.append(coupleId);
        Bakery.w().z().f("Chat");
        E0().r(this);
        h5.i.a(this, EventType.CHAT_EXTENDED_PUSH, EventType.CONNECTION_DETAILS_UPDATED);
        ((p) N0().priceCache().g(com.uber.autodispose.a.a(this))).c(new b());
        this.f16507x = new n1(getActivity(), this, new j8.a(), F0(), this.f16494h, L0(), this.f16496i0);
        a0 a0Var = new a0(this, this.f16485c0, this.f16484b0, D0().getProfileId(), this.f16494h.getProfileId());
        this.V = a0Var;
        a0Var.start();
        this.B = new HashMap<>();
        F0().b();
        this.f16485c0.b(this.f16495h0);
    }

    @SuppressLint({"AutoDispose"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_conversation_dls, viewGroup, false);
        this.F = viewGroup2;
        this.U = viewGroup2.findViewById(R.id.conversation_layout).getId();
        this.f16499k = (EditText) this.F.findViewById(R.id.messageInput);
        ListView listView = (ListView) this.F.findViewById(R.id.listView_messages);
        this.f16502n = listView;
        listView.setTranscriptMode(1);
        this.Y.a(this.Z.c(new r(this)));
        this.f16501m = this.F.findViewById(R.id.divider);
        this.N = (GridView) this.F.findViewById(R.id.stickers_grid);
        this.O = (RelativeLayout) this.F.findViewById(R.id.stickers_grid_container);
        this.Q = (ImageView) this.F.findViewById(R.id.upload_sticker_button);
        this.R = (TextView) this.F.findViewById(R.id.no_stickers_text_view);
        this.f16499k.setOnEditorActionListener(new c0(this));
        this.f16499k.setOnFocusChangeListener(new n0(this));
        this.f16499k.setOnClickListener(new y0(this));
        ImageView imageView = (ImageView) this.F.findViewById(R.id.sendButton);
        this.f16500l = imageView;
        imageView.setOnClickListener(new b1(this));
        this.f16500l.setEnabled(false);
        this.M = (ImageView) this.F.findViewById(R.id.upload_image_button);
        this.f16502n.setOnScrollListener(this.f16483a0);
        p3(F0().c(this.f16494h));
        return this.F;
    }

    public void onDestroy() {
        super.onDestroy();
        h5.i.d(this, EventType.CHAT_EXTENDED_PUSH, EventType.CONNECTION_DETAILS_UPDATED);
        E0().F(this);
        this.S = null;
        this.V.stop();
        tj.b bVar = this.W;
        if (bVar != null) {
            bVar.dispose();
        }
        this.W = null;
        this.Y.dispose();
    }

    public void onDestroyView() {
        super.onDestroyView();
        lc.c.h(this.G);
        lc.c.h(this.H);
        lc.c.h(this.I);
    }

    public void onPause() {
        super.onPause();
        CountDownTimer countDownTimer = this.f16508y;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f16507x.a();
        F0().g(this.f16494h, this.f16499k.getText());
        F0().f();
    }

    public void onResume() {
        super.onResume();
        F0().l(this.f16494h);
        l3();
        this.f16507x.start();
        this.f16507x.d(this);
        ((p) this.f16484b0.s(this.f16494h.getProfileId()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new t(this), new u());
        ((p) q.m(this.f16489e0.a(this.f16494h.getProfileId()), this.f16484b0.W(this.f16494h.getProfileId()), new oc.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(oc.b.b(new v(this)), new w());
        this.V.m();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(Extra.BAGEL, this.f16494h);
        bundle.putSerializable("profile", this.f16504q);
    }

    public void onStart() {
        super.onStart();
        CmbToolbar T0 = ((j5.h) requireActivity()).T0();
        if (T0 != null) {
            ((p) T0.T().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new c1(this));
            CmbLinearLayout cmbLinearLayout = this.T;
            if (cmbLinearLayout != null) {
                ((p) cmbLinearLayout.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new d1(this));
            }
        }
        F3();
        Bakery.w().A().z(this);
    }

    public void onStop() {
        super.onStop();
        Bakery.w().A().P(this);
        this.f16507x.stop();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f16494h == null) {
            return;
        }
        if (M0().j() != null) {
            q3();
            k kVar = new k(getActivity(), com.coffeemeetsbagel.image_loader.b.f13967a, this.f16494h, D0().getProfileId(), this.f16494h.getProfileId(), this, this);
            this.f16497j = kVar;
            this.f16502n.setAdapter(kVar);
            if (this.f16497j.getCount() > 0) {
                this.f16502n.post(new e1(this));
            }
            ((t) this.f16493g0.a(ResourceType.UNSUPPORTED_CHAT_MESSAGE_PLACEHOLDERS).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new f1(this), new g1());
            ((n) this.f16491f0.a().g(com.uber.autodispose.a.a(this))).c(new s(this));
            return;
        }
        fa.a.i(new IllegalStateException("Couldn't set adapter for messages due to profile null in ChatFragment, isAdded=" + isAdded()));
    }

    public void r() {
        this.Q.setOnClickListener(new f0(this));
    }

    public void s0() {
        j2();
    }

    public void u(MessageBase messageBase) {
        this.F.post(new z0(this, messageBase));
    }

    public void u0(Bagel bagel) {
        this.f16507x.e(bagel);
    }

    public void v(MessageBase messageBase) {
        o(messageBase);
    }

    public void w(String str) {
        Intent intent = new Intent(getActivity(), FullscreenPhotoActivity.class);
        intent.putExtra("image_url", str);
        startActivity(intent);
    }

    public void w0() {
        lc.c.h(this.G);
        Y(R.string.media_upload_error);
    }
}
