package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import be.d;
import com.facebook.login.LoginConfiguration;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.b;

public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new e();
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public static final GoogleSignInOptions f38383m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public static final GoogleSignInOptions f38384n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public static final Scope f38385p = new Scope("profile");
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public static final Scope f38386q = new Scope("email");
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public static final Scope f38387t = new Scope(LoginConfiguration.OPENID);
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public static final Scope f38388w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public static final Scope f38389x = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: y  reason: collision with root package name */
    private static Comparator f38390y = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f38391a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f38392b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Account f38393c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f38394d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38395e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38396f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f38397g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f38398h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f38399j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f38400k;

    /* renamed from: l  reason: collision with root package name */
    private Map f38401l;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f38388w = scope;
        a aVar = new a();
        aVar.b();
        aVar.c();
        f38383m = aVar.a();
        a aVar2 = new a();
        aVar2.d(scope, new Scope[0]);
        f38384n = aVar2.a();
    }

    GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, ArrayList arrayList2, String str3) {
        this(i10, arrayList, account, z10, z11, z12, str, str2, A1(arrayList2), str3);
    }

    /* synthetic */ GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3, d dVar) {
        this(3, arrayList, account, z10, z11, z12, str, str2, map, str3);
    }

    /* access modifiers changed from: private */
    public static Map A1(List list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public static GoogleSignInOptions B0(String str) throws JSONException {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b(str);
        HashSet hashSet = new HashSet();
        org.json.a jSONArray = bVar.getJSONArray("scopes");
        int o10 = jSONArray.o();
        for (int i10 = 0; i10 < o10; i10++) {
            hashSet.add(new Scope(jSONArray.n(i10)));
        }
        if (bVar.has("accountName")) {
            str2 = bVar.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z10 = bVar.getBoolean("idTokenRequested");
        boolean z11 = bVar.getBoolean("serverAuthRequested");
        boolean z12 = bVar.getBoolean("forceCodeForRefreshToken");
        if (bVar.has("serverClientId")) {
            str3 = bVar.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (bVar.has("hostedDomain")) {
            str4 = bVar.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z10, z11, z12, str3, str4, (Map) new HashMap(), (String) null);
    }

    public Account O() {
        return this.f38393c;
    }

    @NonNull
    public ArrayList<GoogleSignInOptionsExtensionParcelable> S() {
        return this.f38399j;
    }

    @NonNull
    public final String W0() {
        b bVar = new b();
        try {
            org.json.a aVar = new org.json.a();
            Collections.sort(this.f38392b, f38390y);
            Iterator it = this.f38392b.iterator();
            while (it.hasNext()) {
                aVar.E(((Scope) it.next()).S());
            }
            bVar.put("scopes", (Object) aVar);
            Account account = this.f38393c;
            if (account != null) {
                bVar.put("accountName", (Object) account.name);
            }
            bVar.put("idTokenRequested", this.f38394d);
            bVar.put("forceCodeForRefreshToken", this.f38396f);
            bVar.put("serverAuthRequested", this.f38395e);
            if (!TextUtils.isEmpty(this.f38397g)) {
                bVar.put("serverClientId", (Object) this.f38397g);
            }
            if (!TextUtils.isEmpty(this.f38398h)) {
                bVar.put("hostedDomain", (Object) this.f38398h);
            }
            return bVar.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public String Y() {
        return this.f38400k;
    }

    @NonNull
    public ArrayList<Scope> c0() {
        return new ArrayList<>(this.f38392b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.O()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r1 = r3.f38399j     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 > 0) goto L_0x0090
            java.util.ArrayList r1 = r4.f38399j     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList r1 = r3.f38392b     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.c0()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList r1 = r3.f38392b     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.c0()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.f38393c     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.O()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.O()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.f38397g     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.f0()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.f38397g     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.f0()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.f38396f     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.i0()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f38394d     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.m0()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f38395e     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.q0()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.f38400k     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.Y()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public String f0() {
        return this.f38397g;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f38392b;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(((Scope) arrayList2.get(i10)).S());
        }
        Collections.sort(arrayList);
        ce.a aVar = new ce.a();
        aVar.a(arrayList);
        aVar.a(this.f38393c);
        aVar.a(this.f38397g);
        aVar.c(this.f38396f);
        aVar.c(this.f38394d);
        aVar.c(this.f38395e);
        aVar.a(this.f38400k);
        return aVar.b();
    }

    public boolean i0() {
        return this.f38396f;
    }

    public boolean m0() {
        return this.f38394d;
    }

    public boolean q0() {
        return this.f38395e;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, this.f38391a);
        fe.a.G(parcel, 2, c0(), false);
        fe.a.A(parcel, 3, O(), i10, false);
        fe.a.g(parcel, 4, m0());
        fe.a.g(parcel, 5, q0());
        fe.a.g(parcel, 6, i0());
        fe.a.C(parcel, 7, f0(), false);
        fe.a.C(parcel, 8, this.f38398h, false);
        fe.a.G(parcel, 9, S(), false);
        fe.a.C(parcel, 10, Y(), false);
        fe.a.b(parcel, a10);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set f38402a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f38403b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f38404c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f38405d;

        /* renamed from: e  reason: collision with root package name */
        private String f38406e;

        /* renamed from: f  reason: collision with root package name */
        private Account f38407f;

        /* renamed from: g  reason: collision with root package name */
        private String f38408g;

        /* renamed from: h  reason: collision with root package name */
        private Map f38409h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private String f38410i;

        public a() {
        }

        @NonNull
        public GoogleSignInOptions a() {
            if (this.f38402a.contains(GoogleSignInOptions.f38389x)) {
                Set set = this.f38402a;
                Scope scope = GoogleSignInOptions.f38388w;
                if (set.contains(scope)) {
                    this.f38402a.remove(scope);
                }
            }
            if (this.f38405d && (this.f38407f == null || !this.f38402a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f38402a), this.f38407f, this.f38405d, this.f38403b, this.f38404c, this.f38406e, this.f38408g, this.f38409h, this.f38410i, (d) null);
        }

        @NonNull
        public a b() {
            this.f38402a.add(GoogleSignInOptions.f38387t);
            return this;
        }

        @NonNull
        public a c() {
            this.f38402a.add(GoogleSignInOptions.f38385p);
            return this;
        }

        @NonNull
        public a d(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.f38402a.add(scope);
            this.f38402a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        public a e(@NonNull String str) {
            this.f38410i = str;
            return this;
        }

        public a(@NonNull GoogleSignInOptions googleSignInOptions) {
            p.k(googleSignInOptions);
            this.f38402a = new HashSet(googleSignInOptions.f38392b);
            this.f38403b = googleSignInOptions.f38395e;
            this.f38404c = googleSignInOptions.f38396f;
            this.f38405d = googleSignInOptions.f38394d;
            this.f38406e = googleSignInOptions.f38397g;
            this.f38407f = googleSignInOptions.f38393c;
            this.f38408g = googleSignInOptions.f38398h;
            this.f38409h = GoogleSignInOptions.A1(googleSignInOptions.f38399j);
            this.f38410i = googleSignInOptions.f38400k;
        }
    }

    private GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, Map map, String str3) {
        this.f38391a = i10;
        this.f38392b = arrayList;
        this.f38393c = account;
        this.f38394d = z10;
        this.f38395e = z11;
        this.f38396f = z12;
        this.f38397g = str;
        this.f38398h = str2;
        this.f38399j = new ArrayList(map.values());
        this.f38401l = map;
        this.f38400k = str3;
    }
}
