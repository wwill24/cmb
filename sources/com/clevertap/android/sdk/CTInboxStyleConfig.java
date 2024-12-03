package com.clevertap.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;

public class CTInboxStyleConfig implements Parcelable {
    public static final Parcelable.Creator<CTInboxStyleConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10034a;

    /* renamed from: b  reason: collision with root package name */
    private String f10035b;

    /* renamed from: c  reason: collision with root package name */
    private String f10036c;

    /* renamed from: d  reason: collision with root package name */
    private String f10037d;

    /* renamed from: e  reason: collision with root package name */
    private String f10038e;

    /* renamed from: f  reason: collision with root package name */
    private String f10039f;

    /* renamed from: g  reason: collision with root package name */
    private String f10040g;

    /* renamed from: h  reason: collision with root package name */
    private String f10041h;

    /* renamed from: j  reason: collision with root package name */
    private String f10042j;

    /* renamed from: k  reason: collision with root package name */
    private String f10043k;

    /* renamed from: l  reason: collision with root package name */
    private String f10044l;

    /* renamed from: m  reason: collision with root package name */
    private String[] f10045m;

    /* renamed from: n  reason: collision with root package name */
    private String f10046n;

    class a implements Parcelable.Creator<CTInboxStyleConfig> {
        a() {
        }

        /* renamed from: a */
        public CTInboxStyleConfig createFromParcel(Parcel parcel) {
            return new CTInboxStyleConfig(parcel);
        }

        /* renamed from: b */
        public CTInboxStyleConfig[] newArray(int i10) {
            return new CTInboxStyleConfig[i10];
        }
    }

    public CTInboxStyleConfig() {
        this.f10037d = "#FFFFFF";
        this.f10038e = "App Inbox";
        this.f10039f = "#333333";
        this.f10036c = "#D3D4DA";
        this.f10034a = "#333333";
        this.f10042j = "#1C84FE";
        this.f10046n = "#808080";
        this.f10043k = "#1C84FE";
        this.f10044l = "#FFFFFF";
        this.f10045m = new String[0];
        this.f10040g = "No Message(s) to show";
        this.f10041h = "#000000";
        this.f10035b = "ALL";
    }

    public String a() {
        return this.f10034a;
    }

    public String c() {
        return this.f10035b;
    }

    public String d() {
        return this.f10036c;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f10037d;
    }

    public String f() {
        return this.f10038e;
    }

    public String g() {
        return this.f10039f;
    }

    public String h() {
        return this.f10040g;
    }

    public String i() {
        return this.f10041h;
    }

    public String j() {
        return this.f10042j;
    }

    public String k() {
        return this.f10043k;
    }

    public String l() {
        return this.f10044l;
    }

    public ArrayList<String> m() {
        return this.f10045m == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(this.f10045m));
    }

    public String n() {
        return this.f10046n;
    }

    public boolean o() {
        String[] strArr = this.f10045m;
        return strArr != null && strArr.length > 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10037d);
        parcel.writeString(this.f10038e);
        parcel.writeString(this.f10039f);
        parcel.writeString(this.f10036c);
        parcel.writeStringArray(this.f10045m);
        parcel.writeString(this.f10034a);
        parcel.writeString(this.f10042j);
        parcel.writeString(this.f10046n);
        parcel.writeString(this.f10043k);
        parcel.writeString(this.f10044l);
        parcel.writeString(this.f10040g);
        parcel.writeString(this.f10041h);
        parcel.writeString(this.f10035b);
    }

    protected CTInboxStyleConfig(Parcel parcel) {
        this.f10037d = parcel.readString();
        this.f10038e = parcel.readString();
        this.f10039f = parcel.readString();
        this.f10036c = parcel.readString();
        this.f10045m = parcel.createStringArray();
        this.f10034a = parcel.readString();
        this.f10042j = parcel.readString();
        this.f10046n = parcel.readString();
        this.f10043k = parcel.readString();
        this.f10044l = parcel.readString();
        this.f10040g = parcel.readString();
        this.f10041h = parcel.readString();
        this.f10035b = parcel.readString();
    }
}
