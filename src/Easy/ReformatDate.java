/*

Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
 

Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"
Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"
Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"
 

Constraints:

The given dates are guaranteed to be valid, so no error handling is necessary.

*/


class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] stringArray = date.split(" ");
        sb.append(Integer.parseInt(stringArray[2]));
        sb.append("-");
        if (stringArray[1].equals("Jan")) sb.append("01");
        if (stringArray[1].equals("Feb")) sb.append("02");
        if (stringArray[1].equals("Mar")) sb.append("03");
        if (stringArray[1].equals("Apr")) sb.append("04");
        if (stringArray[1].equals("May")) sb.append("05");
        if (stringArray[1].equals("Jun")) sb.append("06");
        if (stringArray[1].equals("Jul")) sb.append("07");
        if (stringArray[1].equals("Aug")) sb.append("08");
        if (stringArray[1].equals("Sep")) sb.append("09");
        if (stringArray[1].equals("Oct")) sb.append("10");
        if (stringArray[1].equals("Nov")) sb.append("11");
        if (stringArray[1].equals("Dec")) sb.append("12");
        sb.append("-");
        String date1 = "";
        date1 = stringArray[0].replace("st", "").replace("nd", "").replace("rd", "").replace("th", "");
        if (Integer.parseInt(date1) < 10) 
            sb.append(0);
        sb.append(date1);
        return sb.toString();
    }
}
