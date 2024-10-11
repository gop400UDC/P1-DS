package e1;

import java.util.HashSet;

import java.util.Set;

public class StringGames {

    // Método 1: Determina cuál String gana en más categorías
    public static String bestCharacters(String str1, String str2) {
        if (str1.length() != str2.length()) {
            throw new IllegalArgumentException("Las cadenas deben tener la misma longitud.");
        }

        int[] scores = new int[3]; // 0: minúsculas, 1: mayúsculas, 2: dígitos

        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLowerCase(str1.charAt(i))) scores[0]++;
            if (Character.isUpperCase(str1.charAt(i))) scores[1]++;
            if (Character.isDigit(str1.charAt(i))) scores[2]++;

            if (Character.isLowerCase(str2.charAt(i))) scores[0]--;
            if (Character.isUpperCase(str2.charAt(i))) scores[1]--;
            if (Character.isDigit(str2.charAt(i))) scores[2]--;
        }

        // Determinar el ganador basado en la cantidad de categorías ganadas
        int str1Wins = 0;
        int str2Wins = 0;

        for (int score : scores) {
            if (score > 0) str1Wins++;
            else if (score < 0) str2Wins++;
        }

        if (str1Wins > str2Wins) return str1;
        if (str2Wins > str1Wins) return str2;
        return str2; // En caso de empate, devolver str2
    }

    // Método 2: Determina cuántas letras comparten dos Strings
    public static int crossingWords(String str1, String str2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : str1.toCharArray()) {
            set1.add(c);
        }
        for (char c : str2.toCharArray()) {
            set2.add(c);
        }

        set1.retainAll(set2); // Conserva solo los elementos que están en ambos sets

        return set1.size();
    }

    // Método 3: Reordena el primer String según el segundo String
    public static String wackyAlphabet(String str1, String str2) {
        if (str2.length() != 26) {
            throw new IllegalArgumentException("El segundo String debe contener todas las letras del alfabeto.");
        }

        StringBuilder sortedString = new StringBuilder();
        Set<Character> addedChars = new HashSet<>();

        // Reordenar según el segundo String
        for (char c : str2.toCharArray()) {
            for (char ch : str1.toCharArray()) {
                if (ch == c && !addedChars.contains(ch)) {
                    sortedString.append(ch);
                    addedChars.add(ch);
                }
            }
        }

        // Agregar los caracteres que no están en str2
        for (char ch : str1.toCharArray()) {
            if (!addedChars.contains(ch)) {
                sortedString.append(ch);
            }
        }

        return sortedString.toString();
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        // Pruebas manuales (opcional)
        System.out.println(bestCharacters("ABC123", "a12345")); // Debería imprimir "a12345"
        System.out.println(crossingWords("abc", "bcd")); // Debería imprimir 2
        System.out.println(wackyAlphabet("hello", "zyxwvutsrqponmlkjihgfedcba")); // Debería imprimir "ollhe"
    }
}




