import java.util.ArrayDeque;
import java.util.Deque;

/**
 * program
 */
public class program {
    public static void main(String[] args) {
        int a = 22; //старт
        int b = 2022;//конец
        int c = 3;//умножаем
        int d = 1;//добавляем
        //String strTemp = null;
        //int intTemp;
        Long longTemp;
        //String mostShort = "-";
        Long counter = (long) 0;
        //Deque<String> deqPath = new ArrayDeque<>();
        Deque<Long> deqLong = new ArrayDeque<>();
        
        //Добавляем начальные маршрутs
        if (isSubtrahend((long) b, d, a)) {
            //deqPath.addLast("0");
            deqLong.addLast((long) (b - d));
          }
        if (isDivided((long) b, c, a)) {
            //deqPath.addLast("1");
            deqLong.addLast((long) (b/c));
        }
        

        while (!deqLong.isEmpty()) {
            // if (mostShort.equals("-")) {
            //     strTemp = deqPath.pollFirst();
            // }    
            // if (mostShort.equals("-")) {intTemp = calcStr(strTemp, b, c, d);}
            longTemp = deqLong.pollFirst();
            
            if (longTemp == (long) a) {
                //deqRes.addLast(strTemp);    
//                if (mostShort.equals("-")) {mostShort = strTemp;} //Если нашли первую комбинацию - по идее она самая короткая
                //System.out.println(strTemp);
                counter += 1;
            } else {
                if (isSubtrahend(longTemp, d, a)) {
//                    if (mostShort.equals("-")) {deqPath.addLast(strTemp.concat("0"));}
                    deqLong.addLast(longTemp - d);
                }
                if (isDivided(longTemp, c, a)) {
//                    if (mostShort.equals("-")) {deqPath.addLast(strTemp.concat("1"));}
                    deqLong.addLast(longTemp/c);
                }        
            }

        }
        
        System.out.println(counter); //Выводим количество маршрутов
     //   System.out.println(mostShort); //Самый короткий маршруn
    }
    
    // static int calcStr(String inpStr, int b,int c,int d) {
    //     char[] chars = inpStr.toCharArray();
    //     int tempB = b;
    //     if (chars.length > 0) {
    //         for (char ch: chars) {
    //             if (ch == '0'){
    //                 tempB -= d;
    //             } else {
    //                 tempB /= c;
    //             }
    //         }    
    //     }
    //     return tempB;
    // }
    
    static boolean isDivided(Long number, int c, int a) {
        if (number%c == 0 && number/c >= a)
        {return true;}
        
        return false;
    }
    static boolean isSubtrahend(Long number, int d, int a) {
        if (number - d >= a) 
        {return true;}
        
        return false;
    }
}