package s3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import m3.d;
import net.bytebuddy.jar.asm.Opcodes;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static final Paint f17464a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f17465b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f17466c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f17467d;

    /* renamed from: e  reason: collision with root package name */
    private static final Lock f17468e;

    private static final class a implements Lock {
        a() {
        }

        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        Lock lock;
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f17467d = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            lock = new ReentrantLock();
        } else {
            lock = new a();
        }
        f17468e = lock;
        Paint paint = new Paint(7);
        f17466c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f17468e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f17464a);
            d(canvas);
            lock.unlock();
        } catch (Throwable th2) {
            f17468e.unlock();
            throw th2;
        }
    }

    public static Bitmap b(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        float f10;
        float f11;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f12 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            f11 = ((float) i11) / ((float) bitmap.getHeight());
            f12 = (((float) i10) - (((float) bitmap.getWidth()) * f11)) * 0.5f;
            f10 = 0.0f;
        } else {
            f11 = ((float) i10) / ((float) bitmap.getWidth());
            f10 = (((float) i11) - (((float) bitmap.getHeight()) * f11)) * 0.5f;
        }
        matrix.setScale(f11, f11);
        matrix.postTranslate((float) ((int) (f12 + 0.5f)), (float) ((int) (f10 + 0.5f)));
        Bitmap d10 = dVar.d(i10, i11, h(bitmap));
        l(bitmap, d10);
        a(bitmap, d10, matrix);
        return d10;
    }

    public static Bitmap c(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) {
            Log.isLoggable("TransformationUtils", 2);
            return e(dVar, bitmap, i10, i11);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    private static void d(Canvas canvas) {
        canvas.setBitmap((Bitmap) null);
    }

    public static Bitmap e(@NonNull d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        float min = Math.min(((float) i10) / ((float) bitmap.getWidth()), ((float) i11) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            Log.isLoggable("TransformationUtils", 2);
            return bitmap;
        }
        Bitmap d10 = dVar.d((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), h(bitmap));
        l(bitmap, d10);
        if (Log.isLoggable("TransformationUtils", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request: ");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toFit:   ");
            sb3.append(bitmap.getWidth());
            sb3.append("x");
            sb3.append(bitmap.getHeight());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("toReuse: ");
            sb4.append(d10.getWidth());
            sb4.append("x");
            sb4.append(d10.getHeight());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("minPct:   ");
            sb5.append(min);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, d10, matrix);
        return d10;
    }

    public static Lock f() {
        return f17468e;
    }

    public static int g(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return Opcodes.GETFIELD;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void i(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean j(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap k(@NonNull d dVar, @NonNull Bitmap bitmap, int i10) {
        if (!j(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        i(i10, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap d10 = dVar.d(Math.round(rectF.width()), Math.round(rectF.height()), h(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        d10.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, d10, matrix);
        return d10;
    }

    public static void l(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
