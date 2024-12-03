package net.sqlcipher;

import al.b;
import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class CursorWindow extends android.database.CursorWindow {
    public static final Parcelable.Creator<CursorWindow> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private static al.a f32803c = new b();

    /* renamed from: a  reason: collision with root package name */
    private long f32804a;

    /* renamed from: b  reason: collision with root package name */
    private int f32805b;

    static class a implements Parcelable.Creator<CursorWindow> {
        a() {
        }

        /* renamed from: a */
        public CursorWindow createFromParcel(Parcel parcel) {
            return new CursorWindow(parcel, 0);
        }

        /* renamed from: b */
        public CursorWindow[] newArray(int i10) {
            return new CursorWindow[i10];
        }
    }

    public CursorWindow(Parcel parcel, int i10) {
        super(true);
        IBinder readStrongBinder = parcel.readStrongBinder();
        this.f32805b = parcel.readInt();
        native_init(readStrongBinder);
    }

    private native boolean allocRow_native();

    private native void close_native();

    private native char[] copyStringToBuffer_native(int i10, int i11, int i12, CharArrayBuffer charArrayBuffer);

    private native void freeLastRow_native();

    private native byte[] getBlob_native(int i10, int i11);

    private native double getDouble_native(int i10, int i11);

    private native long getLong_native(int i10, int i11);

    private native int getNumRows_native();

    private native String getString_native(int i10, int i11);

    private native int getType_native(int i10, int i11);

    private native boolean isBlob_native(int i10, int i11);

    private native boolean isFloat_native(int i10, int i11);

    private native boolean isInteger_native(int i10, int i11);

    private native boolean isNull_native(int i10, int i11);

    private native boolean isString_native(int i10, int i11);

    private native void native_clear();

    private native IBinder native_getBinder();

    private native void native_init(IBinder iBinder);

    private native boolean putBlob_native(byte[] bArr, int i10, int i11);

    private native boolean putDouble_native(double d10, int i10, int i11);

    private native boolean putLong_native(long j10, int i10, int i11);

    private native boolean putNull_native(int i10, int i11);

    private native boolean putString_native(String str, int i10, int i11);

    private native boolean setNumColumns_native(int i10);

    public boolean allocRow() {
        acquireReference();
        try {
            return allocRow_native();
        } finally {
            releaseReference();
        }
    }

    public void clear() {
        acquireReference();
        try {
            this.f32805b = 0;
            native_clear();
        } finally {
            releaseReference();
        }
    }

    public void close() {
        releaseReference();
    }

    public void copyStringToBuffer(int i10, int i11, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer != null) {
            if (charArrayBuffer.data == null) {
                charArrayBuffer.data = new char[64];
            }
            acquireReference();
            try {
                char[] copyStringToBuffer_native = copyStringToBuffer_native(i10 - this.f32805b, i11, charArrayBuffer.data.length, charArrayBuffer);
                if (copyStringToBuffer_native != null) {
                    charArrayBuffer.data = copyStringToBuffer_native;
                }
            } finally {
                releaseReference();
            }
        } else {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.f32804a != 0) {
            close_native();
        }
    }

    public void freeLastRow() {
        acquireReference();
        try {
            freeLastRow_native();
        } finally {
            releaseReference();
        }
    }

    public byte[] getBlob(int i10, int i11) {
        acquireReference();
        try {
            return getBlob_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public double getDouble(int i10, int i11) {
        acquireReference();
        try {
            return getDouble_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public float getFloat(int i10, int i11) {
        acquireReference();
        try {
            return (float) getDouble_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public int getInt(int i10, int i11) {
        acquireReference();
        try {
            return (int) getLong_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public long getLong(int i10, int i11) {
        acquireReference();
        try {
            return getLong_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public int getNumRows() {
        acquireReference();
        try {
            return getNumRows_native();
        } finally {
            releaseReference();
        }
    }

    public short getShort(int i10, int i11) {
        acquireReference();
        try {
            return (short) ((int) getLong_native(i10 - this.f32805b, i11));
        } finally {
            releaseReference();
        }
    }

    public int getStartPosition() {
        return this.f32805b;
    }

    public String getString(int i10, int i11) {
        acquireReference();
        try {
            return getString_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public int getType(int i10, int i11) {
        acquireReference();
        try {
            return getType_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean isBlob(int i10, int i11) {
        acquireReference();
        try {
            return isBlob_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean isFloat(int i10, int i11) {
        acquireReference();
        try {
            return isFloat_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean isLong(int i10, int i11) {
        acquireReference();
        try {
            return isInteger_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean isNull(int i10, int i11) {
        acquireReference();
        try {
            return isNull_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean isString(int i10, int i11) {
        acquireReference();
        try {
            return isString_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    /* access modifiers changed from: protected */
    public void onAllReferencesReleased() {
        close_native();
        super.onAllReferencesReleased();
    }

    public boolean putBlob(byte[] bArr, int i10, int i11) {
        acquireReference();
        try {
            return putBlob_native(bArr, i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean putDouble(double d10, int i10, int i11) {
        acquireReference();
        try {
            return putDouble_native(d10, i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean putLong(long j10, int i10, int i11) {
        acquireReference();
        try {
            return putLong_native(j10, i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean putNull(int i10, int i11) {
        acquireReference();
        try {
            return putNull_native(i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean putString(String str, int i10, int i11) {
        acquireReference();
        try {
            return putString_native(str, i10 - this.f32805b, i11);
        } finally {
            releaseReference();
        }
    }

    public boolean setNumColumns(int i10) {
        acquireReference();
        try {
            return setNumColumns_native(i10);
        } finally {
            releaseReference();
        }
    }

    public void setStartPosition(int i10) {
        this.f32805b = i10;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStrongBinder(native_getBinder());
        parcel.writeInt(this.f32805b);
    }
}
