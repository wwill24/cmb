package com.clevertap.android.sdk.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.gif.a;

public class e implements a.C0117a {
    public byte[] a(int i10) {
        return new byte[i10];
    }

    @NonNull
    public Bitmap b(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    public int[] c(int i10) {
        return new int[i10];
    }
}
