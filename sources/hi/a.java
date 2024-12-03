package hi;

import com.uber.autodispose.OutsideScopeException;
import vj.j;

public interface a<E> extends j<E, E> {
    E apply(E e10) throws OutsideScopeException;
}
