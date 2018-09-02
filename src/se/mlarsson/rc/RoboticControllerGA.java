package se.mlarsson.rc;

import se.mlarsson.ga.Individual;
import se.mlarsson.ga.Population;

public class RoboticControllerGA {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;

    public RoboticControllerGA(int populationSize, double mutationRate,
                               double crossoverRate, int elitismCount) {
        this.populationSize = populationSize;
        this. mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    public Population initPopulation(int chromosomeLength) {
        return new Population(this.populationSize,
                chromosomeLength);
    }

    public Population mutatePopulation(Population population) {
        Population newPopulation = new Population(this.populationSize);
        for (int i = 0; i < population.size(); i++) {
            Individual individual = population.getFittest(i);
            for (int j = 0; j < individual.getChromosomeLength(); j++) {
                if (i > this.elitismCount) {
                    if (this.mutationRate > Math.random()) {
                        int newGene = 1;
                        if (individual.getGene(j) == 1) {
                            newGene = 0;
                        }
                        individual.setGene(j, newGene);
                    }
                }
            }
            newPopulation.setIndividual(i, individual);
        }
        return newPopulation;
    }
}
