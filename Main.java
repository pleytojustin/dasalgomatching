import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class Main {
     public static char[] stack;
     public static int lengthOftheString = 0;
     public static int stackIndex = 0;
     public static int stackTail = 0;
     public static boolean compOC = false;
     public static boolean ifError = false; 
     boolean er = false; 
     public static String[] storeText;
     public static char[] stackcloseBracket;
    public static boolean err = true; 
  private JFrame frame;
  public static String inputt= "";
  public static JTextArea txtrA;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });


        
       

      // String newInput = JOptionPane.showInputDialog("Enter First number");

        // TESTING
        String test1 = "{Hello World [IS THE BEST] {IN THE WHOLE WORLD} (OH YEAH)}"; //pass
        String test2 = "Hello World { [IS THE BEST] {IN ()THE [WHOLE] WORLD} (OH YEAH)}"; //pass
      String test3WithError = "Hello World { ] New Test has to happen"; //pass
      String test4WithError = "Hello World {  New Test ] has {to happen}"; //pass
    String test5WithError = "Hello World {  New Test  has to happen";  // pass
    String test6WithError = "Hello World }  New Test  has to happen"; //FAIL
      String test7NOError = "Hello World  New Test  has to happen"; //pass
        String test8WithError = "Hello World (] New Test  has to happen"; //FAIL
                      String test9WithError = "Hello World (} New Test  has to happen"; // FAIL

                String test10WithError = "Hello World [) New Test  has to happen"; //PASS
                      String test11WithError = "Hello World [} New Test  has to happen"; // FAIL

                          String test12WithError = "Hello World {) New Test  has to happen"; //pass 
                      String test13WithError = "Hello World {] New Test  has to happen"; //pass


        //Declarations
   //     char c = ' ';
      //    lengthOftheString = inputt.length();
        ifError = CheckCodeBrackets(lengthOftheString, stack, inputt);

        System.out.println(ifError);

          }   

     public static boolean CheckCodeBrackets(int lengthOftheString, char[] stack, String str){

          String stringoutput ="NOT THE SAME";
          int charachterNumberOfTheError = 0;

          boolean err = true; 

          stack = new char[lengthOftheString];
          stackcloseBracket = new char[lengthOftheString];
           
       
          for(int i = 0 ; i < lengthOftheString ; i++){
          //  System.out.println(test1.charAt(i));
  int savefornow = 0;

            if(checkIfOpen(str.charAt(i)))
            {
              push(stack,str.charAt(i));
            }
            else if(checkIfClose(str.charAt(i)))
            {
         
              // System.out.println(test1.charAt(i));
              // System.out.println(stack[stackIndex]);
              char poped = pop(stack);
                System.out.println("OPEN: " + poped + " CLOSE: " + str.charAt(i));
                txtrA.append("OPEN: " + poped + " CLOSE: " + str.charAt(i)+"\n");
            
              if(Character.valueOf(poped).compareTo(str.charAt(i)) >= 0){
                stringoutput= "NOT THE SAME";
                       savefornow = i;
                charachterNumberOfTheError = i;
              //  System.out.println("NOT THE SAME");
                err = false;
              }
              else if(Character.valueOf(poped).compareTo(str.charAt(i)) < 0){
                   if(err != false)
                      err = true;
                      stringoutput= "THE SAME";
                  //    charachterNumberOfTheError = savefornow;

              }

              if(Character.valueOf(poped) == '(' && str.charAt(i) == '}' )
              {

                   err = false;
                  //  System.out.println("NOT THE SAME");
                       stringoutput= "NOT THE SAME";
                         savefornow = i;
                       charachterNumberOfTheError = i;
              }
              if(Character.valueOf(poped) == '(' &&  str.charAt(i) == ']')
              {
                   err = false;
                    //System.out.println("NOT THE SAME");
                    stringoutput= "NOT THE SAME";
                      savefornow = i;
                    charachterNumberOfTheError = i;
              }

              if(Character.valueOf(poped) == '[' &&  str.charAt(i) == '}')
              {
                   err = false;
                    //System.out.println("NOT THE SAME");
                    stringoutput= "NOT THE SAME";
                      savefornow = i;
                    charachterNumberOfTheError = i;
              }

              if(Character.valueOf(poped) == '[' &&  str.charAt(i) == ')')
              {
                   err = false;
                    //System.out.println("NOT THE SAME");
                    stringoutput= "NOT THE SAME";
                      savefornow = i;
                    charachterNumberOfTheError = i;
              }

              if(Character.valueOf(poped) == '{' &&  str.charAt(i) == ']')
              {

                   err = false;
                    //System.out.println("NOT THE SAME");
                    stringoutput= "NOT THE SAME";
                      savefornow = i;
                    charachterNumberOfTheError = i;
              }

              if(Character.valueOf(poped) == '{' &&  str.charAt(i) == ')')
              {
                   err = false;
                    //System.out.println("NOT THE SAME");
                    stringoutput= "NOT THE SAME";
                      savefornow = i;
                    charachterNumberOfTheError = i;
              }



                if(poped == ' ' && str.charAt(i) == '}' || poped == ' ' && str.charAt(i) == ']' || poped == ' ' && str.charAt(i) == ')' )
                {
                   charachterNumberOfTheError = i;
                     savefornow = i;
                   stringoutput= "NOT THE SAME";
                   txtrA.append("NOT THE SAME \n");
                   err = false;
                }
                if(err == false)
                {
                   System.out.println(stringoutput +"\n"+" The Error is at Charachter: " + charachterNumberOfTheError);
                       txtrA.append(stringoutput +"\n"+" The Error is at Charachter: " + charachterNumberOfTheError+ "\n");
                
                }
                if(err == true){
                  System.out.println(stringoutput +" There is no Error");
                  txtrA.append(stringoutput +"\nThere is no Erro \n");
                }
              }
      }


      //isStackEmpty checks if the number of { [ ( are even. 
      //System.out.println("CHECK STACK IS EVEN " + isStackEmpty());
      if(!isStackEmpty())
      {
        err = false;
      }

      return err;
     }






     public static char[] push(char[] s, char value){

        if(stackIndex != lengthOftheString)
        {
          s[stackIndex] = value;
          stackIndex++;
        }
        else
        {
          System.out.println("STACK IS FULL");
        }
        return s;
     }
        public static char pop(char[] s){
          char retValue = ' ';


          if(stackIndex>0)

            retValue = s[stackIndex - 1];
            
          else
              System.out.println("STACK IS EMPTY");
        

        if(stackIndex!=0){
          stackIndex--;
        }

        return retValue;
     }
     public static boolean isStackEmpty()
     {  

        if(stackIndex == 0)
        {
          return true;
        }
        else
        {
          return false;
        }

     }
     public static boolean checkIfOpen(char s){
   
        if(s == '{')
        {
          return true; 
          }
          else if(s == '[')
          {
              return true; 
          }
          else if(s ==  '(')
          {
            return true; 
          }

            return false;
     }
        public static boolean checkIfClose(char s){
   
        if(s == '}')
        {
          return true; 
          }
          else if(s == ']')
          {
              return true; 
          }
          else if(s ==  ')')
          {
            return true; 
          }

            return false;
     }

  /**
   * Create the application.
   */
  public Main() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.getContentPane().setBackground(Color.DARK_GRAY);
    frame.setBounds(100, 100, 529, 379);
    frame.setTitle("DASALGO BRACKET PROJECT");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.NORTH);
       
    JLabel lblEnterCodeHere = new JLabel("ENTER CODE HERE");
    panel.add(lblEnterCodeHere);
    
     final JFrame parent = new JFrame();
     

  
    
    JSplitPane splitPane = new JSplitPane();
    frame.getContentPane().add(splitPane, BorderLayout.CENTER);
    splitPane.setDividerLocation(300);
    txtrA = new JTextArea();
    txtrA.setText("CODE OUTPUT HERE \n(Do Not type anything here)");
    splitPane.setRightComponent(txtrA);
    
    final JTextPane txtpnTypeInputHere = new JTextPane();
    splitPane.setLeftComponent(txtpnTypeInputHere);
    txtpnTypeInputHere.setText("INPUT CODE SNIPPET HERE (DELETE THIS AREA FIRST AND TYPE THE INPUT)");
    
    JButton btnSubmit = new JButton("SUBMIT");
    btnSubmit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        
           txtrA.setText("");
        inputt  = txtpnTypeInputHere.getText();
        System.out.println(inputt);
         lengthOftheString = inputt.length();
        er = CheckCodeBrackets(lengthOftheString, stack, inputt);
        
        
        
            if(er){
                System.out.println("There is no error in your code");
                txtrA.append("There is no error in your code");
            }
             else{
               System.out.println("Your code has errors it may be that there are mis mached open and closed brackets");
               txtrA.append("Your code has errors it may be that there are mis mached open and closed brackets");
             }
            
         
         
      //   JOptionPane.showMessageDialog(parent, er);
         stackIndex = 0;
      //   frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      //  JOptionPane.showMessageDialog(null, "WORLD", "InfoBox: " + "HELLO", JOptionPane.INFORMATION_MESSAGE);
      }
    });
    frame.getContentPane().add(btnSubmit, BorderLayout.SOUTH);

  }

}
