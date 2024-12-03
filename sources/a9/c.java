package a9;

import a9.d;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class c implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d.a f205a;

    public /* synthetic */ c(d.a aVar) {
        this.f205a = aVar;
    }

    public final void onComplete(Task task) {
        this.f205a.b(task);
    }
}
