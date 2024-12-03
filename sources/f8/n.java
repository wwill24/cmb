package f8;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.DialogMultiButtonDls;
import com.coffeemeetsbagel.feature.instagram.login.InstagramLoginActivity;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.my_profile.DeleteMyPhotoUseCase;
import com.coffeemeetsbagel.my_profile.GetMyPhotosUseCase;
import com.coffeemeetsbagel.my_profile.d;
import com.coffeemeetsbagel.my_profile.j;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.util.RequestCode;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.uber.autodispose.p;
import h5.i;
import j5.x;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import r7.h;
import t8.o;
import z9.f;
import z9.m;

public class n extends j5.n implements f, m, t8.n {
    private boolean B;
    private Integer C;
    private String D;
    private t8.m E = new o(L0(), this);
    private AlphaAnimation F;
    private AlphaAnimation G;
    private AlphaAnimation H;
    private AlphaAnimation I;
    private tj.a J;
    private boolean K = false;

    /* renamed from: k  reason: collision with root package name */
    GetMyPhotosUseCase f14921k;

    /* renamed from: l  reason: collision with root package name */
    DeleteMyPhotoUseCase f14922l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public List<Photo> f14923m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private boolean f14924n;

    /* renamed from: p  reason: collision with root package name */
    private boolean[] f14925p = new boolean[9];

    /* renamed from: q  reason: collision with root package name */
    private RecyclerView f14926q;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public DialogMultiButtonDls f14927t;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public h f14928w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public j f14929x;

    /* renamed from: y  reason: collision with root package name */
    private Photo f14930y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public RelativeLayout f14931z;

    class a extends GridLayoutManager.c {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f14932e;

        a(GridLayoutManager gridLayoutManager) {
            this.f14932e = gridLayoutManager;
        }

        public int f(int i10) {
            if (n.this.f14929x.K(i10)) {
                return this.f14932e.W2();
            }
            return 1;
        }
    }

