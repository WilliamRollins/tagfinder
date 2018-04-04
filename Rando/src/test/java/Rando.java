import java.util.ArrayList;

public class Rando {

    private static ArrayList startTagLocation(final String content, final String startTag) {
        int tagsequance = 0;
        int i =-startTag.length();
        ArrayList<Integer> startTagLocation = new ArrayList<>();
        do {
            if (0 <= (i = content.indexOf(startTag, i + startTag.length()))) {
                tagsequance++;
                startTagLocation.add(i);
            }
        } while (-1 != i);
        return startTagLocation;
    }

    private static ArrayList endTagLocation(final String content, final String endTag) {
        int tagsequance = 0;
        int i =-endTag.length();
        ArrayList<Integer> endTagLocation = new ArrayList<>();
        do {
            if (0 <= (i = content.indexOf(endTag, i + endTag.length()))) {
                tagsequance++;
                endTagLocation.add(i);
            }
        } while (-1 != i);
        return endTagLocation;
    }

    private static String taggenerator (final String startTag, final String endTag, final String content, final ArrayList<Integer> startTagLocation, ArrayList<Integer> endTagLocation ) {
        String tagSubString = "";
        for (int i = 0; i < startTagLocation.size(); i++)
            tagSubString = tagSubString+" "+content.substring(startTagLocation.get(i)+startTag.length(), endTagLocation.get(i));
        return tagSubString;
    }

    public static void main(String[] args) {

        String startTag = "[[";
        String endTag = "]]";
        String myContent = "[[i dont]] know [[how to]] java well o well so well.";
        System.out.println(myContent);
        System.out.println(myContent.length());
        System.out.println(startTagLocation(myContent, startTag));
        System.out.println(startTagLocation(myContent, endTag));
        System.out.println(taggenerator(startTag, endTag, myContent, startTagLocation(myContent, startTag), endTagLocation(myContent, endTag)));



    }
}


