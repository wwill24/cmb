package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f38876a;

    /* renamed from: b  reason: collision with root package name */
    ParcelFileDescriptor f38877b;

    /* renamed from: c  reason: collision with root package name */
    final int f38878c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f38879d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f38880e = false;

    /* renamed from: f  reason: collision with root package name */
    private File f38881f;

    BitmapTeleporter(int i10, ParcelFileDescriptor parcelFileDescriptor, int i11) {
        this.f38876a = i10;
        this.f38877b = parcelFileDescriptor;
        this.f38878c = i11;
    }

    private static final void S(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        if (this.f38877b == null) {
            Bitmap bitmap = (Bitmap) p.k(this.f38879d);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array2 = allocate.array();
            File file = this.f38881f;
            if (file != null) {
                try {
                    File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        this.f38877b = ParcelFileDescriptor.open(createTempFile, 268435456);
                        createTempFile.delete();
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                        try {
                            dataOutputStream.writeInt(array2.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(array2);
                            S(dataOutputStream);
                        } catch (IOException e10) {
                            throw new IllegalStateException("Could not write into unlinked file", e10);
                        } catch (Throwable th2) {
                            S(dataOutputStream);
                            throw th2;
                        }
                    } catch (FileNotFoundException unused) {
                        throw new IllegalStateException("Temporary file is somehow already deleted");
                    }
                } catch (IOException e11) {
                    throw new IllegalStateException("Could not create temporary file", e11);
                }
            } else {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
        }
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38876a);
        a.A(parcel, 2, this.f38877b, i10 | 1, false);
        a.s(parcel, 3, this.f38878c);
        a.b(parcel, a10);
        this.f38877b = null;
    }
}
