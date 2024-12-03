package j4;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class b extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final int f15585a;

    public b(int i10) {
        this.f15585a = i10;
    }

    public void g(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.z zVar) {
        rect.bottom = this.f15585a;
    }
}
