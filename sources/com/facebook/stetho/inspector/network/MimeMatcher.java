package com.facebook.stetho.inspector.network;

import android.annotation.SuppressLint;
import java.util.ArrayList;

public class MimeMatcher<T> {
    private final ArrayList<MimeMatcher<T>.MimeMatcherRule> mRuleMap = new ArrayList<>();

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private class MimeMatcherRule {
        private final boolean mHasWildcard;
        private final String mMatchPrefix;
        private final T mResultIfMatched;

        public MimeMatcherRule(String str, T t10) {
            if (str.endsWith("*")) {
                this.mHasWildcard = true;
                this.mMatchPrefix = str.substring(0, str.length() - 1);
            } else {
                this.mHasWildcard = false;
                this.mMatchPrefix = str;
            }
            if (!this.mMatchPrefix.contains("*")) {
                this.mResultIfMatched = t10;
                return;
            }
            throw new IllegalArgumentException("Multiple wildcards present in rule expression " + str);
        }

        public T getResultIfMatched() {
            return this.mResultIfMatched;
        }

        public boolean match(String str) {
            if (!str.startsWith(this.mMatchPrefix)) {
                return false;
            }
            if (this.mHasWildcard || str.length() == this.mMatchPrefix.length()) {
                return true;
            }
            return false;
        }
    }

    public void addRule(String str, T t10) {
        this.mRuleMap.add(new MimeMatcherRule(str, t10));
    }

    public void clear() {
        this.mRuleMap.clear();
    }

    public T match(String str) {
        int size = this.mRuleMap.size();
        for (int i10 = 0; i10 < size; i10++) {
            MimeMatcherRule mimeMatcherRule = this.mRuleMap.get(i10);
            if (mimeMatcherRule.match(str)) {
                return mimeMatcherRule.getResultIfMatched();
            }
        }
        return null;
    }
}
