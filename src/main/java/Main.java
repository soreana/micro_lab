import java.util.*;

public class Main {
    private static ArrayList<String> participates;
    private static Scanner console = new Scanner(System.in);
    private static int[] questions;

    static {
        participates = new ArrayList<>();
        participates.add("آیسا جوادزاد");
        participates.add("سینا کاشی پزها");
        participates.add("ساسان یساری");
        participates.add("سهند عصری");
        participates.add("محمد دبستانی");
    }

    private static int readQuestionNumbers() {
        System.out.println(("Enter number of questions :"));
        while (true) {
            try {
                return console.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println((console.next() + " is not a number.\nPlease enter a valid number:"));
            }
        }
    }

    private static int abjadKabirToInt(String string) {
        string = string.replaceAll("ا", "1").replaceAll("آ", "1")
                .replaceAll("ب", "2").replaceAll("ج", "3")
                .replaceAll("د", "4").replaceAll("ه", "5")
                .replaceAll("و", "6").replaceAll("ز", "7")
                .replaceAll("ح", "8").replaceAll("ط", "9")
                .replaceAll("ی", "10").replaceAll("ي", "10")
                .replaceAll("ک", "11").replaceAll("ل", "12")
                .replaceAll("م", "13").replaceAll("ن", "14")
                .replaceAll("س", "15").replaceAll("ع", "16")
                .replaceAll("ف", "17").replaceAll("ص", "18")
                .replaceAll("ق", "19").replaceAll("ر", "20")
                .replaceAll("ش", "21").replaceAll("ت", "22")
                .replaceAll("ث", "23").replaceAll("خ", "24")
                .replaceAll("ذ", "25").replaceAll("ض", "26")
                .replaceAll("ظ", "27").replaceAll("غ", "28");
        return Integer.parseInt(string);
    }

    private static String intToAbjadKabir(int number) {
        return String.valueOf(number).replaceAll("1", "آ")
                .replaceAll("2", "ب").replaceAll("3", "ج")
                .replaceAll("4", "د").replaceAll("5", "ه")
                .replaceAll("6", "و").replaceAll("7", "ز")
                .replaceAll("8", "ح").replaceAll("9", "ط")
                .replaceAll("10", "ی").replaceAll("10", "ي")
                .replaceAll("11", "ک").replaceAll("12", "ل")
                .replaceAll("13", "م").replaceAll("14", "ن")
                .replaceAll("15", "س").replaceAll("16", "ع")
                .replaceAll("17", "ف").replaceAll("18", "ص")
                .replaceAll("19", "ق").replaceAll("20", "ر")
                .replaceAll("21", "ش").replaceAll("22", "ت")
                .replaceAll("23", "ث").replaceAll("24", "خ")
                .replaceAll("25", "ذ").replaceAll("26", "ض")
                .replaceAll("27", "ظ").replaceAll("28", "غ");
    }

    private static String questionNumber(int n) {
        for (int i = 1; i < questions.length; i++) {
            n -= questions[i];
            if (n <= 0)
                return String.valueOf(i);
        }
        return null;
    }

    private static String indentNumber(int n) {
        for (int i = 1; i < questions.length; i++) {
            n -= questions[i];
            if (n <= 0)
                return intToAbjadKabir(n + questions[i]);
        }
        return null;
    }

    private static String from(int index, double portion) {
        int temp = (int) (Math.floor(index * portion) + 1);
        return "from " + indentNumber(temp) + " in question " + questionNumber(temp);
    }

    private static String to(int index, double portion) {
        int temp = (int) Math.floor((index + 1) * portion);
        return "to " + indentNumber(temp) + " in question " + questionNumber(temp);
    }

    public static void main(String[] args) {
        int questionNumbers = readQuestionNumbers();
        int indentNumbers = 0;
        questions = new int[questionNumbers + 1];

        for (int i = 1; i <= questionNumbers; i++) {
            System.out.println(("Please enter last indent letter for question " + i + " (for example ط)"));
            questions[i] = abjadKabirToInt(console.next());
            indentNumbers += questions[i];
        }

        Collections.shuffle(participates);

        double portion = (double) indentNumbers / participates.size();

        for (int i = 0; i < participates.size(); i++)
            System.out.println(from(i, portion) + " " + to(i, portion) + " for " + participates.get(i));
    }
}