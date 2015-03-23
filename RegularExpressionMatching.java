
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
        if (s.length() < 1) {
            if (p.length() < 1 || (p.length() == 2 && p.charAt(1) == '*')) return true;
            return false;
        }
        boolean ret = isMatchHelper(s, p, 0, 0);
        System.out.println(ret);
        return ret;
	}
    
    public static boolean isMatchHelper(String s, String p, int si, int pi) {
        if (pi >= p.length()) {
        	System.out.print("`");
            if (si >= s.length()) return true;
            System.out.println("-");
            return false;
        }
        if (si >= s.length()) {
            return false;
        }
        
        char sc = s.charAt(si);
        char pc = p.charAt(pi);
                                 
        if (pi == p.length()-1 || p.charAt(pi+1) != '*') {
            if (!matchChar(sc, pc)) return false;
            return isMatchHelper(s, p, si+1, pi+1);
        }
        if (isMatchHelper(s, p, si, pi+2)) return true;
        while(si+1 < s.length()) {
            sc = s.charAt(si + 1);
            if (matchChar(sc, pc)) {
                if (isMatchHelper(s, p, ++si, pi+2)) return true;
            }
        }
        return isMatchHelper(s, p, ++si, pi+2);
    }
    
    public static boolean matchChar(char sc, char pc) {
        if (sc == pc || pc == '.') return true;
        return false;
    }
}
