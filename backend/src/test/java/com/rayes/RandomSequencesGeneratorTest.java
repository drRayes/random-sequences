package com.rayes;

import com.rayes.service.RandomSequencesGenerator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RandomSequencesGeneratorTest extends TestCase {
    @Autowired
    RandomSequencesGenerator generator;

    @Test
    public void setSizeShouldEqualToLengthArgument() {
        Integer length = 11;
        Set<Integer> sequence = generator.generateSequence(length);

        assertTrue(length.equals(sequence.size()));
    }

    @Test
    public void arraySizeShouldEqualToFive() {
        Integer sizeOfArray = 5;
        ArrayList<Set<Integer>> sequences = generator.generateAnArrayOfFiveSequences(15);

        assertTrue(sizeOfArray.equals(sequences.size()));
    }

}
