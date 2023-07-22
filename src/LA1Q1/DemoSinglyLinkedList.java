package LA1Q1;

/********************************************************************************************************************
 *Aarya Patel*
 *251215259*
 *October 9, 2022*
 *This program will display the result of a singly link list string and integer being adjusted from all aspects
 * and it will ask the user to enter the value that they are searching for*
 *******************************************************************************************************************/

//importing all
import java.util.*;

public class DemoSinglyLinkedList {
    public static void main(String args[]){
        //allowing user to input answer
        Scanner input=new Scanner(System.in);
        //print header method
        myHeader("Lab Assignment 1");
        //setting up arraylist for the integer and string
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(56, -22, 34, 57, 98));
        ArrayList<String> sData = new ArrayList<>(Arrays.asList("Griffin", "Will", "Isra", "Delaney", "Madison"));
        //printing the arraylist
        System.out.print("The given Integer array: "+ data);
        System.out.printf("\nThe given String array %s\n", sData);
        //Creating and populating the Integer linked list
        SinglyLinkList<Integer> si = new SinglyLinkList<>();
        for(int i = 0; i<data.size()-2; i++){
            si.addFirst(data.get(i));
        }
        for(int i = data.size()-1; i>2; i--){
            si.addLast(data.get(i));
        }

        System.out.printf("Your Integer List: %s",si);
        //Creating and populating the String linked list
        SinglyLinkList<String> ss = new SinglyLinkList<>();
        for(int j = 0; j<sData.size()-2; j++){
            ss.addFirst(sData.get(j));
        }
        for(int j = sData.size()-1; j>2; j--){
            ss.addLast(sData.get(j));
        }
        //print statements
        System.out.printf("Your String List: %s\n",ss);
        System.out.print("Stack demo with the Integer linked list ...\n");
        //starting method using the integer singlylinklist
        stackDemo(si);
        //print statement
        System.out.println("\nQueue demo with the String linked list ...");
        //starting method using string singlylinklist
        queueDemo(ss);
        //print statements
        System.out.println("\nLet's search the Stack...");
        System.out.printf("The current stack: %s\n",si.toString());
        //setting up variable
        int ans;
        //loop for search stack and to see if user wants to continue the search
        while (true){
            //prompting user
            System.out.print("Enter the value you are searching for: ");
            //loop to verify user's input using a try and catch, if user answers with a value not from the
            //array, display that the value is not found but break out of loop, same thing if there is a value found.
            while (true){
                try{
                    ans=input.nextInt();
                    if (si.searchStack(ans)==0){
                        throw new Exception();
                    }
                    else{
                        System.out.printf("The value %d is found in location %s " +
                                "from the top of the stack", ans,si.searchStack(ans));
                        break;
                    }
                }
                catch (Exception ex) {
                    System.out.print("The value is not found!");
                    break;
                }
                }
            //getting user's input if they want to continue, break loop if they dont want to continue
            System.out.print("\nDo you want to continue? (enter 'y' for yes, " +
                    "or enter any other key to discontinue):");
            char res=input.next().charAt(0);
            if (res=='y'){}
            else{break;}
        }
        //call footer method
        myFooter("Completion of Lab Assignment 1 is successful!");

    }
    //method used to either pop head or tail
    //pop off all when user inputs 1, pushes -58 and 39 to head, while this is happening, the process is to be displayed
    //pop off 3 from tail when user inputs 2, pushes -58 and 39 to head,
    // while this is happening, the process is to be displayed
    //a try and catch in a loop is used to validate the users input
    public static void stackDemo(SinglyLinkList<Integer> list){
        System.out.println("Which end of the Linked List you would like to use as the stack top?");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1 for head or 2 for tail: ");
        int userinput;
        while(true) {

            try {
                userinput=input.nextInt();

                if (userinput == 1||userinput==2) {
                    break;
                }
                else{
                    throw new Exception();
                }

            } catch (Exception ex) {
                System.out.print("Incorrect input! Enter 1 for head or 2 for tail: ");
                input.nextLine();
            }
        }

        if (userinput == 1) {
            System.out.println("\nStack Top: Head of the linked list\n");
            System.out.println("Let's pop first three elements from the stack in sequence: ");
            System.out.printf("The current stack: %s\n", list.toString());
            for (int i=0;i<5;i++) {
                list.toString();
                System.out.printf("%s has been popped! The Revised stack: %s",list.popFromHead(), list);
            }
            System.out.printf("\nLet's push 39 and -58 in the stack ....\nThe current stack: %s", list);

            list.pushAtHead(39);
            System.out.printf("After 39 is pushed, the revised stack: %s", list);
            list.pushAtHead(-58);
            System.out.printf("After -58 is pushed, the revised stack: %s", list);

        }
        else  {
            System.out.println("\nStack Top: Tail of the linked list\n");
            System.out.println("Let's pop first three elements from the stack in sequence: \n");
            System.out.printf("The current stack: %s\n", list.toString());
            for (int j=0;j<3;j++){
                //list.toString();
                System.out.printf("%s has been popped! The Revised stack: %s",list.popFromTail(), list.toString());
            }
            System.out.printf("Let's push 39 and -58 in the stack ....\nThe current stack: %s", list);

            list.pushAtTail(39);
            System.out.printf("After 39 is pushed, the revised stack: %s", list);
            list.pushAtTail(-58);
            System.out.printf("After -58 is pushed, the revised stack: %s", list);
            }
    }
    //similar to stackDemo except it's a string having to other strings enqueued at the tail
    //then dequeued strings from the head 3 times with the help of a for loop
    //the process is all being displayed to the user while this happens
    public static void queueDemo(SinglyLinkList<String> list){
        System.out.print("Note: Head is the Q-front, and Tail is the Q-rear\n");
        System.out.println("\nLet's enqueue Joelle and Lukas in the queue in sequence ...");
        System.out.printf("\nThe current Queue: %s\n", list.toString());
        list.enqueueAtTail("Joelle");
        System.out.printf("After Joelle is enqueued, the revised Queue: %s", list);
        list.enqueueAtTail("Lukas");
        System.out.printf("After Lukas is enqueued, the revised Queue: %s\n", list);
        System.out.println("Let's dequeue first three elements from the queue in sequence ....");
        System.out.printf("The current Queue: %s\n", list.toString());
        for (int k=0;k<3;k++){
            System.out.printf("%s has been dequeued! The Revised queue: %s",list.dequeueAtHead(), list.toString());
        }
    }
    //method for the header message in the displayed output
    public static void myHeader(String lab) {
        String equalSigns = "=======================================================";
        System.out.printf("%s%n", equalSigns);
        System.out.printf("%s%nPrepared by: Aarya Patel%nStudent Number: 251215259%nGoal of Exercise: " +
                "To understand the functionalities and usefulness of Singly Link Lists!%n",lab);
        System.out.printf("%s%n", equalSigns);

    }
    //method for the footer message in the displayed output
    public static void myFooter(String labEnd){
        String equalSigns = "=======================================================";
        System.out.printf("%s", equalSigns);
        System.out.printf("\n%s\nSigning off - Aarya Patel\n", labEnd);
        System.out.printf("%s%n", equalSigns);

    }
}
