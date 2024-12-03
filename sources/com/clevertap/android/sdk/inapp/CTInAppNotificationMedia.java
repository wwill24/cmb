package com.clevertap.android.sdk.inapp;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.p;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.UUID;
import org.json.JSONException;
import org.json.b;

public class CTInAppNotificationMedia implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotificationMedia> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    int f10324a;

    /* renamed from: b  reason: collision with root package name */
    private String f10325b;

    /* renamed from: c  reason: collision with root package name */
    private String f10326c;

    /* renamed from: d  reason: collision with root package name */
    private String f10327d;

    class a implements Parcelable.Creator<CTInAppNotificationMedia> {
        a() {
        }

        /* renamed from: a */
        public CTInAppNotificationMedia createFromParcel(Parcel parcel) {
            return new CTInAppNotificationMedia(parcel, (a) null);
        }

        /* renamed from: b */
        public CTInAppNotificationMedia[] newArray(int i10) {
            return new CTInAppNotificationMedia[i10];
        }
    }

    /* synthetic */ CTInAppNotificationMedia(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f10325b;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f10326c;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f10327d;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f10324a;
    }

    /* access modifiers changed from: package-private */
    public CTInAppNotificationMedia f(b bVar, int i10) {
        String str;
        this.f10324a = i10;
        try {
            String str2 = "";
            if (bVar.has(FirebaseAnalytics.Param.CONTENT_TYPE)) {
                str = bVar.getString(FirebaseAnalytics.Param.CONTENT_TYPE);
            } else {
                str = str2;
            }
            this.f10326c = str;
            if (bVar.has("url")) {
                str2 = bVar.getString("url");
            }
            if (!str2.isEmpty()) {
                if (this.f10326c.startsWith("image")) {
                    this.f10327d = str2;
                    if (bVar.has(SDKConstants.PARAM_KEY)) {
                        this.f10325b = UUID.randomUUID().toString() + bVar.getString(SDKConstants.PARAM_KEY);
                    } else {
                        this.f10325b = UUID.randomUUID().toString();
                    }
                } else {
                    this.f10327d = str2;
                }
            }
        } catch (JSONException e10) {
            p.o("Error parsing Media JSONObject - " + e10.getLocalizedMessage());
        }
        if (this.f10326c.isEmpty()) {
            return null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        String c10 = c();
        if (c10 == null || this.f10327d == null || !c10.startsWith("audio")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        String c10 = c();
        if (c10 == null || this.f10327d == null || !c10.equals("image/gif")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        String c10 = c();
        if (c10 == null || this.f10327d == null || !c10.startsWith("image") || c10.equals("image/gif")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        String c10 = c();
        if (c10 == null || this.f10327d == null || !c10.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void k(String str) {
        this.f10327d = str;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10327d);
        parcel.writeString(this.f10326c);
        parcel.writeString(this.f10325b);
        parcel.writeInt(this.f10324a);
    }

    CTInAppNotificationMedia() {
    }

    private CTInAppNotificationMedia(Parcel parcel) {
        this.f10327d = parcel.readString();
        this.f10326c = parcel.readString();
        this.f10325b = parcel.readString();
        this.f10324a = parcel.readInt();
    }
}
