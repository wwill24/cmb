package ga;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class i implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((File) obj).getName().compareTo(((File) obj2).getName());
    }
}
