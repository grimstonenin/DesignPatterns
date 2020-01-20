package main.udemyDesignPatterns.CreationalDesignPatterns.Singleton;

public class LazyInitialization {

    private static LazyInitialization lazyInitialization;

    private LazyInitialization() {
        System.out.println("Lazy lazy");
    }

//    public static synchronized LazyInitialization getInstance(){
//        if (lazyInitialization == null){
//            lazyInitialization = new LazyInitialization();
//        }
//        return lazyInitialization;
//    }

    //double lock checking

    public static LazyInitialization getInstance(){
        if(lazyInitialization == null){
            synchronized (LazyInitialization.class){
                if (lazyInitialization == null){
                    lazyInitialization = new LazyInitialization();
                }
            }
        }
        return lazyInitialization;
    }
}
