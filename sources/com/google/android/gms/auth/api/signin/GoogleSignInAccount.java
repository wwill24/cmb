package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import be.c;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.f;
import me.i;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public static f f38369p = i.c();

    /* renamed from: a  reason: collision with root package name */
    final int f38370a;

    /* renamed from: b  reason: collision with root package name */
    private String f38371b;

    /* renamed from: c  reason: collision with root package name */
    private String f38372c;

    /* renamed from: d  reason: collision with root package name */
    private String f38373d;

    /* renamed from: e  reason: collision with root package name */
    private String f38374e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f38375f;

    /* renamed from: g  reason: collision with root package name */
    private String f38376g;

    /* renamed from: h  reason: collision with root package name */
    private long f38377h;

    /* renamed from: j  reason: collision with root package name */
    private String f38378j;

    /* renamed from: k  reason: collision with root package name */
    List f38379k;

    /* renamed from: l  reason: collision with root package name */
    private String f38380l;

    /* renamed from: m  reason: collision with root package name */
    private String f38381m;

    /* renamed from: n  reason: collision with root package name */
    private Set f38382n = new HashSet();

    GoogleSignInAccount(int i10, String str, String str2, String str3, String str4, Uri uri, String str5, long j10, String str6, List list, String str7, String str8) {
        this.f38370a = i10;
        this.f38371b = str;
        this.f38372c = str2;
        this.f38373d = str3;
        this.f38374e = str4;
        this.f38375f = uri;
        this.f38376g = str5;
        this.f38377h = j10;
        this.f38378j = str6;
        this.f38379k = list;
        this.f38380l = str7;
        this.f38381m = str8;
    }

    @NonNull
    public static GoogleSignInAccount m0(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l10, @NonNull String str7, @NonNull Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l10.longValue(), p.g(str7), new ArrayList((Collection) p.k(set)), str5, str6);
    }

    public static GoogleSignInAccount q0(String str) throws JSONException {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b(str);
        String optString = bVar.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(bVar.getString(SDKConstants.PARAM_EXPIRATION_TIME));
        HashSet hashSet = new HashSet();
        a jSONArray = bVar.getJSONArray("grantedScopes");
        int o10 = jSONArray.o();
        for (int i10 = 0; i10 < o10; i10++) {
            hashSet.add(new Scope(jSONArray.n(i10)));
        }
        String optString2 = bVar.optString("id");
        if (bVar.has("tokenId")) {
            str2 = bVar.optString("tokenId");
        } else {
            str2 = null;
        }
        if (bVar.has("email")) {
            str3 = bVar.optString("email");
        } else {
            str3 = null;
        }
        if (bVar.has("displayName")) {
            str4 = bVar.optString("displayName");
        } else {
            str4 = null;
        }
        if (bVar.has("givenName")) {
            str5 = bVar.optString("givenName");
        } else {
            str5 = null;
        }
        if (bVar.has("familyName")) {
            str6 = bVar.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount m02 = m0(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), bVar.getString("obfuscatedIdentifier"), hashSet);
        if (bVar.has("serverAuthCode")) {
            str7 = bVar.optString("serverAuthCode");
        }
        m02.f38376g = str7;
        return m02;
    }

    @NonNull
    public final String B0() {
        b bVar = new b();
        try {
            if (c0() != null) {
                bVar.put("id", (Object) c0());
            }
            if (getIdToken() != null) {
                bVar.put("tokenId", (Object) getIdToken());
            }
            if (getEmail() != null) {
                bVar.put("email", (Object) getEmail());
            }
            if (getDisplayName() != null) {
                bVar.put("displayName", (Object) getDisplayName());
            }
            if (Y() != null) {
                bVar.put("givenName", (Object) Y());
            }
            if (S() != null) {
                bVar.put("familyName", (Object) S());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                bVar.put("photoUrl", (Object) photoUrl.toString());
            }
            if (i0() != null) {
                bVar.put("serverAuthCode", (Object) i0());
            }
            bVar.put(SDKConstants.PARAM_EXPIRATION_TIME, this.f38377h);
            bVar.put("obfuscatedIdentifier", (Object) this.f38378j);
            a aVar = new a();
            List list = this.f38379k;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c.f34040a);
            for (Scope S : scopeArr) {
                aVar.E(S.S());
            }
            bVar.put("grantedScopes", (Object) aVar);
            bVar.remove("serverAuthCode");
            return bVar.toString();
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Account O() {
        String str = this.f38373d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String S() {
        return this.f38381m;
    }

    public String Y() {
        return this.f38380l;
    }

    public String c0() {
        return this.f38371b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f38378j.equals(this.f38378j) || !googleSignInAccount.f0().equals(f0())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Set<Scope> f0() {
        HashSet hashSet = new HashSet(this.f38379k);
        hashSet.addAll(this.f38382n);
        return hashSet;
    }

    public String getDisplayName() {
        return this.f38374e;
    }

    public String getEmail() {
        return this.f38373d;
    }

    public String getIdToken() {
        return this.f38372c;
    }

    public Uri getPhotoUrl() {
        return this.f38375f;
    }

    public int hashCode() {
        return ((this.f38378j.hashCode() + 527) * 31) + f0().hashCode();
    }

    public String i0() {
        return this.f38376g;
    }

    @NonNull
    public final String t0() {
        return this.f38378j;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, this.f38370a);
        fe.a.C(parcel, 2, c0(), false);
        fe.a.C(parcel, 3, getIdToken(), false);
        fe.a.C(parcel, 4, getEmail(), false);
        fe.a.C(parcel, 5, getDisplayName(), false);
        fe.a.A(parcel, 6, getPhotoUrl(), i10, false);
        fe.a.C(parcel, 7, i0(), false);
        fe.a.v(parcel, 8, this.f38377h);
        fe.a.C(parcel, 9, this.f38378j, false);
        fe.a.G(parcel, 10, this.f38379k, false);
        fe.a.C(parcel, 11, Y(), false);
        fe.a.C(parcel, 12, S(), false);
        fe.a.b(parcel, a10);
    }
}
