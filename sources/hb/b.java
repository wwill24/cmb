package hb;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import s1.a;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40888a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f40889b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Object f40890c = new Object();

    public b(Context context) {
        this.f40888a = context;
        new Thread(new a(this)).start();
    }

    private void D(Set<String> set) {
        SharedPreferences.Editor G = G("CMB_SHARED_PREFS");
        if (set == null || set.isEmpty()) {
            G.clear().apply();
            return;
        }
        for (Map.Entry<String, ?> key : a().getAll().entrySet()) {
            String str = (String) key.getKey();
            if (!set.contains(str)) {
                G.remove(str).apply();
            }
        }
    }

    /* access modifiers changed from: private */
    public SharedPreferences E() {
        synchronized (this.f40890c) {
            if (this.f40889b == null) {
                try {
                    this.f40889b = EncryptedSharedPreferences.a(this.f40888a.getPackageName() + "_secure_prefs", a.c(a.f17439a), this.f40888a, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
                } catch (Exception e10) {
                    PrintStream printStream = System.err;
                    printStream.println(getClass().getSimpleName() + "Error on getting encrypted shared preferences: " + e10);
                }
            }
        }
        return this.f40889b;
    }

    private SharedPreferences.Editor F() {
        SharedPreferences E = E();
        if (E != null) {
            return E.edit();
        }
        return null;
    }

    public void A() {
        a().edit().putBoolean("HAS_SEEN_EDUCATION", true).apply();
    }

    public SharedPreferences B(String str) {
        return this.f40888a.getSharedPreferences(str, 0);
    }

    public SharedPreferences.Editor G(String str) {
        return B(str).edit();
    }

    public SharedPreferences a() {
        return B("CMB_SHARED_PREFS");
    }

    public void b(String str, long j10) {
        G("CMB_SHARED_PREFS").putLong(str, j10).apply();
    }

    public void c(String str, int i10) {
        G("CMB_SHARED_PREFS").putInt(str, i10).apply();
    }

    public boolean d(boolean z10) {
        return j(z10) != null;
    }

    public void e(String str) {
        SharedPreferences a10 = a();
        if (a10.contains(str)) {
            a10.edit().remove(str).apply();
        }
    }

    public void f(String str, boolean z10) {
        G("CMB_SHARED_PREFS").putBoolean(str, z10).apply();
    }

    public void g(String... strArr) {
        for (String e10 : strArr) {
            e(e10);
        }
    }

    public void h(String str) {
        a().edit().putString("FACEBOOK_ACCESS_TOKEN", str).apply();
    }

    public boolean hasProperty(String str) {
        return a().contains(str);
    }

    public void i(String str, String str2) {
        SharedPreferences.Editor F = F();
        if (F != null) {
            F.putString(str, str2).apply();
        }
    }

    public String j(boolean z10) {
        if (z10) {
            return a().getString("key_user_id_to_impersonate", (String) null);
        }
        return null;
    }

    public String k(String str) {
        try {
            SharedPreferences sharedPreferences = this.f40889b;
            if (sharedPreferences != null && sharedPreferences.contains(str)) {
                return this.f40889b.getString(str, "");
            }
        } catch (Exception unused) {
            v(str);
        }
        return "";
    }

    public int l(String str) {
        return a().getInt(str, 0);
    }

    public void m() {
        a().edit().putBoolean("HAS_SEEN_TODAYS_BAGEL", true).apply();
    }

    public boolean n(String str, boolean z10) {
        return a().getBoolean(str, z10);
    }

    public void o() {
        SharedPreferences a10 = a();
        if (a10.contains("FACEBOOK_ACCESS_TOKEN")) {
            a10.edit().remove("FACEBOOK_ACCESS_TOKEN").apply();
        }
    }

    public boolean p(String str) {
        return n(str, false);
    }

    public String q() {
        SharedPreferences a10 = a();
        if (a10.contains("FACEBOOK_ACCESS_TOKEN")) {
            return a10.getString("FACEBOOK_ACCESS_TOKEN", (String) null);
        }
        return null;
    }

    public String r(String str) {
        try {
            return a().getString(str, (String) null);
        } catch (ClassCastException unused) {
            long j10 = a().getLong(str, 0);
            e(str);
            w(str, String.valueOf(j10));
            return a().getString(str, (String) null);
        }
    }

    public void remove(String str) {
        e(str);
    }

    public void s() {
        HashSet hashSet = new HashSet();
        hashSet.add("is_set_to_baking");
        hashSet.add("should_auto_validate_subscriptions");
        hashSet.add("key_user_id_to_impersonate");
        hashSet.add("custom_ip");
        hashSet.add("HAS_SEEN_DIALOG_RATING");
        hashSet.add("enjoying");
        hashSet.add("not_enjoying");
        hashSet.add("feedback_banner_first_action_taken");
        hashSet.add("has_acted_on_feedback_banner");
        hashSet.add("feedback_prompt_started");
        hashSet.add("last_feedback_prompt");
        hashSet.add("total_feedback_prompts");
        hashSet.add("feedback_enjoying_prompted_action");
        hashSet.add("previous_purge_headers");
        hashSet.add("analytics_events_install_id");
        hashSet.add("num_times_like_pass_flow_shown");
        hashSet.add("last_show_like_pass_flow");
        D(hashSet);
    }

    public long t(String str) {
        return a().getLong(str, 0);
    }

    public void u(String str, Set<String> set) {
        G("CMB_SHARED_PREFS").putStringSet(str, set).apply();
    }

    public void v(String str) {
        SharedPreferences E = E();
        if (E != null && E.contains(str)) {
            E.edit().remove(str).apply();
        }
    }

    public void w(String str, String str2) {
        G("CMB_SHARED_PREFS").putString(str, str2).apply();
    }

    public boolean x() {
        return a().getBoolean("IS_OLD_AGE_CONFIRMED", false);
    }

    public boolean y() {
        return a().getBoolean("HAS_SEEN_TODAYS_BAGEL", false);
    }

    public Set<String> z(String str) {
        return a().getStringSet(str, new HashSet());
    }
}
