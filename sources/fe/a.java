package fe;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class a {
    public static void A(@NonNull Parcel parcel, int i10, @NonNull Parcelable parcelable, int i11, boolean z10) {
        if (parcelable != null) {
            int H = H(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void B(@NonNull Parcel parcel, int i10, short s10) {
        J(parcel, i10, 4);
        parcel.writeInt(s10);
    }

    public static void C(@NonNull Parcel parcel, int i10, @NonNull String str, boolean z10) {
        if (str != null) {
            int H = H(parcel, i10);
            parcel.writeString(str);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void D(@NonNull Parcel parcel, int i10, @NonNull String[] strArr, boolean z10) {
        if (strArr != null) {
            int H = H(parcel, i10);
            parcel.writeStringArray(strArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void E(@NonNull Parcel parcel, int i10, @NonNull List<String> list, boolean z10) {
        if (list != null) {
            int H = H(parcel, i10);
            parcel.writeStringList(list);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static <T extends Parcelable> void F(@NonNull Parcel parcel, int i10, @NonNull T[] tArr, int i11, boolean z10) {
        if (tArr != null) {
            int H = H(parcel, i10);
            parcel.writeInt(r7);
            for (T t10 : tArr) {
                if (t10 == null) {
                    parcel.writeInt(0);
                } else {
                    K(parcel, t10, i11);
                }
            }
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static <T extends Parcelable> void G(@NonNull Parcel parcel, int i10, @NonNull List<T> list, boolean z10) {
        if (list != null) {
            int H = H(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                Parcelable parcelable = (Parcelable) list.get(i11);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    K(parcel, parcelable, 0);
                }
            }
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    private static int H(Parcel parcel, int i10) {
        parcel.writeInt(i10 | Opcodes.V_PREVIEW);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void I(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    private static void J(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    private static void K(Parcel parcel, Parcelable parcelable, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static int a(@NonNull Parcel parcel) {
        return H(parcel, 20293);
    }

    public static void b(@NonNull Parcel parcel, int i10) {
        I(parcel, i10);
    }

    public static void c(@NonNull Parcel parcel, int i10, @NonNull BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal != null) {
            int H = H(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void d(@NonNull Parcel parcel, int i10, @NonNull BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr != null) {
            int H = H(parcel, i10);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i11 = 0; i11 < length; i11++) {
                parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i11].scale());
            }
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void e(@NonNull Parcel parcel, int i10, @NonNull BigInteger bigInteger, boolean z10) {
        if (bigInteger != null) {
            int H = H(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void f(@NonNull Parcel parcel, int i10, @NonNull BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr != null) {
            int H = H(parcel, i10);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void g(@NonNull Parcel parcel, int i10, boolean z10) {
        J(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void h(@NonNull Parcel parcel, int i10, @NonNull boolean[] zArr, boolean z10) {
        if (zArr != null) {
            int H = H(parcel, i10);
            parcel.writeBooleanArray(zArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void i(@NonNull Parcel parcel, int i10, @NonNull Boolean bool, boolean z10) {
        if (bool != null) {
            J(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void j(@NonNull Parcel parcel, int i10, @NonNull Bundle bundle, boolean z10) {
        if (bundle != null) {
            int H = H(parcel, i10);
            parcel.writeBundle(bundle);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void k(@NonNull Parcel parcel, int i10, @NonNull byte[] bArr, boolean z10) {
        if (bArr != null) {
            int H = H(parcel, i10);
            parcel.writeByteArray(bArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void l(@NonNull Parcel parcel, int i10, double d10) {
        J(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void m(@NonNull Parcel parcel, int i10, @NonNull double[] dArr, boolean z10) {
        if (dArr != null) {
            int H = H(parcel, i10);
            parcel.writeDoubleArray(dArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void n(@NonNull Parcel parcel, int i10, @NonNull Double d10, boolean z10) {
        if (d10 != null) {
            J(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void o(@NonNull Parcel parcel, int i10, float f10) {
        J(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void p(@NonNull Parcel parcel, int i10, @NonNull float[] fArr, boolean z10) {
        if (fArr != null) {
            int H = H(parcel, i10);
            parcel.writeFloatArray(fArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void q(@NonNull Parcel parcel, int i10, @NonNull Float f10, boolean z10) {
        if (f10 != null) {
            J(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void r(@NonNull Parcel parcel, int i10, @NonNull IBinder iBinder, boolean z10) {
        if (iBinder != null) {
            int H = H(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void s(@NonNull Parcel parcel, int i10, int i11) {
        J(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void t(@NonNull Parcel parcel, int i10, @NonNull int[] iArr, boolean z10) {
        if (iArr != null) {
            int H = H(parcel, i10);
            parcel.writeIntArray(iArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void u(@NonNull Parcel parcel, int i10, @NonNull Integer num, boolean z10) {
        if (num != null) {
            J(parcel, i10, 4);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void v(@NonNull Parcel parcel, int i10, long j10) {
        J(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void w(@NonNull Parcel parcel, int i10, @NonNull long[] jArr, boolean z10) {
        if (jArr != null) {
            int H = H(parcel, i10);
            parcel.writeLongArray(jArr);
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void x(@NonNull Parcel parcel, int i10, @NonNull Long l10, boolean z10) {
        if (l10 != null) {
            J(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void y(@NonNull Parcel parcel, int i10, @NonNull Parcel parcel2, boolean z10) {
        if (parcel2 != null) {
            int H = H(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }

    public static void z(@NonNull Parcel parcel, int i10, @NonNull List<Parcel> list, boolean z10) {
        if (list != null) {
            int H = H(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                Parcel parcel2 = list.get(i11);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            I(parcel, H);
        } else if (z10) {
            J(parcel, i10, 0);
        }
    }
}
