/**
 * Created by rohanrampuria on 1/12/17.
 */
/*
 * Below is the code to sort Person class based on its fields
 * Few considered tradeoffs:
 * 1. I have implemented the sort method using Comparators
 * 2. I have implemented an additional function "parse" to parse the request string
 *    and get the value of sortfield and ascending
 * 3. Time complexity of sort function here is "O(n log(n))" + O(1) (for switch case)
 * 4. As the output of this program I am printing the first name from the sorted list in parse function.
 * 5. I have also included the condition for null fields.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author rohanrampuria
 */
class Person {

    String ssn;
    Date dateOfBirth;
    String firstName;
    String lastName;
    Double heightIn;
    Double weightLb;

    public Person(String ssn, Date dob, String firstname, String lastname, Double height, Double weight) {
        this.ssn = ssn;
        this.dateOfBirth = dob;
        this.firstName = firstname;
        this.lastName = lastname;
        this.heightIn = height;
        this.weightLb = weight;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSSN() {
        return this.ssn;
    }

    public Double getHeight() {
        return this.heightIn;
    }

    public Double getWeight() {
        return this.weightLb;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public static void main(String[] args) throws ParseException {

        // Adding sample data to the persons list
        List<Person> persons = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        persons.add(new Person(null, df.parse("12/07/1992"), "Bohan", "Rampuria", 59.0, null));
        persons.add(new Person("184-45-6534", df.parse("22/08/1996"), "Anhan", "Jain", 69.0, 12.0));
        persons.add(new Person("384-65-3164", df.parse("02/08/1991"), "Jauan", null, 29.0, 142.0));
        persons.add(new Person("284-45-1064", df.parse("01/12/2016"), "Jack", "Samuels", 79.0, 132.0));


        // Testing various cases here

        System.out.println("Sorting based on SSN and Descending order:-");
        parse(persons, "/people?sortField=ssn&ascending=false");

        System.out.println("Sorting based on First Name and Ascending order:-");
        parse(persons, "/people?sortField=firstName&ascending=true");

        System.out.println("Sorting based on DOB and Descending order:-");
        parse(persons, "/people?sortField=dateOfBirth&ascending=false");

        System.out.println("Sorting based on Height and Ascending order:-");
        parse(persons, "/people?sortField=heightIn&ascending=true");
    }

    static void parse(List<Person> list, String request) {
        String sortfield = null;
        String ascending = null;
        StringTokenizer st = new StringTokenizer(request, "?");
        st.nextElement();
        String toparse = (String) st.nextElement();

        st = new StringTokenizer(toparse, "&");
        while (st.hasMoreTokens()) {
            String param = st.nextToken();
            if (param.startsWith("sortField")) {
                sortfield = param.substring(10);
            } else if (param.startsWith("ascending")) {
                ascending = param.substring(10);
            }
        }

        //sort Function called here
        List<Person> lst = sort(list, sortfield, ascending);

        //Printing first name of sorted list to display
        for (Person p : lst) {
            System.out.println(p.firstName);
        }
    }

    static List<Person> sort(Iterable<Person> people, String sortField, String type) {

        List<Person> lst = new ArrayList<>();
        Iterator<Person> itr = people.iterator();
        while (itr.hasNext()) {
            lst.add(itr.next());
        }

        switch (sortField) {
            case "ssn":
                Collections.sort(lst, new SSNComparator());
                break;
            case "firstName":
                Collections.sort(lst, new FirstNameComparator());
                break;
            case "lastName":
                Collections.sort(lst, new LastNameComparator());
                break;
            case "heightIn":
                Collections.sort(lst, new HeightComparator());
                break;
            case "weightLb":
                Collections.sort(lst, new WeightComparator());
                break;
            case "dateOfBirth":
                Collections.sort(lst, new DobComparator());
                break;
            default:
                break;
        }
        if (type.equals("true")) {
            return lst;
        } else {
            Collections.reverse(lst);
            return lst;
        }

    }
}

/*
 * Below are all custom comparator class
 */

class FirstNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.firstName == null || o2.firstName == null) {
            return 0;
        }
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

class LastNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.lastName == null || o2.lastName == null) {
            return 0;
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}

class DobComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.dateOfBirth == null || o2.dateOfBirth == null) {
            return 0;
        }
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}

class SSNComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.ssn == null || o2.ssn == null) {
            return 0;
        }
        return o1.getSSN().compareTo(o2.getSSN());
    }
}

class HeightComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.heightIn == null || o2.heightIn == null) {
            return 0;
        }
        return o1.getHeight().compareTo(o2.getHeight());
    }
}

class WeightComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.weightLb == null || o2.weightLb == null) {
            return 0;
        }
        return o1.getWeight().compareTo(o2.getWeight());
    }
}

