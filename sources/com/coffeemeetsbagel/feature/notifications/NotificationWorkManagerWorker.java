package com.coffeemeetsbagel.feature.notifications;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.app.j0;
import androidx.core.app.p;
import androidx.core.app.q0;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityLogin;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.bakery.ManagerNotifications;
import com.coffeemeetsbagel.bakery.h1;
import com.coffeemeetsbagel.chat.details.ChatActivity;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.feature.mongoose.sync.MongooseSyncJobService;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.match.j;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.NotificationType;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.GetProfileAvatarUseCase;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.facebook.internal.ServerProtocol;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import kotlin.Unit;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.json.JSONException;
import r8.e;
import r8.f;
import r8.g;

public class NotificationWorkManagerWorker extends Worker {

    /* renamed from: p  reason: collision with root package name */
    private static String f13112p;

    /* renamed from: q  reason: collision with root package name */
    private static String f13113q;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Context f13114f;

    /* renamed from: g  reason: collision with root package name */
    FirebaseContract.Analytics f13115g;

    /* renamed from: h  reason: collision with root package name */
    t f13116h;

    /* renamed from: j  reason: collision with root package name */
    GetProfileAvatarUseCase f13117j;

    /* renamed from: k  reason: collision with root package name */
    private PendingIntent f13118k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13119l;

    /* renamed from: m  reason: collision with root package name */
    private p.e f13120m;

    /* renamed from: n  reason: collision with root package name */
    private Bitmap f13121n;

    class a implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13122a;

        a(String str) {
            this.f13122a = str;
        }

        public void a(Bagel bagel) {
            Bundle bundle = new Bundle();
            bundle.putString(Extra.BAGEL_ID, this.f13122a);
            Bakery.w().q().b(EventType.CHAT_EXTENDED_PUSH, bundle);
        }

