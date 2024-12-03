package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.camera.AutoCaptureRuleSet;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import gk.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class IdConfig implements Parcelable {
    public static final Parcelable.Creator<IdConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25653a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25654b;

    /* renamed from: c  reason: collision with root package name */
    private final List<IdSideConfig> f25655c;

    /* renamed from: d  reason: collision with root package name */
    private final List<IdPart> f25656d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25657e;

    public static final class IdSideConfig implements Parcelable {
        public static final Parcelable.Creator<IdSideConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f25659a;

        /* renamed from: b  reason: collision with root package name */
        private final Side f25660b;

        /* renamed from: c  reason: collision with root package name */
        private final GovernmentIdWorkflow.Screen.Overlay f25661c;

        /* renamed from: d  reason: collision with root package name */
        private final AutoCaptureConfig f25662d;

        /* renamed from: e  reason: collision with root package name */
        private final ManualCaptureConfig f25663e;

        public static final class a implements Parcelable.Creator<IdSideConfig> {
            /* renamed from: a */
            public final IdSideConfig createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new IdSideConfig(parcel.readString(), Side.valueOf(parcel.readString()), (GovernmentIdWorkflow.Screen.Overlay) parcel.readParcelable(IdSideConfig.class.getClassLoader()), AutoCaptureConfig.CREATOR.createFromParcel(parcel), ManualCaptureConfig.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final IdSideConfig[] newArray(int i10) {
                return new IdSideConfig[i10];
            }
        }

        public IdSideConfig(String str, Side side, GovernmentIdWorkflow.Screen.Overlay overlay, AutoCaptureConfig autoCaptureConfig, ManualCaptureConfig manualCaptureConfig) {
            j.g(str, "sideKey");
            j.g(side, "side");
            j.g(overlay, "overlay");
            j.g(autoCaptureConfig, "autoCaptureConfig");
            j.g(manualCaptureConfig, "manualCaptureConfig");
            this.f25659a = str;
            this.f25660b = side;
            this.f25661c = overlay;
            this.f25662d = autoCaptureConfig;
            this.f25663e = manualCaptureConfig;
        }

        public final AutoCaptureConfig a() {
            return this.f25662d;
        }

        public final ManualCaptureConfig c() {
            return this.f25663e;
        }

        public final GovernmentIdWorkflow.Screen.Overlay d() {
            return this.f25661c;
        }

        public int describeContents() {
            return 0;
        }

        public final Side e() {
            return this.f25660b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdSideConfig)) {
                return false;
            }
            IdSideConfig idSideConfig = (IdSideConfig) obj;
            return j.b(this.f25659a, idSideConfig.f25659a) && this.f25660b == idSideConfig.f25660b && j.b(this.f25661c, idSideConfig.f25661c) && j.b(this.f25662d, idSideConfig.f25662d) && j.b(this.f25663e, idSideConfig.f25663e);
        }

        public int hashCode() {
            return (((((((this.f25659a.hashCode() * 31) + this.f25660b.hashCode()) * 31) + this.f25661c.hashCode()) * 31) + this.f25662d.hashCode()) * 31) + this.f25663e.hashCode();
        }

        public String toString() {
            return "IdSideConfig(sideKey=" + this.f25659a + ", side=" + this.f25660b + ", overlay=" + this.f25661c + ", autoCaptureConfig=" + this.f25662d + ", manualCaptureConfig=" + this.f25663e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f25659a);
            parcel.writeString(this.f25660b.name());
            parcel.writeParcelable(this.f25661c, i10);
            this.f25662d.writeToParcel(parcel, i10);
            this.f25663e.writeToParcel(parcel, i10);
        }
    }

    public static final class ManualCaptureConfig implements Parcelable {
        public static final Parcelable.Creator<ManualCaptureConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f25664a;

        /* renamed from: b  reason: collision with root package name */
        private final long f25665b;

        public static final class a implements Parcelable.Creator<ManualCaptureConfig> {
            /* renamed from: a */
            public final ManualCaptureConfig createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ManualCaptureConfig(parcel.readInt() != 0, parcel.readLong());
            }

            /* renamed from: b */
            public final ManualCaptureConfig[] newArray(int i10) {
                return new ManualCaptureConfig[i10];
            }
        }

        public ManualCaptureConfig(boolean z10, long j10) {
            this.f25664a = z10;
            this.f25665b = j10;
        }

        public final long a() {
            return this.f25665b;
        }

        public final boolean c() {
            return this.f25664a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ManualCaptureConfig)) {
                return false;
            }
            ManualCaptureConfig manualCaptureConfig = (ManualCaptureConfig) obj;
            return this.f25664a == manualCaptureConfig.f25664a && this.f25665b == manualCaptureConfig.f25665b;
        }

        public int hashCode() {
            boolean z10 = this.f25664a;
            if (z10) {
                z10 = true;
            }
            return ((z10 ? 1 : 0) * true) + Long.hashCode(this.f25665b);
        }

        public String toString() {
            return "ManualCaptureConfig(isEnabled=" + this.f25664a + ", delayMs=" + this.f25665b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f25664a ? 1 : 0);
            parcel.writeLong(this.f25665b);
        }
    }

    public enum Side {
        Front("front"),
        Back("back"),
        FrontOrBack("front_or_back"),
        BarcodePdf417("barcode_pdf417"),
        PassportSignature("passport_signature");
        

        /* renamed from: a  reason: collision with root package name */
        public static final a f25666a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final f<Map<String, Side>> f25667b = null;
        private final String key;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map<String, Side> b() {
                return (Map) Side.f25667b.getValue();
            }

            public final Side a(String str) {
                j.g(str, "sideKey");
                return b().get(str);
            }
        }

        static {
            f25666a = new a((DefaultConstructorMarker) null);
            f25667b = b.b(IdConfig$Side$Companion$sideKeyToSide$2.f25674a);
        }

        private Side(String str) {
            this.key = str;
        }

        public final String c() {
            return this.key;
        }
    }

    public static final class a implements Parcelable.Creator<IdConfig> {
        /* renamed from: a */
        public final IdConfig createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i10 = 0; i10 != readInt2; i10++) {
                arrayList.add(IdSideConfig.CREATOR.createFromParcel(parcel));
            }
            int readInt3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt3);
            for (int i11 = 0; i11 != readInt3; i11++) {
                arrayList2.add(parcel.readParcelable(IdConfig.class.getClassLoader()));
            }
            return new IdConfig(readString, readInt, arrayList, arrayList2, parcel.readInt() != 0);
        }

        /* renamed from: b */
        public final IdConfig[] newArray(int i10) {
            return new IdConfig[i10];
        }
    }

    public IdConfig(String str, int i10, List<IdSideConfig> list, List<? extends IdPart> list2, boolean z10) {
        j.g(str, "idClassKey");
        j.g(list, "sideConfigs");
        j.g(list2, "parts");
        this.f25653a = str;
        this.f25654b = i10;
        this.f25655c = list;
        this.f25656d = list2;
        this.f25657e = z10;
    }

    public final int a() {
        return this.f25654b;
    }

    public final List<IdPart> c() {
        return this.f25656d;
    }

    public final IdSideConfig d(Side side) {
        boolean z10;
        j.g(side, "side");
        for (IdSideConfig idSideConfig : this.f25655c) {
            if (idSideConfig.e() == side) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                return idSideConfig;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f25657e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdConfig)) {
            return false;
        }
        IdConfig idConfig = (IdConfig) obj;
        return j.b(this.f25653a, idConfig.f25653a) && this.f25654b == idConfig.f25654b && j.b(this.f25655c, idConfig.f25655c) && j.b(this.f25656d, idConfig.f25656d) && this.f25657e == idConfig.f25657e;
    }

    public final String g1() {
        return this.f25653a;
    }

    public int hashCode() {
        int hashCode = ((((((this.f25653a.hashCode() * 31) + Integer.hashCode(this.f25654b)) * 31) + this.f25655c.hashCode()) * 31) + this.f25656d.hashCode()) * 31;
        boolean z10 = this.f25657e;
        if (z10) {
            z10 = true;
        }
        return hashCode + (z10 ? 1 : 0);
    }

    public String toString() {
        return "IdConfig(idClassKey=" + this.f25653a + ", iconRes=" + this.f25654b + ", sideConfigs=" + this.f25655c + ", parts=" + this.f25656d + ", supportsPassportNfc=" + this.f25657e + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25653a);
        parcel.writeInt(this.f25654b);
        List<IdSideConfig> list = this.f25655c;
        parcel.writeInt(list.size());
        for (IdSideConfig writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i10);
        }
        List<IdPart> list2 = this.f25656d;
        parcel.writeInt(list2.size());
        for (IdPart writeParcelable : list2) {
            parcel.writeParcelable(writeParcelable, i10);
        }
        parcel.writeInt(this.f25657e ? 1 : 0);
    }

    public static final class AutoCaptureConfig implements Parcelable {
        public static final Parcelable.Creator<AutoCaptureConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AutoCaptureRuleSet f25658a;

        public static final class a implements Parcelable.Creator<AutoCaptureConfig> {
            /* renamed from: a */
            public final AutoCaptureConfig createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new AutoCaptureConfig((AutoCaptureRuleSet) parcel.readParcelable(AutoCaptureConfig.class.getClassLoader()));
            }

            /* renamed from: b */
            public final AutoCaptureConfig[] newArray(int i10) {
                return new AutoCaptureConfig[i10];
            }
        }

        public AutoCaptureConfig() {
            this((AutoCaptureRuleSet) null, 1, (DefaultConstructorMarker) null);
        }

        public AutoCaptureConfig(AutoCaptureRuleSet autoCaptureRuleSet) {
            j.g(autoCaptureRuleSet, "ruleSet");
            this.f25658a = autoCaptureRuleSet;
        }

        public final AutoCaptureRuleSet a() {
            return this.f25658a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AutoCaptureConfig) && j.b(this.f25658a, ((AutoCaptureConfig) obj).f25658a);
        }

        public int hashCode() {
            return this.f25658a.hashCode();
        }

        public String toString() {
            return "AutoCaptureConfig(ruleSet=" + this.f25658a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f25658a, i10);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AutoCaptureConfig(AutoCaptureRuleSet autoCaptureRuleSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? new AutoCaptureRuleSet((List) null, 1, (DefaultConstructorMarker) null) : autoCaptureRuleSet);
        }
    }
}
