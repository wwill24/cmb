package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import coil.ImageLoader;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker;
import com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentWorkflow extends h<b, State, c, Object> {

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f25006a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f25007b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionRequestWorkflow f25008c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final DocumentCameraWorker f25009d;

    /* renamed from: e  reason: collision with root package name */
    private final DocumentsSelectWorker.Factory f25010e;

    /* renamed from: f  reason: collision with root package name */
    private final DocumentCreateWorker.a f25011f;

    /* renamed from: g  reason: collision with root package name */
    private final DocumentLoadWorker.a f25012g;

    /* renamed from: h  reason: collision with root package name */
    private final DocumentFileUploadWorker.a f25013h;

    /* renamed from: i  reason: collision with root package name */
    private final DocumentFileDeleteWorker.a f25014i;

    /* renamed from: j  reason: collision with root package name */
    private final DocumentSubmitWorker.a f25015j;

    public enum StartPage {
        Prompt,
        Review
    }

    public static abstract class State implements Parcelable {

        /* renamed from: a  reason: collision with root package name */
        private final CaptureState f25019a;

        /* renamed from: b  reason: collision with root package name */
        private final UploadState f25020b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25021c;

        /* renamed from: d  reason: collision with root package name */
        private final List<DocumentFile> f25022d;

        public enum CaptureState {
            None,
            CheckCameraPermissions,
            CameraRunning,
            SelectFileFromDocuments,
            SelectImageFromPhotoLibrary
        }

        public enum UploadState {
            CreateDocument,
            UploadFiles,
            DeleteFiles,
            ReadyToSubmit
        }

        private State(CaptureState captureState, UploadState uploadState, String str, List<? extends DocumentFile> list) {
            this.f25019a = captureState;
            this.f25020b = uploadState;
            this.f25021c = str;
            this.f25022d = list;
        }

        public /* synthetic */ State(CaptureState captureState, UploadState uploadState, String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(captureState, uploadState, str, list);
        }

        public static /* synthetic */ State e(State state, UploadState uploadState, String str, List list, DocumentFile documentFile, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str = null;
                }
                if ((i10 & 4) != 0) {
                    list = null;
                }
                if ((i10 & 8) != 0) {
                    documentFile = null;
                }
                return state.d(uploadState, str, list, documentFile);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyWithUploadState");
        }

        public final State a(CaptureState captureState) {
            j.g(captureState, "captureState");
            if (this instanceof Start) {
                return Start.k((Start) this, captureState, (UploadState) null, (String) null, false, 14, (Object) null);
            }
            if (this instanceof ReviewCaptures) {
                return ReviewCaptures.k((ReviewCaptures) this, (List) null, (String) null, captureState, (UploadState) null, (DocumentFile) null, false, false, (String) null, 251, (Object) null);
            }
            if (this instanceof UploadDocument) {
                return this;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final State c(boolean z10) {
            if (this instanceof Start) {
                return Start.k((Start) this, (CaptureState) null, (UploadState) null, (String) null, z10, 7, (Object) null);
            }
            if (this instanceof ReviewCaptures) {
                return ReviewCaptures.k((ReviewCaptures) this, (List) null, (String) null, (CaptureState) null, (UploadState) null, (DocumentFile) null, false, z10, (String) null, Opcodes.ATHROW, (Object) null);
            }
            if (this instanceof UploadDocument) {
                return this;
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
            if ((r11 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument) == false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
            throw new kotlin.NoWhenBranchMatchedException();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument.k((com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument) r11, (java.util.List) null, (java.lang.String) null, r12, (java.lang.String) null, 11, (java.lang.Object) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State d(com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState r12, java.lang.String r13, java.util.List<? extends com.withpersona.sdk2.inquiry.document.DocumentFile> r14, com.withpersona.sdk2.inquiry.document.DocumentFile r15) {
            /*
                r11 = this;
                java.lang.String r0 = "uploadState"
                kotlin.jvm.internal.j.g(r12, r0)
                boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.Start
                if (r0 == 0) goto L_0x001e
                r1 = r11
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$Start r1 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.Start) r1
                r2 = 0
                if (r13 != 0) goto L_0x0013
                java.lang.String r13 = r11.g()
            L_0x0013:
                r4 = r13
                r5 = 0
                r6 = 9
                r7 = 0
                r3 = r12
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$Start r12 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.Start.k(r1, r2, r3, r4, r5, r6, r7)
                goto L_0x004d
            L_0x001e:
                boolean r13 = r11 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures
                if (r13 == 0) goto L_0x003b
                if (r14 != 0) goto L_0x0028
                java.util.List r14 = r11.h()
            L_0x0028:
                r1 = r14
                r0 = r11
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$ReviewCaptures r0 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures) r0
                r2 = 0
                r3 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 230(0xe6, float:3.22E-43)
                r10 = 0
                r4 = r12
                r5 = r15
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$ReviewCaptures r12 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures.k(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                goto L_0x004d
            L_0x003b:
                boolean r13 = r11 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument
                if (r13 == 0) goto L_0x004e
                r0 = r11
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadDocument r0 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument) r0
                r1 = 0
                r2 = 0
                r4 = 0
                r5 = 11
                r6 = 0
                r3 = r12
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadDocument r12 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument.k(r0, r1, r2, r3, r4, r5, r6)
            L_0x004d:
                return r12
            L_0x004e:
                kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
                r12.<init>()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.d(com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState, java.lang.String, java.util.List, com.withpersona.sdk2.inquiry.document.DocumentFile):com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State");
        }

        public CaptureState f() {
            return this.f25019a;
        }

        public String g() {
            return this.f25021c;
        }

        public List<DocumentFile> h() {
            return this.f25022d;
        }

        public UploadState i() {
            return this.f25020b;
        }

        public static final class UploadDocument extends State {
            public static final Parcelable.Creator<UploadDocument> CREATOR = new a();

            /* renamed from: e  reason: collision with root package name */
            private final List<DocumentFile> f25041e;

            /* renamed from: f  reason: collision with root package name */
            private final String f25042f;

            /* renamed from: g  reason: collision with root package name */
            private final UploadState f25043g;

            /* renamed from: h  reason: collision with root package name */
            private final String f25044h;

            public static final class a implements Parcelable.Creator<UploadDocument> {
                /* renamed from: a */
                public final UploadDocument createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(parcel.readParcelable(UploadDocument.class.getClassLoader()));
                    }
                    return new UploadDocument(arrayList, parcel.readString(), UploadState.valueOf(parcel.readString()), parcel.readString());
                }

                /* renamed from: b */
                public final UploadDocument[] newArray(int i10) {
                    return new UploadDocument[i10];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ UploadDocument(List list, String str, UploadState uploadState, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, str, (i10 & 4) != 0 ? UploadState.CreateDocument : uploadState, (i10 & 8) != 0 ? null : str2);
            }

            public static /* synthetic */ UploadDocument k(UploadDocument uploadDocument, List<DocumentFile> list, String str, UploadState uploadState, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    list = uploadDocument.h();
                }
                if ((i10 & 2) != 0) {
                    str = uploadDocument.g();
                }
                if ((i10 & 4) != 0) {
                    uploadState = uploadDocument.i();
                }
                if ((i10 & 8) != 0) {
                    str2 = uploadDocument.f25044h;
                }
                return uploadDocument.j(list, str, uploadState, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UploadDocument)) {
                    return false;
                }
                UploadDocument uploadDocument = (UploadDocument) obj;
                return j.b(h(), uploadDocument.h()) && j.b(g(), uploadDocument.g()) && i() == uploadDocument.i() && j.b(this.f25044h, uploadDocument.f25044h);
            }

            public String g() {
                return this.f25042f;
            }

            public List<DocumentFile> h() {
                return this.f25041e;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = ((((h().hashCode() * 31) + (g() == null ? 0 : g().hashCode())) * 31) + i().hashCode()) * 31;
                String str = this.f25044h;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public UploadState i() {
                return this.f25043g;
            }

            public final UploadDocument j(List<? extends DocumentFile> list, String str, UploadState uploadState, String str2) {
                j.g(list, "documents");
                j.g(uploadState, "uploadState");
                return new UploadDocument(list, str, uploadState, str2);
            }

            public String toString() {
                return "UploadDocument(documents=" + h() + ", documentId=" + g() + ", uploadState=" + i() + ", error=" + this.f25044h + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                List<DocumentFile> list = this.f25041e;
                parcel.writeInt(list.size());
                for (DocumentFile writeParcelable : list) {
                    parcel.writeParcelable(writeParcelable, i10);
                }
                parcel.writeString(this.f25042f);
                parcel.writeString(this.f25043g.name());
                parcel.writeString(this.f25044h);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UploadDocument(List<? extends DocumentFile> list, String str, UploadState uploadState, String str2) {
                super(CaptureState.None, uploadState, str, list, (DefaultConstructorMarker) null);
                j.g(list, "documents");
                j.g(uploadState, "uploadState");
                this.f25041e = list;
                this.f25042f = str;
                this.f25043g = uploadState;
                this.f25044h = str2;
            }
        }

        public static final class ReviewCaptures extends State {
            public static final Parcelable.Creator<ReviewCaptures> CREATOR = new a();

            /* renamed from: e  reason: collision with root package name */
            private final List<DocumentFile> f25029e;

            /* renamed from: f  reason: collision with root package name */
            private final String f25030f;

            /* renamed from: g  reason: collision with root package name */
            private final CaptureState f25031g;

            /* renamed from: h  reason: collision with root package name */
            private final UploadState f25032h;

            /* renamed from: j  reason: collision with root package name */
            private final DocumentFile f25033j;

            /* renamed from: k  reason: collision with root package name */
            private final boolean f25034k;

            /* renamed from: l  reason: collision with root package name */
            private final boolean f25035l;

            /* renamed from: m  reason: collision with root package name */
            private final String f25036m;

            public static final class a implements Parcelable.Creator<ReviewCaptures> {
                /* renamed from: a */
                public final ReviewCaptures createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(parcel.readParcelable(ReviewCaptures.class.getClassLoader()));
                    }
                    return new ReviewCaptures(arrayList, parcel.readString(), CaptureState.valueOf(parcel.readString()), UploadState.valueOf(parcel.readString()), (DocumentFile) parcel.readParcelable(ReviewCaptures.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
                }

                /* renamed from: b */
                public final ReviewCaptures[] newArray(int i10) {
                    return new ReviewCaptures[i10];
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ ReviewCaptures(java.util.List r12, java.lang.String r13, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState r14, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState r15, com.withpersona.sdk2.inquiry.document.DocumentFile r16, boolean r17, boolean r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
                /*
                    r11 = this;
                    r0 = r20
                    r1 = r0 & 4
                    if (r1 == 0) goto L_0x000a
                    com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r1 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.None
                    r5 = r1
                    goto L_0x000b
                L_0x000a:
                    r5 = r14
                L_0x000b:
                    r1 = r0 & 8
                    if (r1 == 0) goto L_0x0013
                    com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r1 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.CreateDocument
                    r6 = r1
                    goto L_0x0014
                L_0x0013:
                    r6 = r15
                L_0x0014:
                    r1 = r0 & 16
                    r2 = 0
                    if (r1 == 0) goto L_0x001b
                    r7 = r2
                    goto L_0x001d
                L_0x001b:
                    r7 = r16
                L_0x001d:
                    r1 = r0 & 32
                    r3 = 0
                    if (r1 == 0) goto L_0x0024
                    r8 = r3
                    goto L_0x0026
                L_0x0024:
                    r8 = r17
                L_0x0026:
                    r1 = r0 & 64
                    if (r1 == 0) goto L_0x002c
                    r9 = r3
                    goto L_0x002e
                L_0x002c:
                    r9 = r18
                L_0x002e:
                    r0 = r0 & 128(0x80, float:1.794E-43)
                    if (r0 == 0) goto L_0x0034
                    r10 = r2
                    goto L_0x0036
                L_0x0034:
                    r10 = r19
                L_0x0036:
                    r2 = r11
                    r3 = r12
                    r4 = r13
                    r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures.<init>(java.util.List, java.lang.String, com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState, com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState, com.withpersona.sdk2.inquiry.document.DocumentFile, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public static /* synthetic */ ReviewCaptures k(ReviewCaptures reviewCaptures, List list, String str, CaptureState captureState, UploadState uploadState, DocumentFile documentFile, boolean z10, boolean z11, String str2, int i10, Object obj) {
                ReviewCaptures reviewCaptures2 = reviewCaptures;
                int i11 = i10;
                return reviewCaptures.j((i11 & 1) != 0 ? reviewCaptures.h() : list, (i11 & 2) != 0 ? reviewCaptures.g() : str, (i11 & 4) != 0 ? reviewCaptures.f() : captureState, (i11 & 8) != 0 ? reviewCaptures.i() : uploadState, (i11 & 16) != 0 ? reviewCaptures2.f25033j : documentFile, (i11 & 32) != 0 ? reviewCaptures2.f25034k : z10, (i11 & 64) != 0 ? reviewCaptures2.f25035l : z11, (i11 & 128) != 0 ? reviewCaptures2.f25036m : str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ReviewCaptures)) {
                    return false;
                }
                ReviewCaptures reviewCaptures = (ReviewCaptures) obj;
                return j.b(h(), reviewCaptures.h()) && j.b(g(), reviewCaptures.g()) && f() == reviewCaptures.f() && i() == reviewCaptures.i() && j.b(this.f25033j, reviewCaptures.f25033j) && this.f25034k == reviewCaptures.f25034k && this.f25035l == reviewCaptures.f25035l && j.b(this.f25036m, reviewCaptures.f25036m);
            }

            public CaptureState f() {
                return this.f25031g;
            }

            public String g() {
                return this.f25030f;
            }

            public final String getError() {
                return this.f25036m;
            }

            public List<DocumentFile> h() {
                return this.f25029e;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = ((((((h().hashCode() * 31) + (g() == null ? 0 : g().hashCode())) * 31) + f().hashCode()) * 31) + i().hashCode()) * 31;
                DocumentFile documentFile = this.f25033j;
                int hashCode2 = (hashCode + (documentFile == null ? 0 : documentFile.hashCode())) * 31;
                boolean z10 = this.f25034k;
                boolean z11 = true;
                if (z10) {
                    z10 = true;
                }
                int i11 = (hashCode2 + (z10 ? 1 : 0)) * 31;
                boolean z12 = this.f25035l;
                if (!z12) {
                    z11 = z12;
                }
                int i12 = (i11 + (z11 ? 1 : 0)) * 31;
                String str = this.f25036m;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return i12 + i10;
            }

            public UploadState i() {
                return this.f25032h;
            }

            public final ReviewCaptures j(List<? extends DocumentFile> list, String str, CaptureState captureState, UploadState uploadState, DocumentFile documentFile, boolean z10, boolean z11, String str2) {
                j.g(list, "documents");
                j.g(captureState, "captureState");
                j.g(uploadState, "uploadState");
                return new ReviewCaptures(list, str, captureState, uploadState, documentFile, z10, z11, str2);
            }

            public final DocumentFile l() {
                return this.f25033j;
            }

            public final boolean m() {
                return this.f25034k;
            }

            public final boolean n() {
                return this.f25035l;
            }

            public String toString() {
                return "ReviewCaptures(documents=" + h() + ", documentId=" + g() + ", captureState=" + f() + ", uploadState=" + i() + ", documentFileToDelete=" + this.f25033j + ", reloadingFromPreviousSession=" + this.f25034k + ", shouldShowUploadOptionsDialog=" + this.f25035l + ", error=" + this.f25036m + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                List<DocumentFile> list = this.f25029e;
                parcel.writeInt(list.size());
                for (DocumentFile writeParcelable : list) {
                    parcel.writeParcelable(writeParcelable, i10);
                }
                parcel.writeString(this.f25030f);
                parcel.writeString(this.f25031g.name());
                parcel.writeString(this.f25032h.name());
                parcel.writeParcelable(this.f25033j, i10);
                parcel.writeInt(this.f25034k ? 1 : 0);
                parcel.writeInt(this.f25035l ? 1 : 0);
                parcel.writeString(this.f25036m);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ReviewCaptures(List<? extends DocumentFile> list, String str, CaptureState captureState, UploadState uploadState, DocumentFile documentFile, boolean z10, boolean z11, String str2) {
                super(captureState, uploadState, str, list, (DefaultConstructorMarker) null);
                j.g(list, "documents");
                j.g(captureState, "captureState");
                j.g(uploadState, "uploadState");
                this.f25029e = list;
                this.f25030f = str;
                this.f25031g = captureState;
                this.f25032h = uploadState;
                this.f25033j = documentFile;
                this.f25034k = z10;
                this.f25035l = z11;
                this.f25036m = str2;
            }
        }

        public static final class Start extends State {
            public static final Parcelable.Creator<Start> CREATOR = new a();

            /* renamed from: e  reason: collision with root package name */
            private final CaptureState f25037e;

            /* renamed from: f  reason: collision with root package name */
            private final UploadState f25038f;

            /* renamed from: g  reason: collision with root package name */
            private final String f25039g;

            /* renamed from: h  reason: collision with root package name */
            private final boolean f25040h;

            public static final class a implements Parcelable.Creator<Start> {
                /* renamed from: a */
                public final Start createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Start(CaptureState.valueOf(parcel.readString()), UploadState.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0);
                }

                /* renamed from: b */
                public final Start[] newArray(int i10) {
                    return new Start[i10];
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Start(CaptureState captureState, UploadState uploadState, String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this((i10 & 1) != 0 ? CaptureState.None : captureState, (i10 & 2) != 0 ? UploadState.CreateDocument : uploadState, str, (i10 & 8) != 0 ? false : z10);
            }

            public static /* synthetic */ Start k(Start start, CaptureState captureState, UploadState uploadState, String str, boolean z10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    captureState = start.f();
                }
                if ((i10 & 2) != 0) {
                    uploadState = start.i();
                }
                if ((i10 & 4) != 0) {
                    str = start.g();
                }
                if ((i10 & 8) != 0) {
                    z10 = start.f25040h;
                }
                return start.j(captureState, uploadState, str, z10);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Start)) {
                    return false;
                }
                Start start = (Start) obj;
                return f() == start.f() && i() == start.i() && j.b(g(), start.g()) && this.f25040h == start.f25040h;
            }

            public CaptureState f() {
                return this.f25037e;
            }

            public String g() {
                return this.f25039g;
            }

            public int hashCode() {
                int hashCode = ((((f().hashCode() * 31) + i().hashCode()) * 31) + (g() == null ? 0 : g().hashCode())) * 31;
                boolean z10 = this.f25040h;
                if (z10) {
                    z10 = true;
                }
                return hashCode + (z10 ? 1 : 0);
            }

            public UploadState i() {
                return this.f25038f;
            }

            public final Start j(CaptureState captureState, UploadState uploadState, String str, boolean z10) {
                j.g(captureState, "captureState");
                j.g(uploadState, "uploadState");
                return new Start(captureState, uploadState, str, z10);
            }

            public final boolean l() {
                return this.f25040h;
            }

            public String toString() {
                return "Start(captureState=" + f() + ", uploadState=" + i() + ", documentId=" + g() + ", shouldShowUploadOptionsDialog=" + this.f25040h + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f25037e.name());
                parcel.writeString(this.f25038f.name());
                parcel.writeString(this.f25039g);
                parcel.writeInt(this.f25040h ? 1 : 0);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Start(CaptureState captureState, UploadState uploadState, String str, boolean z10) {
                super(captureState, uploadState, str, q.j(), (DefaultConstructorMarker) null);
                j.g(captureState, "captureState");
                j.g(uploadState, "uploadState");
                this.f25037e = captureState;
                this.f25038f = uploadState;
                this.f25039g = str;
                this.f25040h = z10;
            }
        }
    }

    public static abstract class a {

        /* renamed from: com.withpersona.sdk2.inquiry.document.DocumentWorkflow$a$a  reason: collision with other inner class name */
        public static final class C0300a extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final C0300a f25050a = new C0300a();

            private C0300a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final b f25051a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final c f25052a = new c();

            private c() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class d extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final d f25053a = new d();

            private d() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class e extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final e f25054a = new e();

            private e() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class f extends a {

            /* renamed from: a  reason: collision with root package name */
            private final DocumentFile.Remote f25055a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public f(DocumentFile.Remote remote) {
                super((DefaultConstructorMarker) null);
                kotlin.jvm.internal.j.g(remote, "document");
                this.f25055a = remote;
            }

            public final DocumentFile.Remote a() {
                return this.f25055a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && kotlin.jvm.internal.j.b(this.f25055a, ((f) obj).f25055a);
            }

            public int hashCode() {
                return this.f25055a.hashCode();
            }

            public String toString() {
                return "RemoveDocument(document=" + this.f25055a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class g extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final g f25056a = new g();

            private g() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class h extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final h f25057a = new h();

            private h() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class i extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final i f25058a = new i();

            private i() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class j extends a {

            /* renamed from: a  reason: collision with root package name */
            public static final j f25059a = new j();

            private j() {
                super((DefaultConstructorMarker) null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f25060a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25061b;

        /* renamed from: c  reason: collision with root package name */
        private final String f25062c;

        /* renamed from: d  reason: collision with root package name */
        private final String f25063d;

        /* renamed from: e  reason: collision with root package name */
        private final String f25064e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25065f;

        /* renamed from: g  reason: collision with root package name */
        private final String f25066g;

        /* renamed from: h  reason: collision with root package name */
        private final String f25067h;

        /* renamed from: i  reason: collision with root package name */
        private final String f25068i;

        /* renamed from: j  reason: collision with root package name */
        private final String f25069j;

        /* renamed from: k  reason: collision with root package name */
        private final String f25070k;

        /* renamed from: l  reason: collision with root package name */
        private final String f25071l;

        /* renamed from: m  reason: collision with root package name */
        private final String f25072m;

        /* renamed from: n  reason: collision with root package name */
        private final StartPage f25073n;

        /* renamed from: o  reason: collision with root package name */
        private final DocumentPages f25074o;

        /* renamed from: p  reason: collision with root package name */
        private final int f25075p;

        /* renamed from: q  reason: collision with root package name */
        private final boolean f25076q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f25077r;

        /* renamed from: s  reason: collision with root package name */
        private final String f25078s;

        /* renamed from: t  reason: collision with root package name */
        private final String f25079t;

        /* renamed from: u  reason: collision with root package name */
        private final String f25080u;

        /* renamed from: v  reason: collision with root package name */
        private final String f25081v;

        /* renamed from: w  reason: collision with root package name */
        private final StepStyles$DocumentStepStyle f25082w;

        public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, StartPage startPage, DocumentPages documentPages, int i10, boolean z10, boolean z11, String str14, String str15, String str16, String str17, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
            String str18 = str11;
            String str19 = str12;
            StartPage startPage2 = startPage;
            DocumentPages documentPages2 = documentPages;
            j.g(str, "sessionToken");
            j.g(str2, "inquiryId");
            j.g(str3, "fromStep");
            j.g(str4, "fromComponent");
            j.g(str18, "fieldKeyDocument");
            j.g(str19, "kind");
            j.g(startPage2, "startPage");
            j.g(documentPages2, "pages");
            this.f25060a = str;
            this.f25061b = str2;
            this.f25062c = str3;
            this.f25063d = str4;
            this.f25064e = str5;
            this.f25065f = str6;
            this.f25066g = str7;
            this.f25067h = str8;
            this.f25068i = str9;
            this.f25069j = str10;
            this.f25070k = str18;
            this.f25071l = str19;
            this.f25072m = str13;
            this.f25073n = startPage2;
            this.f25074o = documentPages2;
            this.f25075p = i10;
            this.f25076q = z10;
            this.f25077r = z11;
            this.f25078s = str14;
            this.f25079t = str15;
            this.f25080u = str16;
            this.f25081v = str17;
            this.f25082w = stepStyles$DocumentStepStyle;
        }

        public final boolean a() {
            return this.f25076q;
        }

        public final boolean b() {
            return this.f25077r;
        }

        public final String c() {
            return this.f25066g;
        }

        public final int d() {
            return this.f25075p;
        }

        public final String e() {
            return this.f25072m;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return j.b(this.f25060a, bVar.f25060a) && j.b(this.f25061b, bVar.f25061b) && j.b(this.f25062c, bVar.f25062c) && j.b(this.f25063d, bVar.f25063d) && j.b(this.f25064e, bVar.f25064e) && j.b(this.f25065f, bVar.f25065f) && j.b(this.f25066g, bVar.f25066g) && j.b(this.f25067h, bVar.f25067h) && j.b(this.f25068i, bVar.f25068i) && j.b(this.f25069j, bVar.f25069j) && j.b(this.f25070k, bVar.f25070k) && j.b(this.f25071l, bVar.f25071l) && j.b(this.f25072m, bVar.f25072m) && this.f25073n == bVar.f25073n && j.b(this.f25074o, bVar.f25074o) && this.f25075p == bVar.f25075p && this.f25076q == bVar.f25076q && this.f25077r == bVar.f25077r && j.b(this.f25078s, bVar.f25078s) && j.b(this.f25079t, bVar.f25079t) && j.b(this.f25080u, bVar.f25080u) && j.b(this.f25081v, bVar.f25081v) && j.b(this.f25082w, bVar.f25082w);
        }

        public final String f() {
            return this.f25070k;
        }

        public final String g() {
            return this.f25063d;
        }

        public final String h() {
            return this.f25062c;
        }

        public int hashCode() {
            int hashCode = ((((((this.f25060a.hashCode() * 31) + this.f25061b.hashCode()) * 31) + this.f25062c.hashCode()) * 31) + this.f25063d.hashCode()) * 31;
            String str = this.f25064e;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f25065f;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f25066g;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f25067h;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f25068i;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f25069j;
            int hashCode7 = (((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.f25070k.hashCode()) * 31) + this.f25071l.hashCode()) * 31;
            String str7 = this.f25072m;
            int hashCode8 = (((((((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.f25073n.hashCode()) * 31) + this.f25074o.hashCode()) * 31) + Integer.hashCode(this.f25075p)) * 31;
            boolean z10 = this.f25076q;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i11 = (hashCode8 + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f25077r;
            if (!z12) {
                z11 = z12;
            }
            int i12 = (i11 + (z11 ? 1 : 0)) * 31;
            String str8 = this.f25078s;
            int hashCode9 = (i12 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.f25079t;
            int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.f25080u;
            int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.f25081v;
            int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
            StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = this.f25082w;
            if (stepStyles$DocumentStepStyle != null) {
                i10 = stepStyles$DocumentStepStyle.hashCode();
            }
            return hashCode12 + i10;
        }

        public final String i() {
            return this.f25061b;
        }

        public final String j() {
            return this.f25071l;
        }

        public final DocumentPages k() {
            return this.f25074o;
        }

        public final String l() {
            return this.f25069j;
        }

        public final String m() {
            return this.f25068i;
        }

        public final String n() {
            return this.f25081v;
        }

        public final String o() {
            return this.f25080u;
        }

        public final String p() {
            return this.f25079t;
        }

        public final String q() {
            return this.f25078s;
        }

        public final String r() {
            return this.f25065f;
        }

        public final String s() {
            return this.f25064e;
        }

        public final String t() {
            return this.f25060a;
        }

        public String toString() {
            return "Input(sessionToken=" + this.f25060a + ", inquiryId=" + this.f25061b + ", fromStep=" + this.f25062c + ", fromComponent=" + this.f25063d + ", promptTitle=" + this.f25064e + ", promptDescription=" + this.f25065f + ", disclaimer=" + this.f25066g + ", submitButtonText=" + this.f25067h + ", pendingTitle=" + this.f25068i + ", pendingDescription=" + this.f25069j + ", fieldKeyDocument=" + this.f25070k + ", kind=" + this.f25071l + ", documentId=" + this.f25072m + ", startPage=" + this.f25073n + ", pages=" + this.f25074o + ", documentFileLimit=" + this.f25075p + ", backStepEnabled=" + this.f25076q + ", cancelButtonEnabled=" + this.f25077r + ", permissionsTitle=" + this.f25078s + ", permissionsRationale=" + this.f25079t + ", permissionsModalPositiveButton=" + this.f25080u + ", permissionsModalNegativeButton=" + this.f25081v + ", styles=" + this.f25082w + PropertyUtils.MAPPED_DELIM2;
        }

        public final StartPage u() {
            return this.f25073n;
        }

        public final StepStyles$DocumentStepStyle v() {
            return this.f25082w;
        }

        public final String w() {
            return this.f25067h;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final a f25083a = new a();

            private a() {
                super((DefaultConstructorMarker) null);
            }
        }

        public static final class b extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final b f25084a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.withpersona.sdk2.inquiry.document.DocumentWorkflow$c$c  reason: collision with other inner class name */
        public static final class C0301c extends c {

            /* renamed from: a  reason: collision with root package name */
            private final InternalErrorInfo f25085a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0301c(InternalErrorInfo internalErrorInfo) {
                super((DefaultConstructorMarker) null);
                j.g(internalErrorInfo, "cause");
                this.f25085a = internalErrorInfo;
            }

            public final InternalErrorInfo a() {
                return this.f25085a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0301c) && j.b(this.f25085a, ((C0301c) obj).f25085a);
            }

            public int hashCode() {
                return this.f25085a.hashCode();
            }

            public String toString() {
                return "Errored(cause=" + this.f25085a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class d extends c {

            /* renamed from: a  reason: collision with root package name */
            public static final d f25086a = new d();

            private d() {
                super((DefaultConstructorMarker) null);
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            private final String f25087a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25088b;

            /* renamed from: c  reason: collision with root package name */
            private final Function0<Unit> f25089c;

            /* renamed from: d  reason: collision with root package name */
            private final StepStyles$DocumentStepStyle f25090d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, Function0<Unit> function0, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
                super((DefaultConstructorMarker) null);
                j.g(function0, "onCancel");
                this.f25087a = str;
                this.f25088b = str2;
                this.f25089c = function0;
                this.f25090d = stepStyles$DocumentStepStyle;
            }

            public final Function0<Unit> a() {
                return this.f25089c;
            }

            public final String b() {
                return this.f25088b;
            }

            public final StepStyles$DocumentStepStyle c() {
                return this.f25090d;
            }

            public final String d() {
                return this.f25087a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return j.b(this.f25087a, aVar.f25087a) && j.b(this.f25088b, aVar.f25088b) && j.b(this.f25089c, aVar.f25089c) && j.b(this.f25090d, aVar.f25090d);
            }

            public int hashCode() {
                String str = this.f25087a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f25088b;
                int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f25089c.hashCode()) * 31;
                StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = this.f25090d;
                if (stepStyles$DocumentStepStyle != null) {
                    i10 = stepStyles$DocumentStepStyle.hashCode();
                }
                return hashCode2 + i10;
            }

            public String toString() {
                return "LoadingAnimation(title=" + this.f25087a + ", prompt=" + this.f25088b + ", onCancel=" + this.f25089c + ", styles=" + this.f25090d + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static final class b extends d {

            /* renamed from: a  reason: collision with root package name */
            private final ImageLoader f25091a;

            /* renamed from: b  reason: collision with root package name */
            private final String f25092b;

            /* renamed from: c  reason: collision with root package name */
            private final String f25093c;

            /* renamed from: d  reason: collision with root package name */
            private final String f25094d;

            /* renamed from: e  reason: collision with root package name */
            private final String f25095e;

            /* renamed from: f  reason: collision with root package name */
            private final List<DocumentFile> f25096f;

            /* renamed from: g  reason: collision with root package name */
            private final Function0<Unit> f25097g;

            /* renamed from: h  reason: collision with root package name */
            private final Function0<Unit> f25098h;

            /* renamed from: i  reason: collision with root package name */
            private final Function0<Unit> f25099i;

            /* renamed from: j  reason: collision with root package name */
            private final Function0<Unit> f25100j;

            /* renamed from: k  reason: collision with root package name */
            private final Function1<DocumentFile.Remote, Unit> f25101k;

            /* renamed from: l  reason: collision with root package name */
            private final Function0<Unit> f25102l;

            /* renamed from: m  reason: collision with root package name */
            private final Function0<Unit> f25103m;

            /* renamed from: n  reason: collision with root package name */
            private final boolean f25104n;

            /* renamed from: o  reason: collision with root package name */
            private final boolean f25105o;

            /* renamed from: p  reason: collision with root package name */
            private final Function0<Unit> f25106p;

            /* renamed from: q  reason: collision with root package name */
            private final boolean f25107q;

            /* renamed from: r  reason: collision with root package name */
            private final boolean f25108r;

            /* renamed from: s  reason: collision with root package name */
            private final boolean f25109s;

            /* renamed from: t  reason: collision with root package name */
            private final String f25110t;

            /* renamed from: u  reason: collision with root package name */
            private final Function0<Unit> f25111u;

            /* renamed from: v  reason: collision with root package name */
            private final StepStyles$DocumentStepStyle f25112v;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ImageLoader imageLoader, String str, String str2, String str3, String str4, List<? extends DocumentFile> list, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function1<? super DocumentFile.Remote, Unit> function1, Function0<Unit> function05, Function0<Unit> function06, boolean z10, boolean z11, Function0<Unit> function07, boolean z12, boolean z13, boolean z14, String str5, Function0<Unit> function08, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
                super((DefaultConstructorMarker) null);
                List<? extends DocumentFile> list2 = list;
                Function0<Unit> function09 = function0;
                Function0<Unit> function010 = function02;
                Function0<Unit> function011 = function03;
                Function0<Unit> function012 = function04;
                Function1<? super DocumentFile.Remote, Unit> function12 = function1;
                Function0<Unit> function013 = function05;
                Function0<Unit> function014 = function06;
                Function0<Unit> function015 = function07;
                Function0<Unit> function016 = function08;
                j.g(imageLoader, "imageLoader");
                j.g(list2, "documents");
                j.g(function09, "openSelectFile");
                j.g(function010, "selectFromPhotoLibrary");
                j.g(function011, "openCamera");
                j.g(function012, "openUploadOptions");
                j.g(function12, "onRemove");
                j.g(function013, "onSubmit");
                j.g(function014, "onCancel");
                j.g(function015, "onBack");
                j.g(function016, "onErrorDismissed");
                this.f25091a = imageLoader;
                this.f25092b = str;
                this.f25093c = str2;
                this.f25094d = str3;
                this.f25095e = str4;
                this.f25096f = list2;
                this.f25097g = function09;
                this.f25098h = function010;
                this.f25099i = function011;
                this.f25100j = function012;
                this.f25101k = function12;
                this.f25102l = function013;
                this.f25103m = function014;
                this.f25104n = z10;
                this.f25105o = z11;
                this.f25106p = function015;
                this.f25107q = z12;
                this.f25108r = z13;
                this.f25109s = z14;
                this.f25110t = str5;
                this.f25111u = function016;
                this.f25112v = stepStyles$DocumentStepStyle;
            }

            public final boolean a() {
                return this.f25108r;
            }

            public final boolean b() {
                return this.f25104n;
            }

            public final boolean c() {
                return this.f25105o;
            }

            public final boolean d() {
                return this.f25107q;
            }

            public final String e() {
                return this.f25094d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return j.b(this.f25091a, bVar.f25091a) && j.b(this.f25092b, bVar.f25092b) && j.b(this.f25093c, bVar.f25093c) && j.b(this.f25094d, bVar.f25094d) && j.b(this.f25095e, bVar.f25095e) && j.b(this.f25096f, bVar.f25096f) && j.b(this.f25097g, bVar.f25097g) && j.b(this.f25098h, bVar.f25098h) && j.b(this.f25099i, bVar.f25099i) && j.b(this.f25100j, bVar.f25100j) && j.b(this.f25101k, bVar.f25101k) && j.b(this.f25102l, bVar.f25102l) && j.b(this.f25103m, bVar.f25103m) && this.f25104n == bVar.f25104n && this.f25105o == bVar.f25105o && j.b(this.f25106p, bVar.f25106p) && this.f25107q == bVar.f25107q && this.f25108r == bVar.f25108r && this.f25109s == bVar.f25109s && j.b(this.f25110t, bVar.f25110t) && j.b(this.f25111u, bVar.f25111u) && j.b(this.f25112v, bVar.f25112v);
            }

            public final List<DocumentFile> f() {
                return this.f25096f;
            }

            public final String g() {
                return this.f25110t;
            }

            public final ImageLoader h() {
                return this.f25091a;
            }

            public int hashCode() {
                int hashCode = this.f25091a.hashCode() * 31;
                String str = this.f25092b;
                int i10 = 0;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.f25093c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f25094d;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f25095e;
                int hashCode5 = (((((((((((((((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f25096f.hashCode()) * 31) + this.f25097g.hashCode()) * 31) + this.f25098h.hashCode()) * 31) + this.f25099i.hashCode()) * 31) + this.f25100j.hashCode()) * 31) + this.f25101k.hashCode()) * 31) + this.f25102l.hashCode()) * 31) + this.f25103m.hashCode()) * 31;
                boolean z10 = this.f25104n;
                boolean z11 = true;
                if (z10) {
                    z10 = true;
                }
                int i11 = (hashCode5 + (z10 ? 1 : 0)) * 31;
                boolean z12 = this.f25105o;
                if (z12) {
                    z12 = true;
                }
                int hashCode6 = (((i11 + (z12 ? 1 : 0)) * 31) + this.f25106p.hashCode()) * 31;
                boolean z13 = this.f25107q;
                if (z13) {
                    z13 = true;
                }
                int i12 = (hashCode6 + (z13 ? 1 : 0)) * 31;
                boolean z14 = this.f25108r;
                if (z14) {
                    z14 = true;
                }
                int i13 = (i12 + (z14 ? 1 : 0)) * 31;
                boolean z15 = this.f25109s;
                if (!z15) {
                    z11 = z15;
                }
                int i14 = (i13 + (z11 ? 1 : 0)) * 31;
                String str5 = this.f25110t;
                int hashCode7 = (((i14 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f25111u.hashCode()) * 31;
                StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = this.f25112v;
                if (stepStyles$DocumentStepStyle != null) {
                    i10 = stepStyles$DocumentStepStyle.hashCode();
                }
                return hashCode7 + i10;
            }

            public final Function0<Unit> i() {
                return this.f25106p;
            }

            public final Function0<Unit> j() {
                return this.f25103m;
            }

            public final Function0<Unit> k() {
                return this.f25111u;
            }

            public final Function1<DocumentFile.Remote, Unit> l() {
                return this.f25101k;
            }

            public final Function0<Unit> m() {
                return this.f25102l;
            }

            public final Function0<Unit> n() {
                return this.f25100j;
            }

            public final String o() {
                return this.f25093c;
            }

            public final StepStyles$DocumentStepStyle p() {
                return this.f25112v;
            }

            public final boolean q() {
                return this.f25109s;
            }

            public final String r() {
                return this.f25095e;
            }

            public final String s() {
                return this.f25092b;
            }

            public String toString() {
                return "ReviewCaptures(imageLoader=" + this.f25091a + ", title=" + this.f25092b + ", prompt=" + this.f25093c + ", disclaimer=" + this.f25094d + ", submitButtonText=" + this.f25095e + ", documents=" + this.f25096f + ", openSelectFile=" + this.f25097g + ", selectFromPhotoLibrary=" + this.f25098h + ", openCamera=" + this.f25099i + ", openUploadOptions=" + this.f25100j + ", onRemove=" + this.f25101k + ", onSubmit=" + this.f25102l + ", onCancel=" + this.f25103m + ", backStepEnabled=" + this.f25104n + ", cancelButtonEnabled=" + this.f25105o + ", onBack=" + this.f25106p + ", disabled=" + this.f25107q + ", addButtonEnabled=" + this.f25108r + ", submitButtonEnabled=" + this.f25109s + ", error=" + this.f25110t + ", onErrorDismissed=" + this.f25111u + ", styles=" + this.f25112v + PropertyUtils.MAPPED_DELIM2;
            }
        }

        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25113a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f25114b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f25115c;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        static {
            /*
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$StartPage[] r0 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.StartPage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$StartPage r2 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.StartPage.Prompt     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$StartPage r3 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.StartPage.Review     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f25113a = r0
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState[] r0 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r3 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.None     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r3 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.CheckCameraPermissions     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r4 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.CameraRunning     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                r4 = 4
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r5 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.SelectFileFromDocuments     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r5 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.SelectImageFromPhotoLibrary     // Catch:{ NoSuchFieldError -> 0x004d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                f25114b = r0
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState[] r0 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r5 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.CreateDocument     // Catch:{ NoSuchFieldError -> 0x005e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r1 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.UploadFiles     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r1 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.DeleteFiles     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r1 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.ReadyToSubmit     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                f25115c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow.e.<clinit>():void");
        }
    }

    public DocumentWorkflow(ImageLoader imageLoader, Context context, PermissionRequestWorkflow permissionRequestWorkflow, DocumentCameraWorker documentCameraWorker, DocumentsSelectWorker.Factory factory, DocumentCreateWorker.a aVar, DocumentLoadWorker.a aVar2, DocumentFileUploadWorker.a aVar3, DocumentFileDeleteWorker.a aVar4, DocumentSubmitWorker.a aVar5) {
        j.g(imageLoader, "imageLoader");
        j.g(context, "applicationContext");
        j.g(permissionRequestWorkflow, "permissionRequestWorkflow");
        j.g(documentCameraWorker, "documentCameraWorker");
        j.g(factory, "documentsSelectWorkerFactory");
        j.g(aVar, "documentCreateWorker");
        j.g(aVar2, "documentLoadWorker");
        j.g(aVar3, "documentFileUploadWorker");
        j.g(aVar4, "documentFileDeleteWorker");
        j.g(aVar5, "documentSubmitWorker");
        this.f25006a = imageLoader;
        this.f25007b = context;
        this.f25008c = permissionRequestWorkflow;
        this.f25009d = documentCameraWorker;
        this.f25010e = factory;
        this.f25011f = aVar;
        this.f25012g = aVar2;
        this.f25013h = aVar3;
        this.f25014i = aVar4;
        this.f25015j = aVar5;
    }

    private final List<Pair<String, Function0<Unit>>> k(DocumentStartPage documentStartPage, h<? super b, State, ? extends c, ? extends Object>.defpackage.a aVar) {
        Pair pair;
        List<Pair> m10 = q.m(new Pair(documentStartPage.c(), new DocumentWorkflow$componentNamesToActions$1(this, aVar)), new Pair(documentStartPage.d(), new DocumentWorkflow$componentNamesToActions$2(this, aVar)), new Pair(documentStartPage.e(), new DocumentWorkflow$componentNamesToActions$3(this, aVar)), new Pair(documentStartPage.a(), new DocumentWorkflow$componentNamesToActions$4(this, aVar)));
        ArrayList arrayList = new ArrayList();
        for (Pair pair2 : m10) {
            if (pair2.c() != null) {
                Object c10 = pair2.c();
                j.d(c10);
                pair = new Pair(c10, pair2.d());
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    private final List<Pair<String, Function0<Unit>>> l(UploadOptionsDialog uploadOptionsDialog, h<? super b, State, ? extends c, ? extends Object>.defpackage.a aVar) {
        Pair pair;
        List<Pair> m10 = q.m(new Pair(uploadOptionsDialog.c(), new DocumentWorkflow$componentNamesToActions$6(this, aVar)), new Pair(uploadOptionsDialog.d(), new DocumentWorkflow$componentNamesToActions$7(this, aVar)), new Pair(uploadOptionsDialog.e(), new DocumentWorkflow$componentNamesToActions$8(this, aVar)));
        ArrayList arrayList = new ArrayList();
        for (Pair pair2 : m10) {
            if (pair2.c() != null) {
                Object c10 = pair2.c();
                j.d(c10);
                pair = new Pair(c10, pair2.d());
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void n(h<? super b, State, ? extends c, ? extends Object>.defpackage.a aVar, a aVar2) {
        l lVar;
        if (j.b(aVar2, a.b.f25051a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$1.f25116a, 1, (Object) null);
        } else if (j.b(aVar2, a.C0300a.f25050a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$2.f25118a, 1, (Object) null);
        } else if (j.b(aVar2, a.g.f25056a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$3.f25119a, 1, (Object) null);
        } else if (j.b(aVar2, a.h.f25057a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$4.f25120a, 1, (Object) null);
        } else if (j.b(aVar2, a.j.f25059a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$5.f25121a, 1, (Object) null);
        } else if (j.b(aVar2, a.e.f25054a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$6.f25122a, 1, (Object) null);
        } else if (j.b(aVar2, a.c.f25052a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$7.f25123a, 1, (Object) null);
        } else if (aVar2 instanceof a.f) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, new DocumentWorkflow$onEvent$action$8(aVar2), 1, (Object) null);
        } else if (j.b(aVar2, a.d.f25053a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$9.f25124a, 1, (Object) null);
        } else if (j.b(aVar2, a.i.f25058a)) {
            lVar = Workflows__StatefulWorkflowKt.d(this, (String) null, DocumentWorkflow$onEvent$action$10.f25117a, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        aVar.c().d(lVar);
    }

    private static final void p(State.CaptureState captureState, h<? super b, State, ? extends c, ? extends Object>.defpackage.a aVar, DocumentWorkflow documentWorkflow, State state, b bVar) {
        DocumentsSelectWorker documentsSelectWorker;
        int i10 = e.f25114b[captureState.ordinal()];
        if (i10 == 3) {
            o.l(aVar, documentWorkflow.f25009d, kotlin.jvm.internal.l.k(DocumentCameraWorker.class), "", new DocumentWorkflow$render$run$1(documentWorkflow, bVar));
        } else if (i10 == 4 || i10 == 5) {
            if (state.f() == State.CaptureState.SelectFileFromDocuments) {
                documentsSelectWorker = documentWorkflow.f25010e.c();
            } else {
                documentsSelectWorker = documentWorkflow.f25010e.d();
            }
            o.l(aVar, documentsSelectWorker, kotlin.jvm.internal.l.k(DocumentsSelectWorker.class), "", new DocumentWorkflow$render$run$2(documentWorkflow, bVar, state));
        }
    }

    /* JADX WARNING: type inference failed for: r5v15, types: [com.withpersona.sdk2.inquiry.document.DocumentFile] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void q(com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState r5, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State r6, com.squareup.workflow1.h<? super com.withpersona.sdk2.inquiry.document.DocumentWorkflow.b, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State, ? extends com.withpersona.sdk2.inquiry.document.DocumentWorkflow.c, ? extends java.lang.Object>.defpackage.a r7, com.withpersona.sdk2.inquiry.document.DocumentWorkflow r8, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.b r9) {
        /*
            int[] r0 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.e.f25115c
            int r5 = r5.ordinal()
            r5 = r0[r5]
            r0 = 1
            java.lang.String r1 = ""
            if (r5 == r0) goto L_0x00b5
            r0 = 2
            r2 = 0
            r3 = 3
            if (r5 == r0) goto L_0x004d
            if (r5 == r3) goto L_0x0016
            goto L_0x00e0
        L_0x0016:
            boolean r5 = r6 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures
            if (r5 != 0) goto L_0x001b
            return
        L_0x001b:
            r5 = r6
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$ReviewCaptures r5 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures) r5
            com.withpersona.sdk2.inquiry.document.DocumentFile r5 = r5.l()
            boolean r0 = r5 instanceof com.withpersona.sdk2.inquiry.document.DocumentFile.Remote
            if (r0 == 0) goto L_0x0029
            r2 = r5
            com.withpersona.sdk2.inquiry.document.DocumentFile$Remote r2 = (com.withpersona.sdk2.inquiry.document.DocumentFile.Remote) r2
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return
        L_0x002c:
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker$a r5 = r8.f25014i
            java.lang.String r9 = r9.t()
            java.lang.String r6 = r6.g()
            kotlin.jvm.internal.j.d(r6)
            com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker r5 = r5.a(r9, r6, r2)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$6 r6 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$6
            r6.<init>(r8, r2)
            java.lang.Class<com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker> r8 = com.withpersona.sdk2.inquiry.document.network.DocumentFileDeleteWorker.class
            wk.m r8 = kotlin.jvm.internal.l.k(r8)
            com.squareup.workflow1.o.l(r7, r5, r8, r1, r6)
            goto L_0x00e0
        L_0x004d:
            java.util.List r5 = r6.h()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x005a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r5.next()
            boolean r4 = r1 instanceof com.withpersona.sdk2.inquiry.document.DocumentFile.Local
            if (r4 == 0) goto L_0x005a
            r0.add(r1)
            goto L_0x005a
        L_0x006c:
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x007d
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$4 r5 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$4
            r5.<init>(r7, r8, r2)
            java.lang.String r6 = "upload_complete"
            r7.a(r6, r5)
            return
        L_0x007d:
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.s0(r0, r3)
            java.util.Iterator r5 = r5.iterator()
        L_0x0085:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x00e0
            java.lang.Object r0 = r5.next()
            com.withpersona.sdk2.inquiry.document.DocumentFile$Local r0 = (com.withpersona.sdk2.inquiry.document.DocumentFile.Local) r0
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$a r1 = r8.f25013h
            java.lang.String r2 = r9.t()
            java.lang.String r3 = r6.g()
            kotlin.jvm.internal.j.d(r3)
            com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker r1 = r1.a(r2, r3, r0)
            java.lang.String r2 = r0.d()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$5$1 r3 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$5$1
            r3.<init>(r8, r0, r6)
            java.lang.Class<com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker> r0 = com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker.class
            wk.m r0 = kotlin.jvm.internal.l.k(r0)
            com.squareup.workflow1.o.l(r7, r1, r0, r2, r3)
            goto L_0x0085
        L_0x00b5:
            java.lang.String r5 = r6.g()
            if (r5 == 0) goto L_0x00bc
            return
        L_0x00bc:
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker$a r5 = r8.f25011f
            java.lang.String r6 = r9.t()
            java.lang.String r0 = r9.j()
            java.lang.String r2 = r9.f()
            int r9 = r9.d()
            com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker r5 = r5.a(r6, r0, r2, r9)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$3 r6 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$run$3
            r6.<init>(r8)
            java.lang.Class<com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker> r8 = com.withpersona.sdk2.inquiry.document.network.DocumentCreateWorker.class
            wk.m r8 = kotlin.jvm.internal.l.k(r8)
            com.squareup.workflow1.o.l(r7, r5, r8, r1, r6)
        L_0x00e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow.q(com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState, com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State, com.squareup.workflow1.h$a, com.withpersona.sdk2.inquiry.document.DocumentWorkflow, com.withpersona.sdk2.inquiry.document.DocumentWorkflow$b):void");
    }

    /* renamed from: m */
    public State d(b bVar, Snapshot snapshot) {
        boolean z10;
        j.g(bVar, "props");
        if (snapshot != null) {
            ByteString b10 = snapshot.b();
            if (b10.H() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            Parcelable parcelable = null;
            if (!z10) {
                b10 = null;
            }
            if (b10 != null) {
                Parcel obtain = Parcel.obtain();
                j.f(obtain, "obtain()");
                byte[] N = b10.N();
                obtain.unmarshall(N, 0, N.length);
                obtain.setDataPosition(0);
                parcelable = obtain.readParcelable(Snapshot.class.getClassLoader());
                j.d(parcelable);
                j.f(parcelable, "parcel.readParcelable<T>…class.java.classLoader)!!");
                obtain.recycle();
            }
            State state = (State) parcelable;
            if (state != null) {
                return state;
            }
        }
        int i10 = e.f25113a[bVar.u().ordinal()];
        if (i10 == 1) {
            return new State.Start((State.CaptureState) null, (State.UploadState) null, bVar.e(), false, 11, (DefaultConstructorMarker) null);
        }
        if (i10 == 2) {
            return new State.ReviewCaptures(q.j(), bVar.e(), (State.CaptureState) null, (State.UploadState) null, (DocumentFile) null, true, false, (String) null, 220, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: type inference failed for: r3v32, types: [com.withpersona.sdk2.inquiry.modal.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: o */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object f(com.withpersona.sdk2.inquiry.document.DocumentWorkflow.b r43, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State r44, com.squareup.workflow1.h<? super com.withpersona.sdk2.inquiry.document.DocumentWorkflow.b, com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State, ? extends com.withpersona.sdk2.inquiry.document.DocumentWorkflow.c, ? extends java.lang.Object>.defpackage.a r45) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = r44
            r15 = r45
            java.lang.String r3 = "renderProps"
            kotlin.jvm.internal.j.g(r1, r3)
            java.lang.String r3 = "renderState"
            kotlin.jvm.internal.j.g(r2, r3)
            java.lang.String r3 = "context"
            kotlin.jvm.internal.j.g(r15, r3)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r3 = r44.f()
            p(r3, r15, r0, r2, r1)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r3 = r44.i()
            q(r3, r2, r15, r0, r1)
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.Start
            java.lang.String r4 = "applicationContext.getSt…era_permission_rationale)"
            java.lang.String r5 = "applicationContext.getSt…icationName()\n          )"
            java.lang.String r14 = "document_upload_options_dialog"
            java.lang.String r6 = ""
            r7 = 0
            r8 = 1
            if (r3 == 0) goto L_0x010e
            com.withpersona.sdk2.inquiry.document.DocumentPages r3 = r43.k()
            com.withpersona.sdk2.inquiry.document.DocumentStartPage r3 = r3.a()
            com.withpersona.sdk2.inquiry.steps.ui.UiScreen r17 = com.withpersona.sdk2.inquiry.steps.ui.b.a(r3)
            com.withpersona.sdk2.inquiry.document.DocumentPages r3 = r43.k()
            com.withpersona.sdk2.inquiry.document.DocumentStartPage r3 = r3.a()
            java.util.List r18 = r0.k(r3, r15)
            boolean r19 = r43.a()
            boolean r21 = r43.b()
            com.withpersona.sdk2.inquiry.document.DocumentInstructionsView r3 = new com.withpersona.sdk2.inquiry.document.DocumentInstructionsView
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$startScreen$1 r9 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$startScreen$1
            r9.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$startScreen$2 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$startScreen$2
            r10.<init>(r0, r15)
            r16 = r3
            r20 = r9
            r22 = r10
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r9 = r2
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$Start r9 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.Start) r9
            boolean r9 = r9.l()
            if (r9 == 0) goto L_0x00a4
            com.withpersona.sdk2.inquiry.steps.ui.m r9 = com.withpersona.sdk2.inquiry.steps.ui.m.f27597a
            com.withpersona.sdk2.inquiry.document.DocumentPages r10 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r10 = r10.c()
            com.withpersona.sdk2.inquiry.steps.ui.UiScreen r10 = com.withpersona.sdk2.inquiry.steps.ui.b.a(r10)
            com.withpersona.sdk2.inquiry.document.DocumentPages r11 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r11 = r11.c()
            java.util.List r11 = r0.l(r11, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$1 r12 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$1
            r12.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentPages r13 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r13 = r13.c()
            java.lang.String r13 = r13.a()
            com.withpersona.sdk2.inquiry.steps.ui.UiStepBottomSheet r9 = r9.h(r10, r11, r12, r13)
            com.withpersona.sdk2.inquiry.modal.b r3 = com.withpersona.sdk2.inquiry.modal.c.a(r9, r3, r14)
        L_0x00a4:
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r9 = r44.f()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r10 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.CheckCameraPermissions
            if (r9 != r10) goto L_0x00ae
            r9 = r8
            goto L_0x00af
        L_0x00ae:
            r9 = r7
        L_0x00af:
            com.withpersona.sdk2.inquiry.permissions.Permission r10 = com.withpersona.sdk2.inquiry.permissions.Permission.Camera
            java.lang.String r11 = r43.q()
            if (r11 != 0) goto L_0x00b8
            goto L_0x00b9
        L_0x00b8:
            r6 = r11
        L_0x00b9:
            java.lang.String r11 = r43.p()
            if (r11 != 0) goto L_0x00ca
            android.content.Context r11 = r0.f25007b
            int r12 = com.withpersona.sdk2.inquiry.document.n.pi2_document_camera_permission_rationale
            java.lang.String r11 = r11.getString(r12)
            kotlin.jvm.internal.j.f(r11, r4)
        L_0x00ca:
            android.content.Context r4 = r0.f25007b
            int r12 = com.withpersona.sdk2.inquiry.document.n.pi2_document_camera_permission_denied_rationale
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r13 = ti.a.b(r4)
            r8[r7] = r13
            java.lang.String r7 = r4.getString(r12, r8)
            kotlin.jvm.internal.j.f(r7, r5)
            java.lang.String r8 = r43.o()
            java.lang.String r12 = r43.n()
            com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow r13 = r0.f25008c
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle r14 = r43.v()
            r16 = 0
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$1 r5 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$1
            r5.<init>(r0, r2)
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 0
            r1 = r3
            r2 = r45
            r3 = r9
            r4 = r10
            r15 = r5
            r5 = r6
            r6 = r11
            r9 = r12
            r10 = r13
            r11 = r14
            r12 = r16
            r13 = r15
            r14 = r17
            r15 = r18
            com.withpersona.sdk2.inquiry.modal.b r1 = com.withpersona.sdk2.inquiry.permissions.b.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x02cb
        L_0x010e:
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures
            if (r3 == 0) goto L_0x0287
            r17 = r2
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$ReviewCaptures r17 = (com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.ReviewCaptures) r17
            boolean r3 = r17.m()
            if (r3 == 0) goto L_0x013b
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker$a r3 = r0.f25012g
            java.lang.String r9 = r43.t()
            java.lang.String r10 = r44.g()
            kotlin.jvm.internal.j.d(r10)
            com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker r3 = r3.a(r9, r10)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$2 r9 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$2
            r9.<init>(r0, r2)
            java.lang.Class<com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker> r10 = com.withpersona.sdk2.inquiry.document.network.DocumentLoadWorker.class
            wk.m r10 = kotlin.jvm.internal.l.k(r10)
            com.squareup.workflow1.o.l(r15, r3, r10, r6, r9)
        L_0x013b:
            coil.ImageLoader r3 = r0.f25006a
            java.lang.String r20 = r43.s()
            java.lang.String r21 = r43.r()
            java.lang.String r22 = r43.c()
            java.lang.String r23 = r43.w()
            java.util.List r24 = r44.h()
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle r40 = r43.v()
            boolean r32 = r43.a()
            boolean r33 = r43.b()
            boolean r35 = r17.m()
            java.util.List r9 = r44.h()
            int r9 = r9.size()
            int r10 = r43.d()
            if (r9 >= r10) goto L_0x0172
            r36 = r8
            goto L_0x0174
        L_0x0172:
            r36 = r7
        L_0x0174:
            java.util.List r9 = r44.h()
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r8
            if (r9 == 0) goto L_0x018a
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r9 = r44.i()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$UploadState r10 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadState.ReadyToSubmit
            if (r9 != r10) goto L_0x018a
            r37 = r8
            goto L_0x018c
        L_0x018a:
            r37 = r7
        L_0x018c:
            java.lang.String r38 = r17.getError()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$d$b r9 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$d$b
            r18 = r9
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$2 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$2
            r25 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$3 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$3
            r26 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$4 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$4
            r27 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$5 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$5
            r28 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$6 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$6
            r29 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$7 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$7
            r30 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$8 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$8
            r31 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$9 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$9
            r34 = r10
            r10.<init>(r0, r15)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$10 r10 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$10
            r39 = r10
            r10.<init>(r0, r15)
            r19 = r3
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r3 = r44.f()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State$CaptureState r10 = com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.CaptureState.CheckCameraPermissions
            if (r3 != r10) goto L_0x01e2
            r10 = r8
            goto L_0x01e3
        L_0x01e2:
            r10 = r7
        L_0x01e3:
            com.withpersona.sdk2.inquiry.permissions.Permission r11 = com.withpersona.sdk2.inquiry.permissions.Permission.Camera
            java.lang.String r3 = r43.q()
            if (r3 != 0) goto L_0x01ec
            goto L_0x01ed
        L_0x01ec:
            r6 = r3
        L_0x01ed:
            java.lang.String r3 = r43.p()
            if (r3 != 0) goto L_0x01fe
            android.content.Context r3 = r0.f25007b
            int r12 = com.withpersona.sdk2.inquiry.document.n.pi2_document_camera_permission_rationale
            java.lang.String r3 = r3.getString(r12)
            kotlin.jvm.internal.j.f(r3, r4)
        L_0x01fe:
            r12 = r3
            android.content.Context r3 = r0.f25007b
            int r4 = com.withpersona.sdk2.inquiry.document.n.pi2_document_camera_permission_denied_rationale
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r13 = ti.a.b(r3)
            r8[r7] = r13
            java.lang.String r8 = r3.getString(r4, r8)
            kotlin.jvm.internal.j.f(r8, r5)
            java.lang.String r13 = r43.o()
            java.lang.String r16 = r43.n()
            com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow r7 = r0.f25008c
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle r18 = r43.v()
            r19 = 0
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$11 r5 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$screen$11
            r5.<init>(r0, r2)
            r20 = 1024(0x400, float:1.435E-42)
            r21 = 0
            r2 = r9
            r3 = r45
            r4 = r10
            r22 = r5
            r5 = r11
            r11 = r7
            r7 = r12
            r9 = r13
            r10 = r16
            r12 = r18
            r13 = r19
            r41 = r14
            r14 = r22
            r15 = r20
            r16 = r21
            com.withpersona.sdk2.inquiry.modal.b r2 = com.withpersona.sdk2.inquiry.permissions.b.e(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r3 = r17.n()
            if (r3 == 0) goto L_0x0285
            com.withpersona.sdk2.inquiry.steps.ui.m r3 = com.withpersona.sdk2.inquiry.steps.ui.m.f27597a
            com.withpersona.sdk2.inquiry.document.DocumentPages r4 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r4 = r4.c()
            com.withpersona.sdk2.inquiry.steps.ui.UiScreen r4 = com.withpersona.sdk2.inquiry.steps.ui.b.a(r4)
            com.withpersona.sdk2.inquiry.document.DocumentPages r5 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r5 = r5.c()
            r7 = r45
            java.util.List r5 = r0.l(r5, r7)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$3 r6 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$3
            r6.<init>(r0, r7)
            com.withpersona.sdk2.inquiry.document.DocumentPages r1 = r43.k()
            com.withpersona.sdk2.inquiry.document.UploadOptionsDialog r1 = r1.c()
            java.lang.String r1 = r1.a()
            com.withpersona.sdk2.inquiry.steps.ui.UiStepBottomSheet r1 = r3.h(r4, r5, r6, r1)
            r3 = r41
            com.withpersona.sdk2.inquiry.modal.b r1 = com.withpersona.sdk2.inquiry.modal.c.a(r1, r2, r3)
            goto L_0x02cb
        L_0x0285:
            r1 = r2
            goto L_0x02cb
        L_0x0287:
            r7 = r15
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.document.DocumentWorkflow.State.UploadDocument
            if (r3 == 0) goto L_0x02cc
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker$a r8 = r0.f25015j
            java.lang.String r9 = r43.t()
            java.lang.String r10 = r43.i()
            java.lang.String r11 = r43.h()
            java.lang.String r12 = r43.g()
            java.util.List r13 = r44.h()
            com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker r2 = r8.a(r9, r10, r11, r12, r13)
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$4 r3 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$4
            r3.<init>(r0)
            java.lang.Class<com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker> r4 = com.withpersona.sdk2.inquiry.document.network.DocumentSubmitWorker.class
            wk.m r4 = kotlin.jvm.internal.l.k(r4)
            com.squareup.workflow1.o.l(r7, r2, r4, r6, r3)
            java.lang.String r2 = r43.m()
            java.lang.String r3 = r43.l()
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle r1 = r43.v()
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$d$a r4 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$d$a
            com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$5 r5 = new com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$5
            r5.<init>(r0, r7)
            r4.<init>(r2, r3, r5, r1)
            r1 = r4
        L_0x02cb:
            return r1
        L_0x02cc:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow.f(com.withpersona.sdk2.inquiry.document.DocumentWorkflow$b, com.withpersona.sdk2.inquiry.document.DocumentWorkflow$State, com.squareup.workflow1.h$a):java.lang.Object");
    }

    /* renamed from: r */
    public Snapshot g(State state) {
        j.g(state, "state");
        return SnapshotParcelsKt.a(state);
    }
}
