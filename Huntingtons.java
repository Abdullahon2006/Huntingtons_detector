public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna)
    {
        int maxRepeats = 0, lengths = dna.length(), diff = 1, tempC = 0;;
        boolean consecutive = false;
        for (int i = 0; i < lengths; i += diff)
        {
            String checking = new String();
            if (i + 3 <= lengths)
            {
                checking = dna.substring(i, i + 3);
            }
            else break;

            if (checking.equals("CAG"))
            {
                if (consecutive)
                {
                    tempC += 1;
                    if (tempC > maxRepeats)
                        maxRepeats = tempC;
                }
                else
                {
                    consecutive = true;
                    tempC = 1;
                    diff = 3;
                    if (tempC > maxRepeats)
                        maxRepeats = tempC;
                }
            }
            else
            {
                if (consecutive)
                {
                    diff = 1;
                    consecutive = false;
                    if (tempC > maxRepeats)
                    {
                        maxRepeats = tempC;
                    }
                }
            }
        }

        return maxRepeats;
    }

    public static String removeWhitespace(String s)
    {
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    public static String diagnose(int maxRepeats)
    {
        if (maxRepeats <= 9 || maxRepeats >= 181) return "not human";
        else if (maxRepeats <= 35) return "normal";
        else if (maxRepeats <= 39) return "high risk";
        else return "Huntington’s";
    }

    // Sample client (see below).
    public static void main(String[] args)
    {
        String file = args[0];
        In f = new In(file);
        String s = f.readAll();
        f.close();
        int maxRepeats = maxRepeats(removeWhitespace(s));
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose(maxRepeats));

    }

}