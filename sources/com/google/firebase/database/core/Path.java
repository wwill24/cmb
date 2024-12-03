package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Path implements Iterable<ChildKey>, Comparable<Path> {
    private static final Path EMPTY_PATH = new Path("");
    /* access modifiers changed from: private */
    public final int end;
    /* access modifiers changed from: private */
    public final ChildKey[] pieces;
    /* access modifiers changed from: private */
    public final int start;

    public Path(ChildKey... childKeyArr) {
        this.pieces = (ChildKey[]) Arrays.copyOf(childKeyArr, childKeyArr.length);
        this.start = 0;
        this.end = childKeyArr.length;
        int length = childKeyArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Utilities.hardAssert(childKeyArr[i10] != null, "Can't construct a path with a null value!");
        }
    }

    public static Path getEmptyPath() {
        return EMPTY_PATH;
    }

    public static Path getRelative(Path path, Path path2) {
        ChildKey front = path.getFront();
        ChildKey front2 = path2.getFront();
        if (front == null) {
            return path2;
        }
        if (front.equals(front2)) {
            return getRelative(path.popFront(), path2.popFront());
        }
        throw new DatabaseException("INTERNAL ERROR: " + path2 + " is not contained in " + path);
    }

    public List<String> asList() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<ChildKey> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().asString());
        }
        return arrayList;
    }

    public Path child(Path path) {
        int size = size() + path.size();
        ChildKey[] childKeyArr = new ChildKey[size];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size());
        System.arraycopy(path.pieces, path.start, childKeyArr, size(), path.size());
        return new Path(childKeyArr, 0, size);
    }

    public boolean contains(Path path) {
        if (size() > path.size()) {
            return false;
        }
        int i10 = this.start;
        int i11 = path.start;
        while (i10 < this.end) {
            if (!this.pieces[i10].equals(path.pieces[i11])) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Path)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Path path = (Path) obj;
        if (size() != path.size()) {
            return false;
        }
        int i10 = this.start;
        int i11 = path.start;
        while (i10 < this.end && i11 < path.end) {
            if (!this.pieces[i10].equals(path.pieces[i11])) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public ChildKey getBack() {
        if (!isEmpty()) {
            return this.pieces[this.end - 1];
        }
        return null;
    }

    public ChildKey getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.pieces[this.start];
    }

    public Path getParent() {
        if (isEmpty()) {
            return null;
        }
        return new Path(this.pieces, this.start, this.end - 1);
    }

    public int hashCode() {
        int i10 = 0;
        for (int i11 = this.start; i11 < this.end; i11++) {
            i10 = (i10 * 37) + this.pieces[i11].hashCode();
        }
        return i10;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public Iterator<ChildKey> iterator() {
        return new Iterator<ChildKey>() {
            int offset;

            {
                this.offset = Path.this.start;
            }

            public boolean hasNext() {
                return this.offset < Path.this.end;
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }

            public ChildKey next() {
                if (hasNext()) {
                    ChildKey[] access$200 = Path.this.pieces;
                    int i10 = this.offset;
                    ChildKey childKey = access$200[i10];
                    this.offset = i10 + 1;
                    return childKey;
                }
                throw new NoSuchElementException("No more elements.");
            }
        };
    }

    public Path popFront() {
        int i10 = this.start;
        if (!isEmpty()) {
            i10++;
        }
        return new Path(this.pieces, i10, this.end);
    }

    public int size() {
        return this.end - this.start;
    }

    public String toString() {
        if (isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = this.start; i10 < this.end; i10++) {
            sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb2.append(this.pieces[i10].asString());
        }
        return sb2.toString();
    }

    public String wireFormat() {
        if (isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = this.start; i10 < this.end; i10++) {
            if (i10 > this.start) {
                sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            sb2.append(this.pieces[i10].asString());
        }
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(com.google.firebase.database.core.Path r5) {
        /*
            r4 = this;
            int r0 = r4.start
            int r1 = r5.start
        L_0x0004:
            int r2 = r4.end
            if (r0 >= r2) goto L_0x0020
            int r3 = r5.end
            if (r1 >= r3) goto L_0x0020
            com.google.firebase.database.snapshot.ChildKey[] r2 = r4.pieces
            r2 = r2[r0]
            com.google.firebase.database.snapshot.ChildKey[] r3 = r5.pieces
            r3 = r3[r1]
            int r2 = r2.compareTo((com.google.firebase.database.snapshot.ChildKey) r3)
            if (r2 == 0) goto L_0x001b
            return r2
        L_0x001b:
            int r0 = r0 + 1
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0020:
            if (r0 != r2) goto L_0x0028
            int r5 = r5.end
            if (r1 != r5) goto L_0x0028
            r5 = 0
            return r5
        L_0x0028:
            if (r0 != r2) goto L_0x002c
            r5 = -1
            return r5
        L_0x002c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Path.compareTo(com.google.firebase.database.core.Path):int");
    }

    public Path child(ChildKey childKey) {
        int size = size();
        int i10 = size + 1;
        ChildKey[] childKeyArr = new ChildKey[i10];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size);
        childKeyArr[size] = childKey;
        return new Path(childKeyArr, 0, i10);
    }

    public Path(List<String> list) {
        this.pieces = new ChildKey[list.size()];
        int i10 = 0;
        for (String fromString : list) {
            this.pieces[i10] = ChildKey.fromString(fromString);
            i10++;
        }
        this.start = 0;
        this.end = list.size();
    }

    public Path(String str) {
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int i10 = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i10++;
            }
        }
        this.pieces = new ChildKey[i10];
        int i11 = 0;
        for (String str2 : split) {
            if (str2.length() > 0) {
                this.pieces[i11] = ChildKey.fromString(str2);
                i11++;
            }
        }
        this.start = 0;
        this.end = this.pieces.length;
    }

    private Path(ChildKey[] childKeyArr, int i10, int i11) {
        this.pieces = childKeyArr;
        this.start = i10;
        this.end = i11;
    }
}
