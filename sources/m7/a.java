package m7;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.StickerNetwork;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import w9.b;

public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<StickerNetwork> f16340a;

    /* renamed from: b  reason: collision with root package name */
    private Context f16341b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f16342c;

    public a(List<StickerNetwork> list, Context context) {
        this.f16340a = list;
        this.f16341b = context;
    }

    public int getCount() {
        return this.f16340a.size();
    }

    public Object getItem(int i10) {
        return this.f16340a.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (this.f16342c == null) {
            this.f16342c = (LayoutInflater) this.f16341b.getSystemService("layout_inflater");
        }
        LinearLayout linearLayout = (LinearLayout) this.f16342c.inflate(R.layout.sticker_item, (ViewGroup) null);
        b.f13967a.b(this.f16341b, this.f16340a.get(i10).getImageUrl(), (ImageView) linearLayout.findViewById(R.id.sticker_image), (Integer) null, Integer.valueOf(R.drawable.sticker_placeholder), (ImageLoaderContract.b) null, Collections.singletonList(b.a.f18329a), Collections.emptyMap(), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
        return linearLayout;
    }
}
