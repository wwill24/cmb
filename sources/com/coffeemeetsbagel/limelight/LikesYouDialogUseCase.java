package com.coffeemeetsbagel.limelight;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import hb.c;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.w;

public final class LikesYouDialogUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final LikesYouMatchRepository f34337a;

    /* renamed from: b  reason: collision with root package name */
    private final a6.a f34338b;

    /* renamed from: c  reason: collision with root package name */
    private final c f34339c;

    /* renamed from: d  reason: collision with root package name */
    private final ProfileContract$Manager f34340d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f34341a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f34342b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34343c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f34344d;

        public a(int i10, List<String> list, boolean z10, boolean z11) {
            j.g(list, "imageUrlList");
            this.f34341a = i10;
            this.f34342b = list;
            this.f34343c = z10;
            this.f34344d = z11;
        }

        public final List<String> a() {
            return this.f34342b;
        }

        public final boolean b() {
            return this.f34344d;
        }

        public final int c() {
            return this.f34341a;
        }

        public final boolean d() {
            return this.f34343c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f34341a == aVar.f34341a && j.b(this.f34342b, aVar.f34342b) && this.f34343c == aVar.f34343c && this.f34344d == aVar.f34344d;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.f34341a) * 31) + this.f34342b.hashCode()) * 31;
            boolean z10 = this.f34343c;
            boolean z11 = true;
            if (z10) {
                z10 = true;
            }
            int i10 = (hashCode + (z10 ? 1 : 0)) * 31;
            boolean z12 = this.f34344d;
            if (!z12) {
                z11 = z12;
            }
            return i10 + (z11 ? 1 : 0);
        }

        public String toString() {
            int i10 = this.f34341a;
            List<String> list = this.f34342b;
            boolean z10 = this.f34343c;
            boolean z11 = this.f34344d;
            return "LikesYouDialogInfo(size=" + i10 + ", imageUrlList=" + list + ", isFirstLike=" + z10 + ", shouldShowDialog=" + z11 + ")";
        }
    }

    public LikesYouDialogUseCase(LikesYouMatchRepository likesYouMatchRepository, a6.a aVar, c cVar, ProfileContract$Manager profileContract$Manager) {
        j.g(likesYouMatchRepository, "likesYouMatchRepository");
        j.g(aVar, "coachmarkManager");
        j.g(cVar, "sharedPrefsManager");
        j.g(profileContract$Manager, "profileManager");
        this.f34337a = likesYouMatchRepository;
        this.f34338b = aVar;
        this.f34339c = cVar;
        this.f34340d = profileContract$Manager;
    }

    /* access modifiers changed from: private */
    public static final a f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final a6.a b() {
        return this.f34338b;
    }

    public final ProfileContract$Manager c() {
        return this.f34340d;
    }

    public final c d() {
        return this.f34339c;
    }

    public final w<a> e() {
        w<R> K = this.f34337a.x().D(new a(new LikesYouDialogUseCase$invoke$1(this))).K(sj.a.a());
        j.f(K, "operator fun invoke(): S…dSchedulers.mainThread())");
        return K;
    }
}
