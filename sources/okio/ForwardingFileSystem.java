package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0001¢\u0006\u0004\b$\u0010%J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0017\u0010\"\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "path", "", "functionName", "parameterName", "r", "s", "Lokio/FileMetadata;", "m", "dir", "", "k", "file", "Lokio/FileHandle;", "n", "Lokio/Source;", "q", "", "mustCreate", "Lokio/Sink;", "p", "mustExist", "b", "", "g", "source", "target", "c", "i", "toString", "e", "Lokio/FileSystem;", "delegate", "()Lokio/FileSystem;", "<init>", "(Lokio/FileSystem;)V", "okio"}, k = 1, mv = {1, 6, 0})
public abstract class ForwardingFileSystem extends FileSystem {

    /* renamed from: e  reason: collision with root package name */
    private final FileSystem f33346e;

    public ForwardingFileSystem(FileSystem fileSystem) {
        j.g(fileSystem, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f33346e = fileSystem;
    }

    public Sink b(Path path, boolean z10) throws IOException {
        j.g(path, "file");
        return this.f33346e.b(r(path, "appendingSink", "file"), z10);
    }

    public void c(Path path, Path path2) throws IOException {
        j.g(path, "source");
        j.g(path2, TypeProxy.INSTANCE_FIELD);
        this.f33346e.c(r(path, "atomicMove", "source"), r(path2, "atomicMove", TypeProxy.INSTANCE_FIELD));
    }

    public void g(Path path, boolean z10) throws IOException {
        j.g(path, "dir");
        this.f33346e.g(r(path, "createDirectory", "dir"), z10);
    }

    public void i(Path path, boolean z10) throws IOException {
        j.g(path, "path");
        this.f33346e.i(r(path, "delete", "path"), z10);
    }

    public List<Path> k(Path path) throws IOException {
        j.g(path, "dir");
        List<Path> k10 = this.f33346e.k(r(path, "list", "dir"));
        ArrayList arrayList = new ArrayList();
        for (Path s10 : k10) {
            arrayList.add(s(s10, "list"));
        }
        u.v(arrayList);
        return arrayList;
    }

    public FileMetadata m(Path path) throws IOException {
        j.g(path, "path");
        FileMetadata m10 = this.f33346e.m(r(path, "metadataOrNull", "path"));
        if (m10 == null) {
            return null;
        }
        if (m10.e() == null) {
            return m10;
        }
        return FileMetadata.b(m10, false, false, s(m10.e(), "metadataOrNull"), (Long) null, (Long) null, (Long) null, (Long) null, (Map) null, 251, (Object) null);
    }

    public FileHandle n(Path path) throws IOException {
        j.g(path, "file");
        return this.f33346e.n(r(path, "openReadOnly", "file"));
    }

    public Sink p(Path path, boolean z10) throws IOException {
        j.g(path, "file");
        return this.f33346e.p(r(path, "sink", "file"), z10);
    }

    public Source q(Path path) throws IOException {
        j.g(path, "file");
        return this.f33346e.q(r(path, "source", "file"));
    }

    public Path r(Path path, String str, String str2) {
        j.g(path, "path");
        j.g(str, "functionName");
        j.g(str2, "parameterName");
        return path;
    }

    public Path s(Path path, String str) {
        j.g(path, "path");
        j.g(str, "functionName");
        return path;
    }

    public String toString() {
        return l.b(getClass()).getSimpleName() + PropertyUtils.MAPPED_DELIM + this.f33346e + PropertyUtils.MAPPED_DELIM2;
    }
}
