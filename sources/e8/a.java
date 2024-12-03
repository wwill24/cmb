package e8;

import android.app.Activity;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import java.util.ArrayList;
import java.util.List;
import r7.e;

public class a extends e {

    /* renamed from: d  reason: collision with root package name */
    private List<InstagramMediaItem> f14589d = new ArrayList();

    public a(Activity activity, int i10) {
        super(activity, i10);
    }

    public String c(int i10) {
        if (this.f14589d.get(i10).images == null || this.f14589d.get(i10).images.thumbnail == null) {
            return "";
        }
        return this.f14589d.get(i10).images.thumbnail.url;
    }

    public void g(List<InstagramMediaItem> list) {
        this.f14589d.clear();
        this.f14589d.addAll(list);
    }

    public int getCount() {
        return this.f14589d.size();
    }

    public Object getItem(int i10) {
        return this.f14589d.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }
}
