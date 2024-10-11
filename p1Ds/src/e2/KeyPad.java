package e2;

public class KeyPad {
        private final char[][] keypad;
        private final int rows;
        private final int cols;

        // Constructor que inicializa el teclado
        public KeyPad(boolean fillByRows, int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.keypad = new char[rows][cols];
            fillKeypad(fillByRows);
        }

    public static boolean isValidKeyPad(char[][] keyPad1) {
        return false;
    }

    public static boolean areValidMovements(String[] wrongNumber) {
        return false;
    }

    public static String obtainCode(char[][] keyPad7, String[] input0) {
        return "";
    }

    // Método para llenar el teclado
        private void fillKeypad(boolean fillByRows) {
            String sequence = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            int index = 0;

            if (fillByRows) {
                // Llenar el teclado por filas
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (index < sequence.length()) {
                            keypad[i][j] = sequence.charAt(index++);
                        }
                    }
                }
            } else {
                // Llenar el teclado por columnas
                for (int j = 0; j < cols; j++) {
                    for (int i = 0; i < rows; i++) {
                        if (index < sequence.length()) {
                            keypad[i][j] = sequence.charAt(index++);
                        }
                    }
                }
            }
        }

        // Método para ejecutar los movimientos y obtener la clave
        public String getKeyFromMovements(String movements) {
            StringBuilder key = new StringBuilder();
            int x = 0; // Fila inicial
            int y = 0; // Columna inicial

            // Añadimos el primer número de la clave
            key.append(keypad[x][y]);

            // Procesar cada movimiento
            for (char move : movements.toCharArray()) {
                switch (move) {
                    case 'U':
                        if (x > 0) x--; // Movimiento hacia arriba
                        break;
                    case 'D':
                        if (x < rows - 1) x++; // Movimiento hacia abajo
                        break;
                    case 'L':
                        if (y > 0) y--; // Movimiento hacia la izquierda
                        break;
                    case 'R':
                        if (y < cols - 1) y++; // Movimiento hacia la derecha
                        break;
                }
                // Añadir el número correspondiente en la nueva posición
                key.append(keypad[x][y]);
            }

            return key.toString();
        }

        public static void main(String[] args) {
            // Crear un teclado de 4 filas y 3 columnas, llenado por filas
            KeyPad keypad = new KeyPad(true, 4, 3);

            // Definir las secuencias de movimientos
            String[] movements = {
                    "RD",     // Para el primer número
                    "DRUU",   // Para el segundo número
                    "LLD",    // Para el tercer número
                    "D"       // Para el cuarto número
            };

            // Ejecutar los movimientos y construir la clave
            StringBuilder finalKey = new StringBuilder();
            for (String movement : movements) {
                finalKey.append(keypad.getKeyFromMovements(movement));
            }

            // Mostrar la clave final
            System.out.println("La clave es: " + finalKey);
        }
}
