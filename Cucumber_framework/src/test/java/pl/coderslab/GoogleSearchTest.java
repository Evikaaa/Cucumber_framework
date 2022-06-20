package pl.coderslab;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/Cucumber/Features/", plugin = {"pretty","html:out.html"}, tags = "@edit")

    //otagowany hotel, więc dodane , tags = "@hotel", odpali tylko test hotel
    //    @CucumberOptions(features = "src/Cucumber/Features/", plugin = {"pretty","html:out.html"}, tags = "@hotel")
    //not @hotel uruchomi wszystkie testy poza hotelem, można odsiać te, które nas w tej chwili nie interesują
    //    @CucumberOptions(features = "src/Cucumber/Features/", plugin = {"pretty","html:out.html"}, tags = "not @hotel")
    //target > out > prawy myszy > open in broswer chrome i pokaże się "pretty" raport

    public class GoogleSearchTest {
        //ciało metody zostaje puste. cucumber znajdzie kroki w wyżej podanej ścieżce
    }
