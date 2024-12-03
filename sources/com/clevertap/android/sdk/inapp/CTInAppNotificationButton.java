package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.leanplum.internal.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.b;

public class CTInAppNotificationButton implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotificationButton> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10315a;

    /* renamed from: b  reason: collision with root package name */
    private String f10316b;

    /* renamed from: c  reason: collision with root package name */
    private String f10317c;

    /* renamed from: d  reason: collision with root package name */
    private String f10318d;

    /* renamed from: e  reason: collision with root package name */
    private String f10319e;

    /* renamed from: f  reason: collision with root package name */
    private b f10320f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, String> f10321g;

    /* renamed from: h  reason: collision with root package name */
    private String f10322h;

    /* renamed from: j  reason: collision with root package name */
    private String f10323j;

    class a implements Parcelable.Creator<CTInAppNotificationButton> {
        a() {
        }

        /* renamed from: a */
        public CTInAppNotificationButton createFromParcel(Parcel parcel) {
            return new CTInAppNotificationButton(parcel);
        }

        /* renamed from: b */
        public CTInAppNotificationButton[] newArray(int i10) {
            return new CTInAppNotificationButton[i10];
        }
    }

    CTInAppNotificationButton() {
    }

    private boolean j(b bVar) throws JSONException {
        if (bVar == null || !bVar.has("type") || !"kv".equalsIgnoreCase(bVar.getString("type")) || !bVar.has("kv")) {
            return false;
        }
        return true;
    }

    public String a() {
        return this.f10315a;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f10316b;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f10317c;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.f10318d;
    }

    public HashMap<String, String> f() {
        return this.f10321g;
    }

    public String g() {
        return this.f10322h;
    }

    /* access modifiers changed from: package-private */
    public String getError() {
        return this.f10319e;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return this.f10323j;
    }

    /* access modifiers changed from: package-private */
    public CTInAppNotificationButton i(b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        b bVar2;
        b jSONObject;
        Iterator<String> keys;
        try {
            this.f10320f = bVar;
            String str5 = "";
            if (bVar.has("text")) {
                str = bVar.getString("text");
            } else {
                str = str5;
            }
            this.f10322h = str;
            if (bVar.has(Constants.Kinds.COLOR)) {
                str2 = bVar.getString(Constants.Kinds.COLOR);
            } else {
                str2 = "#0000FF";
            }
            this.f10323j = str2;
            String str6 = "#FFFFFF";
            if (bVar.has("bg")) {
                str3 = bVar.getString("bg");
            } else {
                str3 = str6;
            }
            this.f10316b = str3;
            if (bVar.has("border")) {
                str6 = bVar.getString("border");
            }
            this.f10317c = str6;
            if (bVar.has("radius")) {
                str4 = bVar.getString("radius");
            } else {
                str4 = str5;
            }
            this.f10318d = str4;
            if (bVar.has("actions")) {
                bVar2 = bVar.getJSONObject("actions");
            } else {
                bVar2 = null;
            }
            if (bVar2 != null) {
                if (bVar2.has("android")) {
                    str5 = bVar2.getString("android");
                }
                if (!str5.isEmpty()) {
                    this.f10315a = str5;
                }
            }
            if (!(!j(bVar2) || (jSONObject = bVar2.getJSONObject("kv")) == null || (keys = jSONObject.keys()) == null)) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next)) {
                        if (this.f10321g == null) {
                            this.f10321g = new HashMap<>();
                        }
                        this.f10321g.put(next, string);
                    }
                }
            }
        } catch (JSONException unused) {
            this.f10319e = "Invalid JSON";
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10322h);
        parcel.writeString(this.f10323j);
        parcel.writeString(this.f10316b);
        parcel.writeString(this.f10315a);
        parcel.writeString(this.f10317c);
        parcel.writeString(this.f10318d);
        if (this.f10320f == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10320f.toString());
        }
        parcel.writeString(this.f10319e);
        parcel.writeMap(this.f10321g);
    }

    protected CTInAppNotificationButton(Parcel parcel) {
        this.f10322h = parcel.readString();
        this.f10323j = parcel.readString();
        this.f10316b = parcel.readString();
        this.f10315a = parcel.readString();
        this.f10317c = parcel.readString();
        this.f10318d = parcel.readString();
        try {
            this.f10320f = parcel.readByte() == 0 ? null : new b(parcel.readString());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        this.f10319e = parcel.readString();
        this.f10321g = parcel.readHashMap((ClassLoader) null);
    }
}
