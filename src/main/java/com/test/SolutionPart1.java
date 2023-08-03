package com.test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author frankq
 * @date 2023/7/21
 */
public class SolutionPart1 {

    private static final String REG = "\\{\\{\\s*([^\\s]*)\\s*\\}\\}";
    private static final Pattern PATTERN = Pattern.compile(REG);

    public static String solution(String content, Map<String, Object> valuesMap) {
        // 使用正则表达是匹配
        Matcher matcher = PATTERN.matcher(content);
        while (true) {
            System.out.println(content);
            System.out.println(matcher.find());
            System.out.println(matcher.groupCount());
            if (matcher.find()) {
                final String group = matcher.group(1);
                System.out.println(group);
                Object value = valuesMap.getOrDefault(group, null);
                if (Objects.isNull(value)) {
                    throw new RuntimeException("An exception occurred, " +
                            "because the variable\"" + group + "\" " +
                            "is missing from the keys of the values object." );
                }
                content = matcher.replaceFirst(String.valueOf(value));
            }
            // 如果无法找到就直接跳出循环
            break;
        }
        return content;
    }

    public static void main(String[] args) {
        // TEST CASE 1
        String string = "My name is {{ name }} and I am forever {{ age }}";
        HashMap<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("name", "Bill");
        valuesMap.put("age", 21);
        final String result1 = solution(string, valuesMap);
        System.out.println(result1);
    }

}
