package p3;

import androidx.annotation.NonNull;
import f4.g;
import f4.k;
import java.util.Queue;

public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final g<b<A>, B> f16950a;

    class a extends g<b<A>, B> {
        a(long j10) {
            super(j10);
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public void j(@NonNull b<A> bVar, B b10) {
            bVar.c();
        }
    }

    static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f16952d = k.e(0);

        /* renamed from: a  reason: collision with root package name */
        private int f16953a;

        /* renamed from: b  reason: collision with root package name */
        private int f16954b;

        /* renamed from: c  reason: collision with root package name */
        private A f16955c;

        private b() {
        }

        static <A> b<A> a(A a10, int i10, int i11) {
            b<A> poll;
            Queue<b<?>> queue = f16952d;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new b<>();
            }
            poll.b(a10, i10, i11);
            return poll;
        }

        private void b(A a10, int i10, int i11) {
            this.f16955c = a10;
            this.f16954b = i10;
            this.f16953a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f16952d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f16954b == bVar.f16954b && this.f16953a == bVar.f16953a && this.f16955c.equals(bVar.f16955c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f16953a * 31) + this.f16954b) * 31) + this.f16955c.hashCode();
        }
    }

    public m(long j10) {
        this.f16950a = new a(j10);
    }

    public B a(A a10, int i10, int i11) {
        b a11 = b.a(a10, i10, i11);
        B g10 = this.f16950a.g(a11);
        a11.c();
        return g10;
    }

    public void b(A a10, int i10, int i11, B b10) {
        this.f16950a.k(b.a(a10, i10, i11), b10);
    }
}
