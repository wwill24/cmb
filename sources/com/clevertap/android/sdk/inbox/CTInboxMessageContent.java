package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.clevertap.android.sdk.p;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.json.JSONException;
import org.json.b;

public class CTInboxMessageContent implements Parcelable {
    public static final Parcelable.Creator<CTInboxMessageContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10492a;

    /* renamed from: b  reason: collision with root package name */
    private String f10493b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f10494c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f10495d;

    /* renamed from: e  reason: collision with root package name */
    private String f10496e;

    /* renamed from: f  reason: collision with root package name */
    private org.json.a f10497f;

    /* renamed from: g  reason: collision with root package name */
    private String f10498g;

    /* renamed from: h  reason: collision with root package name */
    private String f10499h;

    /* renamed from: j  reason: collision with root package name */
    private String f10500j;

    /* renamed from: k  reason: collision with root package name */
    private String f10501k;

    /* renamed from: l  reason: collision with root package name */
    private String f10502l;

    /* renamed from: m  reason: collision with root package name */
    private String f10503m;

    class a implements Parcelable.Creator<CTInboxMessageContent> {
        a() {
        }

        /* renamed from: a */
        public CTInboxMessageContent createFromParcel(Parcel parcel) {
            return new CTInboxMessageContent(parcel);
        }

        /* renamed from: b */
        public CTInboxMessageContent[] newArray(int i10) {
            return new CTInboxMessageContent[i10];
        }
    }

    CTInboxMessageContent() {
    }

    public String a() {
        return this.f10492a;
    }

    public String c() {
        return this.f10493b;
    }

    public String d() {
        return this.f10496e;
    }

    public int describeContents() {
        return 0;
    }

