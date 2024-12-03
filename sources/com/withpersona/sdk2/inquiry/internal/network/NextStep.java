package com.withpersona.sdk2.inquiry.internal.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.g;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.packet.Session;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

public abstract class NextStep {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26465b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f26466a;

    @i(generateAdapter = true)
    public static final class CancelDialog implements Parcelable {
        public static final Parcelable.Creator<CancelDialog> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f26467a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26468b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26469c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26470d;

        public static final class a implements Parcelable.Creator<CancelDialog> {
            /* renamed from: a */
            public final CancelDialog createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new CancelDialog(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final CancelDialog[] newArray(int i10) {
                return new CancelDialog[i10];
            }
        }

        public CancelDialog(String str, String str2, String str3, String str4) {
            this.f26467a = str;
            this.f26468b = str2;
            this.f26469c = str3;
            this.f26470d = str4;
        }

        public final String a() {
            return this.f26470d;
        }

        public final String c() {
            return this.f26469c;
        }

        public final String d() {
            return this.f26468b;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f26467a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26467a);
            parcel.writeString(this.f26468b);
            parcel.writeString(this.f26469c);
            parcel.writeString(this.f26470d);
        }
    }

    @i(generateAdapter = true)
    public static final class Complete extends NextStep implements Parcelable {
        public static final Parcelable.Creator<Complete> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private final String f26471c;

        public static final class a implements Parcelable.Creator<Complete> {
            /* renamed from: a */
            public final Complete createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Complete(parcel.readString());
            }

            /* renamed from: b */
            public final Complete[] newArray(int i10) {
                return new Complete[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Complete(String str) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f26471c = str;
        }

        public String a() {
            return this.f26471c;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26471c);
        }
    }

    @i(generateAdapter = true)
    public static final class Document extends NextStep implements Parcelable {
        public static final Parcelable.Creator<Document> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private final String f26472c;

        /* renamed from: d  reason: collision with root package name */
        private final StepStyles$DocumentStepStyle f26473d;

        /* renamed from: e  reason: collision with root package name */
        private final Config f26474e;

        @i(generateAdapter = true)
        public static final class Config implements Parcelable {
            public static final Parcelable.Creator<Config> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final Boolean f26475a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f26476b;

            /* renamed from: c  reason: collision with root package name */
            private final int f26477c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26478d;

            /* renamed from: e  reason: collision with root package name */
            private final StartPage f26479e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26480f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26481g;

            /* renamed from: h  reason: collision with root package name */
            private final Localizations f26482h;

            /* renamed from: j  reason: collision with root package name */
            private final Pages f26483j;

            public static final class a implements Parcelable.Creator<Config> {
                /* renamed from: a */
                public final Config createFromParcel(Parcel parcel) {
                    Boolean bool;
                    Boolean bool2;
                    j.g(parcel, "parcel");
                    boolean z10 = true;
                    Pages pages = null;
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    if (parcel.readInt() == 0) {
                        bool2 = null;
                    } else {
                        if (parcel.readInt() == 0) {
                            z10 = false;
                        }
                        bool2 = Boolean.valueOf(z10);
                    }
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    StartPage valueOf = StartPage.valueOf(parcel.readString());
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    Localizations createFromParcel = Localizations.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        pages = Pages.CREATOR.createFromParcel(parcel);
                    }
                    return new Config(bool, bool2, readInt, readString, valueOf, readString2, readString3, createFromParcel, pages);
                }

                /* renamed from: b */
                public final Config[] newArray(int i10) {
                    return new Config[i10];
                }
            }

            public Config(Boolean bool, Boolean bool2, int i10, String str, StartPage startPage, String str2, String str3, Localizations localizations, Pages pages) {
                j.g(startPage, "startPage");
                j.g(str2, "fieldKeyDocument");
                j.g(str3, "kind");
                j.g(localizations, "localizations");
                this.f26475a = bool;
                this.f26476b = bool2;
                this.f26477c = i10;
                this.f26478d = str;
                this.f26479e = startPage;
                this.f26480f = str2;
                this.f26481g = str3;
                this.f26482h = localizations;
                this.f26483j = pages;
            }

            public final Boolean a() {
                return this.f26475a;
            }

            public final Boolean c() {
                return this.f26476b;
            }

            public final int d() {
                return this.f26477c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26478d;
            }

            public final String f() {
                return this.f26480f;
            }

            public final String g() {
                return this.f26481g;
            }

            public final Localizations h() {
                return this.f26482h;
            }

            public final Pages i() {
                return this.f26483j;
            }

            public final StartPage j() {
                return this.f26479e;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                Boolean bool = this.f26475a;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                Boolean bool2 = this.f26476b;
                if (bool2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool2.booleanValue() ? 1 : 0);
                }
                parcel.writeInt(this.f26477c);
                parcel.writeString(this.f26478d);
                parcel.writeString(this.f26479e.name());
                parcel.writeString(this.f26480f);
                parcel.writeString(this.f26481g);
                this.f26482h.writeToParcel(parcel, i10);
                Pages pages = this.f26483j;
                if (pages == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                pages.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Localizations implements Parcelable {
            public static final Parcelable.Creator<Localizations> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final PendingPage f26484a;

            /* renamed from: b  reason: collision with root package name */
            private final PromptPage f26485b;

            /* renamed from: c  reason: collision with root package name */
            private final CancelDialog f26486c;

            public static final class a implements Parcelable.Creator<Localizations> {
                /* renamed from: a */
                public final Localizations createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Localizations(PendingPage.CREATOR.createFromParcel(parcel), PromptPage.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CancelDialog.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Localizations[] newArray(int i10) {
                    return new Localizations[i10];
                }
            }

            public Localizations(PendingPage pendingPage, PromptPage promptPage, CancelDialog cancelDialog) {
                j.g(pendingPage, "pendingPage");
                j.g(promptPage, "promptPage");
                this.f26484a = pendingPage;
                this.f26485b = promptPage;
                this.f26486c = cancelDialog;
            }

            public final CancelDialog a() {
                return this.f26486c;
            }

            public final PendingPage c() {
                return this.f26484a;
            }

            public final PromptPage d() {
                return this.f26485b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                this.f26484a.writeToParcel(parcel, i10);
                this.f26485b.writeToParcel(parcel, i10);
                CancelDialog cancelDialog = this.f26486c;
                if (cancelDialog == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Pages implements Parcelable {
            public static final Parcelable.Creator<Pages> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final DocumentPages f26487a;

            @i(generateAdapter = true)
            public static final class DocumentPages implements Parcelable {
                public static final Parcelable.Creator<DocumentPages> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                private final DocumentStartPage f26488a;

                /* renamed from: b  reason: collision with root package name */
                private final UploadOptionsDialog f26489b;

                public static final class a implements Parcelable.Creator<DocumentPages> {
                    /* renamed from: a */
                    public final DocumentPages createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        UploadOptionsDialog uploadOptionsDialog = null;
                        DocumentStartPage createFromParcel = parcel.readInt() == 0 ? null : DocumentStartPage.CREATOR.createFromParcel(parcel);
                        if (parcel.readInt() != 0) {
                            uploadOptionsDialog = UploadOptionsDialog.CREATOR.createFromParcel(parcel);
                        }
                        return new DocumentPages(createFromParcel, uploadOptionsDialog);
                    }

                    /* renamed from: b */
                    public final DocumentPages[] newArray(int i10) {
                        return new DocumentPages[i10];
                    }
                }

                public DocumentPages(DocumentStartPage documentStartPage, UploadOptionsDialog uploadOptionsDialog) {
                    this.f26488a = documentStartPage;
                    this.f26489b = uploadOptionsDialog;
                }

                public final DocumentStartPage a() {
                    return this.f26488a;
                }

                public final UploadOptionsDialog c() {
                    return this.f26489b;
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof DocumentPages)) {
                        return false;
                    }
                    DocumentPages documentPages = (DocumentPages) obj;
                    return j.b(this.f26488a, documentPages.f26488a) && j.b(this.f26489b, documentPages.f26489b);
                }

                public int hashCode() {
                    DocumentStartPage documentStartPage = this.f26488a;
                    int i10 = 0;
                    int hashCode = (documentStartPage == null ? 0 : documentStartPage.hashCode()) * 31;
                    UploadOptionsDialog uploadOptionsDialog = this.f26489b;
                    if (uploadOptionsDialog != null) {
                        i10 = uploadOptionsDialog.hashCode();
                    }
                    return hashCode + i10;
                }

                public String toString() {
                    return "DocumentPages(prompt=" + this.f26488a + ", uploadOptionsDialog=" + this.f26489b + PropertyUtils.MAPPED_DELIM2;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    DocumentStartPage documentStartPage = this.f26488a;
                    if (documentStartPage == null) {
                        parcel.writeInt(0);
                    } else {
                        parcel.writeInt(1);
                        documentStartPage.writeToParcel(parcel, i10);
                    }
                    UploadOptionsDialog uploadOptionsDialog = this.f26489b;
                    if (uploadOptionsDialog == null) {
                        parcel.writeInt(0);
                        return;
                    }
                    parcel.writeInt(1);
                    uploadOptionsDialog.writeToParcel(parcel, i10);
                }
            }

            @i(generateAdapter = true)
            public static final class DocumentStartPage implements Parcelable {
                public static final Parcelable.Creator<DocumentStartPage> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26490a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26491b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping implements Parcelable {
                    public static final Parcelable.Creator<ComponentNameMapping> CREATOR = new a();

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26492a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f26493b;

                    /* renamed from: c  reason: collision with root package name */
                    private final String f26494c;

                    /* renamed from: d  reason: collision with root package name */
                    private final String f26495d;

                    public static final class a implements Parcelable.Creator<ComponentNameMapping> {
                        /* renamed from: a */
                        public final ComponentNameMapping createFromParcel(Parcel parcel) {
                            j.g(parcel, "parcel");
                            return new ComponentNameMapping(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        }

                        /* renamed from: b */
                        public final ComponentNameMapping[] newArray(int i10) {
                            return new ComponentNameMapping[i10];
                        }
                    }

                    public ComponentNameMapping(String str, String str2, String str3, String str4) {
                        this.f26492a = str;
                        this.f26493b = str2;
                        this.f26494c = str3;
                        this.f26495d = str4;
                    }

                    public final String a() {
                        return this.f26494c;
                    }

                    public final String c() {
                        return this.f26492a;
                    }

                    public final String d() {
                        return this.f26493b;
                    }

                    public int describeContents() {
                        return 0;
                    }

                    public final String e() {
                        return this.f26495d;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ComponentNameMapping)) {
                            return false;
                        }
                        ComponentNameMapping componentNameMapping = (ComponentNameMapping) obj;
                        return j.b(this.f26492a, componentNameMapping.f26492a) && j.b(this.f26493b, componentNameMapping.f26493b) && j.b(this.f26494c, componentNameMapping.f26494c) && j.b(this.f26495d, componentNameMapping.f26495d);
                    }

                    public int hashCode() {
                        String str = this.f26492a;
                        int i10 = 0;
                        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.f26493b;
                        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.f26494c;
                        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        String str4 = this.f26495d;
                        if (str4 != null) {
                            i10 = str4.hashCode();
                        }
                        return hashCode3 + i10;
                    }

                    public String toString() {
                        return "ComponentNameMapping(buttonFilePicker=" + this.f26492a + ", buttonPhotoLibrary=" + this.f26493b + ", buttonCamera=" + this.f26494c + ", buttonUploadOptions=" + this.f26495d + PropertyUtils.MAPPED_DELIM2;
                    }

                    public void writeToParcel(Parcel parcel, int i10) {
                        j.g(parcel, "out");
                        parcel.writeString(this.f26492a);
                        parcel.writeString(this.f26493b);
                        parcel.writeString(this.f26494c);
                        parcel.writeString(this.f26495d);
                    }
                }

                public static final class a implements Parcelable.Creator<DocumentStartPage> {
                    /* renamed from: a */
                    public final DocumentStartPage createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        return new DocumentStartPage(Ui.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ComponentNameMapping.CREATOR.createFromParcel(parcel));
                    }

                    /* renamed from: b */
                    public final DocumentStartPage[] newArray(int i10) {
                        return new DocumentStartPage[i10];
                    }
                }

                public DocumentStartPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26490a = ui2;
                    this.f26491b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26491b;
                }

                public final Ui c() {
                    return this.f26490a;
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof DocumentStartPage)) {
                        return false;
                    }
                    DocumentStartPage documentStartPage = (DocumentStartPage) obj;
                    return j.b(this.f26490a, documentStartPage.f26490a) && j.b(this.f26491b, documentStartPage.f26491b);
                }

