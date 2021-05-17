public class Main {
    //Code your solution to problem number one here
    //Problem 1. Counts up the number of vowels contained in the string
    static int problemOne(String s){

        //Number of vowels set to 0 in the beginning
        int answer = 0;

        //Loop for each character in the string
        for (int i = 0; i < s.length(); i++)
        {
            //Check every vowel: 'a', 'e', 'i', 'o', and 'u'
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
                //Count how many vowels in the string
                answer++;
            }
        }
        //Return number of vowels
        return answer;
    }

    //Code your problem number two here
    //Problem 2. Prints the number of times the string 'bob' occurs in the string
    static int problemTwo(String s){

        //Number of times bob occurs in the string
        int answer = 0;

        //Length of the string
        int lString = s.length();

        //Declaring the string "bob"
        String bobString = "bob";

        //If the length of the string is less thae length of string "bob", we will return 0
        if (lString < 3)
            return 0;

        //Loop from 1st character until the length of the string
        // is equal or less than the length of the string minus 3 which is the length of "bob"
        for (int i = 0; i <= lString - 3; i++)
        {
            //Compare "bob" to the substring fo the string and if it is matching, we will count it
            if (bobString.compareTo(s.substring(i,i+3)) == 0 )

                //Count the number of times the string 'bob' occurs in the string
                answer++;
        }

        //Return number of times the string 'bob' occurs in the string
        return answer;
    }

    //Code your solution to problem number 3 here
    //Problem 3. Find the longest substring of s in which the letters occur in alphabetical order
    static String problemThree(String s){

        //A string for holding the substring of the given string
        String alphString = "";

        //Result string = first letter of the given string, in case if there is only one letter of the longest string
        String answer = s.substring(0, 1);

        //In case if the length of the given string is more than 0
        if(s.length() > 0)
            //The holding string is equal to the first letter of the given string
            alphString = s.substring(0, 1);

        //Otherwise, return empty string
        else return "";

        //Loop from the 1st letter to the last letter
        for(int i = 1; i < s.length(); i++){

            //If the index of the previous character is less or equal the index of the next character
            if((int)s.charAt(i-1) <= (int)s.charAt(i)){

                //Add a letter to the holding string
                alphString += s.charAt(i);

                //If the length of the holding string is more than the length of the result string
                if(alphString.length() > answer.length())

                    //The result string will be equal to the holding string
                    answer = alphString;
            }
            else{

                //Otherwise, holding string will start from this letter
                alphString = s.substring(i, i+1);
            }
        }

        //Return the longest substring of s in which the letters occur in alphabetical order
        return answer;
    }

    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;

    }
}
