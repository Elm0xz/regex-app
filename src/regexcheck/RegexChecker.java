package regexcheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016-11-15.
 */
public class RegexChecker {
    public String check(String regexText, String stringText) {
        Pattern regexPattern = Pattern.compile(regexText);
        Matcher regexMatcher = regexPattern.matcher(stringText);
        HashMap<Integer,String> matchedMap = new HashMap<>();

        while(!regexMatcher.hitEnd())
        {
            if (regexMatcher.find())
            {
                matchedMap.put(regexMatcher.end(),regexMatcher.group());
                //matchedArray.add(regexMatcher.group());
            }
        }
        /*if (regexMatcher.find())
            return ("Regex found! " + regexMatcher.group());
        else
            return ("Regex not found!");*/
        //return matchedArray.toString();
        return matchedMap.toString();

    }
}
