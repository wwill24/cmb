package com.withpersona.sdk2.inquiry.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.withpersona.sdk2.inquiry.document.DocumentPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.StaticInquiryTemplate;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class InquiryState implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final String f26159a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26160b;

    /* renamed from: c  reason: collision with root package name */
    private final TransitionStatus f26161c;

    /* renamed from: d  reason: collision with root package name */
    private final StepStyle f26162d;

    /* renamed from: e  reason: collision with root package name */
    private final NextStep.CancelDialog f26163e;

    /* renamed from: f  reason: collision with root package name */
    private final String f26164f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26165g;

    public static final class Complete extends InquiryState {
        public static final Parcelable.Creator<Complete> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26166h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26167j;

        /* renamed from: k  reason: collision with root package name */
        private final TransitionStatus f26168k;

        /* renamed from: l  reason: collision with root package name */
        private final String f26169l;

        /* renamed from: m  reason: collision with root package name */
        private final Map<String, InquiryField> f26170m;

        public static final class a implements Parcelable.Creator<Complete> {
            /* renamed from: a */
            public final Complete createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                TransitionStatus valueOf = parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString());
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    linkedHashMap.put(parcel.readString(), parcel.readParcelable(Complete.class.getClassLoader()));
                }
                return new Complete(readString, readString2, valueOf, readString3, linkedHashMap);
            }

            /* renamed from: b */
            public final Complete[] newArray(int i10) {
                return new Complete[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Complete(String str, String str2, TransitionStatus transitionStatus, String str3, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : transitionStatus, str3, map);
        }

        public String c() {
            return this.f26166h;
        }

        public String d() {
            return this.f26167j;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Complete)) {
                return false;
            }
            Complete complete = (Complete) obj;
            return j.b(c(), complete.c()) && j.b(d(), complete.d()) && g() == complete.g() && j.b(this.f26169l, complete.f26169l) && j.b(this.f26170m, complete.f26170m);
        }

        public TransitionStatus g() {
            return this.f26168k;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((c().hashCode() * 31) + d().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31;
            String str = this.f26169l;
            if (str != null) {
                i10 = str.hashCode();
            }
            return ((hashCode + i10) * 31) + this.f26170m.hashCode();
        }

        public final Map<String, InquiryField> i() {
            return this.f26170m;
        }

        public final String j() {
            return this.f26169l;
        }

        public String toString() {
            return "Complete(inquiryId=" + c() + ", sessionToken=" + d() + ", transitionStatus=" + g() + ", inquiryStatus=" + this.f26169l + ", fields=" + this.f26170m + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26166h);
            parcel.writeString(this.f26167j);
            TransitionStatus transitionStatus = this.f26168k;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeString(this.f26169l);
            Map<String, InquiryField> map = this.f26170m;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeParcelable((Parcelable) next.getValue(), i10);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Complete(String str, String str2, TransitionStatus transitionStatus, String str3, Map<String, ? extends InquiryField> map) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            j.g(str, "inquiryId");
            j.g(str2, "sessionToken");
            j.g(map, "fields");
            this.f26166h = str;
            this.f26167j = str2;
            this.f26168k = transitionStatus;
            this.f26169l = str3;
            this.f26170m = map;
        }
    }

    public static final class CreateInquiryFromTemplate extends InquiryState {
        public static final Parcelable.Creator<CreateInquiryFromTemplate> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26171h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26172j;

        /* renamed from: k  reason: collision with root package name */
        private final String f26173k;

        /* renamed from: l  reason: collision with root package name */
        private final String f26174l;

        /* renamed from: m  reason: collision with root package name */
        private final Map<String, InquiryField> f26175m;

        /* renamed from: n  reason: collision with root package name */
        private final StaticInquiryTemplate f26176n;

        /* renamed from: p  reason: collision with root package name */
        private final boolean f26177p;

        public static final class a implements Parcelable.Creator<CreateInquiryFromTemplate> {
            /* renamed from: a */
            public final CreateInquiryFromTemplate createFromParcel(Parcel parcel) {
                LinkedHashMap linkedHashMap;
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                if (parcel.readInt() == 0) {
                    linkedHashMap = null;
                } else {
                    int readInt = parcel.readInt();
                    linkedHashMap = new LinkedHashMap(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        linkedHashMap.put(parcel.readString(), parcel.readParcelable(CreateInquiryFromTemplate.class.getClassLoader()));
                    }
                }
                return new CreateInquiryFromTemplate(readString, readString2, readString3, readString4, linkedHashMap, (StaticInquiryTemplate) parcel.readParcelable(CreateInquiryFromTemplate.class.getClassLoader()), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final CreateInquiryFromTemplate[] newArray(int i10) {
                return new CreateInquiryFromTemplate[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateInquiryFromTemplate(String str, String str2, String str3, String str4, Map<String, ? extends InquiryField> map, StaticInquiryTemplate staticInquiryTemplate, boolean z10) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            this.f26171h = str;
            this.f26172j = str2;
            this.f26173k = str3;
            this.f26174l = str4;
            this.f26175m = map;
            this.f26176n = staticInquiryTemplate;
            this.f26177p = z10;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreateInquiryFromTemplate)) {
                return false;
            }
            CreateInquiryFromTemplate createInquiryFromTemplate = (CreateInquiryFromTemplate) obj;
            return j.b(this.f26171h, createInquiryFromTemplate.f26171h) && j.b(this.f26172j, createInquiryFromTemplate.f26172j) && j.b(this.f26173k, createInquiryFromTemplate.f26173k) && j.b(this.f26174l, createInquiryFromTemplate.f26174l) && j.b(this.f26175m, createInquiryFromTemplate.f26175m) && j.b(this.f26176n, createInquiryFromTemplate.f26176n) && this.f26177p == createInquiryFromTemplate.f26177p;
        }

        public int hashCode() {
            String str = this.f26171h;
            int i10 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f26172j;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f26173k;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f26174l;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Map<String, InquiryField> map = this.f26175m;
            int hashCode5 = (hashCode4 + (map == null ? 0 : map.hashCode())) * 31;
            StaticInquiryTemplate staticInquiryTemplate = this.f26176n;
            if (staticInquiryTemplate != null) {
                i10 = staticInquiryTemplate.hashCode();
            }
            int i11 = (hashCode5 + i10) * 31;
            boolean z10 = this.f26177p;
            if (z10) {
                z10 = true;
            }
            return i11 + (z10 ? 1 : 0);
        }

        public final String i() {
            return this.f26173k;
        }

        public final Map<String, InquiryField> j() {
            return this.f26175m;
        }

        public final String k() {
            return this.f26174l;
        }

        public final String l() {
            return this.f26171h;
        }

        public final String m() {
            return this.f26172j;
        }

        public String toString() {
            return "CreateInquiryFromTemplate(templateId=" + this.f26171h + ", templateVersion=" + this.f26172j + ", accountId=" + this.f26173k + ", referenceId=" + this.f26174l + ", fields=" + this.f26175m + ", staticInquiryTemplate=" + this.f26176n + ", shouldAutoFallback=" + this.f26177p + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26171h);
            parcel.writeString(this.f26172j);
            parcel.writeString(this.f26173k);
            parcel.writeString(this.f26174l);
            Map<String, InquiryField> map = this.f26175m;
            if (map == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(map.size());
                for (Map.Entry next : map.entrySet()) {
                    parcel.writeString((String) next.getKey());
                    parcel.writeParcelable((Parcelable) next.getValue(), i10);
                }
            }
            parcel.writeParcelable(this.f26176n, i10);
            parcel.writeInt(this.f26177p ? 1 : 0);
        }
    }

    public static final class CreateInquirySession extends InquiryState {
        public static final Parcelable.Creator<CreateInquirySession> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26178h;

        public static final class a implements Parcelable.Creator<CreateInquirySession> {
            /* renamed from: a */
            public final CreateInquirySession createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new CreateInquirySession(parcel.readString());
            }

            /* renamed from: b */
            public final CreateInquirySession[] newArray(int i10) {
                return new CreateInquirySession[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreateInquirySession(String str) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            j.g(str, "inquiryId");
            this.f26178h = str;
        }

        public String c() {
            return this.f26178h;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CreateInquirySession) && j.b(c(), ((CreateInquirySession) obj).c());
        }

        public int hashCode() {
            return c().hashCode();
        }

        public String toString() {
            return "CreateInquirySession(inquiryId=" + c() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26178h);
        }
    }

    public static final class DocumentStepRunning extends InquiryState implements r {
        public static final Parcelable.Creator<DocumentStepRunning> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26179h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26180j;

        /* renamed from: k  reason: collision with root package name */
        private final TransitionStatus f26181k;

        /* renamed from: l  reason: collision with root package name */
        private final StepStyles$DocumentStepStyle f26182l;

        /* renamed from: m  reason: collision with root package name */
        private final NextStep.CancelDialog f26183m;

        /* renamed from: n  reason: collision with root package name */
        private final NextStep.Document f26184n;

        /* renamed from: p  reason: collision with root package name */
        private final String f26185p;

        /* renamed from: q  reason: collision with root package name */
        private final DocumentPages f26186q;

        /* renamed from: t  reason: collision with root package name */
        private final String f26187t;

        public static final class a implements Parcelable.Creator<DocumentStepRunning> {
            /* renamed from: a */
            public final DocumentStepRunning createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                NextStep.CancelDialog cancelDialog = null;
                TransitionStatus valueOf = parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString());
                StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = (StepStyles$DocumentStepStyle) parcel.readParcelable(DocumentStepRunning.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    cancelDialog = NextStep.CancelDialog.CREATOR.createFromParcel(parcel);
                }
                return new DocumentStepRunning(readString, readString2, valueOf, stepStyles$DocumentStepStyle, cancelDialog, NextStep.Document.CREATOR.createFromParcel(parcel), parcel.readString(), (DocumentPages) parcel.readParcelable(DocumentStepRunning.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: b */
            public final DocumentStepRunning[] newArray(int i10) {
                return new DocumentStepRunning[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DocumentStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle, NextStep.CancelDialog cancelDialog, NextStep.Document document, String str3, DocumentPages documentPages, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : transitionStatus, stepStyles$DocumentStepStyle, cancelDialog, document, str3, documentPages, str4);
        }

        public static /* synthetic */ DocumentStepRunning j(DocumentStepRunning documentStepRunning, String str, String str2, TransitionStatus transitionStatus, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle, NextStep.CancelDialog cancelDialog, NextStep.Document document, String str3, DocumentPages documentPages, String str4, int i10, Object obj) {
            DocumentStepRunning documentStepRunning2 = documentStepRunning;
            int i11 = i10;
            return documentStepRunning.i((i11 & 1) != 0 ? documentStepRunning.c() : str, (i11 & 2) != 0 ? documentStepRunning.d() : str2, (i11 & 4) != 0 ? documentStepRunning.g() : transitionStatus, (i11 & 8) != 0 ? documentStepRunning.b() : stepStyles$DocumentStepStyle, (i11 & 16) != 0 ? documentStepRunning.a() : cancelDialog, (i11 & 32) != 0 ? documentStepRunning2.f26184n : document, (i11 & 64) != 0 ? documentStepRunning2.f26185p : str3, (i11 & 128) != 0 ? documentStepRunning2.f26186q : documentPages, (i11 & 256) != 0 ? documentStepRunning.f() : str4);
        }

        public NextStep.CancelDialog a() {
            return this.f26183m;
        }

        public String c() {
            return this.f26179h;
        }

        public String d() {
            return this.f26180j;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DocumentStepRunning)) {
                return false;
            }
            DocumentStepRunning documentStepRunning = (DocumentStepRunning) obj;
            return j.b(c(), documentStepRunning.c()) && j.b(d(), documentStepRunning.d()) && g() == documentStepRunning.g() && j.b(b(), documentStepRunning.b()) && j.b(a(), documentStepRunning.a()) && j.b(this.f26184n, documentStepRunning.f26184n) && j.b(this.f26185p, documentStepRunning.f26185p) && j.b(this.f26186q, documentStepRunning.f26186q) && j.b(f(), documentStepRunning.f());
        }

        public String f() {
            return this.f26187t;
        }

        public TransitionStatus g() {
            return this.f26181k;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((c().hashCode() * 31) + d().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
            if (a() != null) {
                i10 = a().hashCode();
            }
            return ((((((((hashCode + i10) * 31) + this.f26184n.hashCode()) * 31) + this.f26185p.hashCode()) * 31) + this.f26186q.hashCode()) * 31) + f().hashCode();
        }

        public final DocumentStepRunning i(String str, String str2, TransitionStatus transitionStatus, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle, NextStep.CancelDialog cancelDialog, NextStep.Document document, String str3, DocumentPages documentPages, String str4) {
            j.g(str, "inquiryId");
            j.g(str2, "sessionToken");
            NextStep.Document document2 = document;
            j.g(document2, "documentStep");
            String str5 = str3;
            j.g(str5, "fromComponent");
            DocumentPages documentPages2 = documentPages;
            j.g(documentPages2, "pages");
            String str6 = str4;
            j.g(str6, "fromStep");
            return new DocumentStepRunning(str, str2, transitionStatus, stepStyles$DocumentStepStyle, cancelDialog, document2, str5, documentPages2, str6);
        }

        public final NextStep.Document k() {
            return this.f26184n;
        }

        public final String l() {
            return this.f26185p;
        }

        public final DocumentPages m() {
            return this.f26186q;
        }

        /* renamed from: n */
        public StepStyles$DocumentStepStyle b() {
            return this.f26182l;
        }

        public String toString() {
            return "DocumentStepRunning(inquiryId=" + c() + ", sessionToken=" + d() + ", transitionStatus=" + g() + ", styles=" + b() + ", cancelDialog=" + a() + ", documentStep=" + this.f26184n + ", fromComponent=" + this.f26185p + ", pages=" + this.f26186q + ", fromStep=" + f() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26179h);
            parcel.writeString(this.f26180j);
            TransitionStatus transitionStatus = this.f26181k;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeParcelable(this.f26182l, i10);
            NextStep.CancelDialog cancelDialog = this.f26183m;
            if (cancelDialog == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
            this.f26184n.writeToParcel(parcel, i10);
            parcel.writeString(this.f26185p);
            parcel.writeParcelable(this.f26186q, i10);
            parcel.writeString(this.f26187t);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DocumentStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle, NextStep.CancelDialog cancelDialog, NextStep.Document document, String str3, DocumentPages documentPages, String str4) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            String str5 = str;
            String str6 = str2;
            NextStep.Document document2 = document;
            String str7 = str3;
            DocumentPages documentPages2 = documentPages;
            String str8 = str4;
            j.g(str5, "inquiryId");
            j.g(str6, "sessionToken");
            j.g(document2, "documentStep");
            j.g(str7, "fromComponent");
            j.g(documentPages2, "pages");
            j.g(str8, "fromStep");
            this.f26179h = str5;
            this.f26180j = str6;
            this.f26181k = transitionStatus;
            this.f26182l = stepStyles$DocumentStepStyle;
            this.f26183m = cancelDialog;
            this.f26184n = document2;
            this.f26185p = str7;
            this.f26186q = documentPages2;
            this.f26187t = str8;
        }
    }

    public static final class GovernmentIdStepRunning extends InquiryState implements r {
        public static final Parcelable.Creator<GovernmentIdStepRunning> CREATOR = new a();
        private final List<CaptureOptionNativeMobile> B;
        private final int C;
        private final long D;
        private final String E;
        private final String F;
        private final GovernmentIdPages G;
        private final PassportNfcConfig H;
        private final boolean I;
        private final List<NextStep.GovernmentId.CaptureFileType> J;

        /* renamed from: h  reason: collision with root package name */
        private final String f26188h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26189j;

        /* renamed from: k  reason: collision with root package name */
        private final TransitionStatus f26190k;

        /* renamed from: l  reason: collision with root package name */
        private final StepStyles$GovernmentIdStepStyle f26191l;

        /* renamed from: m  reason: collision with root package name */
        private final NextStep.CancelDialog f26192m;

        /* renamed from: n  reason: collision with root package name */
        private final String f26193n;

        /* renamed from: p  reason: collision with root package name */
        private final List<Id> f26194p;

        /* renamed from: q  reason: collision with root package name */
        private final String f26195q;

        /* renamed from: t  reason: collision with root package name */
        private final String f26196t;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f26197w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f26198x;

        /* renamed from: y  reason: collision with root package name */
        private final NextStep.GovernmentId.Localizations f26199y;

        /* renamed from: z  reason: collision with root package name */
        private final List<NextStep.GovernmentId.LocalizationOverride> f26200z;

        public static final class a implements Parcelable.Creator<GovernmentIdStepRunning> {
            /* renamed from: a */
            public final GovernmentIdStepRunning createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                TransitionStatus valueOf = parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString());
                StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle = (StepStyles$GovernmentIdStepStyle) parcel2.readParcelable(GovernmentIdStepRunning.class.getClassLoader());
                NextStep.CancelDialog createFromParcel = parcel.readInt() == 0 ? null : NextStep.CancelDialog.CREATOR.createFromParcel(parcel2);
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel2.readParcelable(GovernmentIdStepRunning.class.getClassLoader()));
                }
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                NextStep.GovernmentId.Localizations createFromParcel2 = NextStep.GovernmentId.Localizations.CREATOR.createFromParcel(parcel2);
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int readInt2 = parcel.readInt();
                    ArrayList arrayList3 = new ArrayList(readInt2);
                    int i11 = 0;
                    while (i11 != readInt2) {
                        arrayList3.add(NextStep.GovernmentId.LocalizationOverride.CREATOR.createFromParcel(parcel2));
                        i11++;
                        readInt2 = readInt2;
                    }
                    arrayList = arrayList3;
                }
                int readInt3 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt3);
                int i12 = 0;
                while (i12 != readInt3) {
                    arrayList4.add(CaptureOptionNativeMobile.valueOf(parcel.readString()));
                    i12++;
                    readInt3 = readInt3;
                }
                int readInt4 = parcel.readInt();
                long readLong = parcel.readLong();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                GovernmentIdPages governmentIdPages = (GovernmentIdPages) parcel2.readParcelable(GovernmentIdStepRunning.class.getClassLoader());
                PassportNfcConfig passportNfcConfig = (PassportNfcConfig) parcel2.readParcelable(GovernmentIdStepRunning.class.getClassLoader());
                boolean z12 = parcel.readInt() != 0;
                int readInt5 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(readInt5);
                int i13 = 0;
                while (i13 != readInt5) {
                    arrayList5.add(NextStep.GovernmentId.CaptureFileType.valueOf(parcel.readString()));
                    i13++;
                    readInt5 = readInt5;
                }
                return new GovernmentIdStepRunning(readString, readString2, valueOf, stepStyles$GovernmentIdStepStyle, createFromParcel, readString3, arrayList2, readString4, readString5, z10, z11, createFromParcel2, arrayList, arrayList4, readInt4, readLong, readString6, readString7, governmentIdPages, passportNfcConfig, z12, arrayList5);
            }

            /* renamed from: b */
            public final GovernmentIdStepRunning[] newArray(int i10) {
                return new GovernmentIdStepRunning[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GovernmentIdStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, NextStep.CancelDialog cancelDialog, String str3, List list, String str4, String str5, boolean z10, boolean z11, NextStep.GovernmentId.Localizations localizations, List list2, List list3, int i10, long j10, String str6, String str7, GovernmentIdPages governmentIdPages, PassportNfcConfig passportNfcConfig, boolean z12, List list4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i11 & 4) != 0 ? null : transitionStatus, stepStyles$GovernmentIdStepStyle, cancelDialog, str3, list, str4, str5, z10, z11, localizations, list2, list3, i10, j10, str6, str7, governmentIdPages, passportNfcConfig, z12, list4);
        }

        public static /* synthetic */ GovernmentIdStepRunning j(GovernmentIdStepRunning governmentIdStepRunning, String str, String str2, TransitionStatus transitionStatus, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, NextStep.CancelDialog cancelDialog, String str3, List list, String str4, String str5, boolean z10, boolean z11, NextStep.GovernmentId.Localizations localizations, List list2, List list3, int i10, long j10, String str6, String str7, GovernmentIdPages governmentIdPages, PassportNfcConfig passportNfcConfig, boolean z12, List list4, int i11, Object obj) {
            GovernmentIdStepRunning governmentIdStepRunning2 = governmentIdStepRunning;
            int i12 = i11;
            return governmentIdStepRunning.i((i12 & 1) != 0 ? governmentIdStepRunning.c() : str, (i12 & 2) != 0 ? governmentIdStepRunning.d() : str2, (i12 & 4) != 0 ? governmentIdStepRunning.g() : transitionStatus, (i12 & 8) != 0 ? governmentIdStepRunning.b() : stepStyles$GovernmentIdStepStyle, (i12 & 16) != 0 ? governmentIdStepRunning.a() : cancelDialog, (i12 & 32) != 0 ? governmentIdStepRunning2.f26193n : str3, (i12 & 64) != 0 ? governmentIdStepRunning2.f26194p : list, (i12 & 128) != 0 ? governmentIdStepRunning2.f26195q : str4, (i12 & 256) != 0 ? governmentIdStepRunning.f() : str5, (i12 & 512) != 0 ? governmentIdStepRunning2.f26197w : z10, (i12 & 1024) != 0 ? governmentIdStepRunning2.f26198x : z11, (i12 & 2048) != 0 ? governmentIdStepRunning2.f26199y : localizations, (i12 & Opcodes.ACC_SYNTHETIC) != 0 ? governmentIdStepRunning2.f26200z : list2, (i12 & 8192) != 0 ? governmentIdStepRunning2.B : list3, (i12 & Opcodes.ACC_ENUM) != 0 ? governmentIdStepRunning2.C : i10, (i12 & 32768) != 0 ? governmentIdStepRunning2.D : j10, (i12 & 65536) != 0 ? governmentIdStepRunning2.E : str6, (131072 & i12) != 0 ? governmentIdStepRunning2.F : str7, (i12 & Opcodes.ASM4) != 0 ? governmentIdStepRunning2.G : governmentIdPages, (i12 & Opcodes.ASM8) != 0 ? governmentIdStepRunning2.H : passportNfcConfig, (i12 & 1048576) != 0 ? governmentIdStepRunning2.I : z12, (i12 & 2097152) != 0 ? governmentIdStepRunning2.J : list4);
        }

        public final PassportNfcConfig A() {
            return this.H;
        }

        public final boolean B() {
            return this.I;
        }

        /* renamed from: D */
        public StepStyles$GovernmentIdStepStyle b() {
            return this.f26191l;
        }

        public NextStep.CancelDialog a() {
            return this.f26192m;
        }

        public String c() {
            return this.f26188h;
        }

        public String d() {
            return this.f26189j;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GovernmentIdStepRunning)) {
                return false;
            }
            GovernmentIdStepRunning governmentIdStepRunning = (GovernmentIdStepRunning) obj;
            return j.b(c(), governmentIdStepRunning.c()) && j.b(d(), governmentIdStepRunning.d()) && g() == governmentIdStepRunning.g() && j.b(b(), governmentIdStepRunning.b()) && j.b(a(), governmentIdStepRunning.a()) && j.b(this.f26193n, governmentIdStepRunning.f26193n) && j.b(this.f26194p, governmentIdStepRunning.f26194p) && j.b(this.f26195q, governmentIdStepRunning.f26195q) && j.b(f(), governmentIdStepRunning.f()) && this.f26197w == governmentIdStepRunning.f26197w && this.f26198x == governmentIdStepRunning.f26198x && j.b(this.f26199y, governmentIdStepRunning.f26199y) && j.b(this.f26200z, governmentIdStepRunning.f26200z) && j.b(this.B, governmentIdStepRunning.B) && this.C == governmentIdStepRunning.C && this.D == governmentIdStepRunning.D && j.b(this.E, governmentIdStepRunning.E) && j.b(this.F, governmentIdStepRunning.F) && j.b(this.G, governmentIdStepRunning.G) && j.b(this.H, governmentIdStepRunning.H) && this.I == governmentIdStepRunning.I && j.b(this.J, governmentIdStepRunning.J);
        }

        public String f() {
            return this.f26196t;
        }

        public TransitionStatus g() {
            return this.f26190k;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((((((((c().hashCode() * 31) + d().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + this.f26193n.hashCode()) * 31) + this.f26194p.hashCode()) * 31) + this.f26195q.hashCode()) * 31) + f().hashCode()) * 31;
            boolean z10 = this.f26197w;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i11 = (hashCode + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f26198x;
            if (z12) {
                z12 = true;
            }
            int hashCode2 = (((i11 + (z12 ? 1 : 0)) * 31) + this.f26199y.hashCode()) * 31;
            List<NextStep.GovernmentId.LocalizationOverride> list = this.f26200z;
            int hashCode3 = (((((((((((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.B.hashCode()) * 31) + Integer.hashCode(this.C)) * 31) + Long.hashCode(this.D)) * 31) + this.E.hashCode()) * 31) + this.F.hashCode()) * 31;
            GovernmentIdPages governmentIdPages = this.G;
            if (governmentIdPages != null) {
                i10 = governmentIdPages.hashCode();
            }
            int hashCode4 = (((hashCode3 + i10) * 31) + this.H.hashCode()) * 31;
            boolean z13 = this.I;
            if (!z13) {
                z11 = z13;
            }
            return ((hashCode4 + (z11 ? 1 : 0)) * 31) + this.J.hashCode();
        }

        public final GovernmentIdStepRunning i(String str, String str2, TransitionStatus transitionStatus, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, NextStep.CancelDialog cancelDialog, String str3, List<Id> list, String str4, String str5, boolean z10, boolean z11, NextStep.GovernmentId.Localizations localizations, List<NextStep.GovernmentId.LocalizationOverride> list2, List<? extends CaptureOptionNativeMobile> list3, int i10, long j10, String str6, String str7, GovernmentIdPages governmentIdPages, PassportNfcConfig passportNfcConfig, boolean z12, List<? extends NextStep.GovernmentId.CaptureFileType> list4) {
            String str8 = str;
            j.g(str8, "inquiryId");
            j.g(str2, "sessionToken");
            j.g(str3, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            j.g(list, "enabledIdClasses");
            j.g(str4, "fromComponent");
            j.g(str5, "fromStep");
            j.g(localizations, "localizations");
            j.g(list3, "enabledCaptureOptionsNativeMobile");
            j.g(str6, "fieldKeyDocument");
            j.g(str7, "fieldKeyIdClass");
            j.g(passportNfcConfig, "passportNfcConfig");
            j.g(list4, "enabledCaptureFileTypes");
            return new GovernmentIdStepRunning(str8, str2, transitionStatus, stepStyles$GovernmentIdStepStyle, cancelDialog, str3, list, str4, str5, z10, z11, localizations, list2, list3, i10, j10, str6, str7, governmentIdPages, passportNfcConfig, z12, list4);
        }

        public final boolean k() {
            return this.f26197w;
        }

        public final boolean l() {
            return this.f26198x;
        }

        public final String m() {
            return this.f26193n;
        }

        public final List<NextStep.GovernmentId.CaptureFileType> n() {
            return this.J;
        }

        public final List<CaptureOptionNativeMobile> o() {
            return this.B;
        }

        public final List<Id> p() {
            return this.f26194p;
        }

        public final String q() {
            return this.E;
        }

        public final String r() {
            return this.F;
        }

        public final String s() {
            return this.f26195q;
        }

        public final int t() {
            return this.C;
        }

        public String toString() {
            return "GovernmentIdStepRunning(inquiryId=" + c() + ", sessionToken=" + d() + ", transitionStatus=" + g() + ", styles=" + b() + ", cancelDialog=" + a() + ", countryCode=" + this.f26193n + ", enabledIdClasses=" + this.f26194p + ", fromComponent=" + this.f26195q + ", fromStep=" + f() + ", backStepEnabled=" + this.f26197w + ", cancelButtonEnabled=" + this.f26198x + ", localizations=" + this.f26199y + ", localizationOverrides=" + this.f26200z + ", enabledCaptureOptionsNativeMobile=" + this.B + ", imageCaptureCount=" + this.C + ", manualCaptureButtonDelayMs=" + this.D + ", fieldKeyDocument=" + this.E + ", fieldKeyIdClass=" + this.F + ", pages=" + this.G + ", passportNfcConfig=" + this.H + ", shouldSkipReviewScreen=" + this.I + ", enabledCaptureFileTypes=" + this.J + PropertyUtils.MAPPED_DELIM2;
        }

        public final List<NextStep.GovernmentId.LocalizationOverride> u() {
            return this.f26200z;
        }

        public final NextStep.GovernmentId.Localizations w() {
            return this.f26199y;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26188h);
            parcel.writeString(this.f26189j);
            TransitionStatus transitionStatus = this.f26190k;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeParcelable(this.f26191l, i10);
            NextStep.CancelDialog cancelDialog = this.f26192m;
            if (cancelDialog == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
            parcel.writeString(this.f26193n);
            List<Id> list = this.f26194p;
            parcel.writeInt(list.size());
            for (Id writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeString(this.f26195q);
            parcel.writeString(this.f26196t);
            parcel.writeInt(this.f26197w ? 1 : 0);
            parcel.writeInt(this.f26198x ? 1 : 0);
            this.f26199y.writeToParcel(parcel, i10);
            List<NextStep.GovernmentId.LocalizationOverride> list2 = this.f26200z;
            if (list2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(list2.size());
                for (NextStep.GovernmentId.LocalizationOverride writeToParcel : list2) {
                    writeToParcel.writeToParcel(parcel, i10);
                }
            }
            List<CaptureOptionNativeMobile> list3 = this.B;
            parcel.writeInt(list3.size());
            for (CaptureOptionNativeMobile name : list3) {
                parcel.writeString(name.name());
            }
            parcel.writeInt(this.C);
            parcel.writeLong(this.D);
            parcel.writeString(this.E);
            parcel.writeString(this.F);
            parcel.writeParcelable(this.G, i10);
            parcel.writeParcelable(this.H, i10);
            parcel.writeInt(this.I ? 1 : 0);
            List<NextStep.GovernmentId.CaptureFileType> list4 = this.J;
            parcel.writeInt(list4.size());
            for (NextStep.GovernmentId.CaptureFileType name2 : list4) {
                parcel.writeString(name2.name());
            }
        }

        public final long x() {
            return this.D;
        }

        public final GovernmentIdPages z() {
            return this.G;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GovernmentIdStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle, NextStep.CancelDialog cancelDialog, String str3, List<Id> list, String str4, String str5, boolean z10, boolean z11, NextStep.GovernmentId.Localizations localizations, List<NextStep.GovernmentId.LocalizationOverride> list2, List<? extends CaptureOptionNativeMobile> list3, int i10, long j10, String str6, String str7, GovernmentIdPages governmentIdPages, PassportNfcConfig passportNfcConfig, boolean z12, List<? extends NextStep.GovernmentId.CaptureFileType> list4) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            String str8 = str;
            String str9 = str2;
            String str10 = str3;
            List<Id> list5 = list;
            String str11 = str4;
            String str12 = str5;
            j.g(str8, "inquiryId");
            j.g(str9, "sessionToken");
            j.g(str10, RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            j.g(list5, "enabledIdClasses");
            j.g(str11, "fromComponent");
            j.g(str12, "fromStep");
            j.g(localizations, "localizations");
            j.g(list3, "enabledCaptureOptionsNativeMobile");
            j.g(str6, "fieldKeyDocument");
            j.g(str7, "fieldKeyIdClass");
            j.g(passportNfcConfig, "passportNfcConfig");
            j.g(list4, "enabledCaptureFileTypes");
            this.f26188h = str8;
            this.f26189j = str9;
            this.f26190k = transitionStatus;
            this.f26191l = stepStyles$GovernmentIdStepStyle;
            this.f26192m = cancelDialog;
            this.f26193n = str10;
            this.f26194p = list5;
            this.f26195q = str11;
            this.f26196t = str12;
            this.f26197w = z10;
            this.f26198x = z11;
            this.f26199y = localizations;
            this.f26200z = list2;
            this.B = list3;
            this.C = i10;
            this.D = j10;
            this.E = str6;
            this.F = str7;
            this.G = governmentIdPages;
            this.H = passportNfcConfig;
            this.I = z12;
            this.J = list4;
        }
    }

    public static final class SelfieStepRunning extends InquiryState implements r {
        public static final Parcelable.Creator<SelfieStepRunning> CREATOR = new a();
        private final List<NextStep.Selfie.CaptureFileType> B;

        /* renamed from: h  reason: collision with root package name */
        private final String f26201h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26202j;

        /* renamed from: k  reason: collision with root package name */
        private final TransitionStatus f26203k;

        /* renamed from: l  reason: collision with root package name */
        private final StepStyles$SelfieStepStyle f26204l;

        /* renamed from: m  reason: collision with root package name */
        private final NextStep.CancelDialog f26205m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f26206n;

        /* renamed from: p  reason: collision with root package name */
        private final String f26207p;

        /* renamed from: q  reason: collision with root package name */
        private final String f26208q;

        /* renamed from: t  reason: collision with root package name */
        private final boolean f26209t;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f26210w;

        /* renamed from: x  reason: collision with root package name */
        private final String f26211x;

        /* renamed from: y  reason: collision with root package name */
        private final boolean f26212y;

        /* renamed from: z  reason: collision with root package name */
        private final NextStep.Selfie.Localizations f26213z;

        public static final class a implements Parcelable.Creator<SelfieStepRunning> {
            /* renamed from: a */
            public final SelfieStepRunning createFromParcel(Parcel parcel) {
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                NextStep.CancelDialog cancelDialog = null;
                TransitionStatus valueOf = parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString());
                StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle = (StepStyles$SelfieStepStyle) parcel2.readParcelable(SelfieStepRunning.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    cancelDialog = NextStep.CancelDialog.CREATOR.createFromParcel(parcel2);
                }
                NextStep.CancelDialog cancelDialog2 = cancelDialog;
                int i10 = 0;
                boolean z10 = parcel.readInt() != 0;
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean z11 = parcel.readInt() != 0;
                boolean z12 = parcel.readInt() != 0;
                String readString5 = parcel.readString();
                boolean z13 = parcel.readInt() != 0;
                NextStep.Selfie.Localizations createFromParcel = NextStep.Selfie.Localizations.CREATOR.createFromParcel(parcel2);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (i10 != readInt) {
                    arrayList.add(NextStep.Selfie.CaptureFileType.valueOf(parcel.readString()));
                    i10++;
                    readInt = readInt;
                }
                return new SelfieStepRunning(readString, readString2, valueOf, stepStyles$SelfieStepStyle, cancelDialog2, z10, readString3, readString4, z11, z12, readString5, z13, createFromParcel, arrayList);
            }

            /* renamed from: b */
            public final SelfieStepRunning[] newArray(int i10) {
                return new SelfieStepRunning[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SelfieStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, NextStep.CancelDialog cancelDialog, boolean z10, String str3, String str4, boolean z11, boolean z12, String str5, boolean z13, NextStep.Selfie.Localizations localizations, List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : transitionStatus, stepStyles$SelfieStepStyle, cancelDialog, z10, str3, str4, z11, z12, str5, z13, localizations, list);
        }

        public static /* synthetic */ SelfieStepRunning j(SelfieStepRunning selfieStepRunning, String str, String str2, TransitionStatus transitionStatus, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, NextStep.CancelDialog cancelDialog, boolean z10, String str3, String str4, boolean z11, boolean z12, String str5, boolean z13, NextStep.Selfie.Localizations localizations, List list, int i10, Object obj) {
            SelfieStepRunning selfieStepRunning2 = selfieStepRunning;
            int i11 = i10;
            return selfieStepRunning.i((i11 & 1) != 0 ? selfieStepRunning.c() : str, (i11 & 2) != 0 ? selfieStepRunning.d() : str2, (i11 & 4) != 0 ? selfieStepRunning.g() : transitionStatus, (i11 & 8) != 0 ? selfieStepRunning.b() : stepStyles$SelfieStepStyle, (i11 & 16) != 0 ? selfieStepRunning.a() : cancelDialog, (i11 & 32) != 0 ? selfieStepRunning2.f26206n : z10, (i11 & 64) != 0 ? selfieStepRunning2.f26207p : str3, (i11 & 128) != 0 ? selfieStepRunning.f() : str4, (i11 & 256) != 0 ? selfieStepRunning2.f26209t : z11, (i11 & 512) != 0 ? selfieStepRunning2.f26210w : z12, (i11 & 1024) != 0 ? selfieStepRunning2.f26211x : str5, (i11 & 2048) != 0 ? selfieStepRunning2.f26212y : z13, (i11 & Opcodes.ACC_SYNTHETIC) != 0 ? selfieStepRunning2.f26213z : localizations, (i11 & 8192) != 0 ? selfieStepRunning2.B : list);
        }

        public NextStep.CancelDialog a() {
            return this.f26205m;
        }

        public String c() {
            return this.f26201h;
        }

        public String d() {
            return this.f26202j;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelfieStepRunning)) {
                return false;
            }
            SelfieStepRunning selfieStepRunning = (SelfieStepRunning) obj;
            return j.b(c(), selfieStepRunning.c()) && j.b(d(), selfieStepRunning.d()) && g() == selfieStepRunning.g() && j.b(b(), selfieStepRunning.b()) && j.b(a(), selfieStepRunning.a()) && this.f26206n == selfieStepRunning.f26206n && j.b(this.f26207p, selfieStepRunning.f26207p) && j.b(f(), selfieStepRunning.f()) && this.f26209t == selfieStepRunning.f26209t && this.f26210w == selfieStepRunning.f26210w && j.b(this.f26211x, selfieStepRunning.f26211x) && this.f26212y == selfieStepRunning.f26212y && j.b(this.f26213z, selfieStepRunning.f26213z) && j.b(this.B, selfieStepRunning.B);
        }

        public String f() {
            return this.f26208q;
        }

        public TransitionStatus g() {
            return this.f26203k;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((c().hashCode() * 31) + d().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
            if (a() != null) {
                i10 = a().hashCode();
            }
            int i11 = (hashCode + i10) * 31;
            boolean z10 = this.f26206n;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int hashCode2 = (((((i11 + (z10 ? 1 : 0)) * 31) + this.f26207p.hashCode()) * 31) + f().hashCode()) * 31;
            boolean z12 = this.f26209t;
            if (z12) {
                z12 = true;
            }
            int i12 = (hashCode2 + (z12 ? 1 : 0)) * 31;
            boolean z13 = this.f26210w;
            if (z13) {
                z13 = true;
            }
            int hashCode3 = (((i12 + (z13 ? 1 : 0)) * 31) + this.f26211x.hashCode()) * 31;
            boolean z14 = this.f26212y;
            if (!z14) {
                z11 = z14;
            }
            return ((((hashCode3 + (z11 ? 1 : 0)) * 31) + this.f26213z.hashCode()) * 31) + this.B.hashCode();
        }

        public final SelfieStepRunning i(String str, String str2, TransitionStatus transitionStatus, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, NextStep.CancelDialog cancelDialog, boolean z10, String str3, String str4, boolean z11, boolean z12, String str5, boolean z13, NextStep.Selfie.Localizations localizations, List<? extends NextStep.Selfie.CaptureFileType> list) {
            String str6 = str;
            j.g(str6, "inquiryId");
            String str7 = str2;
            j.g(str7, "sessionToken");
            String str8 = str3;
            j.g(str8, "fromComponent");
            String str9 = str4;
            j.g(str9, "fromStep");
            String str10 = str5;
            j.g(str10, "fieldKeySelfie");
            NextStep.Selfie.Localizations localizations2 = localizations;
            j.g(localizations2, "localizations");
            List<? extends NextStep.Selfie.CaptureFileType> list2 = list;
            j.g(list2, "enabledCaptureFileTypes");
            return new SelfieStepRunning(str6, str7, transitionStatus, stepStyles$SelfieStepStyle, cancelDialog, z10, str8, str9, z11, z12, str10, z13, localizations2, list2);
        }

        public final boolean k() {
            return this.f26209t;
        }

        public final boolean l() {
            return this.f26210w;
        }

        public final boolean m() {
            return this.f26206n;
        }

        public final List<NextStep.Selfie.CaptureFileType> n() {
            return this.B;
        }

        public final String o() {
            return this.f26211x;
        }

        public final String p() {
            return this.f26207p;
        }

        public final NextStep.Selfie.Localizations q() {
            return this.f26213z;
        }

        public final boolean r() {
            return this.f26212y;
        }

        /* renamed from: s */
        public StepStyles$SelfieStepStyle b() {
            return this.f26204l;
        }

        public String toString() {
            return "SelfieStepRunning(inquiryId=" + c() + ", sessionToken=" + d() + ", transitionStatus=" + g() + ", styles=" + b() + ", cancelDialog=" + a() + ", centerOnly=" + this.f26206n + ", fromComponent=" + this.f26207p + ", fromStep=" + f() + ", backStepEnabled=" + this.f26209t + ", cancelButtonEnabled=" + this.f26210w + ", fieldKeySelfie=" + this.f26211x + ", skipPromptPage=" + this.f26212y + ", localizations=" + this.f26213z + ", enabledCaptureFileTypes=" + this.B + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26201h);
            parcel.writeString(this.f26202j);
            TransitionStatus transitionStatus = this.f26203k;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeParcelable(this.f26204l, i10);
            NextStep.CancelDialog cancelDialog = this.f26205m;
            if (cancelDialog == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
            parcel.writeInt(this.f26206n ? 1 : 0);
            parcel.writeString(this.f26207p);
            parcel.writeString(this.f26208q);
            parcel.writeInt(this.f26209t ? 1 : 0);
            parcel.writeInt(this.f26210w ? 1 : 0);
            parcel.writeString(this.f26211x);
            parcel.writeInt(this.f26212y ? 1 : 0);
            this.f26213z.writeToParcel(parcel, i10);
            List<NextStep.Selfie.CaptureFileType> list = this.B;
            parcel.writeInt(list.size());
            for (NextStep.Selfie.CaptureFileType name : list) {
                parcel.writeString(name.name());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelfieStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle, NextStep.CancelDialog cancelDialog, boolean z10, String str3, String str4, boolean z11, boolean z12, String str5, boolean z13, NextStep.Selfie.Localizations localizations, List<? extends NextStep.Selfie.CaptureFileType> list) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            String str6 = str;
            String str7 = str2;
            String str8 = str3;
            String str9 = str4;
            String str10 = str5;
            NextStep.Selfie.Localizations localizations2 = localizations;
            j.g(str6, "inquiryId");
            j.g(str7, "sessionToken");
            j.g(str8, "fromComponent");
            j.g(str9, "fromStep");
            j.g(str10, "fieldKeySelfie");
            j.g(localizations2, "localizations");
            j.g(list, "enabledCaptureFileTypes");
            this.f26201h = str6;
            this.f26202j = str7;
            this.f26203k = transitionStatus;
            this.f26204l = stepStyles$SelfieStepStyle;
            this.f26205m = cancelDialog;
            this.f26206n = z10;
            this.f26207p = str8;
            this.f26208q = str9;
            this.f26209t = z11;
            this.f26210w = z12;
            this.f26211x = str10;
            this.f26212y = z13;
            this.f26213z = localizations2;
            this.B = list;
        }
    }

    public static final class UiStepRunning extends InquiryState implements r {
        public static final Parcelable.Creator<UiStepRunning> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26219h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26220j;

        /* renamed from: k  reason: collision with root package name */
        private final TransitionStatus f26221k;

        /* renamed from: l  reason: collision with root package name */
        private final StepStyles$UiStepStyle f26222l;

        /* renamed from: m  reason: collision with root package name */
        private final NextStep.CancelDialog f26223m;

        /* renamed from: n  reason: collision with root package name */
        private final String f26224n;

        /* renamed from: p  reason: collision with root package name */
        private final String f26225p;

        /* renamed from: q  reason: collision with root package name */
        private final List<UiComponent> f26226q;

        /* renamed from: t  reason: collision with root package name */
        private final boolean f26227t;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f26228w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f26229x;

        /* renamed from: y  reason: collision with root package name */
        private final Map<String, InquiryField> f26230y;

        /* renamed from: z  reason: collision with root package name */
        private final String f26231z;

        public static final class a implements Parcelable.Creator<UiStepRunning> {
            /* renamed from: a */
            public final UiStepRunning createFromParcel(Parcel parcel) {
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                NextStep.CancelDialog cancelDialog = null;
                TransitionStatus valueOf = parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString());
                StepStyles$UiStepStyle stepStyles$UiStepStyle = (StepStyles$UiStepStyle) parcel2.readParcelable(UiStepRunning.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    cancelDialog = NextStep.CancelDialog.CREATOR.createFromParcel(parcel2);
                }
                NextStep.CancelDialog cancelDialog2 = cancelDialog;
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                int i10 = 0;
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(parcel2.readParcelable(UiStepRunning.class.getClassLoader()));
                }
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                boolean z12 = parcel.readInt() != 0;
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                while (true) {
                    String readString5 = parcel.readString();
                    if (i10 == readInt2) {
                        return new UiStepRunning(readString, readString2, valueOf, stepStyles$UiStepStyle, cancelDialog2, readString3, readString4, arrayList, z10, z11, z12, linkedHashMap, readString5);
                    }
                    linkedHashMap.put(readString5, parcel2.readParcelable(UiStepRunning.class.getClassLoader()));
                    i10++;
                    readInt2 = readInt2;
                }
            }

            /* renamed from: b */
            public final UiStepRunning[] newArray(int i10) {
                return new UiStepRunning[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UiStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$UiStepStyle stepStyles$UiStepStyle, NextStep.CancelDialog cancelDialog, String str3, String str4, List list, boolean z10, boolean z11, boolean z12, Map map, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : transitionStatus, stepStyles$UiStepStyle, cancelDialog, str3, str4, list, z10, z11, z12, map, str5);
        }

        public static /* synthetic */ UiStepRunning j(UiStepRunning uiStepRunning, String str, String str2, TransitionStatus transitionStatus, StepStyles$UiStepStyle stepStyles$UiStepStyle, NextStep.CancelDialog cancelDialog, String str3, String str4, List list, boolean z10, boolean z11, boolean z12, Map map, String str5, int i10, Object obj) {
            UiStepRunning uiStepRunning2 = uiStepRunning;
            int i11 = i10;
            return uiStepRunning.i((i11 & 1) != 0 ? uiStepRunning.c() : str, (i11 & 2) != 0 ? uiStepRunning.d() : str2, (i11 & 4) != 0 ? uiStepRunning.g() : transitionStatus, (i11 & 8) != 0 ? uiStepRunning.b() : stepStyles$UiStepStyle, (i11 & 16) != 0 ? uiStepRunning.a() : cancelDialog, (i11 & 32) != 0 ? uiStepRunning2.f26224n : str3, (i11 & 64) != 0 ? uiStepRunning2.f26225p : str4, (i11 & 128) != 0 ? uiStepRunning2.f26226q : list, (i11 & 256) != 0 ? uiStepRunning2.f26227t : z10, (i11 & 512) != 0 ? uiStepRunning2.f26228w : z11, (i11 & 1024) != 0 ? uiStepRunning2.f26229x : z12, (i11 & 2048) != 0 ? uiStepRunning2.f26230y : map, (i11 & Opcodes.ACC_SYNTHETIC) != 0 ? uiStepRunning2.f26231z : str5);
        }

        public NextStep.CancelDialog a() {
            return this.f26223m;
        }

        public String c() {
            return this.f26219h;
        }

        public String d() {
            return this.f26220j;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UiStepRunning)) {
                return false;
            }
            UiStepRunning uiStepRunning = (UiStepRunning) obj;
            return j.b(c(), uiStepRunning.c()) && j.b(d(), uiStepRunning.d()) && g() == uiStepRunning.g() && j.b(b(), uiStepRunning.b()) && j.b(a(), uiStepRunning.a()) && j.b(this.f26224n, uiStepRunning.f26224n) && j.b(this.f26225p, uiStepRunning.f26225p) && j.b(this.f26226q, uiStepRunning.f26226q) && this.f26227t == uiStepRunning.f26227t && this.f26228w == uiStepRunning.f26228w && this.f26229x == uiStepRunning.f26229x && j.b(this.f26230y, uiStepRunning.f26230y) && j.b(this.f26231z, uiStepRunning.f26231z);
        }

        public String f() {
            return this.f26225p;
        }

        public TransitionStatus g() {
            return this.f26221k;
        }

        public final List<UiComponent> getComponents() {
            return this.f26226q;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((c().hashCode() * 31) + d().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31) + (b() == null ? 0 : b().hashCode())) * 31) + (a() == null ? 0 : a().hashCode())) * 31;
            String str = this.f26224n;
            if (str != null) {
                i10 = str.hashCode();
            }
            int hashCode2 = (((((hashCode + i10) * 31) + this.f26225p.hashCode()) * 31) + this.f26226q.hashCode()) * 31;
            boolean z10 = this.f26227t;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i11 = (hashCode2 + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f26228w;
            if (z12) {
                z12 = true;
            }
            int i12 = (i11 + (z12 ? 1 : 0)) * 31;
            boolean z13 = this.f26229x;
            if (!z13) {
                z11 = z13;
            }
            return ((((i12 + (z11 ? 1 : 0)) * 31) + this.f26230y.hashCode()) * 31) + this.f26231z.hashCode();
        }

        public final UiStepRunning i(String str, String str2, TransitionStatus transitionStatus, StepStyles$UiStepStyle stepStyles$UiStepStyle, NextStep.CancelDialog cancelDialog, String str3, String str4, List<? extends UiComponent> list, boolean z10, boolean z11, boolean z12, Map<String, ? extends InquiryField> map, String str5) {
            String str6 = str;
            j.g(str6, "inquiryId");
            String str7 = str2;
            j.g(str7, "sessionToken");
            String str8 = str4;
            j.g(str8, "stepName");
            List<? extends UiComponent> list2 = list;
            j.g(list2, "components");
            Map<String, ? extends InquiryField> map2 = map;
            j.g(map2, "fields");
            String str9 = str5;
            j.g(str9, "clientSideKey");
            return new UiStepRunning(str6, str7, transitionStatus, stepStyles$UiStepStyle, cancelDialog, str3, str8, list2, z10, z11, z12, map2, str9);
        }

        public final boolean k() {
            return this.f26227t;
        }

        public final boolean l() {
            return this.f26228w;
        }

        public final String m() {
            return this.f26231z;
        }

        public final Map<String, InquiryField> n() {
            return this.f26230y;
        }

        public final boolean o() {
            return this.f26229x;
        }

        public final String p() {
            return this.f26224n;
        }

        public final String q() {
            return this.f26225p;
        }

        public String toString() {
            return "UiStepRunning(inquiryId=" + c() + ", sessionToken=" + d() + ", transitionStatus=" + g() + ", styles=" + b() + ", cancelDialog=" + a() + ", inquiryStatus=" + this.f26224n + ", stepName=" + this.f26225p + ", components=" + this.f26226q + ", backStepEnabled=" + this.f26227t + ", cancelButtonEnabled=" + this.f26228w + ", finalStep=" + this.f26229x + ", fields=" + this.f26230y + ", clientSideKey=" + this.f26231z + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26219h);
            parcel.writeString(this.f26220j);
            TransitionStatus transitionStatus = this.f26221k;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeParcelable(this.f26222l, i10);
            NextStep.CancelDialog cancelDialog = this.f26223m;
            if (cancelDialog == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
            parcel.writeString(this.f26224n);
            parcel.writeString(this.f26225p);
            List<UiComponent> list = this.f26226q;
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeInt(this.f26227t ? 1 : 0);
            parcel.writeInt(this.f26228w ? 1 : 0);
            parcel.writeInt(this.f26229x ? 1 : 0);
            Map<String, InquiryField> map = this.f26230y;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeParcelable((Parcelable) next.getValue(), i10);
            }
            parcel.writeString(this.f26231z);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UiStepRunning(String str, String str2, TransitionStatus transitionStatus, StepStyles$UiStepStyle stepStyles$UiStepStyle, NextStep.CancelDialog cancelDialog, String str3, String str4, List<? extends UiComponent> list, boolean z10, boolean z11, boolean z12, Map<String, ? extends InquiryField> map, String str5) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            String str6 = str;
            String str7 = str2;
            String str8 = str4;
            List<? extends UiComponent> list2 = list;
            Map<String, ? extends InquiryField> map2 = map;
            String str9 = str5;
            j.g(str6, "inquiryId");
            j.g(str7, "sessionToken");
            j.g(str8, "stepName");
            j.g(list2, "components");
            j.g(map2, "fields");
            j.g(str9, "clientSideKey");
            this.f26219h = str6;
            this.f26220j = str7;
            this.f26221k = transitionStatus;
            this.f26222l = stepStyles$UiStepStyle;
            this.f26223m = cancelDialog;
            this.f26224n = str3;
            this.f26225p = str8;
            this.f26226q = list2;
            this.f26227t = z10;
            this.f26228w = z11;
            this.f26229x = z12;
            this.f26230y = map2;
            this.f26231z = str9;
        }

        public StepStyles$UiStepStyle b() {
            return this.f26222l;
        }
    }

    private InquiryState(String str, String str2, TransitionStatus transitionStatus, StepStyle stepStyle, NextStep.CancelDialog cancelDialog, String str3) {
        this.f26159a = str;
        this.f26160b = str2;
        this.f26161c = transitionStatus;
        this.f26162d = stepStyle;
        this.f26163e = cancelDialog;
        this.f26164f = str3;
    }

    public /* synthetic */ InquiryState(String str, String str2, TransitionStatus transitionStatus, StepStyle stepStyle, NextStep.CancelDialog cancelDialog, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, transitionStatus, stepStyle, cancelDialog, str3);
    }

    public NextStep.CancelDialog a() {
        return this.f26163e;
    }

    public StepStyle b() {
        return this.f26162d;
    }

    public String c() {
        return this.f26160b;
    }

    public String d() {
        return this.f26159a;
    }

    public final boolean e() {
        return this.f26165g;
    }

    public String f() {
        return this.f26164f;
    }

    public TransitionStatus g() {
        return this.f26161c;
    }

    public final void h(boolean z10) {
        this.f26165g = z10;
    }

    public static final class ShowLoadingSpinner extends InquiryState {
        public static final Parcelable.Creator<ShowLoadingSpinner> CREATOR = new a();

        /* renamed from: h  reason: collision with root package name */
        private final String f26214h;

        /* renamed from: j  reason: collision with root package name */
        private final TransitionStatus f26215j;

        /* renamed from: k  reason: collision with root package name */
        private final String f26216k;

        /* renamed from: l  reason: collision with root package name */
        private final StepStyle f26217l;

        /* renamed from: m  reason: collision with root package name */
        private final boolean f26218m;

        public static final class a implements Parcelable.Creator<ShowLoadingSpinner> {
            /* renamed from: a */
            public final ShowLoadingSpinner createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ShowLoadingSpinner(parcel.readString(), parcel.readInt() == 0 ? null : TransitionStatus.valueOf(parcel.readString()), parcel.readString(), (StepStyle) parcel.readParcelable(ShowLoadingSpinner.class.getClassLoader()), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final ShowLoadingSpinner[] newArray(int i10) {
                return new ShowLoadingSpinner[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ShowLoadingSpinner(String str, TransitionStatus transitionStatus, String str2, StepStyle stepStyle, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? TransitionStatus.CheckingForNextState : transitionStatus, str2, stepStyle, z10);
        }

        public StepStyle b() {
            return this.f26217l;
        }

        public String c() {
            return this.f26216k;
        }

        public String d() {
            return this.f26214h;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowLoadingSpinner)) {
                return false;
            }
            ShowLoadingSpinner showLoadingSpinner = (ShowLoadingSpinner) obj;
            return j.b(d(), showLoadingSpinner.d()) && g() == showLoadingSpinner.g() && j.b(c(), showLoadingSpinner.c()) && j.b(b(), showLoadingSpinner.b()) && this.f26218m == showLoadingSpinner.f26218m;
        }

        public TransitionStatus g() {
            return this.f26215j;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((d().hashCode() * 31) + (g() == null ? 0 : g().hashCode())) * 31) + c().hashCode()) * 31;
            if (b() != null) {
                i10 = b().hashCode();
            }
            int i11 = (hashCode + i10) * 31;
            boolean z10 = this.f26218m;
            if (z10) {
                z10 = true;
            }
            return i11 + (z10 ? 1 : 0);
        }

        public final boolean i() {
            return this.f26218m;
        }

        public String toString() {
            return "ShowLoadingSpinner(sessionToken=" + d() + ", transitionStatus=" + g() + ", inquiryId=" + c() + ", styles=" + b() + ", useBasicSpinner=" + this.f26218m + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26214h);
            TransitionStatus transitionStatus = this.f26215j;
            if (transitionStatus == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(transitionStatus.name());
            }
            parcel.writeString(this.f26216k);
            parcel.writeParcelable(this.f26217l, i10);
            parcel.writeInt(this.f26218m ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowLoadingSpinner(String str, TransitionStatus transitionStatus, String str2, StepStyle stepStyle, boolean z10) {
            super((String) null, (String) null, (TransitionStatus) null, (StepStyle) null, (NextStep.CancelDialog) null, (String) null, 63, (DefaultConstructorMarker) null);
            j.g(str, "sessionToken");
            j.g(str2, "inquiryId");
            this.f26214h = str;
            this.f26215j = transitionStatus;
            this.f26216k = str2;
            this.f26217l = stepStyle;
            this.f26218m = z10;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InquiryState(java.lang.String r8, java.lang.String r9, com.withpersona.sdk2.inquiry.internal.TransitionStatus r10, com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle r11, com.withpersona.sdk2.inquiry.internal.network.NextStep.CancelDialog r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r14 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r14 & 4
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r14 & 8
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r14 & 16
            if (r5 == 0) goto L_0x0023
            r5 = r1
            goto L_0x0024
        L_0x0023:
            r5 = r12
        L_0x0024:
            r6 = r14 & 32
            if (r6 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r13
        L_0x002a:
            r6 = 0
            r8 = r7
            r9 = r0
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r14 = r1
            r15 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.InquiryState.<init>(java.lang.String, java.lang.String, com.withpersona.sdk2.inquiry.internal.TransitionStatus, com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle, com.withpersona.sdk2.inquiry.internal.network.NextStep$CancelDialog, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
