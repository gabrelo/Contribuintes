package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<TaxPayer>();

        System.out.println("Enter the number of taxpayers: ");
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            System.out.println("Taxpayer # " + i + " data:");
            System.out.println("Indivisual or Company i/c?");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Anual Income: ");
            Double anualIncome = sc.nextDouble();
            if(type == i){
                System.out.println("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                Individual x = new Individual(name, anualIncome, healthExpenditures);
                list.add(x);
            }
            else{
                System.out.println("Number of Employees: ");
                Integer numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }

        }

        System.out.println();;
        System.out.println("TAXES PAID: ");
        for(TaxPayer tp : list){
            System.out.println(tp.getName() + ": $ " + tp.tax());
        }

        double sum = 0.0;
        for(TaxPayer tp : list){
            sum += tp.tax();
        }

        System.out.println("TOTAL TAXES: "+ sum);
















        sc.close();
    }
}
