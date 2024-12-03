package coil;

import coil.ImageLoader;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcoil/memory/MemoryCache;", "a", "()Lcoil/memory/MemoryCache;"}, k = 3, mv = {1, 7, 1})
final class ImageLoader$Builder$build$1 extends Lambda implements Function0<MemoryCache> {
    final /* synthetic */ ImageLoader.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageLoader$Builder$build$1(ImageLoader.Builder builder) {
        super(0);
        this.this$0 = builder;
    }

    /* renamed from: a */
    public final MemoryCache invoke() {
        return new MemoryCache.a(this.this$0.f8021a).a();
    }
}