                public int hashCode() {
                    int hashCode = this.f26490a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26491b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "DocumentStartPage(uiStep=" + this.f26490a + ", componentNameMapping=" + this.f26491b + PropertyUtils.MAPPED_DELIM2;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    this.f26490a.writeToParcel(parcel, i10);
                    ComponentNameMapping componentNameMapping = this.f26491b;
                    if (componentNameMapping == null) {
                        parcel.writeInt(0);
                        return;
                    }
                    parcel.writeInt(1);
                    componentNameMapping.writeToParcel(parcel, i10);
                }
            }

            @i(generateAdapter = true)
            public static final class UploadOptionsDialog implements Parcelable {
                public static final Parcelable.Creator<UploadOptionsDialog> CREATOR = new a();

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26496a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26497b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping implements Parcelable {
                    public static final Parcelable.Creator<ComponentNameMapping> CREATOR = new a();

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26498a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f26499b;

                    /* renamed from: c  reason: collision with root package name */
                    private final String f26500c;

                    /* renamed from: d  reason: collision with root package name */
                    private final String f26501d;

                    public static final class a implements Parcelable.Creator<ComponentNameMapping> {
                        /* renamed from: a */
                        public final ComponentNameMapping createFromParcel(Parcel parcel) {
                            j.g(parcel, "parcel");
                            return new ComponentNameMapping(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        }

                        /* renamed from: b */
                        public final ComponentNameMapping[] newArray(int i10) {
                            return new ComponentNameMapping[i10];
                        }
                    }

                    public ComponentNameMapping(String str, String str2, String str3, String str4) {
                        this.f26498a = str;
                        this.f26499b = str2;
                        this.f26500c = str3;
                        this.f26501d = str4;
                    }

                    public final String a() {
                        return this.f26500c;
                    }

                    public final String c() {
                        return this.f26501d;
                    }

                    public final String d() {
                        return this.f26498a;
                    }

                    public int describeContents() {
                        return 0;
                    }

                    public final String e() {
                        return this.f26499b;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ComponentNameMapping)) {
                            return false;
                        }
                        ComponentNameMapping componentNameMapping = (ComponentNameMapping) obj;
                        return j.b(this.f26498a, componentNameMapping.f26498a) && j.b(this.f26499b, componentNameMapping.f26499b) && j.b(this.f26500c, componentNameMapping.f26500c) && j.b(this.f26501d, componentNameMapping.f26501d);
                    }

                    public int hashCode() {
                        String str = this.f26498a;
                        int i10 = 0;
                        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.f26499b;
                        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.f26500c;
                        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        String str4 = this.f26501d;
                        if (str4 != null) {
                            i10 = str4.hashCode();
                        }
                        return hashCode3 + i10;
                    }

                    public String toString() {
                        return "ComponentNameMapping(buttonFilePicker=" + this.f26498a + ", buttonPhotoLibrary=" + this.f26499b + ", buttonCamera=" + this.f26500c + ", buttonCancel=" + this.f26501d + PropertyUtils.MAPPED_DELIM2;
                    }

                    public void writeToParcel(Parcel parcel, int i10) {
                        j.g(parcel, "out");
                        parcel.writeString(this.f26498a);
                        parcel.writeString(this.f26499b);
                        parcel.writeString(this.f26500c);
                        parcel.writeString(this.f26501d);
                    }
                }

                public static final class a implements Parcelable.Creator<UploadOptionsDialog> {
                    /* renamed from: a */
                    public final UploadOptionsDialog createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        return new UploadOptionsDialog(Ui.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ComponentNameMapping.CREATOR.createFromParcel(parcel));
                    }

                    /* renamed from: b */
                    public final UploadOptionsDialog[] newArray(int i10) {
                        return new UploadOptionsDialog[i10];
                    }
                }

                public UploadOptionsDialog(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26496a = ui2;
                    this.f26497b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26497b;
                }

                public final Ui c() {
                    return this.f26496a;
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof UploadOptionsDialog)) {
                        return false;
                    }
                    UploadOptionsDialog uploadOptionsDialog = (UploadOptionsDialog) obj;
                    return j.b(this.f26496a, uploadOptionsDialog.f26496a) && j.b(this.f26497b, uploadOptionsDialog.f26497b);
                }

                public int hashCode() {
                    int hashCode = this.f26496a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26497b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "UploadOptionsDialog(uiStep=" + this.f26496a + ", componentNameMapping=" + this.f26497b + PropertyUtils.MAPPED_DELIM2;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    this.f26496a.writeToParcel(parcel, i10);
                    ComponentNameMapping componentNameMapping = this.f26497b;
                    if (componentNameMapping == null) {
                        parcel.writeInt(0);
                        return;
                    }
                    parcel.writeInt(1);
                    componentNameMapping.writeToParcel(parcel, i10);
                }
            }

            public static final class a implements Parcelable.Creator<Pages> {
                /* renamed from: a */
                public final Pages createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Pages(parcel.readInt() == 0 ? null : DocumentPages.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Pages[] newArray(int i10) {
                    return new Pages[i10];
                }
            }

            public Pages(DocumentPages documentPages) {
                this.f26487a = documentPages;
            }

            public final DocumentPages a() {
                return this.f26487a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Pages) && j.b(this.f26487a, ((Pages) obj).f26487a);
            }

            public int hashCode() {
                DocumentPages documentPages = this.f26487a;
                if (documentPages == null) {
                    return 0;
                }
                return documentPages.hashCode();
            }

            public String toString() {
                return "Pages(document=" + this.f26487a + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                DocumentPages documentPages = this.f26487a;
                if (documentPages == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                documentPages.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class PendingPage implements Parcelable {
            public static final Parcelable.Creator<PendingPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26502a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26503b;

            public static final class a implements Parcelable.Creator<PendingPage> {
                /* renamed from: a */
                public final PendingPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PendingPage(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PendingPage[] newArray(int i10) {
                    return new PendingPage[i10];
                }
            }

            public PendingPage(String str, String str2) {
                this.f26502a = str;
                this.f26503b = str2;
            }

            public final String a() {
                return this.f26503b;
            }

            public final String c() {
                return this.f26502a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26502a);
                parcel.writeString(this.f26503b);
            }
        }

        @i(generateAdapter = true)
        public static final class PromptPage implements Parcelable {
            public static final Parcelable.Creator<PromptPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26504a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26505b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26506c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26507d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26508e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26509f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26510g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26511h;

            /* renamed from: j  reason: collision with root package name */
            private final String f26512j;

            /* renamed from: k  reason: collision with root package name */
            private final String f26513k;

            /* renamed from: l  reason: collision with root package name */
            private final String f26514l;

            public static final class a implements Parcelable.Creator<PromptPage> {
                /* renamed from: a */
                public final PromptPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PromptPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PromptPage[] newArray(int i10) {
                    return new PromptPage[i10];
                }
            }

            public PromptPage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, @g(name = "cameraPermissionsBtnContinueMobile") String str10, @g(name = "cameraPermissionsBtnCancel") String str11) {
                this.f26504a = str;
                this.f26505b = str2;
                this.f26506c = str3;
                this.f26507d = str4;
                this.f26508e = str5;
                this.f26509f = str6;
                this.f26510g = str7;
                this.f26511h = str8;
                this.f26512j = str9;
                this.f26513k = str10;
                this.f26514l = str11;
            }

            public final String a() {
                return this.f26508e;
            }

            public final String c() {
                return this.f26510g;
            }

            public final String d() {
                return this.f26509f;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26513k;
            }

            public final String f() {
                return this.f26514l;
            }

            public final String g() {
                return this.f26512j;
            }

            public final String h() {
                return this.f26511h;
            }

            public final String i() {
                return this.f26507d;
            }

            public final String j() {
                return this.f26506c;
            }

            public final String k() {
                return this.f26505b;
            }

            public final String l() {
                return this.f26504a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26504a);
                parcel.writeString(this.f26505b);
                parcel.writeString(this.f26506c);
                parcel.writeString(this.f26507d);
                parcel.writeString(this.f26508e);
                parcel.writeString(this.f26509f);
                parcel.writeString(this.f26510g);
                parcel.writeString(this.f26511h);
                parcel.writeString(this.f26512j);
                parcel.writeString(this.f26513k);
                parcel.writeString(this.f26514l);
            }
        }

        @i(generateAdapter = false)
        public enum StartPage {
            PROMPT,
            REVIEW
        }

        public static final class a implements Parcelable.Creator<Document> {
            /* renamed from: a */
            public final Document createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Document(parcel.readString(), (StepStyles$DocumentStepStyle) parcel.readParcelable(Document.class.getClassLoader()), Config.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final Document[] newArray(int i10) {
                return new Document[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Document(String str, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle, Config config) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            j.g(config, "config");
            this.f26472c = str;
            this.f26473d = stepStyles$DocumentStepStyle;
            this.f26474e = config;
        }

        public String a() {
            return this.f26472c;
        }

        public final Config c() {
            return this.f26474e;
        }

        public final StepStyles$DocumentStepStyle d() {
            return this.f26473d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26472c);
            parcel.writeParcelable(this.f26473d, i10);
            this.f26474e.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class GovernmentId extends NextStep {

        /* renamed from: c  reason: collision with root package name */
        private final String f26515c;

        /* renamed from: d  reason: collision with root package name */
        private final Config f26516d;

        /* renamed from: e  reason: collision with root package name */
        private final StepStyles$GovernmentIdStepStyle f26517e;

        @i(generateAdapter = false)
        public enum CaptureFileType {
            IMAGE,
            VIDEO,
            UNKNOWN;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<CaptureFileType> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, CaptureFileType captureFileType) {
                    j.g(qVar, "writer");
                }

                @f
                public CaptureFileType fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                        return CaptureFileType.VIDEO;
                    }
                    if (j.b(J, "image")) {
                        return CaptureFileType.IMAGE;
                    }
                    return CaptureFileType.UNKNOWN;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        @i(generateAdapter = true)
        public static final class CapturePage implements Parcelable {
            public static final Parcelable.Creator<CapturePage> CREATOR = new a();
            private final String B;
            private final String C;
            private final String D;

            /* renamed from: a  reason: collision with root package name */
            private final String f26518a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26519b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26520c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26521d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26522e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26523f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26524g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26525h;

            /* renamed from: j  reason: collision with root package name */
            private final String f26526j;

            /* renamed from: k  reason: collision with root package name */
            private final String f26527k;

            /* renamed from: l  reason: collision with root package name */
            private final String f26528l;

            /* renamed from: m  reason: collision with root package name */
            private final String f26529m;

            /* renamed from: n  reason: collision with root package name */
            private final String f26530n;

            /* renamed from: p  reason: collision with root package name */
            private final String f26531p;

            /* renamed from: q  reason: collision with root package name */
            private final String f26532q;

            /* renamed from: t  reason: collision with root package name */
            private final String f26533t;

            /* renamed from: w  reason: collision with root package name */
            private final String f26534w;

            /* renamed from: x  reason: collision with root package name */
            private final String f26535x;

            /* renamed from: y  reason: collision with root package name */
            private final String f26536y;

            /* renamed from: z  reason: collision with root package name */
            private final String f26537z;

            public static final class a implements Parcelable.Creator<CapturePage> {
                /* renamed from: a */
                public final CapturePage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new CapturePage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final CapturePage[] newArray(int i10) {
                    return new CapturePage[i10];
                }
            }

            public CapturePage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23) {
                String str24 = str7;
                j.g(str, "scanFront");
                j.g(str2, "scanBack");
                j.g(str3, "scanPdf417");
                j.g(str4, "scanFrontOrBack");
                j.g(str5, "scanSignature");
                j.g(str6, "capturing");
                j.g(str24, "confirmCapture");
                this.f26518a = str;
                this.f26519b = str2;
                this.f26520c = str3;
                this.f26521d = str4;
                this.f26522e = str5;
                this.f26523f = str6;
                this.f26524g = str24;
                this.f26525h = str8;
                this.f26526j = str9;
                this.f26527k = str10;
                this.f26528l = str11;
                this.f26529m = str12;
                this.f26530n = str13;
                this.f26531p = str14;
                this.f26532q = str15;
                this.f26533t = str16;
                this.f26534w = str17;
                this.f26535x = str18;
                this.f26536y = str19;
                this.f26537z = str20;
                this.B = str21;
                this.C = str22;
                this.D = str23;
            }

            public final String a() {
                return this.f26532q;
            }

            public final String c() {
                return this.f26531p;
            }

            public final String d() {
                return this.f26530n;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26529m;
            }

            public final String f() {
                return this.f26528l;
            }

            public final String g() {
                return this.f26523f;
            }

            public final String h() {
                return this.f26524g;
            }

            public final String i() {
                return this.f26525h;
            }

            public final String j() {
                return this.f26526j;
            }

            public final String k() {
                return this.f26527k;
            }

            public final String l() {
                return this.D;
            }

            public final String m() {
                return this.C;
            }

            public final String n() {
                return this.B;
            }

            public final String o() {
                return this.f26537z;
            }

            public final String p() {
                return this.f26536y;
            }

            public final String q() {
                return this.f26535x;
            }

            public final String r() {
                return this.f26534w;
            }

            public final String s() {
                return this.f26533t;
            }

            public final String t() {
                return this.f26519b;
            }

            public final String u() {
                return this.f26518a;
            }

            public final String w() {
                return this.f26521d;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26518a);
                parcel.writeString(this.f26519b);
                parcel.writeString(this.f26520c);
                parcel.writeString(this.f26521d);
                parcel.writeString(this.f26522e);
                parcel.writeString(this.f26523f);
                parcel.writeString(this.f26524g);
                parcel.writeString(this.f26525h);
                parcel.writeString(this.f26526j);
                parcel.writeString(this.f26527k);
                parcel.writeString(this.f26528l);
                parcel.writeString(this.f26529m);
                parcel.writeString(this.f26530n);
                parcel.writeString(this.f26531p);
                parcel.writeString(this.f26532q);
                parcel.writeString(this.f26533t);
                parcel.writeString(this.f26534w);
                parcel.writeString(this.f26535x);
                parcel.writeString(this.f26536y);
                parcel.writeString(this.f26537z);
                parcel.writeString(this.B);
                parcel.writeString(this.C);
                parcel.writeString(this.D);
            }

            public final String x() {
                return this.f26520c;
            }

            public final String z() {
                return this.f26522e;
            }
        }

        @i(generateAdapter = true)
        public static final class CheckPage implements Parcelable {
            public static final Parcelable.Creator<CheckPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26538a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26539b;

            public static final class a implements Parcelable.Creator<CheckPage> {
                /* renamed from: a */
                public final CheckPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new CheckPage(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final CheckPage[] newArray(int i10) {
                    return new CheckPage[i10];
                }
            }

            public CheckPage(@g(name = "btnSubmit") String str, @g(name = "btnRetake") String str2) {
                j.g(str, "buttonSubmit");
                j.g(str2, "buttonRetake");
                this.f26538a = str;
                this.f26539b = str2;
            }

            public final String a() {
                return this.f26539b;
            }

            public final String c() {
                return this.f26538a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26538a);
                parcel.writeString(this.f26539b);
            }
        }

        @i(generateAdapter = true)
        public static final class Config {

            /* renamed from: a  reason: collision with root package name */
            private final List<Id> f26540a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f26541b;

            /* renamed from: c  reason: collision with root package name */
            private final Boolean f26542c;

            /* renamed from: d  reason: collision with root package name */
            private final Localizations f26543d;

            /* renamed from: e  reason: collision with root package name */
            private final List<CaptureOptionNativeMobile> f26544e;

            /* renamed from: f  reason: collision with root package name */
            private final Integer f26545f;

            /* renamed from: g  reason: collision with root package name */
            private final Long f26546g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26547h;

            /* renamed from: i  reason: collision with root package name */
            private final String f26548i;

            /* renamed from: j  reason: collision with root package name */
            private final NfcPassport f26549j;

            /* renamed from: k  reason: collision with root package name */
            private final List<LocalizationOverride> f26550k;

            /* renamed from: l  reason: collision with root package name */
            private final Pages f26551l;

            /* renamed from: m  reason: collision with root package name */
            private final Boolean f26552m;

            /* renamed from: n  reason: collision with root package name */
            private final List<CaptureFileType> f26553n;

            public Config(List<Id> list, Boolean bool, Boolean bool2, Localizations localizations, List<? extends CaptureOptionNativeMobile> list2, Integer num, Long l10, String str, String str2, NfcPassport nfcPassport, List<LocalizationOverride> list3, Pages pages, Boolean bool3, List<? extends CaptureFileType> list4) {
                j.g(localizations, "localizations");
                j.g(str, "fieldKeyDocument");
                j.g(str2, "fieldKeyIdclass");
                this.f26540a = list;
                this.f26541b = bool;
                this.f26542c = bool2;
                this.f26543d = localizations;
                this.f26544e = list2;
                this.f26545f = num;
                this.f26546g = l10;
                this.f26547h = str;
                this.f26548i = str2;
                this.f26549j = nfcPassport;
                this.f26550k = list3;
                this.f26551l = pages;
                this.f26552m = bool3;
                this.f26553n = list4;
            }

            public final Boolean a() {
                return this.f26541b;
            }

            public final Boolean b() {
                return this.f26542c;
            }

            public final List<CaptureFileType> c() {
                return this.f26553n;
            }

            public final List<CaptureOptionNativeMobile> d() {
                return this.f26544e;
            }

            public final String e() {
                return this.f26547h;
            }

            public final String f() {
                return this.f26548i;
            }

            public final List<Id> g() {
                return this.f26540a;
            }

            public final Integer h() {
                return this.f26545f;
            }

            public final List<LocalizationOverride> i() {
                return this.f26550k;
            }

            public final Localizations j() {
                return this.f26543d;
            }

            public final Long k() {
                return this.f26546g;
            }

            public final NfcPassport l() {
                return this.f26549j;
            }

            public final Pages m() {
                return this.f26551l;
            }

            public final Boolean n() {
                return this.f26552m;
            }
        }

        @i(generateAdapter = true)
        public static final class LocalizationOverride implements Parcelable, Comparable<LocalizationOverride> {
            public static final Parcelable.Creator<LocalizationOverride> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26554a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26555b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26556c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26557d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26558e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26559f;

            /* renamed from: g  reason: collision with root package name */
            private final gk.f f26560g = b.b(new NextStep$GovernmentId$LocalizationOverride$precedenceScore$2(this));

            public static final class a implements Parcelable.Creator<LocalizationOverride> {
                /* renamed from: a */
                public final LocalizationOverride createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new LocalizationOverride(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final LocalizationOverride[] newArray(int i10) {
                    return new LocalizationOverride[i10];
                }
            }

            public LocalizationOverride(String str, String str2, String str3, String str4, String str5, String str6) {
                j.g(str4, DataLayout.ELEMENT);
                j.g(str5, SDKConstants.PARAM_KEY);
                j.g(str6, "text");
                this.f26554a = str;
                this.f26555b = str2;
                this.f26556c = str3;
                this.f26557d = str4;
                this.f26558e = str5;
                this.f26559f = str6;
            }

            /* renamed from: a */
            public int compareTo(LocalizationOverride localizationOverride) {
                j.g(localizationOverride, "other");
                return j.i(i(), localizationOverride.i());
            }

            public final String c() {
                return this.f26554a;
            }

            public final String d() {
                return this.f26555b;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26558e;
            }

            public final String h() {
                return this.f26557d;
            }

            public final int i() {
                return ((Number) this.f26560g.getValue()).intValue();
            }

            public final String j() {
                return this.f26556c;
            }

            public final String k() {
                return this.f26559f;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26554a);
                parcel.writeString(this.f26555b);
                parcel.writeString(this.f26556c);
                parcel.writeString(this.f26557d);
                parcel.writeString(this.f26558e);
                parcel.writeString(this.f26559f);
            }
        }

        @i(generateAdapter = true)
        public static final class Localizations implements Parcelable {
            public static final Parcelable.Creator<Localizations> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final SelectPage f26561a;

            /* renamed from: b  reason: collision with root package name */
            private final PromptPage f26562b;

            /* renamed from: c  reason: collision with root package name */
            private final CapturePage f26563c;

            /* renamed from: d  reason: collision with root package name */
            private final CheckPage f26564d;

            /* renamed from: e  reason: collision with root package name */
            private final PendingPage f26565e;

            /* renamed from: f  reason: collision with root package name */
            private final RequestPage f26566f;

            /* renamed from: g  reason: collision with root package name */
            private final ReviewUploadPage f26567g;

            /* renamed from: h  reason: collision with root package name */
            private final CancelDialog f26568h;

            /* renamed from: j  reason: collision with root package name */
            private final PassportNfc f26569j;

            public static final class a implements Parcelable.Creator<Localizations> {
                /* renamed from: a */
                public final Localizations createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    SelectPage createFromParcel = SelectPage.CREATOR.createFromParcel(parcel);
                    PromptPage createFromParcel2 = PromptPage.CREATOR.createFromParcel(parcel);
                    CapturePage createFromParcel3 = CapturePage.CREATOR.createFromParcel(parcel);
                    CheckPage createFromParcel4 = CheckPage.CREATOR.createFromParcel(parcel);
                    PendingPage createFromParcel5 = PendingPage.CREATOR.createFromParcel(parcel);
                    RequestPage createFromParcel6 = RequestPage.CREATOR.createFromParcel(parcel);
                    ReviewUploadPage createFromParcel7 = ReviewUploadPage.CREATOR.createFromParcel(parcel);
                    PassportNfc passportNfc = null;
                    CancelDialog createFromParcel8 = parcel.readInt() == 0 ? null : CancelDialog.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        passportNfc = PassportNfc.CREATOR.createFromParcel(parcel);
                    }
                    return new Localizations(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, passportNfc);
                }

                /* renamed from: b */
                public final Localizations[] newArray(int i10) {
                    return new Localizations[i10];
                }
            }

            public Localizations(SelectPage selectPage, PromptPage promptPage, CapturePage capturePage, CheckPage checkPage, PendingPage pendingPage, RequestPage requestPage, ReviewUploadPage reviewUploadPage, CancelDialog cancelDialog, PassportNfc passportNfc) {
                j.g(selectPage, "selectPage");
                j.g(promptPage, "promptPage");
                j.g(capturePage, "capturePage");
                j.g(checkPage, "checkPage");
                j.g(pendingPage, "pendingPage");
                j.g(requestPage, "requestPage");
                j.g(reviewUploadPage, "reviewUploadPage");
                this.f26561a = selectPage;
                this.f26562b = promptPage;
                this.f26563c = capturePage;
                this.f26564d = checkPage;
                this.f26565e = pendingPage;
                this.f26566f = requestPage;
                this.f26567g = reviewUploadPage;
                this.f26568h = cancelDialog;
                this.f26569j = passportNfc;
            }

            public final CancelDialog a() {
                return this.f26568h;
            }

            public final CapturePage c() {
                return this.f26563c;
            }

            public final CheckPage d() {
                return this.f26564d;
            }

            public int describeContents() {
                return 0;
            }

            public final PassportNfc e() {
                return this.f26569j;
            }

            public final PendingPage f() {
                return this.f26565e;
            }

            public final PromptPage g() {
                return this.f26562b;
            }

            public final RequestPage h() {
                return this.f26566f;
            }

            public final ReviewUploadPage i() {
                return this.f26567g;
            }

            public final SelectPage j() {
                return this.f26561a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                this.f26561a.writeToParcel(parcel, i10);
                this.f26562b.writeToParcel(parcel, i10);
                this.f26563c.writeToParcel(parcel, i10);
                this.f26564d.writeToParcel(parcel, i10);
                this.f26565e.writeToParcel(parcel, i10);
                this.f26566f.writeToParcel(parcel, i10);
                this.f26567g.writeToParcel(parcel, i10);
                CancelDialog cancelDialog = this.f26568h;
                if (cancelDialog == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    cancelDialog.writeToParcel(parcel, i10);
                }
                PassportNfc passportNfc = this.f26569j;
                if (passportNfc == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                passportNfc.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class NfcPassport {

            /* renamed from: a  reason: collision with root package name */
            private final String f26570a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f26571b;

            /* renamed from: c  reason: collision with root package name */
            private final PassportNfcOption f26572c;

            public NfcPassport(String str, Boolean bool, PassportNfcOption passportNfcOption) {
                this.f26570a = str;
                this.f26571b = bool;
                this.f26572c = passportNfcOption;
            }

            public final String a() {
                return this.f26570a;
            }

            public final PassportNfcOption b() {
                return this.f26572c;
            }

            public final Boolean c() {
                return this.f26571b;
            }
        }

        @i(generateAdapter = true)
        public static final class Pages {

            /* renamed from: a  reason: collision with root package name */
            private final PassportNfc f26573a;

            @i(generateAdapter = true)
            public static final class PassportNfc {

                /* renamed from: a  reason: collision with root package name */
                private final PassportNfcStartPage f26574a;

                /* renamed from: b  reason: collision with root package name */
                private final PassportNfcVerifyDetailsPage f26575b;

                /* renamed from: c  reason: collision with root package name */
                private final PassportNfcScanPage f26576c;

                /* renamed from: d  reason: collision with root package name */
                private final PassportNfcPromptPage f26577d;

                /* renamed from: e  reason: collision with root package name */
                private final PassportNfcScanReadyPage f26578e;

                /* renamed from: f  reason: collision with root package name */
                private final PassportNfcScanCompletePage f26579f;

                /* renamed from: g  reason: collision with root package name */
                private final PassportNfcConfirmDetailsPage f26580g;

                /* renamed from: h  reason: collision with root package name */
                private final PassportNfcNfcNotSupportedPage f26581h;

                /* renamed from: i  reason: collision with root package name */
                private final PassportNfcModuleMissingPage f26582i;

                public PassportNfc(PassportNfcStartPage passportNfcStartPage, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, PassportNfcScanPage passportNfcScanPage, PassportNfcPromptPage passportNfcPromptPage, PassportNfcScanReadyPage passportNfcScanReadyPage, PassportNfcScanCompletePage passportNfcScanCompletePage, PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage, PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage, PassportNfcModuleMissingPage passportNfcModuleMissingPage) {
                    this.f26574a = passportNfcStartPage;
                    this.f26575b = passportNfcVerifyDetailsPage;
                    this.f26576c = passportNfcScanPage;
                    this.f26577d = passportNfcPromptPage;
                    this.f26578e = passportNfcScanReadyPage;
                    this.f26579f = passportNfcScanCompletePage;
                    this.f26580g = passportNfcConfirmDetailsPage;
                    this.f26581h = passportNfcNfcNotSupportedPage;
                    this.f26582i = passportNfcModuleMissingPage;
                }

                public final PassportNfcConfirmDetailsPage a() {
                    return this.f26580g;
                }

                public final PassportNfcModuleMissingPage b() {
                    return this.f26582i;
                }

                public final PassportNfcNfcNotSupportedPage c() {
                    return this.f26581h;
                }

                public final PassportNfcPromptPage d() {
                    return this.f26577d;
                }

                public final PassportNfcScanPage e() {
                    return this.f26576c;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfc)) {
                        return false;
                    }
                    PassportNfc passportNfc = (PassportNfc) obj;
                    return j.b(this.f26574a, passportNfc.f26574a) && j.b(this.f26575b, passportNfc.f26575b) && j.b(this.f26576c, passportNfc.f26576c) && j.b(this.f26577d, passportNfc.f26577d) && j.b(this.f26578e, passportNfc.f26578e) && j.b(this.f26579f, passportNfc.f26579f) && j.b(this.f26580g, passportNfc.f26580g) && j.b(this.f26581h, passportNfc.f26581h) && j.b(this.f26582i, passportNfc.f26582i);
                }

                public final PassportNfcScanCompletePage f() {
                    return this.f26579f;
                }

                public final PassportNfcScanReadyPage g() {
                    return this.f26578e;
                }

                public final PassportNfcStartPage h() {
                    return this.f26574a;
                }

                public int hashCode() {
                    PassportNfcStartPage passportNfcStartPage = this.f26574a;
                    int i10 = 0;
                    int hashCode = (passportNfcStartPage == null ? 0 : passportNfcStartPage.hashCode()) * 31;
                    PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage = this.f26575b;
                    int hashCode2 = (hashCode + (passportNfcVerifyDetailsPage == null ? 0 : passportNfcVerifyDetailsPage.hashCode())) * 31;
                    PassportNfcScanPage passportNfcScanPage = this.f26576c;
                    int hashCode3 = (hashCode2 + (passportNfcScanPage == null ? 0 : passportNfcScanPage.hashCode())) * 31;
                    PassportNfcPromptPage passportNfcPromptPage = this.f26577d;
                    int hashCode4 = (hashCode3 + (passportNfcPromptPage == null ? 0 : passportNfcPromptPage.hashCode())) * 31;
                    PassportNfcScanReadyPage passportNfcScanReadyPage = this.f26578e;
                    int hashCode5 = (hashCode4 + (passportNfcScanReadyPage == null ? 0 : passportNfcScanReadyPage.hashCode())) * 31;
                    PassportNfcScanCompletePage passportNfcScanCompletePage = this.f26579f;
                    int hashCode6 = (hashCode5 + (passportNfcScanCompletePage == null ? 0 : passportNfcScanCompletePage.hashCode())) * 31;
                    PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage = this.f26580g;
                    int hashCode7 = (hashCode6 + (passportNfcConfirmDetailsPage == null ? 0 : passportNfcConfirmDetailsPage.hashCode())) * 31;
                    PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage = this.f26581h;
                    int hashCode8 = (hashCode7 + (passportNfcNfcNotSupportedPage == null ? 0 : passportNfcNfcNotSupportedPage.hashCode())) * 31;
                    PassportNfcModuleMissingPage passportNfcModuleMissingPage = this.f26582i;
                    if (passportNfcModuleMissingPage != null) {
                        i10 = passportNfcModuleMissingPage.hashCode();
                    }
                    return hashCode8 + i10;
                }

                public final PassportNfcVerifyDetailsPage i() {
                    return this.f26575b;
                }

                public String toString() {
                    return "PassportNfc(start=" + this.f26574a + ", verifyDetails=" + this.f26575b + ", scan=" + this.f26576c + ", prompt=" + this.f26577d + ", scanReady=" + this.f26578e + ", scanComplete=" + this.f26579f + ", confirmDetails=" + this.f26580g + ", nfcNotSupported=" + this.f26581h + ", moduleMissing=" + this.f26582i + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcConfirmDetailsPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26583a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26584b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26585a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f26586b;

                    /* renamed from: c  reason: collision with root package name */
                    private final String f26587c;

                    /* renamed from: d  reason: collision with root package name */
                    private final String f26588d;

                    /* renamed from: e  reason: collision with root package name */
                    private final String f26589e;

                    /* renamed from: f  reason: collision with root package name */
                    private final String f26590f;

                    /* renamed from: g  reason: collision with root package name */
                    private final String f26591g;

                    /* renamed from: h  reason: collision with root package name */
                    private final String f26592h;

                    /* renamed from: i  reason: collision with root package name */
                    private final String f26593i;

                    /* renamed from: j  reason: collision with root package name */
                    private final String f26594j;

                    /* renamed from: k  reason: collision with root package name */
                    private final String f26595k;

                    /* renamed from: l  reason: collision with root package name */
                    private final String f26596l;

                    public ComponentNameMapping(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
                        this.f26585a = str;
                        this.f26586b = str2;
                        this.f26587c = str3;
                        this.f26588d = str4;
                        this.f26589e = str5;
                        this.f26590f = str6;
                        this.f26591g = str7;
                        this.f26592h = str8;
                        this.f26593i = str9;
                        this.f26594j = str10;
                        this.f26595k = str11;
                        this.f26596l = str12;
                    }

                    public final String a() {
                        return this.f26594j;
                    }

                    public final String b() {
                        return this.f26595k;
                    }

                    public final String c() {
                        return this.f26587c;
                    }

                    public final String d() {
                        return this.f26588d;
                    }

                    public final String e() {
                        return this.f26589e;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ComponentNameMapping)) {
                            return false;
                        }
                        ComponentNameMapping componentNameMapping = (ComponentNameMapping) obj;
                        return j.b(this.f26585a, componentNameMapping.f26585a) && j.b(this.f26586b, componentNameMapping.f26586b) && j.b(this.f26587c, componentNameMapping.f26587c) && j.b(this.f26588d, componentNameMapping.f26588d) && j.b(this.f26589e, componentNameMapping.f26589e) && j.b(this.f26590f, componentNameMapping.f26590f) && j.b(this.f26591g, componentNameMapping.f26591g) && j.b(this.f26592h, componentNameMapping.f26592h) && j.b(this.f26593i, componentNameMapping.f26593i) && j.b(this.f26594j, componentNameMapping.f26594j) && j.b(this.f26595k, componentNameMapping.f26595k) && j.b(this.f26596l, componentNameMapping.f26596l);
                    }

                    public final String f() {
                        return this.f26591g;
                    }

                    public final String g() {
                        return this.f26585a;
                    }

                    public final String h() {
                        return this.f26592h;
                    }

                    public int hashCode() {
                        String str = this.f26585a;
                        int i10 = 0;
                        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.f26586b;
                        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.f26587c;
                        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        String str4 = this.f26588d;
                        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                        String str5 = this.f26589e;
                        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                        String str6 = this.f26590f;
                        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                        String str7 = this.f26591g;
                        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
                        String str8 = this.f26592h;
                        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
                        String str9 = this.f26593i;
                        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
                        String str10 = this.f26594j;
                        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
                        String str11 = this.f26595k;
                        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
                        String str12 = this.f26596l;
                        if (str12 != null) {
                            i10 = str12.hashCode();
                        }
                        return hashCode11 + i10;
                    }

                    public final String i() {
                        return this.f26590f;
                    }

                    public final String j() {
                        return this.f26593i;
                    }

                    public final String k() {
                        return this.f26586b;
                    }

                    public final String l() {
                        return this.f26596l;
                    }

                    public String toString() {
                        return "ComponentNameMapping(image=" + this.f26585a + ", passportNumber=" + this.f26586b + ", dob=" + this.f26587c + ", exp=" + this.f26588d + ", firstName=" + this.f26589e + ", lastName=" + this.f26590f + ", gender=" + this.f26591g + ", issuingAuthority=" + this.f26592h + ", nationality=" + this.f26593i + ", address=" + this.f26594j + ", completeButton=" + this.f26595k + ", retryButton=" + this.f26596l + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcConfirmDetailsPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26583a = ui2;
                    this.f26584b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26584b;
                }

                public final Ui b() {
                    return this.f26583a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcConfirmDetailsPage)) {
                        return false;
                    }
                    PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage = (PassportNfcConfirmDetailsPage) obj;
                    return j.b(this.f26583a, passportNfcConfirmDetailsPage.f26583a) && j.b(this.f26584b, passportNfcConfirmDetailsPage.f26584b);
                }

                public int hashCode() {
                    int hashCode = this.f26583a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26584b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcConfirmDetailsPage(uiStep=" + this.f26583a + ", componentNameMapping=" + this.f26584b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcModuleMissingPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26597a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26598b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26599a;

                    public ComponentNameMapping(String str) {
                        this.f26599a = str;
                    }

                    public final String a() {
                        return this.f26599a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ComponentNameMapping) && j.b(this.f26599a, ((ComponentNameMapping) obj).f26599a);
                    }

                    public int hashCode() {
                        String str = this.f26599a;
                        if (str == null) {
                            return 0;
                        }
                        return str.hashCode();
                    }

                    public String toString() {
                        return "ComponentNameMapping(confirmButton=" + this.f26599a + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcModuleMissingPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26597a = ui2;
                    this.f26598b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26598b;
                }

                public final Ui b() {
                    return this.f26597a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcModuleMissingPage)) {
                        return false;
                    }
                    PassportNfcModuleMissingPage passportNfcModuleMissingPage = (PassportNfcModuleMissingPage) obj;
                    return j.b(this.f26597a, passportNfcModuleMissingPage.f26597a) && j.b(this.f26598b, passportNfcModuleMissingPage.f26598b);
                }

                public int hashCode() {
                    int hashCode = this.f26597a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26598b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcModuleMissingPage(uiStep=" + this.f26597a + ", componentNameMapping=" + this.f26598b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcNfcNotSupportedPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26600a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26601b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26602a;

                    public ComponentNameMapping(String str) {
                        this.f26602a = str;
                    }

                    public final String a() {
                        return this.f26602a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ComponentNameMapping) && j.b(this.f26602a, ((ComponentNameMapping) obj).f26602a);
                    }

                    public int hashCode() {
                        String str = this.f26602a;
                        if (str == null) {
                            return 0;
                        }
                        return str.hashCode();
                    }

                    public String toString() {
                        return "ComponentNameMapping(confirmButton=" + this.f26602a + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcNfcNotSupportedPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26600a = ui2;
                    this.f26601b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26601b;
                }

                public final Ui b() {
                    return this.f26600a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcNfcNotSupportedPage)) {
                        return false;
                    }
                    PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage = (PassportNfcNfcNotSupportedPage) obj;
                    return j.b(this.f26600a, passportNfcNfcNotSupportedPage.f26600a) && j.b(this.f26601b, passportNfcNfcNotSupportedPage.f26601b);
                }

                public int hashCode() {
                    int hashCode = this.f26600a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26601b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcNfcNotSupportedPage(uiStep=" + this.f26600a + ", componentNameMapping=" + this.f26601b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcPromptPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26603a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26604b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26605a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f26606b;

                    public ComponentNameMapping(String str, String str2) {
                        this.f26605a = str;
                        this.f26606b = str2;
                    }

                    public final String a() {
                        return this.f26606b;
                    }

                    public final String b() {
                        return this.f26605a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ComponentNameMapping)) {
                            return false;
                        }
                        ComponentNameMapping componentNameMapping = (ComponentNameMapping) obj;
                        return j.b(this.f26605a, componentNameMapping.f26605a) && j.b(this.f26606b, componentNameMapping.f26606b);
                    }

                    public int hashCode() {
                        String str = this.f26605a;
                        int i10 = 0;
                        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.f26606b;
                        if (str2 != null) {
                            i10 = str2.hashCode();
                        }
                        return hashCode + i10;
                    }

                    public String toString() {
                        return "ComponentNameMapping(confirmButton=" + this.f26605a + ", cancelButton=" + this.f26606b + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcPromptPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26603a = ui2;
                    this.f26604b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26604b;
                }

                public final Ui b() {
                    return this.f26603a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcPromptPage)) {
                        return false;
                    }
                    PassportNfcPromptPage passportNfcPromptPage = (PassportNfcPromptPage) obj;
                    return j.b(this.f26603a, passportNfcPromptPage.f26603a) && j.b(this.f26604b, passportNfcPromptPage.f26604b);
                }

                public int hashCode() {
                    int hashCode = this.f26603a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26604b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcPromptPage(uiStep=" + this.f26603a + ", componentNameMapping=" + this.f26604b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcScanCompletePage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26607a;

                public PassportNfcScanCompletePage(Ui ui2) {
                    j.g(ui2, "uiStep");
                    this.f26607a = ui2;
                }

                public final Ui a() {
                    return this.f26607a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof PassportNfcScanCompletePage) && j.b(this.f26607a, ((PassportNfcScanCompletePage) obj).f26607a);
                }

                public int hashCode() {
                    return this.f26607a.hashCode();
                }

                public String toString() {
                    return "PassportNfcScanCompletePage(uiStep=" + this.f26607a + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcScanPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26608a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26609b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26610a;

                    public ComponentNameMapping(String str) {
                        this.f26610a = str;
                    }

                    public final String a() {
                        return this.f26610a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ComponentNameMapping) && j.b(this.f26610a, ((ComponentNameMapping) obj).f26610a);
                    }

                    public int hashCode() {
                        String str = this.f26610a;
                        if (str == null) {
                            return 0;
                        }
                        return str.hashCode();
                    }

                    public String toString() {
                        return "ComponentNameMapping(confirmButton=" + this.f26610a + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcScanPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26608a = ui2;
                    this.f26609b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26609b;
                }

                public final Ui b() {
                    return this.f26608a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcScanPage)) {
                        return false;
                    }
                    PassportNfcScanPage passportNfcScanPage = (PassportNfcScanPage) obj;
                    return j.b(this.f26608a, passportNfcScanPage.f26608a) && j.b(this.f26609b, passportNfcScanPage.f26609b);
                }

                public int hashCode() {
                    int hashCode = this.f26608a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26609b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcScanPage(uiStep=" + this.f26608a + ", componentNameMapping=" + this.f26609b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcScanReadyPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26611a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26612b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26613a;

                    public ComponentNameMapping(String str) {
                        this.f26613a = str;
                    }

                    public final String a() {
                        return this.f26613a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ComponentNameMapping) && j.b(this.f26613a, ((ComponentNameMapping) obj).f26613a);
                    }

                    public int hashCode() {
                        String str = this.f26613a;
                        if (str == null) {
                            return 0;
                        }
                        return str.hashCode();
                    }

                    public String toString() {
                        return "ComponentNameMapping(cancelButton=" + this.f26613a + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcScanReadyPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26611a = ui2;
                    this.f26612b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26612b;
                }

                public final Ui b() {
                    return this.f26611a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcScanReadyPage)) {
                        return false;
                    }
                    PassportNfcScanReadyPage passportNfcScanReadyPage = (PassportNfcScanReadyPage) obj;
                    return j.b(this.f26611a, passportNfcScanReadyPage.f26611a) && j.b(this.f26612b, passportNfcScanReadyPage.f26612b);
                }

                public int hashCode() {
                    int hashCode = this.f26611a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26612b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcScanReadyPage(uiStep=" + this.f26611a + ", componentNameMapping=" + this.f26612b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcStartPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26614a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26615b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26616a;

                    public ComponentNameMapping(String str) {
                        this.f26616a = str;
                    }

                    public final String a() {
                        return this.f26616a;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ComponentNameMapping) && j.b(this.f26616a, ((ComponentNameMapping) obj).f26616a);
                    }

                    public int hashCode() {
                        String str = this.f26616a;
                        if (str == null) {
                            return 0;
                        }
                        return str.hashCode();
                    }

                    public String toString() {
                        return "ComponentNameMapping(confirmButton=" + this.f26616a + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcStartPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26614a = ui2;
                    this.f26615b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26615b;
                }

                public final Ui b() {
                    return this.f26614a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcStartPage)) {
                        return false;
                    }
                    PassportNfcStartPage passportNfcStartPage = (PassportNfcStartPage) obj;
                    return j.b(this.f26614a, passportNfcStartPage.f26614a) && j.b(this.f26615b, passportNfcStartPage.f26615b);
                }

                public int hashCode() {
                    int hashCode = this.f26614a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26615b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcStartPage(uiStep=" + this.f26614a + ", componentNameMapping=" + this.f26615b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            @i(generateAdapter = true)
            public static final class PassportNfcVerifyDetailsPage {

                /* renamed from: a  reason: collision with root package name */
                private final Ui f26617a;

                /* renamed from: b  reason: collision with root package name */
                private final ComponentNameMapping f26618b;

                @i(generateAdapter = true)
                public static final class ComponentNameMapping {

                    /* renamed from: a  reason: collision with root package name */
                    private final String f26619a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f26620b;

                    /* renamed from: c  reason: collision with root package name */
                    private final String f26621c;

                    /* renamed from: d  reason: collision with root package name */
                    private final String f26622d;

                    public ComponentNameMapping(String str, String str2, String str3, String str4) {
                        this.f26619a = str;
                        this.f26620b = str2;
                        this.f26621c = str3;
                        this.f26622d = str4;
                    }

                    public final String a() {
                        return this.f26622d;
                    }

                    public final String b() {
                        return this.f26620b;
                    }

                    public final String c() {
                        return this.f26619a;
                    }

                    public final String d() {
                        return this.f26621c;
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ComponentNameMapping)) {
                            return false;
                        }
                        ComponentNameMapping componentNameMapping = (ComponentNameMapping) obj;
                        return j.b(this.f26619a, componentNameMapping.f26619a) && j.b(this.f26620b, componentNameMapping.f26620b) && j.b(this.f26621c, componentNameMapping.f26621c) && j.b(this.f26622d, componentNameMapping.f26622d);
                    }

                    public int hashCode() {
                        String str = this.f26619a;
                        int i10 = 0;
                        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.f26620b;
                        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.f26621c;
                        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        String str4 = this.f26622d;
                        if (str4 != null) {
                            i10 = str4.hashCode();
                        }
                        return hashCode3 + i10;
                    }

                    public String toString() {
                        return "ComponentNameMapping(documentNumber=" + this.f26619a + ", dob=" + this.f26620b + ", exp=" + this.f26621c + ", confirmButton=" + this.f26622d + PropertyUtils.MAPPED_DELIM2;
                    }
                }

                public PassportNfcVerifyDetailsPage(Ui ui2, ComponentNameMapping componentNameMapping) {
                    j.g(ui2, "uiStep");
                    this.f26617a = ui2;
                    this.f26618b = componentNameMapping;
                }

                public final ComponentNameMapping a() {
                    return this.f26618b;
                }

                public final Ui b() {
                    return this.f26617a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof PassportNfcVerifyDetailsPage)) {
                        return false;
                    }
                    PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage = (PassportNfcVerifyDetailsPage) obj;
                    return j.b(this.f26617a, passportNfcVerifyDetailsPage.f26617a) && j.b(this.f26618b, passportNfcVerifyDetailsPage.f26618b);
                }

                public int hashCode() {
                    int hashCode = this.f26617a.hashCode() * 31;
                    ComponentNameMapping componentNameMapping = this.f26618b;
                    return hashCode + (componentNameMapping == null ? 0 : componentNameMapping.hashCode());
                }

                public String toString() {
                    return "PassportNfcVerifyDetailsPage(uiStep=" + this.f26617a + ", componentNameMapping=" + this.f26618b + PropertyUtils.MAPPED_DELIM2;
                }
            }

            public Pages(PassportNfc passportNfc) {
                this.f26573a = passportNfc;
            }

            public final PassportNfc a() {
                return this.f26573a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Pages) && j.b(this.f26573a, ((Pages) obj).f26573a);
            }

            public int hashCode() {
                PassportNfc passportNfc = this.f26573a;
                if (passportNfc == null) {
                    return 0;
                }
                return passportNfc.hashCode();
            }

            public String toString() {
                return "Pages(passportNfc=" + this.f26573a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        @i(generateAdapter = false)
        public enum PassportNfcOption {
            REQUIRED,
            OPTIONAL,
            REQUIRED_IF_SUPPORTED;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<PassportNfcOption> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, PassportNfcOption passportNfcOption) {
                    j.g(qVar, "writer");
                }

                @f
                public PassportNfcOption fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, FormField.Required.ELEMENT)) {
                        return PassportNfcOption.REQUIRED;
                    }
                    if (j.b(J, Session.Feature.OPTIONAL_ELEMENT)) {
                        return PassportNfcOption.OPTIONAL;
                    }
                    if (j.b(J, "required_if_supported")) {
                        return PassportNfcOption.REQUIRED_IF_SUPPORTED;
                    }
                    return PassportNfcOption.OPTIONAL;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        @i(generateAdapter = true)
        public static final class PendingPage implements Parcelable {
            public static final Parcelable.Creator<PendingPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26623a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26624b;

            public static final class a implements Parcelable.Creator<PendingPage> {
                /* renamed from: a */
                public final PendingPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PendingPage(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PendingPage[] newArray(int i10) {
                    return new PendingPage[i10];
                }
            }

            public PendingPage(String str, String str2) {
                j.g(str, "title");
                j.g(str2, "description");
                this.f26623a = str;
                this.f26624b = str2;
            }

            public final String a() {
                return this.f26624b;
            }

            public final String c() {
                return this.f26623a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26623a);
                parcel.writeString(this.f26624b);
            }
        }

        @i(generateAdapter = true)
        public static final class PromptPage implements Parcelable {
            public static final Parcelable.Creator<PromptPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26625a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26626b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26627c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26628d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26629e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26630f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26631g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26632h;

            public static final class a implements Parcelable.Creator<PromptPage> {
                /* renamed from: a */
                public final PromptPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PromptPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PromptPage[] newArray(int i10) {
                    return new PromptPage[i10];
                }
            }

            public PromptPage(String str, String str2, @g(name = "cameraPermissionsBtnContinueMobile") String str3, @g(name = "cameraPermissionsBtnCancel") String str4, String str5, String str6, String str7, String str8) {
                this.f26625a = str;
                this.f26626b = str2;
                this.f26627c = str3;
                this.f26628d = str4;
                this.f26629e = str5;
                this.f26630f = str6;
                this.f26631g = str7;
                this.f26632h = str8;
            }

            public final String a() {
                return this.f26627c;
            }

            public final String c() {
                return this.f26628d;
            }

            public final String d() {
                return this.f26626b;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26625a;
            }

            public final String f() {
                return this.f26629e;
            }

            public final String g() {
                return this.f26630f;
            }

            public final String h() {
                return this.f26631g;
            }

            public final String i() {
                return this.f26632h;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26625a);
                parcel.writeString(this.f26626b);
                parcel.writeString(this.f26627c);
                parcel.writeString(this.f26628d);
                parcel.writeString(this.f26629e);
                parcel.writeString(this.f26630f);
                parcel.writeString(this.f26631g);
                parcel.writeString(this.f26632h);
            }
        }

        @i(generateAdapter = true)
        public static final class RequestPage implements Parcelable {
            public static final Parcelable.Creator<RequestPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26633a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26634b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26635c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26636d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26637e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26638f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26639g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26640h;

            /* renamed from: j  reason: collision with root package name */
            private final String f26641j;

            /* renamed from: k  reason: collision with root package name */
            private final String f26642k;

            /* renamed from: l  reason: collision with root package name */
            private final gk.f f26643l = b.b(new NextStep$GovernmentId$RequestPage$titleBySide$2(this));

            /* renamed from: m  reason: collision with root package name */
            private final gk.f f26644m = b.b(new NextStep$GovernmentId$RequestPage$descriptionBySide$2(this));

            public static final class a implements Parcelable.Creator<RequestPage> {
                /* renamed from: a */
                public final RequestPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new RequestPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final RequestPage[] newArray(int i10) {
                    return new RequestPage[i10];
                }
            }

            public RequestPage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
                j.g(str, "titleFront");
                j.g(str2, "titleBack");
                j.g(str3, "titlePdf417");
                j.g(str4, "titlePassportSignature");
                j.g(str5, "descriptionFront");
                j.g(str6, "descriptionBack");
                j.g(str7, "descriptionPdf417");
                j.g(str8, "descriptionPassportSignature");
                j.g(str9, "choosePhotoButtonText");
                j.g(str10, "liveUploadButtonText");
                this.f26633a = str;
                this.f26634b = str2;
                this.f26635c = str3;
                this.f26636d = str4;
                this.f26637e = str5;
                this.f26638f = str6;
                this.f26639g = str7;
                this.f26640h = str8;
                this.f26641j = str9;
                this.f26642k = str10;
            }

            public final String a() {
                return this.f26641j;
            }

            public final String c() {
                return this.f26638f;
            }

            public final Map<Pair<IdConfig.Side, String>, String> d() {
                return (Map) this.f26644m.getValue();
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26637e;
            }

            public final String f() {
                return this.f26640h;
            }

            public final String g() {
                return this.f26639g;
            }

            public final String h() {
                return this.f26642k;
            }

            public final String i() {
                return this.f26634b;
            }

            public final Map<Pair<IdConfig.Side, String>, String> j() {
                return (Map) this.f26643l.getValue();
            }

            public final String k() {
                return this.f26633a;
            }

            public final String l() {
                return this.f26636d;
            }

            public final String m() {
                return this.f26635c;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26633a);
                parcel.writeString(this.f26634b);
                parcel.writeString(this.f26635c);
                parcel.writeString(this.f26636d);
                parcel.writeString(this.f26637e);
                parcel.writeString(this.f26638f);
                parcel.writeString(this.f26639g);
                parcel.writeString(this.f26640h);
                parcel.writeString(this.f26641j);
                parcel.writeString(this.f26642k);
            }
        }

        @i(generateAdapter = true)
        public static final class ReviewUploadPage implements Parcelable {
            public static final Parcelable.Creator<ReviewUploadPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26645a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26646b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26647c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26648d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26649e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26650f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26651g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26652h;

            /* renamed from: j  reason: collision with root package name */
            private final String f26653j;

            /* renamed from: k  reason: collision with root package name */
            private final String f26654k;

            /* renamed from: l  reason: collision with root package name */
            private final gk.f f26655l = b.b(new NextStep$GovernmentId$ReviewUploadPage$titleBySide$2(this));

            /* renamed from: m  reason: collision with root package name */
            private final gk.f f26656m = b.b(new NextStep$GovernmentId$ReviewUploadPage$descriptionBySide$2(this));

            public static final class a implements Parcelable.Creator<ReviewUploadPage> {
                /* renamed from: a */
                public final ReviewUploadPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new ReviewUploadPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final ReviewUploadPage[] newArray(int i10) {
                    return new ReviewUploadPage[i10];
                }
            }

            public ReviewUploadPage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
                j.g(str, "titleFront");
                j.g(str2, "titleBack");
                j.g(str3, "titlePdf417");
                j.g(str4, "titlePassportSignature");
                j.g(str5, "descriptionFront");
                j.g(str6, "descriptionBack");
                j.g(str7, "descriptionPdf417");
                j.g(str8, "descriptionPassportSignature");
                j.g(str9, "confirmButtonText");
                j.g(str10, "chooseAnotherButtonText");
                this.f26645a = str;
                this.f26646b = str2;
                this.f26647c = str3;
                this.f26648d = str4;
                this.f26649e = str5;
                this.f26650f = str6;
                this.f26651g = str7;
                this.f26652h = str8;
                this.f26653j = str9;
                this.f26654k = str10;
            }

            public final String a() {
                return this.f26654k;
            }

            public final String c() {
                return this.f26653j;
            }

            public final String d() {
                return this.f26650f;
            }

            public int describeContents() {
                return 0;
            }

            public final Map<IdConfig.Side, String> e() {
                return (Map) this.f26656m.getValue();
            }

            public final String f() {
                return this.f26649e;
            }

            public final String g() {
                return this.f26652h;
            }

            public final String h() {
                return this.f26651g;
            }

            public final String i() {
                return this.f26646b;
            }

            public final Map<IdConfig.Side, String> j() {
                return (Map) this.f26655l.getValue();
            }

            public final String k() {
                return this.f26645a;
            }

            public final String l() {
                return this.f26648d;
            }

            public final String m() {
                return this.f26647c;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26645a);
                parcel.writeString(this.f26646b);
                parcel.writeString(this.f26647c);
                parcel.writeString(this.f26648d);
                parcel.writeString(this.f26649e);
                parcel.writeString(this.f26650f);
                parcel.writeString(this.f26651g);
                parcel.writeString(this.f26652h);
                parcel.writeString(this.f26653j);
                parcel.writeString(this.f26654k);
            }
        }

        @i(generateAdapter = false)
        public static final class SelectPage implements Parcelable {
            public static final Parcelable.Creator<SelectPage> CREATOR = new a();

            /* renamed from: f  reason: collision with root package name */
            public static final Companion f26657f = new Companion((DefaultConstructorMarker) null);

            /* renamed from: a  reason: collision with root package name */
            private final String f26658a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26659b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26660c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26661d;

            /* renamed from: e  reason: collision with root package name */
            private final Map<String, String> f26662e;

            public static final class Companion extends h<SelectPage> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, SelectPage selectPage) {
                    j.g(qVar, "writer");
                }

                /* JADX WARNING: Can't fix incorrect switch cases order */
                @com.squareup.moshi.f
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.SelectPage fromJson(com.squareup.moshi.JsonReader r10) {
                    /*
                        r9 = this;
                        java.lang.String r0 = "reader"
                        kotlin.jvm.internal.j.g(r10, r0)
                        java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                        r6.<init>()
                        r10.b()
                        java.lang.String r0 = ""
                        r1 = 0
                        r2 = r0
                        r3 = r2
                        r4 = r3
                        r5 = r1
                    L_0x0014:
                        boolean r0 = r10.g()
                        if (r0 == 0) goto L_0x008d
                        java.lang.String r0 = r10.u()
                        java.lang.String r1 = "reader.nextString()"
                        if (r0 == 0) goto L_0x006b
                        int r7 = r0.hashCode()
                        switch(r7) {
                            case -979805852: goto L_0x005a;
                            case 110371416: goto L_0x0049;
                            case 432371099: goto L_0x003b;
                            case 1282023341: goto L_0x002a;
                            default: goto L_0x0029;
                        }
                    L_0x0029:
                        goto L_0x006b
                    L_0x002a:
                        java.lang.String r7 = "optionNotice"
                        boolean r7 = r0.equals(r7)
                        if (r7 != 0) goto L_0x0033
                        goto L_0x006b
                    L_0x0033:
                        java.lang.String r4 = r10.y()
                        kotlin.jvm.internal.j.f(r4, r1)
                        goto L_0x0014
                    L_0x003b:
                        java.lang.String r7 = "disclaimer"
                        boolean r7 = r0.equals(r7)
                        if (r7 != 0) goto L_0x0044
                        goto L_0x006b
                    L_0x0044:
                        java.lang.String r5 = ti.d.a(r10)
                        goto L_0x0014
                    L_0x0049:
                        java.lang.String r7 = "title"
                        boolean r7 = r0.equals(r7)
                        if (r7 != 0) goto L_0x0052
                        goto L_0x006b
                    L_0x0052:
                        java.lang.String r2 = r10.y()
                        kotlin.jvm.internal.j.f(r2, r1)
                        goto L_0x0014
                    L_0x005a:
                        java.lang.String r7 = "prompt"
                        boolean r7 = r0.equals(r7)
                        if (r7 != 0) goto L_0x0063
                        goto L_0x006b
                    L_0x0063:
                        java.lang.String r3 = r10.y()
                        kotlin.jvm.internal.j.f(r3, r1)
                        goto L_0x0014
                    L_0x006b:
                        boolean r7 = r10.g()
                        if (r7 == 0) goto L_0x0089
                        com.squareup.moshi.JsonReader$Token r7 = r10.E()
                        com.squareup.moshi.JsonReader$Token r8 = com.squareup.moshi.JsonReader.Token.STRING
                        if (r7 != r8) goto L_0x0089
                        java.lang.String r7 = "key"
                        kotlin.jvm.internal.j.f(r0, r7)
                        java.lang.String r7 = r10.y()
                        kotlin.jvm.internal.j.f(r7, r1)
                        r6.put(r0, r7)
                        goto L_0x0014
                    L_0x0089:
                        r10.Y()
                        goto L_0x0014
                    L_0x008d:
                        r10.e()
                        com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$SelectPage r10 = new com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$SelectPage
                        r1 = r10
                        r1.<init>(r2, r3, r4, r5, r6)
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.SelectPage.Companion.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$SelectPage");
                }
            }

            public static final class a implements Parcelable.Creator<SelectPage> {
                /* renamed from: a */
                public final SelectPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                    }
                    return new SelectPage(readString, readString2, readString3, readString4, linkedHashMap);
                }

                /* renamed from: b */
                public final SelectPage[] newArray(int i10) {
                    return new SelectPage[i10];
                }
            }

            public SelectPage(String str, String str2, String str3, String str4, Map<String, String> map) {
                j.g(str, "title");
                j.g(str2, "prompt");
                j.g(str3, "choose");
                j.g(map, "idClassToName");
                this.f26658a = str;
                this.f26659b = str2;
                this.f26660c = str3;
                this.f26661d = str4;
                this.f26662e = map;
            }

            public final String a() {
                return this.f26660c;
            }

            public final String c() {
                return this.f26661d;
            }

            public final Map<String, String> d() {
                return this.f26662e;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26659b;
            }

            public final String f() {
                return this.f26658a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26658a);
                parcel.writeString(this.f26659b);
                parcel.writeString(this.f26660c);
                parcel.writeString(this.f26661d);
                Map<String, String> map = this.f26662e;
                parcel.writeInt(map.size());
                for (Map.Entry next : map.entrySet()) {
                    parcel.writeString((String) next.getKey());
                    parcel.writeString((String) next.getValue());
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GovernmentId(String str, Config config, StepStyles$GovernmentIdStepStyle stepStyles$GovernmentIdStepStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            j.g(config, "config");
            this.f26515c = str;
            this.f26516d = config;
            this.f26517e = stepStyles$GovernmentIdStepStyle;
        }

        public String a() {
            return this.f26515c;
        }

        public final Config c() {
            return this.f26516d;
        }

        public final StepStyles$GovernmentIdStepStyle d() {
            return this.f26517e;
        }
    }

    @i(generateAdapter = true)
    public static final class PassportNfc implements Parcelable {
        public static final Parcelable.Creator<PassportNfc> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f26663a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26664b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26665c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26666d;

        /* renamed from: e  reason: collision with root package name */
        private final String f26667e;

        /* renamed from: f  reason: collision with root package name */
        private final String f26668f;

        /* renamed from: g  reason: collision with root package name */
        private final String f26669g;

        /* renamed from: h  reason: collision with root package name */
        private final String f26670h;

        /* renamed from: j  reason: collision with root package name */
        private final String f26671j;

        public static final class a implements Parcelable.Creator<PassportNfc> {
            /* renamed from: a */
            public final PassportNfc createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new PassportNfc(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final PassportNfc[] newArray(int i10) {
                return new PassportNfc[i10];
            }
        }

        public PassportNfc(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.f26663a = str;
            this.f26664b = str2;
            this.f26665c = str3;
            this.f26666d = str4;
            this.f26667e = str5;
            this.f26668f = str6;
            this.f26669g = str7;
            this.f26670h = str8;
            this.f26671j = str9;
        }

        public final String a() {
            return this.f26669g;
        }

        public final String c() {
            return this.f26668f;
        }

        public final String d() {
            return this.f26667e;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f26666d;
        }

        public final String f() {
            return this.f26665c;
        }

        public final String g() {
            return this.f26664b;
        }

        public final String h() {
            return this.f26663a;
        }

        public final String i() {
            return this.f26671j;
        }

        public final String j() {
            return this.f26670h;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26663a);
            parcel.writeString(this.f26664b);
            parcel.writeString(this.f26665c);
            parcel.writeString(this.f26666d);
            parcel.writeString(this.f26667e);
            parcel.writeString(this.f26668f);
            parcel.writeString(this.f26669g);
            parcel.writeString(this.f26670h);
            parcel.writeString(this.f26671j);
        }
    }

    @i(generateAdapter = true)
    public static final class Selfie extends NextStep {

        /* renamed from: c  reason: collision with root package name */
        private final String f26672c;

        /* renamed from: d  reason: collision with root package name */
        private final Config f26673d;

        /* renamed from: e  reason: collision with root package name */
        private final StepStyles$SelfieStepStyle f26674e;

        @i(generateAdapter = false)
        public enum CaptureFileType {
            IMAGE,
            VIDEO,
            UNKNOWN;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<CaptureFileType> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, CaptureFileType captureFileType) {
                    j.g(qVar, "writer");
                }

                @f
                public CaptureFileType fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                        return CaptureFileType.VIDEO;
                    }
                    if (j.b(J, "image")) {
                        return CaptureFileType.IMAGE;
                    }
                    return CaptureFileType.UNKNOWN;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        @i(generateAdapter = false)
        public enum CaptureMethod {
            ONLY_CENTER,
            PROFILE_AND_CENTER
        }

        @i(generateAdapter = true)
        public static final class CapturePage implements Parcelable {
            public static final Parcelable.Creator<CapturePage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26675a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26676b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26677c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26678d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26679e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26680f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26681g;

            public static final class a implements Parcelable.Creator<CapturePage> {
                /* renamed from: a */
                public final CapturePage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new CapturePage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final CapturePage[] newArray(int i10) {
                    return new CapturePage[i10];
                }
            }

            public CapturePage(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                j.g(str, "selfieHintTakePhoto");
                j.g(str2, "selfieHintCenterFace");
                j.g(str3, "selfieHintFaceTooClose");
                j.g(str4, "selfieHintPoseNotCenter");
                j.g(str5, "selfieHintLookLeft");
                j.g(str6, "selfieHintLookRight");
                j.g(str7, "selfieHintHoldStill");
                this.f26675a = str;
                this.f26676b = str2;
                this.f26677c = str3;
                this.f26678d = str4;
                this.f26679e = str5;
                this.f26680f = str6;
                this.f26681g = str7;
            }

            public final String a() {
                return this.f26676b;
            }

            public final String c() {
                return this.f26677c;
            }

            public final String d() {
                return this.f26681g;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26679e;
            }

            public final String f() {
                return this.f26680f;
            }

            public final String g() {
                return this.f26678d;
            }

            public final String h() {
                return this.f26675a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26675a);
                parcel.writeString(this.f26676b);
                parcel.writeString(this.f26677c);
                parcel.writeString(this.f26678d);
                parcel.writeString(this.f26679e);
                parcel.writeString(this.f26680f);
                parcel.writeString(this.f26681g);
            }
        }

        @i(generateAdapter = true)
        public static final class Config {

            /* renamed from: a  reason: collision with root package name */
            private final CaptureMethod f26682a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f26683b;

            /* renamed from: c  reason: collision with root package name */
            private final Boolean f26684c;

            /* renamed from: d  reason: collision with root package name */
            private final Localizations f26685d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26686e;

            /* renamed from: f  reason: collision with root package name */
            private final Boolean f26687f;

            /* renamed from: g  reason: collision with root package name */
            private final List<CaptureFileType> f26688g;

            public Config(CaptureMethod captureMethod, Boolean bool, Boolean bool2, Localizations localizations, String str, Boolean bool3, List<? extends CaptureFileType> list) {
                j.g(captureMethod, "selfieType");
                j.g(localizations, "localizations");
                j.g(str, "fieldKeySelfie");
                this.f26682a = captureMethod;
                this.f26683b = bool;
                this.f26684c = bool2;
                this.f26685d = localizations;
                this.f26686e = str;
                this.f26687f = bool3;
                this.f26688g = list;
            }

            public final Boolean a() {
                return this.f26683b;
            }

            public final Boolean b() {
                return this.f26684c;
            }

            public final List<CaptureFileType> c() {
                return this.f26688g;
            }

            public final String d() {
                return this.f26686e;
            }

            public final Localizations e() {
                return this.f26685d;
            }

            public final CaptureMethod f() {
                return this.f26682a;
            }

            public final Boolean g() {
                return this.f26687f;
            }
        }

        @i(generateAdapter = true)
        public static final class Localizations implements Parcelable {
            public static final Parcelable.Creator<Localizations> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final PromptPage f26689a;

            /* renamed from: b  reason: collision with root package name */
            private final CapturePage f26690b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingPage f26691c;

            /* renamed from: d  reason: collision with root package name */
            private final CancelDialog f26692d;

            public static final class a implements Parcelable.Creator<Localizations> {
                /* renamed from: a */
                public final Localizations createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Localizations(PromptPage.CREATOR.createFromParcel(parcel), CapturePage.CREATOR.createFromParcel(parcel), PendingPage.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : CancelDialog.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Localizations[] newArray(int i10) {
                    return new Localizations[i10];
                }
            }

            public Localizations(PromptPage promptPage, CapturePage capturePage, PendingPage pendingPage, CancelDialog cancelDialog) {
                j.g(promptPage, "promptPage");
                j.g(capturePage, "capturePage");
                j.g(pendingPage, "pendingPage");
                this.f26689a = promptPage;
                this.f26690b = capturePage;
                this.f26691c = pendingPage;
                this.f26692d = cancelDialog;
            }

            public final CancelDialog a() {
                return this.f26692d;
            }

            public final CapturePage c() {
                return this.f26690b;
            }

            public final PendingPage d() {
                return this.f26691c;
            }

            public int describeContents() {
                return 0;
            }

            public final PromptPage e() {
                return this.f26689a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                this.f26689a.writeToParcel(parcel, i10);
                this.f26690b.writeToParcel(parcel, i10);
                this.f26691c.writeToParcel(parcel, i10);
                CancelDialog cancelDialog = this.f26692d;
                if (cancelDialog == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class PendingPage implements Parcelable {
            public static final Parcelable.Creator<PendingPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26693a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26694b;

            public static final class a implements Parcelable.Creator<PendingPage> {
                /* renamed from: a */
                public final PendingPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PendingPage(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PendingPage[] newArray(int i10) {
                    return new PendingPage[i10];
                }
            }

            public PendingPage(String str, String str2) {
                j.g(str, "title");
                j.g(str2, "description");
                this.f26693a = str;
                this.f26694b = str2;
            }

            public final String a() {
                return this.f26694b;
            }

            public final String c() {
                return this.f26693a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26693a);
                parcel.writeString(this.f26694b);
            }
        }

        @i(generateAdapter = true)
        public static final class PromptPage implements Parcelable {
            public static final Parcelable.Creator<PromptPage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f26695a;

            /* renamed from: b  reason: collision with root package name */
            private final String f26696b;

            /* renamed from: c  reason: collision with root package name */
            private final String f26697c;

            /* renamed from: d  reason: collision with root package name */
            private final String f26698d;

            /* renamed from: e  reason: collision with root package name */
            private final String f26699e;

            /* renamed from: f  reason: collision with root package name */
            private final String f26700f;

            /* renamed from: g  reason: collision with root package name */
            private final String f26701g;

            /* renamed from: h  reason: collision with root package name */
            private final String f26702h;

            /* renamed from: j  reason: collision with root package name */
            private final String f26703j;

            /* renamed from: k  reason: collision with root package name */
            private final String f26704k;

            /* renamed from: l  reason: collision with root package name */
            private final String f26705l;

            /* renamed from: m  reason: collision with root package name */
            private final String f26706m;

            /* renamed from: n  reason: collision with root package name */
            private final String f26707n;

            public static final class a implements Parcelable.Creator<PromptPage> {
                /* renamed from: a */
                public final PromptPage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PromptPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final PromptPage[] newArray(int i10) {
                    return new PromptPage[i10];
                }
            }

            public PromptPage(@g(name = "selfieTitle") String str, @g(name = "selfiePrompt") String str2, @g(name = "selfiePromptCenter") String str3, @g(name = "agreeToPolicy") String str4, @g(name = "btnSubmit") String str5, String str6, String str7, @g(name = "cameraPermissionsBtnContinueMobile") String str8, @g(name = "cameraPermissionsBtnCancel") String str9, String str10, String str11, String str12, String str13) {
                j.g(str, "title");
                j.g(str2, "prompt");
                j.g(str3, "promptCenter");
                j.g(str4, "disclosure");
                j.g(str5, "buttonSubmit");
                this.f26695a = str;
                this.f26696b = str2;
                this.f26697c = str3;
                this.f26698d = str4;
                this.f26699e = str5;
                this.f26700f = str6;
                this.f26701g = str7;
                this.f26702h = str8;
                this.f26703j = str9;
                this.f26704k = str10;
                this.f26705l = str11;
                this.f26706m = str12;
                this.f26707n = str13;
            }

            public final String a() {
                return this.f26699e;
            }

            public final String c() {
                return this.f26702h;
            }

            public final String d() {
                return this.f26703j;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f26701g;
            }

            public final String f() {
                return this.f26700f;
            }

            public final String g() {
                return this.f26698d;
            }

            public final String h() {
                return this.f26704k;
            }

            public final String i() {
                return this.f26705l;
            }

            public final String j() {
                return this.f26706m;
            }

            public final String k() {
                return this.f26707n;
            }

            public final String l() {
                return this.f26696b;
            }

            public final String m() {
                return this.f26697c;
            }

            public final String n() {
                return this.f26695a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f26695a);
                parcel.writeString(this.f26696b);
                parcel.writeString(this.f26697c);
                parcel.writeString(this.f26698d);
                parcel.writeString(this.f26699e);
                parcel.writeString(this.f26700f);
                parcel.writeString(this.f26701g);
                parcel.writeString(this.f26702h);
                parcel.writeString(this.f26703j);
                parcel.writeString(this.f26704k);
                parcel.writeString(this.f26705l);
                parcel.writeString(this.f26706m);
                parcel.writeString(this.f26707n);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Selfie(String str, Config config, StepStyles$SelfieStepStyle stepStyles$SelfieStepStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            j.g(config, "config");
            this.f26672c = str;
            this.f26673d = config;
            this.f26674e = stepStyles$SelfieStepStyle;
        }

        public String a() {
            return this.f26672c;
        }

        public final Config c() {
            return this.f26673d;
        }

        public final StepStyles$SelfieStepStyle d() {
            return this.f26674e;
        }
    }

    @i(generateAdapter = true)
    public static final class Ui extends NextStep implements Parcelable {
        public static final Parcelable.Creator<Ui> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private final String f26708c;

        /* renamed from: d  reason: collision with root package name */
        private final Config f26709d;

        /* renamed from: e  reason: collision with root package name */
        private final StepStyles$UiStepStyle f26710e;

        @i(generateAdapter = true)
        public static final class Config implements Parcelable {
            public static final Parcelable.Creator<Config> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final List<UiComponent> f26711a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f26712b;

            /* renamed from: c  reason: collision with root package name */
            private final Boolean f26713c;

            /* renamed from: d  reason: collision with root package name */
            private final Boolean f26714d;

            /* renamed from: e  reason: collision with root package name */
            private final Localizations f26715e;

            public static final class a implements Parcelable.Creator<Config> {
                /* renamed from: a */
                public final Config createFromParcel(Parcel parcel) {
                    ArrayList arrayList;
                    Boolean bool;
                    Boolean bool2;
                    Boolean bool3;
                    j.g(parcel, "parcel");
                    boolean z10 = false;
                    Localizations localizations = null;
                    if (parcel.readInt() == 0) {
                        arrayList = null;
                    } else {
                        int readInt = parcel.readInt();
                        ArrayList arrayList2 = new ArrayList(readInt);
                        for (int i10 = 0; i10 != readInt; i10++) {
                            arrayList2.add(parcel.readParcelable(Config.class.getClassLoader()));
                        }
                        arrayList = arrayList2;
                    }
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    if (parcel.readInt() == 0) {
                        bool2 = null;
                    } else {
                        bool2 = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    if (parcel.readInt() == 0) {
                        bool3 = null;
                    } else {
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        }
                        bool3 = Boolean.valueOf(z10);
                    }
                    if (parcel.readInt() != 0) {
                        localizations = Localizations.CREATOR.createFromParcel(parcel);
                    }
                    return new Config(arrayList, bool, bool2, bool3, localizations);
                }

                /* renamed from: b */
                public final Config[] newArray(int i10) {
                    return new Config[i10];
                }
            }

            public Config(List<? extends UiComponent> list, Boolean bool, Boolean bool2, Boolean bool3, Localizations localizations) {
                this.f26711a = list;
                this.f26712b = bool;
                this.f26713c = bool2;
                this.f26714d = bool3;
                this.f26715e = localizations;
            }

            public final Boolean a() {
                return this.f26712b;
            }

            public final Boolean c() {
                return this.f26713c;
            }

            public final Localizations d() {
                return this.f26715e;
            }

            public int describeContents() {
                return 0;
            }

            public final Boolean e() {
                return this.f26714d;
            }

            public final List<UiComponent> getComponents() {
                return this.f26711a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                List<UiComponent> list = this.f26711a;
                if (list == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(list.size());
                    for (UiComponent writeParcelable : list) {
                        parcel.writeParcelable(writeParcelable, i10);
                    }
                }
                Boolean bool = this.f26712b;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                Boolean bool2 = this.f26713c;
                if (bool2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool2.booleanValue() ? 1 : 0);
                }
                Boolean bool3 = this.f26714d;
                if (bool3 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool3.booleanValue() ? 1 : 0);
                }
                Localizations localizations = this.f26715e;
                if (localizations == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                localizations.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Localizations implements Parcelable {
            public static final Parcelable.Creator<Localizations> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final CancelDialog f26716a;

            public static final class a implements Parcelable.Creator<Localizations> {
                /* renamed from: a */
                public final Localizations createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Localizations(parcel.readInt() == 0 ? null : CancelDialog.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Localizations[] newArray(int i10) {
                    return new Localizations[i10];
                }
            }

            public Localizations(CancelDialog cancelDialog) {
                this.f26716a = cancelDialog;
            }

            public final CancelDialog a() {
                return this.f26716a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                CancelDialog cancelDialog = this.f26716a;
                if (cancelDialog == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                cancelDialog.writeToParcel(parcel, i10);
            }
        }

        public static final class a implements Parcelable.Creator<Ui> {
            /* renamed from: a */
            public final Ui createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Ui(parcel.readString(), Config.CREATOR.createFromParcel(parcel), (StepStyles$UiStepStyle) parcel.readParcelable(Ui.class.getClassLoader()));
            }

            /* renamed from: b */
            public final Ui[] newArray(int i10) {
                return new Ui[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ui(String str, Config config, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            j.g(config, "config");
            this.f26708c = str;
            this.f26709d = config;
            this.f26710e = stepStyles$UiStepStyle;
        }

        public String a() {
            return this.f26708c;
        }

        public final StepStyles$UiStepStyle b() {
            return this.f26710e;
        }

        public final Config c() {
            return this.f26709d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26708c);
            this.f26709d.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f26710e, i10);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.e a() {
            ai.b<NextStep> e10 = ai.b.b(NextStep.class, "type").c(b.f26717c).e(Ui.class, "ui").e(GovernmentId.class, "government_id").e(Selfie.class, "selfie").e(Document.class, "document").e(Complete.class, "complete");
            j.f(e10, "of(NextStep::class.java,…::class.java, \"complete\")");
            return e10;
        }
    }

    public static final class b extends NextStep {

        /* renamed from: c  reason: collision with root package name */
        public static final b f26717c = new b();

        private b() {
            super("unknown", (DefaultConstructorMarker) null);
        }
    }

    private NextStep(String str) {
        this.f26466a = str;
    }

    public /* synthetic */ NextStep(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String a() {
        return this.f26466a;
    }
}
