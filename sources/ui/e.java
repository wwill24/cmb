package ui;

import androidx.lifecycle.a0;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class e implements a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f33887d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a0 f33888a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<StepData> f33889b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33890c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(a0 a0Var) {
        j.g(a0Var, "savedStateHandle");
        this.f33888a = a0Var;
        ArrayList<StepData> arrayList = (ArrayList) a0Var.e("com.withpersona.sdk2.inquiry.shared.data_collection.RealDataCollector.collectedData");
        this.f33889b = arrayList == null ? new ArrayList<>() : arrayList;
        this.f33890c = true;
    }

    public boolean a() {
        return this.f33890c;
    }

    public void b(StepData stepData) {
        j.g(stepData, "stepData");
        this.f33889b.add(stepData);
        this.f33888a.i("com.withpersona.sdk2.inquiry.shared.data_collection.RealDataCollector.collectedData", this.f33889b);
    }

    public ArrayList<StepData> c() {
        return new ArrayList<>(this.f33889b);
    }
}
