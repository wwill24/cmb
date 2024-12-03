package l2;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import coil.decode.d;
import coil.size.Scale;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007BE\b\u0007\u0012\b\u00105\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010a\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010?\u001a\u00020;\u0012\b\b\u0002\u0010C\u001a\u00020\u0004\u0012\b\b\u0002\u0010G\u001a\u00020\u001a\u0012\b\b\u0002\u0010J\u001a\u00020\u001a¢\u0006\u0004\bb\u0010cJ#\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0017J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0004H\u0014J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0018\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0001H\u0016J \u0010(\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00103\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000101H\u0017J\b\u00104\u001a\u00020\u001aH\u0016J\b\u00105\u001a\u00020\tH\u0016J\b\u00106\u001a\u00020\tH\u0016J\u001f\u00109\u001a\u00020\t2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0016H\u0001¢\u0006\u0004\b9\u0010:R\u0017\u0010?\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b\u0007\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010C\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010G\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b9\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010J\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\bH\u0010D\u001a\u0004\bI\u0010FR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020L0K8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010@R\u0014\u0010S\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010@R\u0016\u0010V\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010@R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010@R(\u00105\u001a\u0004\u0018\u00010\u00012\b\u0010Z\u001a\u0004\u0018\u00010\u00018\u0006@BX\u000e¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0019\u0010a\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b_\u0010\\\u001a\u0004\b`\u0010^¨\u0006e"}, d2 = {"Ll2/b;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "", "", "startSize", "endSize", "a", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "", "b", "Landroid/graphics/Canvas;", "canvas", "draw", "getAlpha", "alpha", "setAlpha", "getOpacity", "Landroid/graphics/ColorFilter;", "getColorFilter", "colorFilter", "setColorFilter", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "level", "", "onLevelChange", "", "state", "onStateChange", "getIntrinsicWidth", "getIntrinsicHeight", "who", "Ljava/lang/Runnable;", "what", "unscheduleDrawable", "invalidateDrawable", "", "when", "scheduleDrawable", "tintColor", "setTint", "Landroid/content/res/ColorStateList;", "tint", "setTintList", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "setTintMode", "Landroid/graphics/BlendMode;", "blendMode", "setTintBlendMode", "isRunning", "start", "stop", "drawable", "targetBounds", "c", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V", "Lcoil/size/Scale;", "Lcoil/size/Scale;", "getScale", "()Lcoil/size/Scale;", "scale", "I", "getDurationMillis", "()I", "durationMillis", "Z", "getFadeStart", "()Z", "fadeStart", "d", "getPreferExactIntrinsicSize", "preferExactIntrinsicSize", "", "Landroidx/vectordrawable/graphics/drawable/b;", "e", "Ljava/util/List;", "callbacks", "f", "intrinsicWidth", "g", "intrinsicHeight", "h", "J", "startTimeMillis", "j", "maxAlpha", "k", "<set-?>", "l", "Landroid/graphics/drawable/Drawable;", "getStart", "()Landroid/graphics/drawable/Drawable;", "m", "getEnd", "end", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZZ)V", "n", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class b extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: n  reason: collision with root package name */
    public static final a f15981n = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Scale f15982a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15983b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15984c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15985d;

    /* renamed from: e  reason: collision with root package name */
    private final List<androidx.vectordrawable.graphics.drawable.b> f15986e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final int f15987f;

    /* renamed from: g  reason: collision with root package name */
    private final int f15988g;

    /* renamed from: h  reason: collision with root package name */
    private long f15989h;

    /* renamed from: j  reason: collision with root package name */
    private int f15990j;

    /* renamed from: k  reason: collision with root package name */
    private int f15991k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f15992l;

    /* renamed from: m  reason: collision with root package name */
    private final Drawable f15993m;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Ll2/b$a;", "", "", "DEFAULT_DURATION", "I", "STATE_DONE", "STATE_RUNNING", "STATE_START", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(Drawable drawable, Drawable drawable2, Scale scale, int i10, boolean z10, boolean z11) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Drawable drawable3;
        boolean z12;
        this.f15982a = scale;
        this.f15983b = i10;
        this.f15984c = z10;
        this.f15985d = z11;
        Drawable drawable4 = null;
        if (drawable != null) {
            num = Integer.valueOf(drawable.getIntrinsicWidth());
        } else {
            num = null;
        }
        if (drawable2 != null) {
            num2 = Integer.valueOf(drawable2.getIntrinsicWidth());
        } else {
            num2 = null;
        }
        this.f15987f = a(num, num2);
        if (drawable != null) {
            num3 = Integer.valueOf(drawable.getIntrinsicHeight());
        } else {
            num3 = null;
        }
        if (drawable2 != null) {
            num4 = Integer.valueOf(drawable2.getIntrinsicHeight());
        } else {
            num4 = null;
        }
        this.f15988g = a(num3, num4);
        this.f15990j = 255;
        if (drawable != null) {
            drawable3 = drawable.mutate();
        } else {
            drawable3 = null;
        }
        this.f15992l = drawable3;
        drawable4 = drawable2 != null ? drawable2.mutate() : drawable4;
        this.f15993m = drawable4;
        if (i10 > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            Drawable drawable5 = this.f15992l;
            if (drawable5 != null) {
                drawable5.setCallback(this);
            }
            if (drawable4 != null) {
                drawable4.setCallback(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("durationMillis must be > 0.".toString());
    }

    private final int a(Integer num, Integer num2) {
        int i10;
        int i11 = -1;
        if (!this.f15985d && ((num != null && num.intValue() == -1) || (num2 != null && num2.intValue() == -1))) {
            return -1;
        }
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = -1;
        }
        if (num2 != null) {
            i11 = num2.intValue();
        }
        return Math.max(i10, i11);
    }

    private final void b() {
        this.f15991k = 2;
        this.f15992l = null;
        List<androidx.vectordrawable.graphics.drawable.b> list = this.f15986e;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            list.get(i10).b(this);
        }
    }

    public final void c(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double c10 = d.c(intrinsicWidth, intrinsicHeight, width, height, this.f15982a);
        double d10 = (double) 2;
        int a10 = c.a((((double) width) - (((double) intrinsicWidth) * c10)) / d10);
        int a11 = c.a((((double) height) - (c10 * ((double) intrinsicHeight))) / d10);
        drawable.setBounds(rect.left + a10, rect.top + a11, rect.right - a10, rect.bottom - a11);
    }

    public void draw(Canvas canvas) {
        boolean z10;
        Drawable drawable;
        int i10 = this.f15991k;
        if (i10 == 0) {
            Drawable drawable2 = this.f15992l;
            if (drawable2 != null) {
                drawable2.setAlpha(this.f15990j);
                int save = canvas.save();
                try {
                    drawable2.draw(canvas);
                } finally {
                    canvas.restoreToCount(save);
                }
            }
        } else if (i10 == 2) {
            Drawable drawable3 = this.f15993m;
            if (drawable3 != null) {
                drawable3.setAlpha(this.f15990j);
                int save2 = canvas.save();
                try {
                    drawable3.draw(canvas);
                } finally {
                    canvas.restoreToCount(save2);
                }
            }
        } else {
            double uptimeMillis = ((double) (SystemClock.uptimeMillis() - this.f15989h)) / ((double) this.f15983b);
            double i11 = j.i(uptimeMillis, 0.0d, 1.0d);
            int i12 = this.f15990j;
            int i13 = (int) (i11 * ((double) i12));
            if (this.f15984c) {
                i12 -= i13;
            }
            if (uptimeMillis >= 1.0d) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && (drawable = this.f15992l) != null) {
                drawable.setAlpha(i12);
                int save3 = canvas.save();
                try {
                    drawable.draw(canvas);
                } finally {
                    canvas.restoreToCount(save3);
                }
            }
            Drawable drawable4 = this.f15993m;
            if (drawable4 != null) {
                drawable4.setAlpha(i13);
                int save4 = canvas.save();
                try {
                    drawable4.draw(canvas);
                } finally {
                    canvas.restoreToCount(save4);
                }
            }
            if (z10) {
                b();
            } else {
                invalidateSelf();
            }
        }
    }

    public int getAlpha() {
        return this.f15990j;
    }

    public ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable;
        int i10 = this.f15991k;
        if (i10 == 0) {
            Drawable drawable2 = this.f15992l;
            if (drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        } else if (i10 == 1) {
            Drawable drawable3 = this.f15993m;
            if (drawable3 != null && (colorFilter = drawable3.getColorFilter()) != null) {
                return colorFilter;
            }
            Drawable drawable4 = this.f15992l;
            if (drawable4 != null) {
                return drawable4.getColorFilter();
            }
            return null;
        } else if (i10 == 2 && (drawable = this.f15993m) != null) {
            return drawable.getColorFilter();
        } else {
            return null;
        }
    }

    public int getIntrinsicHeight() {
        return this.f15988g;
    }

    public int getIntrinsicWidth() {
        return this.f15987f;
    }

    public int getOpacity() {
        Drawable drawable = this.f15992l;
        Drawable drawable2 = this.f15993m;
        int i10 = this.f15991k;
        if (i10 == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        } else if (i10 == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        } else if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        } else {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.f15991k == 1;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            c(drawable, rect);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            c(drawable2, rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        boolean z10;
        boolean z11;
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            z10 = drawable.setLevel(i10);
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            z11 = drawable2.setLevel(i10);
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        boolean z11;
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            z10 = drawable.setState(iArr);
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            z11 = drawable2.setState(iArr);
        } else {
            z11 = false;
        }
        if (z10 || z11) {
            return true;
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        boolean z10 = false;
        if (i10 >= 0 && i10 < 256) {
            z10 = true;
        }
        if (z10) {
            this.f15990j = i10;
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + i10).toString());
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i10) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            drawable.setTint(i10);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            drawable2.setTint(i10);
        }
    }

    public void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f15992l;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.f15993m;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.f15992l
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0010
            r0.start()
        L_0x0010:
            android.graphics.drawable.Drawable r0 = r4.f15993m
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x0019
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.start()
        L_0x001e:
            int r0 = r4.f15991k
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            r0 = 1
            r4.f15991k = r0
            long r0 = android.os.SystemClock.uptimeMillis()
            r4.f15989h = r0
            java.util.List<androidx.vectordrawable.graphics.drawable.b> r0 = r4.f15986e
            r1 = 0
            int r2 = r0.size()
        L_0x0033:
            if (r1 >= r2) goto L_0x0041
            java.lang.Object r3 = r0.get(r1)
            androidx.vectordrawable.graphics.drawable.b r3 = (androidx.vectordrawable.graphics.drawable.b) r3
            r3.c(r4)
            int r1 = r1 + 1
            goto L_0x0033
        L_0x0041:
            r4.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.b.start():void");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r3 = this;
            android.graphics.drawable.Drawable r0 = r3.f15992l
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 == 0) goto L_0x0010
            r0.stop()
        L_0x0010:
            android.graphics.drawable.Drawable r0 = r3.f15993m
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x0019
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.stop()
        L_0x001e:
            int r0 = r3.f15991k
            r1 = 2
            if (r0 == r1) goto L_0x0026
            r3.b()
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.b.stop():void");
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
