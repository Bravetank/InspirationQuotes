package com.bravetank.inspirationalQuotes;

import java.io.*;

public class QuotesLoadAndSave {
    public static void save(Quote[] quotes) {
        try (
            FileOutputStream fos = new FileOutputStream("quotes.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(quotes);
        } catch (IOException ioe) {
            System.out.println("Problem saving Quotes");
            ioe.printStackTrace();
        }
    }

    public static Quote[] load() {
        Quote[] quotes = new Quote[0];
        try (
            FileInputStream fis = new FileInputStream("quotes.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            quotes = (Quote[]) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Problem loading file");
            ioe.printStackTrace();
        } catch(ClassNotFoundException cnfe){
            System.out.println("Error loading quotes");
            cnfe.printStackTrace();
        }
        return quotes;
    }

}