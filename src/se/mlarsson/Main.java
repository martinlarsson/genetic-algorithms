package se.mlarsson;

import se.mlarsson.ga.GeneticAlgorithm;
import se.mlarsson.ga.Population;

public class Main {

    public static void main(String[] args) {
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.95,0);
        Population population = ga.initPopulation(50);
        ga.evalPopulation(population);
        int generation = 1;
        while (!ga.isTerminationConditionMet(population)) {
            System.out.println("Best solution: "+
                    population.getFittest(0).toString());
            population = ga.crossoverPopulation(population);
            //TODO Apply mutation
            ga.evalPopulation(population);
            generation++;
        }
        System.out.println("Found solution in " + generation + " generations");
        System.out.println("Best solution: " +
                population.getFittest(0).toString());
    }
}