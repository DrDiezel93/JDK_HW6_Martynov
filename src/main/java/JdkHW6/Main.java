package JdkHW6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    static int doors = 3;
    static int quantity = 1000;
    public static void main(String[] args) {
        int countWinner = 0;
        int countLoser = 0;
        for (int i = 0; i < processingGame().size(); i++) {
            if (processingGame().get(i + 1)) {
                countWinner++;
            } else {
                countLoser++;
            }
        }
        System.out.println("Выигрышных комбинаций: " + countWinner + "\nПроигрышных комбинаций: " + countLoser);

        double percentWinner = (double) (countWinner * 100) / quantity;
        double percentLoser = (double) (countLoser * 100) / quantity;
        System.out.println("% выигрышных комбинаций: " + percentWinner + "\n% проигрышных комбинаций: " + percentLoser);
    }

    public static Map<Integer, Boolean> processingGame() {
        int counter = 0;
        Map<Integer, Boolean> result = new HashMap<>();
        while (counter < quantity) {
            int winningDoor = new Random().nextInt(doors) + 1;
            int selectedDoor = new Random().nextInt(doors) + 1;
            result.put(counter + 1, resultGame(winningDoor, selectedDoor));
            counter++;
        }
        return result;
    }

    public static boolean resultGame(int winningDoor, int selectedDoor) {
        int newDoor = new Random().nextInt(2); // Случайный выбор решения: менять или не менять
        if (winningDoor == selectedDoor) {
            return newDoor == 0;
        }
        return newDoor == 1;
    }
}