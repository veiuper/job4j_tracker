package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        System.out.println("Игра 11.");
        Scanner input = new Scanner(System.in);
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = (turn) ? "Первый игрок" : "Второй игрок";
            System.out.print(player + ", введите число от 1 до 3: ");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            count -= matches;
            System.out.println("На столе осталось " + Math.max(count, 0) + " спичек.");
        }
        if (turn) {
            System.out.println("Выиграл второй игрок.");
        } else {
            System.out.println("Выиграл первый игрок.");
        }
    }
}
