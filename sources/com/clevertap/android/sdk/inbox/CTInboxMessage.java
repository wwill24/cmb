package com.clevertap.android.sdk.inbox;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.p;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.b;

public class CTInboxMessage implements Parcelable {
    public static final Parcelable.Creator<CTInboxMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10475a;

    /* renamed from: b  reason: collision with root package name */
    private String f10476b;

    /* renamed from: c  reason: collision with root package name */
    private String f10477c;

    /* renamed from: d  reason: collision with root package name */
    private String f10478d;

    /* renamed from: e  reason: collision with root package name */
    private b f10479e;

    /* renamed from: f  reason: collision with root package name */
    private b f10480f;

    /* renamed from: g  reason: collision with root package name */
    private long f10481g;

    /* renamed from: h  reason: collision with root package name */
    private long f10482h;

    /* renamed from: j  reason: collision with root package name */
    private String f10483j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<CTInboxMessageContent> f10484k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10485l;

    /* renamed from: m  reason: collision with root package name */
    private String f10486m;

    /* renamed from: n  reason: collision with root package name */
    private String f10487n;

    /* renamed from: p  reason: collision with root package name */
    private List<String> f10488p;

    /* renamed from: q  reason: collision with root package name */
    private String f10489q;

    /* renamed from: t  reason: collision with root package name */
    private CTInboxMessageType f10490t;

    /* renamed from: w  reason: collision with root package name */
    private b f10491w;

    class a implements Parcelable.Creator<CTInboxMessage> {
        a() {
        }

        /* renamed from: a */
        public CTInboxMessage createFromParcel(Parcel parcel) {
            return new CTInboxMessage(parcel, (a) null);
        }

        /* renamed from: b */
        public CTInboxMessage[] newArray(int i10) {
            return new CTInboxMessage[i10];
        }
    }

    /* synthetic */ CTInboxMessage(Parcel parcel, a aVar) {
        this(parcel);
    }

    public String a() {
        return this.f10476b;
    }

    public ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CTInboxMessageContent> it = e().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m());
        }
        return arrayList;
    }

    public long d() {
        return this.f10481g;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CTInboxMessageContent> e() {
        return this.f10484k;
    }

    public String f() {
        return this.f10486m;
    }

    public String g() {
        return this.f10487n;
    }

    public List<String> h() {
        return this.f10488p;
    }

    public CTInboxMessageType i() {
        return this.f10490t;
    }

    public b j() {
        b bVar = this.f10491w;
        return bVar == null ? new b() : bVar;
    }

    public boolean k() {
        return this.f10485l;
    }

    /* access modifiers changed from: package-private */
    public void l(boolean z10) {
        this.f10485l = z10;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10489q);
        parcel.writeString(this.f10477c);
        parcel.writeString(this.f10483j);
        parcel.writeString(this.f10475a);
        parcel.writeLong(this.f10481g);
        parcel.writeLong(this.f10482h);
        parcel.writeString(this.f10486m);
        if (this.f10480f == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10480f.toString());
        }
        if (this.f10479e == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10479e.toString());
        }
        parcel.writeByte(this.f10485l ? (byte) 1 : 0);
        parcel.writeValue(this.f10490t);
        if (this.f10488p == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f10488p);
        }
        parcel.writeString(this.f10476b);
        if (this.f10484k == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f10484k);
        }
        parcel.writeString(this.f10487n);
        parcel.writeString(this.f10478d);
        if (this.f10491w == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeString(this.f10491w.toString());
    }

    public CTInboxMessage(b bVar) {
        long j10;
        long j11;
        this.f10484k = new ArrayList<>();
        this.f10488p = new ArrayList();
        this.f10480f = bVar;
        try {
            this.f10486m = bVar.has("id") ? bVar.getString("id") : "0";
            this.f10478d = bVar.has("wzrk_id") ? bVar.getString("wzrk_id") : "0_0";
            if (bVar.has("date")) {
                j10 = bVar.getLong("date");
            } else {
                j10 = System.currentTimeMillis() / 1000;
            }
            this.f10481g = j10;
            if (bVar.has("wzrk_ttl")) {
                j11 = bVar.getLong("wzrk_ttl");
            } else {
                j11 = System.currentTimeMillis() + 86400000;
            }
            this.f10482h = j11;
            this.f10485l = bVar.has(Constants.Keys.IS_READ) && bVar.getBoolean(Constants.Keys.IS_READ);
            b bVar2 = null;
            org.json.a jSONArray = bVar.has("tags") ? bVar.getJSONArray("tags") : null;
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    this.f10488p.add(jSONArray.n(i10));
                }
            }
            b jSONObject = bVar.has(SDKConstants.PARAM_DEBUG_MESSAGE) ? bVar.getJSONObject(SDKConstants.PARAM_DEBUG_MESSAGE) : null;
            if (jSONObject != null) {
                String str = "";
                this.f10490t = jSONObject.has("type") ? CTInboxMessageType.a(jSONObject.getString("type")) : CTInboxMessageType.a(str);
                this.f10476b = jSONObject.has("bg") ? jSONObject.getString("bg") : str;
                org.json.a jSONArray2 = jSONObject.has("content") ? jSONObject.getJSONArray("content") : null;
                if (jSONArray2 != null) {
                    for (int i11 = 0; i11 < jSONArray2.o(); i11++) {
                        this.f10484k.add(new CTInboxMessageContent().s(jSONArray2.j(i11)));
                    }
                }
                this.f10487n = jSONObject.has("orientation") ? jSONObject.getString("orientation") : str;
            }
            this.f10491w = bVar.has("wzrkParams") ? bVar.getJSONObject("wzrkParams") : bVar2;
        } catch (JSONException e10) {
            p.o("Unable to init CTInboxMessage with JSON - " + e10.getLocalizedMessage());
        }
    }

    private CTInboxMessage(Parcel parcel) {
        this.f10484k = new ArrayList<>();
        this.f10488p = new ArrayList();
        try {
            this.f10489q = parcel.readString();
            this.f10477c = parcel.readString();
            this.f10483j = parcel.readString();
            this.f10475a = parcel.readString();
            this.f10481g = parcel.readLong();
            this.f10482h = parcel.readLong();
            this.f10486m = parcel.readString();
            b bVar = null;
            this.f10480f = parcel.readByte() == 0 ? null : new b(parcel.readString());
            this.f10479e = parcel.readByte() == 0 ? null : new b(parcel.readString());
            this.f10485l = parcel.readByte() != 0;
            this.f10490t = (CTInboxMessageType) parcel.readValue(CTInboxMessageType.class.getClassLoader());
            if (parcel.readByte() == 1) {
                ArrayList arrayList = new ArrayList();
                this.f10488p = arrayList;
                parcel.readList(arrayList, String.class.getClassLoader());
            } else {
                this.f10488p = null;
            }
            this.f10476b = parcel.readString();
            if (parcel.readByte() == 1) {
                ArrayList<CTInboxMessageContent> arrayList2 = new ArrayList<>();
                this.f10484k = arrayList2;
                parcel.readList(arrayList2, CTInboxMessageContent.class.getClassLoader());
            } else {
                this.f10484k = null;
            }
            this.f10487n = parcel.readString();
            this.f10478d = parcel.readString();
            if (parcel.readByte() != 0) {
                bVar = new b(parcel.readString());
            }
            this.f10491w = bVar;
        } catch (JSONException e10) {
            p.o("Unable to parse CTInboxMessage from parcel - " + e10.getLocalizedMessage());
        }
    }
}
