class Solution {

    private static void genParen(List<String> lst, int left, int right, String str, int n){
        if(str.length() == 2*n){
            lst.add(str);
            return;
        }
        
        if(left < n){
            genParen(lst,left+1,right, str+"(", n);
        }

        if(right < left){
            genParen(lst, left, right+1, str+")" , n);
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        genParen(lst,0,0,"",n);
        return lst;
    }
}


/*

approach : first of all the left brackets number should be equal to right ones

left braces should come before the right one and also right braces can only be put if the 
left braces are more then that


for e.g for TC 1 .. recurssion/ backtrack schema will be in this form

(

(( or ()

((( or ()(

((())) or ()()
.
.
.
((())) or ()()()

between the above choices there will be sub choices as well

*/