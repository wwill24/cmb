package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull android.os.Parcel r4) {
            /*
                r2 = this;
                int r0 = r4.dataPosition()
                int r4 = r4.dataSize()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                java.lang.String r3 = " Parcel: pos="
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = " size="
                r1.append(r3)
                r1.append(r4)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    @NonNull
    public static Float A(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        if (I == 0) {
            return null;
        }
        L(parcel, i10, I, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int B(@NonNull Parcel parcel) {
        return parcel.readInt();
    }

    @NonNull
    public static IBinder C(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + I);
        return readStrongBinder;
    }

    public static int D(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return parcel.readInt();
    }

    @NonNull
    public static Integer E(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        if (I == 0) {
            return null;
        }
        L(parcel, i10, I, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long F(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 8);
        return parcel.readLong();
    }

    @NonNull
    public static Long G(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        if (I == 0) {
            return null;
        }
        L(parcel, i10, I, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short H(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return (short) parcel.readInt();
    }

    public static int I(@NonNull Parcel parcel, int i10) {
        return (i10 & Opcodes.V_PREVIEW) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void J(@NonNull Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + I(parcel, i10));
    }

    public static int K(@NonNull Parcel parcel) {
        int B = B(parcel);
        int I = I(parcel, B);
        int dataPosition = parcel.dataPosition();
        if (u(B) == 20293) {
            int i10 = I + dataPosition;
            if (i10 >= dataPosition && i10 <= parcel.dataSize()) {
                return i10;
            }
            throw new ParseException("Size read is invalid start=" + dataPosition + " end=" + i10, parcel);
        }
        throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(B))), parcel);
    }

    private static void L(Parcel parcel, int i10, int i11, int i12) {
        if (i11 != i12) {
            String hexString = Integer.toHexString(i11);
            throw new ParseException("Expected size " + i12 + " got " + i11 + " (0x" + hexString + ")", parcel);
        }
    }

    private static void M(Parcel parcel, int i10, int i11) {
        int I = I(parcel, i10);
        if (I != i11) {
            String hexString = Integer.toHexString(I);
            throw new ParseException("Expected size " + i11 + " got " + I + " (0x" + hexString + ")", parcel);
        }
    }

    @NonNull
    public static BigDecimal a(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + I);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    @NonNull
    public static BigDecimal[] b(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i11] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + I);
        return bigDecimalArr;
    }

    @NonNull
    public static BigInteger c(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + I);
        return new BigInteger(createByteArray);
    }

    @NonNull
    public static BigInteger[] d(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            bigIntegerArr[i11] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + I);
        return bigIntegerArr;
    }

    @NonNull
    public static boolean[] e(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + I);
        return createBooleanArray;
    }

    @NonNull
    public static Bundle f(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + I);
        return readBundle;
    }

    @NonNull
    public static byte[] g(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + I);
        return createByteArray;
    }

    @NonNull
    public static double[] h(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + I);
        return createDoubleArray;
    }

    @NonNull
    public static float[] i(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + I);
        return createFloatArray;
    }

    @NonNull
    public static int[] j(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + I);
        return createIntArray;
    }

    @NonNull
    public static long[] k(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + I);
        return createLongArray;
    }

    @NonNull
    public static Parcel l(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, I);
        parcel.setDataPosition(dataPosition + I);
        return obtain;
    }

    @NonNull
    public static Parcel[] m(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i11] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i11] = null;
            }
        }
        parcel.setDataPosition(dataPosition + I);
        return parcelArr;
    }

    @NonNull
    public static <T extends Parcelable> T n(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        T t10 = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + I);
        return t10;
    }

    @NonNull
    public static String o(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + I);
        return readString;
    }

    @NonNull
    public static String[] p(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + I);
        return createStringArray;
    }

    @NonNull
    public static ArrayList<String> q(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + I);
        return createStringArrayList;
    }

    @NonNull
    public static <T> T[] r(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + I);
        return createTypedArray;
    }

    @NonNull
    public static <T> ArrayList<T> s(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int I = I(parcel, i10);
        int dataPosition = parcel.dataPosition();
        if (I == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + I);
        return createTypedArrayList;
    }

    public static void t(@NonNull Parcel parcel, int i10) {
        if (parcel.dataPosition() != i10) {
            throw new ParseException("Overread allowed size end=" + i10, parcel);
        }
    }

    public static int u(int i10) {
        return (char) i10;
    }

    public static boolean v(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 4);
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Boolean w(@NonNull Parcel parcel, int i10) {
        boolean z10;
        int I = I(parcel, i10);
        if (I == 0) {
            return null;
        }
        L(parcel, i10, I, 4);
        if (parcel.readInt() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public static double x(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 8);
        return parcel.readDouble();
    }

    @NonNull
    public static Double y(@NonNull Parcel parcel, int i10) {
        int I = I(parcel, i10);
        if (I == 0) {
            return null;
        }
        L(parcel, i10, I, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float z(@NonNull Parcel parcel, int i10) {
        M(parcel, i10, 4);
        return parcel.readFloat();
    }
}