    public String e(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.has("bg")) {
                return bVar.getString("bg");
            }
            return "";
        } catch (JSONException e10) {
            p.o("Unable to get Link Text Color with JSON - " + e10.getLocalizedMessage());
            return null;
        }
    }

    public String f(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.has(Constants.Kinds.COLOR)) {
                return bVar.getString(Constants.Kinds.COLOR);
            }
            return "";
        } catch (JSONException e10) {
            p.o("Unable to get Link Text Color with JSON - " + e10.getLocalizedMessage());
            return null;
        }
    }

    public String g(b bVar) {
        b bVar2;
        if (bVar == null) {
            return "";
        }
        try {
            if (bVar.has("copyText")) {
                bVar2 = bVar.getJSONObject("copyText");
            } else {
                bVar2 = null;
            }
            if (bVar2 == null || !bVar2.has("text")) {
                return "";
            }
            return bVar2.getString("text");
        } catch (JSONException e10) {
            p.o("Unable to get Link Text with JSON - " + e10.getLocalizedMessage());
            return "";
        }
    }

    public HashMap<String, String> h(b bVar) {
        if (bVar != null && bVar.has("kv")) {
            try {
                b jSONObject = bVar.getJSONObject("kv");
                Iterator<String> keys = jSONObject.keys();
                HashMap<String, String> hashMap = new HashMap<>();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next)) {
                        hashMap.put(next, string);
                    }
                }
                if (!hashMap.isEmpty()) {
                    return hashMap;
                }
                return null;
            } catch (JSONException e10) {
                p.o("Unable to get Link Key Value with JSON - " + e10.getLocalizedMessage());
            }
        }
        return null;
    }

    public String i(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.has("text")) {
                return bVar.getString("text");
            }
            return "";
        } catch (JSONException e10) {
            p.o("Unable to get Link Text with JSON - " + e10.getLocalizedMessage());
            return null;
        }
    }

    public String j(b bVar) {
        b bVar2;
        b bVar3;
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.has("url")) {
                bVar2 = bVar.getJSONObject("url");
            } else {
                bVar2 = null;
            }
            if (bVar2 == null) {
                return null;
            }
            if (bVar2.has("android")) {
                bVar3 = bVar2.getJSONObject("android");
            } else {
                bVar3 = null;
            }
            if (bVar3 == null) {
                return "";
            }
            if (bVar3.has("text")) {
                return bVar3.getString("text");
            }
            return "";
        } catch (JSONException e10) {
            p.o("Unable to get Link URL with JSON - " + e10.getLocalizedMessage());
            return null;
        }
    }

    public org.json.a k() {
        return this.f10497f;
    }

    public String l(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.has("type")) {
                return bVar.getString("type");
            }
            return "";
        } catch (JSONException e10) {
            p.o("Unable to get Link Type with JSON - " + e10.getLocalizedMessage());
            return null;
        }
    }

    public String m() {
        return this.f10498g;
    }

    public String n() {
        return this.f10499h;
    }

    public String o() {
        return this.f10500j;
    }

    public String p() {
        return this.f10501k;
    }

    public String q() {
        return this.f10502l;
    }

    public String r() {
        return this.f10503m;
    }

    /* access modifiers changed from: package-private */
    public CTInboxMessageContent s(b bVar) {
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        boolean z10;
        b bVar7;
        org.json.a aVar;
        b bVar8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        b bVar9 = bVar;
        try {
            if (bVar9.has("title")) {
                bVar2 = bVar9.getJSONObject("title");
            } else {
                bVar2 = null;
            }
            String str9 = "";
            if (bVar2 != null) {
                if (bVar2.has("text")) {
                    str7 = bVar2.getString("text");
                } else {
                    str7 = str9;
                }
                this.f10502l = str7;
                if (bVar2.has(Constants.Kinds.COLOR)) {
                    str8 = bVar2.getString(Constants.Kinds.COLOR);
                } else {
                    str8 = str9;
                }
                this.f10503m = str8;
            }
            if (bVar9.has("message")) {
                bVar3 = bVar9.getJSONObject("message");
            } else {
                bVar3 = null;
            }
            if (bVar3 != null) {
                if (bVar3.has("text")) {
                    str5 = bVar3.getString("text");
                } else {
                    str5 = str9;
                }
                this.f10499h = str5;
                if (bVar3.has(Constants.Kinds.COLOR)) {
                    str6 = bVar3.getString(Constants.Kinds.COLOR);
                } else {
                    str6 = str9;
                }
                this.f10500j = str6;
            }
            if (bVar9.has(SoftwareInfoForm.ICON)) {
                bVar4 = bVar9.getJSONObject(SoftwareInfoForm.ICON);
            } else {
                bVar4 = null;
            }
            if (bVar4 != null) {
                if (bVar4.has("url")) {
                    str4 = bVar4.getString("url");
                } else {
                    str4 = str9;
                }
                this.f10496e = str4;
            }
            if (bVar9.has("media")) {
                bVar5 = bVar9.getJSONObject("media");
            } else {
                bVar5 = null;
            }
            if (bVar5 != null) {
                if (bVar5.has("url")) {
                    str = bVar5.getString("url");
                } else {
                    str = str9;
                }
                this.f10498g = str;
                if (bVar5.has(FirebaseAnalytics.Param.CONTENT_TYPE)) {
                    str2 = bVar5.getString(FirebaseAnalytics.Param.CONTENT_TYPE);
                } else {
                    str2 = str9;
                }
                this.f10493b = str2;
                if (bVar5.has("poster")) {
                    str3 = bVar5.getString("poster");
                } else {
                    str3 = str9;
                }
                this.f10501k = str3;
            }
            if (bVar9.has("action")) {
                bVar6 = bVar9.getJSONObject("action");
            } else {
                bVar6 = null;
            }
            if (bVar6 != null) {
                boolean z11 = true;
                if (!bVar6.has("hasUrl") || !bVar6.getBoolean("hasUrl")) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.f10495d = Boolean.valueOf(z10);
                if (!bVar6.has("hasLinks") || !bVar6.getBoolean("hasLinks")) {
                    z11 = false;
                }
                this.f10494c = Boolean.valueOf(z11);
                if (bVar6.has("url")) {
                    bVar7 = bVar6.getJSONObject("url");
                } else {
                    bVar7 = null;
                }
                if (bVar7 != null && this.f10495d.booleanValue()) {
                    if (bVar7.has("android")) {
                        bVar8 = bVar7.getJSONObject("android");
                    } else {
                        bVar8 = null;
                    }
                    if (bVar8 != null) {
                        if (bVar8.has("text")) {
                            str9 = bVar8.getString("text");
                        }
                        this.f10492a = str9;
                    }
                }
                if (bVar7 != null && this.f10494c.booleanValue()) {
                    if (bVar6.has("links")) {
                        aVar = bVar6.getJSONArray("links");
                    } else {
                        aVar = null;
                    }
                    this.f10497f = aVar;
                }
            }
        } catch (JSONException e10) {
            p.o("Unable to init CTInboxMessageContent with JSON - " + e10.getLocalizedMessage());
        }
        return this;
    }

    public boolean t() {
        String c10 = c();
        if (c10 == null || this.f10498g == null || !c10.startsWith("audio")) {
            return false;
        }
        return true;
    }

    public boolean u() {
        String c10 = c();
        if (c10 == null || this.f10498g == null || !c10.equals("image/gif")) {
            return false;
        }
        return true;
    }

    public boolean w() {
        String c10 = c();
        if (c10 == null || this.f10498g == null || !c10.startsWith("image") || c10.equals("image/gif")) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10502l);
        parcel.writeString(this.f10503m);
        parcel.writeString(this.f10499h);
        parcel.writeString(this.f10500j);
        parcel.writeString(this.f10498g);
        parcel.writeByte(this.f10495d.booleanValue() ? (byte) 1 : 0);
        parcel.writeByte(this.f10494c.booleanValue() ? (byte) 1 : 0);
        parcel.writeString(this.f10492a);
        parcel.writeString(this.f10496e);
        if (this.f10497f == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10497f.toString());
        }
        parcel.writeString(this.f10493b);
        parcel.writeString(this.f10501k);
    }

    public boolean x() {
        String c10 = c();
        if (c10 == null || this.f10498g == null || !c10.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
            return false;
        }
        return true;
    }

    protected CTInboxMessageContent(Parcel parcel) {
        this.f10502l = parcel.readString();
        this.f10503m = parcel.readString();
        this.f10499h = parcel.readString();
        this.f10500j = parcel.readString();
        this.f10498g = parcel.readString();
        boolean z10 = true;
        this.f10495d = Boolean.valueOf(parcel.readByte() != 0);
        this.f10494c = Boolean.valueOf(parcel.readByte() == 0 ? false : z10);
        this.f10492a = parcel.readString();
        this.f10496e = parcel.readString();
        try {
            this.f10497f = parcel.readByte() == 0 ? null : new org.json.a(parcel.readString());
        } catch (JSONException e10) {
            p.o("Unable to init CTInboxMessageContent with Parcel - " + e10.getLocalizedMessage());
        }
        this.f10493b = parcel.readString();
        this.f10501k = parcel.readString();
    }
}
