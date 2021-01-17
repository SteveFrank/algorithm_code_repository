package com.algorithm.lesson.dataStruct.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * 1、后缀表达式的计算
 * 2、中缀表达式转后缀表达式的方法
 *
 * @author yangqian
 * @date 2021/1/17
 */
public class PolandNotation {

    public static void main(String[] args) {
        System.out.println("===============中缀表达式转后缀表达式-START===============");
        // 完成将一个中缀表达式转成后缀表达式的功能
        // 说明
        // 1、1+((2+3)*4)-5 => 转成 1 2 3 + 4 * + 5 -
        // 2、因为直接对str进行操作，不方便，因此先将"1+((2+3)*4)-5"=>中缀表达式对应的List
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        // 将得到的中缀表达式对应的List => 转为后缀表达式对应的List
        System.out.println(parseSuffixExpressionList(infixExpressionList));
        System.out.println("===============中缀表达式转后缀表达式-END===============");

        System.out.println("===============逆波兰表达式-START===============");
        // 先定义一个逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        // 1、现将suffixExpression放入到ArrayList中
        // 2、将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        System.out.printf("suffixExpression:[%s],结果为:[%d]", suffixExpression, calculate(rpnList));
        System.out.println("===============逆波兰表达式-END===============");
    }

    /**
     * 将一个逆波兰表达式，将数据和运算符放入到ArrayList中
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, split);
        return list;
    }

    /**
     * 中缀 =》后缀的转换
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<>();
        // 说明：因为s2这个栈在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        // 因为比较麻烦，就不再使用Stack<String> 而转为直接使用List<String> s2
        // 用于存储中间结果的list
        List<String> s2 = new ArrayList<>();
        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号，则依次弹s1的栈
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // 将s1中的向左的小括号消除
                s1.pop();
            } else {
                // 优先级的问题
                // 当item的优先级小于栈顶的运算符，将s1栈顶的运算符弹出并且加入到s2中
                // 问题: 缺少一个比较优先级的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈中
                s1.push(item);
            }
        }
        // 将s1剩余的元素压入s2
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 方法: 将中缀表达式转成对应的List
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        // 一个指针，用于遍历中缀表达式字符串
        int i = 0;
        // 对多位数拼接
        String str;
        // 每遍历一个字符，就放入到c
        char c;
        do {
            // 如果c是一个非数字，则加入大ls中
            if ((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                // 如果是一个数字，需要考虑多位数的问题
                // 先将str置为空字符串
                str = "";
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    // 拼接到字符串上
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    /**
     * 完成逆波兰表达式的运算
     *  1)从左至右扫描，将3和4压入堆栈；
     *  2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     *	3)将5入栈；
     *	4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     *	5)将6入栈；
     *	6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        // 创建一个栈，只需要一个栈即可
        final Stack<String> stack = new Stack<>();
        // 遍历list
        for (String item : ls) {
            // 使用正则表达是取出数
            if (item.matches("\\d+")) {
                // 匹配多位数
                stack.push(item);
            } else {
                // pop出两个数，并进行运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(res));
            }
        }
        // 最有留在stack中的数据为结果
        return Integer.parseInt(stack.pop());
    }

}

/**
 * 编写一个类 Operation 返回一个运算符对应的优先级
 */
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
