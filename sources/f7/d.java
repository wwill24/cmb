package f7;

import android.database.Cursor;
import android.database.SQLException;
import com.coffeemeetsbagel.models.Bagel;
import java.util.List;

public interface d {
    Integer a(Cursor cursor) throws SQLException;

    List<Bagel> b(Cursor cursor, boolean z10) throws SQLException;
}
