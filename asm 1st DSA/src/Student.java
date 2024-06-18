public class Student {
//    private String name;
//    private String id;
//    private double marks;
//
//    public Student(String name, String id, double marks) {
//        this.name = name;
//        this.id = id;
//        this.marks = marks;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public double getMarks() {
//        return marks;
//    }
//
//    public void setMarks(double marks) {
//        this.marks = marks;
//    }
//
//    public String getRanking() {
//        if (marks >= 0 && marks < 5.0) {
//            return "Fail";
//        } else if (marks >= 5.0 && marks < 6.5) {
//            return "Medium";
//        } else if (marks >= 6.5 && marks < 7.5) {
//            return "Good";
//        } else if (marks >= 7.5 && marks < 9.0) {
//            return "Very Good";
//        } else if (marks >= 9.0 && marks <= 10.0) {
//            return "Excellent";
//        } else {
//            return "Invalid marks";
//        }
//    }

    private String id;
    private String name;
    private double marks;
    private String rank;

    public Student(String id, String name, double marks) {
        this.marks = marks;
        this.id = id;
        this.name = name;
        this.rank = setRank(marks);


    }

    public String getRank() {
        return rank;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMark(double marks){
        this.marks = marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " - Name: " + getName() + " - Marks: " + getMarks() + " - Rank: " + getRank();
    }

    public String setRank(double marks) {
        if (marks >= 0 && marks < 5.0) {
            rank = "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            rank = "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            rank = "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            rank = "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            rank = "Excellent";
        } else {
            rank = "Invalid";
        }
        return rank;
    }
}

