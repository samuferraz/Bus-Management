import java.util.Arrays;

class BusManagement {
    
    // static int[] buses = {10, 20};
    // static int[] passengers = {2, 17, 18, 19};
    // static int capacity = 2;
    // // saída esperada de 16

    static int[] buses = {20, 30, 10};
    static int[] passengers = {19, 13, 26, 4, 25, 11, 21};
    static int capacity = 2;
    // saída esperada de 20

    public static void main(String[] args) {
        manageBuses();
    }

    public static void manageBuses(){
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int[] clone = passengers.clone();

        int time = 0;
        for (int bus : buses) {
            int lastPassenger = 0;
            int onBus = 0;

            for(int i = 0; i < passengers.length; i++){
                if(passengers[i] <= bus) {
                    lastPassenger = passengers[i];
                    passengers[i] = Integer.MAX_VALUE;
                    onBus++;
                }
                if(onBus == capacity) break;
            }

            if (onBus < capacity)       
                time = bus;
            else
                for(int j = 1; j < bus; j++){
                    boolean exists = false;
                    for(int i = 0; i < clone.length; i++)
                        if(lastPassenger - j == clone[i]) exists = true;

                    if(!exists) {
                        time = lastPassenger - j;
                        break;
                    }
                }
        }
        System.out.println(time);
    }
}