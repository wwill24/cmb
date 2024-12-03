package com.coffeemeetsbagel.whatsnew;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.t;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;

public final class WhatsNewViewModel extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private a7.a f37615d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final t<List<a>> f37616e = new t<>();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f37617a;

        /* renamed from: b  reason: collision with root package name */
        private final String f37618b;

        /* renamed from: c  reason: collision with root package name */
        private final String f37619c;

        /* renamed from: d  reason: collision with root package name */
        private final String f37620d;

        /* renamed from: e  reason: collision with root package name */
        private final String f37621e;

        /* renamed from: f  reason: collision with root package name */
        private final String f37622f;

        /* renamed from: g  reason: collision with root package name */
        private final String f37623g;

        public a(int i10, String str, String str2, String str3, String str4, String str5, String str6) {
            j.g(str, "subTitle");
            j.g(str2, "title");
            j.g(str3, "imageUrl");
            j.g(str4, "description");
            j.g(str5, "primaryButton");
            j.g(str6, "secondaryButton");
            this.f37617a = i10;
            this.f37618b = str;
            this.f37619c = str2;
            this.f37620d = str3;
            this.f37621e = str4;
            this.f37622f = str5;
            this.f37623g = str6;
        }

        public final String a() {
            return this.f37621e;
        }

        public final String b() {
            return this.f37620d;
        }

        public final int c() {
            return this.f37617a;
        }

        public final String d() {
            return this.f37622f;
        }

        public final String e() {
            return this.f37623g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f37617a == aVar.f37617a && j.b(this.f37618b, aVar.f37618b) && j.b(this.f37619c, aVar.f37619c) && j.b(this.f37620d, aVar.f37620d) && j.b(this.f37621e, aVar.f37621e) && j.b(this.f37622f, aVar.f37622f) && j.b(this.f37623g, aVar.f37623g);
        }

        public final String f() {
            return this.f37618b;
        }

        public final String g() {
            return this.f37619c;
        }

        public final boolean h() {
            if (this.f37620d.length() > 0) {
                if (this.f37621e.length() > 0) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.f37617a) * 31) + this.f37618b.hashCode()) * 31) + this.f37619c.hashCode()) * 31) + this.f37620d.hashCode()) * 31) + this.f37621e.hashCode()) * 31) + this.f37622f.hashCode()) * 31) + this.f37623g.hashCode();
        }

        public String toString() {
            int i10 = this.f37617a;
            String str = this.f37618b;
            String str2 = this.f37619c;
            String str3 = this.f37620d;
            String str4 = this.f37621e;
            String str5 = this.f37622f;
            String str6 = this.f37623g;
            return "WhatsNewPage(pageIndex=" + i10 + ", subTitle=" + str + ", title=" + str2 + ", imageUrl=" + str3 + ", description=" + str4 + ", primaryButton=" + str5 + ", secondaryButton=" + str6 + ")";
        }
    }

    public WhatsNewViewModel(a7.a aVar) {
        j.g(aVar, "analyticsManager");
        this.f37615d = aVar;
        h();
    }

    private final void h() {
        s1 unused = j.d(g0.a(this), (CoroutineContext) null, (CoroutineStart) null, new WhatsNewViewModel$loadPages$1(this, (c<? super WhatsNewViewModel$loadPages$1>) null), 3, (Object) null);
    }

    public final LiveData<List<a>> g() {
        return this.f37616e;
    }

    public final void i() {
        this.f37615d.d("New Control Prompt FTUE");
    }
}
