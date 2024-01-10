public class Door 
{
    //a single private attribute
    private int value;

    //class constants representing named quote values 
    public static final Door OPEN = new Door(0);
    public static final Door CLOSE = new Door(1);
    

    //private constructor used by class constants
    private Door (int x)
    {
        value = x;
    }

    public boolean equals (Object objectIn)
    {
        Door d=(Door) objectIn;
        return value==d.value;
    }

    //useful for testing purposes
    public String toString()
    {
        switch (value) {
            case 0:
                return "OPEN";
            case  1:
                return "CLOSE";
            default:
                return "";
        }
    }
    
}
