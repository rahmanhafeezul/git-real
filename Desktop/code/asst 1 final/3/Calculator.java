public class Calculator
	{
		private Stack s;
   		private String input;
   		private String output = "";
   		public Calculator(String in) {
      		input = in;
      		int stackSize = input.length();
      		s = new Stack(stackSize);
		}
	public String convertExpression(String input) {
      		for (int j = 0; j < input.length(); j++) {
         	char ch = input.charAt(j);
         	switch (ch) {
            case '+':
            case '-':output=output+" "; 
            ifOperator(ch, 1); 
            break; 
            case '*':
            output=output+" ";
            ifOperator(ch, 2); 
            break; 
            case '(': 
            s.push(ch);
            break;
            case ')':
            ifBrackets(ch); 
            break;
            default: 
            output = output + ch; 
            break;
         }
      }
      while (!s.isEmpty()) {
         output = output +s.pop();
      }
      
      return output; 
   }
   public void ifOperator(char oper, int priority1) {
      while (!s.isEmpty()) {
         char opTop = (char)s.pop();
         if (opTop == '(') {
            s.push(opTop);
            break;
         }
         else {
            int priority2;
            if (opTop == '+' || opTop == '-')
            priority2 = 1;
            else
            priority2 = 2;
            if (priority2 < priority1) { 
               s.push(opTop);
               break;
            }
		    else
            output = output+opTop;
         }
      }
      s.push(oper);
   }
   public void ifBrackets(char ch){ 
      while (!s.isEmpty()) {
         char chx = (char)s.pop();
         if (chx == '(') 
         break; 
         else
         output = output+" "+ chx; 
      }
   }


   


}
