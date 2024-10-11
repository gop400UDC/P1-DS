package e1;


public class StringGames {
    public static String bestCharacters(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Las dos cadenas deben tener la misma longitud");
        }
        int minusculasS1=0;
        int minusculasS2=0;
        int mayusculasS1=0;
        int mayusculasS2=0;
        int digitosS1=0;
        int digitosS2=0;

        for (int i=0;i<s1.length();i++) {
            char c1 =s1.charAt(i);
            char c2 =s2.charAt(i);

            if (Character.isLowerCase(c1)) {
                minusculasS1++;
            }else if(Character.isUpperCase(c1)) {
                mayusculasS1++;
            }else if(Character.isDigit(c1)) {
                digitosS1++;
            }
            if(Character.isLowerCase(c2)) {
                minusculasS2++;
            }else if(Character.isUpperCase(c2)) {
                mayusculasS2++;
            }else if(Character.isDigit(c2)) {
                digitosS2++;
            }
        }
        int puntosS1 =0;
        int puntosS2 =0;
        if(minusculasS1 > minusculasS2) {
            puntosS1++;
        }else if(minusculasS2 > minusculasS1) {
            puntosS2++;
        }

        if(mayusculasS1 > mayusculasS2) {
            puntosS1++;
        }else if(mayusculasS2 > mayusculasS1) {
            puntosS2++;
        }
        if(digitosS1 > digitosS2) {
            puntosS1++;
        }else if(digitosS2 > digitosS1) {
            puntosS2++;
        }

        return puntosS1 >= puntosS2 ? s1 : s2;
    }
    public static int crossingWords(String s1, String s2) {
        int cuenta=0;

        for (int i=0; i<s1.length();i++) {
            char c1=s1.charAt(i);

            for(int j=0;j<s2.length();j++) {
                char c2=s2.charAt(j);
                if (c1==c2) {
                    cuenta++;
                }
            }
        }

        return cuenta;
    }

    public static String wackyAlphabet(String s1, String s2) {
        if(s2.length()!=26){
            throw new IllegalArgumentException("ERROR-El segundo string no contiene todas las letras del alfabeto");
        }

        for(char c='a';c<='z';c++) {
            if (s2.indexOf(c)==-1) {
                throw new IllegalArgumentException("ERROR-El segundo string no contiene todas las letras del alfabeto");
            }
        }
        StringBuilder s3 = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {

            char c = s2.charAt(i);

            for (int j = 0; j < s1.length(); j++) {

                if (s1.charAt(j) == c) {

                    s3.append(c);

                }

            }

        }
        return s3.toString();
    }
}


