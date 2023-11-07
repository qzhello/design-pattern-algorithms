package qzh.overview.creation;

/**
 * 单例模式
 * 场景：
 * 1. 多线程的线程池
 * 2. 数据库链接
 * 3. 系统环境变量
 * 4. 上下文
 */
public class Singleton {
    /**
     * 双重检验锁+内存可见性
     */
    private static volatile Singleton instance = null;

    /**
     * 构造器私有，保证外部无法实例化
     */
    private Singleton() {
    }

    /**
     * 懒汉式
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 饿汉式
     */
    public static Singleton getInstance2() {
        return instance;
    }

    /**
     * 双重检查锁
     */
    public static Singleton getInstance3() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    return instance;
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类
     */
    public static Singleton getInstance4() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
}
