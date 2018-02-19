package com.bravetank.inspirationalQuotes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Quote implements Comparable<Quote>, Serializable {

    private String mAuthor;
    private String mDescription;
    private LocalDate mDateUploaded;

    public Quote(String author, String description, LocalDate dateUploaded) {
        this.mAuthor = author;
        this.mDescription = description;
        this.mDateUploaded = dateUploaded;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public LocalDate getDateUploaded() {
        return mDateUploaded;
    }

    @Override
    public String toString () {
        return String.format("Quote: \"%s\" by %s, uploaded on %s",
                mDescription,
                mAuthor,
                mDateUploaded);
    }

    public List<String> getWords(){
        String [] words = mDescription.toLowerCase().split("[^\\w#@']+");
        return Arrays.asList(words);
    }

    @Override
    public int compareTo(Quote other) {
        if(equals(other)){
            return 0;
        }
        int dateCmp = mDateUploaded.compareTo(other.mDateUploaded);
        if (dateCmp == 0){
            return mDescription.compareTo(other.mDescription);
        }
        return dateCmp;
    }

    private List<String> getWordsPrefixedWith(String prefix){
        List<String> results = new ArrayList<String>();
        for (String word: getWords()) {
            if(word.startsWith(prefix)){
                results.add(word);
            }
        } return results;
    }

    public List<String> getWordsPrefixedWithA(){
        return getWordsPrefixedWith("a");
    }


}


