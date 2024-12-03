package com.squareup.workflow1.ui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0012B\u0011\b\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0019J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/squareup/workflow1/ui/ParcelableTextController;", "Lcom/squareup/workflow1/ui/k;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "describeContents", "Lkotlinx/coroutines/flow/b;", "", "a", "()Lkotlinx/coroutines/flow/b;", "onTextChanged", "c", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "textValue", "controllerImplementation", "<init>", "(Lcom/squareup/workflow1/ui/k;)V", "initialValue", "parcel", "(Landroid/os/Parcel;)V", "CREATOR", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class ParcelableTextController implements k, Parcelable {
    public static final a CREATOR = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ k f23177a;

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/ParcelableTextController$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/ParcelableTextController;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/ParcelableTextController;", "<init>", "()V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
    public static final class a implements Parcelable.Creator<ParcelableTextController> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public ParcelableTextController createFromParcel(Parcel parcel) {
            j.g(parcel, "source");
            return new ParcelableTextController(parcel, (DefaultConstructorMarker) null);
        }

        /* renamed from: b */
        public ParcelableTextController[] newArray(int i10) {
            return new ParcelableTextController[i10];
        }
    }

    public /* synthetic */ ParcelableTextController(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private ParcelableTextController(k kVar) {
        this.f23177a = kVar;
    }

    public b<String> a() {
        return this.f23177a.a();
    }

    public String c() {
        return this.f23177a.c();
    }

    public void d(String str) {
        j.g(str, "<set-?>");
        this.f23177a.d(str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(c());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ParcelableTextController(String str) {
        this(m.a(str));
        j.g(str, "initialValue");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ParcelableTextController(android.os.Parcel r1) {
        /*
            r0 = this;
            java.lang.String r1 = r1.readString()
            if (r1 != 0) goto L_0x0008
            java.lang.String r1 = ""
        L_0x0008:
            r0.<init>((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.ParcelableTextController.<init>(android.os.Parcel):void");
    }
}
