package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.temporal.k;
import j$.time.temporal.l;
import java.util.Objects;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

public interface c extends k, l, Comparable {
    long g(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, Range.ATTR_OFFSET);
        LocalDateTime localDateTime = (LocalDateTime) this;
        return ((((LocalDate) localDateTime.D()).F() * 86400) + ((long) localDateTime.E().A())) - ((long) zoneOffset.r());
    }
}
