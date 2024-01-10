/**
 * ElevatorControlSystem
 */
public class ElevatorControlSystem implements InvariantCheck{

    //constants
    public static final int NIL = -999;
    public static final int MAX = 10;
    public static final int MIN = 0;

    //state attributes
    private int requestedFloor ;
    private int currentFloor ;
    private boolean isMoving ;
    private Command movement;
    private Door doorStatus;

    //initialisation satisfied by constructor 
    public ElevatorControlSystem()
    {
        requestedFloor=NIL;
        currentFloor=NIL;
        isMoving=false;
        //checking invariant class
        VDM.invTest(this);
    }

    //invariant
    public boolean inv()
    {
        return (inRange(requestedFloor)||requestedFloor==NIL) && (inRange(currentFloor)||currentFloor==NIL) && (isMoving==false || isMoving==true);
    }

    //inRange function added as a private method
    private boolean inRange(int val)
    {
        return (MIN <= val && val <=MAX);
    }

    //a function to set the initial floor
    public void setInitialFloor(int floorNo)
    {
        VDM.preTest(inRange(floorNo) && currentFloor==NIL);
        currentFloor=floorNo;
    }

    //a function to request a floor
    public Command requestFloor(int floorNo)
    {
        //check precondition
        VDM.preTest(inRange(floorNo) && currentFloor!=NIL);

        //implement post condition
        //satistfy 1st conjuct
        requestedFloor=floorNo;

        //satisfy 2nd conjuct
        if(floorNo>currentFloor)
        {
            movement = Command.UP;
        }
        if(floorNo<currentFloor)
        {
            movement = Command.DOWN;
        }
        if(floorNo==currentFloor)
        {
            movement = Command.STOP;
        }
        //check invariant before method ends
        VDM.invTest(this);
        //send back output value
        return movement;
    }

    //operation to move up
    public Command moveUP()
    {
        //pre-condition checked
        VDM.preTest(currentFloor<requestedFloor && currentFloor!=NIL && requestedFloor!=NIL );

        //post condition
        //satisfy 1st conjuct
        currentFloor=currentFloor+1;
        //satisfy 2nd conjuct
        isMoving=true;
        //satisfy 3rd conjuct
        if(currentFloor<requestedFloor)
        {
            movement = Command.UP;
        }
        if(currentFloor==requestedFloor)
        {
            movement = Command.STOP;
            System.out.println("You have reached the requested floor");
            isMoving=false;
        }
        //check invariant before method ends
        VDM.invTest(this);
        //send back output value
        return movement;
    }

    //operation to move down
    public Command moveDOWN()
    {
        //pre-condition checked
        VDM.preTest(currentFloor>requestedFloor && currentFloor!=NIL && requestedFloor!=NIL);

        //post condition
        //satisfy 1st conjuct
        currentFloor=currentFloor-1;
        //satisfy 2nd conjuct
        isMoving=true;
        //satisfy 3rd conjuct
        if(currentFloor>requestedFloor)
        {
            movement = Command.DOWN;
        }
        if(currentFloor==requestedFloor)
        {
            movement = Command.STOP;
            System.out.println("You have reached the requested floor");
            isMoving=false;
        }
        //check invariant before method ends
        VDM.invTest(this);
        //send back output value
        return movement;
    }


    //operation to open door
    public Door openDoor(int floorNo)
    {
        //pre-condition checked
        VDM.preTest((inRange(floorNo))&& (currentFloor==floorNo) && (isMoving==false));
        //post condition
        doorStatus = Door.OPEN;
        //check invariant before method ends
        VDM.invTest(this);
        //send back output value
        return doorStatus;
    }

    //operation to close door
    public Door closeDoor(int floorNo)
    {
        //pre-condition checked
        VDM.preTest((inRange(floorNo))&& (currentFloor==floorNo) && (isMoving==false));
        //post condition
        doorStatus = Door.CLOSE;
        //check invariant before method ends
        VDM.invTest(this);
        //send back output value
        return doorStatus;
    }

    public int getRequestedFloor()
    {
        return requestedFloor;
    }

    public int getCurrentFloor()
    {
        return currentFloor;
    }

    public boolean getMovingState()
    {
        return isMoving;
    }
    
}
