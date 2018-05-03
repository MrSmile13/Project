package different;

public class Salary {
    public static void main(String[] args) {

        Worker Ivan = new Worker("Иван", 8, 60);
        System.out.println(Ivan.salaryOut());
    }
}

class Worker{
    public double salaryHour, workHour;
    public String name;

    Worker(String name, int salaryHour, int workHour) {
        this.name = name;
        this.salaryHour = salaryHour;
        this.workHour = workHour;
    }

    private double salaryCount(double salaryHour, double workHour) {
        double salaryWeek;
        if(workHour <= 40) {
            salaryWeek = salaryHour * workHour;
            return salaryWeek;
        }  else if(workHour > 40 && workHour <= 60) {
            salaryWeek = (salaryHour * 40) + ((salaryHour * (workHour - 40)) * 1.5d);
            return salaryWeek;
        } else {
            salaryWeek = (salaryHour * 40) + (salaryHour * 20 * 1.5d);
            return salaryWeek;
        }
    }

    public String salaryOut() {
        if(workHour <= 60) {
            String s = String.format("%s\nЗарплата в час: %.2f; отработано часов: %.1f\n", name,salaryHour, workHour);
            double salaryWeek = salaryCount(salaryHour, workHour);
            return String.format("%sЗарплата в неделю: %.2f\n", s, salaryWeek);
        } else {
            String s = String.format("Зарплата в час: %.2f; отработано часов: %.1f\n", salaryHour, workHour);
            double salaryWeek = salaryCount(salaryHour, workHour);
            return String.format("%s\nЧасы не могут превышать 60. Зарплата рассчитана исходя из 60 рабочих часов\n%sЗарплата в неделю: %.2f\n", name, s, salaryWeek);
        }
    }
}
