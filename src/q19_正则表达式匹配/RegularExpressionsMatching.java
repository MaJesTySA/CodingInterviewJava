package q19_正则表达式匹配;

public class RegularExpressionsMatching {
    public static void main(String[] args) {

    }

    private static boolean match(String str,String pattern){
        if (str==null||pattern==null||str.length()==0||pattern.length()==0)
            return false;
        int strPtr=0;
        int patternPtr=0;
        return matchCore(str,pattern,strPtr,patternPtr);
    }

    private static boolean matchCore(String str,String pattern,int strPtr,int patternPtr){
        if (strPtr==str.length() && patternPtr==pattern.length())
            return true;
        if (strPtr!=str.length() && patternPtr==pattern.length())
            return false;
        //处理
        if (pattern.charAt(patternPtr+1)=='*'){

        }
        return true;
    }
}
