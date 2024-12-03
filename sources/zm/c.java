package zm;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class c {
    public static <T> T a(Set<T> set, Random random) {
        int nextInt = random.nextInt(set.size());
        Iterator<T> it = set.iterator();
        for (int i10 = 0; i10 < nextInt && it.hasNext(); i10++) {
            it.next();
        }
        return it.next();
    }
}
