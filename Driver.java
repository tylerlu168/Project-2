import java.util.Scanner;

public class Driver
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int terminate = 0;

        Dispatcher dispatch  = new Dispatcher();
        System.out.println("Bus Dispatching System");
        System.out.println();

        while(terminate == 0)
        {
            System.out.println("1. Add bus" + "\n" +
                                "2. Add Person to bus" + "\n" +
                                "3. Remove bus" + "\n" +
                                "4. Remove person" + "\n" +
                                "5. List passengers" + "\n" +
                                "6. List busses" + "\n" +
                                "7. Requeue bus" + "\n" +
                                "8. Transfer person" + "\n" +
                                "9. Dispatch bus" + "\n" +
                                "0. Exit");

            int choice = input.nextInt();
            System.out.println();

            if(choice == 1)
            {
                Bus newBus = new Bus();
                int position = dispatch.addBus(newBus);

                System.out.println("Bus " + newBus.getID() + " added to position " + position);
                System.out.println();
            }
            else if(choice == 2)
            {
                System.out.print("Enter bus id: ");
                int id = input.nextInt();
                Bus check = dispatch.findBus(id);

                if(check == null)
                {
                    System.out.println("No bus with id " + id);
                    System.out.println();

                }
                else
                {
                    input.nextLine();
                    System.out.print("Enter person's name: ");
                    String name = input.nextLine();
                    Person newPerson = new Person(name);
                    check.addPerson(newPerson);
                    System.out.println(name + " has been added to bus " + id);
                    System.out.println();

                }
            }
            else if(choice == 3)
            {
                System.out.print("Enter bus id: ");
                int id = input.nextInt();
                Bus check = dispatch.findBus(id);
                if(check == null)
                {
                    System.out.println("No bus with id " + id);
                    System.out.println();
                }
                else {
                    dispatch.removeBus(id);
                    System.out.println("Bus " + id + " removed");
                    System.out.println();
                }
            }
            else if(choice == 4)
            {
                System.out.print("Enter bus id: ");
                int id = input.nextInt();
                Bus check = dispatch.findBus(id);

                if(check == null)
                {
                    System.out.println("No bus with id " + id);
                    System.out.println();

                }
                else {
                    input.nextLine();
                    System.out.print("Enter person's name: ");
                    String name = input.nextLine();
                    Person checkPerson = check.findPerson(name);
                    if(checkPerson == null)
                    {
                        System.out.println(name + " is not in bus " + id);
                        System.out.println();
                    }
                    else
                    {
                        boolean checkTrue = check.removePerson(checkPerson);
                        if(checkTrue == true)
                        {
                            System.out.println(name + " has been removed from bus " + id);
                            System.out.println();
                        }
                        else {
                            System.out.println("No such person found in bus " + id);
                            System.out.println();
                        }
                    }
                }
            }
            else if(choice == 5)
            {
                System.out.print("Enter bus id: ");
                int id = input.nextInt();

                Bus check = dispatch.findBus(id);

                if(check == null)
                {
                    System.out.println("No bus with id " + id);
                    System.out.println();
                }
                else {
                    System.out.println("Bus " + id);
                    System.out.println(check.getPassengers());
                    System.out.println();
                }
            }
            else if(choice == 6)
            {
                System.out.println("BUS QUEUE");
                System.out.println(dispatch.toString());
                System.out.println();
            }
            else if(choice == 7)
            {
                System.out.print("Enter bus id: ");
                int id = input.nextInt();

                Bus check = dispatch.findBus(id);

                if(check == null)
                {
                    System.out.println("No bus with id " + id);
                    System.out.println();
                }
                else {
                    input.nextLine();
                    System.out.print("Enter new bus position: ");
                    int id2 = input.nextInt();
                    int position = dispatch.addBus(check, id2);

                    System.out.println("Bus " + id + " added to position " + position);
                    System.out.println();
                }
            }
            else if(choice == 8)
            {
                input.nextLine();
                System.out.print("Enter person's name: ");
                String name = input.nextLine();
                System.out.print("Enter id of bus 1: ");
                int bus1 = input.nextInt();
                System.out.print("Enter id of bus 2: ");
                int bus2 = input.nextInt();

                //input.nextLine();


                Bus one = dispatch.findBus(bus1);
                Bus two = dispatch.findBus(bus2);
                Person person = one.findPerson(name);
                if(one == null)
                {
                    System.out.println("No bus with id " + bus1);
                    System.out.println();
                }
                if(two == null)
                {
                    System.out.println("No bus with id " + bus2);
                    System.out.println();
                }
                if(person == null)
                {
                    System.out.println("No person named " + name);
                    System.out.println();
                }
                else if(one != null && two != null && person != null)
                {
                    boolean check = Bus.transferPerson(one, two, person);
                    if(check == true)
                    {
                        System.out.println("Person transferred sucessfully");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Person transfer failed");
                        System.out.println();
                    }
                }
            }
            else if(choice == 9)
            {


                Bus check = dispatch.dispatchBus();

                if (check == null)
                {
                    System.out.println("Bus queue is empty");
                    System.out.println();
                }
                else {
                    int id = check.getID();
                    System.out.println("Bus " + id + " has been dispatched");
                    System.out.println();
                }
            }
            else if(choice == 0)
            {
                System.out.println("Shutting down.");
                terminate = 1;
            }
        }

    }

}
