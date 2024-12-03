package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import java.util.HashMap;
import java.util.Map;

public class TreeNode<T> {
    public Map<ChildKey, TreeNode<T>> children = new HashMap();
    public T value;

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + "<value>: " + this.value + "\n";
        if (this.children.isEmpty()) {
            return str2 + str + "<empty>";
        }
        for (Map.Entry next : this.children.entrySet()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str);
            sb2.append(next.getKey());
            sb2.append(":\n");
            sb2.append(((TreeNode) next.getValue()).toString(str + "\t"));
            sb2.append("\n");
            str2 = sb2.toString();
        }
        return str2;
    }
}
