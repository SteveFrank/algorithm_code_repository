package com.algorithm.lesson.dataStruct.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * 1、后缀表达式的计算
 *
 * @author yangqian
 * @date 2021/1/17
 */
public class PolandNotation {

    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        // 1、现将suffixExpression放入到ArrayList中
        // 2、将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(rpnList);
        System.out.printf("suffixExpression:[%s],结果为:[%d]", suffixExpression, calculate(rpnList));
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
