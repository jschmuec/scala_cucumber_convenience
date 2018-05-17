Scala-Cucumber-Convenience
===

This is a package that packages various things that make working iwth Cucumber in Scala more convenient. To add this package add the following line to your `build.sbt`.

```Scala
libraryDependencies += "com.schmueckers" %% "scala-cucumber-convenience" % "0.1.0" % Test
```

This will automatically import all the dependencies you need to use Cucumber in Scala. Essentially, you are creating the following dependencies:

```Scala
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "2.0.1"

libraryDependencies += "io.cucumber" % "cucumber-junit" % "2.3.1"
```

You are also getting a trait called ```cucumber_convenience``` which contains a number of regular 
expression which are useful for to take Gherkin expressions apart and some helper functions.

```Scala
Given(s"""^$r_mw is an interbank counterparty$$""") { (cptyName: String) =>
    interbankCpties = Branch(cptyName) :: interbankCpties
}
```

`$r_mw` will be replaced by a reg ex which mattes multiple words separated by spaces.

And the following code will convert the Java DataTable you are getting from Cucumber into a 
Scala list of maps.

```Scala
Given("Some data in a table") {
  (javaDT : DataTable) =>
    val maps : List[Map[String, String]] = dataTableToScalaMaps( javaDT )
}
```