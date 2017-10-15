package se.mlarsson.ga;

import com.sun.org.apache.bcel.internal.generic.POP;

public class GeneticAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this. mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    public Population initPopulation(int chromosomeLength) {
        Population population = new Population(this.populationSize,
                chromosomeLength);
        return population;
    }

    public double calcFitness(Individual individual) {
        int correctGenes = 0;
        for (int i = 0; i < individual.getChromosomeLength(); i++) {
            if (individual.getGene(i) == 1) {
                correctGenes++;
            }
        }
        double fitness = (double) correctGenes /
                individual.getChromosomeLength();
        individual.setFitness(fitness);
        return fitness;
    }

    public void evalPopulation(Population population) {
        double populationFitness = 0;

        for (Individual individual : population.getIndividuals()) {
            populationFitness += calcFitness(individual);
        }

        population.setPopulationFitness(populationFitness);
    }

    public boolean isTerminationConditionMet(Population population) {
        for (Individual individual : population.getIndividuals()) {
            if (individual.getFitness() == 1) {
                return true;
            }
        }
        return false;
    }
}
