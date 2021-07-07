package baekjun;

import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class exam7490_clear {
    static int N;
    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("js");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        for(int i=0 ; i<max ; i++){
            N = sc.nextInt();
            recur("1",1);

            System.out.println();
        }
    }

    static void recur(String str, int num){
        if(num==N){
            if(calStr(str))
                System.out.println(str);
        }else {
            num++;
            recur(str + " "+num, num);
            recur(str + "+"+num, num);
            recur(str + "-"+num, num);
        }
    }

    static boolean calStr(String str){
        try {
            return engine.eval(str.replaceAll(" ","")).toString().equals("0");
        } catch (Exception e) {
            return false;
        }
    }
}
