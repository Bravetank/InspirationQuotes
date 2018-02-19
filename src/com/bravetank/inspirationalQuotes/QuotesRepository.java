package com.bravetank.inspirationalQuotes;

import java.time.LocalDate;

public class QuotesRepository {



    Quote quote = new Quote(
            "John Lennon",
            "A dream you dream alone is only a dream. A dream you dream together is reality.",
            LocalDate.of(2018, 02, 19));

    Quote secondQuote = new Quote("John Lennon",
            "There's nowhere you can be that isn't where you're meant to be.",
            LocalDate.of(2018, 02, 18));


    Quote thirdQuote = new Quote("Paul McCartney",
            "You can judge a man's true character by the way he treats his fellow animals.",
            LocalDate.of(2018, 02, 18));

    Quote [] quotes = {quote, secondQuote, thirdQuote};

    public Quote[] getQuotes() {
        return quotes;
    }

    public Quote getQuote() {
        return quote;
    }

    public Quote getSecondQuote() {
        return secondQuote;
    }

    public Quote getThirdQuote() {
        return thirdQuote;
    }
}

