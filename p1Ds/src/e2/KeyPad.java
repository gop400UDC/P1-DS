package e2 ;


public class KeyPad {
    public static boolean isValidKeyPad(char[][] keyPad) {
        if (keyPad == null) {
            return false;
        }

        int rows = keyPad.length;
        int cols = -1;

        // Verificar si el teclado es rectangular
        for (int i = 0; i < rows; i++) {
            if (keyPad[i]==null ) {
                return false;
            }
            if(cols==-1){
                cols=keyPad[i].length;
            }else if(keyPad[i].length!=cols){
                return false;
            }

        }

        // Verificar si el número en la esquina superior izquierda es el 1
        if (keyPad[0][0] != '1') {
            return false;
        }

        // Verificar si la secuencia de números y letras es correcta
        int num = 1;
        for(int i = 0; i < rows; i++) {

            for (int j = 0; j < keyPad[i].length; j++) {
                if (num <= 9) {
                    if (keyPad[i][j] != (char) (num + '0')) {
                        return false;
                    }
                    num++;
                } else {
                    if (keyPad[i][j] != (char) (num - 10 + 'A')) {
                        return false;
                    }
                    num++;
                }
            }
        }

        return true;
    }

    public static boolean areValidMovements(String[] movements) {
        if (movements == null) {
            return false;
        }

        for (String movement : movements) {
            if (movement == null || movement.isEmpty()) {
                return false;
            }

            for (char c : movement.toCharArray()) {
                if (c != 'U' && c != 'D' && c != 'L' && c != 'R') {
                    return false;
                }
            }
        }

        return true;
    }

    public static String obtainCode(char[][] keyPad, String[] movements) {
        
        int rows = keyPad.length;
        int cols = keyPad[0].length;
        int row = 0;
        int col = 0;
        StringBuilder code = new StringBuilder();

        for (String movement : movements) {
            for (char c : movement.toCharArray()) {
                switch (c) {
                    case 'U':
                        if (row > 0) {
                            row--;
                        }
                        break;
                    case 'D':
                        if (row < rows - 1) {
                            row++;
                        }
                        break;
                    case 'L':
                        if (col > 0) {
                            col--;
                        }
                        break;
                    case 'R':
                        if (col < cols - 1) {
                            col++;
                        }
                        break;
                }
            }

            code.append(keyPad[row][col]);
        }

        return code.toString();
    }
}
