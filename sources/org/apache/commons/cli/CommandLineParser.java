package org.apache.commons.cli;

public interface CommandLineParser {
    CommandLine parse(Options options, String[] strArr) throws ParseException;

    CommandLine parse(Options options, String[] strArr, boolean z10) throws ParseException;
}
