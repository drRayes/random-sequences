package com.rayes.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Class for generating sequences of prime numbers.
 */
@Service
public class RandomSequencesGenerator {

    /**
     * Method generate an array list with five sequences of non-repeating primes.
     * @param length
     * @return Arraylist
     */
    public ArrayList<Set<Integer>> generateAnArrayOfFiveSequences(Integer length) {
        ArrayList<Set<Integer>> randomSequences = new ArrayList<>(5);
        for(int i = 0; i < 5; i++) {
            randomSequences.add(generateSequence(length));
        }

        return randomSequences;
    }

    /**
     * Method generate an set with sequence of non-repeating primes.
     * @param length
     * @return
     */
    public Set<Integer> generateSequence(Integer length) {
        Set<Integer> sequence = new HashSet<>();
        Random random = new Random();
        while(sequence.size() < length) {
            Integer randomInteger = random.nextInt(2147483647);
            BigInteger bigInteger = BigInteger.valueOf(randomInteger);
            if(bigInteger.isProbablePrime((int) Math.log(randomInteger))) {
                sequence.add(randomInteger);
            }
        }

        return sequence;
    }
}
