import org.junit.Assert
import org.junit.Test

class UniverseImplodeSpec {

    @Test
    void testSwitchWhenQueriesWithIdenticalStringsInside(){
        //Tests that 'Googol' and 'Googol Bulgaria' are treated differently
        UniverseImplode code = new UniverseImplode()
        List<String> queries = ['Googol', 'Googol Bulgaria', 'Googol', 'Googol Bulgaria', 'Alibubu', 'Alibubu', 'Alibubu',
                                'Googol', 'Googol Bulgaria', 'Googol', 'Googol', 'Googol', 'Googol', 'Alibubu', 'Alibubu',
                                'Alibubu', 'Alibubu', 'Googol Bulgaria', 'Alibubu']
        List<String> centralSystems = ['Googol Bulgaria', 'Googol', 'Alibubu']
        Assert.assertEquals(3, code.calculateCountForCase(queries, centralSystems))
    }

}
