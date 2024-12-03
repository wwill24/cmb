package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.pushnotification.i;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.leanplum.internal.Constants;
import i4.h;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.b;

public class CleverTapInstanceConfig implements Parcelable {
    public static final Parcelable.Creator<CleverTapInstanceConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10077a;

    /* renamed from: b  reason: collision with root package name */
    private String f10078b;

    /* renamed from: c  reason: collision with root package name */
    private String f10079c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<String> f10080d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10081e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10082f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10083g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10084h;

    /* renamed from: j  reason: collision with root package name */
    private int f10085j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10086k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10087l;

    /* renamed from: m  reason: collision with root package name */
    private String f10088m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10089n;

    /* renamed from: p  reason: collision with root package name */
    private p f10090p;

    /* renamed from: q  reason: collision with root package name */
    private String f10091q;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10092t;

    /* renamed from: w  reason: collision with root package name */
    private String[] f10093w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f10094x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f10095y;

    class a implements Parcelable.Creator<CleverTapInstanceConfig> {
        a() {
        }

        /* renamed from: a */
        public CleverTapInstanceConfig createFromParcel(Parcel parcel) {
            return new CleverTapInstanceConfig(parcel, (a) null);
        }

        /* renamed from: b */
        public CleverTapInstanceConfig[] newArray(int i10) {
            return new CleverTapInstanceConfig[i10];
        }
    }

    /* synthetic */ CleverTapInstanceConfig(Parcel parcel, a aVar) {
        this(parcel);
    }

