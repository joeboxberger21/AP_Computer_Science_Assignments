//Joe Boxberger
//U2-A9: A real class

class employeeTester_5Boxberger {
    public static void main(String[] args) {
        Employee steve = new Employee("Steve Johnson", 35000);
        Employee temp = new Employee();

        System.out.println(steve);
        System.out.println(temp);

        steve.raiseSalary(0.50);
        System.out.println(steve);
    }
}

class Employee {
    //------instance variables------
    String name;
    int salary;

    //-----cosntructors-----
    public Employee() {
        name = "Temp";
        salary = 20000;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    //-----methods-----
    
    //mutators
    public void raiseSalary(double raisePercent) {
        System.out.println(name + " has been given a " + raisePercent * 100 + "% raise!");
        salary *= raisePercent + 1.00;
    }

    //accessors
    public String toString() {
        return name + " is currently earning " + salary;
    }
}