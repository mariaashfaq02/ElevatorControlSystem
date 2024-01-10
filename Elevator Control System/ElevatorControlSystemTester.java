
public class ElevatorControlSystemTester 
{
    public static void main(String[] args)
    {
        char choice;
        
        //to monitor for an invariant violation of initial object
        try
        {
            //generate a new elevator control system object
            ElevatorControlSystem elevator =new ElevatorControlSystem();
            do
            {
                System.out.println("\n Elevator Control System Tester");
                System.out.println("1.Initialize system");
                System.out.println("2.Request a floor");
                System.out.println("3.Display current floor");
                System.out.println("4.Display requested floor");
                System.out.println("5.Display moving state");
                System.out.println("6.Go up");
                System.out.println("7.Go down");
                System.out.println("8.Open Door");
                System.out.println("9.Close Door");
                System.out.println("Enter choice 1 to 9 or press 0 to quit");

                //accepts character enetered at keyboard
                choice =EasyIn.getChar();

                System.out.println(); //blank line
                try
                {
                    switch (choice) {
                        case '1':
                            option1(elevator);
                            break;
                        case '2':
                            option2(elevator);
                            break;
                        case '3':
                            option3(elevator);
                            break;
                        case '4':
                            option4(elevator);
                            break;
                        case '5':
                            option5(elevator);
                            break;
                        case '6':
                            option6(elevator);
                            break;
                        case '7':
                            option7(elevator);
                            break;
                        case '8':
                            option8(elevator);
                            break;
                        case '9':
                            option9(elevator);
                            break;
                        default:
                            break;
                    }

                }catch(VDMException e)
                {
                    e.printStackTrace(); //built in exception method
                }
            }while(choice !='0');

        }
        catch(VDMException e)//if initial object breaks invariant
        {
            System.out.println("Initial object breaks invariant"); //error message
            EasyIn.pause("\nPress <Enter> to quit");//pause method of EasyIn
        }
    }
    //test VDM operation implementations
    
    public static void option1(ElevatorControlSystem elevator)
    {
        System.out.println("Enter floor number");
        int floor =EasyIn.getInt();
        elevator.setInitialFloor(floor);
        System.out.println("System initialized to floor  "+ elevator.getCurrentFloor());
    } 

    public static void option2(ElevatorControlSystem elevator)
    {
        System.out.println("Enter floor number");
        int floor =EasyIn.getInt();
        elevator.requestFloor(floor);
    } 
    public static void option3(ElevatorControlSystem elevator)
    {
        if(elevator.getCurrentFloor()==-999){System.out.println("Current floor is unknown.\nPlease initialize the system");}
        else{System.out.println("Current floor is : "+elevator.getCurrentFloor());}
    } 

    public static void option4(ElevatorControlSystem elevator)
    {
        System.out.println("Requested floor is : "+elevator.getRequestedFloor());
    } 
    public static void option5(ElevatorControlSystem elevator)
    {
        if(elevator.getMovingState()==true){System.out.println("Elevator is moving");}
        if(elevator.getMovingState()==false){System.out.println("Elevator is not moving");}
        
    } 
    public static void option6(ElevatorControlSystem elevator)
    {
        elevator.moveUP();//this method could throw a VDMException
    } 
    public static void option7(ElevatorControlSystem elevator)
    {
        elevator.moveDOWN();//this method could throw a VDMException
    }
    public static void option8(ElevatorControlSystem elevator)
    {
        elevator.openDoor(elevator.getCurrentFloor());//this method could throw a VDMException
        System.out.println("Door opened");
    } 
    public static void option9(ElevatorControlSystem elevator)
    {
        elevator.closeDoor(elevator.getCurrentFloor());//this method could throw a VDMException
        System.out.println("Door closed");
    } 


}
