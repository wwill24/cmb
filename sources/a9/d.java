package a9;

import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import h5.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lc.g;

public class d implements t {

    /* renamed from: h  reason: collision with root package name */
    private static final Long f206h = 0L;

    /* renamed from: i  reason: collision with root package name */
    private static final Long f207i = Long.valueOf(DateUtils.SEC_IN_HOUR);

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f208j = {"should_show_remote_action_button", "network_okhttp_login_refactor", "android_new_discover_sql_query", "android_profile_me", "likesyoucuration_tabcounters_show_android", "android_should_auto_verify_phone", "android_phone_login_prevent_emulators", "android_phone_login_require_sim_card", "android_show_referral_link", "android_outage_mode"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f209k = {"android_phone_login_resend_sms_delay", "android_stl_default_flower_count", "android_stl_percentage_f_5_to_9", "android_stl_percentage_f_10_to_24", "android_stl_percentage_f_25_to_49", "android_stl_percentage_f_50_to_99", "android_stl_percentage_f_100_and_up", "android_stl_percentage_m_10_to_24", "android_stl_percentage_m_25_to_49", "android_stl_percentage_m_50_to_99", "android_stl_percentage_m_100_to_199", "android_stl_percentage_m_200_and_up", "android_likes_you_cache_duration_minute", "android_sentry_sample_rate"};

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f210l = {"android_onboarding_refactor", "android_image_loader"};
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final FirebaseRemoteConfig f211a;

    /* renamed from: b  reason: collision with root package name */
    private final a7.a f212b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Boolean> f213c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> f214d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Long> f215e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final y7.a f216f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<t.a> f217g = new ArrayList<>();

    class a implements ConfigUpdateListener {
        a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Task task) {
            d.this.I();
            d.this.f216f.a(EventType.REMOTE_CONFIG_UPDATED);
            d.this.H();
        }

        public void onError(@NonNull FirebaseRemoteConfigException firebaseRemoteConfigException) {
        }

        public void onUpdate(@NonNull ConfigUpdate configUpdate) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onUpdate(): ");
            sb2.append(configUpdate.getUpdatedKeys().toArray());
            d.this.f211a.activate().addOnCompleteListener(new c(this));
        }
    }

    public d(FirebaseRemoteConfig firebaseRemoteConfig, y7.a aVar, a7.a aVar2) {
        boolean z10;
        Long l10;
        this.f216f = aVar;
        this.f211a = firebaseRemoteConfig;
        this.f212b = aVar2;
        if (e.f15349a || g.c()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            l10 = f206h;
        } else {
            l10 = f207i;
        }
        firebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(l10.longValue()).build());
        firebaseRemoteConfig.setDefaultsAsync((int) R.xml.remote_config_defaults);
        this.f213c = new HashMap();
        this.f214d = new HashMap();
        this.f215e = new HashMap();
        I();
        E();
    }

    private void E() {
        this.f211a.fetchAndActivate().addOnCompleteListener(new b(this, System.currentTimeMillis()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(long j10, Task task) {
        if (task.isSuccessful()) {
            I();
            this.f216f.a(EventType.REMOTE_CONFIG_UPDATED);
            H();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("activate() time: ");
            sb2.append(System.currentTimeMillis() - j10);
            this.f211a.addOnConfigUpdateListener(new a());
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G(Task task) {
        if (task.isSuccessful()) {
            I();
            this.f216f.a(EventType.REMOTE_CONFIG_UPDATED);
            H();
            d();
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        Iterator<t.a> it = this.f217g.iterator();
        while (it.hasNext()) {
            it.next().I();
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        for (String str : f208j) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\t");
            sb2.append(str);
            sb2.append("=");
            sb2.append(this.f211a.getBoolean(str));
            this.f213c.put(str, Boolean.valueOf(this.f211a.getBoolean(str)));
        }
        for (String str2 : f209k) {
            this.f215e.put(str2, Long.valueOf(this.f211a.getLong(str2)));
        }
        for (String str3 : f210l) {
            this.f214d.put(str3, this.f211a.getString(str3));
        }
    }

    public boolean a() {
        return this.f213c.get("android_should_auto_verify_phone").booleanValue();
    }

    public boolean b() {
        return Boolean.TRUE.equals(this.f213c.get("android_phone_login_prevent_emulators"));
    }

    public long c() {
        return this.f215e.get("android_stl_percentage_f_25_to_49").longValue();
    }

    public void d() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("onboarding_variant", this.f211a.getString("android_onboarding_refactor"));
        this.f212b.h(hashMap);
    }

    public void e(t.a aVar) {
        if (!this.f217g.contains(aVar)) {
            this.f217g.add(aVar);
        }
    }

    public long f() {
        return this.f215e.get("android_stl_percentage_f_5_to_9").longValue();
    }

    public long g() {
        return this.f215e.get("android_stl_percentage_m_50_to_99").longValue();
    }

    public long h() {
        return this.f215e.get("android_stl_percentage_f_100_and_up").longValue();
    }

    public long i() {
        return this.f215e.get("android_stl_percentage_f_10_to_24").longValue();
    }

    public long j() {
        return this.f215e.get("android_stl_percentage_m_200_and_up").longValue();
    }

    public void k(t.a aVar) {
        if (this.f217g.contains(aVar)) {
            this.f217g.remove(aVar);
        }
    }

    public long l() {
        return this.f215e.get("android_stl_percentage_m_100_to_199").longValue();
    }

    public long m() {
        return this.f215e.get("android_stl_default_flower_count").longValue();
    }

    public boolean n() {
        return this.f213c.get("android_outage_mode").booleanValue();
    }

    public void o() {
        this.f211a.fetchAndActivate().addOnCompleteListener(new a(this));
    }

    public long p() {
        return this.f215e.get("android_sentry_sample_rate").longValue();
    }

    public long q() {
        return this.f215e.get("android_stl_percentage_m_10_to_24").longValue();
    }

    public boolean r() {
        return this.f213c.get("android_show_referral_link").booleanValue();
    }

    public boolean s() {
        return Boolean.TRUE.equals(this.f213c.get("network_okhttp_login_refactor"));
    }

    public boolean t() {
        return Boolean.TRUE.equals(this.f213c.get("android_phone_login_require_sim_card"));
    }

    public long u() {
        return this.f215e.get("android_stl_percentage_f_50_to_99").longValue();
    }

    public long v() {
        return this.f215e.get("android_phone_login_resend_sms_delay").longValue();
    }

    public long w() {
        return this.f215e.get("android_stl_percentage_m_25_to_49").longValue();
    }

    public boolean x() {
        return this.f213c.get("android_profile_me").booleanValue();
    }
}
