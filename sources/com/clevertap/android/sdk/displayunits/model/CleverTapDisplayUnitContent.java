package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.json.b;

public class CleverTapDisplayUnitContent implements Parcelable {
    public static final Parcelable.Creator<CleverTapDisplayUnitContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10195a;

    /* renamed from: b  reason: collision with root package name */
    private String f10196b;

    /* renamed from: c  reason: collision with root package name */
    private String f10197c;

    /* renamed from: d  reason: collision with root package name */
    private String f10198d;

    /* renamed from: e  reason: collision with root package name */
    private String f10199e;

    /* renamed from: f  reason: collision with root package name */
    private String f10200f;

    /* renamed from: g  reason: collision with root package name */
    private String f10201g;

    /* renamed from: h  reason: collision with root package name */
    private String f10202h;

    /* renamed from: j  reason: collision with root package name */
    private String f10203j;

    /* renamed from: k  reason: collision with root package name */
    private String f10204k;

    class a implements Parcelable.Creator<CleverTapDisplayUnitContent> {
        a() {
        }

        /* renamed from: a */
        public CleverTapDisplayUnitContent createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnitContent(parcel, (a) null);
        }

        /* renamed from: b */
        public CleverTapDisplayUnitContent[] newArray(int i10) {
            return new CleverTapDisplayUnitContent[i10];
        }
    }

    /* synthetic */ CleverTapDisplayUnitContent(Parcel parcel, a aVar) {
        this(parcel);
    }

    static CleverTapDisplayUnitContent a(b bVar) {
        b bVar2;
        String str;
        String str2;
        b bVar3;
        String str3;
        String str4;
        b bVar4;
        String str5;
        b bVar5;
        String str6;
        String str7;
        String str8;
        b bVar6;
        b bVar7;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        b bVar8 = bVar;
        try {
            b bVar9 = null;
            if (bVar8.has("title")) {
                bVar2 = bVar8.getJSONObject("title");
            } else {
                bVar2 = null;
            }
            String str17 = "";
            if (bVar2 != null) {
                if (bVar2.has("text")) {
                    str15 = bVar2.getString("text");
                } else {
                    str15 = str17;
                }
                if (bVar2.has(Constants.Kinds.COLOR)) {
                    str16 = bVar2.getString(Constants.Kinds.COLOR);
                } else {
                    str16 = str17;
                }
                str = str16;
                str2 = str15;
            } else {
                str2 = str17;
                str = str2;
            }
            if (bVar8.has("message")) {
                bVar3 = bVar8.getJSONObject("message");
            } else {
                bVar3 = null;
            }
            if (bVar3 != null) {
                if (bVar3.has("text")) {
                    str13 = bVar3.getString("text");
                } else {
                    str13 = str17;
                }
                if (bVar3.has(Constants.Kinds.COLOR)) {
                    str14 = bVar3.getString(Constants.Kinds.COLOR);
                } else {
                    str14 = str17;
                }
                str3 = str14;
                str4 = str13;
            } else {
                str4 = str17;
                str3 = str4;
            }
            if (bVar8.has(SoftwareInfoForm.ICON)) {
                bVar4 = bVar8.getJSONObject(SoftwareInfoForm.ICON);
            } else {
                bVar4 = null;
            }
            if (bVar4 != null) {
                if (bVar4.has("url")) {
                    str12 = bVar4.getString("url");
                } else {
                    str12 = str17;
                }
                str5 = str12;
            } else {
                str5 = str17;
            }
            if (bVar8.has("media")) {
                bVar5 = bVar8.getJSONObject("media");
            } else {
                bVar5 = null;
            }
            if (bVar5 != null) {
                if (bVar5.has("url")) {
                    str9 = bVar5.getString("url");
                } else {
                    str9 = str17;
                }
                if (bVar5.has(FirebaseAnalytics.Param.CONTENT_TYPE)) {
                    str10 = bVar5.getString(FirebaseAnalytics.Param.CONTENT_TYPE);
                } else {
                    str10 = str17;
                }
                if (bVar5.has("poster")) {
                    str11 = bVar5.getString("poster");
                } else {
                    str11 = str17;
                }
                str6 = str11;
                str7 = str10;
                str8 = str9;
            } else {
                str8 = str17;
                str7 = str8;
                str6 = str7;
            }
            if (bVar8.has("action")) {
                bVar6 = bVar8.getJSONObject("action");
            } else {
                bVar6 = null;
            }
            if (bVar6 != null) {
                if (bVar6.has("url")) {
                    bVar7 = bVar6.getJSONObject("url");
                } else {
                    bVar7 = null;
                }
                if (bVar7 != null) {
                    if (bVar7.has("android")) {
                        bVar9 = bVar7.getJSONObject("android");
                    }
                    if (bVar9 != null && bVar9.has("text")) {
                        str17 = bVar9.getString("text");
                    }
                }
            }
            return new CleverTapDisplayUnitContent(str2, str, str4, str3, str5, str8, str7, str6, str17, (String) null);
        } catch (Exception e10) {
            p.b("DisplayUnit : ", "Unable to init CleverTapDisplayUnitContent with JSON - " + e10.getLocalizedMessage());
            return new CleverTapDisplayUnitContent("", "", "", "", "", "", "", "", "", "Error Creating DisplayUnit Content from JSON : " + e10.getLocalizedMessage());
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getError() {
        return this.f10197c;
    }

    @NonNull
    public String toString() {
        return "[ title:" + this.f10203j + ", titleColor:" + this.f10204k + " message:" + this.f10200f + ", messageColor:" + this.f10201g + ", media:" + this.f10199e + ", contentType:" + this.f10196b + ", posterUrl:" + this.f10202h + ", actionUrl:" + this.f10195a + ", icon:" + this.f10198d + ", error:" + this.f10197c + " ]";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10203j);
        parcel.writeString(this.f10204k);
        parcel.writeString(this.f10200f);
        parcel.writeString(this.f10201g);
        parcel.writeString(this.f10198d);
        parcel.writeString(this.f10199e);
        parcel.writeString(this.f10196b);
        parcel.writeString(this.f10202h);
        parcel.writeString(this.f10195a);
        parcel.writeString(this.f10197c);
    }

    private CleverTapDisplayUnitContent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f10203j = str;
        this.f10204k = str2;
        this.f10200f = str3;
        this.f10201g = str4;
        this.f10198d = str5;
        this.f10199e = str6;
        this.f10196b = str7;
        this.f10202h = str8;
        this.f10195a = str9;
        this.f10197c = str10;
    }

    private CleverTapDisplayUnitContent(Parcel parcel) {
        this.f10203j = parcel.readString();
        this.f10204k = parcel.readString();
        this.f10200f = parcel.readString();
        this.f10201g = parcel.readString();
        this.f10198d = parcel.readString();
        this.f10199e = parcel.readString();
        this.f10196b = parcel.readString();
        this.f10202h = parcel.readString();
        this.f10195a = parcel.readString();
        this.f10197c = parcel.readString();
    }
}
