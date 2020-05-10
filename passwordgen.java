//🔥Enter the password length. Integer!

import java.security.NoSuchAlgorithmException;
//Import the Date class.
import java.util.Date;

//Import the date editing class.
import java.text.SimpleDateFormat;

//Importing the MessageDigest class.
import java.security.MessageDigest;

//Importing the Random class.
import java.util.Random;

//Importing the Scanner class.
import java.util.Scanner;
class GenPassword{
    public static void main(String[] args) throws Exception{
        Scanner input=new Scanner(System.in);
        int length=input.nextInt();
        input.close();
        //creating a lowcase letter variable
        String charsNorml="qwertyuiopasdfghjklzxcvbnm";
        //creating a uppercase letter variable
        String charsUppercase="QWERTYUIOPASDFGHJKLZXCVBNM";
        //creating a variable of numbers
        String numbers="1234567890";
        String specChars="";
        //creating a string with all our characters
        String pswd=charsNorml+charsUppercase+numbers+specChars;
        //denoting an instance of the random class
        Random rnd=new Random();
        //creating a char array and setting the noof elements equal to password length
        char[] pass=new char[length];
        //creating a"for" loop to execute body as many times as the password len
        for(int i=0;i<length;i++){
            pass[i]=pswd.charAt(rnd.nextInt(pswd.length()));
        }
        //output a message to user
        System.out.print("Your Password:");
        //output the value of pass array
        System.out.println(pass);
        /*Creating a string from the char array*/
          String passhex = new String(pass);
      
          /*Creating the MessageDigest object using the getInstance ("SHA-1 or SHA-256 or MD5"); method.*/
          MessageDigest md =MessageDigest.getInstance("MD5");
           
          /*This method takes an
            array of bytes representing
            the message and
            adds / passes it to the
            MessageDigest object created
            above.*/
          md.update(passhex.getBytes());
         
          /*This method calculates
            the hash function for the
            current object and returns
            the message digest as a
            byte array.*/
          byte[] digest = md.digest();
         
          /*Converting the byte
          array in to HexString format*/
          StringBuffer hexString = new StringBuffer();
         
         
         for (int i = 0;i<digest.length;i++){
        
        //Zeroing the high-level bits
        hexString.append(Integer.toHexString(0xFF & digest[i]));
       }
         
          /*Output the MD5 hash to the user*/
          System.out.println("MD5 Hash: " + hexString.toString());
         
          //Indent
          System.out.println("");
          //Create an instance of the class
        SimpleDateFormat dateFormat= new SimpleDateFormat
        ("d MMM yyyy HH:mm:ss z");
       
        //Print date
        System.out.println(dateFormat.format( new Date() ) );

    }
}