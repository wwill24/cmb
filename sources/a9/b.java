package a9;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f203a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f204b;

    public /* synthetic */ b(d dVar, long j10) {
        this.f203a = dVar;
        this.f204b = j10;
    }

    public final void onComplete(Task task) {
        this.f203a.F(this.f204b, task);
    }
}
