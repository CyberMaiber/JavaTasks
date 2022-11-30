import java.io.*;

public class program {

    public static void main(String[] args) {
        writeOutput(String.valueOf(ourPow(readInput())));
    }
    
    static Double ourPow(String inpt) {
        double a;
        double b;
        String[] tempStr;
        tempStr = inpt.split(" ");
        a = Double.parseDouble(tempStr[0]);
        b = Double.parseDouble(tempStr[1]);
        if (a == 0.0 && b == 0.0) {return null;}
        return Math.pow(a, b);
    }

    static String readInput() {
        String resultStr = "";
        try {
            String[] tempStr;
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            tempStr = br.readLine().split(" "); //считали первую строку из файла
            resultStr = tempStr[1];
            tempStr = br.readLine().split(" "); //считали вторую строку из файла
            if (tempStr[0].equals("a")) {
                resultStr = tempStr[1] + " " + resultStr;
            } else {
                resultStr = resultStr + " " + tempStr[1];
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {return resultStr;}
    }

    static void writeOutput(String outpt) { //Вывод результата в файл
        try (FileWriter fw = new FileWriter("output.txt",false)) {
            fw.write(outpt);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}