        public void onError(String str) {
        }
    }

    class b implements jc.b<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NotificationType f13124a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13125b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f13126c;

        b(NotificationType notificationType, String str, Map map) {
            this.f13124a = notificationType;
            this.f13125b = str;
            this.f13126c = map;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("NotificationWorkManagerWorker", "Failed to sync on Expedited Batch");
            fa.a.i(new Exception("Failed to sync on Campaign Expedited Batch"));
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            NotificationWorkManagerWorker notificationWorkManagerWorker = NotificationWorkManagerWorker.this;
            notificationWorkManagerWorker.G(notificationWorkManagerWorker.f13114f, NotificationWorkManagerWorker.this.g(), this.f13124a, this.f13125b, this.f13126c);
        }
    }

    class c implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f13128a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NotificationType f13129b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13130c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f13131d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f13132e;

        c(Map map, NotificationType notificationType, String str, String str2, Context context) {
            this.f13128a = map;
            this.f13129b = notificationType;
            this.f13130c = str;
            this.f13131d = str2;
            this.f13132e = context;
        }

        public void a(Bagel bagel) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("#push successfully got bagel=");
            sb2.append(bagel);
            String profileId = Bakery.w().g().getProfileId();
            if (bagel.getProfile().getId().equals(profileId)) {
                fa.a.i(new Exception("#notification got own profile as bagel for bagel " + bagel.getId() + " with own profile " + profileId));
            }
            if (TextUtils.isEmpty(bagel.getCoupleId()) || TextUtils.isEmpty(bagel.getDecouplingDate())) {
                fa.a.f("NotificationWorkManagerWorker", "#push notification: invalid bagel conn data=" + bagel);
                fa.a.i(new IllegalStateException("Invalid bagel connection details during notification after server fetch"));
            }
            this.f13128a.put(Extra.BAGEL_ID, bagel.getId());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("\tNotificationType: ");
            sb3.append(this.f13129b);
            NotificationType notificationType = this.f13129b;
            if (notificationType == NotificationType.CHAT || notificationType == NotificationType.ICE_BREAKER) {
                MongooseSyncJobService.E(NotificationWorkManagerWorker.this.a(), Collections.singletonList(lc.t.g(bagel.getProfileId())), true);
            }
            NotificationWorkManagerWorker notificationWorkManagerWorker = NotificationWorkManagerWorker.this;
            notificationWorkManagerWorker.B(this.f13130c, this.f13131d, this.f13129b, this.f13128a, this.f13132e, notificationWorkManagerWorker.E(), bagel);
        }

        public void onError(String str) {
            fa.a.f("NotificationWorkManagerWorker", "#push http GET bagel failed: " + str);
            fa.a.i(new IllegalStateException("Could not fetch bagel from server during push with bagel id"));
            NotificationWorkManagerWorker notificationWorkManagerWorker = NotificationWorkManagerWorker.this;
            notificationWorkManagerWorker.B(this.f13130c, this.f13131d, this.f13129b, this.f13128a, this.f13132e, notificationWorkManagerWorker.E(), (Bagel) null);
        }
    }

    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13134a;

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
                com.coffeemeetsbagel.models.enums.NotificationType[] r0 = com.coffeemeetsbagel.models.enums.NotificationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13134a = r0
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.CHAT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.EXPEDITED_BATCH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.STICKER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.EXPIRATION     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.ICE_BREAKER     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f13134a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.coffeemeetsbagel.models.enums.NotificationType r1 = com.coffeemeetsbagel.models.enums.NotificationType.GENERAL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker.d.<clinit>():void");
        }
    }

    public NotificationWorkManagerWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f13114f = context;
        Bakery.j().z1(this);
    }

    private void A(String str, String str2, String str3, NotificationType notificationType, Bagel bagel, Intent intent, Intent intent2, Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("w", Integer.toString(190));
        hashMap.put("h", Integer.toString(190));
        String str4 = str2;
        String str5 = str3;
        NotificationType notificationType2 = notificationType;
        Bagel bagel2 = bagel;
        Context context2 = context;
        Intent intent3 = intent;
        Intent intent4 = intent2;
        com.coffeemeetsbagel.image_loader.b.f13967a.b(context, str, (ImageView) null, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), new f(this, str4, str5, notificationType2, bagel2, context2, intent3, intent4), new g(this, str4, str5, notificationType2, bagel2, context2, intent3, intent4), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void B(String str, String str2, NotificationType notificationType, Map<String, String> map, Context context, Intent intent, Bagel bagel) {
        NotificationType notificationType2 = notificationType;
        Map<String, String> map2 = map;
        Context context2 = context;
        Intent intent2 = intent;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("message=");
        sb2.append(str2);
        sb2.append(", notificationType=");
        sb2.append(notificationType2);
        if (TextUtils.isEmpty(str2)) {
            V("Empty Message", g());
            return;
        }
        Intent intent3 = new Intent(context2, ActivityLogin.class);
        intent3.setFlags(32768);
        intent3.putExtras(intent2);
        boolean z10 = true;
        intent3.putExtra(Extra.IS_FROM_PUSH, true);
        this.f13118k = PendingIntent.getActivity(context2, 0, intent3, 1140850688);
        if (map2.containsKey(Extra.BAGEL_ID) && this.f13119l) {
            String str3 = map2.get(Extra.BAGEL_ID);
            if (bagel == null) {
                V("Null Profile", g());
            } else if (Bakery.w().A().E(str3)) {
                V("Currently In Chat", g());
                return;
            } else if (bagel.isBlocked()) {
                V("Bagel Blocked", g());
                return;
            } else {
                O(str3, context2, intent2);
            }
        }
        if (notificationType2 == NotificationType.VIDEO_FEED) {
            Q(context2, intent2);
        }
        if ("limelight_nonsubscriber_likes_you".equals(intent3.getStringExtra("campaign")) || "limelight_subscriber_likes_you".equals(intent3.getStringExtra("campaign"))) {
            P(context2, intent2);
            if ("limelight_subscriber_likes_you".equals(intent3.getStringExtra("campaign"))) {
                Bakery.w().U().a().f(new r8.d(), new e());
            } else {
                return;
            }
        }
        String str4 = "all_pushes";
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager f10 = ManagerNotifications.f();
            String stringExtra = intent2.getStringExtra(Extra.CHANNEL_ID);
            if (stringExtra != null) {
                str4 = stringExtra;
            }
            String stringExtra2 = intent2.getStringExtra(Extra.CHANNEL_NAME);
            if (stringExtra2 == null) {
                stringExtra2 = "All Pushes";
            }
            String stringExtra3 = intent2.getStringExtra(Extra.CHANNEL_PRIORITY);
            if (stringExtra3 == null) {
                stringExtra3 = "medium";
            }
            String stringExtra4 = intent2.getStringExtra(Extra.CHANNEL_DESCRIPTION);
            if (f10.getNotificationChannel(str4) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(str4, stringExtra2, D(stringExtra3));
                if (stringExtra4 != null) {
                    notificationChannel.setDescription(stringExtra4);
                }
                f10.createNotificationChannel(notificationChannel);
            }
            this.f13120m = new p.e(context2, str4);
            if (f10.getNotificationChannel(str4).getImportance() == 0 || !j0.b(context).a()) {
                z10 = false;
            }
            R(stringExtra2, z10);
        } else {
            this.f13120m = new p.e(context2, str4);
            R("none", j0.b(context).a());
        }
        switch (d.f13134a[notificationType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                if (this.f13119l) {
                    if (map2.containsKey(Extra.NOTIFICATION_IMAGE_URL)) {
                        U("url");
                        A(map2.get(Extra.NOTIFICATION_IMAGE_URL), str, str2, notificationType, (Bagel) null, intent, intent3, context);
                        return;
                    } else if (bagel != null) {
                        U(Extra.BAGEL);
                        N(bagel, context, str, str2, notificationType, intent, intent3);
                        return;
                    } else {
                        U("default");
                        this.f13121n = lc.c.c(Bakery.w().getApplicationContext(), R.drawable.cmb_icon_notification);
                        C(str, str2, notificationType, bagel, context, intent, intent3);
                        return;
                    }
                } else {
                    return;
                }
            default:
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Notification type not recognized: ");
                sb3.append(notificationType2);
                this.f13121n = lc.c.c(Bakery.w().getApplicationContext(), R.drawable.cmb_icon_notification);
                C(str, str2, notificationType, bagel, context, intent, intent3);
                return;
        }
    }

    private void C(String str, String str2, NotificationType notificationType, Bagel bagel, Context context, Intent intent, Intent intent2) {
        p.e k10 = this.f13120m.n(6).k(this.f13118k);
        if (TextUtils.isEmpty(str)) {
            str = "Coffee Meets Bagel";
        }
        k10.m(str).u(true).f(true).B(str2).x(R.drawable.icon_notification_k_statusbar).q(this.f13121n).l(str2).z(new p.c().h(str2));
        Notification b10 = this.f13120m.b();
        int F = F(intent2.getExtras());
        intent2.putExtra(Extra.NOTIFICATION_ID, F);
        try {
            ManagerNotifications.f().notify(F, b10);
            W(g());
        } catch (IllegalArgumentException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e10.getMessage());
            sb2.append(" ");
            if (notificationType != null) {
                sb2.append(notificationType.getType());
            }
            fa.a.i(new Throwable(sb2.toString()));
        }
        this.f13121n = null;
    }

    private int D(String str) {
        if (str == null) {
            return 3;
        }
        char c10 = 65535;
        switch (str.hashCode()) {
            case -836906175:
                if (str.equals("urgent")) {
                    c10 = 0;
                    break;
                }
                break;
            case 107348:
                if (str.equals("low")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3202466:
                if (str.equals("high")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return 5;
            case 1:
                return 2;
            case 2:
                return 4;
            default:
                return 3;
        }
    }

    /* access modifiers changed from: private */
    public Intent E() {
        Intent intent = new Intent();
        Map<String, Object> h10 = g().h();
        for (String next : h10.keySet()) {
            Object obj = h10.get(next);
            if (obj instanceof String) {
                intent.putExtra(next, (String) obj);
            } else if (obj instanceof Integer) {
                intent.putExtra(next, (Integer) obj);
            } else if (obj instanceof Boolean) {
                intent.putExtra(next, (Boolean) obj);
            } else if (obj instanceof Float) {
                intent.putExtra(next, (Float) obj);
            } else if (obj instanceof Double) {
                intent.putExtra(next, (Double) obj);
            } else if (obj instanceof Long) {
                intent.putExtra(next, (Long) obj);
            }
        }
        return intent;
    }

    private int F(Bundle bundle) {
        if (bundle != null && bundle.containsKey("ll")) {
            try {
                return new org.json.b(bundle.getString("ll")).getInt("ca");
            } catch (JSONException unused) {
            }
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public void G(Context context, androidx.work.b bVar, NotificationType notificationType, String str, Map<String, String> map) {
        String i10 = bVar.i("title");
        String orDefault = map.getOrDefault(Extra.BAGEL_ID, "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleValidNotification: ");
        sb2.append(orDefault);
        if (TextUtils.isEmpty(orDefault) || !this.f13119l) {
            B(i10, str, notificationType, map, context, E(), (Bagel) null);
            return;
        }
        c cVar = new c(map, notificationType, i10, str, context);
        Bagel k10 = Bakery.w().i().k(orDefault);
        if (k10 == null || TextUtils.isEmpty(k10.getDecouplingDate()) || TextUtils.isEmpty(k10.getCoupleId())) {
            Bakery.w().i().d(orDefault, cVar);
        } else {
            cVar.a(k10);
        }
    }

    private void H() {
        boolean z10;
        NotificationType notificationType = NotificationType.GENERAL;
        androidx.work.b g10 = g();
        String i10 = g10.i(Extra.BAGEL_ID);
        String i11 = g10.i("image_url");
        String i12 = g10.i("type");
        X(g10);
        if (!TextUtils.isEmpty(i12)) {
            notificationType = NotificationType.getNotificationType(i12);
        }
        NotificationType notificationType2 = NotificationType.EXPEDITED_BATCH;
        if (notificationType2.getType().equals(g10.i("campaign"))) {
            notificationType = notificationType2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\tIntent type=");
        sb2.append(i12);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\tNotificationType type=");
        sb3.append(notificationType);
        if (notificationType == NotificationType.REOPEN_SUCCESS && !TextUtils.isEmpty(i10)) {
            new Handler(Looper.getMainLooper()).post(new r8.c(this, i10));
        }
        boolean isLoggedIn = Bakery.w().g().isLoggedIn();
        this.f13119l = isLoggedIn;
        if (!isLoggedIn) {
            Bakery.w().h().a();
        } else {
            if (g10.i(Extra.BADGE) != null) {
                try {
                    Bakery.w().h().b(Integer.parseInt(g10.i(Extra.BADGE)));
                } catch (NumberFormatException e10) {
                    fa.a.i(e10);
                }
            }
            if (Bakery.w().G().j() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return;
            }
        }
        String i13 = g10.i("message");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(i10)) {
            hashMap.put(Extra.BAGEL_ID, i10);
        }
        if (!TextUtils.isEmpty(i11)) {
            hashMap.put(Extra.NOTIFICATION_IMAGE_URL, i11);
        }
        if (g10.i(Extra.DEEP_LINK) != null) {
            hashMap.put(Extra.DEEP_LINK, g10.i(Extra.DEEP_LINK));
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("#push: alert=");
        sb4.append(i13);
        sb4.append(", bagelId=");
        sb4.append(i10);
        sb4.append(", lastAlert=");
        sb4.append(f13112p);
        sb4.append(", lastBagelId=");
        sb4.append(f13113q);
        if (notificationType != NotificationType.CHAT || i13 == null || !i13.equals(f13112p) || i10 == null || !i10.equals(f13113q)) {
            f13112p = i13;
            f13113q = i10;
            if (notificationType == NotificationType.EXPEDITED_BATCH) {
                Bakery.w().D().b(new b(notificationType, i13, hashMap), false);
                return;
            }
            G(this.f13114f, g10, notificationType, i13, hashMap);
            return;
        }
        V("Duplicate Chat Message", g());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit I(String str, String str2, NotificationType notificationType, Bagel bagel, Context context, Intent intent, Intent intent2) {
        T(StreamManagement.Failed.ELEMENT, g());
        this.f13121n = lc.c.c(Bakery.w().getApplicationContext(), R.drawable.cmb_icon_notification);
        C(str, str2, notificationType, bagel, context, intent, intent2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit J(String str, String str2, NotificationType notificationType, Bagel bagel, Context context, Intent intent, Intent intent2, Bitmap bitmap) {
        T("succeeded", g());
        if (bitmap == null) {
            return null;
        }
        this.f13121n = bitmap;
        C(str, str2, notificationType, bagel, context, intent, intent2);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void K() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(String str) {
        Bakery.w().i().d(str, new a(str));
    }

    private void N(Bagel bagel, Context context, String str, String str2, NotificationType notificationType, Intent intent, Intent intent2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("This is CHAT notification so getting bagel ... ");
        Bagel bagel2 = bagel;
        sb2.append(bagel);
        Optional h10 = this.f13117j.b(bagel.getProfileId()).h();
        if (h10.isPresent()) {
            Photo photo = (Photo) h10.get();
            S(photo.getUrl());
            A(photo.getUrl(), str, str2, notificationType, bagel, intent, intent2, context);
            return;
        }
        S((String) null);
        this.f13121n = lc.c.c(Bakery.w().getApplicationContext(), R.drawable.cmb_icon_notification);
        C(str, str2, notificationType, bagel, context, intent, intent2);
    }

    private void O(String str, Context context, Intent intent) {
        Class<ChatActivity> cls = ChatActivity.class;
        Intent intent2 = new Intent(context, cls);
        intent2.putExtras(intent);
        intent2.putExtra(Extra.BAGEL_ID, str);
        intent2.putExtra(Extra.IS_FROM_PUSH, true);
        q0 j10 = q0.j(context);
        j10.i(cls);
        j10.b(intent2);
        this.f13118k = j10.m(0, 201326592);
    }

    private void P(Context context, Intent intent) {
        Intent intent2 = new Intent(context, ActivityMain.class);
        intent2.putExtras(intent);
        intent2.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_LIKES_YOU);
        intent2.putExtra(Extra.IS_FROM_PUSH, true);
        this.f13118k = PendingIntent.getActivity(context, 0, intent2, 201326592);
    }

    private void Q(Context context, Intent intent) {
        Intent intent2 = new Intent(context, ActivityMain.class);
        intent2.putExtras(intent);
        intent2.putExtra("deeplink_page_to_redirect_to", ModelDeeplinkData.VALUE_VIDEO_FEED);
        intent2.putExtra(Extra.IS_FROM_PUSH, true);
        this.f13118k = PendingIntent.getActivity(context, 0, intent2, 201326592);
    }

    private void R(String str, boolean z10) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("channel", str);
        if (z10) {
            str2 = "on";
        } else {
            str2 = "off";
        }
        hashMap.put("state", str2);
        Bakery.w().z().trackEvent("Android OS Notification", hashMap);
    }

    private void S(String str) {
        Bakery.w().z().trackEvent("Push Bagel Image", Collections.singletonMap("url", str));
    }

    private void T(String str, androidx.work.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(MamElements.MamResultExtension.ELEMENT, str);
        z(bVar, hashMap);
        Bakery.w().z().trackEvent("Push Image Load", hashMap);
    }

    private void U(String str) {
        Bakery.w().z().trackEvent("Push Image Source", Collections.singletonMap("source", str));
    }

    private void V(String str, androidx.work.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("Error", str);
        z(bVar, hashMap);
        Bakery.w().z().trackEvent("Push Process Error", hashMap);
    }

    private void W(androidx.work.b bVar) {
        String str;
        if (h1.g().i()) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_foreground", str);
        z(bVar, hashMap);
        Bakery.w().z().trackEvent("Push Fired", hashMap);
        this.f13115g.trackEvent("Push Fired", hashMap);
    }

    private void X(androidx.work.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("profile id", Bakery.w().g().getProfileId());
        z(bVar, hashMap);
        Bakery.w().z().trackEvent("Push Received", hashMap);
    }

    private void z(androidx.work.b bVar, Map<String, String> map) {
        if (bVar.i("cmb_push_id") != null) {
            map.put("cmb push id", bVar.i("cmb_push_id"));
        }
        if (bVar.i("get_now") != null) {
            map.put("get now", bVar.i("get_now"));
        }
        if (bVar.i("profile_image_url") != null) {
            map.put("profile image url", bVar.i("profile_image_url"));
        }
    }

    @NonNull
    public c.a o() {
        H();
        return c.a.c();
    }
}
