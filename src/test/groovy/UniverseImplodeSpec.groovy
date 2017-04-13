import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UniverseImplodeSpec {

    private UniverseImplode universeImplode

    @Before
    void setup(){
        universeImplode = new UniverseImplode()
    }

    @Test
    void testSwitchWhenQueriesWithIdenticalStringsInside(){
        //Tests that 'Googol' and 'Googol Bulgaria' are treated differently to avoid 'contains' issue

        List<String> queries = ['Googol Bulgaria', 'Alibubu', 'Googol', 'Googol Bulgaria', 'Googol']
        List<String> centralSystems = ['Googol Bulgaria', 'Googol', 'Alibubu']
        Assert.assertEquals(1, universeImplode.calculateCountForCase(queries, centralSystems))
    }

    @Test
    void testNoSwitchesWhenAllQueriesAreTheSame(){
        List<String> queries = ['Googol', 'Googol', 'Googol', 'Googol', 'Googol']
        List<String> centralSystems = ['Googol', 'Yeehaw']
        Assert.assertEquals(0, universeImplode.calculateCountForCase(queries, centralSystems))
    }

    @Test
    void testSwitchIsCountedIfSwitchNeededAtEnd(){
        List<String> queries = ['Googol Bulgaria', 'Alibubu', 'Googol', 'Googol Bulgaria', 'Alibubu']
        List<String> centralSystems = ['Googol Bulgaria', 'Googol', 'Alibubu']
        Assert.assertEquals(2, universeImplode.calculateCountForCase(queries, centralSystems))
    }

    @Test
    void whatHappensIfOnlyOneCentralSearchEngine(){
        //created out of curiosity - wasn't a scenario in the problem so logic doesn't make sense
        List<String> queries = ['Googol Bulgaria', 'Alibubu', 'Googol', 'Googol Bulgaria', 'Alibubu']
        List<String> centralSystems = ['Googol']
        Assert.assertEquals(1, universeImplode.calculateCountForCase(queries, centralSystems))
    }
}
