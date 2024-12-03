package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@i(generateAdapter = true)
public final class Id implements Parcelable {
    public static final Parcelable.Creator<Id> CREATOR = new b();

    /* renamed from: f  reason: collision with root package name */
    public static final a f25837f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f25838a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f25839b;

    /* renamed from: c  reason: collision with root package name */
    private final IdIcon f25840c;

    /* renamed from: d  reason: collision with root package name */
    private final List<CapturePageConfig> f25841d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f25842e;

    @i(generateAdapter = true)
    public static final class IdIcon implements Parcelable {
        public static final Parcelable.Creator<IdIcon> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final IdLocalIcon f25843a;

        public static final class a implements Parcelable.Creator<IdIcon> {
            /* renamed from: a */
            public final IdIcon createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new IdIcon(parcel.readInt() == 0 ? null : IdLocalIcon.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final IdIcon[] newArray(int i10) {
                return new IdIcon[i10];
            }
        }

        public IdIcon(IdLocalIcon idLocalIcon) {
            this.f25843a = idLocalIcon;
        }

        public final IdLocalIcon a() {
            return this.f25843a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IdIcon) && this.f25843a == ((IdIcon) obj).f25843a;
        }

        public int hashCode() {
            IdLocalIcon idLocalIcon = this.f25843a;
            if (idLocalIcon == null) {
                return 0;
            }
            return idLocalIcon.hashCode();
        }

        public String toString() {
            return "IdIcon(iconFallback=" + this.f25843a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            IdLocalIcon idLocalIcon = this.f25843a;
            if (idLocalIcon == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(idLocalIcon.name());
        }
    }

    @i(generateAdapter = false)
    public enum IdLocalIcon {
        WORLD,
        CARD,
        FLAG,
        HOUSE
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public static final h c(Type type, Set set, s sVar) {
            Class<IdLocalIcon> cls = IdLocalIcon.class;
            Class<CapturePageConfig.OverlayLocalIcon> cls2 = CapturePageConfig.OverlayLocalIcon.class;
            Class<CapturePageConfig.RuleType> cls3 = CapturePageConfig.RuleType.class;
            if (j.b(type, cls3)) {
                return ai.a.a(cls3).d(null);
            }
            if (j.b(type, cls2)) {
                return ai.a.a(cls2).d(null);
            }
            if (j.b(type, cls)) {
                return ai.a.a(cls).d(null);
            }
            return null;
        }

        public final h.e b() {
            return new c();
        }
    }

    public static final class b implements Parcelable.Creator<Id> {
        /* renamed from: a */
        public final Id createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            IdIcon createFromParcel = parcel.readInt() == 0 ? null : IdIcon.CREATOR.createFromParcel(parcel);
            boolean z10 = false;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(CapturePageConfig.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                if (parcel.readInt() != 0) {
                    z10 = true;
                }
                bool = Boolean.valueOf(z10);
            }
            return new Id(readString, createStringArrayList, createFromParcel, arrayList, bool);
        }

        /* renamed from: b */
        public final Id[] newArray(int i10) {
            return new Id[i10];
        }
    }

    public Id(String str, List<String> list, IdIcon idIcon, List<CapturePageConfig> list2, Boolean bool) {
        j.g(str, "class");
        j.g(list, "requiresSides");
        this.f25838a = str;
        this.f25839b = list;
        this.f25840c = idIcon;
        this.f25841d = list2;
        this.f25842e = bool;
    }

    public final List<CapturePageConfig> a() {
        return this.f25841d;
    }

    public final String c() {
        return this.f25838a;
    }

    public final IdIcon d() {
        return this.f25840c;
    }

    public int describeContents() {
        return 0;
    }

    public final List<String> e() {
        return this.f25839b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Id)) {
            return false;
        }
        Id id2 = (Id) obj;
        return j.b(this.f25838a, id2.f25838a) && j.b(this.f25839b, id2.f25839b) && j.b(this.f25840c, id2.f25840c) && j.b(this.f25841d, id2.f25841d) && j.b(this.f25842e, id2.f25842e);
    }

    public final Boolean f() {
        return this.f25842e;
    }

    public final boolean g() {
        return this.f25841d != null;
    }

    public int hashCode() {
        int hashCode = ((this.f25838a.hashCode() * 31) + this.f25839b.hashCode()) * 31;
        IdIcon idIcon = this.f25840c;
        int i10 = 0;
        int hashCode2 = (hashCode + (idIcon == null ? 0 : idIcon.hashCode())) * 31;
        List<CapturePageConfig> list = this.f25841d;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.f25842e;
        if (bool != null) {
            i10 = bool.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "Id(class=" + this.f25838a + ", requiresSides=" + this.f25839b + ", icon=" + this.f25840c + ", capturePageConfigs=" + this.f25841d + ", supportsPassportNfc=" + this.f25842e + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25838a);
        parcel.writeStringList(this.f25839b);
        IdIcon idIcon = this.f25840c;
        if (idIcon == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            idIcon.writeToParcel(parcel, i10);
        }
        List<CapturePageConfig> list = this.f25841d;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CapturePageConfig writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
        }
        Boolean bool = this.f25842e;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Id(String str, List list, IdIcon idIcon, List list2, Boolean bool, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, idIcon, list2, (i10 & 16) != 0 ? null : bool);
    }
}
