package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil.decode.e;
import coil.fetch.i;
import coil.memory.MemoryCache;
import coil.request.l;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.ViewSizeResolver;
import coil.size.h;
import coil.target.ImageViewTarget;
import coil.util.d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.s;
import r2.a;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u000b\u000fB\u0003\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\u0006\u00101\u001a\u00020,\u0012\b\u00107\u001a\u0004\u0018\u000102\u0012\u0006\u0010=\u001a\u000208\u0012\u001c\u0010D\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030?\u0012\b\u0012\u0006\u0012\u0002\b\u00030@\u0018\u00010>\u0012\b\u0010I\u001a\u0004\u0018\u00010E\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020K0J\u0012\u0006\u0010T\u001a\u00020P\u0012\u0006\u0010Z\u001a\u00020U\u0012\u0006\u0010_\u001a\u00020[\u0012\u0006\u0010c\u001a\u00020\u0007\u0012\u0006\u0010e\u001a\u00020\u0007\u0012\u0006\u0010f\u001a\u00020\u0007\u0012\u0006\u0010i\u001a\u00020\u0007\u0012\u0006\u0010o\u001a\u00020j\u0012\u0006\u0010q\u001a\u00020j\u0012\u0006\u0010t\u001a\u00020j\u0012\u0006\u0010y\u001a\u00020u\u0012\u0006\u0010z\u001a\u00020u\u0012\u0006\u0010{\u001a\u00020u\u0012\u0006\u0010~\u001a\u00020u\u0012\u0007\u0010\u0001\u001a\u00020\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010 \u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\b\u0010¡\u0001\u001a\u00030\u0001\u0012\b\u0010¥\u0001\u001a\u00030¢\u0001¢\u0006\u0006\bª\u0001\u0010«\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u00101\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00107\u001a\u0004\u0018\u0001028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010=\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R-\u0010D\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030?\u0012\b\u0012\u0006\u0012\u0002\b\u00030@\u0018\u00010>8\u0006¢\u0006\f\n\u0004\b/\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010I\u001a\u0004\u0018\u00010E8\u0006¢\u0006\f\n\u0004\b5\u0010F\u001a\u0004\bG\u0010HR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020K0J8\u0006¢\u0006\f\n\u0004\b\r\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010T\u001a\u00020P8\u0006¢\u0006\f\n\u0004\b\u0011\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010Z\u001a\u00020U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0017\u0010_\u001a\u00020[8\u0006¢\u0006\f\n\u0004\bG\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010c\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\b-\u0010bR\u0017\u0010e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bd\u0010a\u001a\u0004\b3\u0010bR\u0017\u0010f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b)\u0010a\u001a\u0004\b9\u0010bR\u0017\u0010i\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bg\u0010a\u001a\u0004\bh\u0010bR\u0017\u0010o\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010q\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bp\u0010l\u001a\u0004\bg\u0010nR\u0017\u0010t\u001a\u00020j8\u0006¢\u0006\f\n\u0004\br\u0010l\u001a\u0004\bs\u0010nR\u0017\u0010y\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bB\u0010v\u001a\u0004\bw\u0010xR\u0017\u0010z\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bX\u0010v\u001a\u0004\br\u0010xR\u0017\u0010{\u001a\u00020u8\u0006¢\u0006\f\n\u0004\bw\u0010v\u001a\u0004\bV\u0010xR\u0017\u0010~\u001a\u00020u8\u0006¢\u0006\f\n\u0004\b|\u0010v\u001a\u0004\b}\u0010xR\u001a\u0010\u0001\u001a\u000208\u0006¢\u0006\u000e\n\u0005\b\u001d\u0010\u0001\u001a\u0005\b|\u0010\u0001R\u001c\u0010\u0001\u001a\u00030\u00018\u0006¢\u0006\u000f\n\u0005\b#\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00030\u00018\u0006¢\u0006\u000f\n\u0005\bm\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00030\u00018\u0006¢\u0006\u000f\n\u0005\bs\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0004\u0018\u00010 8\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\"\u001a\u0005\b\u0001\u0010$R\u0019\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\u0007\n\u0005\b;\u0010\u0001R\u0019\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bh\u0010\u0001R\u0019\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010¡\u0001\u001a\u00030\u00018\u0006¢\u0006\u000e\n\u0005\b]\u0010\u0001\u001a\u0005\bd\u0010 \u0001R\u001b\u0010¥\u0001\u001a\u00030¢\u00018\u0006¢\u0006\u000e\n\u0005\b\u0017\u0010£\u0001\u001a\u0005\b`\u0010¤\u0001R\u0017\u0010§\u0001\u001a\u0005\u0018\u00010\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010¦\u0001R\u0016\u0010¨\u0001\u001a\u0005\u0018\u00010\u00018F¢\u0006\u0007\u001a\u0005\bk\u0010¦\u0001R\u0016\u0010©\u0001\u001a\u0005\u0018\u00010\u00018F¢\u0006\u0007\u001a\u0005\bp\u0010¦\u0001¨\u0006¬\u0001"}, d2 = {"Lcoil/request/g;", "", "Landroid/content/Context;", "context", "Lcoil/request/g$a;", "Q", "other", "", "equals", "", "hashCode", "a", "Landroid/content/Context;", "l", "()Landroid/content/Context;", "b", "Ljava/lang/Object;", "m", "()Ljava/lang/Object;", "data", "Lp2/a;", "c", "Lp2/a;", "M", "()Lp2/a;", "target", "Lcoil/request/g$b;", "d", "Lcoil/request/g$b;", "A", "()Lcoil/request/g$b;", "listener", "Lcoil/memory/MemoryCache$Key;", "e", "Lcoil/memory/MemoryCache$Key;", "B", "()Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "", "f", "Ljava/lang/String;", "r", "()Ljava/lang/String;", "diskCacheKey", "Landroid/graphics/Bitmap$Config;", "g", "Landroid/graphics/Bitmap$Config;", "j", "()Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/ColorSpace;", "h", "Landroid/graphics/ColorSpace;", "k", "()Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/Precision;", "i", "Lcoil/size/Precision;", "H", "()Lcoil/size/Precision;", "precision", "Lkotlin/Pair;", "Lcoil/fetch/i$a;", "Ljava/lang/Class;", "Lkotlin/Pair;", "w", "()Lkotlin/Pair;", "fetcherFactory", "Lcoil/decode/e$a;", "Lcoil/decode/e$a;", "o", "()Lcoil/decode/e$a;", "decoderFactory", "", "Lq2/a;", "Ljava/util/List;", "O", "()Ljava/util/List;", "transformations", "Lr2/c$a;", "Lr2/c$a;", "P", "()Lr2/c$a;", "transitionFactory", "Lokhttp3/s;", "n", "Lokhttp3/s;", "x", "()Lokhttp3/s;", "headers", "Lcoil/request/p;", "Lcoil/request/p;", "L", "()Lcoil/request/p;", "tags", "p", "Z", "()Z", "allowConversionToBitmap", "q", "allowHardware", "allowRgb565", "s", "I", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "t", "Lcoil/request/CachePolicy;", "C", "()Lcoil/request/CachePolicy;", "memoryCachePolicy", "u", "diskCachePolicy", "v", "D", "networkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "y", "()Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "fetcherDispatcher", "decoderDispatcher", "z", "N", "transformationDispatcher", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcoil/size/h;", "Lcoil/size/h;", "K", "()Lcoil/size/h;", "sizeResolver", "Lcoil/size/Scale;", "Lcoil/size/Scale;", "J", "()Lcoil/size/Scale;", "scale", "Lcoil/request/l;", "Lcoil/request/l;", "E", "()Lcoil/request/l;", "parameters", "G", "placeholderMemoryCacheKey", "F", "Ljava/lang/Integer;", "placeholderResId", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "errorResId", "errorDrawable", "fallbackResId", "fallbackDrawable", "Lcoil/request/b;", "Lcoil/request/b;", "()Lcoil/request/b;", "defined", "Lcoil/request/a;", "Lcoil/request/a;", "()Lcoil/request/a;", "defaults", "()Landroid/graphics/drawable/Drawable;", "placeholder", "error", "fallback", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Lp2/a;Lcoil/request/g$b;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/Precision;Lkotlin/Pair;Lcoil/decode/e$a;Ljava/util/List;Lr2/c$a;Lokhttp3/s;Lcoil/request/p;ZZZZLcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/lifecycle/Lifecycle;Lcoil/size/h;Lcoil/size/Scale;Lcoil/request/l;Lcoil/memory/MemoryCache$Key;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcoil/request/b;Lcoil/request/a;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class g {
    private final Lifecycle A;
    private final h B;
    private final Scale C;
    private final l D;
    private final MemoryCache.Key E;
    /* access modifiers changed from: private */
    public final Integer F;
    /* access modifiers changed from: private */
    public final Drawable G;
    /* access modifiers changed from: private */
    public final Integer H;
    /* access modifiers changed from: private */
    public final Drawable I;
    /* access modifiers changed from: private */
    public final Integer J;
    /* access modifiers changed from: private */
    public final Drawable K;
    private final b L;
    private final a M;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8306a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f8307b;

    /* renamed from: c  reason: collision with root package name */
    private final p2.a f8308c;

    /* renamed from: d  reason: collision with root package name */
    private final b f8309d;

    /* renamed from: e  reason: collision with root package name */
    private final MemoryCache.Key f8310e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8311f;

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap.Config f8312g;

    /* renamed from: h  reason: collision with root package name */
    private final ColorSpace f8313h;

    /* renamed from: i  reason: collision with root package name */
    private final Precision f8314i;

    /* renamed from: j  reason: collision with root package name */
    private final Pair<i.a<?>, Class<?>> f8315j;

    /* renamed from: k  reason: collision with root package name */
    private final e.a f8316k;

    /* renamed from: l  reason: collision with root package name */
    private final List<q2.a> f8317l;

    /* renamed from: m  reason: collision with root package name */
    private final c.a f8318m;

    /* renamed from: n  reason: collision with root package name */
    private final s f8319n;

    /* renamed from: o  reason: collision with root package name */
    private final p f8320o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f8321p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f8322q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f8323r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f8324s;

    /* renamed from: t  reason: collision with root package name */
    private final CachePolicy f8325t;

    /* renamed from: u  reason: collision with root package name */
    private final CachePolicy f8326u;

    /* renamed from: v  reason: collision with root package name */
    private final CachePolicy f8327v;

    /* renamed from: w  reason: collision with root package name */
    private final CoroutineDispatcher f8328w;

    /* renamed from: x  reason: collision with root package name */
    private final CoroutineDispatcher f8329x;

    /* renamed from: y  reason: collision with root package name */
    private final CoroutineDispatcher f8330y;

    /* renamed from: z  reason: collision with root package name */
    private final CoroutineDispatcher f8331z;

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nH\u0017¨\u0006\f"}, d2 = {"Lcoil/request/g$b;", "", "Lcoil/request/g;", "request", "", "b", "a", "Lcoil/request/d;", "result", "c", "Lcoil/request/n;", "d", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public interface b {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar, d dVar);

        void d(g gVar, n nVar);
    }

    private g(Context context, Object obj, p2.a aVar, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair<? extends i.a<?>, ? extends Class<?>> pair, e.a aVar2, List<? extends q2.a> list, c.a aVar3, s sVar, p pVar, boolean z10, boolean z11, boolean z12, boolean z13, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, h hVar, Scale scale, l lVar, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, b bVar2, a aVar4) {
        this.f8306a = context;
        this.f8307b = obj;
        this.f8308c = aVar;
        this.f8309d = bVar;
        this.f8310e = key;
        this.f8311f = str;
        this.f8312g = config;
        this.f8313h = colorSpace;
        this.f8314i = precision;
        this.f8315j = pair;
        this.f8316k = aVar2;
        this.f8317l = list;
        this.f8318m = aVar3;
        this.f8319n = sVar;
        this.f8320o = pVar;
        this.f8321p = z10;
        this.f8322q = z11;
        this.f8323r = z12;
        this.f8324s = z13;
        this.f8325t = cachePolicy;
        this.f8326u = cachePolicy2;
        this.f8327v = cachePolicy3;
        this.f8328w = coroutineDispatcher;
        this.f8329x = coroutineDispatcher2;
        this.f8330y = coroutineDispatcher3;
        this.f8331z = coroutineDispatcher4;
        this.A = lifecycle;
        this.B = hVar;
        this.C = scale;
        this.D = lVar;
        this.E = key2;
        this.F = num;
        this.G = drawable;
        this.H = num2;
        this.I = drawable2;
        this.J = num3;
        this.K = drawable3;
        this.L = bVar2;
        this.M = aVar4;
    }

    public /* synthetic */ g(Context context, Object obj, p2.a aVar, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, e.a aVar2, List list, c.a aVar3, s sVar, p pVar, boolean z10, boolean z11, boolean z12, boolean z13, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, h hVar, Scale scale, l lVar, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, b bVar2, a aVar4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, aVar, bVar, key, str, config, colorSpace, precision, pair, aVar2, list, aVar3, sVar, pVar, z10, z11, z12, z13, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, hVar, scale, lVar, key2, num, drawable, num2, drawable2, num3, drawable3, bVar2, aVar4);
    }

    public static /* synthetic */ a R(g gVar, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = gVar.f8306a;
        }
        return gVar.Q(context);
    }

    public final b A() {
        return this.f8309d;
    }

    public final MemoryCache.Key B() {
        return this.f8310e;
    }

    public final CachePolicy C() {
        return this.f8325t;
    }

    public final CachePolicy D() {
        return this.f8327v;
    }

    public final l E() {
        return this.D;
    }

    public final Drawable F() {
        return coil.util.h.c(this, this.G, this.F, this.M.n());
    }

    public final MemoryCache.Key G() {
        return this.E;
    }

    public final Precision H() {
        return this.f8314i;
    }

    public final boolean I() {
        return this.f8324s;
    }

    public final Scale J() {
        return this.C;
    }

    public final h K() {
        return this.B;
    }

    public final p L() {
        return this.f8320o;
    }

    public final p2.a M() {
        return this.f8308c;
    }

    public final CoroutineDispatcher N() {
        return this.f8331z;
    }

    public final List<q2.a> O() {
        return this.f8317l;
    }

    public final c.a P() {
        return this.f8318m;
    }

    public final a Q(Context context) {
        return new a(this, context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (!j.b(this.f8306a, gVar.f8306a) || !j.b(this.f8307b, gVar.f8307b) || !j.b(this.f8308c, gVar.f8308c) || !j.b(this.f8309d, gVar.f8309d) || !j.b(this.f8310e, gVar.f8310e) || !j.b(this.f8311f, gVar.f8311f) || this.f8312g != gVar.f8312g || ((Build.VERSION.SDK_INT >= 26 && !j.b(this.f8313h, gVar.f8313h)) || this.f8314i != gVar.f8314i || !j.b(this.f8315j, gVar.f8315j) || !j.b(this.f8316k, gVar.f8316k) || !j.b(this.f8317l, gVar.f8317l) || !j.b(this.f8318m, gVar.f8318m) || !j.b(this.f8319n, gVar.f8319n) || !j.b(this.f8320o, gVar.f8320o) || this.f8321p != gVar.f8321p || this.f8322q != gVar.f8322q || this.f8323r != gVar.f8323r || this.f8324s != gVar.f8324s || this.f8325t != gVar.f8325t || this.f8326u != gVar.f8326u || this.f8327v != gVar.f8327v || !j.b(this.f8328w, gVar.f8328w) || !j.b(this.f8329x, gVar.f8329x) || !j.b(this.f8330y, gVar.f8330y) || !j.b(this.f8331z, gVar.f8331z) || !j.b(this.E, gVar.E) || !j.b(this.F, gVar.F) || !j.b(this.G, gVar.G) || !j.b(this.H, gVar.H) || !j.b(this.I, gVar.I) || !j.b(this.J, gVar.J) || !j.b(this.K, gVar.K) || !j.b(this.A, gVar.A) || !j.b(this.B, gVar.B) || this.C != gVar.C || !j.b(this.D, gVar.D) || !j.b(this.L, gVar.L) || !j.b(this.M, gVar.M))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean g() {
        return this.f8321p;
    }

    public final boolean h() {
        return this.f8322q;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int hashCode = ((this.f8306a.hashCode() * 31) + this.f8307b.hashCode()) * 31;
        p2.a aVar = this.f8308c;
        int i23 = 0;
        if (aVar != null) {
            i10 = aVar.hashCode();
        } else {
            i10 = 0;
        }
        int i24 = (hashCode + i10) * 31;
        b bVar = this.f8309d;
        if (bVar != null) {
            i11 = bVar.hashCode();
        } else {
            i11 = 0;
        }
        int i25 = (i24 + i11) * 31;
        MemoryCache.Key key = this.f8310e;
        if (key != null) {
            i12 = key.hashCode();
        } else {
            i12 = 0;
        }
        int i26 = (i25 + i12) * 31;
        String str = this.f8311f;
        if (str != null) {
            i13 = str.hashCode();
        } else {
            i13 = 0;
        }
        int hashCode2 = (((i26 + i13) * 31) + this.f8312g.hashCode()) * 31;
        ColorSpace colorSpace = this.f8313h;
        if (colorSpace != null) {
            i14 = colorSpace.hashCode();
        } else {
            i14 = 0;
        }
        int hashCode3 = (((hashCode2 + i14) * 31) + this.f8314i.hashCode()) * 31;
        Pair<i.a<?>, Class<?>> pair = this.f8315j;
        if (pair != null) {
            i15 = pair.hashCode();
        } else {
            i15 = 0;
        }
        int i27 = (hashCode3 + i15) * 31;
        e.a aVar2 = this.f8316k;
        if (aVar2 != null) {
            i16 = aVar2.hashCode();
        } else {
            i16 = 0;
        }
        int hashCode4 = (((((((((((((((((((((((((((((((((((((((i27 + i16) * 31) + this.f8317l.hashCode()) * 31) + this.f8318m.hashCode()) * 31) + this.f8319n.hashCode()) * 31) + this.f8320o.hashCode()) * 31) + Boolean.hashCode(this.f8321p)) * 31) + Boolean.hashCode(this.f8322q)) * 31) + Boolean.hashCode(this.f8323r)) * 31) + Boolean.hashCode(this.f8324s)) * 31) + this.f8325t.hashCode()) * 31) + this.f8326u.hashCode()) * 31) + this.f8327v.hashCode()) * 31) + this.f8328w.hashCode()) * 31) + this.f8329x.hashCode()) * 31) + this.f8330y.hashCode()) * 31) + this.f8331z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31;
        MemoryCache.Key key2 = this.E;
        if (key2 != null) {
            i17 = key2.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (hashCode4 + i17) * 31;
        Integer num = this.F;
        if (num != null) {
            i18 = num.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        Drawable drawable = this.G;
        if (drawable != null) {
            i19 = drawable.hashCode();
        } else {
            i19 = 0;
        }
        int i30 = (i29 + i19) * 31;
        Integer num2 = this.H;
        if (num2 != null) {
            i20 = num2.hashCode();
        } else {
            i20 = 0;
        }
        int i31 = (i30 + i20) * 31;
        Drawable drawable2 = this.I;
        if (drawable2 != null) {
            i21 = drawable2.hashCode();
        } else {
            i21 = 0;
        }
        int i32 = (i31 + i21) * 31;
        Integer num3 = this.J;
        if (num3 != null) {
            i22 = num3.hashCode();
        } else {
            i22 = 0;
        }
        int i33 = (i32 + i22) * 31;
        Drawable drawable3 = this.K;
        if (drawable3 != null) {
            i23 = drawable3.hashCode();
        }
        return ((((i33 + i23) * 31) + this.L.hashCode()) * 31) + this.M.hashCode();
    }

    public final boolean i() {
        return this.f8323r;
    }

    public final Bitmap.Config j() {
        return this.f8312g;
    }

    public final ColorSpace k() {
        return this.f8313h;
    }

    public final Context l() {
        return this.f8306a;
    }

    public final Object m() {
        return this.f8307b;
    }

    public final CoroutineDispatcher n() {
        return this.f8330y;
    }

    public final e.a o() {
        return this.f8316k;
    }

    public final a p() {
        return this.M;
    }

    public final b q() {
        return this.L;
    }

    public final String r() {
        return this.f8311f;
    }

    public final CachePolicy s() {
        return this.f8326u;
    }

    public final Drawable t() {
        return coil.util.h.c(this, this.I, this.H, this.M.h());
    }

    public final Drawable u() {
        return coil.util.h.c(this, this.K, this.J, this.M.i());
    }

    public final CoroutineDispatcher v() {
        return this.f8329x;
    }

    public final Pair<i.a<?>, Class<?>> w() {
        return this.f8315j;
    }

    public final s x() {
        return this.f8319n;
    }

    public final CoroutineDispatcher y() {
        return this.f8328w;
    }

    public final Lifecycle z() {
        return this.A;
    }

    @Metadata(bv = {}, d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\u0006\u00101\u001a\u00020/¢\u0006\u0006\b\u0001\u0010\u0001B\u001e\b\u0017\u0012\u0007\u0010\u0001\u001a\u00020-\u0012\b\b\u0002\u00101\u001a\u00020/¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*J\u0006\u0010.\u001a\u00020-R\u0014\u00101\u001a\u00020/8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u00100R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u00102R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u00103R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00104R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010ER,\u0010K\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030H\u0012\b\u0012\u0006\u0012\u0002\b\u00030I\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010LR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010UR(\u0010Y\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030I\u0012\u0004\u0012\u00020\u0001\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010XR\u0016\u0010[\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010ZR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010g\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010dR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bp\u0010lR\u0018\u0010s\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010lR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u00109R\u0018\u0010|\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010{R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010{R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcoil/request/g$a;", "", "", "i", "h", "Landroidx/lifecycle/Lifecycle;", "j", "Lcoil/size/h;", "l", "Lcoil/size/Scale;", "k", "data", "d", "", "width", "height", "m", "Lcoil/size/g;", "size", "n", "resolver", "o", "Lcoil/decode/e$a;", "factory", "e", "Landroid/graphics/drawable/Drawable;", "drawable", "g", "Landroid/widget/ImageView;", "imageView", "p", "Lp2/a;", "target", "q", "", "enable", "c", "durationMillis", "b", "Lr2/c$a;", "transition", "r", "Lcoil/request/a;", "defaults", "f", "Lcoil/request/g;", "a", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcoil/request/a;", "Ljava/lang/Object;", "Lp2/a;", "Lcoil/request/g$b;", "Lcoil/request/g$b;", "listener", "Lcoil/memory/MemoryCache$Key;", "Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "", "Ljava/lang/String;", "diskCacheKey", "Landroid/graphics/Bitmap$Config;", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Landroid/graphics/ColorSpace;", "Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/Precision;", "Lcoil/size/Precision;", "precision", "Lkotlin/Pair;", "Lcoil/fetch/i$a;", "Ljava/lang/Class;", "Lkotlin/Pair;", "fetcherFactory", "Lcoil/decode/e$a;", "decoderFactory", "", "Lq2/a;", "Ljava/util/List;", "transformations", "Lr2/c$a;", "transitionFactory", "Lokhttp3/s$a;", "Lokhttp3/s$a;", "headers", "", "Ljava/util/Map;", "tags", "Z", "allowConversionToBitmap", "Ljava/lang/Boolean;", "allowHardware", "s", "allowRgb565", "t", "premultipliedAlpha", "Lcoil/request/CachePolicy;", "u", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "v", "diskCachePolicy", "w", "networkCachePolicy", "Lkotlinx/coroutines/CoroutineDispatcher;", "x", "Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "y", "fetcherDispatcher", "z", "decoderDispatcher", "A", "transformationDispatcher", "Lcoil/request/l$a;", "B", "Lcoil/request/l$a;", "parameters", "C", "placeholderMemoryCacheKey", "D", "Ljava/lang/Integer;", "placeholderResId", "E", "Landroid/graphics/drawable/Drawable;", "placeholderDrawable", "F", "errorResId", "G", "errorDrawable", "H", "fallbackResId", "I", "fallbackDrawable", "J", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "K", "Lcoil/size/h;", "sizeResolver", "L", "Lcoil/size/Scale;", "scale", "M", "resolvedLifecycle", "N", "resolvedSizeResolver", "O", "resolvedScale", "<init>", "(Landroid/content/Context;)V", "request", "(Lcoil/request/g;Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private CoroutineDispatcher A;
        private l.a B;
        private MemoryCache.Key C;
        private Integer D;
        private Drawable E;
        private Integer F;
        private Drawable G;
        private Integer H;
        private Drawable I;
        private Lifecycle J;
        private h K;
        private Scale L;
        private Lifecycle M;
        private h N;
        private Scale O;

        /* renamed from: a  reason: collision with root package name */
        private final Context f8332a;

        /* renamed from: b  reason: collision with root package name */
        private a f8333b;

        /* renamed from: c  reason: collision with root package name */
        private Object f8334c;

        /* renamed from: d  reason: collision with root package name */
        private p2.a f8335d;

        /* renamed from: e  reason: collision with root package name */
        private b f8336e;

        /* renamed from: f  reason: collision with root package name */
        private MemoryCache.Key f8337f;

        /* renamed from: g  reason: collision with root package name */
        private String f8338g;

        /* renamed from: h  reason: collision with root package name */
        private Bitmap.Config f8339h;

        /* renamed from: i  reason: collision with root package name */
        private ColorSpace f8340i;

        /* renamed from: j  reason: collision with root package name */
        private Precision f8341j;

        /* renamed from: k  reason: collision with root package name */
        private Pair<? extends i.a<?>, ? extends Class<?>> f8342k;

        /* renamed from: l  reason: collision with root package name */
        private e.a f8343l;

        /* renamed from: m  reason: collision with root package name */
        private List<? extends q2.a> f8344m;

        /* renamed from: n  reason: collision with root package name */
        private c.a f8345n;

        /* renamed from: o  reason: collision with root package name */
        private s.a f8346o;

        /* renamed from: p  reason: collision with root package name */
        private Map<Class<?>, Object> f8347p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f8348q;

        /* renamed from: r  reason: collision with root package name */
        private Boolean f8349r;

        /* renamed from: s  reason: collision with root package name */
        private Boolean f8350s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f8351t;

        /* renamed from: u  reason: collision with root package name */
        private CachePolicy f8352u;

        /* renamed from: v  reason: collision with root package name */
        private CachePolicy f8353v;

        /* renamed from: w  reason: collision with root package name */
        private CachePolicy f8354w;

        /* renamed from: x  reason: collision with root package name */
        private CoroutineDispatcher f8355x;

        /* renamed from: y  reason: collision with root package name */
        private CoroutineDispatcher f8356y;

        /* renamed from: z  reason: collision with root package name */
        private CoroutineDispatcher f8357z;

        public a(Context context) {
            this.f8332a = context;
            this.f8333b = coil.util.h.b();
            this.f8334c = null;
            this.f8335d = null;
            this.f8336e = null;
            this.f8337f = null;
            this.f8338g = null;
            this.f8339h = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.f8340i = null;
            }
            this.f8341j = null;
            this.f8342k = null;
            this.f8343l = null;
            this.f8344m = q.j();
            this.f8345n = null;
            this.f8346o = null;
            this.f8347p = null;
            this.f8348q = true;
            this.f8349r = null;
            this.f8350s = null;
            this.f8351t = true;
            this.f8352u = null;
            this.f8353v = null;
            this.f8354w = null;
            this.f8355x = null;
            this.f8356y = null;
            this.f8357z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final void h() {
            this.O = null;
        }

        private final void i() {
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final Lifecycle j() {
            Context context;
            p2.a aVar = this.f8335d;
            if (aVar instanceof p2.b) {
                context = ((p2.b) aVar).getView().getContext();
            } else {
                context = this.f8332a;
            }
            Lifecycle c10 = d.c(context);
            if (c10 == null) {
                return f.f8304b;
            }
            return c10;
        }

        private final Scale k() {
            ViewSizeResolver viewSizeResolver;
            p2.b bVar;
            View view;
            h hVar = this.K;
            View view2 = null;
            if (hVar instanceof ViewSizeResolver) {
                viewSizeResolver = (ViewSizeResolver) hVar;
            } else {
                viewSizeResolver = null;
            }
            if (viewSizeResolver == null || (view = viewSizeResolver.getView()) == null) {
                p2.a aVar = this.f8335d;
                if (aVar instanceof p2.b) {
                    bVar = (p2.b) aVar;
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    view2 = bVar.getView();
                }
            } else {
                view2 = view;
            }
            if (view2 instanceof ImageView) {
                return coil.util.j.o((ImageView) view2);
            }
            return Scale.FIT;
        }

        private final h l() {
            boolean z10;
            p2.a aVar = this.f8335d;
            if (!(aVar instanceof p2.b)) {
                return new coil.size.d(this.f8332a);
            }
            View view = ((p2.b) aVar).getView();
            if (view instanceof ImageView) {
                ImageView.ScaleType scaleType = ((ImageView) view).getScaleType();
                if (scaleType == ImageView.ScaleType.CENTER || scaleType == ImageView.ScaleType.MATRIX) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    return coil.size.i.a(coil.size.g.f8414d);
                }
            }
            return coil.size.j.b(view, false, 2, (Object) null);
        }

        public final g a() {
            s sVar;
            p pVar;
            boolean z10;
            boolean z11;
            l lVar;
            Context context = this.f8332a;
            Object obj = this.f8334c;
            if (obj == null) {
                obj = i.f8358a;
            }
            Object obj2 = obj;
            p2.a aVar = this.f8335d;
            b bVar = this.f8336e;
            MemoryCache.Key key = this.f8337f;
            String str = this.f8338g;
            Bitmap.Config config = this.f8339h;
            if (config == null) {
                config = this.f8333b.e();
            }
            Bitmap.Config config2 = config;
            ColorSpace colorSpace = this.f8340i;
            Precision precision = this.f8341j;
            if (precision == null) {
                precision = this.f8333b.o();
            }
            Precision precision2 = precision;
            Pair<? extends i.a<?>, ? extends Class<?>> pair = this.f8342k;
            e.a aVar2 = this.f8343l;
            List<? extends q2.a> list = this.f8344m;
            c.a aVar3 = this.f8345n;
            if (aVar3 == null) {
                aVar3 = this.f8333b.q();
            }
            c.a aVar4 = aVar3;
            s.a aVar5 = this.f8346o;
            if (aVar5 != null) {
                sVar = aVar5.f();
            } else {
                sVar = null;
            }
            s y10 = coil.util.j.y(sVar);
            Map<Class<?>, Object> map = this.f8347p;
            if (map != null) {
                pVar = p.f8391b.a(map);
            } else {
                pVar = null;
            }
            p x10 = coil.util.j.x(pVar);
            boolean z12 = this.f8348q;
            Boolean bool = this.f8349r;
            if (bool != null) {
                z10 = bool.booleanValue();
            } else {
                z10 = this.f8333b.c();
            }
            boolean z13 = z10;
            Boolean bool2 = this.f8350s;
            if (bool2 != null) {
                z11 = bool2.booleanValue();
            } else {
                z11 = this.f8333b.d();
            }
            boolean z14 = z11;
            boolean z15 = this.f8351t;
            CachePolicy cachePolicy = this.f8352u;
            if (cachePolicy == null) {
                cachePolicy = this.f8333b.l();
            }
            CachePolicy cachePolicy2 = cachePolicy;
            CachePolicy cachePolicy3 = this.f8353v;
            if (cachePolicy3 == null) {
                cachePolicy3 = this.f8333b.g();
            }
            CachePolicy cachePolicy4 = cachePolicy3;
            CachePolicy cachePolicy5 = this.f8354w;
            if (cachePolicy5 == null) {
                cachePolicy5 = this.f8333b.m();
            }
            CachePolicy cachePolicy6 = cachePolicy5;
            CoroutineDispatcher coroutineDispatcher = this.f8355x;
            if (coroutineDispatcher == null) {
                coroutineDispatcher = this.f8333b.k();
            }
            CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
            CoroutineDispatcher coroutineDispatcher3 = this.f8356y;
            if (coroutineDispatcher3 == null) {
                coroutineDispatcher3 = this.f8333b.j();
            }
            CoroutineDispatcher coroutineDispatcher4 = coroutineDispatcher3;
            CoroutineDispatcher coroutineDispatcher5 = this.f8357z;
            if (coroutineDispatcher5 == null) {
                coroutineDispatcher5 = this.f8333b.f();
            }
            CoroutineDispatcher coroutineDispatcher6 = coroutineDispatcher5;
            CoroutineDispatcher coroutineDispatcher7 = this.A;
            if (coroutineDispatcher7 == null) {
                coroutineDispatcher7 = this.f8333b.p();
            }
            CoroutineDispatcher coroutineDispatcher8 = coroutineDispatcher7;
            Lifecycle lifecycle = this.J;
            if (lifecycle == null && (lifecycle = this.M) == null) {
                lifecycle = j();
            }
            Lifecycle lifecycle2 = lifecycle;
            h hVar = this.K;
            if (hVar == null && (hVar = this.N) == null) {
                hVar = l();
            }
            h hVar2 = hVar;
            Scale scale = this.L;
            if (scale == null && (scale = this.O) == null) {
                scale = k();
            }
            Scale scale2 = scale;
            l.a aVar6 = this.B;
            if (aVar6 != null) {
                lVar = aVar6.a();
            } else {
                lVar = null;
            }
            l w10 = coil.util.j.w(lVar);
            MemoryCache.Key key2 = this.C;
            Integer num = this.D;
            Drawable drawable = this.E;
            Integer num2 = this.F;
            Drawable drawable2 = this.G;
            Integer num3 = this.H;
            Drawable drawable3 = this.I;
            b bVar2 = r43;
            boolean z16 = z12;
            c.a aVar7 = aVar4;
            List<? extends q2.a> list2 = list;
            e.a aVar8 = aVar2;
            Pair<? extends i.a<?>, ? extends Class<?>> pair2 = pair;
            Precision precision3 = precision2;
            ColorSpace colorSpace2 = colorSpace;
            Bitmap.Config config3 = config2;
            String str2 = str;
            MemoryCache.Key key3 = key;
            b bVar3 = bVar;
            p2.a aVar9 = aVar;
            Object obj3 = obj2;
            b bVar4 = new b(this.J, this.K, this.L, this.f8355x, this.f8356y, this.f8357z, this.A, this.f8345n, this.f8341j, this.f8339h, this.f8349r, this.f8350s, this.f8352u, this.f8353v, this.f8354w);
            return new g(context, obj3, aVar9, bVar3, key3, str2, config3, colorSpace2, precision3, pair2, aVar8, list2, aVar7, y10, x10, z16, z13, z14, z15, cachePolicy2, cachePolicy4, cachePolicy6, coroutineDispatcher2, coroutineDispatcher4, coroutineDispatcher6, coroutineDispatcher8, lifecycle2, hVar2, scale2, w10, key2, num, drawable, num2, drawable2, num3, drawable3, bVar2, this.f8333b, (DefaultConstructorMarker) null);
        }

        public final a b(int i10) {
            c.a aVar;
            if (i10 > 0) {
                aVar = new a.C0197a(i10, false, 2, (DefaultConstructorMarker) null);
            } else {
                aVar = c.a.f17259b;
            }
            r(aVar);
            return this;
        }

        public final a c(boolean z10) {
            return b(z10 ? 100 : 0);
        }

        public final a d(Object obj) {
            this.f8334c = obj;
            return this;
        }

        public final a e(e.a aVar) {
            this.f8343l = aVar;
            return this;
        }

        public final a f(a aVar) {
            this.f8333b = aVar;
            h();
            return this;
        }

        public final a g(Drawable drawable) {
            this.E = drawable;
            this.D = 0;
            return this;
        }

        public final a m(int i10, int i11) {
            return n(coil.size.b.a(i10, i11));
        }

        public final a n(coil.size.g gVar) {
            return o(coil.size.i.a(gVar));
        }

        public final a o(h hVar) {
            this.K = hVar;
            i();
            return this;
        }

        public final a p(ImageView imageView) {
            return q(new ImageViewTarget(imageView));
        }

        public final a q(p2.a aVar) {
            this.f8335d = aVar;
            i();
            return this;
        }

        public final a r(c.a aVar) {
            this.f8345n = aVar;
            return this;
        }

        public a(g gVar, Context context) {
            this.f8332a = context;
            this.f8333b = gVar.p();
            this.f8334c = gVar.m();
            this.f8335d = gVar.M();
            this.f8336e = gVar.A();
            this.f8337f = gVar.B();
            this.f8338g = gVar.r();
            this.f8339h = gVar.q().c();
            if (Build.VERSION.SDK_INT >= 26) {
                this.f8340i = gVar.k();
            }
            this.f8341j = gVar.q().k();
            this.f8342k = gVar.w();
            this.f8343l = gVar.o();
            this.f8344m = gVar.O();
            this.f8345n = gVar.q().o();
            this.f8346o = gVar.x().j();
            this.f8347p = h0.w(gVar.L().a());
            this.f8348q = gVar.g();
            this.f8349r = gVar.q().a();
            this.f8350s = gVar.q().b();
            this.f8351t = gVar.I();
            this.f8352u = gVar.q().i();
            this.f8353v = gVar.q().e();
            this.f8354w = gVar.q().j();
            this.f8355x = gVar.q().g();
            this.f8356y = gVar.q().f();
            this.f8357z = gVar.q().d();
            this.A = gVar.q().n();
            this.B = gVar.E().f();
            this.C = gVar.G();
            this.D = gVar.F;
            this.E = gVar.G;
            this.F = gVar.H;
            this.G = gVar.I;
            this.H = gVar.J;
            this.I = gVar.K;
            this.J = gVar.q().h();
            this.K = gVar.q().m();
            this.L = gVar.q().l();
            if (gVar.l() == context) {
                this.M = gVar.z();
                this.N = gVar.K();
                this.O = gVar.J();
                return;
            }
            this.M = null;
            this.N = null;
            this.O = null;
        }
    }
}