    class b implements jc.b<Integer> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            if (n.this.getActivity() != null) {
                sb.a.i(n.this.f14931z, R.string.error_photo_delete);
            }
            lc.c.h(n.this.f14928w);
            lc.c.h(n.this.f14927t);
        }

        /* renamed from: c */
        public void a(Integer num, SuccessStatus successStatus) {
            int size = n.this.f14923m.size();
            n nVar = n.this;
            nVar.l1(nVar.f14923m, num.intValue());
            n.this.f14922l.c(num.intValue()).l();
            if (num.intValue() == 0) {
                n.this.f14929x.l();
            } else {
                n.this.f14929x.t(num.intValue());
                n.this.f14929x.p(num.intValue(), size - (num.intValue() + 1));
            }
            i.b(EventType.PROFILE_SAVED);
            lc.c.h(n.this.f14928w);
            lc.c.h(n.this.f14927t);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14935a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14935a = r0
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_PRE_UPLOAD_DONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_DOWNLOAD_OPERATION_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_DOWNLOAD_OPERATION_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_UPLOADING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_UPLOAD_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f14935a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.PHOTO_UPLOAD_ERROR     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f8.n.c.<clinit>():void");
        }
    }

    public static n A1(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_onboarding", z10);
        n nVar = new n();
        nVar.setArguments(bundle);
        return nVar;
    }

    public static n B1() {
        return A1(true);
    }

    private void G1(int i10) {
        if (isAdded()) {
            M0().f();
        }
    }

    private void H1() {
        if (Build.VERSION.SDK_INT >= 33) {
            requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, 1);
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void I1() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        this.f14926q.setLayoutManager(gridLayoutManager);
        this.f14926q.setAdapter(this.f14929x);
        gridLayoutManager.e3(new a(gridLayoutManager));
        new l(new d(this.f14929x)).m(this.f14926q);
    }

    private void J1(boolean z10, int i10, String str) {
        int i11;
        if (z10) {
            i11 = 4;
        } else {
            i11 = 3;
        }
        ArrayList arrayList = new ArrayList(i11);
        DialogMultiButtonDls.Button.Type type = DialogMultiButtonDls.Button.Type.SECONDARY;
        DialogMultiButtonDls.Button button = new DialogMultiButtonDls.Button(type, getString(R.string.choose_from_facebook_dls), 8388611);
        DialogMultiButtonDls.Button button2 = new DialogMultiButtonDls.Button(type, getString(R.string.choose_from_gallery_dls), 8388611);
        DialogMultiButtonDls.Button button3 = new DialogMultiButtonDls.Button(DialogMultiButtonDls.Button.Type.DESTRUCTIVE_SECONDARY, getString(R.string.delete_it_dls), 8388611);
        arrayList.add(button);
        arrayList.add(button2);
        if (z10) {
            arrayList.add(button3);
        }
        DialogMultiButtonDls dialogMultiButtonDls = new DialogMultiButtonDls(requireContext(), getString(R.string.upload_your_photo), (String) null, (List<DialogMultiButtonDls.Button>) arrayList);
        this.f14927t = dialogMultiButtonDls;
        dialogMultiButtonDls.show();
        if (this.f14927t.getWindow() != null) {
            this.f14927t.getWindow().setLayout(-1, -2);
        }
        this.J.a(((p) this.f14927t.a(button).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(this, i10, str)));
        this.J.a(((p) this.f14927t.a(button2).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l(this, i10, str)));
        if (z10) {
            this.J.a(((p) this.f14927t.a(button3).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new m(this, i10)));
        }
    }

    private void K1(String str, DialogInterface.OnClickListener onClickListener) {
        new b.a(requireContext()).f(str).i(getString(R.string.ok_short_caps), onClickListener).g(getString(R.string.cancel_caps), (DialogInterface.OnClickListener) null).a().show();
    }

    private void M1(int i10) {
        if (isAdded() && this.f14926q.getChildAt(i10) != null) {
            new Handler(Looper.getMainLooper()).post(new j((ShimmerFrameLayout) this.f14926q.getChildAt(i10).findViewById(R.id.shimmer_holder)));
        }
    }

    private void k1(String str) {
        if (str == null) {
            fa.a.i(new IllegalStateException("profile ID is null"));
        }
    }

    /* access modifiers changed from: private */
    public void l1(List<Photo> list, int i10) {
        this.E.i(i10);
        if (list.size() > i10 + 1) {
            int size = (list.size() - i10) - 1;
            for (int i11 = 0; i11 < size; i11++) {
                int i12 = i10 + i11;
                new File(this.E.a(i12 + 1)).renameTo(new File(this.E.a(i12)));
            }
        }
    }

    private void m1(int i10) {
        if (!this.f14925p[i10]) {
            boolean z10 = false;
            if (i10 < this.f14923m.size()) {
                String c10 = this.f14923m.get(i10).c();
                this.D = c10;
                if (!(i10 == 0 && this.f14923m.size() == 1)) {
                    z10 = true;
                }
                J1(z10, i10, c10);
                this.f14930y = this.f14923m.get(i10);
                return;
            }
            this.D = null;
            int i11 = -1;
            int i12 = 0;
            while (true) {
                boolean[] zArr = this.f14925p;
                if (i12 < zArr.length) {
                    if (zArr[i12]) {
                        i11 = i12;
                    }
                    i12++;
                } else {
                    Integer valueOf = Integer.valueOf(Math.max(this.f14923m.size(), i11 + 1));
                    this.C = valueOf;
                    J1(false, valueOf.intValue(), (String) null);
                    return;
                }
            }
        } else {
            sb.a.k(this.f14931z, R.string.please_wait);
        }
    }

    private void n1(int i10) {
        this.f14925p[i10] = false;
        this.f14930y = null;
    }

    private void o1(Bundle bundle) {
        int i10 = bundle.getInt(Extra.PHOTO_INDEX);
        if (getActivity() != null) {
            sb.a.i(this.f14931z, R.string.error_photo_upload);
        }
        Photo photo = this.f14930y;
        if (photo != null) {
            k1(photo.e());
            Bakery.w().G().c(new NetworkPhoto(this.f14930y.d(), this.f14930y.getUrl(), this.f14930y.c(), this.f14930y.e(), this.f14930y.a()));
        }
        lc.o.b(this.E.a(i10));
        G1(i10);
    }

    private void p1(Bundle bundle) {
        String string = bundle.getString(Extra.PHOTO_ID);
        String string2 = bundle.getString(Extra.IMAGE_URI);
        String string3 = bundle.getString("caption");
        int i10 = bundle.getInt(Extra.PHOTO_INDEX);
        String profileId = Bakery.w().g().getProfileId();
        k1(profileId);
        Bakery.w().G().c(new NetworkPhoto(i10, string2, string, profileId, string3));
        G1(i10);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(Extra.WAS_PROFILED_EDITED, true);
        i.c(EventType.PROFILE_SAVED, bundle2);
    }

    private boolean q1() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (requireActivity().checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0) {
                return true;
            }
            return false;
        } else if (requireActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void r1() {
        if (this.F == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.F = alphaAnimation;
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            this.F.setDuration(1300);
        }
        if (this.G == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.G = alphaAnimation2;
            alphaAnimation2.setInterpolator(new AccelerateInterpolator());
            this.F.setDuration(1300);
        }
        if (this.H == null) {
            AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
            this.H = alphaAnimation3;
            alphaAnimation3.setInterpolator(new DecelerateInterpolator());
            this.F.setDuration(1300);
        }
        if (this.I == null) {
            AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation4;
            alphaAnimation4.setInterpolator(new AccelerateInterpolator());
            this.F.setDuration(1300);
        }
    }

    public static boolean s1() {
        NetworkProfile j10 = Bakery.w().G().j();
        boolean a10 = Bakery.w().l().a("has_seen_like_flow");
        boolean a11 = Bakery.w().l().a("has_seen_pass_flow");
        if (j10.isMissingAllPhotos() || (!a10 && !a11)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t1(List list) throws Exception {
        this.f14929x.T(list);
        this.f14923m = list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", requireActivity().getApplicationContext().getPackageName(), (String) null));
        intent.addFlags(268435456);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1() {
        z9.h hVar = this.f15615d;
        if (hVar != null) {
            hVar.X(b0(false), this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(int i10, String str, x xVar) throws Exception {
        C1(i10, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(int i10, String str, x xVar) throws Exception {
        D1(i10, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(int i10, x xVar) throws Exception {
        F1(i10);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z1(ShimmerFrameLayout shimmerFrameLayout) {
        if (shimmerFrameLayout != null && shimmerFrameLayout.isShimmerStarted()) {
            shimmerFrameLayout.setShimmer(((Shimmer.AlphaHighlightBuilder) ((Shimmer.AlphaHighlightBuilder) new Shimmer.AlphaHighlightBuilder().setBaseAlpha(1.0f)).setIntensity(0.0f)).build());
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.clearAnimation();
        }
    }

    public void C1(int i10, String str) {
        lc.c.h(this.f14927t);
        this.E.g(getActivity(), i10, true, str, this.E.d(), this.f14931z);
    }

    public void D1(int i10, String str) {
        if (!q1()) {
            H1();
        } else if (!this.B) {
            this.B = true;
            this.E.j(getActivity(), i10, str);
        }
    }

    public void E1(int i10, String str) {
        lc.c.h(this.f14927t);
        if (I0().isLoggedIn()) {
            this.E.c(getActivity(), i10, true, str, this.E.d());
            return;
        }
        startActivityForResult(new Intent(getActivity(), InstagramLoginActivity.class), RequestCode.LOGIN_INSTAGRAM);
    }

    public void F1(int i10) {
        lc.c.h(this.f14927t);
        if (i10 < this.f14923m.size()) {
            h hVar = new h(getActivity());
            this.f14928w = hVar;
            hVar.show();
            this.E.b(new b(), this.f14923m.get(i10).c(), i10);
        }
    }

    public void L1() {
        if (this.f14924n && !this.K) {
            sb.a.i(this.f14931z, R.string.onboarding_upload_photos);
            this.K = true;
        }
    }

    public void M(int i10) {
        if (i10 >= 0) {
            this.C = Integer.valueOf(i10);
            m1(i10);
        }
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Upload Photos";
    }

    public void V0() {
        C0().f("Onboarding - Upload Photos");
    }

    public boolean b0(boolean z10) {
        if (!CollectionUtils.isEmpty((List) this.f14923m)) {
            return true;
        }
        if (!z10) {
            return false;
        }
        sb.a.i(this.f14931z, R.string.error_not_enough_photos);
        return false;
    }

    public void d0() {
        lc.c.h(this.f14928w);
        lc.c.h(this.f14927t);
    }

    public void n0(EventType eventType, Bundle bundle) {
        switch (c.f14935a[eventType.ordinal()]) {
            case 1:
                lc.c.h(this.f14927t);
                h hVar = new h(getActivity());
                this.f14928w = hVar;
                hVar.show();
                return;
            case 2:
                int i10 = bundle.getInt(Extra.PHOTO_INDEX);
                boolean[] zArr = this.f14925p;
                if (i10 <= zArr.length - 1) {
                    zArr[i10] = true;
                    return;
                }
                return;
            case 3:
            case 4:
                lc.c.h(this.f14928w);
                lc.c.h(this.f14927t);
                return;
            case 5:
                lc.c.h(this.f14928w);
                lc.c.h(this.f14927t);
                int i11 = bundle.getInt(Extra.PHOTO_INDEX);
                boolean[] zArr2 = this.f14925p;
                if (i11 <= zArr2.length - 1) {
                    zArr2[i11] = true;
                    return;
                }
                return;
            case 6:
                int i12 = bundle.getInt(Extra.PHOTO_INDEX);
                M1(i12);
                p1(bundle);
                n1(i12);
                return;
            case 7:
                int i13 = bundle.getInt(Extra.PHOTO_INDEX);
                M1(i13);
                o1(bundle);
                n1(i13);
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        lc.c.h(this.f14928w);
        h5.l.h().onActivityResult(i10, i11, intent);
        if (i10 == 9282 && i11 == -1) {
            E1(this.C.intValue(), this.D);
        }
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().k1(this);
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f14924n = arguments.getBoolean("is_onboarding", false);
        }
        if (bundle != null) {
            this.D = bundle.getString("selected_photo");
            this.C = Integer.valueOf(bundle.getInt("selected_photo_index"));
        }
        if (Bakery.w().M().hasProperty("key_temp_photo")) {
            this.f14930y = (Photo) new com.google.gson.d().k(Bakery.w().M().r("key_temp_photo"), Photo.class);
        }
        i.a(this, EventType.PHOTO_PRE_UPLOAD_DONE, EventType.PHOTO_UPLOAD_ERROR, EventType.PHOTO_UPLOAD_SUCCESS, EventType.PHOTO_UPLOADING, EventType.PHOTO_DOWNLOADING, EventType.PHOTO_DOWNLOAD_OPERATION_COMPLETE, EventType.PHOTO_DOWNLOAD_OPERATION_FAILED);
        r1();
        this.f14929x = new j(requireContext(), this.f14923m, 9, this, this.E);
        ((com.uber.autodispose.n) this.f14921k.c().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new h(this));
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_photos_dls, viewGroup, false);
        this.f14931z = (RelativeLayout) inflate.findViewById(R.id.relativeLayout_container);
        if (this.f14924n) {
            inflate.findViewById(R.id.textView_title).setVisibility(0);
        } else {
            inflate.findViewById(R.id.textView_title).setVisibility(8);
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        i.d(this, EventType.PHOTO_PRE_UPLOAD_DONE, EventType.PHOTO_UPLOAD_ERROR, EventType.PHOTO_UPLOAD_SUCCESS, EventType.PHOTO_UPLOADING, EventType.PHOTO_DOWNLOADING, EventType.PHOTO_DOWNLOAD_OPERATION_COMPLETE, EventType.PHOTO_DOWNLOAD_OPERATION_FAILED);
    }

    public void onPause() {
        super.onPause();
        if (this.f14930y != null) {
            Bakery.w().M().w("key_temp_photo", new com.google.gson.d().u(this.f14930y));
        }
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.B = true;
                this.E.j(getActivity(), this.C.intValue(), this.D);
            } else if (iArr.length <= 0 || iArr[0] != -1) {
                lc.c.h(this.f14927t);
                sb.a.g(getView(), R.string.write_permission_denied);
            } else if (!shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                K1(getString(R.string.allow_access_to_gallery), new i(this));
            } else {
                lc.c.h(this.f14927t);
                sb.a.g(getView(), R.string.write_permission_denied);
            }
        }
    }

    public void onResume() {
        super.onResume();
        this.B = false;
        Bakery.w().z().f("My Profile - Edit Photos");
    }

    public void onSaveInstanceState(Bundle bundle) {
        Integer num = this.C;
        if (num != null) {
            bundle.putInt("selected_photo_index", num.intValue());
        }
        String str = this.D;
        if (str != null) {
            bundle.putString("selected_photo", str);
        }
        super.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.J = new tj.a();
    }

    public void onStop() {
        super.onStop();
        this.J.dispose();
        lc.c.h(this.f14927t);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f14926q = (RecyclerView) view.findViewById(R.id.my_photos_grid);
        I1();
        if (this.f14924n) {
            new Handler().post(new g(this));
        }
    }

    public void y0() {
        h hVar = new h(getActivity());
        this.f14928w = hVar;
        hVar.show();
    }
}
