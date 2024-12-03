package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint;
import com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments;
import com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcData;
import com.withpersona.sdk2.inquiry.nfc.MrzKey;
import com.withpersona.sdk2.inquiry.nfc.PassportInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class GovernmentIdState implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25382a;

    public static final class CountdownToCapture extends GovernmentIdState {
        public static final Parcelable.Creator<CountdownToCapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.SideIdPart f25391b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25392c;

        /* renamed from: d  reason: collision with root package name */
        private final IdConfig f25393d;

        /* renamed from: e  reason: collision with root package name */
        private final GovernmentId f25394e;

        /* renamed from: f  reason: collision with root package name */
        private final List<IdPart> f25395f;

        /* renamed from: g  reason: collision with root package name */
        private final int f25396g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdState f25397h;

        /* renamed from: j  reason: collision with root package name */
        private final Hint f25398j;

        public static final class a implements Parcelable.Creator<CountdownToCapture> {
            /* renamed from: a */
            public final CountdownToCapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.SideIdPart createFromParcel = IdPart.SideIdPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(CountdownToCapture.class.getClassLoader()));
                }
                IdConfig createFromParcel2 = IdConfig.CREATOR.createFromParcel(parcel);
                GovernmentId governmentId = (GovernmentId) parcel.readParcelable(CountdownToCapture.class.getClassLoader());
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(CountdownToCapture.class.getClassLoader()));
                }
                return new CountdownToCapture(createFromParcel, arrayList, createFromParcel2, governmentId, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(CountdownToCapture.class.getClassLoader()), (Hint) parcel.readParcelable(CountdownToCapture.class.getClassLoader()));
            }

            /* renamed from: b */
            public final CountdownToCapture[] newArray(int i10) {
                return new CountdownToCapture[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CountdownToCapture(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, Hint hint) {
            super((DefaultConstructorMarker) null);
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            j.g(list2, "parts");
            this.f25391b = sideIdPart;
            this.f25392c = list;
            this.f25393d = idConfig;
            this.f25394e = governmentId;
            this.f25395f = list2;
            this.f25396g = i10;
            this.f25397h = governmentIdState;
            this.f25398j = hint;
        }

        public static /* synthetic */ CountdownToCapture m(CountdownToCapture countdownToCapture, IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentId governmentId, List list2, int i10, GovernmentIdState governmentIdState, Hint hint, int i11, Object obj) {
            CountdownToCapture countdownToCapture2 = countdownToCapture;
            int i12 = i11;
            return countdownToCapture.l((i12 & 1) != 0 ? countdownToCapture.n() : sideIdPart, (i12 & 2) != 0 ? countdownToCapture.j() : list, (i12 & 4) != 0 ? countdownToCapture2.f25393d : idConfig, (i12 & 8) != 0 ? countdownToCapture2.f25394e : governmentId, (i12 & 16) != 0 ? countdownToCapture.i() : list2, (i12 & 32) != 0 ? countdownToCapture.h() : i10, (i12 & 64) != 0 ? countdownToCapture.f() : governmentIdState, (i12 & 128) != 0 ? countdownToCapture2.f25398j : hint);
        }

        public int describeContents() {
            return 0;
        }

        public void e() {
            GovernmentIdState.super.e();
            for (Frame a10 : this.f25394e.U1()) {
                new File(a10.a()).delete();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountdownToCapture)) {
                return false;
            }
            CountdownToCapture countdownToCapture = (CountdownToCapture) obj;
            return j.b(n(), countdownToCapture.n()) && j.b(j(), countdownToCapture.j()) && j.b(this.f25393d, countdownToCapture.f25393d) && j.b(this.f25394e, countdownToCapture.f25394e) && j.b(i(), countdownToCapture.i()) && h() == countdownToCapture.h() && j.b(f(), countdownToCapture.f()) && j.b(this.f25398j, countdownToCapture.f25398j);
        }

        public GovernmentIdState f() {
            return this.f25397h;
        }

        public int h() {
            return this.f25396g;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((((n().hashCode() * 31) + j().hashCode()) * 31) + this.f25393d.hashCode()) * 31) + this.f25394e.hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            Hint hint = this.f25398j;
            if (hint != null) {
                i10 = hint.hashCode();
            }
            return hashCode + i10;
        }

        public List<IdPart> i() {
            return this.f25395f;
        }

        public List<GovernmentId> j() {
            return this.f25392c;
        }

        public final CountdownToCapture l(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, Hint hint) {
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            j.g(list2, "parts");
            return new CountdownToCapture(sideIdPart, list, idConfig, governmentId, list2, i10, governmentIdState, hint);
        }

        public IdPart.SideIdPart n() {
            return this.f25391b;
        }

        public final Hint o() {
            return this.f25398j;
        }

        public final IdConfig p() {
            return this.f25393d;
        }

        public final GovernmentId q() {
            return this.f25394e;
        }

        public String toString() {
            return "CountdownToCapture(currentPart=" + n() + ", uploadingIds=" + j() + ", id=" + this.f25393d + ", idForReview=" + this.f25394e + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", hint=" + this.f25398j + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25391b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25392c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            this.f25393d.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f25394e, i10);
            List<IdPart> list2 = this.f25395f;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25396g);
            parcel.writeParcelable(this.f25397h, i10);
            parcel.writeParcelable(this.f25398j, i10);
        }
    }

    public static final class FinalizeVideo extends GovernmentIdState {
        public static final Parcelable.Creator<FinalizeVideo> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdConfig f25399b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25400c;

        /* renamed from: d  reason: collision with root package name */
        private final IdPart f25401d;

        /* renamed from: e  reason: collision with root package name */
        private final List<IdPart> f25402e;

        /* renamed from: f  reason: collision with root package name */
        private final int f25403f;

        /* renamed from: g  reason: collision with root package name */
        private final GovernmentIdState f25404g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdRequestArguments f25405h;

        /* renamed from: j  reason: collision with root package name */
        private final PassportNfcRequestArguments f25406j;

        /* renamed from: k  reason: collision with root package name */
        private final long f25407k;

        /* renamed from: l  reason: collision with root package name */
        private final boolean f25408l;

        public static final class a implements Parcelable.Creator<FinalizeVideo> {
            /* renamed from: a */
            public final FinalizeVideo createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdConfig createFromParcel = IdConfig.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(FinalizeVideo.class.getClassLoader()));
                }
                IdPart idPart = (IdPart) parcel.readParcelable(FinalizeVideo.class.getClassLoader());
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(FinalizeVideo.class.getClassLoader()));
                }
                int readInt3 = parcel.readInt();
                GovernmentIdState governmentIdState = (GovernmentIdState) parcel.readParcelable(FinalizeVideo.class.getClassLoader());
                PassportNfcRequestArguments passportNfcRequestArguments = null;
                GovernmentIdRequestArguments createFromParcel2 = parcel.readInt() == 0 ? null : GovernmentIdRequestArguments.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    passportNfcRequestArguments = PassportNfcRequestArguments.CREATOR.createFromParcel(parcel);
                }
                return new FinalizeVideo(createFromParcel, arrayList, idPart, arrayList2, readInt3, governmentIdState, createFromParcel2, passportNfcRequestArguments, parcel.readLong(), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final FinalizeVideo[] newArray(int i10) {
                return new FinalizeVideo[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ FinalizeVideo(com.withpersona.sdk2.inquiry.governmentid.IdConfig r16, java.util.List r17, com.withpersona.sdk2.inquiry.governmentid.IdPart r18, java.util.List r19, int r20, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r21, com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r22, com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r23, long r24, boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
            /*
                r15 = this;
                r0 = r27
                r1 = r0 & 32
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r9 = r2
                goto L_0x000b
            L_0x0009:
                r9 = r21
            L_0x000b:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0011
                r10 = r2
                goto L_0x0013
            L_0x0011:
                r10 = r22
            L_0x0013:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x0019
                r11 = r2
                goto L_0x001b
            L_0x0019:
                r11 = r23
            L_0x001b:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x0023
                r1 = 3000(0xbb8, double:1.482E-320)
                r12 = r1
                goto L_0x0025
            L_0x0023:
                r12 = r24
            L_0x0025:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x002c
                r0 = 0
                r14 = r0
                goto L_0x002e
            L_0x002c:
                r14 = r26
            L_0x002e:
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.FinalizeVideo.<init>(com.withpersona.sdk2.inquiry.governmentid.IdConfig, java.util.List, com.withpersona.sdk2.inquiry.governmentid.IdPart, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments, com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments, long, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ FinalizeVideo m(FinalizeVideo finalizeVideo, IdConfig idConfig, List list, IdPart idPart, List list2, int i10, GovernmentIdState governmentIdState, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments, long j10, boolean z10, int i11, Object obj) {
            FinalizeVideo finalizeVideo2 = finalizeVideo;
            int i12 = i11;
            return finalizeVideo.l((i12 & 1) != 0 ? finalizeVideo2.f25399b : idConfig, (i12 & 2) != 0 ? finalizeVideo.j() : list, (i12 & 4) != 0 ? finalizeVideo.n() : idPart, (i12 & 8) != 0 ? finalizeVideo.i() : list2, (i12 & 16) != 0 ? finalizeVideo.h() : i10, (i12 & 32) != 0 ? finalizeVideo.f() : governmentIdState, (i12 & 64) != 0 ? finalizeVideo2.f25405h : governmentIdRequestArguments, (i12 & 128) != 0 ? finalizeVideo2.f25406j : passportNfcRequestArguments, (i12 & 256) != 0 ? finalizeVideo2.f25407k : j10, (i12 & 512) != 0 ? finalizeVideo2.f25408l : z10);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FinalizeVideo)) {
                return false;
            }
            FinalizeVideo finalizeVideo = (FinalizeVideo) obj;
            return j.b(this.f25399b, finalizeVideo.f25399b) && j.b(j(), finalizeVideo.j()) && j.b(n(), finalizeVideo.n()) && j.b(i(), finalizeVideo.i()) && h() == finalizeVideo.h() && j.b(f(), finalizeVideo.f()) && j.b(this.f25405h, finalizeVideo.f25405h) && j.b(this.f25406j, finalizeVideo.f25406j) && this.f25407k == finalizeVideo.f25407k && this.f25408l == finalizeVideo.f25408l;
        }

        public GovernmentIdState f() {
            return this.f25404g;
        }

        public int h() {
            return this.f25403f;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((this.f25399b.hashCode() * 31) + j().hashCode()) * 31) + n().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            GovernmentIdRequestArguments governmentIdRequestArguments = this.f25405h;
            int hashCode2 = (hashCode + (governmentIdRequestArguments == null ? 0 : governmentIdRequestArguments.hashCode())) * 31;
            PassportNfcRequestArguments passportNfcRequestArguments = this.f25406j;
            if (passportNfcRequestArguments != null) {
                i10 = passportNfcRequestArguments.hashCode();
            }
            int hashCode3 = (((hashCode2 + i10) * 31) + Long.hashCode(this.f25407k)) * 31;
            boolean z10 = this.f25408l;
            if (z10) {
                z10 = true;
            }
            return hashCode3 + (z10 ? 1 : 0);
        }

        public List<IdPart> i() {
            return this.f25402e;
        }

        public List<GovernmentId> j() {
            return this.f25400c;
        }

        public final FinalizeVideo l(IdConfig idConfig, List<? extends GovernmentId> list, IdPart idPart, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments, long j10, boolean z10) {
            j.g(idConfig, "id");
            j.g(list, "uploadingIds");
            IdPart idPart2 = idPart;
            j.g(idPart2, "currentPart");
            List<? extends IdPart> list3 = list2;
            j.g(list3, "parts");
            return new FinalizeVideo(idConfig, list, idPart2, list3, i10, governmentIdState, governmentIdRequestArguments, passportNfcRequestArguments, j10, z10);
        }

        public IdPart n() {
            return this.f25401d;
        }

        public final IdConfig o() {
            return this.f25399b;
        }

        public final long p() {
            return this.f25407k;
        }

        public final boolean q() {
            return this.f25408l;
        }

        public String toString() {
            return "FinalizeVideo(id=" + this.f25399b + ", uploadingIds=" + j() + ", currentPart=" + n() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", governmentIdRequestArguments=" + this.f25405h + ", passportNfcRequestArguments=" + this.f25406j + ", minDurationMs=" + this.f25407k + ", isDelayComplete=" + this.f25408l + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25399b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25400c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeParcelable(this.f25401d, i10);
            List<IdPart> list2 = this.f25402e;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25403f);
            parcel.writeParcelable(this.f25404g, i10);
            GovernmentIdRequestArguments governmentIdRequestArguments = this.f25405h;
            if (governmentIdRequestArguments == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                governmentIdRequestArguments.writeToParcel(parcel, i10);
            }
            PassportNfcRequestArguments passportNfcRequestArguments = this.f25406j;
            if (passportNfcRequestArguments == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                passportNfcRequestArguments.writeToParcel(parcel, i10);
            }
            parcel.writeLong(this.f25407k);
            parcel.writeInt(this.f25408l ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinalizeVideo(IdConfig idConfig, List<? extends GovernmentId> list, IdPart idPart, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments, long j10, boolean z10) {
            super((DefaultConstructorMarker) null);
            j.g(idConfig, "id");
            j.g(list, "uploadingIds");
            j.g(idPart, "currentPart");
            j.g(list2, "parts");
            this.f25399b = idConfig;
            this.f25400c = list;
            this.f25401d = idPart;
            this.f25402e = list2;
            this.f25403f = i10;
            this.f25404g = governmentIdState;
            this.f25405h = governmentIdRequestArguments;
            this.f25406j = passportNfcRequestArguments;
            this.f25407k = j10;
            this.f25408l = z10;
        }
    }

    public static final class PassportNfcConfirmDetails extends GovernmentIdState {
        public static final Parcelable.Creator<PassportNfcConfirmDetails> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.PassportNfcPart f25417b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25418c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25419d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25420e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25421f;

        /* renamed from: g  reason: collision with root package name */
        private final PassportNfcConfirmDetailsPage f25422g;

        /* renamed from: h  reason: collision with root package name */
        private final IdConfig f25423h;

        /* renamed from: j  reason: collision with root package name */
        private final PassportNfcData f25424j;

        /* renamed from: k  reason: collision with root package name */
        private final PassportInfo f25425k;

        public static final class a implements Parcelable.Creator<PassportNfcConfirmDetails> {
            /* renamed from: a */
            public final PassportNfcConfirmDetails createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.PassportNfcPart createFromParcel = IdPart.PassportNfcPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(PassportNfcConfirmDetails.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcConfirmDetails.class.getClassLoader()));
                }
                return new PassportNfcConfirmDetails(createFromParcel, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(PassportNfcConfirmDetails.class.getClassLoader()), PassportNfcConfirmDetailsPage.CREATOR.createFromParcel(parcel), IdConfig.CREATOR.createFromParcel(parcel), PassportNfcData.CREATOR.createFromParcel(parcel), (PassportInfo) parcel.readParcelable(PassportNfcConfirmDetails.class.getClassLoader()));
            }

            /* renamed from: b */
            public final PassportNfcConfirmDetails[] newArray(int i10) {
                return new PassportNfcConfirmDetails[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PassportNfcConfirmDetails(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage, IdConfig idConfig, PassportNfcData passportNfcData, PassportInfo passportInfo) {
            super((DefaultConstructorMarker) null);
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(passportNfcConfirmDetailsPage, "passportNfcConfirmDetailsPage");
            j.g(idConfig, "selectedId");
            j.g(passportNfcData, "passportNfcData");
            j.g(passportInfo, "passportInfo");
            this.f25417b = passportNfcPart;
            this.f25418c = list;
            this.f25419d = list2;
            this.f25420e = i10;
            this.f25421f = governmentIdState;
            this.f25422g = passportNfcConfirmDetailsPage;
            this.f25423h = idConfig;
            this.f25424j = passportNfcData;
            this.f25425k = passportInfo;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PassportNfcConfirmDetails)) {
                return false;
            }
            PassportNfcConfirmDetails passportNfcConfirmDetails = (PassportNfcConfirmDetails) obj;
            return j.b(l(), passportNfcConfirmDetails.l()) && j.b(j(), passportNfcConfirmDetails.j()) && j.b(i(), passportNfcConfirmDetails.i()) && h() == passportNfcConfirmDetails.h() && j.b(f(), passportNfcConfirmDetails.f()) && j.b(this.f25422g, passportNfcConfirmDetails.f25422g) && j.b(this.f25423h, passportNfcConfirmDetails.f25423h) && j.b(this.f25424j, passportNfcConfirmDetails.f25424j) && j.b(this.f25425k, passportNfcConfirmDetails.f25425k);
        }

        public GovernmentIdState f() {
            return this.f25421f;
        }

        public int h() {
            return this.f25420e;
        }

        public int hashCode() {
            return (((((((((((((((l().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25422g.hashCode()) * 31) + this.f25423h.hashCode()) * 31) + this.f25424j.hashCode()) * 31) + this.f25425k.hashCode();
        }

        public List<IdPart> i() {
            return this.f25419d;
        }

        public List<GovernmentId> j() {
            return this.f25418c;
        }

        public IdPart.PassportNfcPart l() {
            return this.f25417b;
        }

        public final PassportInfo m() {
            return this.f25425k;
        }

        public final PassportNfcConfirmDetailsPage n() {
            return this.f25422g;
        }

        public final PassportNfcData o() {
            return this.f25424j;
        }

        public final IdConfig p() {
            return this.f25423h;
        }

        public String toString() {
            return "PassportNfcConfirmDetails(currentPart=" + l() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", passportNfcConfirmDetailsPage=" + this.f25422g + ", selectedId=" + this.f25423h + ", passportNfcData=" + this.f25424j + ", passportInfo=" + this.f25425k + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25417b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25418c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25419d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25420e);
            parcel.writeParcelable(this.f25421f, i10);
            this.f25422g.writeToParcel(parcel, i10);
            this.f25423h.writeToParcel(parcel, i10);
            this.f25424j.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f25425k, i10);
        }
    }

    public static final class PassportNfcInstructions extends GovernmentIdState {
        public static final Parcelable.Creator<PassportNfcInstructions> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.PassportNfcPart f25432b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25433c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25434d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25435e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25436f;

        /* renamed from: g  reason: collision with root package name */
        private final PassportNfcStartPage f25437g;

        /* renamed from: h  reason: collision with root package name */
        private final IdConfig f25438h;

        public static final class a implements Parcelable.Creator<PassportNfcInstructions> {
            /* renamed from: a */
            public final PassportNfcInstructions createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.PassportNfcPart createFromParcel = IdPart.PassportNfcPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(PassportNfcInstructions.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcInstructions.class.getClassLoader()));
                }
                return new PassportNfcInstructions(createFromParcel, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(PassportNfcInstructions.class.getClassLoader()), PassportNfcStartPage.CREATOR.createFromParcel(parcel), IdConfig.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final PassportNfcInstructions[] newArray(int i10) {
                return new PassportNfcInstructions[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PassportNfcInstructions(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcStartPage passportNfcStartPage, IdConfig idConfig) {
            super((DefaultConstructorMarker) null);
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(passportNfcStartPage, "passportNfcStartPage");
            j.g(idConfig, "selectedId");
            this.f25432b = passportNfcPart;
            this.f25433c = list;
            this.f25434d = list2;
            this.f25435e = i10;
            this.f25436f = governmentIdState;
            this.f25437g = passportNfcStartPage;
            this.f25438h = idConfig;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PassportNfcInstructions)) {
                return false;
            }
            PassportNfcInstructions passportNfcInstructions = (PassportNfcInstructions) obj;
            return j.b(l(), passportNfcInstructions.l()) && j.b(j(), passportNfcInstructions.j()) && j.b(i(), passportNfcInstructions.i()) && h() == passportNfcInstructions.h() && j.b(f(), passportNfcInstructions.f()) && j.b(this.f25437g, passportNfcInstructions.f25437g) && j.b(this.f25438h, passportNfcInstructions.f25438h);
        }

        public GovernmentIdState f() {
            return this.f25436f;
        }

        public int h() {
            return this.f25435e;
        }

        public int hashCode() {
            return (((((((((((l().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25437g.hashCode()) * 31) + this.f25438h.hashCode();
        }

        public List<IdPart> i() {
            return this.f25434d;
        }

        public List<GovernmentId> j() {
            return this.f25433c;
        }

        public IdPart.PassportNfcPart l() {
            return this.f25432b;
        }

        public final PassportNfcStartPage m() {
            return this.f25437g;
        }

        public final IdConfig n() {
            return this.f25438h;
        }

        public String toString() {
            return "PassportNfcInstructions(currentPart=" + l() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", passportNfcStartPage=" + this.f25437g + ", selectedId=" + this.f25438h + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25432b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25433c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25434d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25435e);
            parcel.writeParcelable(this.f25436f, i10);
            this.f25437g.writeToParcel(parcel, i10);
            this.f25438h.writeToParcel(parcel, i10);
        }
    }

    public static final class ReviewCapturedImage extends GovernmentIdState {
        public static final Parcelable.Creator<ReviewCapturedImage> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.SideIdPart f25448b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25449c;

        /* renamed from: d  reason: collision with root package name */
        private final IdConfig f25450d;

        /* renamed from: e  reason: collision with root package name */
        private final GovernmentId f25451e;

        /* renamed from: f  reason: collision with root package name */
        private final List<IdPart> f25452f;

        /* renamed from: g  reason: collision with root package name */
        private final int f25453g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdState f25454h;

        /* renamed from: j  reason: collision with root package name */
        private final String f25455j;

        public static final class a implements Parcelable.Creator<ReviewCapturedImage> {
            /* renamed from: a */
            public final ReviewCapturedImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.SideIdPart createFromParcel = IdPart.SideIdPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(ReviewCapturedImage.class.getClassLoader()));
                }
                IdConfig createFromParcel2 = IdConfig.CREATOR.createFromParcel(parcel);
                GovernmentId governmentId = (GovernmentId) parcel.readParcelable(ReviewCapturedImage.class.getClassLoader());
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(ReviewCapturedImage.class.getClassLoader()));
                }
                return new ReviewCapturedImage(createFromParcel, arrayList, createFromParcel2, governmentId, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(ReviewCapturedImage.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: b */
            public final ReviewCapturedImage[] newArray(int i10) {
                return new ReviewCapturedImage[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ReviewCapturedImage(IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentId governmentId, List list2, int i10, GovernmentIdState governmentIdState, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(sideIdPart, list, idConfig, governmentId, list2, i10, governmentIdState, (i11 & 128) != 0 ? null : str);
        }

        public static /* synthetic */ ReviewCapturedImage m(ReviewCapturedImage reviewCapturedImage, IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentId governmentId, List list2, int i10, GovernmentIdState governmentIdState, String str, int i11, Object obj) {
            ReviewCapturedImage reviewCapturedImage2 = reviewCapturedImage;
            int i12 = i11;
            return reviewCapturedImage.l((i12 & 1) != 0 ? reviewCapturedImage.n() : sideIdPart, (i12 & 2) != 0 ? reviewCapturedImage.j() : list, (i12 & 4) != 0 ? reviewCapturedImage2.f25450d : idConfig, (i12 & 8) != 0 ? reviewCapturedImage2.f25451e : governmentId, (i12 & 16) != 0 ? reviewCapturedImage.i() : list2, (i12 & 32) != 0 ? reviewCapturedImage.h() : i10, (i12 & 64) != 0 ? reviewCapturedImage.f() : governmentIdState, (i12 & 128) != 0 ? reviewCapturedImage2.f25455j : str);
        }

        public int describeContents() {
            return 0;
        }

        public void e() {
            GovernmentIdState.super.e();
            for (Frame a10 : this.f25451e.U1()) {
                new File(a10.a()).delete();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReviewCapturedImage)) {
                return false;
            }
            ReviewCapturedImage reviewCapturedImage = (ReviewCapturedImage) obj;
            return j.b(n(), reviewCapturedImage.n()) && j.b(j(), reviewCapturedImage.j()) && j.b(this.f25450d, reviewCapturedImage.f25450d) && j.b(this.f25451e, reviewCapturedImage.f25451e) && j.b(i(), reviewCapturedImage.i()) && h() == reviewCapturedImage.h() && j.b(f(), reviewCapturedImage.f()) && j.b(this.f25455j, reviewCapturedImage.f25455j);
        }

        public GovernmentIdState f() {
            return this.f25454h;
        }

        public final String getError() {
            return this.f25455j;
        }

        public int h() {
            return this.f25453g;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((((n().hashCode() * 31) + j().hashCode()) * 31) + this.f25450d.hashCode()) * 31) + this.f25451e.hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            String str = this.f25455j;
            if (str != null) {
                i10 = str.hashCode();
            }
            return hashCode + i10;
        }

        public List<IdPart> i() {
            return this.f25452f;
        }

        public List<GovernmentId> j() {
            return this.f25449c;
        }

        public final ReviewCapturedImage l(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, String str) {
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            j.g(list2, "parts");
            return new ReviewCapturedImage(sideIdPart, list, idConfig, governmentId, list2, i10, governmentIdState, str);
        }

        public IdPart.SideIdPart n() {
            return this.f25448b;
        }

        public final IdConfig o() {
            return this.f25450d;
        }

        public final GovernmentId p() {
            return this.f25451e;
        }

        public String toString() {
            return "ReviewCapturedImage(currentPart=" + n() + ", uploadingIds=" + j() + ", id=" + this.f25450d + ", idForReview=" + this.f25451e + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", error=" + this.f25455j + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25448b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25449c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            this.f25450d.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f25451e, i10);
            List<IdPart> list2 = this.f25452f;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25453g);
            parcel.writeParcelable(this.f25454h, i10);
            parcel.writeString(this.f25455j);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReviewCapturedImage(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, String str) {
            super((DefaultConstructorMarker) null);
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            j.g(list2, "parts");
            this.f25448b = sideIdPart;
            this.f25449c = list;
            this.f25450d = idConfig;
            this.f25451e = governmentId;
            this.f25452f = list2;
            this.f25453g = i10;
            this.f25454h = governmentIdState;
            this.f25455j = str;
        }
    }

    public static final class ReviewSelectedImage extends GovernmentIdState {
        public static final Parcelable.Creator<ReviewSelectedImage> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.SideIdPart f25456b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25457c;

        /* renamed from: d  reason: collision with root package name */
        private final IdConfig f25458d;

        /* renamed from: e  reason: collision with root package name */
        private final GovernmentId f25459e;

        /* renamed from: f  reason: collision with root package name */
        private final String f25460f;

        /* renamed from: g  reason: collision with root package name */
        private final List<IdPart> f25461g;

        /* renamed from: h  reason: collision with root package name */
        private final int f25462h;

        /* renamed from: j  reason: collision with root package name */
        private final GovernmentIdState f25463j;

        /* renamed from: k  reason: collision with root package name */
        private final String f25464k;

        public static final class a implements Parcelable.Creator<ReviewSelectedImage> {
            /* renamed from: a */
            public final ReviewSelectedImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.SideIdPart createFromParcel = IdPart.SideIdPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(ReviewSelectedImage.class.getClassLoader()));
                }
                IdConfig createFromParcel2 = IdConfig.CREATOR.createFromParcel(parcel);
                GovernmentId governmentId = (GovernmentId) parcel.readParcelable(ReviewSelectedImage.class.getClassLoader());
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(ReviewSelectedImage.class.getClassLoader()));
                }
                return new ReviewSelectedImage(createFromParcel, arrayList, createFromParcel2, governmentId, readString, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(ReviewSelectedImage.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: b */
            public final ReviewSelectedImage[] newArray(int i10) {
                return new ReviewSelectedImage[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ReviewSelectedImage(IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentId governmentId, String str, List list2, int i10, GovernmentIdState governmentIdState, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(sideIdPart, list, idConfig, governmentId, str, list2, i10, governmentIdState, (i11 & 256) != 0 ? null : str2);
        }

        public static /* synthetic */ ReviewSelectedImage m(ReviewSelectedImage reviewSelectedImage, IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentId governmentId, String str, List list2, int i10, GovernmentIdState governmentIdState, String str2, int i11, Object obj) {
            ReviewSelectedImage reviewSelectedImage2 = reviewSelectedImage;
            int i12 = i11;
            return reviewSelectedImage.l((i12 & 1) != 0 ? reviewSelectedImage.n() : sideIdPart, (i12 & 2) != 0 ? reviewSelectedImage.j() : list, (i12 & 4) != 0 ? reviewSelectedImage2.f25458d : idConfig, (i12 & 8) != 0 ? reviewSelectedImage2.f25459e : governmentId, (i12 & 16) != 0 ? reviewSelectedImage2.f25460f : str, (i12 & 32) != 0 ? reviewSelectedImage.i() : list2, (i12 & 64) != 0 ? reviewSelectedImage.h() : i10, (i12 & 128) != 0 ? reviewSelectedImage.f() : governmentIdState, (i12 & 256) != 0 ? reviewSelectedImage2.f25464k : str2);
        }

        public int describeContents() {
            return 0;
        }

        public void e() {
            GovernmentIdState.super.e();
            for (Frame a10 : this.f25459e.U1()) {
                new File(a10.a()).delete();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReviewSelectedImage)) {
                return false;
            }
            ReviewSelectedImage reviewSelectedImage = (ReviewSelectedImage) obj;
            return j.b(n(), reviewSelectedImage.n()) && j.b(j(), reviewSelectedImage.j()) && j.b(this.f25458d, reviewSelectedImage.f25458d) && j.b(this.f25459e, reviewSelectedImage.f25459e) && j.b(this.f25460f, reviewSelectedImage.f25460f) && j.b(i(), reviewSelectedImage.i()) && h() == reviewSelectedImage.h() && j.b(f(), reviewSelectedImage.f()) && j.b(this.f25464k, reviewSelectedImage.f25464k);
        }

        public GovernmentIdState f() {
            return this.f25463j;
        }

        public final String getError() {
            return this.f25464k;
        }

        public int h() {
            return this.f25462h;
        }

        public int hashCode() {
            int hashCode = ((((((n().hashCode() * 31) + j().hashCode()) * 31) + this.f25458d.hashCode()) * 31) + this.f25459e.hashCode()) * 31;
            String str = this.f25460f;
            int i10 = 0;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            String str2 = this.f25464k;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return hashCode2 + i10;
        }

        public List<IdPart> i() {
            return this.f25461g;
        }

        public List<GovernmentId> j() {
            return this.f25457c;
        }

        public final ReviewSelectedImage l(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, String str, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, String str2) {
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            List<? extends IdPart> list3 = list2;
            j.g(list3, "parts");
            return new ReviewSelectedImage(sideIdPart, list, idConfig, governmentId, str, list3, i10, governmentIdState, str2);
        }

        public IdPart.SideIdPart n() {
            return this.f25456b;
        }

        public final String o() {
            return this.f25460f;
        }

        public final IdConfig p() {
            return this.f25458d;
        }

        public final GovernmentId q() {
            return this.f25459e;
        }

        public String toString() {
            return "ReviewSelectedImage(currentPart=" + n() + ", uploadingIds=" + j() + ", id=" + this.f25458d + ", idForReview=" + this.f25459e + ", fileName=" + this.f25460f + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", error=" + this.f25464k + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25456b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25457c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            this.f25458d.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f25459e, i10);
            parcel.writeString(this.f25460f);
            List<IdPart> list2 = this.f25461g;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25462h);
            parcel.writeParcelable(this.f25463j, i10);
            parcel.writeString(this.f25464k);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReviewSelectedImage(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentId governmentId, String str, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, String str2) {
            super((DefaultConstructorMarker) null);
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(governmentId, "idForReview");
            j.g(list2, "parts");
            this.f25456b = sideIdPart;
            this.f25457c = list;
            this.f25458d = idConfig;
            this.f25459e = governmentId;
            this.f25460f = str;
            this.f25461g = list2;
            this.f25462h = i10;
            this.f25463j = governmentIdState;
            this.f25464k = str2;
        }
    }

    public static final class WaitForAutocapture extends GovernmentIdState implements b, a {
        public static final Parcelable.Creator<WaitForAutocapture> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.SideIdPart f25490b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25491c;

        /* renamed from: d  reason: collision with root package name */
        private final IdConfig f25492d;

        /* renamed from: e  reason: collision with root package name */
        private final GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture f25493e;

        /* renamed from: f  reason: collision with root package name */
        private final List<IdPart> f25494f;

        /* renamed from: g  reason: collision with root package name */
        private final int f25495g;

        /* renamed from: h  reason: collision with root package name */
        private final Throwable f25496h;

        /* renamed from: j  reason: collision with root package name */
        private final GovernmentIdState f25497j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f25498k;

        /* renamed from: l  reason: collision with root package name */
        private final boolean f25499l;

        /* renamed from: m  reason: collision with root package name */
        private final Hint f25500m;

        public static final class a implements Parcelable.Creator<WaitForAutocapture> {
            /* renamed from: a */
            public final WaitForAutocapture createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.SideIdPart createFromParcel = IdPart.SideIdPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(WaitForAutocapture.class.getClassLoader()));
                }
                IdConfig createFromParcel2 = IdConfig.CREATOR.createFromParcel(parcel);
                GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture valueOf = GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.valueOf(parcel.readString());
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(WaitForAutocapture.class.getClassLoader()));
                }
                return new WaitForAutocapture(createFromParcel, arrayList, createFromParcel2, valueOf, arrayList2, parcel.readInt(), (Throwable) parcel.readSerializable(), (GovernmentIdState) parcel.readParcelable(WaitForAutocapture.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0, (Hint) parcel.readParcelable(WaitForAutocapture.class.getClassLoader()));
            }

            /* renamed from: b */
            public final WaitForAutocapture[] newArray(int i10) {
                return new WaitForAutocapture[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ WaitForAutocapture(com.withpersona.sdk2.inquiry.governmentid.IdPart.SideIdPart r16, java.util.List r17, com.withpersona.sdk2.inquiry.governmentid.IdConfig r18, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture r19, java.util.List r20, int r21, java.lang.Throwable r22, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r23, boolean r24, boolean r25, com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
            /*
                r15 = this;
                r0 = r27
                r1 = r0 & 64
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r10 = r2
                goto L_0x000b
            L_0x0009:
                r10 = r22
            L_0x000b:
                r1 = r0 & 256(0x100, float:3.59E-43)
                r3 = 1
                if (r1 == 0) goto L_0x0012
                r12 = r3
                goto L_0x0014
            L_0x0012:
                r12 = r24
            L_0x0014:
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x001a
                r13 = r3
                goto L_0x001c
            L_0x001a:
                r13 = r25
            L_0x001c:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x0022
                r14 = r2
                goto L_0x0024
            L_0x0022:
                r14 = r26
            L_0x0024:
                r3 = r15
                r4 = r16
                r5 = r17
                r6 = r18
                r7 = r19
                r8 = r20
                r9 = r21
                r11 = r23
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.WaitForAutocapture.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart, java.util.List, com.withpersona.sdk2.inquiry.governmentid.IdConfig, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture, java.util.List, int, java.lang.Throwable, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, boolean, boolean, com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ WaitForAutocapture m(WaitForAutocapture waitForAutocapture, IdPart.SideIdPart sideIdPart, List list, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, List list2, int i10, Throwable th2, GovernmentIdState governmentIdState, boolean z10, boolean z11, Hint hint, int i11, Object obj) {
            WaitForAutocapture waitForAutocapture2 = waitForAutocapture;
            int i12 = i11;
            return waitForAutocapture.l((i12 & 1) != 0 ? waitForAutocapture.p() : sideIdPart, (i12 & 2) != 0 ? waitForAutocapture.j() : list, (i12 & 4) != 0 ? waitForAutocapture2.f25492d : idConfig, (i12 & 8) != 0 ? waitForAutocapture2.f25493e : manualCapture, (i12 & 16) != 0 ? waitForAutocapture.i() : list2, (i12 & 32) != 0 ? waitForAutocapture.h() : i10, (i12 & 64) != 0 ? waitForAutocapture2.f25496h : th2, (i12 & 128) != 0 ? waitForAutocapture.f() : governmentIdState, (i12 & 256) != 0 ? waitForAutocapture.o() : z10, (i12 & 512) != 0 ? waitForAutocapture.n() : z11, (i12 & 1024) != 0 ? waitForAutocapture2.f25500m : hint);
        }

        public GovernmentIdState a(boolean z10) {
            return m(this, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture) null, (List) null, 0, (Throwable) null, (GovernmentIdState) null, false, z10, (Hint) null, 1535, (Object) null);
        }

        public GovernmentIdState c(boolean z10) {
            return m(this, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture) null, (List) null, 0, (Throwable) null, (GovernmentIdState) null, z10, false, (Hint) null, 1791, (Object) null);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WaitForAutocapture)) {
                return false;
            }
            WaitForAutocapture waitForAutocapture = (WaitForAutocapture) obj;
            return j.b(p(), waitForAutocapture.p()) && j.b(j(), waitForAutocapture.j()) && j.b(this.f25492d, waitForAutocapture.f25492d) && this.f25493e == waitForAutocapture.f25493e && j.b(i(), waitForAutocapture.i()) && h() == waitForAutocapture.h() && j.b(this.f25496h, waitForAutocapture.f25496h) && j.b(f(), waitForAutocapture.f()) && o() == waitForAutocapture.o() && n() == waitForAutocapture.n() && j.b(this.f25500m, waitForAutocapture.f25500m);
        }

        public GovernmentIdState f() {
            return this.f25497j;
        }

        public int h() {
            return this.f25495g;
        }

        public int hashCode() {
            int hashCode = ((((((((((p().hashCode() * 31) + j().hashCode()) * 31) + this.f25492d.hashCode()) * 31) + this.f25493e.hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31;
            Throwable th2 = this.f25496h;
            int i10 = 0;
            int hashCode2 = (((hashCode + (th2 == null ? 0 : th2.hashCode())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            boolean o10 = o();
            boolean z10 = true;
            if (o10) {
                o10 = true;
            }
            int i11 = (hashCode2 + (o10 ? 1 : 0)) * 31;
            boolean n10 = n();
            if (!n10) {
                z10 = n10;
            }
            int i12 = (i11 + (z10 ? 1 : 0)) * 31;
            Hint hint = this.f25500m;
            if (hint != null) {
                i10 = hint.hashCode();
            }
            return i12 + i10;
        }

        public List<IdPart> i() {
            return this.f25494f;
        }

        public List<GovernmentId> j() {
            return this.f25491c;
        }

        public final WaitForAutocapture l(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, List<? extends IdPart> list2, int i10, Throwable th2, GovernmentIdState governmentIdState, boolean z10, boolean z11, Hint hint) {
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            IdConfig idConfig2 = idConfig;
            j.g(idConfig2, "id");
            GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture2 = manualCapture;
            j.g(manualCapture2, "manualCapture");
            List<? extends IdPart> list3 = list2;
            j.g(list3, "parts");
            return new WaitForAutocapture(sideIdPart, list, idConfig2, manualCapture2, list3, i10, th2, governmentIdState, z10, z11, hint);
        }

        public boolean n() {
            return this.f25499l;
        }

        public boolean o() {
            return this.f25498k;
        }

        public IdPart.SideIdPart p() {
            return this.f25490b;
        }

        public final Throwable q() {
            return this.f25496h;
        }

        public final Hint r() {
            return this.f25500m;
        }

        public final IdConfig s() {
            return this.f25492d;
        }

        public final GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture t() {
            return this.f25493e;
        }

        public String toString() {
            return "WaitForAutocapture(currentPart=" + p() + ", uploadingIds=" + j() + ", id=" + this.f25492d + ", manualCapture=" + this.f25493e + ", parts=" + i() + ", partIndex=" + h() + ", error=" + this.f25496h + ", backState=" + f() + ", checkCameraPermissions=" + o() + ", checkAudioPermissions=" + n() + ", hint=" + this.f25500m + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25490b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25491c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            this.f25492d.writeToParcel(parcel, i10);
            parcel.writeString(this.f25493e.name());
            List<IdPart> list2 = this.f25494f;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25495g);
            parcel.writeSerializable(this.f25496h);
            parcel.writeParcelable(this.f25497j, i10);
            parcel.writeInt(this.f25498k ? 1 : 0);
            parcel.writeInt(this.f25499l ? 1 : 0);
            parcel.writeParcelable(this.f25500m, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WaitForAutocapture(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, List<? extends IdPart> list2, int i10, Throwable th2, GovernmentIdState governmentIdState, boolean z10, boolean z11, Hint hint) {
            super((DefaultConstructorMarker) null);
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(idConfig, "id");
            j.g(manualCapture, "manualCapture");
            j.g(list2, "parts");
            this.f25490b = sideIdPart;
            this.f25491c = list;
            this.f25492d = idConfig;
            this.f25493e = manualCapture;
            this.f25494f = list2;
            this.f25495g = i10;
            this.f25496h = th2;
            this.f25497j = governmentIdState;
            this.f25498k = z10;
            this.f25499l = z11;
            this.f25500m = hint;
        }
    }

    private GovernmentIdState() {
    }

    public /* synthetic */ GovernmentIdState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final GovernmentIdState d(String str) {
        j.g(str, "error");
        if (this instanceof ReviewCapturedImage) {
            return ReviewCapturedImage.m((ReviewCapturedImage) this, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentId) null, (List) null, 0, (GovernmentIdState) null, str, Opcodes.LAND, (Object) null);
        }
        if (this instanceof ReviewSelectedImage) {
            return ReviewSelectedImage.m((ReviewSelectedImage) this, (IdPart.SideIdPart) null, (List) null, (IdConfig) null, (GovernmentId) null, (String) null, (List) null, 0, (GovernmentIdState) null, str, 255, (Object) null);
        }
        if (this instanceof ChooseCaptureMethod) {
            return ChooseCaptureMethod.m((ChooseCaptureMethod) this, (IdPart.SideIdPart) null, (List) null, (List) null, 0, (IdConfig) null, false, (GovernmentIdState) null, str, Opcodes.LAND, (Object) null);
        }
        if (this instanceof ShowInstructions) {
            return ShowInstructions.m((ShowInstructions) this, (IdPart) null, (List) null, (List) null, (GovernmentIdState) null, 0, (IdConfig) null, false, str, Opcodes.LAND, (Object) null);
        }
        return this;
    }

    public void e() {
        for (GovernmentId U1 : j()) {
            for (Frame a10 : U1.U1()) {
                new File(a10.a()).delete();
            }
        }
    }

    public abstract GovernmentIdState f();

    public final boolean g() {
        return this.f25382a;
    }

    public abstract int h();

    public abstract List<IdPart> i();

    public abstract List<GovernmentId> j();

    public final void k(boolean z10) {
        this.f25382a = z10;
    }

    public static final class PassportNfcScan extends GovernmentIdState {
        public static final Parcelable.Creator<PassportNfcScan> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.PassportNfcPart f25439b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25440c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25441d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25442e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25443f;

        /* renamed from: g  reason: collision with root package name */
        private final PassportNfcScanPage f25444g;

        /* renamed from: h  reason: collision with root package name */
        private final IdConfig f25445h;

        /* renamed from: j  reason: collision with root package name */
        private final MrzKey f25446j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f25447k;

        public static final class a implements Parcelable.Creator<PassportNfcScan> {
            /* renamed from: a */
            public final PassportNfcScan createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.PassportNfcPart createFromParcel = IdPart.PassportNfcPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(PassportNfcScan.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcScan.class.getClassLoader()));
                }
                return new PassportNfcScan(createFromParcel, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(PassportNfcScan.class.getClassLoader()), PassportNfcScanPage.CREATOR.createFromParcel(parcel), IdConfig.CREATOR.createFromParcel(parcel), (MrzKey) parcel.readParcelable(PassportNfcScan.class.getClassLoader()), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final PassportNfcScan[] newArray(int i10) {
                return new PassportNfcScan[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ PassportNfcScan(com.withpersona.sdk2.inquiry.governmentid.IdPart.PassportNfcPart r13, java.util.List r14, java.util.List r15, int r16, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r17, com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage r18, com.withpersona.sdk2.inquiry.governmentid.IdConfig r19, com.withpersona.sdk2.inquiry.nfc.MrzKey r20, boolean r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r12 = this;
                r0 = r22
                r1 = r0 & 2
                if (r1 == 0) goto L_0x000c
                java.util.List r1 = kotlin.collections.q.j()
                r4 = r1
                goto L_0x000d
            L_0x000c:
                r4 = r14
            L_0x000d:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0014
                r1 = 0
                r7 = r1
                goto L_0x0016
            L_0x0014:
                r7 = r17
            L_0x0016:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x001d
                r0 = 0
                r11 = r0
                goto L_0x001f
            L_0x001d:
                r11 = r21
            L_0x001f:
                r2 = r12
                r3 = r13
                r5 = r15
                r6 = r16
                r8 = r18
                r9 = r19
                r10 = r20
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.PassportNfcScan.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart, java.util.List, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage, com.withpersona.sdk2.inquiry.governmentid.IdConfig, com.withpersona.sdk2.inquiry.nfc.MrzKey, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ PassportNfcScan m(PassportNfcScan passportNfcScan, IdPart.PassportNfcPart passportNfcPart, List list, List list2, int i10, GovernmentIdState governmentIdState, PassportNfcScanPage passportNfcScanPage, IdConfig idConfig, MrzKey mrzKey, boolean z10, int i11, Object obj) {
            PassportNfcScan passportNfcScan2 = passportNfcScan;
            int i12 = i11;
            return passportNfcScan.l((i12 & 1) != 0 ? passportNfcScan.n() : passportNfcPart, (i12 & 2) != 0 ? passportNfcScan.j() : list, (i12 & 4) != 0 ? passportNfcScan.i() : list2, (i12 & 8) != 0 ? passportNfcScan.h() : i10, (i12 & 16) != 0 ? passportNfcScan.f() : governmentIdState, (i12 & 32) != 0 ? passportNfcScan2.f25444g : passportNfcScanPage, (i12 & 64) != 0 ? passportNfcScan2.f25445h : idConfig, (i12 & 128) != 0 ? passportNfcScan2.f25446j : mrzKey, (i12 & 256) != 0 ? passportNfcScan2.f25447k : z10);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PassportNfcScan)) {
                return false;
            }
            PassportNfcScan passportNfcScan = (PassportNfcScan) obj;
            return j.b(n(), passportNfcScan.n()) && j.b(j(), passportNfcScan.j()) && j.b(i(), passportNfcScan.i()) && h() == passportNfcScan.h() && j.b(f(), passportNfcScan.f()) && j.b(this.f25444g, passportNfcScan.f25444g) && j.b(this.f25445h, passportNfcScan.f25445h) && j.b(this.f25446j, passportNfcScan.f25446j) && this.f25447k == passportNfcScan.f25447k;
        }

        public GovernmentIdState f() {
            return this.f25443f;
        }

        public int h() {
            return this.f25442e;
        }

        public int hashCode() {
            int hashCode = ((((((((((((((n().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25444g.hashCode()) * 31) + this.f25445h.hashCode()) * 31) + this.f25446j.hashCode()) * 31;
            boolean z10 = this.f25447k;
            if (z10) {
                z10 = true;
            }
            return hashCode + (z10 ? 1 : 0);
        }

        public List<IdPart> i() {
            return this.f25441d;
        }

        public List<GovernmentId> j() {
            return this.f25440c;
        }

        public final PassportNfcScan l(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcScanPage passportNfcScanPage, IdConfig idConfig, MrzKey mrzKey, boolean z10) {
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            PassportNfcScanPage passportNfcScanPage2 = passportNfcScanPage;
            j.g(passportNfcScanPage2, "passportNfcScanPage");
            IdConfig idConfig2 = idConfig;
            j.g(idConfig2, "selectedId");
            MrzKey mrzKey2 = mrzKey;
            j.g(mrzKey2, "mrzKey");
            return new PassportNfcScan(passportNfcPart, list, list2, i10, governmentIdState, passportNfcScanPage2, idConfig2, mrzKey2, z10);
        }

        public IdPart.PassportNfcPart n() {
            return this.f25439b;
        }

        public final MrzKey o() {
            return this.f25446j;
        }

        public final PassportNfcScanPage p() {
            return this.f25444g;
        }

        public final IdConfig q() {
            return this.f25445h;
        }

        public final boolean r() {
            return this.f25447k;
        }

        public String toString() {
            return "PassportNfcScan(currentPart=" + n() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", passportNfcScanPage=" + this.f25444g + ", selectedId=" + this.f25445h + ", mrzKey=" + this.f25446j + ", startScanNfc=" + this.f25447k + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25439b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25440c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25441d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25442e);
            parcel.writeParcelable(this.f25443f, i10);
            this.f25444g.writeToParcel(parcel, i10);
            this.f25445h.writeToParcel(parcel, i10);
            parcel.writeParcelable(this.f25446j, i10);
            parcel.writeInt(this.f25447k ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PassportNfcScan(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcScanPage passportNfcScanPage, IdConfig idConfig, MrzKey mrzKey, boolean z10) {
            super((DefaultConstructorMarker) null);
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(passportNfcScanPage, "passportNfcScanPage");
            j.g(idConfig, "selectedId");
            j.g(mrzKey, "mrzKey");
            this.f25439b = passportNfcPart;
            this.f25440c = list;
            this.f25441d = list2;
            this.f25442e = i10;
            this.f25443f = governmentIdState;
            this.f25444g = passportNfcScanPage;
            this.f25445h = idConfig;
            this.f25446j = mrzKey;
            this.f25447k = z10;
        }
    }

    public static final class Submit extends GovernmentIdState {
        public static final Parcelable.Creator<Submit> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdConfig f25473b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25474c;

        /* renamed from: d  reason: collision with root package name */
        private final IdPart f25475d;

        /* renamed from: e  reason: collision with root package name */
        private final List<IdPart> f25476e;

        /* renamed from: f  reason: collision with root package name */
        private final int f25477f;

        /* renamed from: g  reason: collision with root package name */
        private final GovernmentIdState f25478g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdRequestArguments f25479h;

        /* renamed from: j  reason: collision with root package name */
        private final PassportNfcRequestArguments f25480j;

        public static final class a implements Parcelable.Creator<Submit> {
            /* renamed from: a */
            public final Submit createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdConfig createFromParcel = IdConfig.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(Submit.class.getClassLoader()));
                }
                IdPart idPart = (IdPart) parcel.readParcelable(Submit.class.getClassLoader());
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(Submit.class.getClassLoader()));
                }
                int readInt3 = parcel.readInt();
                GovernmentIdState governmentIdState = (GovernmentIdState) parcel.readParcelable(Submit.class.getClassLoader());
                PassportNfcRequestArguments passportNfcRequestArguments = null;
                GovernmentIdRequestArguments createFromParcel2 = parcel.readInt() == 0 ? null : GovernmentIdRequestArguments.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    passportNfcRequestArguments = PassportNfcRequestArguments.CREATOR.createFromParcel(parcel);
                }
                return new Submit(createFromParcel, arrayList, idPart, arrayList2, readInt3, governmentIdState, createFromParcel2, passportNfcRequestArguments);
            }

            /* renamed from: b */
            public final Submit[] newArray(int i10) {
                return new Submit[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Submit(com.withpersona.sdk2.inquiry.governmentid.IdConfig r13, java.util.List r14, com.withpersona.sdk2.inquiry.governmentid.IdPart r15, java.util.List r16, int r17, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r18, com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r19, com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
            /*
                r12 = this;
                r0 = r21
                r1 = r0 & 4
                if (r1 == 0) goto L_0x000f
                com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r1 = new com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r2 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front
                r1.<init>(r2)
                r6 = r1
                goto L_0x0010
            L_0x000f:
                r6 = r15
            L_0x0010:
                r1 = r0 & 32
                r2 = 0
                if (r1 == 0) goto L_0x0017
                r9 = r2
                goto L_0x0019
            L_0x0017:
                r9 = r18
            L_0x0019:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x001f
                r10 = r2
                goto L_0x0021
            L_0x001f:
                r10 = r19
            L_0x0021:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0027
                r11 = r2
                goto L_0x0029
            L_0x0027:
                r11 = r20
            L_0x0029:
                r3 = r12
                r4 = r13
                r5 = r14
                r7 = r16
                r8 = r17
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.Submit.<init>(com.withpersona.sdk2.inquiry.governmentid.IdConfig, java.util.List, com.withpersona.sdk2.inquiry.governmentid.IdPart, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments, com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Submit)) {
                return false;
            }
            Submit submit = (Submit) obj;
            return j.b(this.f25473b, submit.f25473b) && j.b(j(), submit.j()) && j.b(l(), submit.l()) && j.b(i(), submit.i()) && h() == submit.h() && j.b(f(), submit.f()) && j.b(this.f25479h, submit.f25479h) && j.b(this.f25480j, submit.f25480j);
        }

        public GovernmentIdState f() {
            return this.f25478g;
        }

        public int h() {
            return this.f25477f;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((this.f25473b.hashCode() * 31) + j().hashCode()) * 31) + l().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            GovernmentIdRequestArguments governmentIdRequestArguments = this.f25479h;
            int hashCode2 = (hashCode + (governmentIdRequestArguments == null ? 0 : governmentIdRequestArguments.hashCode())) * 31;
            PassportNfcRequestArguments passportNfcRequestArguments = this.f25480j;
            if (passportNfcRequestArguments != null) {
                i10 = passportNfcRequestArguments.hashCode();
            }
            return hashCode2 + i10;
        }

        public List<IdPart> i() {
            return this.f25476e;
        }

        public List<GovernmentId> j() {
            return this.f25474c;
        }

        public IdPart l() {
            return this.f25475d;
        }

        public final GovernmentIdRequestArguments m() {
            return this.f25479h;
        }

        public final PassportNfcRequestArguments n() {
            return this.f25480j;
        }

        public String toString() {
            return "Submit(id=" + this.f25473b + ", uploadingIds=" + j() + ", currentPart=" + l() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", governmentIdRequestArguments=" + this.f25479h + ", passportNfcRequestArguments=" + this.f25480j + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25473b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25474c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            parcel.writeParcelable(this.f25475d, i10);
            List<IdPart> list2 = this.f25476e;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25477f);
            parcel.writeParcelable(this.f25478g, i10);
            GovernmentIdRequestArguments governmentIdRequestArguments = this.f25479h;
            if (governmentIdRequestArguments == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                governmentIdRequestArguments.writeToParcel(parcel, i10);
            }
            PassportNfcRequestArguments passportNfcRequestArguments = this.f25480j;
            if (passportNfcRequestArguments == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            passportNfcRequestArguments.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Submit(IdConfig idConfig, List<? extends GovernmentId> list, IdPart idPart, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, GovernmentIdRequestArguments governmentIdRequestArguments, PassportNfcRequestArguments passportNfcRequestArguments) {
            super((DefaultConstructorMarker) null);
            j.g(idConfig, "id");
            j.g(list, "uploadingIds");
            j.g(idPart, "currentPart");
            j.g(list2, "parts");
            this.f25473b = idConfig;
            this.f25474c = list;
            this.f25475d = idPart;
            this.f25476e = list2;
            this.f25477f = i10;
            this.f25478g = governmentIdState;
            this.f25479h = governmentIdRequestArguments;
            this.f25480j = passportNfcRequestArguments;
        }
    }

    public static final class ChooseCaptureMethod extends GovernmentIdState {
        public static final Parcelable.Creator<ChooseCaptureMethod> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.SideIdPart f25383b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25384c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25385d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25386e;

        /* renamed from: f  reason: collision with root package name */
        private final IdConfig f25387f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f25388g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdState f25389h;

        /* renamed from: j  reason: collision with root package name */
        private final String f25390j;

        public static final class a implements Parcelable.Creator<ChooseCaptureMethod> {
            /* renamed from: a */
            public final ChooseCaptureMethod createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.SideIdPart createFromParcel = IdPart.SideIdPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(ChooseCaptureMethod.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(ChooseCaptureMethod.class.getClassLoader()));
                }
                return new ChooseCaptureMethod(createFromParcel, arrayList, arrayList2, parcel.readInt(), IdConfig.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, (GovernmentIdState) parcel.readParcelable(ChooseCaptureMethod.class.getClassLoader()), parcel.readString());
            }

            /* renamed from: b */
            public final ChooseCaptureMethod[] newArray(int i10) {
                return new ChooseCaptureMethod[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ChooseCaptureMethod(com.withpersona.sdk2.inquiry.governmentid.IdPart.SideIdPart r13, java.util.List r14, java.util.List r15, int r16, com.withpersona.sdk2.inquiry.governmentid.IdConfig r17, boolean r18, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r19, java.lang.String r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
            /*
                r12 = this;
                r0 = r21
                r1 = r0 & 1
                if (r1 == 0) goto L_0x000f
                com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r1 = new com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r2 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front
                r1.<init>(r2)
                r4 = r1
                goto L_0x0010
            L_0x000f:
                r4 = r13
            L_0x0010:
                r1 = r0 & 2
                if (r1 == 0) goto L_0x001a
                java.util.List r1 = kotlin.collections.q.j()
                r5 = r1
                goto L_0x001b
            L_0x001a:
                r5 = r14
            L_0x001b:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0022
                r1 = 0
                r9 = r1
                goto L_0x0024
            L_0x0022:
                r9 = r18
            L_0x0024:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x002b
                r0 = 0
                r11 = r0
                goto L_0x002d
            L_0x002b:
                r11 = r20
            L_0x002d:
                r3 = r12
                r6 = r15
                r7 = r16
                r8 = r17
                r10 = r19
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.ChooseCaptureMethod.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart, java.util.List, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.IdConfig, boolean, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ ChooseCaptureMethod m(ChooseCaptureMethod chooseCaptureMethod, IdPart.SideIdPart sideIdPart, List list, List list2, int i10, IdConfig idConfig, boolean z10, GovernmentIdState governmentIdState, String str, int i11, Object obj) {
            ChooseCaptureMethod chooseCaptureMethod2 = chooseCaptureMethod;
            int i12 = i11;
            return chooseCaptureMethod.l((i12 & 1) != 0 ? chooseCaptureMethod.o() : sideIdPart, (i12 & 2) != 0 ? chooseCaptureMethod.j() : list, (i12 & 4) != 0 ? chooseCaptureMethod.i() : list2, (i12 & 8) != 0 ? chooseCaptureMethod.h() : i10, (i12 & 16) != 0 ? chooseCaptureMethod2.f25387f : idConfig, (i12 & 32) != 0 ? chooseCaptureMethod2.f25388g : z10, (i12 & 64) != 0 ? chooseCaptureMethod.f() : governmentIdState, (i12 & 128) != 0 ? chooseCaptureMethod2.f25390j : str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChooseCaptureMethod)) {
                return false;
            }
            ChooseCaptureMethod chooseCaptureMethod = (ChooseCaptureMethod) obj;
            return j.b(o(), chooseCaptureMethod.o()) && j.b(j(), chooseCaptureMethod.j()) && j.b(i(), chooseCaptureMethod.i()) && h() == chooseCaptureMethod.h() && j.b(this.f25387f, chooseCaptureMethod.f25387f) && this.f25388g == chooseCaptureMethod.f25388g && j.b(f(), chooseCaptureMethod.f()) && j.b(this.f25390j, chooseCaptureMethod.f25390j);
        }

        public GovernmentIdState f() {
            return this.f25389h;
        }

        public final String getError() {
            return this.f25390j;
        }

        public int h() {
            return this.f25386e;
        }

        public int hashCode() {
            int hashCode = ((((((((o().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + this.f25387f.hashCode()) * 31;
            boolean z10 = this.f25388g;
            if (z10) {
                z10 = true;
            }
            int i10 = 0;
            int hashCode2 = (((hashCode + (z10 ? 1 : 0)) * 31) + (f() == null ? 0 : f().hashCode())) * 31;
            String str = this.f25390j;
            if (str != null) {
                i10 = str.hashCode();
            }
            return hashCode2 + i10;
        }

        public List<IdPart> i() {
            return this.f25385d;
        }

        public List<GovernmentId> j() {
            return this.f25384c;
        }

        public final ChooseCaptureMethod l(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, IdConfig idConfig, boolean z10, GovernmentIdState governmentIdState, String str) {
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(idConfig, "id");
            return new ChooseCaptureMethod(sideIdPart, list, list2, i10, idConfig, z10, governmentIdState, str);
        }

        public final boolean n() {
            return this.f25388g;
        }

        public IdPart.SideIdPart o() {
            return this.f25383b;
        }

        public final IdConfig p() {
            return this.f25387f;
        }

        public String toString() {
            return "ChooseCaptureMethod(currentPart=" + o() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", id=" + this.f25387f + ", choosingDocumentToUpload=" + this.f25388g + ", backState=" + f() + ", error=" + this.f25390j + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25383b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25384c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25385d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25386e);
            this.f25387f.writeToParcel(parcel, i10);
            parcel.writeInt(this.f25388g ? 1 : 0);
            parcel.writeParcelable(this.f25389h, i10);
            parcel.writeString(this.f25390j);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChooseCaptureMethod(IdPart.SideIdPart sideIdPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, IdConfig idConfig, boolean z10, GovernmentIdState governmentIdState, String str) {
            super((DefaultConstructorMarker) null);
            j.g(sideIdPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(idConfig, "id");
            this.f25383b = sideIdPart;
            this.f25384c = list;
            this.f25385d = list2;
            this.f25386e = i10;
            this.f25387f = idConfig;
            this.f25388g = z10;
            this.f25389h = governmentIdState;
            this.f25390j = str;
        }
    }

    public static final class MrzScan extends GovernmentIdState implements b {
        public static final Parcelable.Creator<MrzScan> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.PassportNfcPart f25409b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25410c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25411d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25412e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25413f;

        /* renamed from: g  reason: collision with root package name */
        private final IdConfig f25414g;

        /* renamed from: h  reason: collision with root package name */
        private final GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture f25415h;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f25416j;

        public static final class a implements Parcelable.Creator<MrzScan> {
            /* renamed from: a */
            public final MrzScan createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.PassportNfcPart createFromParcel = IdPart.PassportNfcPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(MrzScan.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(MrzScan.class.getClassLoader()));
                }
                return new MrzScan(createFromParcel, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(MrzScan.class.getClassLoader()), IdConfig.CREATOR.createFromParcel(parcel), GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.valueOf(parcel.readString()), parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final MrzScan[] newArray(int i10) {
                return new MrzScan[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MrzScan(com.withpersona.sdk2.inquiry.governmentid.IdPart.PassportNfcPart r12, java.util.List r13, java.util.List r14, int r15, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r16, com.withpersona.sdk2.inquiry.governmentid.IdConfig r17, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r11 = this;
                r0 = r20
                r1 = r0 & 2
                if (r1 == 0) goto L_0x000c
                java.util.List r1 = kotlin.collections.q.j()
                r4 = r1
                goto L_0x000d
            L_0x000c:
                r4 = r13
            L_0x000d:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x0014
                r1 = 0
                r7 = r1
                goto L_0x0016
            L_0x0014:
                r7 = r16
            L_0x0016:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x001e
                com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture r1 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Hidden
                r9 = r1
                goto L_0x0020
            L_0x001e:
                r9 = r18
            L_0x0020:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0027
                r0 = 1
                r10 = r0
                goto L_0x0029
            L_0x0027:
                r10 = r19
            L_0x0029:
                r2 = r11
                r3 = r12
                r5 = r14
                r6 = r15
                r8 = r17
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.MrzScan.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart, java.util.List, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, com.withpersona.sdk2.inquiry.governmentid.IdConfig, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ MrzScan m(MrzScan mrzScan, IdPart.PassportNfcPart passportNfcPart, List list, List list2, int i10, GovernmentIdState governmentIdState, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, boolean z10, int i11, Object obj) {
            MrzScan mrzScan2 = mrzScan;
            int i12 = i11;
            return mrzScan.l((i12 & 1) != 0 ? mrzScan.o() : passportNfcPart, (i12 & 2) != 0 ? mrzScan.j() : list, (i12 & 4) != 0 ? mrzScan.i() : list2, (i12 & 8) != 0 ? mrzScan.h() : i10, (i12 & 16) != 0 ? mrzScan.f() : governmentIdState, (i12 & 32) != 0 ? mrzScan2.f25414g : idConfig, (i12 & 64) != 0 ? mrzScan2.f25415h : manualCapture, (i12 & 128) != 0 ? mrzScan.n() : z10);
        }

        public GovernmentIdState c(boolean z10) {
            return m(this, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (IdConfig) null, (GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture) null, z10, Opcodes.LAND, (Object) null);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MrzScan)) {
                return false;
            }
            MrzScan mrzScan = (MrzScan) obj;
            return j.b(o(), mrzScan.o()) && j.b(j(), mrzScan.j()) && j.b(i(), mrzScan.i()) && h() == mrzScan.h() && j.b(f(), mrzScan.f()) && j.b(this.f25414g, mrzScan.f25414g) && this.f25415h == mrzScan.f25415h && n() == mrzScan.n();
        }

        public GovernmentIdState f() {
            return this.f25413f;
        }

        public int h() {
            return this.f25412e;
        }

        public int hashCode() {
            int hashCode = ((((((((((((o().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25414g.hashCode()) * 31) + this.f25415h.hashCode()) * 31;
            boolean n10 = n();
            if (n10) {
                n10 = true;
            }
            return hashCode + (n10 ? 1 : 0);
        }

        public List<IdPart> i() {
            return this.f25411d;
        }

        public List<GovernmentId> j() {
            return this.f25410c;
        }

        public final MrzScan l(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, boolean z10) {
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            IdConfig idConfig2 = idConfig;
            j.g(idConfig2, "selectedId");
            GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture2 = manualCapture;
            j.g(manualCapture2, "manualCapture");
            return new MrzScan(passportNfcPart, list, list2, i10, governmentIdState, idConfig2, manualCapture2, z10);
        }

        public boolean n() {
            return this.f25416j;
        }

        public IdPart.PassportNfcPart o() {
            return this.f25409b;
        }

        public final GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture p() {
            return this.f25415h;
        }

        public final IdConfig q() {
            return this.f25414g;
        }

        public String toString() {
            return "MrzScan(currentPart=" + o() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", selectedId=" + this.f25414g + ", manualCapture=" + this.f25415h + ", checkCameraPermissions=" + n() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25409b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25410c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25411d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25412e);
            parcel.writeParcelable(this.f25413f, i10);
            this.f25414g.writeToParcel(parcel, i10);
            parcel.writeString(this.f25415h.name());
            parcel.writeInt(this.f25416j ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MrzScan(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, IdConfig idConfig, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture manualCapture, boolean z10) {
            super((DefaultConstructorMarker) null);
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(idConfig, "selectedId");
            j.g(manualCapture, "manualCapture");
            this.f25409b = passportNfcPart;
            this.f25410c = list;
            this.f25411d = list2;
            this.f25412e = i10;
            this.f25413f = governmentIdState;
            this.f25414g = idConfig;
            this.f25415h = manualCapture;
            this.f25416j = z10;
        }
    }

    public static final class PassportNfcError extends GovernmentIdState {
        public static final Parcelable.Creator<PassportNfcError> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart f25426b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25427c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25428d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25429e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25430f;

        /* renamed from: g  reason: collision with root package name */
        private final PassportNfcErrorPage f25431g;

        public static final class a implements Parcelable.Creator<PassportNfcError> {
            /* renamed from: a */
            public final PassportNfcError createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart idPart = (IdPart) parcel.readParcelable(PassportNfcError.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(PassportNfcError.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcError.class.getClassLoader()));
                }
                return new PassportNfcError(idPart, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(PassportNfcError.class.getClassLoader()), (PassportNfcErrorPage) parcel.readParcelable(PassportNfcError.class.getClassLoader()));
            }

            /* renamed from: b */
            public final PassportNfcError[] newArray(int i10) {
                return new PassportNfcError[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PassportNfcError(IdPart idPart, List list, List list2, int i10, GovernmentIdState governmentIdState, PassportNfcErrorPage passportNfcErrorPage, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new IdPart.SideIdPart(IdConfig.Side.Front) : idPart, (i11 & 2) != 0 ? q.j() : list, list2, i10, (i11 & 16) != 0 ? null : governmentIdState, passportNfcErrorPage);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PassportNfcError)) {
                return false;
            }
            PassportNfcError passportNfcError = (PassportNfcError) obj;
            return j.b(l(), passportNfcError.l()) && j.b(j(), passportNfcError.j()) && j.b(i(), passportNfcError.i()) && h() == passportNfcError.h() && j.b(f(), passportNfcError.f()) && j.b(this.f25431g, passportNfcError.f25431g);
        }

        public GovernmentIdState f() {
            return this.f25430f;
        }

        public int h() {
            return this.f25429e;
        }

        public int hashCode() {
            return (((((((((l().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25431g.hashCode();
        }

        public List<IdPart> i() {
            return this.f25428d;
        }

        public List<GovernmentId> j() {
            return this.f25427c;
        }

        public IdPart l() {
            return this.f25426b;
        }

        public final PassportNfcErrorPage m() {
            return this.f25431g;
        }

        public String toString() {
            return "PassportNfcError(currentPart=" + l() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", errorPage=" + this.f25431g + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f25426b, i10);
            List<GovernmentId> list = this.f25427c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25428d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25429e);
            parcel.writeParcelable(this.f25430f, i10);
            parcel.writeParcelable(this.f25431g, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PassportNfcError(IdPart idPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcErrorPage passportNfcErrorPage) {
            super((DefaultConstructorMarker) null);
            j.g(idPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(passportNfcErrorPage, "errorPage");
            this.f25426b = idPart;
            this.f25427c = list;
            this.f25428d = list2;
            this.f25429e = i10;
            this.f25430f = governmentIdState;
            this.f25431g = passportNfcErrorPage;
        }
    }

    public static final class VerifyPassportDetails extends GovernmentIdState {
        public static final Parcelable.Creator<VerifyPassportDetails> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart.PassportNfcPart f25481b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25482c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25483d;

        /* renamed from: e  reason: collision with root package name */
        private final int f25484e;

        /* renamed from: f  reason: collision with root package name */
        private final GovernmentIdState f25485f;

        /* renamed from: g  reason: collision with root package name */
        private final PassportNfcVerifyDetailsPage f25486g;

        /* renamed from: h  reason: collision with root package name */
        private final IdConfig f25487h;

        /* renamed from: j  reason: collision with root package name */
        private final PassportNfcKeys f25488j;

        /* renamed from: k  reason: collision with root package name */
        private final List<String> f25489k;

        public static final class a implements Parcelable.Creator<VerifyPassportDetails> {
            /* renamed from: a */
            public final VerifyPassportDetails createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart.PassportNfcPart createFromParcel = IdPart.PassportNfcPart.CREATOR.createFromParcel(parcel);
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(VerifyPassportDetails.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(VerifyPassportDetails.class.getClassLoader()));
                }
                return new VerifyPassportDetails(createFromParcel, arrayList, arrayList2, parcel.readInt(), (GovernmentIdState) parcel.readParcelable(VerifyPassportDetails.class.getClassLoader()), PassportNfcVerifyDetailsPage.CREATOR.createFromParcel(parcel), IdConfig.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : PassportNfcKeys.CREATOR.createFromParcel(parcel), parcel.createStringArrayList());
            }

            /* renamed from: b */
            public final VerifyPassportDetails[] newArray(int i10) {
                return new VerifyPassportDetails[i10];
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ VerifyPassportDetails(com.withpersona.sdk2.inquiry.governmentid.IdPart.PassportNfcPart r13, java.util.List r14, java.util.List r15, int r16, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r17, com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage r18, com.withpersona.sdk2.inquiry.governmentid.IdConfig r19, com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys r20, java.util.List r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r12 = this;
                r0 = r22
                r1 = r0 & 2
                if (r1 == 0) goto L_0x000c
                java.util.List r1 = kotlin.collections.q.j()
                r4 = r1
                goto L_0x000d
            L_0x000c:
                r4 = r14
            L_0x000d:
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L_0x0014
                r7 = r2
                goto L_0x0016
            L_0x0014:
                r7 = r17
            L_0x0016:
                r1 = r0 & 128(0x80, float:1.794E-43)
                if (r1 == 0) goto L_0x001c
                r10 = r2
                goto L_0x001e
            L_0x001c:
                r10 = r20
            L_0x001e:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L_0x0028
                java.util.List r0 = kotlin.collections.q.j()
                r11 = r0
                goto L_0x002a
            L_0x0028:
                r11 = r21
            L_0x002a:
                r2 = r12
                r3 = r13
                r5 = r15
                r6 = r16
                r8 = r18
                r9 = r19
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.VerifyPassportDetails.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart, java.util.List, java.util.List, int, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage, com.withpersona.sdk2.inquiry.governmentid.IdConfig, com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ VerifyPassportDetails m(VerifyPassportDetails verifyPassportDetails, IdPart.PassportNfcPart passportNfcPart, List list, List list2, int i10, GovernmentIdState governmentIdState, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, IdConfig idConfig, PassportNfcKeys passportNfcKeys, List list3, int i11, Object obj) {
            VerifyPassportDetails verifyPassportDetails2 = verifyPassportDetails;
            int i12 = i11;
            return verifyPassportDetails.l((i12 & 1) != 0 ? verifyPassportDetails.o() : passportNfcPart, (i12 & 2) != 0 ? verifyPassportDetails.j() : list, (i12 & 4) != 0 ? verifyPassportDetails.i() : list2, (i12 & 8) != 0 ? verifyPassportDetails.h() : i10, (i12 & 16) != 0 ? verifyPassportDetails.f() : governmentIdState, (i12 & 32) != 0 ? verifyPassportDetails2.f25486g : passportNfcVerifyDetailsPage, (i12 & 64) != 0 ? verifyPassportDetails2.f25487h : idConfig, (i12 & 128) != 0 ? verifyPassportDetails2.f25488j : passportNfcKeys, (i12 & 256) != 0 ? verifyPassportDetails2.f25489k : list3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerifyPassportDetails)) {
                return false;
            }
            VerifyPassportDetails verifyPassportDetails = (VerifyPassportDetails) obj;
            return j.b(o(), verifyPassportDetails.o()) && j.b(j(), verifyPassportDetails.j()) && j.b(i(), verifyPassportDetails.i()) && h() == verifyPassportDetails.h() && j.b(f(), verifyPassportDetails.f()) && j.b(this.f25486g, verifyPassportDetails.f25486g) && j.b(this.f25487h, verifyPassportDetails.f25487h) && j.b(this.f25488j, verifyPassportDetails.f25488j) && j.b(this.f25489k, verifyPassportDetails.f25489k);
        }

        public GovernmentIdState f() {
            return this.f25485f;
        }

        public int h() {
            return this.f25484e;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((((((o().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + Integer.hashCode(h())) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + this.f25486g.hashCode()) * 31) + this.f25487h.hashCode()) * 31;
            PassportNfcKeys passportNfcKeys = this.f25488j;
            if (passportNfcKeys != null) {
                i10 = passportNfcKeys.hashCode();
            }
            return ((hashCode + i10) * 31) + this.f25489k.hashCode();
        }

        public List<IdPart> i() {
            return this.f25483d;
        }

        public List<GovernmentId> j() {
            return this.f25482c;
        }

        public final VerifyPassportDetails l(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, IdConfig idConfig, PassportNfcKeys passportNfcKeys, List<String> list3) {
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage2 = passportNfcVerifyDetailsPage;
            j.g(passportNfcVerifyDetailsPage2, "passportNfcVerifyDetailsPage");
            IdConfig idConfig2 = idConfig;
            j.g(idConfig2, "selectedId");
            List<String> list4 = list3;
            j.g(list4, "componentsWithErrors");
            return new VerifyPassportDetails(passportNfcPart, list, list2, i10, governmentIdState, passportNfcVerifyDetailsPage2, idConfig2, passportNfcKeys, list4);
        }

        public final List<String> n() {
            return this.f25489k;
        }

        public IdPart.PassportNfcPart o() {
            return this.f25481b;
        }

        public final PassportNfcKeys p() {
            return this.f25488j;
        }

        public final PassportNfcVerifyDetailsPage q() {
            return this.f25486g;
        }

        public final IdConfig r() {
            return this.f25487h;
        }

        public String toString() {
            return "VerifyPassportDetails(currentPart=" + o() + ", uploadingIds=" + j() + ", parts=" + i() + ", partIndex=" + h() + ", backState=" + f() + ", passportNfcVerifyDetailsPage=" + this.f25486g + ", selectedId=" + this.f25487h + ", passportNfcKeys=" + this.f25488j + ", componentsWithErrors=" + this.f25489k + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            this.f25481b.writeToParcel(parcel, i10);
            List<GovernmentId> list = this.f25482c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25483d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeInt(this.f25484e);
            parcel.writeParcelable(this.f25485f, i10);
            this.f25486g.writeToParcel(parcel, i10);
            this.f25487h.writeToParcel(parcel, i10);
            PassportNfcKeys passportNfcKeys = this.f25488j;
            if (passportNfcKeys == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                passportNfcKeys.writeToParcel(parcel, i10);
            }
            parcel.writeStringList(this.f25489k);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VerifyPassportDetails(IdPart.PassportNfcPart passportNfcPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, int i10, GovernmentIdState governmentIdState, PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, IdConfig idConfig, PassportNfcKeys passportNfcKeys, List<String> list3) {
            super((DefaultConstructorMarker) null);
            j.g(passportNfcPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            j.g(passportNfcVerifyDetailsPage, "passportNfcVerifyDetailsPage");
            j.g(idConfig, "selectedId");
            j.g(list3, "componentsWithErrors");
            this.f25481b = passportNfcPart;
            this.f25482c = list;
            this.f25483d = list2;
            this.f25484e = i10;
            this.f25485f = governmentIdState;
            this.f25486g = passportNfcVerifyDetailsPage;
            this.f25487h = idConfig;
            this.f25488j = passportNfcKeys;
            this.f25489k = list3;
        }
    }

    public static final class ShowInstructions extends GovernmentIdState {
        public static final Parcelable.Creator<ShowInstructions> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        private final IdPart f25465b;

        /* renamed from: c  reason: collision with root package name */
        private final List<GovernmentId> f25466c;

        /* renamed from: d  reason: collision with root package name */
        private final List<IdPart> f25467d;

        /* renamed from: e  reason: collision with root package name */
        private final GovernmentIdState f25468e;

        /* renamed from: f  reason: collision with root package name */
        private final int f25469f;

        /* renamed from: g  reason: collision with root package name */
        private final IdConfig f25470g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f25471h;

        /* renamed from: j  reason: collision with root package name */
        private final String f25472j;

        public static final class a implements Parcelable.Creator<ShowInstructions> {
            /* renamed from: a */
            public final ShowInstructions createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                IdPart idPart = (IdPart) parcel.readParcelable(ShowInstructions.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(ShowInstructions.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList2.add(parcel.readParcelable(ShowInstructions.class.getClassLoader()));
                }
                return new ShowInstructions(idPart, arrayList, arrayList2, (GovernmentIdState) parcel.readParcelable(ShowInstructions.class.getClassLoader()), parcel.readInt(), parcel.readInt() == 0 ? null : IdConfig.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readString());
            }

            /* renamed from: b */
            public final ShowInstructions[] newArray(int i10) {
                return new ShowInstructions[i10];
            }
        }

        public ShowInstructions() {
            this((IdPart) null, (List) null, (List) null, (GovernmentIdState) null, 0, (IdConfig) null, false, (String) null, 255, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ShowInstructions(com.withpersona.sdk2.inquiry.governmentid.IdPart r10, java.util.List r11, java.util.List r12, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r13, int r14, com.withpersona.sdk2.inquiry.governmentid.IdConfig r15, boolean r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
            /*
                r9 = this;
                r0 = r18
                r1 = r0 & 1
                if (r1 == 0) goto L_0x000e
                com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r1 = new com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r2 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front
                r1.<init>(r2)
                goto L_0x000f
            L_0x000e:
                r1 = r10
            L_0x000f:
                r2 = r0 & 2
                if (r2 == 0) goto L_0x0018
                java.util.List r2 = kotlin.collections.q.j()
                goto L_0x0019
            L_0x0018:
                r2 = r11
            L_0x0019:
                r3 = r0 & 4
                if (r3 == 0) goto L_0x0022
                java.util.List r3 = kotlin.collections.q.j()
                goto L_0x0023
            L_0x0022:
                r3 = r12
            L_0x0023:
                r4 = r0 & 8
                r5 = 0
                if (r4 == 0) goto L_0x002a
                r4 = r5
                goto L_0x002b
            L_0x002a:
                r4 = r13
            L_0x002b:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0031
                r6 = -1
                goto L_0x0032
            L_0x0031:
                r6 = r14
            L_0x0032:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0038
                r7 = r5
                goto L_0x0039
            L_0x0038:
                r7 = r15
            L_0x0039:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x003f
                r8 = 0
                goto L_0x0041
            L_0x003f:
                r8 = r16
            L_0x0041:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0046
                goto L_0x0048
            L_0x0046:
                r5 = r17
            L_0x0048:
                r10 = r9
                r11 = r1
                r12 = r2
                r13 = r3
                r14 = r4
                r15 = r6
                r16 = r7
                r17 = r8
                r18 = r5
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.ShowInstructions.<init>(com.withpersona.sdk2.inquiry.governmentid.IdPart, java.util.List, java.util.List, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, int, com.withpersona.sdk2.inquiry.governmentid.IdConfig, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ ShowInstructions m(ShowInstructions showInstructions, IdPart idPart, List list, List list2, GovernmentIdState governmentIdState, int i10, IdConfig idConfig, boolean z10, String str, int i11, Object obj) {
            ShowInstructions showInstructions2 = showInstructions;
            int i12 = i11;
            return showInstructions.l((i12 & 1) != 0 ? showInstructions.n() : idPart, (i12 & 2) != 0 ? showInstructions.j() : list, (i12 & 4) != 0 ? showInstructions.i() : list2, (i12 & 8) != 0 ? showInstructions.f() : governmentIdState, (i12 & 16) != 0 ? showInstructions.h() : i10, (i12 & 32) != 0 ? showInstructions2.f25470g : idConfig, (i12 & 64) != 0 ? showInstructions2.f25471h : z10, (i12 & 128) != 0 ? showInstructions2.f25472j : str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowInstructions)) {
                return false;
            }
            ShowInstructions showInstructions = (ShowInstructions) obj;
            return j.b(n(), showInstructions.n()) && j.b(j(), showInstructions.j()) && j.b(i(), showInstructions.i()) && j.b(f(), showInstructions.f()) && h() == showInstructions.h() && j.b(this.f25470g, showInstructions.f25470g) && this.f25471h == showInstructions.f25471h && j.b(this.f25472j, showInstructions.f25472j);
        }

        public GovernmentIdState f() {
            return this.f25468e;
        }

        public final String getError() {
            return this.f25472j;
        }

        public int h() {
            return this.f25469f;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((((((((n().hashCode() * 31) + j().hashCode()) * 31) + i().hashCode()) * 31) + (f() == null ? 0 : f().hashCode())) * 31) + Integer.hashCode(h())) * 31;
            IdConfig idConfig = this.f25470g;
            int hashCode2 = (hashCode + (idConfig == null ? 0 : idConfig.hashCode())) * 31;
            boolean z10 = this.f25471h;
            if (z10) {
                z10 = true;
            }
            int i11 = (hashCode2 + (z10 ? 1 : 0)) * 31;
            String str = this.f25472j;
            if (str != null) {
                i10 = str.hashCode();
            }
            return i11 + i10;
        }

        public List<IdPart> i() {
            return this.f25467d;
        }

        public List<GovernmentId> j() {
            return this.f25466c;
        }

        public final ShowInstructions l(IdPart idPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, GovernmentIdState governmentIdState, int i10, IdConfig idConfig, boolean z10, String str) {
            j.g(idPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            return new ShowInstructions(idPart, list, list2, governmentIdState, i10, idConfig, z10, str);
        }

        public IdPart n() {
            return this.f25465b;
        }

        public final IdConfig o() {
            return this.f25470g;
        }

        public final boolean p() {
            return this.f25471h;
        }

        public String toString() {
            return "ShowInstructions(currentPart=" + n() + ", uploadingIds=" + j() + ", parts=" + i() + ", backState=" + f() + ", partIndex=" + h() + ", selectedId=" + this.f25470g + ", showPassportNfcPrompt=" + this.f25471h + ", error=" + this.f25472j + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f25465b, i10);
            List<GovernmentId> list = this.f25466c;
            parcel.writeInt(list.size());
            for (GovernmentId writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
            List<IdPart> list2 = this.f25467d;
            parcel.writeInt(list2.size());
            for (IdPart writeParcelable2 : list2) {
                parcel.writeParcelable(writeParcelable2, i10);
            }
            parcel.writeParcelable(this.f25468e, i10);
            parcel.writeInt(this.f25469f);
            IdConfig idConfig = this.f25470g;
            if (idConfig == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                idConfig.writeToParcel(parcel, i10);
            }
            parcel.writeInt(this.f25471h ? 1 : 0);
            parcel.writeString(this.f25472j);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowInstructions(IdPart idPart, List<? extends GovernmentId> list, List<? extends IdPart> list2, GovernmentIdState governmentIdState, int i10, IdConfig idConfig, boolean z10, String str) {
            super((DefaultConstructorMarker) null);
            j.g(idPart, "currentPart");
            j.g(list, "uploadingIds");
            j.g(list2, "parts");
            this.f25465b = idPart;
            this.f25466c = list;
            this.f25467d = list2;
            this.f25468e = governmentIdState;
            this.f25469f = i10;
            this.f25470g = idConfig;
            this.f25471h = z10;
            this.f25472j = str;
        }
    }
}
