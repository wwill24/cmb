package com.coffeemeetsbagel.image_loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.apache.commons.beanutils.PropertyUtils;

public interface ImageLoaderContract {

    public enum ImageBucketSize {
        MICRO(286.0f),
        SMALL(428.0f),
        MEDIUM(856.0f),
        LARGE(1284.0f),
        DEFAULT(r0.width);
        
        private final float width;

        private ImageBucketSize(float f10) {
            this.width = f10;
        }

        public final float b() {
            return this.width;
        }
    }

    public enum MemoryConfig {
        NO_CACHE,
        NO_STORE
    }

    public static final class a {
        public static /* synthetic */ void a(ImageLoaderContract imageLoaderContract, Context context, String str, ImageView imageView, Integer num, Integer num2, b bVar, List list, Map map, Function0 function0, Function1 function1, Bitmap.Config config, ImageBucketSize imageBucketSize, MemoryConfig[] memoryConfigArr, int i10, Object obj) {
            ImageView imageView2;
            Integer num3;
            Integer num4;
            b bVar2;
            List list2;
            HashMap hashMap;
            Function0 function02;
            Function1 function12;
            Bitmap.Config config2;
            ImageBucketSize imageBucketSize2;
            int i11 = i10;
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    imageView2 = null;
                } else {
                    imageView2 = imageView;
                }
                if ((i11 & 8) != 0) {
                    num3 = null;
                } else {
                    num3 = num;
                }
                if ((i11 & 16) != 0) {
                    num4 = null;
                } else {
                    num4 = num2;
                }
                if ((i11 & 32) != 0) {
                    bVar2 = null;
                } else {
                    bVar2 = bVar;
                }
                if ((i11 & 64) != 0) {
                    list2 = q.j();
                } else {
                    list2 = list;
                }
                if ((i11 & 128) != 0) {
                    hashMap = new HashMap();
                } else {
                    hashMap = map;
                }
                if ((i11 & 256) != 0) {
                    function02 = null;
                } else {
                    function02 = function0;
                }
                if ((i11 & 512) != 0) {
                    function12 = null;
                } else {
                    function12 = function1;
                }
                if ((i11 & 1024) != 0) {
                    config2 = null;
                } else {
                    config2 = config;
                }
                if ((i11 & 2048) != 0) {
                    imageBucketSize2 = ImageBucketSize.DEFAULT;
                } else {
                    imageBucketSize2 = imageBucketSize;
                }
                imageLoaderContract.b(context, str, imageView2, num3, num4, bVar2, list2, hashMap, function02, function12, config2, imageBucketSize2, memoryConfigArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadImage");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f13963a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13964b;

        public b(int i10, int i11) {
            this.f13963a = i10;
            this.f13964b = i11;
        }

        public final int a() {
            return this.f13964b;
        }

        public final int b() {
            return this.f13963a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f13963a == bVar.f13963a && this.f13964b == bVar.f13964b;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f13963a) * 31) + Integer.hashCode(this.f13964b);
        }

        public String toString() {
            return "Resize(width=" + this.f13963a + ", height=" + this.f13964b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    void a(Context context, int i10, ImageView imageView, b bVar, List<? extends w9.b> list, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1);

    void b(Context context, String str, ImageView imageView, Integer num, Integer num2, b bVar, List<? extends w9.b> list, Map<String, String> map, Function0<Unit> function0, Function1<? super Bitmap, Unit> function1, Bitmap.Config config, ImageBucketSize imageBucketSize, MemoryConfig... memoryConfigArr);
}
