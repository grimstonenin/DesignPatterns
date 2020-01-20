package main.udemyDesignPatterns.CreationalDesignPatterns.Singleton;

public class EnumExample {

    enum EnumSingleton{
        INSTANCE(1);

        EnumSingleton(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
