package com.bravetank.inspirationalQuotes;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        //Printing out QuotesRepository Array
        QuotesRepository quotesRepository = new QuotesRepository();
        Quote[] quotes = quotesRepository.getQuotes();
        System.out.printf("There are %d quotes. %n", quotes.length);
        for (Quote quotation : quotes) {
            System.out.println(quotation + "%n");
            List<String> quotationWords = quotation.getWords();
            System.out.println(quotationWords);
            List<String> aWords = quotation.getWordsPrefixedWithA();
            System.out.println(aWords);
        }

        //A count of words starting with A
        Map<String, Integer> hashAWordCounts = new HashMap<String, Integer>();
        for (Quote quotation : quotes) {
            for (String aWord : quotation.getWordsPrefixedWithA()) {
                Integer count = hashAWordCounts.get(aWord);
                if (count == null) {
                    count = 0;
                }
                count++;
                hashAWordCounts.put(aWord, count);
            }
        }
        System.out.printf("Words starting with A: %s %n", hashAWordCounts);


        //Quotes by Author
        Map<String, List<Quote>> quotesByAuthor = new HashMap<String, List<Quote>>();
        for (Quote quotation: quotes){
            List<Quote> authoredQuotes = quotesByAuthor.get(quotation.getAuthor());
            if (authoredQuotes == null){
                  authoredQuotes = new ArrayList<Quote>();
                  quotesByAuthor.put(quotation.getAuthor(), authoredQuotes);
                }
               authoredQuotes.add(quotation);
            }
        System.out.printf("Quotes by author: %s %n", quotesByAuthor);
        System.out.printf("Quotes by author: %s %n", quotesByAuthor.get("Paul McCartney"));


        }

   }

//Other things that could be added

// Using Set
// Could use TreeSet to make it alphabetical - currently imported but not used

//        Set<String> allLWords = new HashSet<String>();
//        for (Quote quotation: quotes) {
//            allLWords.addAll(quotation.getWordsPrefixedWithL());
//        }
//        System.out.printf("L Words: %s %n", allLWords);




//Sorting

//         Can sort because of the compareTo method in the Quote class
//       Arrays.sort(quotes);
//       for (Quote exampleQuote: quotes) {
//            System.out.println(exampleQuote);
//        }


//Saving

        //Quote[] quotes = {quote, secondQuote};
        //QuotesLoadAndSave.save(quotes);


// Loading

        // Quote[] reloadedQuotes = QuotesLoadAndSave.load();
        //        for (Quote reloaded: reloadedQuotes) {
        //            System.out.println(reloaded);
        //        }




