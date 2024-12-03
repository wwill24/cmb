package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f4598a = aVar.p(iconCompat.f4598a, 1);
        iconCompat.f4600c = aVar.j(iconCompat.f4600c, 2);
        iconCompat.f4601d = aVar.r(iconCompat.f4601d, 3);
        iconCompat.f4602e = aVar.p(iconCompat.f4602e, 4);
        iconCompat.f4603f = aVar.p(iconCompat.f4603f, 5);
        iconCompat.f4604g = (ColorStateList) aVar.r(iconCompat.f4604g, 6);
        iconCompat.f4606i = aVar.t(iconCompat.f4606i, 7);
        iconCompat.f4607j = aVar.t(iconCompat.f4607j, 8);
        iconCompat.o();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.p(aVar.f());
        int i10 = iconCompat.f4598a;
        if (-1 != i10) {
            aVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f4600c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f4601d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f4602e;
        if (i11 != 0) {
            aVar.F(i11, 4);
        }
        int i12 = iconCompat.f4603f;
        if (i12 != 0) {
            aVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f4604g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f4606i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f4607j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
