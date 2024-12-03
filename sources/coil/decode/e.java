package coil.decode;

import coil.ImageLoader;
import coil.fetch.l;
import coil.request.k;
import kotlin.Metadata;
import kotlin.coroutines.c;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0003J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcoil/decode/e;", "", "Lcoil/decode/c;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface e {

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcoil/decode/e$a;", "", "Lcoil/fetch/l;", "result", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/decode/e;", "a", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public interface a {
        e a(l lVar, k kVar, ImageLoader imageLoader);
    }

    Object a(c<? super c> cVar);
}
