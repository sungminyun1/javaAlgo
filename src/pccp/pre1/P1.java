package pccp.pre1;



public class P1 {
    public static void main(String[] args) {
        P1 p1 = new P1();
        String t = p1.solution("abc");
        System.out.println(t);
    }
    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        int[] check = new int[26];
        int[] ans = new int[26];
        boolean isEmpty = true;
        for (int i = 0; i < input_string.length(); i++) {
            char now = input_string.charAt(i);
            if(check[now-97] == 1){
                if(input_string.charAt(i-1) != now){
                    ans[now-97] = 1;
                    isEmpty = false;
                }
            }else{
                check[now-97] = 1;
            }
        }
        if(isEmpty) return "N";
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 1) {
                char now = (char) (i + 97);
                sb.append(""+now);
            }
        }


        return sb.toString();
    }
}
