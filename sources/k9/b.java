package k9;

import com.coffeemeetsbagel.models.Price;
import java.util.Arrays;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f15972b = {"Take", "ReopenChat", "InstantLike", "Boost", "PaidLike"};

    /* renamed from: a  reason: collision with root package name */
    private final a f15973a;

    public b(a aVar) {
        this.f15973a = aVar;
    }

    private boolean b(Price price) {
        if (price.getName().equals("Woo")) {
            return false;
        }
        if (price.getName().equals("InstantLike") || price.getName().equals("Take")) {
            return !this.f15973a.a("OnePaidLike.Enabled.Android");
        }
        if (price.getName().equals("PaidLike")) {
            return this.f15973a.a("OnePaidLike.Enabled.Android");
        }
        return d(price);
    }

    private boolean c(Price price) {
        if (price == null || price.getImageUrl() == null || price.getTintColor() == null || price.getName() == null) {
            return false;
        }
        return true;
    }

    private boolean d(Price price) {
        return Arrays.asList(f15972b).contains(price.getName());
    }

    public boolean a(Price price) {
        return c(price) && b(price);
    }
}
