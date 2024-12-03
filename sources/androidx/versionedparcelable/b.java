package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.a;
import java.lang.reflect.Method;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f7158d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f7159e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7160f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7161g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7162h;

    /* renamed from: i  reason: collision with root package name */
    private int f7163i;

    /* renamed from: j  reason: collision with root package name */
    private int f7164j;

    /* renamed from: k  reason: collision with root package name */
    private int f7165k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f7159e.writeInt(bArr.length);
            this.f7159e.writeByteArray(bArr);
            return;
        }
        this.f7159e.writeInt(-1);
    }

    /* access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f7159e, 0);
    }

    public void E(int i10) {
        this.f7159e.writeInt(i10);
    }

    public void G(Parcelable parcelable) {
        this.f7159e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f7159e.writeString(str);
    }

    public void a() {
        int i10 = this.f7163i;
        if (i10 >= 0) {
            int i11 = this.f7158d.get(i10);
            int dataPosition = this.f7159e.dataPosition();
            this.f7159e.setDataPosition(i11);
            this.f7159e.writeInt(dataPosition - i11);
            this.f7159e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a b() {
        Parcel parcel = this.f7159e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f7164j;
        if (i10 == this.f7160f) {
            i10 = this.f7161g;
        }
        int i11 = i10;
        return new b(parcel, dataPosition, i11, this.f7162h + "  ", this.f7155a, this.f7156b, this.f7157c);
    }

    public boolean g() {
        return this.f7159e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f7159e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f7159e.readByteArray(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f7159e);
    }

    public boolean m(int i10) {
        while (this.f7164j < this.f7161g) {
            int i11 = this.f7165k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f7159e.setDataPosition(this.f7164j);
            int readInt = this.f7159e.readInt();
            this.f7165k = this.f7159e.readInt();
            this.f7164j += readInt;
        }
        if (this.f7165k == i10) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f7159e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f7159e.readParcelable(getClass().getClassLoader());
    }

    public String s() {
        return this.f7159e.readString();
    }

    public void w(int i10) {
        a();
        this.f7163i = i10;
        this.f7158d.put(i10, this.f7159e.dataPosition());
        E(0);
        E(i10);
    }

    public void y(boolean z10) {
        this.f7159e.writeInt(z10 ? 1 : 0);
    }

    private b(Parcel parcel, int i10, int i11, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f7158d = new SparseIntArray();
        this.f7163i = -1;
        this.f7165k = -1;
        this.f7159e = parcel;
        this.f7160f = i10;
        this.f7161g = i11;
        this.f7164j = i10;
        this.f7162h = str;
    }
}
