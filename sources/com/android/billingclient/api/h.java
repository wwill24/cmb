package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzm;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;

public class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f8914a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f8915b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f8916c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f8917d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public zzu f8918e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f8919f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f8920g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8921a;

        /* renamed from: b  reason: collision with root package name */
        private String f8922b;

        /* renamed from: c  reason: collision with root package name */
        private List f8923c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList f8924d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8925e;

        /* renamed from: f  reason: collision with root package name */
        private c.a f8926f;

        /* synthetic */ a(l0 l0Var) {
            c.a a10 = c.a();
            c.a unused = a10.f8936c = true;
            this.f8926f = a10;
        }

        @NonNull
        public h a() {
            boolean z10;
            boolean z11;
            ArrayList arrayList;
            zzu zzu;
            ArrayList arrayList2 = this.f8924d;
            boolean z12 = true;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            List list = this.f8923c;
            if (list == null || list.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z10 && !z11) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            } else if (!z10 || !z11) {
                if (!z10) {
                    b bVar = (b) this.f8923c.get(0);
                    int i10 = 0;
                    while (i10 < this.f8923c.size()) {
                        b bVar2 = (b) this.f8923c.get(i10);
                        if (bVar2 == null) {
                            throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                        } else if (i10 == 0 || bVar2.b().c().equals(bVar.b().c()) || bVar2.b().c().equals("play_pass_subs")) {
                            i10++;
                        } else {
                            throw new IllegalArgumentException("All products should have same ProductType.");
                        }
                    }
                    String e10 = bVar.b().e();
                    for (b bVar3 : this.f8923c) {
                        if (!bVar.b().c().equals("play_pass_subs") && !bVar3.b().c().equals("play_pass_subs") && !e10.equals(bVar3.b().e())) {
                            throw new IllegalArgumentException("All products must have the same package name.");
                        }
                    }
                } else if (this.f8924d.contains((Object) null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                } else if (this.f8924d.size() > 1) {
                    SkuDetails skuDetails = (SkuDetails) this.f8924d.get(0);
                    String b10 = skuDetails.b();
                    ArrayList arrayList3 = this.f8924d;
                    int size = arrayList3.size();
                    int i11 = 0;
                    while (i11 < size) {
                        SkuDetails skuDetails2 = (SkuDetails) arrayList3.get(i11);
                        if (b10.equals("play_pass_subs") || skuDetails2.b().equals("play_pass_subs") || b10.equals(skuDetails2.b())) {
                            i11++;
                        } else {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    String f10 = skuDetails.f();
                    ArrayList arrayList4 = this.f8924d;
                    int size2 = arrayList4.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        SkuDetails skuDetails3 = (SkuDetails) arrayList4.get(i12);
                        if (b10.equals("play_pass_subs") || skuDetails3.b().equals("play_pass_subs") || f10.equals(skuDetails3.f())) {
                            i12++;
                        } else {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
                h hVar = new h((q0) null);
                if ((!z10 || ((SkuDetails) this.f8924d.get(0)).f().isEmpty()) && (!z11 || ((b) this.f8923c.get(0)).b().e().isEmpty())) {
                    z12 = false;
                }
                hVar.f8914a = z12;
                hVar.f8915b = this.f8921a;
                hVar.f8916c = this.f8922b;
                hVar.f8917d = this.f8926f.a();
                ArrayList arrayList5 = this.f8924d;
                if (arrayList5 != null) {
                    arrayList = new ArrayList(arrayList5);
                } else {
                    arrayList = new ArrayList();
                }
                hVar.f8919f = arrayList;
                hVar.f8920g = this.f8925e;
                List list2 = this.f8923c;
                if (list2 != null) {
                    zzu = zzu.zzj(list2);
                } else {
                    zzu = zzu.zzk();
                }
                hVar.f8918e = zzu;
                return hVar;
            } else {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
        }

        @NonNull
        public a b(@NonNull String str) {
            this.f8921a = str;
            return this;
        }

        @NonNull
        public a c(@NonNull String str) {
            this.f8922b = str;
            return this;
        }

        @NonNull
        public a d(@NonNull List<b> list) {
            this.f8923c = new ArrayList(list);
            return this;
        }

        @NonNull
        public a e(@NonNull c cVar) {
            this.f8926f = c.c(cVar);
            return this;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final o f8927a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8928b;

        public static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public o f8929a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f8930b;

            /* synthetic */ a(m0 m0Var) {
            }

            @NonNull
            public b a() {
                zzm.zzc(this.f8929a, "ProductDetails is required for constructing ProductDetailsParams.");
                zzm.zzc(this.f8930b, "offerToken is required for constructing ProductDetailsParams.");
                return new b(this, (n0) null);
            }

            @NonNull
            public a b(@NonNull String str) {
                this.f8930b = str;
                return this;
            }

            @NonNull
            public a c(@NonNull o oVar) {
                this.f8929a = oVar;
                if (oVar.a() != null) {
                    oVar.a().getClass();
                    this.f8930b = oVar.a().d();
                }
                return this;
            }
        }

        /* synthetic */ b(a aVar, n0 n0Var) {
            this.f8927a = aVar.f8929a;
            this.f8928b = aVar.f8930b;
        }

        @NonNull
        public static a a() {
            return new a((m0) null);
        }

        @NonNull
        public final o b() {
            return this.f8927a;
        }

        @NonNull
        public final String c() {
            return this.f8928b;
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f8931a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f8932b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f8933c = 0;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private String f8934a;

            /* renamed from: b  reason: collision with root package name */
            private String f8935b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f8936c;

            /* renamed from: d  reason: collision with root package name */
            private int f8937d = 0;

            /* synthetic */ a(o0 o0Var) {
            }

            @NonNull
            public c a() {
                boolean z10;
                if (!TextUtils.isEmpty(this.f8934a) || !TextUtils.isEmpty((CharSequence) null)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean isEmpty = true ^ TextUtils.isEmpty(this.f8935b);
                if (z10 && isEmpty) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                } else if (this.f8936c || z10 || isEmpty) {
                    c cVar = new c((p0) null);
                    cVar.f8931a = this.f8934a;
                    cVar.f8933c = this.f8937d;
                    cVar.f8932b = this.f8935b;
                    return cVar;
                } else {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
            }

            @NonNull
            public a b(@NonNull String str) {
                this.f8934a = str;
                return this;
            }

            @NonNull
            @Deprecated
            public a c(@NonNull String str) {
                this.f8934a = str;
                return this;
            }

            @NonNull
            public a d(@NonNull String str) {
                this.f8935b = str;
                return this;
            }

            @NonNull
            public a e(int i10) {
                this.f8937d = i10;
                return this;
            }

            @NonNull
            @Deprecated
            public a f(int i10) {
                this.f8937d = i10;
                return this;
            }
        }

        /* synthetic */ c(p0 p0Var) {
        }

        @NonNull
        public static a a() {
            return new a((o0) null);
        }

        static /* bridge */ /* synthetic */ a c(c cVar) {
            a a10 = a();
            a10.c(cVar.f8931a);
            a10.f(cVar.f8933c);
            a10.d(cVar.f8932b);
            return a10;
        }

        /* access modifiers changed from: package-private */
        public final int b() {
            return this.f8933c;
        }

        /* access modifiers changed from: package-private */
        public final String d() {
            return this.f8931a;
        }

        /* access modifiers changed from: package-private */
        public final String e() {
            return this.f8932b;
        }
    }

    /* synthetic */ h(q0 q0Var) {
    }

    @NonNull
    public static a a() {
        return new a((l0) null);
    }

    public final int b() {
        return this.f8917d.b();
    }

    public final String c() {
        return this.f8915b;
    }

    public final String d() {
        return this.f8916c;
    }

    public final String e() {
        return this.f8917d.d();
    }

    public final String f() {
        return this.f8917d.e();
    }

    @NonNull
    public final ArrayList g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f8919f);
        return arrayList;
    }

    @NonNull
    public final List h() {
        return this.f8918e;
    }

    public final boolean p() {
        return this.f8920g;
    }

    /* access modifiers changed from: package-private */
    public final boolean q() {
        if (this.f8915b == null && this.f8916c == null && this.f8917d.e() == null && this.f8917d.b() == 0 && !this.f8914a && !this.f8920g) {
            return false;
        }
        return true;
    }
}
