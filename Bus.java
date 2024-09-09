import java.util.ArrayList;

public class Bus
{
    private ArrayList<Person> passengers;

    private static int nextID;

    private int busId;

    public Bus()
    {
        passengers = new ArrayList<Person>();
        busId = nextID;
        nextID++;
    }

    public int getID()
    {
        return busId;
    }

    public void addPerson(Person person)
    {
        passengers.add(person);
    }

    public boolean removePerson(Person person)
    {
        passengers.remove(person);

        int counter = 0;

        for (int i = 0; i < passengers.size(); i++) {
            if(passengers.get(i) != person)
            {
                counter++;
            }
        }
        if(counter == passengers.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Person findPerson(String name)
    {
        for (int i = 0; i < passengers.size(); i++) {
            if(passengers.get(i).getName().equals(name))
            {
                return passengers.get(i);
            }
        }
        return null;
    }

    public static boolean transferPerson(Bus bus1, Bus bus2, Person person)
    {
        for (int i = 0; i < bus1.passengers.size(); i++) {
            if(bus1.passengers.get(i) == person)
            {
                bus2.passengers.add(bus1.passengers.get(i));
                bus1.passengers.remove(i);
                return true;
            }
        }
        return false;

    }

    public String getPassengers()
    {
        String output = "";
        for (int i = 0; i < passengers.size(); i++) {
            if(i == passengers.size()-1)
            {
                output += passengers.get(i).toString();
            }
            else
            {
                output += passengers.get(i).toString() + "\n";
            }
        }
        return output;
    }


    @Override
    public String toString()
    {
        String output = "";
        output+= busId;
        return output;
    }
}
