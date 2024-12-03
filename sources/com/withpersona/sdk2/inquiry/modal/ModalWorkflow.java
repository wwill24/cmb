package com.withpersona.sdk2.inquiry.modal;

import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.workflow1.Snapshot;
import com.squareup.workflow1.a;
import com.squareup.workflow1.h;
import com.squareup.workflow1.k;
import com.squareup.workflow1.ui.SnapshotParcelsKt;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyle;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okio.ByteString;

public final class ModalWorkflow<PropsT, OutputT extends Parcelable, RenderingT> extends h<PropsT, ModalState, OutputT, Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26997b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final k<PropsT, OutputT, RenderingT> f26998a;

    public static abstract class ModalState implements Parcelable {

        public static final class Running extends ModalState {
            public static final Parcelable.Creator<Running> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            public static final Running f26999a = new Running();

            public static final class a implements Parcelable.Creator<Running> {
                /* renamed from: a */
                public final Running createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return Running.f26999a;
                }

                /* renamed from: b */
                public final Running[] newArray(int i10) {
                    return new Running[i10];
                }
            }

            private Running() {
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

        public static final class ShowingModal<OutputT extends Parcelable> extends ModalState {
            public static final Parcelable.Creator<ShowingModal<?>> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final OutputT f27000a;

            /* renamed from: b  reason: collision with root package name */
            private final StepStyle f27001b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27002c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27003d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27004e;

            /* renamed from: f  reason: collision with root package name */
            private final String f27005f;

            public static final class a implements Parcelable.Creator<ShowingModal<?>> {
                /* renamed from: a */
                public final ShowingModal<?> createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new ShowingModal(parcel.readParcelable(ShowingModal.class.getClassLoader()), (StepStyle) parcel.readParcelable(ShowingModal.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final ShowingModal<?>[] newArray(int i10) {
                    return new ShowingModal[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowingModal(OutputT outputt, StepStyle stepStyle, String str, String str2, String str3, String str4) {
                super((DefaultConstructorMarker) null);
                j.g(outputt, "output");
                this.f27000a = outputt;
                this.f27001b = stepStyle;
                this.f27002c = str;
                this.f27003d = str2;
                this.f27004e = str3;
                this.f27005f = str4;
            }

            public final String a() {
                return this.f27005f;
            }

            public final String c() {
                return this.f27003d;
            }

            public final OutputT d() {
                return this.f27000a;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f27004e;
            }

            public final StepStyle f() {
                return this.f27001b;
            }

            public final String g() {
                return this.f27002c;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeParcelable(this.f27000a, i10);
                parcel.writeParcelable(this.f27001b, i10);
                parcel.writeString(this.f27002c);
                parcel.writeString(this.f27003d);
                parcel.writeString(this.f27004e);
                parcel.writeString(this.f27005f);
            }
        }

        private ModalState() {
        }

        public /* synthetic */ ModalState(DefaultConstructorMarker defaultConstructorMarker) {
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

    public ModalWorkflow(k<? super PropsT, ? extends OutputT, ? extends RenderingT> kVar) {
        j.g(kVar, "childWorkflow");
        this.f26998a = kVar;
    }

    /* renamed from: h */
    public ModalState d(PropsT propst, Snapshot snapshot) {
        boolean z10;
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
            ModalState modalState = (ModalState) parcelable;
            if (modalState != null) {
                return modalState;
            }
        }
        return ModalState.Running.f26999a;
    }

    /* renamed from: i */
    public Object f(PropsT propst, ModalState modalState, h<? super PropsT, ModalState, ? extends OutputT, ? extends Object>.defpackage.a aVar) {
        j.g(modalState, "renderState");
        j.g(aVar, IdentityHttpResponse.CONTEXT);
        Object a10 = a.C0266a.a(aVar, this.f26998a, propst, (String) null, new ModalWorkflow$render$currentScreen$1(this), 4, (Object) null);
        if (modalState instanceof ModalState.Running) {
            return new b(a10, q.j(), "CancelModal");
        }
        if (modalState instanceof ModalState.ShowingModal) {
            ModalState.ShowingModal showingModal = (ModalState.ShowingModal) modalState;
            return c.a(new CancelScreen(showingModal.f(), new ModalWorkflow$render$1(aVar, this, modalState), new ModalWorkflow$render$2(aVar, this), showingModal.g(), showingModal.c(), showingModal.e(), showingModal.a()), a10, "CancelModal");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: j */
    public Snapshot g(ModalState modalState) {
        j.g(modalState, "state");
        return SnapshotParcelsKt.a(modalState);
    }
}
