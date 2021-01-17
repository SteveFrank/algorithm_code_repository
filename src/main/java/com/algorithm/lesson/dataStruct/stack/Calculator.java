package com.algorithm.lesson.dataStruct.stack;

/**
 * @author yangqian
 * @date 2021/1/17
 */
public class Calculator {

    public static void main(String[] args) {
        // 完成表达式运算(处理多位数的问题)
        // 70+21*6-42
        String expression = "70+20*6-4";
        // 创建两个栈，数栈，一个符号栈
        ArrayCalculationStack numStack = new ArrayCalculationStack(10);
        ArrayCalculationStack operStack = new ArrayCalculationStack(10);
        // 定义需要的相关变量
        // 用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res  = 0;
        char ch = ' ';
        StringBuilder keepNum = new StringBuilder();
        // 开始用while循环扫描表达式
        while(true) {
            // 依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {
                // 如果是运算符
                if (!operStack.isEmpty()) {
                    // 处理
                    if (operStack.priority(ch) <= operStack.priority((char)operStack.peak())) {
                        num1 = (int) numStack.pop();
                        num2 = (int) numStack.pop();
                        oper = (char) operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                    }
                }
                operStack.push(ch);
            } else {
                // 处理数的逻辑
                keepNum.append(ch);
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum.toString()));
                } else {
                    // 当发现是数的时候不能够立即入栈，在入数栈的时候需要考虑多位数的情况, 向后再看一位，如果是数，则继续
                    // 判断下一个字符是否为数字知道为运算符才入栈
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum.toString()));
                        keepNum = new StringBuilder("");
                    }
                }

            }
            // index + 1 判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (!operStack.isEmpty()) {
            num1 = (int) numStack.pop();
            num2 = (int) numStack.pop();
            oper = (char) operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);

        }

        System.out.printf("expression:[%s], 结果为[%d]\n", expression, (int) numStack.pop());
    }

}

/**
 * 运算使用的栈
 */
class ArrayCalculationStack {
    /**
     * 栈大小
     */
    private int maxSize;
    /**
     * 数组，模拟栈
     */
    private Object[] stack;
    /**
     * top 标识栈顶指针，初始化为-1
     */
    private int top = -1;

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayCalculationStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Object value) {
        /*
         * 栈是否满
         */
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = value;
    }

    public Object pop() {
        // 栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        Object value = stack[top];
        top --;
        return value;
    }

    /**
     * 看一眼栈顶的值
     * @return
     */
    public Object peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    /**
     * 遍历栈，遍历时，需要从栈顶显示数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级使用数字标识，数字越大，优先级越高
     */
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            // 假定目前的表达式只有 +,-,*,/
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}

