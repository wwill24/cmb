package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f4597k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f4598a;

    /* renamed from: b  reason: collision with root package name */
    Object f4599b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f4600c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f4601d;

    /* renamed from: e  reason: collision with root package name */
    public int f4602e;

    /* renamed from: f  reason: collision with root package name */
    public int f4603f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f4604g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f4605h;

    /* renamed from: i  reason: collision with root package name */
    public String f4606i;

    /* renamed from: j  reason: collision with root package name */
    public String f4607j;

    static class a {
        static IconCompat a(@NonNull Object obj) {
            h.g(obj);
            int d10 = d(obj);
            if (d10 == 2) {
                return IconCompat.h((Resources) null, c(obj), b(obj));
            }
            if (d10 == 4) {
                return IconCompat.f(e(obj));
            }
            if (d10 == 6) {
                return IconCompat.c(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f4599b = obj;
            return iconCompat;
        }

        static int b(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        static String c(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static int d(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                return -1;
            } catch (InvocationTargetException unused2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to get icon type ");
                sb3.append(obj);
                return -1;
            } catch (NoSuchMethodException unused3) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unable to get icon type ");
                sb4.append(obj);
                return -1;
            }
        }

        static Uri e(@NonNull Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon g(IconCompat iconCompat, Context context) {
            Icon icon;
            switch (iconCompat.f4598a) {
                case -1:
                    return (Icon) iconCompat.f4599b;
                case 1:
                    icon = Icon.createWithBitmap((Bitmap) iconCompat.f4599b);
                    break;
                case 2:
                    icon = Icon.createWithResource(iconCompat.k(), iconCompat.f4602e);
                    break;
                case 3:
                    icon = Icon.createWithData((byte[]) iconCompat.f4599b, iconCompat.f4602e, iconCompat.f4603f);
                    break;
                case 4:
                    icon = Icon.createWithContentUri((String) iconCompat.f4599b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        icon = Icon.createWithBitmap(IconCompat.b((Bitmap) iconCompat.f4599b, false));
                        break;
                    } else {
                        icon = b.b((Bitmap) iconCompat.f4599b);
                        break;
                    }
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        icon = d.a(iconCompat.m());
                        break;
                    } else if (context != null) {
                        InputStream n10 = iconCompat.n(context);
                        if (n10 != null) {
                            if (i10 < 26) {
                                icon = Icon.createWithBitmap(IconCompat.b(BitmapFactory.decodeStream(n10), false));
                                break;
                            } else {
                                icon = b.b(BitmapFactory.decodeStream(n10));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.m());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.m());
                    }
                default:
                    throw new IllegalArgumentException("Unknown type");
            }
            ColorStateList colorStateList = iconCompat.f4604g;
            if (colorStateList != null) {
                icon.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f4605h;
            if (mode != IconCompat.f4597k) {
                icon.setTintMode(mode);
            }
            return icon;
        }
    }

    static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class c {
        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class d {
        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f4598a = -1;
        this.f4600c = null;
        this.f4601d = null;
        this.f4602e = 0;
        this.f4603f = 0;
        this.f4604g = null;
        this.f4605h = f4597k;
        this.f4606i = null;
    }

    public static IconCompat a(@NonNull Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z10) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = (float) min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @NonNull
    public static IconCompat c(@NonNull Uri uri) {
        androidx.core.util.c.c(uri);
        return d(uri.toString());
    }

    @NonNull
    public static IconCompat d(@NonNull String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f4599b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat e(@NonNull Bitmap bitmap) {
        androidx.core.util.c.c(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f4599b = bitmap;
        return iconCompat;
    }

    @NonNull
    public static IconCompat f(@NonNull Uri uri) {
        androidx.core.util.c.c(uri);
        return g(uri.toString());
    }

    @NonNull
    public static IconCompat g(@NonNull String str) {
        androidx.core.util.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f4599b = str;
        return iconCompat;
    }

    @NonNull
    public static IconCompat h(Resources resources, @NonNull String str, int i10) {
        androidx.core.util.c.c(str);
        if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f4602e = i10;
            if (resources != null) {
                try {
                    iconCompat.f4599b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f4599b = str;
            }
            iconCompat.f4607j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String s(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return IdentityHttpResponse.UNKNOWN;
        }
    }

    public Bitmap i() {
        int i10 = this.f4598a;
        if (i10 == -1) {
            Object obj = this.f4599b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i10 == 1) {
            return (Bitmap) this.f4599b;
        } else {
            if (i10 == 5) {
                return b((Bitmap) this.f4599b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int j() {
        int i10 = this.f4598a;
        if (i10 == -1) {
            return a.b(this.f4599b);
        }
        if (i10 == 2) {
            return this.f4602e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @NonNull
    public String k() {
        int i10 = this.f4598a;
        if (i10 == -1) {
            return a.c(this.f4599b);
        }
        if (i10 == 2) {
            String str = this.f4607j;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f4599b).split(CertificateUtil.DELIMITER, -1)[0];
            }
            return this.f4607j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i10 = this.f4598a;
        if (i10 == -1) {
            return a.d(this.f4599b);
        }
        return i10;
    }

    @NonNull
    public Uri m() {
        int i10 = this.f4598a;
        if (i10 == -1) {
            return a.e(this.f4599b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f4599b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream n(@NonNull Context context) {
        Uri m10 = m();
        String scheme = m10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m10);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to load image from URI: ");
                sb2.append(m10);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f4599b));
            } catch (FileNotFoundException unused2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to load image from path: ");
                sb3.append(m10);
                return null;
            }
        }
    }

    public void o() {
        this.f4605h = PorterDuff.Mode.valueOf(this.f4606i);
        switch (this.f4598a) {
            case -1:
                Parcelable parcelable = this.f4601d;
                if (parcelable != null) {
                    this.f4599b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.f4601d;
                if (parcelable2 != null) {
                    this.f4599b = parcelable2;
                    return;
                }
                byte[] bArr = this.f4600c;
                this.f4599b = bArr;
                this.f4598a = 3;
                this.f4602e = 0;
                this.f4603f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f4600c, Charset.forName("UTF-16"));
                this.f4599b = str;
                if (this.f4598a == 2 && this.f4607j == null) {
                    this.f4607j = str.split(CertificateUtil.DELIMITER, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f4599b = this.f4600c;
                return;
            default:
                return;
        }
    }

    public void p(boolean z10) {
        this.f4606i = this.f4605h.name();
        switch (this.f4598a) {
            case -1:
                if (!z10) {
                    this.f4601d = (Parcelable) this.f4599b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z10) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f4599b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f4600c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f4601d = (Parcelable) this.f4599b;
                return;
            case 2:
                this.f4600c = ((String) this.f4599b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f4600c = (byte[]) this.f4599b;
                return;
            case 4:
            case 6:
                this.f4600c = this.f4599b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    @NonNull
    @Deprecated
    public Icon q() {
        return r((Context) null);
    }

    @NonNull
    public Icon r(Context context) {
        return a.g(this, context);
    }

    @NonNull
    public String toString() {
        if (this.f4598a == -1) {
            return String.valueOf(this.f4599b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(s(this.f4598a));
        switch (this.f4598a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f4599b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f4599b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f4607j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", new Object[]{Integer.valueOf(j())}));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f4602e);
                if (this.f4603f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f4603f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f4599b);
                break;
        }
        if (this.f4604g != null) {
            sb2.append(" tint=");
            sb2.append(this.f4604g);
        }
        if (this.f4605h != f4597k) {
            sb2.append(" mode=");
            sb2.append(this.f4605h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    IconCompat(int i10) {
        this.f4600c = null;
        this.f4601d = null;
        this.f4602e = 0;
        this.f4603f = 0;
        this.f4604g = null;
        this.f4605h = f4597k;
        this.f4606i = null;
        this.f4598a = i10;
    }
}
