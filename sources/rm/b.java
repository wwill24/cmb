package rm;

import org.minidns.dnssec.DnssecValidationFailedException;
import org.minidns.record.f;
import org.minidns.record.q;

public interface b {
    boolean a(byte[] bArr, q qVar, f fVar) throws DnssecValidationFailedException;
}
