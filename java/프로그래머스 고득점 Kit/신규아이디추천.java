
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        //1.

        //2.
        for(int i=0; i<new_id.length(); i++){
            char a = new_id.charAt(i);
            if(Character.isAlphabetic(a) 
||
              Character.isDigit(a)
||
              a == '-' || a == '_' || a == '.') answer += a;
        }

        //3. 
        while(answer.indexOf("..") != -1){
            answer = answer.replace("..", ".");
        }

        //4.
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }


        //5.
        if(answer.isEmpty()){
            answer = "a";
        }

        //6.
        if(answer.length() >= 16) {
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1)=='.') answer = answer.substring(0, answer.length()-1);
        }

        //7.
        while(answer.length()<3){
            answer += answer.charAt(answer.length()-1);
        }


        return answer;
    }
}
