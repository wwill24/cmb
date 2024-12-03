package i9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import java.util.ArrayList;
import java.util.List;

public class b extends RecyclerView.Adapter<a> {

    /* renamed from: d  reason: collision with root package name */
    private List<String> f15520d = new ArrayList();

    public static class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        TextView f15521u;

        public a(View view) {
            super(view);
            this.f15521u = (TextView) view.findViewById(R.id.text);
        }

        public void V(String str) {
            this.f15521u.setText(str);
        }
    }

    /* renamed from: G */
    public void v(a aVar, int i10) {
        aVar.V(this.f15520d.get(i10));
    }

    /* renamed from: H */
    public a x(ViewGroup viewGroup, int i10) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_log_line, viewGroup, false));
    }

    public void I(List<String> list) {
        this.f15520d = list;
    }

    public int g() {
        return this.f15520d.size();
    }
}
