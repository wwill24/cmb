package lb;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;

public class a extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final int f41094a;

    public a(Context context) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(context.getColor(R.color.light_gray));
        this.f41094a = (int) context.getResources().getDimension(R.dimen.one_dp);
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.set(0, 0, 0, this.f41094a);
    }
}
