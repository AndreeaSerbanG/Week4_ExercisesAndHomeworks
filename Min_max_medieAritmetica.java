import java.util.Scanner;

public class Min_max_medieAritmetica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Introducerea de la tastatura a numarului n;
        System.out.println("Introduceti numarul de elemente:");
        int n = sc.nextInt();

        //Partea 1 - declarare variabile;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        //Partea 2 - declarare variabile;
        int noDivBy7 = 0;
        int noDivBy5 = 0;
        int lastDigit379 = 0;
        int digitsNo = 0;
        int firstDigit2 = 0;

        //Partea 3 - - declarare variabile;
        int minDigits =Integer.MAX_VALUE;
        int maxDigits =Integer.MIN_VALUE;
        int minDigitsNumber = Integer.MAX_VALUE;
        int maxDigitsNumber = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti numarul " + (i+1) + "/" + n + ":");
            int crtNumber = sc.nextInt();

            // Partea 1 - instructiuni;
            // Cautarea numerelor min si max;
            if (crtNumber < minValue) {
                minValue = crtNumber;
            } else if (crtNumber > maxValue) {
                maxValue = crtNumber;
            }

            // Calcularea sumei celor n numere;
            sum += crtNumber;

            //Partea 2- instructiuni;
            // Calcularea numarului de numere divizibile cu 7;
            if (crtNumber % 7 == 0) {
                noDivBy7++;
            }

            // Calcularea numarului de numere care au suma cifrelor divizibilă cu 5;
            int copyCrt = crtNumber;
            int sumDigitsCrtNumber = 0;
            int sym = 0;

            while (copyCrt != 0) {
                int lastDigit = copyCrt % 10;
                sumDigitsCrtNumber += lastDigit;
                sym = sym * 10 + lastDigit;
                digitsNo ++;
                copyCrt /= 10;
            }
            if(crtNumber == 0){
                digitsNo++;
            }
            if (sumDigitsCrtNumber % 5 == 0) {
                noDivBy5++;
            }

            //Calcularea numarului de numere care au prima cifră 2;
            if ( sym % 10 == 2){
                firstDigit2++;
            }

            //Calcularea numarului de numere care au ultima cifră 3, 7 sau 9;
            if( crtNumber !=0 ) {
                int _lastDigit = crtNumber % 10;
                if (_lastDigit == 3 || _lastDigit == 7 || _lastDigit == 9) {
                    lastDigit379 ++;
                }
            }

            //Partea 3 - instructiuni;
            //Aflarea numrelor cu numarul minim, respectiv maxim de cifre;
            int _CrtNumber = crtNumber;
            int _digitsNo = 0;
            while (_CrtNumber != 0) {
                _digitsNo++;
                _CrtNumber /= 10;

            }
            if (crtNumber == 0) {
                _digitsNo = 1;
            }
            if (_digitsNo < minDigits) {
                minDigits = _digitsNo;
                minDigitsNumber = crtNumber;
            } else if (_digitsNo > maxDigits) {
                maxDigits = _digitsNo;
                maxDigitsNumber = crtNumber;
            }
        }

        // Partea 1 - afisare rezultate;
        System.out.println("Numarul minim: " + minValue);
        System.out.println("Numarul maxim: " + maxValue);
        System.out.println("Media aritmetica: " + (sum * 1.0d / n));
        // Partea 2 - afisare rezultate;
        System.out.println("Numere divizibile cu 7: " + noDivBy7);
        System.out.println("Numere care au suma cifrelor divizibila cu 5: " + noDivBy5);
        System.out.println("Numarul de numere care au ultima cifra 3, 7 sau 9: " + lastDigit379);
        System.out.println("Numarul total de cifre ale numerelor: " + digitsNo);
        System.out.println("Numarul de numere care au prima cifra 2: " + firstDigit2);
        //Partea 3 - afisare rezultate;
        System.out.println("Numarul " + minDigitsNumber + " are cele mai putine cifre: " + minDigits);
        System.out.println("Numarul " + maxDigitsNumber + " are cele mai multe cifre: " + maxDigits);
        sc.close();
    }
}
