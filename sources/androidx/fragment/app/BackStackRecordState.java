package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.fragment.app.b0;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int[] f5571a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f5572b;

    /* renamed from: c  reason: collision with root package name */
    final int[] f5573c;

    /* renamed from: d  reason: collision with root package name */
    final int[] f5574d;

    /* renamed from: e  reason: collision with root package name */
    final int f5575e;

    /* renamed from: f  reason: collision with root package name */
    final String f5576f;

    /* renamed from: g  reason: collision with root package name */
    final int f5577g;

    /* renamed from: h  reason: collision with root package name */
    final int f5578h;

    /* renamed from: j  reason: collision with root package name */
    final CharSequence f5579j;

    /* renamed from: k  reason: collision with root package name */
    final int f5580k;

    /* renamed from: l  reason: collision with root package name */
    final CharSequence f5581l;

    /* renamed from: m  reason: collision with root package name */
    final ArrayList<String> f5582m;

    /* renamed from: n  reason: collision with root package name */
    final ArrayList<String> f5583n;

    /* renamed from: p  reason: collision with root package name */
    final boolean f5584p;

    class a implements Parcelable.Creator<BackStackRecordState> {
        a() {
        }

        /* renamed from: a */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        /* renamed from: b */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    BackStackRecordState(a aVar) {
        int size = aVar.f5784c.size();
        this.f5571a = new int[(size * 6)];
        if (aVar.f5790i) {
            this.f5572b = new ArrayList<>(size);
            this.f5573c = new int[size];
            this.f5574d = new int[size];
            int i10 = 0;
            int i11 = 0;
            while (i10 < size) {
                b0.a aVar2 = aVar.f5784c.get(i10);
                int i12 = i11 + 1;
                this.f5571a[i11] = aVar2.f5801a;
                ArrayList<String> arrayList = this.f5572b;
                Fragment fragment = aVar2.f5802b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f5571a;
                int i13 = i12 + 1;
                iArr[i12] = aVar2.f5803c;
                int i14 = i13 + 1;
                iArr[i13] = aVar2.f5804d;
                int i15 = i14 + 1;
                iArr[i14] = aVar2.f5805e;
                int i16 = i15 + 1;
                iArr[i15] = aVar2.f5806f;
                iArr[i16] = aVar2.f5807g;
                this.f5573c[i10] = aVar2.f5808h.ordinal();
                this.f5574d[i10] = aVar2.f5809i.ordinal();
                i10++;
                i11 = i16 + 1;
            }
            this.f5575e = aVar.f5789h;
            this.f5576f = aVar.f5792k;
            this.f5577g = aVar.f5730v;
            this.f5578h = aVar.f5793l;
            this.f5579j = aVar.f5794m;
            this.f5580k = aVar.f5795n;
            this.f5581l = aVar.f5796o;
            this.f5582m = aVar.f5797p;
            this.f5583n = aVar.f5798q;
            this.f5584p = aVar.f5799r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    private void a(@NonNull a aVar) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 < this.f5571a.length) {
                b0.a aVar2 = new b0.a();
                int i12 = i10 + 1;
                aVar2.f5801a = this.f5571a[i10];
                if (FragmentManager.J0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Instantiate ");
                    sb2.append(aVar);
                    sb2.append(" op #");
                    sb2.append(i11);
                    sb2.append(" base fragment #");
                    sb2.append(this.f5571a[i12]);
                }
                aVar2.f5808h = Lifecycle.State.values()[this.f5573c[i11]];
                aVar2.f5809i = Lifecycle.State.values()[this.f5574d[i11]];
                int[] iArr = this.f5571a;
                int i13 = i12 + 1;
                if (iArr[i12] == 0) {
                    z10 = false;
                }
                aVar2.f5803c = z10;
                int i14 = i13 + 1;
                int i15 = iArr[i13];
                aVar2.f5804d = i15;
                int i16 = i14 + 1;
                int i17 = iArr[i14];
                aVar2.f5805e = i17;
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                aVar2.f5806f = i19;
                int i20 = iArr[i18];
                aVar2.f5807g = i20;
                aVar.f5785d = i15;
                aVar.f5786e = i17;
                aVar.f5787f = i19;
                aVar.f5788g = i20;
                aVar.f(aVar2);
                i11++;
                i10 = i18 + 1;
            } else {
                aVar.f5789h = this.f5575e;
                aVar.f5792k = this.f5576f;
                aVar.f5790i = true;
                aVar.f5793l = this.f5578h;
                aVar.f5794m = this.f5579j;
                aVar.f5795n = this.f5580k;
                aVar.f5796o = this.f5581l;
                aVar.f5797p = this.f5582m;
                aVar.f5798q = this.f5583n;
                aVar.f5799r = this.f5584p;
                return;
            }
        }
    }

    @NonNull
    public a c(@NonNull FragmentManager fragmentManager) {
        a aVar = new a(fragmentManager);
        a(aVar);
        aVar.f5730v = this.f5577g;
        for (int i10 = 0; i10 < this.f5572b.size(); i10++) {
            String str = this.f5572b.get(i10);
            if (str != null) {
                aVar.f5784c.get(i10).f5802b = fragmentManager.g0(str);
            }
        }
        aVar.z(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f5571a);
        parcel.writeStringList(this.f5572b);
        parcel.writeIntArray(this.f5573c);
        parcel.writeIntArray(this.f5574d);
        parcel.writeInt(this.f5575e);
        parcel.writeString(this.f5576f);
        parcel.writeInt(this.f5577g);
        parcel.writeInt(this.f5578h);
        TextUtils.writeToParcel(this.f5579j, parcel, 0);
        parcel.writeInt(this.f5580k);
        TextUtils.writeToParcel(this.f5581l, parcel, 0);
        parcel.writeStringList(this.f5582m);
        parcel.writeStringList(this.f5583n);
        parcel.writeInt(this.f5584p ? 1 : 0);
    }

    BackStackRecordState(Parcel parcel) {
        this.f5571a = parcel.createIntArray();
        this.f5572b = parcel.createStringArrayList();
        this.f5573c = parcel.createIntArray();
        this.f5574d = parcel.createIntArray();
        this.f5575e = parcel.readInt();
        this.f5576f = parcel.readString();
        this.f5577g = parcel.readInt();
        this.f5578h = parcel.readInt();
        this.f5579j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5580k = parcel.readInt();
        this.f5581l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5582m = parcel.createStringArrayList();
        this.f5583n = parcel.createStringArrayList();
        this.f5584p = parcel.readInt() != 0;
    }
}
