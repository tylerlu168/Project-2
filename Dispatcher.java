import java.util.ArrayList;

public class Dispatcher
{
    private ArrayList<Bus> busQueue = new ArrayList<Bus>();

    public int addBus(Bus bus)
    {
        busQueue.add(bus);

        int find = 0;

        for (int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i) == bus)
            {
                find = i;
            }
        }
        return find;
    }

    public int addBus(Bus bus, int position)
    {
        int delete = -1;
        for (int i = 0; i < busQueue.size(); i++) {
            if(bus == busQueue.get(i))
            {
                delete = i;
            }
        }
        if (position >= busQueue.size() || position < 0)
        {
            busQueue.add(bus);
            busQueue.remove(delete);
            return busQueue.size()-1;
        }  else {
            Bus holder = busQueue.get(position);
            busQueue.set(position, bus);
            busQueue.set(delete, holder);
            return position;
        }
    }

    public Bus findBus(int id)
    {
        for (int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i).getID() == id)
            {
                return busQueue.get(i);
            }
        }
        return null;
    }

    public Bus removeBus(int id)
    {
        Bus holder;
        for (int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i).getID() == id)
            {
                holder = busQueue.get(i);
                busQueue.remove(i);
                return holder;
            }
        }
        return null;
    }

    public Bus dispatchBus()
    {
        int counter = 0;
        for (int i = 0; i < busQueue.size(); i++) {
            if(busQueue.get(i) == null)
            {
                counter++;
            }
        }
        if(counter == busQueue.size())
        {
            return null;
        }

        Bus placeholder = busQueue.get(0);
        busQueue.remove(0);
        return placeholder;
    }

    @Override
    public String toString()
    {
        String output = "";

        for (int i = 0; i < busQueue.size(); i++) {
            if(i == busQueue.size()-1)
            {
                output += busQueue.get(i);
            }
            else
            {
                output += busQueue.get(i) + "\n";
            }
        }
        return output;
    }


}
