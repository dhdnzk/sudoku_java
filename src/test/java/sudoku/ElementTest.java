package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class ElementTest {


    @Test
    public void Element () {
        Element testElement = new Element();
        testElement.setConfirmedElement( 8 );
        TestCase.assertEquals( 8, testElement.getConfirmedElement() );
        TestCase.assertEquals( 0, testElement.getNumOfCandidates() );
        TestCase.assertEquals( null, testElement.getCandidates() );

        Element testElement2 = new Element();
        testElement2.setConfirmedElement( 10 );
        testElement2.removeACandidate( 9 );
        TestCase.assertEquals( 0, testElement2.getConfirmedElement() );
        TestCase.assertEquals( 0, testElement2.getCandidates()[8] );
        for (int i = 0; i < 8; i ++ ) {
            TestCase.assertEquals(i + 1, testElement2.getCandidates()[i]);
        }
    }
}

