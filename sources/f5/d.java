package f5;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.models.FacebookPhoto;
import java.util.ArrayList;
import java.util.List;
import r7.e;

public class d extends e {

    /* renamed from: d  reason: collision with root package name */
    private List<FacebookPhoto> f14740d = new ArrayList();

    public d(h hVar, int i10) {
        super(hVar, i10);
    }

    public String c(int i10) {
        return this.f14740d.get(i10).getSourceUrl();
    }

    public void g(List<FacebookPhoto> list) {
        this.f14740d.addAll(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f14740d.size();
    }

    public Object getItem(int i10) {
        return this.f14740d.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public String h(int i10) {
        return this.f14740d.get(i10).getId();
    }

    public String i(int i10) {
        return this.f14740d.get(i10).getSourceUrl();
    }
}