    protected static CleverTapInstanceConfig a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        return new CleverTapInstanceConfig(context, str, str2, str3, true);
    }

    public static CleverTapInstanceConfig c(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (str != null && str2 != null) {
            return new CleverTapInstanceConfig(context, str, str2, str3, false);
        }
        p.j("CleverTap accountId and accountToken cannot be null");
        return null;
    }

    protected static CleverTapInstanceConfig d(@NonNull String str) {
        try {
            return new CleverTapInstanceConfig(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String j(@NonNull String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        if (!TextUtils.isEmpty(str)) {
            str2 = CertificateUtil.DELIMITER + str;
        } else {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(this.f10077a);
        sb2.append("]");
        return sb2.toString();
    }

    public void A(@NonNull String str, @NonNull String str2) {
        this.f10090p.t(j(str), str2);
    }

    public void B(@NonNull String str, @NonNull String str2, Throwable th2) {
        this.f10090p.u(j(str), str2, th2);
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.f10084h = true;
    }

    public void E(int i10) {
        this.f10085j = i10;
        p pVar = this.f10090p;
        if (pVar != null) {
            pVar.n(i10);
        }
    }

    public void F(boolean z10) {
        this.f10087l = z10;
    }

    /* access modifiers changed from: package-private */
    public String G() {
        b bVar = new b();
        try {
            bVar.put(Constants.Params.CT_ACCOUNT_ID, (Object) e());
            bVar.put("accountToken", (Object) g());
            bVar.put("accountRegion", (Object) f());
            bVar.put("fcmSenderId", (Object) l());
            bVar.put("analyticsOnly", p());
            bVar.put("isDefaultInstance", t());
            bVar.put("useGoogleAdId", z());
            bVar.put("disableAppLaunchedEvent", u());
            bVar.put("personalization", w());
            bVar.put("debugLevel", i());
            bVar.put("createdPostAppLaunch", s());
            bVar.put("sslPinning", x());
            bVar.put("backgroundSync", q());
            bVar.put("getEnableCustomCleverTapId", k());
            bVar.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, (Object) o());
            bVar.put("beta", r());
            bVar.put("allowedPushTypes", (Object) v4.a.i(this.f10080d));
            return bVar.toString();
        } catch (Throwable th2) {
            p.r("Unable to convert config to JSON : ", th2.getCause());
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f10077a;
    }

    public String f() {
        return this.f10078b;
    }

    public String g() {
        return this.f10079c;
    }

    @NonNull
    public ArrayList<String> h() {
        return this.f10080d;
    }

    public int i() {
        return this.f10085j;
    }

    public boolean k() {
        return this.f10087l;
    }

    public String l() {
        return this.f10088m;
    }

    public String[] m() {
        return this.f10093w;
    }

    public p n() {
        if (this.f10090p == null) {
            this.f10090p = new p(this.f10085j);
        }
        return this.f10090p;
    }

    public String o() {
        return this.f10091q;
    }

    public boolean p() {
        return this.f10081e;
    }

    public boolean q() {
        return this.f10082f;
    }

    public boolean r() {
        return this.f10083g;
    }

    public boolean s() {
        return this.f10084h;
    }

    public boolean t() {
        return this.f10089n;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        return this.f10086k;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.f10092t;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10077a);
        parcel.writeString(this.f10079c);
        parcel.writeString(this.f10078b);
        parcel.writeByte(this.f10081e ? (byte) 1 : 0);
        parcel.writeByte(this.f10089n ? (byte) 1 : 0);
        parcel.writeByte(this.f10095y ? (byte) 1 : 0);
        parcel.writeByte(this.f10086k ? (byte) 1 : 0);
        parcel.writeByte(this.f10092t ? (byte) 1 : 0);
        parcel.writeInt(this.f10085j);
        parcel.writeByte(this.f10084h ? (byte) 1 : 0);
        parcel.writeByte(this.f10094x ? (byte) 1 : 0);
        parcel.writeByte(this.f10082f ? (byte) 1 : 0);
        parcel.writeByte(this.f10087l ? (byte) 1 : 0);
        parcel.writeString(this.f10088m);
        parcel.writeString(this.f10091q);
        parcel.writeByte(this.f10083g ? (byte) 1 : 0);
        parcel.writeList(this.f10080d);
        parcel.writeStringArray(this.f10093w);
    }

    public boolean x() {
        return this.f10094x;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return this.f10095y;
    }

    CleverTapInstanceConfig(CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f10080d = i.b();
        this.f10093w = h.f15492e;
        this.f10077a = cleverTapInstanceConfig.f10077a;
        this.f10079c = cleverTapInstanceConfig.f10079c;
        this.f10078b = cleverTapInstanceConfig.f10078b;
        this.f10089n = cleverTapInstanceConfig.f10089n;
        this.f10081e = cleverTapInstanceConfig.f10081e;
        this.f10092t = cleverTapInstanceConfig.f10092t;
        this.f10085j = cleverTapInstanceConfig.f10085j;
        this.f10090p = cleverTapInstanceConfig.f10090p;
        this.f10095y = cleverTapInstanceConfig.f10095y;
        this.f10086k = cleverTapInstanceConfig.f10086k;
        this.f10084h = cleverTapInstanceConfig.f10084h;
        this.f10094x = cleverTapInstanceConfig.f10094x;
        this.f10082f = cleverTapInstanceConfig.f10082f;
        this.f10087l = cleverTapInstanceConfig.f10087l;
        this.f10088m = cleverTapInstanceConfig.f10088m;
        this.f10091q = cleverTapInstanceConfig.f10091q;
        this.f10083g = cleverTapInstanceConfig.f10083g;
        this.f10080d = cleverTapInstanceConfig.f10080d;
        this.f10093w = cleverTapInstanceConfig.f10093w;
    }

    private CleverTapInstanceConfig(Context context, String str, String str2, String str3, boolean z10) {
        this.f10080d = i.b();
        this.f10093w = h.f15492e;
        this.f10077a = str;
        this.f10079c = str2;
        this.f10078b = str3;
        this.f10089n = z10;
        this.f10081e = false;
        this.f10092t = true;
        int a10 = CleverTapAPI.LogLevel.INFO.a();
        this.f10085j = a10;
        this.f10090p = new p(a10);
        this.f10084h = false;
        q h10 = q.h(context);
        this.f10095y = h10.r();
        this.f10086k = h10.m();
        this.f10094x = h10.o();
        this.f10082f = h10.n();
        this.f10088m = h10.g();
        this.f10091q = h10.k();
        this.f10087l = h10.q();
        this.f10083g = h10.b();
        if (this.f10089n) {
            this.f10093w = h10.l();
            A("ON_USER_LOGIN", "Setting Profile Keys from Manifest: " + Arrays.toString(this.f10093w));
        }
    }

    private CleverTapInstanceConfig(String str) throws Throwable {
        String str2 = str;
        String str3 = "identityTypes";
        String str4 = "allowedPushTypes";
        String str5 = "beta";
        String str6 = "fcmSenderId";
        String str7 = "getEnableCustomCleverTapId";
        this.f10080d = i.b();
        this.f10093w = h.f15492e;
        try {
            b bVar = new b(str2);
            if (bVar.has(Constants.Params.CT_ACCOUNT_ID)) {
                this.f10077a = bVar.getString(Constants.Params.CT_ACCOUNT_ID);
            }
            if (bVar.has("accountToken")) {
                this.f10079c = bVar.getString("accountToken");
            }
            if (bVar.has("accountRegion")) {
                this.f10078b = bVar.getString("accountRegion");
            }
            if (bVar.has("analyticsOnly")) {
                this.f10081e = bVar.getBoolean("analyticsOnly");
            }
            if (bVar.has("isDefaultInstance")) {
                this.f10089n = bVar.getBoolean("isDefaultInstance");
            }
            if (bVar.has("useGoogleAdId")) {
                this.f10095y = bVar.getBoolean("useGoogleAdId");
            }
            if (bVar.has("disableAppLaunchedEvent")) {
                this.f10086k = bVar.getBoolean("disableAppLaunchedEvent");
            }
            if (bVar.has("personalization")) {
                this.f10092t = bVar.getBoolean("personalization");
            }
            if (bVar.has("debugLevel")) {
                this.f10085j = bVar.getInt("debugLevel");
            }
            this.f10090p = new p(this.f10085j);
            if (bVar.has(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME)) {
                this.f10091q = bVar.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            }
            if (bVar.has("createdPostAppLaunch")) {
                this.f10084h = bVar.getBoolean("createdPostAppLaunch");
            }
            if (bVar.has("sslPinning")) {
                this.f10094x = bVar.getBoolean("sslPinning");
            }
            if (bVar.has("backgroundSync")) {
                this.f10082f = bVar.getBoolean("backgroundSync");
            }
            String str8 = str7;
            if (bVar.has(str8)) {
                this.f10087l = bVar.getBoolean(str8);
            }
            String str9 = str6;
            if (bVar.has(str9)) {
                this.f10088m = bVar.getString(str9);
            }
            String str10 = str5;
            if (bVar.has(str10)) {
                this.f10083g = bVar.getBoolean(str10);
            }
            String str11 = str4;
            if (bVar.has(str11)) {
                this.f10080d = v4.a.l(bVar.getJSONArray(str11));
            }
            String str12 = str3;
            if (bVar.has(str12)) {
                this.f10093w = (String[]) v4.a.h(bVar.getJSONArray(str12));
            }
        } catch (Throwable th2) {
            p.r("Error constructing CleverTapInstanceConfig from JSON: " + str2 + ": ", th2.getCause());
            throw th2;
        }
    }

    private CleverTapInstanceConfig(Parcel parcel) {
        this.f10080d = i.b();
        this.f10093w = h.f15492e;
        this.f10077a = parcel.readString();
        this.f10079c = parcel.readString();
        this.f10078b = parcel.readString();
        boolean z10 = true;
        this.f10081e = parcel.readByte() != 0;
        this.f10089n = parcel.readByte() != 0;
        this.f10095y = parcel.readByte() != 0;
        this.f10086k = parcel.readByte() != 0;
        this.f10092t = parcel.readByte() != 0;
        this.f10085j = parcel.readInt();
        this.f10084h = parcel.readByte() != 0;
        this.f10094x = parcel.readByte() != 0;
        this.f10082f = parcel.readByte() != 0;
        this.f10087l = parcel.readByte() != 0;
        this.f10088m = parcel.readString();
        this.f10091q = parcel.readString();
        this.f10090p = new p(this.f10085j);
        this.f10083g = parcel.readByte() == 0 ? false : z10;
        ArrayList<String> arrayList = new ArrayList<>();
        this.f10080d = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        this.f10093w = parcel.createStringArray();
    }
}
