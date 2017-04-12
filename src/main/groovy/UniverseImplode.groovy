class UniverseImplode {

    def fileContents = []

    void code() {
        readFromFile()
        println fileContents
        def numberOfCases = fileContents.get(0) as int
        removeElements(0)
        for (int i = 1; i <= numberOfCases; i++) {
            def centralSystems = populateListOfCentralSystems()
            def queries = populateListOfQueries()
            Set hsCentral = []
            def count = 0
            for (String query : queries) {
                if (!hsCentral.toString().contains(query)) {
                    hsCentral.add(query)
                    if(hsCentral.size() == centralSystems.size()){
                        count++
                        hsCentral.clear()
                    }
                }
            }
            println("Case #$i: $count")
        }
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
        removeElements(numberOfQueries - 1)
        return listOfQueriedSearchEngines
    }

    void removeElements(int linesToRemove) {
        0.upto(linesToRemove) {
            fileContents.remove(0)
        }
    }

    private Collection readFromFile() {
        new File("src/main/resources/universeImplode.txt").eachLine {
            line -> fileContents += "$line"
        }
    }

    static class runner {
        static void main(String[] args) {
            UniverseImplode universeImplode = new UniverseImplode()
            universeImplode.code()
        }
    }
}
