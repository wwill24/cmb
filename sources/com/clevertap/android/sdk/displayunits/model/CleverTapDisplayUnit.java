package com.clevertap.android.sdk.displayunits.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.displayunits.CTDisplayUnitType;
import com.clevertap.android.sdk.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.b;

public class CleverTapDisplayUnit implements Parcelable {
    public static final Parcelable.Creator<CleverTapDisplayUnit> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f10188a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<CleverTapDisplayUnitContent> f10189b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, String> f10190c;

    /* renamed from: d  reason: collision with root package name */
    private String f10191d;

    /* renamed from: e  reason: collision with root package name */
    private b f10192e;

    /* renamed from: f  reason: collision with root package name */
    private CTDisplayUnitType f10193f;

    /* renamed from: g  reason: collision with root package name */
    private String f10194g;

    class a implements Parcelable.Creator<CleverTapDisplayUnit> {
        a() {
        }

        /* renamed from: a */
        public CleverTapDisplayUnit createFromParcel(Parcel parcel) {
            return new CleverTapDisplayUnit(parcel, (a) null);
        }

        /* renamed from: b */
        public CleverTapDisplayUnit[] newArray(int i10) {
            return new CleverTapDisplayUnit[i10];
        }
    }

    /* synthetic */ CleverTapDisplayUnit(Parcel parcel, a aVar) {
        this(parcel);
    }

    @NonNull
    public static CleverTapDisplayUnit d(b bVar) {
        String str;
        CTDisplayUnitType cTDisplayUnitType;
        String str2;
        org.json.a aVar;
        b bVar2;
        try {
            if (bVar.has("wzrk_id")) {
                str = bVar.getString("wzrk_id");
            } else {
                str = "0_0";
            }
            String str3 = str;
            if (bVar.has("type")) {
                cTDisplayUnitType = CTDisplayUnitType.a(bVar.getString("type"));
            } else {
                cTDisplayUnitType = null;
            }
            if (bVar.has("bg")) {
                str2 = bVar.getString("bg");
            } else {
                str2 = "";
            }
            String str4 = str2;
            if (bVar.has("content")) {
                aVar = bVar.getJSONArray("content");
            } else {
                aVar = null;
            }
            ArrayList arrayList = new ArrayList();
            if (aVar != null) {
                for (int i10 = 0; i10 < aVar.o(); i10++) {
                    CleverTapDisplayUnitContent a10 = CleverTapDisplayUnitContent.a(aVar.j(i10));
                    if (TextUtils.isEmpty(a10.getError())) {
                        arrayList.add(a10);
                    }
                }
            }
            if (bVar.has("custom_kv")) {
                bVar2 = bVar.getJSONObject("custom_kv");
            } else {
                bVar2 = null;
            }
            return new CleverTapDisplayUnit(bVar, str3, cTDisplayUnitType, str4, arrayList, bVar2, (String) null);
        } catch (Exception e10) {
            p.b("DisplayUnit : ", "Unable to init CleverTapDisplayUnit with JSON - " + e10.getLocalizedMessage());
            return new CleverTapDisplayUnit((b) null, "", (CTDisplayUnitType) null, (String) null, (ArrayList<CleverTapDisplayUnitContent>) null, (b) null, "Error Creating Display Unit from JSON : " + e10.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, String> a(b bVar) {
        if (bVar != null) {
            try {
                Iterator<String> keys = bVar.keys();
                if (keys != null) {
                    HashMap<String, String> hashMap = null;
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = bVar.getString(next);
                        if (!TextUtils.isEmpty(next)) {
                            if (hashMap == null) {
                                hashMap = new HashMap<>();
                            }
                            hashMap.put(next, string);
                        }
                    }
                    return hashMap;
                }
            } catch (Exception e10) {
                p.b("DisplayUnit : ", "Error in getting Key Value Pairs " + e10.getLocalizedMessage());
            }
        }
        return null;
    }

    public String c() {
        return this.f10194g;
    }

    public int describeContents() {
        return 0;
    }

    public String getError() {
        return this.f10191d;
    }

    @NonNull
    public String toString() {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(" Unit id- ");
            sb2.append(this.f10194g);
            sb2.append(", Type- ");
            CTDisplayUnitType cTDisplayUnitType = this.f10193f;
            if (cTDisplayUnitType != null) {
                str = cTDisplayUnitType.toString();
            } else {
                str = null;
            }
            sb2.append(str);
            sb2.append(", bgColor- ");
            sb2.append(this.f10188a);
            ArrayList<CleverTapDisplayUnitContent> arrayList = this.f10189b;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (int i10 = 0; i10 < this.f10189b.size(); i10++) {
                    CleverTapDisplayUnitContent cleverTapDisplayUnitContent = this.f10189b.get(i10);
                    if (cleverTapDisplayUnitContent != null) {
                        sb2.append(", Content Item:");
                        sb2.append(i10);
                        sb2.append(" ");
                        sb2.append(cleverTapDisplayUnitContent.toString());
                        sb2.append("\n");
                    }
                }
            }
            if (this.f10190c != null) {
                sb2.append(", Custom KV:");
                sb2.append(this.f10190c);
            }
            sb2.append(", JSON -");
            sb2.append(this.f10192e);
            sb2.append(", Error-");
            sb2.append(this.f10191d);
            sb2.append(" ]");
            return sb2.toString();
        } catch (Exception e10) {
            p.b("DisplayUnit : ", "Exception in toString:" + e10);
            return super.toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10194g);
        parcel.writeValue(this.f10193f);
        parcel.writeString(this.f10188a);
        if (this.f10189b == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeList(this.f10189b);
        }
        parcel.writeMap(this.f10190c);
        if (this.f10192e == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10192e.toString());
        }
        parcel.writeString(this.f10191d);
    }

    private CleverTapDisplayUnit(b bVar, String str, CTDisplayUnitType cTDisplayUnitType, String str2, ArrayList<CleverTapDisplayUnitContent> arrayList, b bVar2, String str3) {
        this.f10192e = bVar;
        this.f10194g = str;
        this.f10193f = cTDisplayUnitType;
        this.f10188a = str2;
        this.f10189b = arrayList;
        this.f10190c = a(bVar2);
        this.f10191d = str3;
    }

    private CleverTapDisplayUnit(Parcel parcel) {
        try {
            this.f10194g = parcel.readString();
            this.f10193f = (CTDisplayUnitType) parcel.readValue(CTDisplayUnitType.class.getClassLoader());
            this.f10188a = parcel.readString();
            b bVar = null;
            if (parcel.readByte() == 1) {
                ArrayList<CleverTapDisplayUnitContent> arrayList = new ArrayList<>();
                this.f10189b = arrayList;
                parcel.readList(arrayList, CleverTapDisplayUnitContent.class.getClassLoader());
            } else {
                this.f10189b = null;
            }
            this.f10190c = parcel.readHashMap((ClassLoader) null);
            if (parcel.readByte() != 0) {
                bVar = new b(parcel.readString());
            }
            this.f10192e = bVar;
            this.f10191d = parcel.readString();
        } catch (Exception e10) {
            String str = "Error Creating Display Unit from parcel : " + e10.getLocalizedMessage();
            this.f10191d = str;
            p.b("DisplayUnit : ", str);
        }
    }
}
