import java.util.Scanner;

public class Descompunerea_in_cifre {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Introducerea numarului n de la tastatura;
        System.out.println("Introduceti numarul:");
        int n = sc.nextInt();

        //Declararea variabilelor necesare prelucrarii numarului n;
        int digitNo = 0;
        int sum = 0;
        int _n = n; //copie a numarului pentru prelucrare;
        int reverseN=0;
        int noEvenDigits = 0;
        int noOddDigits = 0;

        boolean onlyEvenDigits = true;
        boolean contains0 = false;
        boolean contains1 = false;
        boolean contains9 = false;
        boolean endsWith379 = false;
        boolean islastDigit = true;

        while(_n!=0){
            int lastDigit = _n % 10;

            //verificarea ultimei cifre a numarului pentru a stabili daca este 3, 7 sau 9
            if(islastDigit && (lastDigit == 3 || lastDigit == 7 || lastDigit == 9)){
                endsWith379 = true;
            }
            islastDigit = false;

            //calcularea numarului de cifre pare si impare;
            if(lastDigit % 2 == 1){
                onlyEvenDigits = false;
                noOddDigits++;
            }else{
                noEvenDigits++;
            }
            //cautarea cifrelor 0,1 si 9 in interiorul numarului;
            if(lastDigit == 0){
                contains0 = true;
            }else if(lastDigit == 1){
                contains1 = true;
            }else if(lastDigit == 9){
                contains9 = true;
            }
            digitNo++;
            sum += lastDigit;
            reverseN = reverseN * 10 + lastDigit;
            _n /= 10;
        }

        //Afisarea cifrelor in ordine crescatoare,a numarului lor, precum si a sumei acestora;
        int _digitNo = digitNo;
        System.out.print("Caracteristici principale:\nCifrele numarului sunt: ");

        while(reverseN != 0){
            int lastDigit = reverseN % 10;
            if(_digitNo != 1) {
                System.out.print(lastDigit + ", ");
            }else{
                System.out.print(lastDigit + ".\n");
            }
            reverseN /= 10;
            _digitNo--;
        }
        System.out.println("Numarul este format din " + digitNo + " cifre.");
        System.out.println("Suma cifrelor este egala cu : " + sum + ".");

        //afisarea celorlalte proprietati ale numarului n;
        System.out.println("Alte proprietati:\nContine numai cifre pare? R: " + onlyEvenDigits);

        boolean moreEvenThanOdd = noEvenDigits>noOddDigits;
        System.out.println("Contine mai multe cifre pare decat cifre impare? R: " + moreEvenThanOdd);

        boolean isSumDivBy5= (sum % 5==0);
        System.out.println("Suma cifrelor sale este divizibila cu 5? R: " + isSumDivBy5);

        boolean isDigitNoMulOf3 = (digitNo%3==0);
        System.out.println("Numarul de cifre este multiplu de 3? R: " + isDigitNoMulOf3);

        System.out.println("Numarul contine cifra 9? R: " + contains9);
        System.out.println("Numarul se termina cu oricare dintre cifrele 3,7 sau 9? R: " + endsWith379);
        System.out.println("Numarul este o cifra? R: " + (digitNo==1));
        System.out.println("Numarul contine cifra 1 si cifra 0? R: " + (contains0&&contains1));
        sc.close();
    }
}
