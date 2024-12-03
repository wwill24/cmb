package com.airbnb.lottie.model.content;

import c3.f;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.l;
import y2.c;

public class MergePaths implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8644a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f8645b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8646c;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode b(int i10) {
            if (i10 == 1) {
                return MERGE;
            }
            if (i10 == 2) {
                return ADD;
            }
            if (i10 == 3) {
                return SUBTRACT;
            }
            if (i10 == 4) {
                return INTERSECT;
            }
            if (i10 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f8644a = str;
        this.f8645b = mergePathsMode;
        this.f8646c = z10;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        if (lottieDrawable.A()) {
            return new l(this);
        }
        f.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f8645b;
    }

    public String c() {
        return this.f8644a;
    }

    public boolean d() {
        return this.f8646c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f8645b + '}';
    }
}
