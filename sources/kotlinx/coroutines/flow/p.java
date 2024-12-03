package kotlinx.coroutines.flow;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/p;", "", "Lkotlinx/coroutines/flow/r;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface p {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32480a = a.f32481a;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/p$a;", "", "Lkotlinx/coroutines/flow/p;", "b", "Lkotlinx/coroutines/flow/p;", "a", "()Lkotlinx/coroutines/flow/p;", "Eagerly", "c", "Lazily", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f32481a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final p f32482b = new q();

        /* renamed from: c  reason: collision with root package name */
        private static final p f32483c = new StartedLazily();

        private a() {
        }

        public final p a() {
            return f32482b;
        }

        public final p b() {
            return f32483c;
        }
    }

    b<SharingCommand> a(r<Integer> rVar);
}
