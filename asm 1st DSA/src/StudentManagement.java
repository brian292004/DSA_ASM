import java.util.*;

//public class StudentManagement {
//    public StudentManagement() {
//        studentList = new LinkedList<>();
//    }
//    Scanner scanner = new Scanner(System.in);
//    private LinkedList<Student> studentList;
//
//    public void addStudent() {
//        System.out.print("Enter the ID of the student: ");
//        String id = scanner.next();
//        System.out.print("Enter the name of the student: ");
//        String name = scanner.next();
//        System.out.print("Enter the marks of the student: ");
//        double marks = scanner.nextDouble();
//        Student newStudent = new Student(id, name, marks);
//        studentList.add(newStudent); // Thêm đối tượng Student vào LinkedList
//
//        System.out.println("Student added successfully!");
//
//        // Hiển thị danh sách sinh viên sau khi thêm
//        System.out.println("Updated student list:");
//        for (Student student : studentList) {
//            System.out.println(
//                    "Student name: " + student.getId() +" , "+
//                    "Student id: " + student.getName() +" , "+
//                    "Student mark: " + student.getMarks()+" , "+
//                    "Student ranking: " + student.getRanking()
//            );
//        }
//    }
//}


public class StudentManagement {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students");
            System.out.println("5. Search Student");
            System.out.println("6. QuickSort Students");
            System.out.println("7. Display Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    sortStudentsByMarks();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    QuicksortStudentsByMarks();
                    break;
                case 7:
                    displayStudents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.println("--------------------");
        }

        scanner.close();
    }

    public void addStudent() {
        System.out.println("Add Student");
        System.out.print("Enter Student ID: ");
        String id = scanner.next();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        students.add(student);

        System.out.println("Student added successfully!");

    }
    public void printStudent(){
        if (students.isEmpty()) {
            System.out.println("No students found.");
        }
        else {
            int index = 1;
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(index +". "+student.toString());
                index++;
            }
        }
    }
    public void editStudent() {
        printStudent();
        System.out.println("Edit Student");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        if(id != "0" && id != null){
            Student update = null;
            for(Student student : students){
                if(student.getId().equals(id)){
                    update = student;
                    break;
                }
            }
            if(update != null){
                System.out.println("nhap ten: ");
                String newName = scanner.nextLine();
                System.out.println("nhap MARK: ");
                double newMark = scanner.nextDouble();
                update.setName(newName);
                update.setMark(newMark);
                System.out.println("CAP NHAT THANH CONG");
            }

        }
    }

    public void deleteStudent() {

            System.out.println("Delete Student");
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();

            boolean studentFound = false;
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getId().equals(id)) {
                    iterator.remove();
                    studentFound = true;
                    break;
                }
            }

            if (studentFound) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
    }

    public void searchStudent() {
        System.out.println("Search Student");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        boolean studentFound = false;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found:");
                System.out.println(student.toString());
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student not found!");
        }
    }

    public void sortStudentsByMarks() {
        int size = students.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Student temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }
        System.out.println("Sắp xếp học sinh theo điểm thành công.");
        displayStudents();
    }

    public void displayStudents() {
        System.out.println("Danh sách học sinh đã được sắp xếp theo điểm:");
        for (Student student : students) {
            System.out.println(student.getName() + " - Điểm: " + student.getMarks());
        }
    }

    public void QuicksortStudentsByMarks() {
        quickSort(students, 0, students.size() - 1);
        System.out.println("Sắp xếp học sinh theo điểm tăng dần thành công.");
        displayStudents();
    }

    public void quickSort(List<Student> students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);

            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    public int partition(List<Student> students, int low, int high) {
        double pivot = students.get(high).getMarks();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (students.get(j).getMarks() > pivot) {
                i++;

                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }

        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);

        return i + 1;
    }

}
