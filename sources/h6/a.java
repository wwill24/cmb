package h6;

import android.content.ContentValues;
import android.database.Cursor;
import com.coffeemeetsbagel.models.Model;
import java.util.List;

public interface a<M extends Model> {
    ContentValues a();

    List<M> b(Cursor cursor);
}
