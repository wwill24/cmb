package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@i(generateAdapter = true)
public final class CapturePageConfig implements Parcelable {
    public static final Parcelable.Creator<CapturePageConfig> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25802a;

    /* renamed from: b  reason: collision with root package name */
    private final ManualCaptureConfig f25803b;

    /* renamed from: c  reason: collision with root package name */
    private final AutoCaptureConfig f25804c;

    /* renamed from: d  reason: collision with root package name */
    private final OverlayConfig f25805d;

    @i(generateAdapter = true)
    public static final class AutoCaptureConfig implements Parcelable {
        public static final Parcelable.Creator<AutoCaptureConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<RuleSet> f25806a;

        public static final class a implements Parcelable.Creator<AutoCaptureConfig> {
            /* renamed from: a */
            public final AutoCaptureConfig createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                j.g(parcel, "parcel");
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList2.add(RuleSet.CREATOR.createFromParcel(parcel));
                    }
                    arrayList = arrayList2;
                }
                return new AutoCaptureConfig(arrayList);
            }

            /* renamed from: b */
            public final AutoCaptureConfig[] newArray(int i10) {
                return new AutoCaptureConfig[i10];
            }
        }

        public AutoCaptureConfig(List<RuleSet> list) {
            this.f25806a = list;
        }

        public final List<RuleSet> a() {
            return this.f25806a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AutoCaptureConfig) && j.b(this.f25806a, ((AutoCaptureConfig) obj).f25806a);
        }

        public int hashCode() {
            List<RuleSet> list = this.f25806a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "AutoCaptureConfig(ruleSets=" + this.f25806a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<RuleSet> list = this.f25806a;
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (RuleSet writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
        }
    }

    @i(generateAdapter = true)
    public static final class ManualCaptureConfig implements Parcelable {
        public static final Parcelable.Creator<ManualCaptureConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f25807a;

        /* renamed from: b  reason: collision with root package name */
        private final Long f25808b;

        public static final class a implements Parcelable.Creator<ManualCaptureConfig> {
            /* renamed from: a */
            public final ManualCaptureConfig createFromParcel(Parcel parcel) {
                Boolean bool;
                j.g(parcel, "parcel");
                Long l10 = null;
                if (parcel.readInt() == 0) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                if (parcel.readInt() != 0) {
                    l10 = Long.valueOf(parcel.readLong());
                }
                return new ManualCaptureConfig(bool, l10);
            }

            /* renamed from: b */
            public final ManualCaptureConfig[] newArray(int i10) {
                return new ManualCaptureConfig[i10];
            }
        }

        public ManualCaptureConfig(Boolean bool, Long l10) {
            this.f25807a = bool;
            this.f25808b = l10;
        }

        public final Long a() {
            return this.f25808b;
        }

        public final Boolean c() {
            return this.f25807a;
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
            return j.b(this.f25807a, manualCaptureConfig.f25807a) && j.b(this.f25808b, manualCaptureConfig.f25808b);
        }

        public int hashCode() {
            Boolean bool = this.f25807a;
            int i10 = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Long l10 = this.f25808b;
            if (l10 != null) {
                i10 = l10.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "ManualCaptureConfig(isEnabled=" + this.f25807a + ", delayMs=" + this.f25808b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            Boolean bool = this.f25807a;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Long l10 = this.f25808b;
            if (l10 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeLong(l10.longValue());
        }
    }

    @i(generateAdapter = true)
    public static final class OverlayConfig implements Parcelable {
        public static final Parcelable.Creator<OverlayConfig> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final UiComponent.RemoteImage f25809a;

        /* renamed from: b  reason: collision with root package name */
        private final OverlayLocalIcon f25810b;

        public static final class a implements Parcelable.Creator<OverlayConfig> {
            /* renamed from: a */
            public final OverlayConfig createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new OverlayConfig((UiComponent.RemoteImage) parcel.readParcelable(OverlayConfig.class.getClassLoader()), parcel.readInt() == 0 ? null : OverlayLocalIcon.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final OverlayConfig[] newArray(int i10) {
                return new OverlayConfig[i10];
            }
        }

        public OverlayConfig(UiComponent.RemoteImage remoteImage, OverlayLocalIcon overlayLocalIcon) {
            this.f25809a = remoteImage;
            this.f25810b = overlayLocalIcon;
        }

        public final UiComponent.RemoteImage a() {
            return this.f25809a;
        }

        public final OverlayLocalIcon c() {
            return this.f25810b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OverlayConfig)) {
                return false;
            }
            OverlayConfig overlayConfig = (OverlayConfig) obj;
            return j.b(this.f25809a, overlayConfig.f25809a) && this.f25810b == overlayConfig.f25810b;
        }

        public int hashCode() {
            UiComponent.RemoteImage remoteImage = this.f25809a;
            int i10 = 0;
            int hashCode = (remoteImage == null ? 0 : remoteImage.hashCode()) * 31;
            OverlayLocalIcon overlayLocalIcon = this.f25810b;
            if (overlayLocalIcon != null) {
                i10 = overlayLocalIcon.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "OverlayConfig(overlay=" + this.f25809a + ", overlayFallback=" + this.f25810b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f25809a, i10);
            OverlayLocalIcon overlayLocalIcon = this.f25810b;
            if (overlayLocalIcon == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(overlayLocalIcon.name());
        }
    }

    @i(generateAdapter = false)
    public enum OverlayLocalIcon {
        BARCODE,
        PASSPORT,
        ID_FRONT,
        ID_BACK,
        EMPTY
    }

    @i(generateAdapter = true)
    public static final class Rule implements Parcelable {
        public static final Parcelable.Creator<Rule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final RuleType f25811a;

        /* renamed from: b  reason: collision with root package name */
        private final Boolean f25812b;

        public static final class a implements Parcelable.Creator<Rule> {
            /* renamed from: a */
            public final Rule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                Boolean bool = null;
                RuleType valueOf = parcel.readInt() == 0 ? null : RuleType.valueOf(parcel.readString());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new Rule(valueOf, bool);
            }

            /* renamed from: b */
            public final Rule[] newArray(int i10) {
                return new Rule[i10];
            }
        }

        public Rule(RuleType ruleType, Boolean bool) {
            this.f25811a = ruleType;
            this.f25812b = bool;
        }

        public final RuleType a() {
            return this.f25811a;
        }

        public final Boolean c() {
            return this.f25812b;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Rule)) {
                return false;
            }
            Rule rule = (Rule) obj;
            return this.f25811a == rule.f25811a && j.b(this.f25812b, rule.f25812b);
        }

        public int hashCode() {
            RuleType ruleType = this.f25811a;
            int i10 = 0;
            int hashCode = (ruleType == null ? 0 : ruleType.hashCode()) * 31;
            Boolean bool = this.f25812b;
            if (bool != null) {
                i10 = bool.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "Rule(type=" + this.f25811a + ", isRequired=" + this.f25812b + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            RuleType ruleType = this.f25811a;
            if (ruleType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(ruleType.name());
            }
            Boolean bool = this.f25812b;
            if (bool == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    @i(generateAdapter = true)
    public static final class RuleSet implements Parcelable {
        public static final Parcelable.Creator<RuleSet> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<Rule> f25813a;

        public static final class a implements Parcelable.Creator<RuleSet> {
            /* renamed from: a */
            public final RuleSet createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                j.g(parcel, "parcel");
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList2.add(Rule.CREATOR.createFromParcel(parcel));
                    }
                    arrayList = arrayList2;
                }
                return new RuleSet(arrayList);
            }

            /* renamed from: b */
            public final RuleSet[] newArray(int i10) {
                return new RuleSet[i10];
            }
        }

        public RuleSet(List<Rule> list) {
            this.f25813a = list;
        }

        public final List<Rule> a() {
            return this.f25813a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RuleSet) && j.b(this.f25813a, ((RuleSet) obj).f25813a);
        }

        public int hashCode() {
            List<Rule> list = this.f25813a;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "RuleSet(rules=" + this.f25813a + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            List<Rule> list = this.f25813a;
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Rule writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i10);
            }
        }
    }

    @i(generateAdapter = false)
    public enum RuleType {
        ID_FRONT,
        ID_FRONT_OR_BACK,
        BARCODE_PDF417,
        PASSPORT_MRZ,
        TEXT_EXTRACTION
    }

    public static final class a implements Parcelable.Creator<CapturePageConfig> {
        /* renamed from: a */
        public final CapturePageConfig createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            OverlayConfig overlayConfig = null;
            ManualCaptureConfig createFromParcel = parcel.readInt() == 0 ? null : ManualCaptureConfig.CREATOR.createFromParcel(parcel);
            AutoCaptureConfig createFromParcel2 = parcel.readInt() == 0 ? null : AutoCaptureConfig.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                overlayConfig = OverlayConfig.CREATOR.createFromParcel(parcel);
            }
            return new CapturePageConfig(readString, createFromParcel, createFromParcel2, overlayConfig);
        }

        /* renamed from: b */
        public final CapturePageConfig[] newArray(int i10) {
            return new CapturePageConfig[i10];
        }
    }

    public CapturePageConfig(String str, ManualCaptureConfig manualCaptureConfig, AutoCaptureConfig autoCaptureConfig, OverlayConfig overlayConfig) {
        this.f25802a = str;
        this.f25803b = manualCaptureConfig;
        this.f25804c = autoCaptureConfig;
        this.f25805d = overlayConfig;
    }

    public final AutoCaptureConfig a() {
        return this.f25804c;
    }

    public final ManualCaptureConfig c() {
        return this.f25803b;
    }

    public final OverlayConfig d() {
        return this.f25805d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f25802a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CapturePageConfig)) {
            return false;
        }
        CapturePageConfig capturePageConfig = (CapturePageConfig) obj;
        return j.b(this.f25802a, capturePageConfig.f25802a) && j.b(this.f25803b, capturePageConfig.f25803b) && j.b(this.f25804c, capturePageConfig.f25804c) && j.b(this.f25805d, capturePageConfig.f25805d);
    }

    public int hashCode() {
        String str = this.f25802a;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ManualCaptureConfig manualCaptureConfig = this.f25803b;
        int hashCode2 = (hashCode + (manualCaptureConfig == null ? 0 : manualCaptureConfig.hashCode())) * 31;
        AutoCaptureConfig autoCaptureConfig = this.f25804c;
        int hashCode3 = (hashCode2 + (autoCaptureConfig == null ? 0 : autoCaptureConfig.hashCode())) * 31;
        OverlayConfig overlayConfig = this.f25805d;
        if (overlayConfig != null) {
            i10 = overlayConfig.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "CapturePageConfig(side=" + this.f25802a + ", manualCaptureConfig=" + this.f25803b + ", autoCaptureConfig=" + this.f25804c + ", overlay=" + this.f25805d + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25802a);
        ManualCaptureConfig manualCaptureConfig = this.f25803b;
        if (manualCaptureConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            manualCaptureConfig.writeToParcel(parcel, i10);
        }
        AutoCaptureConfig autoCaptureConfig = this.f25804c;
        if (autoCaptureConfig == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            autoCaptureConfig.writeToParcel(parcel, i10);
        }
        OverlayConfig overlayConfig = this.f25805d;
        if (overlayConfig == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        overlayConfig.writeToParcel(parcel, i10);
    }
}
