public class Person
{
    private String name;
    private int ticketNumber;

    private static int nextTicketNumber;

    public Person()
    {
        name = "NO NAME";
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public Person(String name)
    {
        this.name = name;
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public String getName() // see if this is possible
    {
        return name;
    }

    @Override
    public String toString()
    {
        String output = "";
        output += ticketNumber + "\t" + name;
        return output;
    }
}
