package programmers.lv2;

import java.util.*;

class P67257 {
    public ArrayList<Integer> nums = new ArrayList<>();
    public ArrayList<Integer> oper = new ArrayList<>();
    public long answer = -1L;
    public long solution(String expression) {
        int s= 0;
        for(int i =0; i<expression.length(); i++){
            char now = expression.charAt(i);
            if(now == '+' || now == '-' || now =='*'){
                nums.add(Integer.parseInt(expression.substring(s,i)));
                s = i+1;
                if(now == '+'){ oper.add(0);}
                else if(now == '-'){ oper.add(1);}
                else if(now == '*'){ oper.add(2);}
            }
        }
        nums.add(Integer.parseInt(expression.substring(s,expression.length())));
        boolean[] orderCheck = new boolean[3];
        for(int i =0; i<3; i++){
            if(orderCheck[i]) continue;
            orderCheck[i] = true;
            ArrayList<Integer> order = new ArrayList<>();
            order.add(0,i);
            for(int j =0; j<3; j++){
                if(orderCheck[j]) continue;
                orderCheck[j] = true;
                order.add(1,j);
                for(int k =0; k<3; k++){
                    if(orderCheck[k]) continue;
                    orderCheck[k] = true;
                    order.add(2,k);
                    System.out.println("order "+ order.get(0) + " " + order.get(1) + " "+order.get(2) + " ");
                    int res = solve(order,0,nums.get(0));
                    System.out.println(res);
                    orderCheck[k] = false;
                }
                orderCheck[j] = false;
            }
            orderCheck[i] = false;
        }
        return answer;
    }
    public int solve(ArrayList<Integer> order,int opI, int sum){
        if(opI == oper.size()-1){
            if(oper.get(opI) == 0){
                return sum += nums.get(opI+1);
            }else if(oper.get(opI) == 1){
                return sum -= nums.get(opI+1);
            }else if(oper.get(opI) == 2){
                return sum *= nums.get(opI+1);
            }
        }
        Integer operNow = oper.get(opI);
        Integer operNext = oper.get(opI+1);
        if(order.indexOf(operNow) <= order.indexOf(operNext)){
            if(operNow == 0){
                return solve(order,opI+1, sum + nums.get(opI+1));
            }else if(operNow == 1){
                return solve(order,opI+1, sum + -(nums.get(opI+1)));
            }else if(operNow == 2){
                return solve(order,opI+1, sum * nums.get(opI+1));
            }
        }else{
            if(operNow == 0){
                return sum + solve(order,opI+1,nums.get(opI+1));
            }else if(operNow == 1){
                return sum + -(solve(order,opI+1,nums.get(opI+1)));
            }else if(operNow == 2){
                return sum * solve(order,opI+1,nums.get(opI+1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        P67257 p = new P67257();
        p.solution("100-200*300-500+20");
    }
}