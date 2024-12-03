package pd;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<Priority> f41792a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f41793b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f41793b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f41793b.put(Priority.VERY_LOW, 1);
        f41793b.put(Priority.HIGHEST, 2);
        for (Priority next : f41793b.keySet()) {
            f41792a.append(f41793b.get(next).intValue(), next);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f41793b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i10) {
        Priority priority = f41792a.get(i10);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
