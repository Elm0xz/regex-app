package regexcheck;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016-11-15.
 */
public class RegexChecker extends ExpChecker {

    public RegexChecker() {}

    public String check(String regexText, String stringText) {
        Pattern regexPattern = Pattern.compile(regexText);
        Matcher regexMatcher = regexPattern.matcher(stringText);
        TreeMap<Integer,String> matchedMap = new TreeMap<>();
        int matchCounter = 0;

        while(!regexMatcher.hitEnd())
        {
            if (regexMatcher.find())
            {
                matchedMap.put(regexMatcher.end(),regexMatcher.group());
                matchCounter++;
                //matchedArray.add(regexMatcher.group());
            }
        }
        StringBuilder resultBuilder = new StringBuilder(matchCounter + " expressions found: \n");
        for (Map.Entry<Integer,String> entry : matchedMap.entrySet())
        {
            resultBuilder.append("Position: " + entry.getKey() + ", value: " + entry.getValue() + "\n");
        }
        //resultBuilder.append(matchedMap.toString());
        resultBuilder.append("\n\n" + stringText);
        /*if (regexMatcher.find())
            return ("Regex found! " + regexMatcher.group());
        else
            return ("Regex not found!");*/
        //return matchedArray.toString();

        return resultBuilder.toString();

    }
}
