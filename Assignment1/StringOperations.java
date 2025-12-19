public class StringOperations {
    public static void main(String[] args) {

//      Use of all functions of strings

        String str = "Hello, World!";
        int length = str.length();
        System.out.println("Length of the string is: "+ length);

        char firstChar = str.charAt(0);
        System.out.println("First character: "+ firstChar);

        String substring = str.substring(7);
        System.out.println("Substring: "+ substring);

        String rangeString = str.substring(0,5);
        System.out.println("Range string: "+ rangeString);

        String upperCase = str.toUpperCase();
        System.out.println("uppercase: "+ upperCase);

        String lowerCase = str.toLowerCase();
        System.out.println("lowercase: "+ lowerCase);

        String concatString = str.concat(" goodbye ");
        System.out.println("Concat String: "+concatString);

        String stringWithWhiteSpace = "      hello     ";
        String trimmedString = stringWithWhiteSpace.trim();
        System.out.println("trimmed String: "+ trimmedString);

        String replaceString = str.replace("Hello","hii");
        System.out.println("replace string: "+ replaceString);

        String replacedCharacter = str.replace('o','u');
        System.out.println("replaced character: "+ replacedCharacter);

        String sentence = " is fun!";
        String[] words = sentence.split(" "); // splits by space
        for(String num:words){
            System.out.print(num);
        }
        System.out.println();

        String[] words2 = {" ", "is", "fun!"};
        String sentence2 = String.join(" ",words2); // joins with space
        System.out.println(sentence);

    }
}
