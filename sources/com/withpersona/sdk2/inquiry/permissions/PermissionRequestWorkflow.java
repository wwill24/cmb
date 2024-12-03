package com.withpersona.sdk2.inquiry.permissions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.squareup.workflow1.o;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorker;
import com.withpersona.sdk2.inquiry.shared.ui.ScreenTransition;
import com.withpersona.sdk2.inquiry.shared.ui.e;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.ByteString;
import org.apache.commons.beanutils.PropertyUtils;

public final class PermissionRequestWorkflow extends h<c, PermissionRequestState, b, Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f27118c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f27119a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionRequestWorker.a f27120b;

    public static abstract class PermissionRequestState implements Parcelable {

        public static final class CheckPermissionPermanentlyDenied extends PermissionRequestState {
            public static final Parcelable.Creator<CheckPermissionPermanentlyDenied> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final CheckPermissionPermanentlyDenied f27121a = new CheckPermissionPermanentlyDenied();

            public static final class a implements Parcelable.Creator<CheckPermissionPermanentlyDenied> {
                /* renamed from: a */
                public final CheckPermissionPermanentlyDenied createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return CheckPermissionPermanentlyDenied.f27121a;
                }

                /* renamed from: b */
                public final CheckPermissionPermanentlyDenied[] newArray(int i10) {
                    return new CheckPermissionPermanentlyDenied[i10];
                }
            }

            private CheckPermissionPermanentlyDenied() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class CheckPermissionRationaleState extends PermissionRequestState {
            public static final Parcelable.Creator<CheckPermissionRationaleState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final CheckPermissionRationaleState f27122a = new CheckPermissionRationaleState();

            public static final class a implements Parcelable.Creator<CheckPermissionRationaleState> {
                /* renamed from: a */
                public final CheckPermissionRationaleState createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return CheckPermissionRationaleState.f27122a;
                }

                /* renamed from: b */
                public final CheckPermissionRationaleState[] newArray(int i10) {
                    return new CheckPermissionRationaleState[i10];
                }
            }

            private CheckPermissionRationaleState() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class CheckPermissionState extends PermissionRequestState {
            public static final Parcelable.Creator<CheckPermissionState> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final CheckPermissionState f27123a = new CheckPermissionState();

            public static final class a implements Parcelable.Creator<CheckPermissionState> {
                /* renamed from: a */
                public final CheckPermissionState createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return CheckPermissionState.f27123a;
                }

                /* renamed from: b */
                public final CheckPermissionState[] newArray(int i10) {
                    return new CheckPermissionState[i10];
                }
            }

            private CheckPermissionState() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class Complete extends PermissionRequestState {
            public static final Parcelable.Creator<Complete> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final Complete f27124a = new Complete();

            public static final class a implements Parcelable.Creator<Complete> {
                /* renamed from: a */
                public final Complete createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return Complete.f27124a;
                }

                /* renamed from: b */
                public final Complete[] newArray(int i10) {
                    return new Complete[i10];
                }
            }

            private Complete() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class RequestPermission extends PermissionRequestState {
            public static final Parcelable.Creator<RequestPermission> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final RequestPermission f27125a = new RequestPermission();

            public static final class a implements Parcelable.Creator<RequestPermission> {
                /* renamed from: a */
                public final RequestPermission createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return RequestPermission.f27125a;
                }

                /* renamed from: b */
                public final RequestPermission[] newArray(int i10) {
                    return new RequestPermission[i10];
                }
            }

            private RequestPermission() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class ShowPermissionPermanentlyDeniedMessage extends PermissionRequestState {
            public static final Parcelable.Creator<ShowPermissionPermanentlyDeniedMessage> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final ShowPermissionPermanentlyDeniedMessage f27126a = new ShowPermissionPermanentlyDeniedMessage();

            public static final class a implements Parcelable.Creator<ShowPermissionPermanentlyDeniedMessage> {
                /* renamed from: a */
                public final ShowPermissionPermanentlyDeniedMessage createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return ShowPermissionPermanentlyDeniedMessage.f27126a;
                }

                /* renamed from: b */
                public final ShowPermissionPermanentlyDeniedMessage[] newArray(int i10) {
                    return new ShowPermissionPermanentlyDeniedMessage[i10];
                }
            }

            private ShowPermissionPermanentlyDeniedMessage() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        public static final class ShowRequestPermissionRationale extends PermissionRequestState {
            public static final Parcelable.Creator<ShowRequestPermissionRationale> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final ShowRequestPermissionRationale f27127a = new ShowRequestPermissionRationale();

            public static final class a implements Parcelable.Creator<ShowRequestPermissionRationale> {
                /* renamed from: a */
                public final ShowRequestPermissionRationale createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return ShowRequestPermissionRationale.f27127a;
                }

                /* renamed from: b */
                public final ShowRequestPermissionRationale[] newArray(int i10) {
                    return new ShowRequestPermissionRationale[i10];
                }
            }

            private ShowRequestPermissionRationale() {
                super((DefaultConstructorMarker) null);
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        private PermissionRequestState() {
        }

        public /* synthetic */ PermissionRequestState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final PermissionState f27128a;

        public b(PermissionState permissionState) {
            j.g(permissionState, "permissionState");
            this.f27128a = permissionState;
        }

        public final PermissionState a() {
            return this.f27128a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && j.b(this.f27128a, ((b) obj).f27128a);
        }

        public int hashCode() {
            return this.f27128a.hashCode();
        }

        public String toString() {
            return "Output(permissionState=" + this.f27128a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Permission f27129a;

        /* renamed from: b  reason: collision with root package name */
        private final String f27130b;

        /* renamed from: c  reason: collision with root package name */
        private final String f27131c;

        /* renamed from: d  reason: collision with root package name */
        private final String f27132d;

        /* renamed from: e  reason: collision with root package name */
        private final String f27133e;

        /* renamed from: f  reason: collision with root package name */
        private final String f27134f;

        /* renamed from: g  reason: collision with root package name */
        private final StepStyle f27135g;

        public c(Permission permission, String str, String str2, String str3, String str4, String str5, StepStyle stepStyle) {
            j.g(permission, "permission");
            j.g(str, "title");
            j.g(str2, "rationale");
            j.g(str3, "rationaleWhenPermanentlyDenied");
            this.f27129a = permission;
            this.f27130b = str;
            this.f27131c = str2;
            this.f27132d = str3;
            this.f27133e = str4;
            this.f27134f = str5;
            this.f27135g = stepStyle;
        }

        public final String a() {
            return this.f27134f;
        }

        public final Permission b() {
            return this.f27129a;
        }

        public final String c() {
            return this.f27133e;
        }

        public final String d() {
            return this.f27131c;
        }

        public final String e() {
            return this.f27132d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f27129a == cVar.f27129a && j.b(this.f27130b, cVar.f27130b) && j.b(this.f27131c, cVar.f27131c) && j.b(this.f27132d, cVar.f27132d) && j.b(this.f27133e, cVar.f27133e) && j.b(this.f27134f, cVar.f27134f) && j.b(this.f27135g, cVar.f27135g);
        }

        public final StepStyle f() {
            return this.f27135g;
        }

        public final String g() {
            return this.f27130b;
        }

        public int hashCode() {
            int hashCode = ((((((this.f27129a.hashCode() * 31) + this.f27130b.hashCode()) * 31) + this.f27131c.hashCode()) * 31) + this.f27132d.hashCode()) * 31;
            String str = this.f27133e;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f27134f;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            StepStyle stepStyle = this.f27135g;
            if (stepStyle != null) {
                i10 = stepStyle.hashCode();
            }
            return hashCode3 + i10;
        }

        public String toString() {
            return "Props(permission=" + this.f27129a + ", title=" + this.f27130b + ", rationale=" + this.f27131c + ", rationaleWhenPermanentlyDenied=" + this.f27132d + ", positiveButtonText=" + this.f27133e + ", negativeButtonText=" + this.f27134f + ", styles=" + this.f27135g + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public PermissionRequestWorkflow(Context context, PermissionRequestWorker.a aVar) {
        j.g(context, "applicationContext");
        j.g(aVar, "permissionRequestWorkerFactory");
        this.f27119a = context;
        this.f27120b = aVar;
    }

    /* access modifiers changed from: private */
    public final void k(l<? super c, PermissionRequestState, b>.c cVar, PermissionState permissionState) {
        cVar.d(new b(permissionState));
        cVar.e(PermissionRequestState.Complete.f27124a);
    }

    /* access modifiers changed from: private */
    public final void m() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addFlags(268435456);
        intent.setData(Uri.fromParts("package", this.f27119a.getPackageName(), (String) null));
        this.f27119a.startActivity(intent);
    }

    /* renamed from: l */
    public PermissionRequestState d(c cVar, Snapshot snapshot) {
        boolean z10;
        j.g(cVar, "props");
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
            PermissionRequestState permissionRequestState = (PermissionRequestState) parcelable;
            if (permissionRequestState != null) {
                return permissionRequestState;
            }
        }
        return PermissionRequestState.CheckPermissionState.f27123a;
    }

    /* renamed from: n */
    public Object f(c cVar, PermissionRequestState permissionRequestState, h<? super c, PermissionRequestState, b, ? extends Object>.defpackage.a aVar) {
        j.g(cVar, "renderProps");
        j.g(permissionRequestState, "renderState");
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        if (j.b(permissionRequestState, PermissionRequestState.CheckPermissionState.f27123a)) {
            aVar.a("check_permission_state", new PermissionRequestWorkflow$render$1(this, cVar, aVar, (kotlin.coroutines.c<? super PermissionRequestWorkflow$render$1>) null));
            return null;
        } else if (j.b(permissionRequestState, PermissionRequestState.CheckPermissionRationaleState.f27122a)) {
            return new e(new CheckRequestPermissionRationaleStateView(cVar.b(), new PermissionRequestWorkflow$render$2(aVar, this)), ScreenTransition.NONE);
        } else {
            if (j.b(permissionRequestState, PermissionRequestState.ShowRequestPermissionRationale.f27127a)) {
                String g10 = cVar.g();
                String d10 = cVar.d();
                String c10 = cVar.c();
                if (c10 == null) {
                    c10 = this.f27119a.getString(e.pi2_permissions_continue);
                    j.f(c10, "applicationContext.getSt…pi2_permissions_continue)");
                }
                String str = c10;
                StepStyle f10 = cVar.f();
                PermissionRequestWorkflow$render$3 permissionRequestWorkflow$render$3 = new PermissionRequestWorkflow$render$3(aVar, this);
                String a10 = cVar.a();
                if (a10 == null) {
                    a10 = this.f27119a.getString(e.pi2_permissions_cancel);
                    j.f(a10, "applicationContext.getSt…g.pi2_permissions_cancel)");
                }
                return new e(new BottomSheetDialogView(g10, d10, str, f10, permissionRequestWorkflow$render$3, a10, new PermissionRequestWorkflow$render$4(aVar, this, cVar)), ScreenTransition.NONE);
            } else if (j.b(permissionRequestState, PermissionRequestState.RequestPermission.f27125a)) {
                o.l(aVar, this.f27120b.a(cVar.b()), kotlin.jvm.internal.l.k(PermissionRequestWorker.class), "", new PermissionRequestWorkflow$render$5(this, cVar, aVar));
                return null;
            } else if (j.b(permissionRequestState, PermissionRequestState.CheckPermissionPermanentlyDenied.f27121a)) {
                return new e(new CheckRequestPermissionRationaleStateView(cVar.b(), new PermissionRequestWorkflow$render$6(aVar, this, cVar)), ScreenTransition.NONE);
            } else {
                if (j.b(permissionRequestState, PermissionRequestState.ShowPermissionPermanentlyDeniedMessage.f27126a)) {
                    String g11 = cVar.g();
                    String e10 = cVar.e();
                    String c11 = cVar.c();
                    if (c11 == null) {
                        c11 = this.f27119a.getString(e.pi2_permissions_settings);
                        j.f(c11, "applicationContext.getSt…pi2_permissions_settings)");
                    }
                    String str2 = c11;
                    StepStyle f11 = cVar.f();
                    PermissionRequestWorkflow$render$7 permissionRequestWorkflow$render$7 = new PermissionRequestWorkflow$render$7(this, aVar, cVar);
                    String a11 = cVar.a();
                    if (a11 == null) {
                        a11 = this.f27119a.getString(e.pi2_permissions_cancel);
                        j.f(a11, "applicationContext.getSt…g.pi2_permissions_cancel)");
                    }
                    return new e(new BottomSheetDialogView(g11, e10, str2, f11, permissionRequestWorkflow$render$7, a11, new PermissionRequestWorkflow$render$8(aVar, this, cVar)), ScreenTransition.NONE);
                } else if (j.b(permissionRequestState, PermissionRequestState.Complete.f27124a)) {
                    return null;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    /* renamed from: o */
    public Snapshot g(PermissionRequestState permissionRequestState) {
        j.g(permissionRequestState, "state");
        return SnapshotParcelsKt.a(permissionRequestState);
    }
}
