1. 实现角度：
   String 字符串常量，是不可变的对象，因此每次对 String 类型进行改变的时，等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象
   StringBuffer 字符串变量（线程安全）
   StringBuilder 字符串变量（非线程安全）
2. 执行速度、效率：StringBuilder > StringBuffer > String
3. 线程安全：StringBuilder是线程不安全的，而StringBuffer是线程安全的
   所以多线程使用字符串缓冲区时，使用StringBuffer，如果是单线程，使用StringBuiler效率更高一些。
