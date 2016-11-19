package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016-11-15.
 */
public class RegexChecker {
    public String check(String regexText, String stringText) {
        Pattern regexPattern = Pattern.compile(regexText);
        Matcher regexMatcher = regexPattern.matcher(stringText);

        if (regexMatcher.find())
            return ("Regex found!");
        else
            return ("Regex not found!");

    }
}
