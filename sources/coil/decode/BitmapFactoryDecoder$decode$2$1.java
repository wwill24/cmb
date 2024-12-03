package coil.decode;

import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcoil/decode/c;", "a", "()Lcoil/decode/c;"}, k = 3, mv = {1, 7, 1})
final class BitmapFactoryDecoder$decode$2$1 extends Lambda implements Function0<c> {
    final /* synthetic */ BitmapFactoryDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BitmapFactoryDecoder$decode$2$1(BitmapFactoryDecoder bitmapFactoryDecoder) {
        super(0);
        this.this$0 = bitmapFactoryDecoder;
    }

    /* renamed from: a */
    public final c invoke() {
        return this.this$0.e(new BitmapFactory.Options());
    }
}
