class Command 
{
    //a single private attribute
    private int value;

    //class constants representing named quote values 
    public static final Command UP = new Command(0);
    public static final Command DOWN = new Command(1);
    public static final Command STOP = new Command(2);

    //private constructor used by class constants
    private Command (int x)
    {
        value = x;
    }

    public boolean equals (Object objectIn)
    {
        Command c=(Command) objectIn;
        return value==c.value;
    }

    //useful for testing purposes
    public String toString()
    {
        switch (value) {
            case 0:
                return "UP";
            case  1:
                return "DOWN";
            default:
                return "STOP";
        }
    }

}

