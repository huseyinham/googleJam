class UniverseImplode {

    def fileContents = []

    void mainProcess() {
        readFromFile()
        println fileContents
        def numberOfCases = fileContents.get(0) as int
        removeElements(0)
        for (int i = 1; i <= numberOfCases; i++) {
            def centralSystems = populateListOfCentralSystems()
            def queries = populateListOfQueries()
            int count = calculateCountForCase(queries, centralSystems)
            println("Case #$i: $count")
        }
    }

    protected int calculateCountForCase(List<String> queries, List<String> centralSystems) {
        Set hsUsedCentralSystems = []
        def count = 0
        for (String query : queries) {
            println(hsUsedCentralSystems)
            println(query)
            if (!hsUsedCentralSystems.contains(query)) {
                if (hsUsedCentralSystems.size() == centralSystems.size() - 1) {
                    hsUsedCentralSystems.clear()
                    count++
                    println(count)
                }
                hsUsedCentralSystems.add(query)
            }
        }
        count
    }

    private List<String> populateListOfCentralSystems() {
        def numberOfSearchEngines = fileContents.get(0) as int
        removeElements(0)
        def listOfSearchEngines = []
        for (int i = 0; i < numberOfSearchEngines; i++) {
            listOfSearchEngines.add(fileContents.get(i))
        }
        removeElements(numberOfSearchEngines - 1)
        return listOfSearchEngines
    }

    private List<String> populateListOfQueries() {
        def numberOfQueries = fileContents.get(0) as int
        removeElements(0)
        def listOfQueriedSearchEngines = []
        for (int i = 0; i < numberOfQueries; i++) {
            listOfQueriedSearchEngines.add(fileContents.get(i))
        }
        if (numberOfQueries > 0)
            removeElements(numberOfQueries - 1)

        return listOfQueriedSearchEngines
    }

    private void removeElements(int linesToRemove) {
        0.upto(linesToRemove) {
            fileContents.remove(0)
        }
    }

    private Collection readFromFile() {
        new File("src/main/resources/A-small-practice.in").eachLine {
            line -> fileContents += "$line"
        }
    }

    static class runner {
        static void main(String[] args) {
            UniverseImplode universeImplode = new UniverseImplode()
            universeImplode.mainProcess()
        }
    }
}
