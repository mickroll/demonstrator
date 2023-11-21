package com.example.reproducer.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.blazebit.persistence.CriteriaBuilder;
import com.example.reproducer.model.Person;
import com.example.reproducer.model.PersonId;

public class SampleTest extends AbstractSampleTest {

    @Test
    public void embeddedIdKeysetTest() {
        transactional(em -> {
            CriteriaBuilder<Person> query = cbf.create(em, Person.class);
            query.orderByAsc("name")
                    .orderByAsc("id");
            var paginatedQuery = query
                    .page(0, 50)
                    .withKeysetExtraction(true);
            final var foundRows = paginatedQuery.getResultList();

            final var keyset = foundRows.getKeysetPage().getHighest();
            assertNotNull("keyset should be present", keyset);
            assertEquals(2, keyset.getTuple().length);
            assertNotNull("keyset value 0 be present", keyset.getTuple()[0]);
            assertNotNull("keyset value 1 be present", keyset.getTuple()[1]);
            assertEquals(String.class, keyset.getTuple()[0].getClass());
            assertEquals(PersonId.class, keyset.getTuple()[1].getClass());
        });
    }
}
