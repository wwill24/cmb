package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f14380a;

    public static final class a extends w {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap) {
            super(bitmap, (DefaultConstructorMarker) null);
            j.g(bitmap, "bitmap");
        }
    }

    public static final class b extends w {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Bitmap bitmap) {
            super(bitmap, (DefaultConstructorMarker) null);
            j.g(bitmap, "bitmap");
        }
    }

    public static final class c extends w {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Bitmap bitmap) {
            super(bitmap, (DefaultConstructorMarker) null);
            j.g(bitmap, "bitmap");
        }
    }

    private w(Bitmap bitmap) {
        this.f14380a = bitmap;
    }

    public /* synthetic */ w(Bitmap bitmap, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap);
    }

    public final Bitmap a() {
        return this.f14380a;
    }
}
