import java.util.*;

/* Student Class */
class Student {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Remove duplicates (based on ID)
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student s = (Student) obj;

        return id == s.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/* Comparator for Sorting */
class MarksComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.marks, s1.marks); // Descending
    }
}

/* Main Class */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList for storage
        ArrayList<Student> list = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        // Input students
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            list.add(new Student(id, name, marks));
        }

        // Remove duplicates using Set
        Set<Student> set = new HashSet<>(list);

        // Convert back to ArrayList
        ArrayList<Student> students =
                new ArrayList<>(set);

        // HashMap for fast lookup
        HashMap<Integer, Student> map =
                new HashMap<>();

        for (Student s : students) {
            map.put(s.id, s);
        }

        // Sort using Comparator
        Collections.sort(students, new MarksComparator());

        // Report
        System.out.println("\n----- Student Report -----\n");

        System.out.printf("%-10s %-15s %-10s\n",
                "ID", "Name", "Marks");
        System.out.println("--------------------------------");

        for (Student s : students) {

            System.out.printf("%-10d %-15s %-10.2f\n",
                    s.id, s.name, s.marks);
        }

        // Search Student
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();

        Student found = map.get(searchId);

        if (found != null) {

            System.out.println("\n--- Student Details ---");
            System.out.println("Student Name: " + found.name);
            System.out.println("Marks: " + found.marks);
        }
        else {
            System.out.println("Student Not Found");
        }

        // Collection Hierarchy
        System.out.println("\nCollection Hierarchy:");
        System.out.println("ArrayList -> List -> Collection");
        System.out.println("HashSet -> Set -> Collection");
        System.out.println("HashMap -> Map");

        sc.close();
    }
}
